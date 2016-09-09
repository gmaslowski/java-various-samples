ista-wnap
=========

Ista Property Manager Portal

## Building project in production mode
```
./gradlew clean build -PproductionBuild
```
## Build project
```bash
./gradlew clean build
```

## Building project with building docker image

```bash
./gradlew clean buildDocker
```

### Skipping Api Integration Tests during build
Sometimes it can be useful to skip ITs
```
./gradlew clean build -PskipCTs
```

## Running tests

```bash
./gradlew clean test
```
Provide ```-t``` parameter for continuous testing.

## Running application from gradle
Example:
```bash
./gradlew bootRun
```

## Refreshing test data
When the application is run in test-data profile, it serves two HTTP endpoints for reafreshing test data:
```
http://wnap-portal/internalTestApi/properties/refreshTestData
http://wnap-portal/internalTestApi/accounts/refreshTestData
http://wnap-portal/internalTestApi/reportRequests/refreshTestData
```

## Running development environment with IDE

* add a following line to ``/etc/hosts``/``c:\windows\system32\drivers\etc\hosts`` file:
  * <IP> wnap-dev wnap-mysql wnap-redis dsl-mysql dsl-core
    * where IP is your IP in Linux
    * or IP is an IP returned by ``docker-machine ip default`` in Windows
* Run DSL ``docker-compose <wncp_dsl_repo>/docker/development/dsl.yml up``
* Run Portal: ``docker-compose <wncp_portal_repo>/docker/development/dev-dbs.yml up`` to run db-s server containers.
* To run/debug from the IDE, create the following run configuration:
  * VM Options = ``-Dspring.profiles.active=dev``
  * Before launch: Run Gradle task 'compileJava compileGroovy'


## Running the whole built portal
1. Run DSL:
```bash
docker-compose --file docker/development/all-mocks.yml up
```
1a Use DSL from ista-ci - add the following parameter to WNAP aplication command line:
```
--dsl.url=http://ista-ci:8081
```

2. Run the portal:
```bash
docker-compose --file docker/development/all-mocks.yml up
```

3. Run both DSL and Portal (requires wnap-infrastructure project checked out)
```
./wnap-infrastructure/docker/dev/dev-all.sh
```

## Running Jenkins CI
```
docker-compose --file docker/continuous-integration/ci.yml up
```

## Windows notice
1. Run gradle from Docker shell (Docker Quickstart Terminal). From ordinary windows shell
there are couple of steps needed to get it working right
[https://docs.docker.com/v1.8/installation/windows/#using-docker-from-windows-command-line-prompt-cmd-exe](https://docs.docker.com/v1.8/installation/windows/#using-docker-from-windows-command-line-prompt-cmd-exe)


2. When connecting to endpoint exposed on port 8080 from the host machine
one must use an IP address of virtual box, not host machine itself.
To get this IP address you should run the following command:
```
docker-machine ip default
```

## Frontend development

### Pre-requirements - blue or red pill
You can develop frontend application in two ways... it's your decision which way you'll choose:
1. setup a complete development environment with node.js and all that stuff
2. use gradle to handle the environment setup and management and do everything via its commands (however you won't have access to all options and operations [still in most cases this will be enough])

**PLEASE CHECK ALSO THE COMMON PARTS PARAGRAPH BELOW**

### OPTION 1 (complete environment)
####Requirements
- node.js v4.4.7 LTS (recommended install by NVM https://github.com/creationix/nvm) and node-gyp
- bower (please install it globally for easiness of use)
- grunt-cli (please install it globally for easiness of use)

**COMMANDS ARE BEING RUNNED IN CLIENT SUBFOLDER OF THE WHOLE PROJECT**

#### Setup development and build environment
In terminal (console) run:
```
npm run bootstrap
```
this will install all required dependencies for development and 3rd party frontend libraries used in final application

#### Grunt usage
##### Command available for development
Grunt is a task runner used in whole process of development and as a build tool.

To get a live preview (opens a browser window with live-reload) at localhost:9000 run:
```
grunt serve
````
to have version with mocks, or run:
```
grunt serve --proxy
```
to use locally built and runned backend server (at localhost:8080) via built-in Grunt proxy


To execute unit tests or e2e test run:
```
grunt unittest
grunt e2e
```

To execute JSHint and JSCS checker:
```
grunt jshint jscs
```

To run all tests (JSHint + JSCS + Unit Tests)
```
grunt tests
```
#### Build

To build the application (with pre-build code analyze and unit tests) use:
```
grunt build
```
* pass --target *<path>* to specify where to copy everything after a successful build (relative to Gruntfile.js location or absolute path is required; defaults to: dist/)
* pass --production to perform a production build which will remove all e2e css classes

### OPTION 2 (gradle)
We assume that you already have gradle!

**COMMANDS ARE BEING RUNNED IN MAIN FOLDER OF THE WHOLE PROJECT**

#### Development using gradle
To get a live preview (opens a browser window with live-reload) at localhost:9000 run:
```
./gradlew :wnap-client:grunt_serve
```
to have version with mocks, or run:
```
./gradlew :wnap-client:gruntServeProxy [-PproxyTarget=host:port]
```
to use localy built and runned backend server (at localhost:8080) via built-in Grunt proxy

#### Build using gradle
```
./gradlew :wnap-client:build
```
It will build the app to project.rootDir.absolutePath + "/wnap-portal/src/main/resources/public"

Or use:
```
./gradlew :wnap-client:productionBuild
```
To perform a production build which will remove all e2e css classes

### Commons
#### API Mocks
**Mocks are available during live-preview mode only.**
Mocked responses should be under:
 ``wnap-client/mocks``.

#### For static mocks (static content)
For example a mock for a request to ``GET /api/user`` should be placed under ``wnap-client/mocks/api/user/GET.json`` where the file should be named after HTTP_METHOD.json.

#### For dynamic mocks
There's a number of ways to create a dynamic mocks and this will be described later... leaving a TODO HERE

### For more informations
Please checkout wnap-client/README.md

### Common Errors
Watch ENOSPC Error while using grunt, use command: ``echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p``
