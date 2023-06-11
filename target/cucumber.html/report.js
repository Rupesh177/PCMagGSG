$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/NewsTest.feature");
formatter.feature({
  "name": "To Test PCMag portal",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify user is able to access PCMag Home Page",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have launched browser",
  "keyword": "Given "
});
formatter.match({
  "location": "glue.Base_Step_Definition.Verify_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on PCMag page",
  "keyword": "Given "
});
formatter.match({
  "location": "glue.Base_Step_Definition.Navigate_To_NBA()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see PCMag home page",
  "keyword": "Then "
});
formatter.match({
  "location": "glue.Base_Step_Definition.Verify_App_Logo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify user is able to navigate to a subpage",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I select \"Software \u0026 Services\" from \"Best Products \" section",
  "keyword": "When "
});
formatter.match({
  "location": "glue.Base_Step_Definition.iSelectFromSection(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Best Antivirus Apps\" option",
  "keyword": "And "
});
formatter.match({
  "location": "glue.Base_Step_Definition.iSelectOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be navigated to the \"Best Antivirus App\"",
  "keyword": "Then "
});
formatter.match({
  "location": "glue.Base_Step_Definition.navigateAndCheck(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "glue.Base_Step_Definition.After_Scenario()"
});
formatter.result({
  "status": "passed"
});
});