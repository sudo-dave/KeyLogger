# KeyLogger
Record keyboard inputs in the background. This application listens to keyboard presses and records it into a file. It also crates a timestamp for each key press. The application is created using java and utlizes the jnativehook libary.

### Example of output file
[KeyLog](https://github.com/sudo-dave/KeyLogger/blob/master/demo-log.txt)

## How to Build and Run Project
Build project: 
```bash
mvn package
```
Run ./target/KeyLogger-jar-with-dependencies.jar file using command:
```bash
java -jar ./target/keylogger-jar-with-dependencies.jar
```
