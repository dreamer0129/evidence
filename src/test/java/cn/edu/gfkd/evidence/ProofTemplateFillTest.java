package cn.edu.gfkd.evidence;

import cn.edu.gfkd.evidence.domain.HashEvidence;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class ProofTemplateFillTest {

    @Test
    public void testFillProofTemplate() {
        // 1. 加载PDF模板
        String templatePath = "src/main/resources/static/proof_template.pdf";
        String outputDirPath = "src/test/resources/";
        String outputPath = outputDirPath + "filled_proof.pdf";
        String fontPath = "src/main/resources/static/fonts/SourceHanSans-Regular.ttf";

        // 尝试加载 PDF 文档并修改表单字段
        try (
                // 使用随机访问读取 PDF 文件
                RandomAccessRead readPdf = new RandomAccessReadBuffer(new FileInputStream(templatePath));
                PDDocument document = Loader.loadPDF(readPdf) // 加载 PDF 文档
        ) {
            // 获取 PDF 表单
            PDAcroForm pdfForm = document.getDocumentCatalog().getAcroForm();
            if (pdfForm != null) {
                // 加载并嵌入字体
                try (RandomAccessRead readFont = new RandomAccessReadBuffer(new FileInputStream(fontPath))) {
                    PDFont font = PDType0Font.load(document, readFont, false, false); // 加载ttf
                    // 设置默认字体资源
                    PDResources resources = new PDResources();
                    resources.put(COSName.getPDFName("F1"), font); // 将字体添加到资源中
                    pdfForm.setDefaultResources(resources); // 设置 PDF 表单的默认字体资源

                    HashEvidence hashEvidence = new HashEvidence();
                    hashEvidence.setBlockHeight(12345678);
                    hashEvidence.setTimestamp(1634567890);
                    hashEvidence.setTxHash("0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef");
                    hashEvidence.setOwner("chenhuan");
                    hashEvidence.setFileName("test.pdf");
                    hashEvidence.setFileType("pdf");
                    hashEvidence.setFileSize(1024);
                    hashEvidence.setFileHash("0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef");
                    hashEvidence.setId("1234567890");

                    Map<String, String> fieldContentMap = hashEvidence.toMap();
                    Date current = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    fieldContentMap.put("date", "  " + sdf.format(current));

                    SimpleDateFormat sdfChinese = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
                    String content = "\t" + sdfChinese.format(current) +
                            "本处在证据链节点，接收到新增数据存证事件的同步信息，该存证事件包含的以下信息，均由智能数据科学系提供，存证信息经本处系统验证，与区块上的一致，特此证明。";
                    fieldContentMap.put("content", content);

                    // 遍历所有表单字段并设置新内容
                    for (PDField field : pdfForm.getFields()) {
                        // 检查字段是否在定义的内容映射中
                        if (fieldContentMap.containsKey(field.getFullyQualifiedName())) {
                            if (field instanceof PDTextField) { // 确保字段是文本字段
                                PDTextField textField = (PDTextField) field;
                                // 设置文本字段的外观和内容
                                textField.setDefaultAppearance("/F1 12 Tf 0 g"); // 设置字体和字号
                                textField.setValue(fieldContentMap.get(field.getFullyQualifiedName())); // 设置字段值
                                textField.setReadOnly(true); // 将字段设置为只读
                            }
                        }
                    }
                } catch (IOException e) {
                    System.err.println("加载字体时出错: " + e.getMessage()); // 输出字体加载错误信息
                }
            } else {
                System.out.println("PDF 表单未找到！"); // 如果没有找到表单
            }
            // 保存修改后的 PDF
            document.save(outputPath, CompressParameters.NO_COMPRESSION); // 不压缩保存 PDF
            System.out.println("PDF 保存成功！"); // 输出保存成功信息
        } catch (IOException e) {
            System.out.println(e.getMessage()); // 输出 IO 异常信息
        }
    }
}