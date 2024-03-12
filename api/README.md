---

# ExBank API Automation

This project is an API testing framework for ExBank, built using Java, Spring Boot, TestNG, Rest Assured, and Extent Reports.

## Description

ExBank API Automation project provides a framework for automating the testing of ExBank's API endpoints. It utilizes Spring Boot for setting up the application context, TestNG as the testing framework, Rest Assured for making API calls and assertions, and Extent Reports for generating detailed test reports.

## Technologies Used

- Java 17
- Spring Boot
- TestNG
- Rest Assured
- Extent Report
## Getting Started

  Here are the prerequisites you need to setup.
- Java JDK
- Maven
- IntelliJ
- [Spring initializr](https://start.spring.io/)
- [Postman](https://www.postman.com/downloads/)

## Dependencies

- `spring-boot-starter-web`: Starter for building web applications using Spring MVC.
- `spring-boot-starter-test`: Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest, and Mockito.
- `io.rest-assured`: Java DSL for easy testing of REST services.
- `org.testng:testng`: Testing framework inspired by JUnit and NUnit.
- `org.projectlombok:lombok`: Java library that automatically plugs into your editor and builds tools, spicing up your java.
- `com.aventstack:extentreports`: Library for creating interactive and comprehensive test reports.

## Environment Configurations

- JAVA_HOME
- MAVEN_HOME
- Add bin paths to 'Path'

Run following commands to see if the configurations are set.

```bash
# Check Java version
$ java -version

# Check Maven version
$ mvn --version
```

<h3> Reporting </h3>
Reporting done via Extent Report.
Generated before and after tests.

```bash
# Import 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
```

To build the project, you can use Maven:

```
mvn clean install
```

To run the project, you can use the Spring Boot Maven Plugin:

```
mvn spring-boot:run
```

## Testing

Tests can be executed using Maven:

```
mvn test
```

<h3> Setting up the project </h3>

[test-api-ui-mobile repository](https://github.com/RochelleAbeywickrama/test-api-web-mobile.git)

Clone the project to your local and build the project successfully.

```bash
# Clone this repository
$ git clone https://github.com/IsharaHewa/exbank-api-test-automation.git

# Build Project
$ mvn clean install
```

If the initial configurations and prerequisites are done, you can execute  the API tests. </br>

# TODO List:

- [X] Develop API
- [X] Api Automation suite
- [X] Web Automation suite
- [X] Mobile Automation suite
- [X] Add Testcases document to the test resources

## Contributing

Contributions to this project are welcome. To contribute, fork the repository and create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).


## Related Links

[Maven Repository](https://mvnrepository.com/)

[IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

[NodeJS](https://nodejs.org/en)

[Material 1](https://www.youtube.com/watch?v=Zo9xQzibp4Y)

[Material 2- By Author](https://www.youtube.com/watch?v=z_ZH_8SLWls&t=11s)

---