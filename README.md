# Joke API Test Framework

Automated API testing framework for the [Official Joke API](https://official-joke-api.appspot.com/) using RestAssured,
Cucumber, and TestNG.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)

---

## 🎯 Project Overview

This framework tests the Official Joke API endpoints with focus on:

- Retrieving random jokes
- Fetching jokes by ID
- Data validation and schema verification
- Status code checks

Built with BDD approach using Cucumber for readable test scenarios and comprehensive HTML reporting.

---

## 🛠️ Tech Stack

| Technology  | Version | Purpose                            |
|-------------|---------|------------------------------------|
| Java        | 17      | Programming language               |
| Maven       | 3.x     | Build automation                   |
| RestAssured | 6.0.0   | API testing library                |
| Cucumber    | 7.18.1  | BDD framework                      |
| TestNG      | 7.10.2  | Test execution framework           |
| Lombok      | 1.18.42 | Boilerplate code reduction         |
| AssertJ     | 3.27.7  | Fluent assertions                  |
| Jackson     | 2.15.2  | JSON serialization/deserialization |

---

## ✅ Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **IDE** with Lombok plugin (IntelliJ IDEA / Eclipse)
    - IntelliJ: Settings → Plugins → Install "Lombok"
    - Enable Annotation Processing: Settings → Build → Compiler → Annotation Processors → ✅ Enable

---

## 🚀 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/TymekSz/JokeApiTestRepo.git
```

### 2. Install dependencies

```bash
mvn clean install
```

### 3. Verify setup

```bash
mvn test
```

---

## ▶️ Running Tests

### Run all tests

```bash
mvn clean test
```

### Run specific feature

```bash
mvn test -Dcucumber.options="src/test/resources/features/random_number_of_jokes.feature"
```

### Run tests from IDE

1. Right-click on `TestRunner.java`
2. Select **Run 'TestRunner'**

---

## 📊 Test Reports

After test execution, reports are generated in multiple formats:

### HTML Report

```
html:target/cucumber-reports/cucumber.html
```

**How to view:** Right-click → Open in Browser

### Console Output

Test results are printed in the console with:

- ✅ Passed scenarios (green)
- ❌ Failed scenarios (red)
- Step-by-step execution details
- Execution time

---

## 🔧 Configuration

### Cucumber Options (TestRunner.java)

```java
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports/cucumber.html"
        }
)
```

### Maven Configuration (pom.xml)

- Java version: 17
- Maven compiler: 3.13.0
- Surefire plugin for test execution
- All dependencies managed via Maven Central

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-test`)
3. Commit changes (`git commit -m 'Add new test scenario'`)
4. Push to branch (`git push origin feature/new-test`)
5. Open a Pull Request

---

## 📝 License

This project is open source and available for educational purposes.

---

## 📧 Contact

**Author:** TymekSz  
**Repository:** [JokeApiTestRepo](https://github.com/TymekSz/JokeApiTestRepo)

---

## 🙏 Acknowledgments

- [Official Joke API](https://official-joke-api.appspot.com/) for providing the test endpoint
- Claude for creating this readme
- Myself for fighting with cucumber
