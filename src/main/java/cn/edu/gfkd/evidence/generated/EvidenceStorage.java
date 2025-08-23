package cn.edu.gfkd.evidence.generated;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
import org.web3j.tuples.generated.Tuple8;
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
public class EvidenceStorage extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b506114af8061001c5f395ff3fe608060405234801561000f575f5ffd5b50600436106100a6575f3560e01c80639136d41e1161006e5780639136d41e1461012f5780639598210014610173578063a2ed5af014610186578063b8d444871461018f578063caf5544414610197578063d84c09de146101aa575f5ffd5b8063166acb01146100aa57806322de1c65146100c85780632fecc27a146100e95780634a7221a0146100fc578063878b534a1461011c575b5f5ffd5b6100b26101d1565b6040516100bf9190610f9a565b60405180910390f35b6100db6100d6366004610ff7565b610227565b6040519081526020016100bf565b6100db6100f73660046110be565b610252565b61010f61010a36600461115f565b61058e565b6040516100bf91906111a4565b6100b261012a366004611249565b6107f2565b61014261013d36600461115f565b61085b565b6040516100bf9493929190931515845260208401929092526001600160a01b03166040830152606082015260800190565b6100db61018136600461115f565b610ad8565b6100db60035481565b6003546100db565b61010f6101a536600461115f565b610af7565b6101bd6101b836600461115f565b610d75565b6040516100bf989796959493929190611269565b6060600280548060200260200160405190810160405280929190818152602001828054801561021d57602002820191905f5260205f20905b815481526020019060010190808311610209575b5050505050905090565b6001602052815f5260405f208181548110610240575f80fd5b905f5260205f20015f91509150505481565b5f856102a55760405162461bcd60e51b815260206004820152601860248201527f46696c6520686173682063616e6e6f74206265207a65726f000000000000000060448201526064015b60405180910390fd5b5f8551116102f55760405162461bcd60e51b815260206004820152601960248201527f46696c65206e616d652063616e6e6f7420626520656d70747900000000000000604482015260640161029c565b5f83116103505760405162461bcd60e51b815260206004820152602360248201527f46696c652073697a65206d7573742062652067726561746572207468616e207a60448201526265726f60e81b606482015260840161029c565b5f86815260208190526040902054156103ba5760405162461bcd60e51b815260206004820152602660248201527f45766964656e636520776974682074686973206861736820616c72656164792060448201526565786973747360d01b606482015260840161029c565b5f8642336040516020016103f393929190928352602083019190915260601b6bffffffffffffffffffffffff1916604082015260540190565b60408051808303601f19018152828252805160209182012061010084018352808452338285019081528484018b8152606086018b9052608086018a905260a086018d90524260c087015260e086018990525f8d815293849052939092208451815591516001830180546001600160a01b0319166001600160a01b0390921691909117905591519193508291600282019061048d908261135e565b50606082015160038201906104a2908261135e565b506080820151600482015560a0820151600582015560c0820151600682015560e082015160078201906104d5908261135e565b5050335f908152600160208181526040832080548084018255908452908320018b905560028054918201815582527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace018a90556003805492509061053883611419565b9190505550336001600160a01b0316827f68b3001c55fef94e12a434bca5ef7c9f81b2f55a57ec86d1ea763358d7c53e308a8a4260405161057b9392919061143d565b60405180910390a3509695505050505050565b610596610f51565b5f828152602081905260409020546105e55760405162461bcd60e51b8152602060048201526012602482015271115d9a59195b98d9481b9bdd08199bdd5b9960721b604482015260640161029c565b5f82815260208181526040918290208251610100810184528154815260018201546001600160a01b031692810192909252600281018054929391929184019161062d906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610659906112da565b80156106a45780601f1061067b576101008083540402835291602001916106a4565b820191905f5260205f20905b81548152906001019060200180831161068757829003601f168201915b505050505081526020016003820180546106bd906112da565b80601f01602080910402602001604051908101604052809291908181526020018280546106e9906112da565b80156107345780601f1061070b57610100808354040283529160200191610734565b820191905f5260205f20905b81548152906001019060200180831161071757829003601f168201915b5050505050815260200160048201548152602001600582015481526020016006820154815260200160078201805461076b906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610797906112da565b80156107e25780601f106107b9576101008083540402835291602001916107e2565b820191905f5260205f20905b8154815290600101906020018083116107c557829003601f168201915b5050505050815250509050919050565b6001600160a01b0381165f9081526001602090815260409182902080548351818402810184019094528084526060939283018282801561084f57602002820191905f5260205f20905b81548152602001906001019080831161083b575b50505050509050919050565b5f818152602081815260408083208151610100810183528154815260018201546001600160a01b03169381019390935260028101805485948594859485949293909291840191906108ab906112da565b80601f01602080910402602001604051908101604052809291908181526020018280546108d7906112da565b80156109225780601f106108f957610100808354040283529160200191610922565b820191905f5260205f20905b81548152906001019060200180831161090557829003601f168201915b5050505050815260200160038201805461093b906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610967906112da565b80156109b25780601f10610989576101008083540402835291602001916109b2565b820191905f5260205f20905b81548152906001019060200180831161099557829003601f168201915b505050505081526020016004820154815260200160058201548152602001600682015481526020016007820180546109e9906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610a15906112da565b8015610a605780601f10610a3757610100808354040283529160200191610a60565b820191905f5260205f20905b815481529060010190602001808311610a4357829003601f168201915b50505091909252505081511580159750919250610a8d9050578051602082015160c0830151919550935091505b6040805133815286151560208201524281830152905185917f44db094f43efa113aa67a0a0c54d0573ccf926a00248e4449bffb7ce8d01fcfe919081900360600190a2509193509193565b60028181548110610ae7575f80fd5b5f91825260209091200154905081565b610aff610f51565b6002548210610b465760405162461bcd60e51b8152602060048201526013602482015272496e646578206f7574206f6620626f756e647360681b604482015260640161029c565b5f60028381548110610b5a57610b5a611465565b5f9182526020808320909101548083528282526040928390208351610100810185528154815260018201546001600160a01b0316938101939093526002810180549295509293909290840191610baf906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610bdb906112da565b8015610c265780601f10610bfd57610100808354040283529160200191610c26565b820191905f5260205f20905b815481529060010190602001808311610c0957829003601f168201915b50505050508152602001600382018054610c3f906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610c6b906112da565b8015610cb65780601f10610c8d57610100808354040283529160200191610cb6565b820191905f5260205f20905b815481529060010190602001808311610c9957829003601f168201915b50505050508152602001600482015481526020016005820154815260200160068201548152602001600782018054610ced906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610d19906112da565b8015610d645780601f10610d3b57610100808354040283529160200191610d64565b820191905f5260205f20905b815481529060010190602001808311610d4757829003601f168201915b505050505081525050915050919050565b5f6020819052908152604090208054600182015460028301805492936001600160a01b0390921692610da6906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610dd2906112da565b8015610e1d5780601f10610df457610100808354040283529160200191610e1d565b820191905f5260205f20905b815481529060010190602001808311610e0057829003601f168201915b505050505090806003018054610e32906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610e5e906112da565b8015610ea95780601f10610e8057610100808354040283529160200191610ea9565b820191905f5260205f20905b815481529060010190602001808311610e8c57829003601f168201915b505050505090806004015490806005015490806006015490806007018054610ed0906112da565b80601f0160208091040260200160405190810160405280929190818152602001828054610efc906112da565b8015610f475780601f10610f1e57610100808354040283529160200191610f47565b820191905f5260205f20905b815481529060010190602001808311610f2a57829003601f168201915b5050505050905088565b6040518061010001604052805f81526020015f6001600160a01b0316815260200160608152602001606081526020015f81526020015f81526020015f8152602001606081525090565b602080825282518282018190525f918401906040840190835b81811015610fd1578351835260209384019390920191600101610fb3565b509095945050505050565b80356001600160a01b0381168114610ff2575f5ffd5b919050565b5f5f60408385031215611008575f5ffd5b61101183610fdc565b946020939093013593505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112611042575f5ffd5b813567ffffffffffffffff81111561105c5761105c61101f565b604051601f8201601f19908116603f0116810167ffffffffffffffff8111828210171561108b5761108b61101f565b6040528181528382016020018510156110a2575f5ffd5b816020850160208301375f918101602001919091529392505050565b5f5f5f5f5f60a086880312156110d2575f5ffd5b85359450602086013567ffffffffffffffff8111156110ef575f5ffd5b6110fb88828901611033565b945050604086013567ffffffffffffffff811115611117575f5ffd5b61112388828901611033565b93505060608601359150608086013567ffffffffffffffff811115611146575f5ffd5b61115288828901611033565b9150509295509295909350565b5f6020828403121561116f575f5ffd5b5035919050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b60208152815160208201525f60208301516111ca60408401826001600160a01b03169052565b50604083015161010060608401526111e6610120840182611176565b90506060840151601f198483030160808501526112038282611176565b915050608084015160a084015260a084015160c084015260c084015160e084015260e0840151601f19848303016101008501526112408282611176565b95945050505050565b5f60208284031215611259575f5ffd5b61126282610fdc565b9392505050565b8881526001600160a01b0388166020820152610100604082018190525f9061129390830189611176565b82810360608401526112a58189611176565b90508660808401528560a08401528460c084015282810360e08401526112cb8185611176565b9b9a5050505050505050505050565b600181811c908216806112ee57607f821691505b60208210810361130c57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561135957805f5260205f20601f840160051c810160208510156113375750805b601f840160051c820191505b81811015611356575f8155600101611343565b50505b505050565b815167ffffffffffffffff8111156113785761137861101f565b61138c8161138684546112da565b84611312565b6020601f8211600181146113be575f83156113a75750848201515b5f19600385901b1c1916600184901b178455611356565b5f84815260208120601f198516915b828110156113ed57878501518255602094850194600190920191016113cd565b508482101561140a57868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b5f6001820161143657634e487b7160e01b5f52601160045260245ffd5b5060010190565b838152606060208201525f6114556060830185611176565b9050826040830152949350505050565b634e487b7160e01b5f52603260045260245ffdfea2646970667358221220486f9b1b6cadeed3f5f6eaf973ba6e22a377d94bb5390c0895f2410e7548c34e64736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ALLEVIDENCEIDS = "allEvidenceIds";

    public static final String FUNC_EVIDENCECOUNT = "evidenceCount";

    public static final String FUNC_EVIDENCES = "evidences";

    public static final String FUNC_GETALLEVIDENCEIDS = "getAllEvidenceIds";

    public static final String FUNC_GETEVIDENCE = "getEvidence";

    public static final String FUNC_GETEVIDENCEBYINDEX = "getEvidenceByIndex";

    public static final String FUNC_GETEVIDENCECOUNT = "getEvidenceCount";

    public static final String FUNC_GETUSEREVIDENCES = "getUserEvidences";

    public static final String FUNC_STOREEVIDENCE = "storeEvidence";

    public static final String FUNC_USEREVIDENCES = "userEvidences";

    public static final String FUNC_VERIFYEVIDENCE = "verifyEvidence";

    public static final Event EVIDENCESTORED_EVENT = new Event("EvidenceStored", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EVIDENCEVERIFIED_EVENT = new Event("EvidenceVerified", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected EvidenceStorage(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EvidenceStorage(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EvidenceStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EvidenceStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<EvidenceStoredEventResponse> getEvidenceStoredEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EVIDENCESTORED_EVENT, transactionReceipt);
        ArrayList<EvidenceStoredEventResponse> responses = new ArrayList<EvidenceStoredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EvidenceStoredEventResponse typedResponse = new EvidenceStoredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.evidenceId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.fileHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.fileName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EvidenceStoredEventResponse getEvidenceStoredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EVIDENCESTORED_EVENT, log);
        EvidenceStoredEventResponse typedResponse = new EvidenceStoredEventResponse();
        typedResponse.log = log;
        typedResponse.evidenceId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.fileHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.fileName = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<EvidenceStoredEventResponse> evidenceStoredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEvidenceStoredEventFromLog(log));
    }

    public Flowable<EvidenceStoredEventResponse> evidenceStoredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVIDENCESTORED_EVENT));
        return evidenceStoredEventFlowable(filter);
    }

    public static List<EvidenceVerifiedEventResponse> getEvidenceVerifiedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EVIDENCEVERIFIED_EVENT, transactionReceipt);
        ArrayList<EvidenceVerifiedEventResponse> responses = new ArrayList<EvidenceVerifiedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EvidenceVerifiedEventResponse typedResponse = new EvidenceVerifiedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.evidenceId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.verifier = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.isValid = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EvidenceVerifiedEventResponse getEvidenceVerifiedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EVIDENCEVERIFIED_EVENT, log);
        EvidenceVerifiedEventResponse typedResponse = new EvidenceVerifiedEventResponse();
        typedResponse.log = log;
        typedResponse.evidenceId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.verifier = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.isValid = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<EvidenceVerifiedEventResponse> evidenceVerifiedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEvidenceVerifiedEventFromLog(log));
    }

    public Flowable<EvidenceVerifiedEventResponse> evidenceVerifiedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVIDENCEVERIFIED_EVENT));
        return evidenceVerifiedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> allEvidenceIds(BigInteger param0) {
        final Function function = new Function(FUNC_ALLEVIDENCEIDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> evidenceCount() {
        final Function function = new Function(FUNC_EVIDENCECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple8<byte[], String, String, String, BigInteger, byte[], BigInteger, String>> evidences(
            byte[] param0) {
        final Function function = new Function(FUNC_EVIDENCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple8<byte[], String, String, String, BigInteger, byte[], BigInteger, String>>(function,
                new Callable<Tuple8<byte[], String, String, String, BigInteger, byte[], BigInteger, String>>() {
                    @Override
                    public Tuple8<byte[], String, String, String, BigInteger, byte[], BigInteger, String> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<byte[], String, String, String, BigInteger, byte[], BigInteger, String>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (byte[]) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<List> getAllEvidenceIds() {
        final Function function = new Function(FUNC_GETALLEVIDENCEIDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Evidence> getEvidence(byte[] _fileHash) {
        final Function function = new Function(FUNC_GETEVIDENCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_fileHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Evidence>() {}));
        return executeRemoteCallSingleValueReturn(function, Evidence.class);
    }

    public RemoteFunctionCall<Evidence> getEvidenceByIndex(BigInteger _index) {
        final Function function = new Function(FUNC_GETEVIDENCEBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Evidence>() {}));
        return executeRemoteCallSingleValueReturn(function, Evidence.class);
    }

    public RemoteFunctionCall<BigInteger> getEvidenceCount() {
        final Function function = new Function(FUNC_GETEVIDENCECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getUserEvidences(String _user) {
        final Function function = new Function(FUNC_GETUSEREVIDENCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> storeEvidence(byte[] _fileHash, String _fileName,
            String _fileType, BigInteger _fileSize, String _memo) {
        final Function function = new Function(
                FUNC_STOREEVIDENCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_fileHash), 
                new org.web3j.abi.datatypes.Utf8String(_fileName), 
                new org.web3j.abi.datatypes.Utf8String(_fileType), 
                new org.web3j.abi.datatypes.generated.Uint256(_fileSize), 
                new org.web3j.abi.datatypes.Utf8String(_memo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> userEvidences(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_USEREVIDENCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> verifyEvidence(byte[] _fileHash) {
        final Function function = new Function(
                FUNC_VERIFYEVIDENCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_fileHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EvidenceStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new EvidenceStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EvidenceStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EvidenceStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EvidenceStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new EvidenceStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EvidenceStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EvidenceStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EvidenceStorage> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EvidenceStorage.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EvidenceStorage> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EvidenceStorage.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<EvidenceStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EvidenceStorage.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EvidenceStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EvidenceStorage.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class Evidence extends DynamicStruct {
        public byte[] id;

        public String owner;

        public String fileName;

        public String fileType;

        public BigInteger fileSize;

        public byte[] fileHash;

        public BigInteger timestamp;

        public String memo;

        public Evidence(byte[] id, String owner, String fileName, String fileType,
                BigInteger fileSize, byte[] fileHash, BigInteger timestamp, String memo) {
            super(new org.web3j.abi.datatypes.generated.Bytes32(id), 
                    new org.web3j.abi.datatypes.Address(160, owner), 
                    new org.web3j.abi.datatypes.Utf8String(fileName), 
                    new org.web3j.abi.datatypes.Utf8String(fileType), 
                    new org.web3j.abi.datatypes.generated.Uint256(fileSize), 
                    new org.web3j.abi.datatypes.generated.Bytes32(fileHash), 
                    new org.web3j.abi.datatypes.generated.Uint256(timestamp), 
                    new org.web3j.abi.datatypes.Utf8String(memo));
            this.id = id;
            this.owner = owner;
            this.fileName = fileName;
            this.fileType = fileType;
            this.fileSize = fileSize;
            this.fileHash = fileHash;
            this.timestamp = timestamp;
            this.memo = memo;
        }

        public Evidence(Bytes32 id, Address owner, Utf8String fileName, Utf8String fileType,
                Uint256 fileSize, Bytes32 fileHash, Uint256 timestamp, Utf8String memo) {
            super(id, owner, fileName, fileType, fileSize, fileHash, timestamp, memo);
            this.id = id.getValue();
            this.owner = owner.getValue();
            this.fileName = fileName.getValue();
            this.fileType = fileType.getValue();
            this.fileSize = fileSize.getValue();
            this.fileHash = fileHash.getValue();
            this.timestamp = timestamp.getValue();
            this.memo = memo.getValue();
        }
    }

    public static class EvidenceStoredEventResponse extends BaseEventResponse {
        public byte[] evidenceId;

        public String owner;

        public byte[] fileHash;

        public String fileName;

        public BigInteger timestamp;
    }

    public static class EvidenceVerifiedEventResponse extends BaseEventResponse {
        public byte[] evidenceId;

        public String verifier;

        public Boolean isValid;

        public BigInteger timestamp;
    }
}
