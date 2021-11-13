# I'm a readme file and will tell about this project
___
The project is showed how using Allure Repost in projects.

## Acknowledgments
___
Artem Yaroshenko

## About home task
___
Написать тест на проверку названия Issue в репозитории через Web-интерфейс.

Этот тест представить в трех вариантах:

1. Чистый Selenide (с Listener)

2. Лямбда шаги через step (name, () -> {})

3. Шаги с аннотацией @Step

В качестве ответа на задание приложите ссылку на свой репозиторий GitHub в поле ответа

## Steps
___
### Lesson 6. Theory.
___
Step 1. Create the three files: readme.md, build.gradle and .gitignore.

Step 2. Fill the file build.gradle the main features: plugins, repositories, dependencies, test.

Step 3. Create directories of the projects in /src.

Step 4. Create the test with "steps".

Step 5. Create the test with "annotation".

Step 6. Take a screenshot of a page for an attachment of Allure (in the class with steps).

Step 7. Take a screenshot of a page for an attachment of Allure (in the class with annotation).

Step 8. Create a parameterization test.

Step 9. Add labels in Allure.

Step 10. Log events of tests in Allure.

___
___

### Lesson 6. The Homework.
___



## What's new
___
### 1. Java
### 2. Gradle
   1. [plugins](https://plugins.gradle.org/plugin/io.qameta.allure)

    ```plugins {
      id "io.qameta.allure" version "2.9.6"
      }
    ```  
   2. https://github.com/allure-framework/allure-gradle

### 3. Selenide
### 4. Git
### 5. Allure
1. allureReport generates a report in a project.
2. allureServe generates a report in html page.
3. Parameterization tests
   ```aidl
   @DisplayName("CHECK")
   @ParameterizedTest(name="{0} {displayName} ")
   @ValueSource(strings = {"AAA", "BBB"})
   void testParameterization(String city) {
         Allure.parameter("City", city);
    }
   ```
4. Log events and report to Allure

   Dependencies:

    `io.qameta.allure:allure-selenide:2.13.2`

   Start:  

   `SelenideLogger.addListener("allure", new AllureSelenide());`

5. Screenshot
   ```
     AllureLifecycle lifeCycle = Allure.getLifecycle();
     
     lifeCycle.addAttachment("screenshot", 
                "image/png", 
                "png", 
                takeScreenShot());
                
     private static byte[] takeScreenShot(){
        WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

   ```


            
___
### -2. require "Resources"



## Checking
___


