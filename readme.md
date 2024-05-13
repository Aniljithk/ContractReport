# Sample Contract Report Generator App

Java Application to Generate  Specific reports for Contracts.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Input

Input data is specified in the root folder under "input/input.txt" file.

Sample Input: 
```text
2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
```

## Running the application In IntelliJ

Open the Class "ContractReportingApp" and run using Intellij

## Running the application From CommandLine
Open the Source Directory.

build the java project using the below command (This command will place all the classFiles inside classFiles folder.)
```shell
javac -d classFiles src/com/contractreport/ContractReportingApp.java src/com/contractreport/factory/*.java src/com/contractreport/engine/*.java src/com/contractreport/input/*.java src/com/contractreport/interfaces/*.java src/com/contractreport/model/*.java src/com/contractreport/report/*.java src/com/contractreport/interfaces/report/*.java src/com/contractreport/service/report/*.java src/com/contractreport/service/*.java

cd classFiles
```

create a folder inside classFiles input and paste the input.txt file which contains the input data.

Run the Application using the below command.

```shell
java com.contractreport.ContractReportingApp
```


