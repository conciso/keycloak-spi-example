# Keycloak SPI example

A simple example project for implementing Keycloak SPIs

[![Build Status](https://travis-ci.org/conciso/keycloak-spi-example.svg?branch=master)](https://travis-ci.org/conciso/keycloak-spi-example)

## Build

For a build you need to have set up Maven, Java, and Docker.

You can build this project with Maven running:
```bash
mvn clean install
```

## Running the demo

After you have build the Docker image, you may run the demo with Docker Compose from the root directory of the repository:

```bash
docker-compose up
```

This starts Keycloak and makes it available at [http://localhost:8080](http://localhost:8080).
Use user `admin` and password `admin` for login.

It also starts an additional container named `mail`. You may use it to check emails send by Keycloak. The web interface will be available at [http://localhost:9080](http://localhost:9080).

NOTE: Make sure you have configured email settings in Keycloak correctly. Use `mail` as hostname and keep the port to `25` (default).

## Step by step

* Step 1: [Register and enable provider](https://github.com/conciso/keycloak-spi-example/compare/demo-step-1...demo-step-2)
* Step 2: [Add some logging to check if it works](https://github.com/conciso/keycloak-spi-example/compare/demo-step-2...demo-step-3)
* Step 3: [Reuse default provider / Provider lookup](https://github.com/conciso/keycloak-spi-example/compare/demo-step-3...demo-step-4)
* Step 4: [Configure provider](https://github.com/conciso/keycloak-spi-example/compare/demo-step-4...demo-step-5)
