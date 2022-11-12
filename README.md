## BalanceAggregator
Is an app that is developed to calculate the monthly and cumulative balance for a customer in a banking system using Spring Boot.


## Requirements
For building and running the application you will need:
- <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" target="_blank">JDK 17</a>
- <a href="https://maven.apache.org/download.cgi" target="_blank">Maven 3.8.6</a>


## Running The Application 
1. Build the project using:
```shell
mvn clean install
```
2. Run using:
```shell
mvn spring-boot:run
```
3. You can view __monthlyBalance__ by sending a GET request to:
```shell
http://localhost:7070/customer/{customerId}/monthlyBalance
```
4. You can view __cumulativeBalance__ by sending a GET request to:
```shell
http://localhost:7070/customer/{customerId}/cumulativeBalance
```

## Notes
- cutomerId: customer1, customer2, customer3... 
- Dummy Data Service was created to represent Transactions Data (amount and date). To view it click [here](src/main/java/com/bank/balanceAggregator/service/DummyTransactionClientImpl.java)
- The application was tested using unit testing for the BalanceService
