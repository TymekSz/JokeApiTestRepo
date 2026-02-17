# Development Log (DEVLOG)

## Project: Joke API Test Framework

**Repository:** https://github.com/TymekSz/JokeApiTestRepo  
**Branch:** master  
**Development Period:**  February 2025

---

## 📅 Development Timeline

### Phase 1: Project Initialization

**Date:** 16 February 2025

#### Initial Setup

- Created Maven project structure
- Added core dependencies:
    - RestAssured 6.0.0 for API testing
    - Cucumber 7.18.1 for BDD
    - TestNG 7.10.2 as test framework
    - Lombok 1.18.42 for cleaner code
    - Jackson 2.15.2 for JSON handling

#### Key Decisions

- Chose TestNG over JUnit for better test configuration flexibility
- Used Lombok `@Data` annotation to reduce DTO boilerplate

**Commits:**

- `Initial project setup with Maven`
- `Add core dependencies: RestAssured, Cucumber, TestNG`
- `Configure Maven compiler plugin for Java 17`

---

### Phase 2: Core Framework Development

**Date:** 17 February 2025

#### DTO Creation

Created `JokeDto.java` with Lombok annotations:

```java

@Data
public class JokeDto {
    private String type;
    private String setup;
    private String punchline;
    private int id;
}
```

**Challenge:** IDE wasn't recognizing Lombok-generated getters/setters  
**Solution:** Installed Lombok plugin and enabled annotation processing in IDE settings

#### API Request Layer

Implemented requests to handle API calls:

- Centralized RestAssured configuration
- Reusable request methods
- Response deserialization to `JokeDto`

---

### Phase 3: Cucumber Integration

**Date:** 17 February 2025

#### Feature File Development

Created steps and features files:

- Scenario for validating jokes retrieved by ID
- Integrated Cucumber DataTable for test data

#### Test Runner Configuration

Created `TestRunner.java` extending `AbstractTestNGCucumberTests`:

**Challenge:** Reports not generating after test execution  
**Solution:** Ensured runner extends `AbstractTestNGCucumberTests` and tests are executed via runner class, not directly
from feature files


---

#### README.md Creation

#### DEVLOG.md Creation

---

## 🤖 AI Usage

### Claude AI Assistance (Anthropic)

Throughout this project, Claude AI was used as a development assistant and pair programming partner:

#### Areas of AI Assistance:

1. **Problem Solving:**
    - Debugging Cucumber DataTable mapping issues
    - Troubleshooting Lombok plugin configuration

2. **Code Generation:**
    - Step definition templates for Cucumber scenarios
    - Report generation configuration

3. **Best Practices:**
    - Maven dependency management
    - Cucumber naming conventions (snake_case for features)
    - Test organization patterns (Given-When-Then)

4. **Documentation:**
    - README structure and content
    - DEVLOG formatting and organization

#### Human Developer Contributions:

- All final code review and decisions
- Manual testing and validation
- Git commits and version control
- Project architecture decisions
- Custom business logic implementation
- API endpoint understanding and test case design

#### AI Transparency:

- AI provided suggestions and code snippets
- Developer made final implementation decisions
- AI acted as a knowledge resource, not autonomous developer

---

## 📊 Project Statistics

- **Total Features:** 3
- **Total Scenarios:** 3
- **Development Time:** ~4 hours
- **Test Execution Time:** ~5-6 seconds

---

## ✅ Final Status

**Project Status:** ✅ Complete and functional  
**All Tests:** ✅ Passing  
**Documentation:** ✅ Complete  
**Reports:** ✅ Generating successfully

---

**Last Updated:** February 17, 2025  
**Author:** TymekSz