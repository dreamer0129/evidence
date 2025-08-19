package cn.edu.gfkd.evidence;

import cn.edu.gfkd.evidence.generated.Counter;
import cn.edu.gfkd.evidence.utils.ContractUtils;
import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

public class CounterTest {

    private static final String nodeUrl = System.getenv().getOrDefault("WEB3J_NODE_URL",
            "http://127.0.0.1:8545");
    private static final String walletPassword = System.getenv().getOrDefault("WEB3J_WALLET_PASSWORD", "123456");
    private static final String walletPath = System.getenv().getOrDefault("WEB3J_WALLET_PATH",
            "src/test/resources/wallet/testnet/keystore/hardhat-wallet0.json");
    // 提高gasPrice以解决过低问题
    private static final StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(600000000L),
            BigInteger.valueOf(9000000L));

    public static void main(String[] args) throws Exception {
        String address = ContractUtils.getDeployedContractAddress("Counter", "localhost");
        System.out.println(address);

        Web3j web3j = null;
        try {
            Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletPath);
            web3j = Web3j.build(new HttpService(nodeUrl));
            Counter counter = Counter.load(address, web3j, credentials, gasProvider);
            BigInteger count = counter.x().send();
            System.out.println("count=" + count);

            TransactionReceipt receipt = counter.increment().send();
            System.out.println("transactionReceipt:" + receipt);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 确保web3j被关闭
            if (web3j != null) {
                web3j.close();
            }
        }
    }

}
