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
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class YourContract extends Contract {
    public static final String BINARY = "60e0604052601c60a09081527f4275696c64696e6720556e73746f707061626c6520417070732121210000000060c0525f9061003b908261011d565b506001805460ff191690555f600255348015610055575f5ffd5b50604051610904380380610904833981016040819052610074916101d7565b6001600160a01b0316608052610204565b634e487b7160e01b5f52604160045260245ffd5b600181811c908216806100ad57607f821691505b6020821081036100cb57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561011857805f5260205f20601f840160051c810160208510156100f65750805b601f840160051c820191505b81811015610115575f8155600101610102565b50505b505050565b81516001600160401b0381111561013657610136610085565b61014a816101448454610099565b846100d1565b6020601f82116001811461017c575f83156101655750848201515b5f19600385901b1c1916600184901b178455610115565b5f84815260208120601f198516915b828110156101ab578785015182556020948501946001909201910161018b565b50848210156101c857868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b5f602082840312156101e7575f5ffd5b81516001600160a01b03811681146101fd575f5ffd5b9392505050565b6080516106db6102295f395f818160a30152818161019801526101fd01526106db5ff3fe608060405260043610610071575f3560e01c8063a41368621161004c578063a413686214610105578063cea49c3c14610118578063e0a73a9314610143578063ef690cc01461016c575f5ffd5b80633ccfd60b1461007c5780638da5cb5b1461009257806397feba9d146100e2575f5ffd5b3661007857005b5f5ffd5b348015610087575f5ffd5b5061009061018d565b005b34801561009d575f5ffd5b506100c57f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b0390911681526020015b60405180910390f35b3480156100ed575f5ffd5b506100f760025481565b6040519081526020016100d9565b6100906101133660046103fd565b6102b3565b348015610123575f5ffd5b506100f76101323660046104b0565b60036020525f908152604090205481565b34801561014e575f5ffd5b5060015461015c9060ff1681565b60405190151581526020016100d9565b348015610177575f5ffd5b5061018061035e565b6040516100d9919061050b565b336001600160a01b037f000000000000000000000000000000000000000000000000000000000000000016146101fa5760405162461bcd60e51b815260206004820152600d60248201526c2737ba103a34329027bbb732b960991b60448201526064015b60405180910390fd5b5f7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316476040515f6040518083038185875af1925050503d805f8114610263576040519150601f19603f3d011682016040523d82523d5f602084013e610268565b606091505b50509050806102b05760405162461bcd60e51b81526020600482015260146024820152732330b4b632b2103a379039b2b7321022ba3432b960611b60448201526064016101f1565b50565b5f6102be82826105a1565b50600160025f8282546102d1919061065c565b9091555050335f9081526003602052604081208054600192906102f590849061065c565b90915550503415610311576001805460ff19168117905561031c565b6001805460ff191690555b60405133907f94cbd7e04dca26a7667654f6448b2ca0a40fec602118dc5fd8c82b9cf3c645ad906103539084903480151591610681565b60405180910390a250565b5f805461036a9061051d565b80601f01602080910402602001604051908101604052809291908181526020018280546103969061051d565b80156103e15780601f106103b8576101008083540402835291602001916103e1565b820191905f5260205f20905b8154815290600101906020018083116103c457829003601f168201915b505050505081565b634e487b7160e01b5f52604160045260245ffd5b5f6020828403121561040d575f5ffd5b813567ffffffffffffffff811115610423575f5ffd5b8201601f81018413610433575f5ffd5b803567ffffffffffffffff81111561044d5761044d6103e9565b604051601f8201601f19908116603f0116810167ffffffffffffffff8111828210171561047c5761047c6103e9565b604052818152828201602001861015610493575f5ffd5b816020840160208301375f91810160200191909152949350505050565b5f602082840312156104c0575f5ffd5b81356001600160a01b03811681146104d6575f5ffd5b9392505050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b602081525f6104d660208301846104dd565b600181811c9082168061053157607f821691505b60208210810361054f57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561059c57805f5260205f20601f840160051c8101602085101561057a5750805b601f840160051c820191505b81811015610599575f8155600101610586565b50505b505050565b815167ffffffffffffffff8111156105bb576105bb6103e9565b6105cf816105c9845461051d565b84610555565b6020601f821160018114610601575f83156105ea5750848201515b5f19600385901b1c1916600184901b178455610599565b5f84815260208120601f198516915b828110156106305787850151825560209485019460019092019101610610565b508482101561064d57868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b8082018082111561067b57634e487b7160e01b5f52601160045260245ffd5b92915050565b606081525f61069360608301866104dd565b9315156020830152506040015291905056fea2646970667358221220c23f8dbe4203655a761ec32c668037a30a047e111a1787d138b074481f850db164736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GREETING = "greeting";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PREMIUM = "premium";

    public static final String FUNC_SETGREETING = "setGreeting";

    public static final String FUNC_TOTALCOUNTER = "totalCounter";

    public static final String FUNC_USERGREETINGCOUNTER = "userGreetingCounter";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event GREETINGCHANGE_EVENT = new Event("GreetingChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected YourContract(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected YourContract(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected YourContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected YourContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<GreetingChangeEventResponse> getGreetingChangeEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(GREETINGCHANGE_EVENT, transactionReceipt);
        ArrayList<GreetingChangeEventResponse> responses = new ArrayList<GreetingChangeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GreetingChangeEventResponse typedResponse = new GreetingChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.greetingSetter = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newGreeting = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.premium = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static GreetingChangeEventResponse getGreetingChangeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(GREETINGCHANGE_EVENT, log);
        GreetingChangeEventResponse typedResponse = new GreetingChangeEventResponse();
        typedResponse.log = log;
        typedResponse.greetingSetter = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newGreeting = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.premium = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<GreetingChangeEventResponse> greetingChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getGreetingChangeEventFromLog(log));
    }

    public Flowable<GreetingChangeEventResponse> greetingChangeEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GREETINGCHANGE_EVENT));
        return greetingChangeEventFlowable(filter);
    }

    public RemoteFunctionCall<String> greeting() {
        final Function function = new Function(FUNC_GREETING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> premium() {
        final Function function = new Function(FUNC_PREMIUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setGreeting(String _newGreeting,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SETGREETING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_newGreeting)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> totalCounter() {
        final Function function = new Function(FUNC_TOTALCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> userGreetingCounter(String param0) {
        final Function function = new Function(FUNC_USERGREETINGCOUNTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static YourContract load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new YourContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static YourContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new YourContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static YourContract load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new YourContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static YourContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new YourContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<YourContract> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(YourContract.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<YourContract> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(YourContract.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<YourContract> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(YourContract.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<YourContract> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(YourContract.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class GreetingChangeEventResponse extends BaseEventResponse {
        public String greetingSetter;

        public String newGreeting;

        public Boolean premium;

        public BigInteger value;
    }
}
