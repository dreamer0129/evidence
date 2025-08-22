# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a blockchain-based evidence management system built with Spring Boot (Java 21) and Hardhat (Solidity). The system provides:
- User authentication with JWT
- Evidence storage with blockchain verification
- PDF proof generation
- Smart contract integration

## Architecture

**Backend (Spring Boot):**
- Main application: `EvidenceApplication.java`
- Controllers: User authentication endpoints
- Services: Business logic and blockchain integration
- Domain: Data models (User, HashEvidence)
- Repository: SQLite database access
- Utils: JWT, Contract utilities

**Fronted (Next.js):**
- Located in `contract/evidence/packages/nextjs/`

**Smart Contracts (Hardhat):**
- Located in `contract/evidence/packages/hardhat/contracts/`
- Web3j plugin generates Java wrappers
- Deployed contracts stored in `generated/` package

## Development Commands

### Backend (Spring Boot)
```bash
# Run application
./mvnw spring-boot:run

# Build and run tests
./mvnw test

# Build native executable
./mvnw native:compile -Pnative

# Build Docker image
./mvnw spring-boot:build-image -Pnative

# Run specific test class
./mvnw test -Dtest=UserServiceTest
```

### Smart Contracts (Hardhat)
```bash
cd contract/evidence

# Compile contracts
yarn hardhat:compile

# Run tests
yarn hardhat:test

# Deploy contracts
yarn hardhat:deploy

# Generate Java wrappers
./mvnw compile  # Runs web3j-maven-plugin
```

## Database
- SQLite database: `evidence.db`
- JPA with Hibernate for ORM
- Automatic schema updates enabled

## Configuration
- Main config: `src/main/resources/application.properties`
- JWT secret: Configure `jwt.secret` property
- SQLite connection: JDBC URL points to `evidence.db`

## Key Files
- `EvidenceApplication.java`: Main Spring Boot application
- `UserController.java`: Authentication endpoints
- `UserService.java`: User management logic
- `ContractUtils.java`: Blockchain interaction utilities
- `JwtUtils.java`: JWT token handling
- Smart contracts in `contract/evidence/packages/hardhat/contracts/`

## Testing
- Unit tests in `src/test/java/`
- Test database: Uses separate SQLite instance
- Contract tests: Hardhat test framework

## Build System
- Maven for Java backend
- Yarn workspaces for smart contracts
- Web3j plugin for Solidity to Java code generation