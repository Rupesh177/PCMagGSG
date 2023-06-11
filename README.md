
News Automation :

This project targets to automate PCMag portal from Accessibility point of view

Technology Stack :
- Selenium Webdriver
- Java
- Cucumber
- Cucumber Report & Extent report

Following Features Automated:
- Verify user is able to access PCMag Home Page
- Verify user is able to navigate to the sub-page. Then verify below items-
	1. Article Name/Header  
	2. Article Content 
	3. Article Block 

Steps to Execute:
- Clone this project.
- Perform mvn clean test->It will call the TestRunner file which in turn would execute the Cucumber feature file. 
- Or you can go to Resources->Features->NewsTest.feature and execute all the scenarios. 

Result/Report File :
- You can see report in 'test-output/AutomationSummaryReport/ExtentSpark->Here you would find an html report and in PDF_Report-> you will see the report in PDF format. cucumber-reports/index.html'. Please open this html file in browser.


Notes:
- This will be executed on chrome browser by default. When we will hook up this framework with CI then we can create profiles in POM file  and pass different browsers from CI tool.

