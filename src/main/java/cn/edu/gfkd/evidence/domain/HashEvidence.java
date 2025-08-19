package cn.edu.gfkd.evidence.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class HashEvidence {
    private String id;
    private String owner;
    private String fileName;
    private String fileType;
    private long fileSize;
    private String fileHash;
    private String txHash;
    private long blockHeight;
    private long timestamp;
    private String memo;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("owner", owner);
        map.put("fileName", fileName);
        map.put("fileType", fileType);
        map.put("fileSize", String.valueOf(fileSize));
        map.put("fileHash", fileHash);
        map.put("txHash", txHash);
        map.put("blockHeight", String.valueOf(blockHeight));
        map.put("timestamp", String.valueOf(timestamp));
        map.put("memo", memo);
        return map;
    }
}
