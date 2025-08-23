import { expect } from "chai";
import { ethers } from "hardhat";
import type { EvidenceStorage } from "../typechain-types";

describe("EvidenceStorage", function () {
  let evidenceStorage: EvidenceStorage;
  let user1: any, user2: any;

  before(async () => {
    [, user1, user2] = await ethers.getSigners();
    const evidenceStorageFactory = await ethers.getContractFactory("EvidenceStorage");
    evidenceStorage = (await evidenceStorageFactory.deploy()) as EvidenceStorage;
    await evidenceStorage.waitForDeployment();
  });

  describe("Deployment", function () {
    it("Should deploy successfully", async function () {
      void expect(await evidenceStorage.getAddress()).to.be.properAddress;
    });

    it("Should have zero evidence count initially", async function () {
      void expect(await evidenceStorage.getEvidenceCount()).to.equal(0);
    });
  });

  describe("Store Evidence", function () {
    const testFileHash = "0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";
    const fileName = "test-document.pdf";
    const fileType = "application/pdf";
    const fileSize = 1024;
    const memo = "Important contract document";

    it("Should store evidence successfully", async function () {
      const tx = await evidenceStorage.connect(user1).storeEvidence(testFileHash, fileName, fileType, fileSize, memo);

      await expect(tx).to.emit(evidenceStorage, "EvidenceStored");

      expect(await evidenceStorage.getEvidenceCount()).to.equal(1);
    });

    it("Should reject zero file hash", async function () {
      const zeroHash = "0x0000000000000000000000000000000000000000000000000000000000000000";
      await expect(
        evidenceStorage.connect(user1).storeEvidence(zeroHash, fileName, fileType, fileSize, memo),
      ).to.be.revertedWith("File hash cannot be zero");
    });

    it("Should reject empty file name", async function () {
      await expect(
        evidenceStorage.connect(user1).storeEvidence(testFileHash, "", fileType, fileSize, memo),
      ).to.be.revertedWith("File name cannot be empty");
    });

    it("Should reject zero file size", async function () {
      await expect(
        evidenceStorage.connect(user1).storeEvidence(testFileHash, fileName, fileType, 0, memo),
      ).to.be.revertedWith("File size must be greater than zero");
    });

    it("Should reject duplicate file hash", async function () {
      await expect(
        evidenceStorage.connect(user1).storeEvidence(testFileHash, fileName, fileType, fileSize, memo),
      ).to.be.revertedWith("Evidence with this hash already exists");
    });
  });

  describe("Verify Evidence", function () {
    const testFileHash = "0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";
    const nonExistentHash = "0xabcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890";

    it("Should verify existing evidence successfully", async function () {
      const tx = await evidenceStorage.connect(user2).verifyEvidence(testFileHash);

      await expect(tx).to.emit(evidenceStorage, "EvidenceVerified");

      const [isValid, evidenceId, owner, timestamp] = await evidenceStorage
        .connect(user2)
        .verifyEvidence.staticCall(testFileHash);

      void expect(isValid).to.be.true;
      expect(evidenceId).to.not.equal(ethers.ZeroHash);
      expect(owner).to.equal(user1.address);
      expect(timestamp).to.be.gt(0);
    });

    it("Should return false for non-existent evidence", async function () {
      const tx = await evidenceStorage.connect(user2).verifyEvidence(nonExistentHash);

      await expect(tx).to.emit(evidenceStorage, "EvidenceVerified");

      const result = await evidenceStorage.connect(user2).verifyEvidence.staticCall(nonExistentHash);

      void expect(result[0]).to.be.false;
      expect(result[1]).to.equal(ethers.ZeroHash);
      expect(result[2]).to.equal(ethers.ZeroAddress);
      expect(result[3]).to.equal(0);
    });
  });

  describe("Get Evidence Details", function () {
    const testFileHash = "0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";

    it("Should get evidence details successfully", async function () {
      const evidence = await evidenceStorage.getEvidence(testFileHash);

      expect(evidence.id).to.not.equal(ethers.ZeroHash);
      expect(evidence.owner).to.equal(user1.address);
      expect(evidence.fileName).to.equal("test-document.pdf");
      expect(evidence.fileType).to.equal("application/pdf");
      expect(evidence.fileSize).to.equal(1024);
      expect(evidence.fileHash).to.equal(testFileHash);
      expect(evidence.timestamp).to.be.gt(0);
      expect(evidence.memo).to.equal("Important contract document");
    });

    it("Should reject getting non-existent evidence", async function () {
      const nonExistentHash = "0xabcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890";
      await expect(evidenceStorage.getEvidence(nonExistentHash)).to.be.revertedWith("Evidence not found");
    });
  });

  describe("User Evidence Management", function () {
    const secondFileHash = "0xabcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890";

    it("Should store multiple evidences for same user", async function () {
      // Store second evidence for user1
      await evidenceStorage
        .connect(user1)
        .storeEvidence(secondFileHash, "second-file.txt", "text/plain", 512, "Second file");

      expect(await evidenceStorage.getEvidenceCount()).to.equal(2);
    });

    it("Should get user evidences correctly", async function () {
      const userEvidences = await evidenceStorage.getUserEvidences(user1.address);

      expect(userEvidences.length).to.equal(2);
      expect(userEvidences[0]).to.equal("0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef");
      expect(userEvidences[1]).to.equal(secondFileHash);
    });

    it("Should return empty array for user with no evidences", async function () {
      const user2Evidences = await evidenceStorage.getUserEvidences(user2.address);
      expect(user2Evidences.length).to.equal(0);
    });
  });

  describe("Evidence Index Access", function () {
    it("Should get evidence by index", async function () {
      const evidence = await evidenceStorage.getEvidenceByIndex(0);
      expect(evidence.fileHash).to.equal("0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef");
    });

    it("Should reject out of bounds index", async function () {
      await expect(evidenceStorage.getEvidenceByIndex(10)).to.be.revertedWith("Index out of bounds");
    });

    it("Should get all evidence IDs", async function () {
      const allIds = await evidenceStorage.getAllEvidenceIds();
      expect(allIds.length).to.equal(2);
    });
  });
});
