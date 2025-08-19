package cn.edu.gfkd.evidence.generated;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.14.0.
 */
@SuppressWarnings("rawtypes")
public class Counter extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50604051610206380380610206833981016040819052602b916031565b5f556047565b5f602082840312156040575f5ffd5b5051919050565b6101b2806100545f395ff3fe608060405234801561000f575f5ffd5b506004361061003f575f3560e01c80630c55699c146100435780632baeceb71461005d578063d09de08a14610067575b5f5ffd5b61004b5f5481565b60405190815260200160405180910390f35b61006561006f565b005b6100656100cd565b5f8054908061007d83610123565b91905055507f838e6248a9fe26601aa42682802665dcdfb12259b15af93d00c4072d27912be25f5460016100b19190610138565b5f546040805192835260208301919091520160405180910390a1565b5f805490806100db83610151565b91905055507f838e6248a9fe26601aa42682802665dcdfb12259b15af93d00c4072d27912be260015f546100b19190610169565b634e487b7160e01b5f52601160045260245ffd5b5f816101315761013161010f565b505f190190565b8082018082111561014b5761014b61010f565b92915050565b5f600182016101625761016261010f565b5060010190565b8181038181111561014b5761014b61010f56fea264697066735822122066c9d8ba545224617f84b101feda85ad3f366cecd1927b5c6d4860907d28616664736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DECREMENT = "decrement";

    public static final String FUNC_INCREMENT = "increment";

    public static final String FUNC_X = "x";

    public static final Event XUPDATE_EVENT = new Event("XUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Counter(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Counter(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<XUpdateEventResponse> getXUpdateEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(XUPDATE_EVENT, transactionReceipt);
        ArrayList<XUpdateEventResponse> responses = new ArrayList<XUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            XUpdateEventResponse typedResponse = new XUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oldValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newValue = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static XUpdateEventResponse getXUpdateEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(XUPDATE_EVENT, log);
        XUpdateEventResponse typedResponse = new XUpdateEventResponse();
        typedResponse.log = log;
        typedResponse.oldValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.newValue = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<XUpdateEventResponse> xUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getXUpdateEventFromLog(log));
    }

    public Flowable<XUpdateEventResponse> xUpdateEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(XUPDATE_EVENT));
        return xUpdateEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> decrement() {
        final Function function = new Function(
                FUNC_DECREMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increment() {
        final Function function = new Function(
                FUNC_INCREMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> x() {
        final Function function = new Function(FUNC_X, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Counter load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Counter load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Counter load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Counter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Counter load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Counter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Counter> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger _x) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_x)));
        return deployRemoteCall(Counter.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<Counter> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, BigInteger _x) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_x)));
        return deployRemoteCall(Counter.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Counter> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger _x) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_x)));
        return deployRemoteCall(Counter.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Counter> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger _x) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_x)));
        return deployRemoteCall(Counter.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class XUpdateEventResponse extends BaseEventResponse {
        public BigInteger oldValue;

        public BigInteger newValue;
    }
}
