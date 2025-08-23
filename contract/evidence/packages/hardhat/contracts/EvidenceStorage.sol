// SPDX-License-Identifier: MIT
pragma solidity >=0.8.0 <0.9.0;

/**
 * @title EvidenceStorage
 * @dev A smart contract for storing and verifying file evidence on the blockchain
 * @author Evidence Management System
 */
contract EvidenceStorage {
    // Evidence structure
    struct Evidence {
        bytes32 id;
        address owner;
        string fileName;
        string fileType;
        uint256 fileSize;
        bytes32 fileHash;
        uint256 timestamp;
        string memo;
    }

    // State variables
    mapping(bytes32 => Evidence) public evidences;
    mapping(address => bytes32[]) public userEvidences;
    bytes32[] public allEvidenceIds;
    uint256 public evidenceCount;

    // Events
    event EvidenceStored(
        bytes32 indexed evidenceId,
        address indexed owner,
        bytes32 fileHash,
        string fileName,
        uint256 timestamp
    );

    event EvidenceVerified(
        bytes32 indexed evidenceId,
        address verifier,
        bool isValid,
        uint256 timestamp
    );

    /**
     * @dev Store evidence on the blockchain
     * @param _fileHash SHA256 hash of the file content
     * @param _fileName Original filename
     * @param _fileType File type/extension
     * @param _fileSize File size in bytes
     * @param _memo Optional description or memo
     * @return evidenceId The unique identifier of the stored evidence
     */
    function storeEvidence(
        bytes32 _fileHash,
        string memory _fileName,
        string memory _fileType,
        uint256 _fileSize,
        string memory _memo
    ) public returns (bytes32) {
        require(_fileHash != bytes32(0), "File hash cannot be zero");
        require(bytes(_fileName).length > 0, "File name cannot be empty");
        require(_fileSize > 0, "File size must be greater than zero");

        // Check if evidence with this hash already exists
        require(evidences[_fileHash].id == bytes32(0), "Evidence with this hash already exists");

        // Generate unique evidence ID
        bytes32 evidenceId = keccak256(
            abi.encodePacked(_fileHash, block.timestamp, msg.sender)
        );

        // Create new evidence
        Evidence memory newEvidence = Evidence({
            id: evidenceId,
            owner: msg.sender,
            fileName: _fileName,
            fileType: _fileType,
            fileSize: _fileSize,
            fileHash: _fileHash,
            timestamp: block.timestamp,
            memo: _memo
        });

        // Store evidence
        evidences[_fileHash] = newEvidence;
        userEvidences[msg.sender].push(_fileHash);
        allEvidenceIds.push(_fileHash);
        evidenceCount++;

        // Emit event
        emit EvidenceStored(
            evidenceId,
            msg.sender,
            _fileHash,
            _fileName,
            block.timestamp
        );

        return evidenceId;
    }

    /**
     * @dev Verify if evidence exists and return details
     * @param _fileHash SHA256 hash of the file content to verify
     * @return isValid Whether the evidence exists
     * @return evidenceId The evidence identifier if exists
     * @return owner The owner address if exists
     * @return timestamp The storage timestamp if exists
     */
    function verifyEvidence(bytes32 _fileHash)
        public
        returns (
            bool isValid,
            bytes32 evidenceId,
            address owner,
            uint256 timestamp
        )
    {
        Evidence memory evidence = evidences[_fileHash];
        isValid = (evidence.id != bytes32(0));
        
        if (isValid) {
            evidenceId = evidence.id;
            owner = evidence.owner;
            timestamp = evidence.timestamp;
        }

        // Emit verification event
        emit EvidenceVerified(
            evidenceId,
            msg.sender,
            isValid,
            block.timestamp
        );

        return (isValid, evidenceId, owner, timestamp);
    }

    /**
     * @dev Get evidence details by file hash
     * @param _fileHash SHA256 hash of the file content
     * @return Evidence structure with all details
     */
    function getEvidence(bytes32 _fileHash) public view returns (Evidence memory) {
        require(evidences[_fileHash].id != bytes32(0), "Evidence not found");
        return evidences[_fileHash];
    }

    /**
     * @dev Get all evidence IDs for a specific user
     * @param _user Address of the user
     * @return Array of file hashes for the user
     */
    function getUserEvidences(address _user) public view returns (bytes32[] memory) {
        return userEvidences[_user];
    }

    /**
     * @dev Get total number of evidences stored
     * @return count The total evidence count
     */
    function getEvidenceCount() public view returns (uint256) {
        return evidenceCount;
    }

    /**
     * @dev Get evidence by index from all stored evidences
     * @param _index Index of the evidence
     * @return Evidence structure
     */
    function getEvidenceByIndex(uint256 _index) public view returns (Evidence memory) {
        require(_index < allEvidenceIds.length, "Index out of bounds");
        bytes32 fileHash = allEvidenceIds[_index];
        return evidences[fileHash];
    }

    /**
     * @dev Get all stored evidence IDs
     * @return Array of all evidence file hashes
     */
    function getAllEvidenceIds() public view returns (bytes32[] memory) {
        return allEvidenceIds;
    }
}