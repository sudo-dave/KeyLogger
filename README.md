# KeyLogger
Record keyboard inputs in the background. This application listens to keyboard presses and records it into a file. It also crates a timestamp for each key press. The app is implemented using **Java** and utlizes the [Jnativehook](https://github.com/kwhat/jnativehook) libary.

### Example of output file
[KeyLog](https://github.com/sudo-dave/KeyLogger/blob/master/demo-log.txt)

## How to Build and Run Project

Clone the repository and change directory.

```
git clone https://github.com/sudo-dave/KeyLogger
cd KeyLogger
```

Build project: 
```bash
mvn package
```
Run ./target/KeyLogger-jar-with-dependencies.jar file using command:
```bash
java -jar ./target/keylogger-jar-with-dependencies.jar
```
## How to stop recording input
The **default** key press to end the program is `ESC` 
