# Intro

Codesubmit interview test for Bhavesh Ramburn
- Email: nitrogen@gmail.com

# Instruction

## Requirements

- Java SDK 11
- Maven
- Windows 10 (Only tested on this OS)

## Steps

Step 1)

Make sure you have Java SDK installed from [Java](https://www.oracle.com/java/technologies/downloads/)
as well as Maven

Run the following after you have maven and the JDK.

```shell
mvn compile
```

Step 2)

Testing the application.

With Maven installed you can use `mvn test` to run the test


Step 3)

To run the application you can run the following:

Build the jar file 

```shell
mvn clean
mvn package
```


Running the jar file

Args:

- 1 = Required = absolute file path to formatted json
- 2 = Optional = Date

```shell
java -jar target/BackendBirthdayApp.jar "<<absolute path to .json file>>" "<<optional: Date in YYYY/MM/DD>>"
```
_Please make sure JAVA is set on your path_

Examples:

Testing a random day

```shell
java -jar target/BackendBirthdayApp.jar "C:\Users\bramburn\Dev\backend-birthday-assignment-1-fxtpqy\sample.json" "2000/04/02"
```

```shell
java -jar target/BackendBirthdayApp.jar "C:\Users\bramburn\Dev\backend-birthday-assignment-1-fxtpqy\sample.json" "2000/04/02"
```

# Assumptions

Here is a list of assumptions I've had during building the application:

- 



