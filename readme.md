Base Test Automation Page Object Model Project 
==============================================================


IntelliJ Instructions
--------------------

1. Click "Checkout from Version Control"
2. Past following url and select directory to save.
    ```git repository``` : ```https://github.com/selcukayhan/baseTestAutomationPOM.git```
3. Build as a Maven Project

Test Execution Instructions
--------------------

* Before running tests please update Config file and Buyer e-mails. 

    * Please update `DEFAULT_USERNAME` and `DEFAULT_PASSWORD` variables in the Config file.
    * Please update buyer e-mails in the BuyerPool file as specified.


* To execute whole tests in Test Classes :
    1. Open `SmokeTest.java` under `src/test/java/com/selenium`
    2. Right click inside the home class and Click "Run SmokeTest".
   
    * Or Type `mvn clean test -Dtest=SmokeTest`  to terminal. 
    
* To execute a simple test in Test Class :
    1. Open `SmokeTest.java` under `src/test/java/com/selenium`
    2. Right click inside the test method and Click "Run testMethodName()" for example "Run shouldLogin()"
    
    * Or Type ```mvn clean test -Dtest=SmokeTest#shouldLogin``` to terminal. 

* To execute api tests : 
    1. Open ApiTest under `src/test/java/com/api`
    2. Right click inside the test method and Click "Run testMethodName()" for example "Run shouldGiveMeDirectionsFromDisneylandToUniversal()"
