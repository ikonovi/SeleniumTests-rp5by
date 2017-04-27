## Example of Selenium Tests

### Project Configuration
- Selenium 2.53
- TestNG
- Java as a programming language 

### Requirements
* FireFox 45.8 installed in a system where are you going to run automated tests.
* Web-site is available: [http://rp5.by](http://rp5.by)  

### How To Run 
1. Download ZIP file of the project, unzip it. 
2. Import project as Maven project in Eclipse.
3. Make sure that in the class `by.rp5.WebBrowser`, value of system property `webdriver.firefox.bin` points out to exe-file of FireFox. As an alternative you can define system environment variable with the same name and required value on your machine.  
4. Open `pom.xml` to check it for errors. 
5. Do `Alt+F5` to build project
6. Open file `by.rp5.Rp5PageTest` and press `Ctrl+F11` to run TestNG tests.   

Check results of test execution on TestNG view in Eclipse.

