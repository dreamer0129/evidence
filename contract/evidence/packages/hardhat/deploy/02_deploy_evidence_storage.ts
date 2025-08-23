import { HardhatRuntimeEnvironment } from "hardhat/types";
import { DeployFunction } from "hardhat-deploy/types";
import { Contract } from "ethers";

/**
 * Deploys the EvidenceStorage contract
 *
 * @param hre HardhatRuntimeEnvironment object.
 */
const deployEvidenceStorage: DeployFunction = async function (hre: HardhatRuntimeEnvironment) {
  const { deployer } = await hre.getNamedAccounts();
  const { deploy } = hre.deployments;

  await deploy("EvidenceStorage", {
    from: deployer,
    // No constructor arguments needed for EvidenceStorage
    args: [],
    log: true,
    autoMine: true,
  });

  // Get the deployed contract to interact with it after deploying.
  const evidenceStorage = await hre.ethers.getContract<Contract>("EvidenceStorage", deployer);
  console.log("✅ EvidenceStorage deployed at:", await evidenceStorage.getAddress());
  console.log("📊 Initial evidence count:", await evidenceStorage.getEvidenceCount());
};

export default deployEvidenceStorage;

// Tags are useful if you have multiple deploy files and only want to run one of them.
// e.g. yarn deploy --tags EvidenceStorage
deployEvidenceStorage.tags = ["EvidenceStorage"];
