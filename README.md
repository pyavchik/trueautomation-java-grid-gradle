# Selenium-Grid using, the project example

**Description:** You are viewing the README for using the Selenium-Grid with TrueAutomation.
This is the detailed instruction how to run tests against multiple browsers in parallel, using Selenium-Grid within the TrueAutomation project example.

To use the project, you must have your own [registered TrueAutomation account](https://app.trueautomation.io/auth/signup) and the installed TrueAutomation client.
If you have not installed the client yet, please checkout the installation process - https://trueautomation.io/docs/#/install-client

## Setup

At first, clone the project and initialize it from the project's root folder:

```bash
git clone https://github.com/pyavchik/trueautomation-java-grid-gradle.git
```
Go to the project's root folder and run command: ```trueautomation init```, follow the instructions.

## Start the hub

Open a separate command line and navigate to the directory where is the selenium-server-standalone file (this is the project's root folder).
To run the hub, type the following command:

```bash
java -jar selenium-server-standalone-3.13.0.jar -role hub
```

## Start the nodes

The hub and nodes are shown here running on the same machine, but of course you can use the selenium-server-standalone at multiple machines.

Again open a separate command line and navigate to the directory with the selenium-server-standalone file (the project's root folder).
To run the node, use the following command:

for UNIX operating system:

```bash
java -Dwebdriver.chrome.driver=./drivers/chromedriver -Dwebdriver.gecko.driver=./drivers/geckodriver -jar selenium-server-standalone-3.13.0.jar -role node -nodeConfig nodeconfig.json
```

for Windows operating system:

```bash
java -Dwebdriver.chrome.driver=.\\drivers\\chromedriver_win.exe -Dwebdriver.gecko.driver=.\\drivers\\geckodriver_win.exe -Dwebdriver.ie.driver=.\\drivers\\IEDriverServer.exe -Dwebdriver.edge.driver=.\\drivers\\MicrosoftWebDriver.exe -jar selenium-server-standalone-3.13.0.jar -role node -nodeConfig nodeconfig.json
```

The node is configured by the JSON file: ```nodeconfig.json```. You can view the status of hub and node by opening a browser window and navigating to: http://localhost:4444/grid/console

## Running tests

Tests run in parallel in different browsers depending on the platform.

### If you use Mac OS

For Mac OS, tests can be run in the ```Google Chrome```, ```Mozilla Firefox``` and ```Safari```. You can use any of these browsers and
run the default test in parallel using the commands:

for Google Chrome:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=CHROME
```

for Mozilla Firefox:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=FF
```

for Safari (do not forget to enable Remote Automation in the Safari Develop menu):

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=SAFARI
```

Or you can run the test simultaneously in all these browsers, but for this you should have installed all of them.
To run the test this way, use the following command:

```bash
gradle clean test -DsuiteFile=testngMAC.xml
```

### If you use some Linux distribution:

For Linux, tests can be run in the ```Google Chrome``` and ```Mozilla Firefox```. You can use any of these browsers and
run the default test in parallel using the commands:

for Google Chrome:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=CHROME
```

for Mozilla Firefox:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=FF
```

Or you can run the test simultaneously in all these browsers, but for this you should have installed all of them.
To run the test this way, use the following command:

```bash
gradle clean test -DsuiteFile=testngLINUX.xml
```

### If you use Windows 10 OS:

For Windows, tests can be run in the ```Google Chrome```, ```Mozilla Firefox```, ```Microsoft Edge``` and ```Internet Explorer 11```.
You can use any of these browsers and run the default test in parallel using the commands:

for Google Chrome:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=CHROME
```

for Mozilla Firefox:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=FF
```

for Microsoft Edge:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=EDGE
```

for Internet Explorer 11:

```bash
gradle clean test -DsuiteFile=testng.xml -Dbrowser=IE
```

Or you can run the test simultaneously in all these browsers, but for this you should have installed all of them.
To run the test this way, use the following command:

```bash
gradle clean test -DsuiteFile=testngWIN.xml
```