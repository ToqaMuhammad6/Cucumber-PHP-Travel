# Travel Site Test Automation

Automated test framework for a travel site using **Selenium WebDriver**, **Cucumber (BDD)**, and **JUnit/TestNG**.

---

## 🚀 Features
- BDD-style test scenarios with Cucumber.
- Page Object Model (POM) for maintainable code.
- Hooks for setup/teardown and screenshots on failure.
- Reusable driver factory for multiple browsers.
- Assertions for UI validations and search functionality.

---

## 🛠️ Tech Stack
- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit/TestNG**
- **Maven**

---

## 📂 Project Structure
src\
├── main/java/travel/site/pages # Page classes (POM)\
├── test/java/travel/site/steps # Step definitions\
├── test/java/travel/site/hooks # Hooks (Before/After)\
├── test/resources/features # Cucumber feature files


---

## ▶️ How to Run
1. Clone the repository:
```bash
   git clone https://github.com/ToqaMuhammad6/Cucumber-PHP-Travel.git
 ```
2. Navigate to the project folder:
```bash
    cd travel-site-tests
```

3. Run tests with Maven:
```bash
  mvn test
```

