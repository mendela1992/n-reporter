# N-Reporter [![Codacy Badge](https://api.codacy.com/project/badge/Grade/fab21886dca9477990f7ed1a93fd4076)](https://www.codacy.com?utm_source=bitbucket.org&amp;utm_medium=referral&amp;utm_content=reserach_n_development/inspired-reporting&amp;utm_campaign=Badge_Grade)

**N-Reporter** is a JAVA based API report generator that empowers you to generate beautiful, interactive and detailed results reports for automation tests. It allows you to keep track of execution tests and over time.
N-Reporter can include screenshots, code blocks, tags, specified author and categorized the execution and any other relevant information many more information can be added dynamically. See Screenshot below:

## Getting Started

###Pre-requisites
N-Reporter was build on Java 8.
So you will need to download and install [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

### Installation
Insert snippet below into your pom.xml and build your project.
```
<dependency>
  <groupId>com.inspiredtesting</groupId>
  <artifactId>Inspired-Report</artifactId>
  <version>${reporter.verison}</version>
</dependency>
```
Replace x.x.x by version number. 
Find [latest Release](http://10.20.10.126:8081/#browse/browse:maven-releases:com%2Finspiredtesting%2FInspired-Report)
## Features
-   Generate beautiful HTML report.
-   Customizable report content.
-   Customizable report name.
-   Customizable project name.
-   Categories execution (Regression execution etc).
-   Include tags in tests executed.
-   Customizable status color for your report.
-   Mobile responsive report.
-   Include Dashboard with graphs.
-   Convert Media content into base64 imaging.

## Usage
### Create report 
To enable a report or start a reporter, create an object of NReporter
```
NReporter report = new NReporter(“folderPath”);
```
### Create a test
To create a test use ```createTest``` method. This will return an NTest object.
```
NTest test = report.createTest("First Test", "First Steps description");
```

### Media Content
Create portable (base64 Image) media content from either URL or physical file path:
```
// Using Path
MediaContent.createMediaFromPath("./src/main/resources/NReporter2.png").toBase64();

// Using URL
MediaContent.createMediaFromURL("https://www.inspiredtesting.com/images/logo.png").toBase64();
```
### Set Project name
Define your project name
```
report.setProjectName("ProjectName");
```
### Set Report Name
Define report name. (if null will use project name)
```
report.setReportName("ReportName");
```
### Set Category 
Categorize your execution (Optional)
```
test.setCategory("Category Name");

// Short-hand
report.setCategory(new InspiredCategory("Category Name", "Category Description"));
```
### Set Environment
Add extra information regarding the execution environment.
```
report.setSystemInfo("Java Version", "1.8");
```
### Set Status Colour
Customize status background colours for HTML report. Use ```setStatusColor``` method. 
```
// With RGB value
report.setStatusColor(Enums.Status.FATAL, "rgb(255, 0, 0)");

// With Hex value 
report.setStatusColor(Enums.Status.INFO, "#09a2ef");
```

### Add Screenshot manually
To add screenshot to your last test result, use ```addScreenshot```. This will return an NTest object.
```
test.addScreenshot("https:dummyimage.com/600x400/000/fff.png&text=Passed");
```
### Create and assign tag(s)
```
test.assignTag("tag", "tag2");
```
### Flush
Calling the flush method will write update of your execution into a HTML report.
```
report.flush();
```
## Example
### Basic code
```
public void basicReport() throws Exception {
   // Initialiaze reporting
   NReporter report = new NReporter("/path/to/report/folder");
   // Set Report logo
   report.setLogo("logoName");
   // Set Report name
   report.setReportName("NReportering Name");
   // Set Project Name
   report.setProjectName("NReporter Project");
   // Create New test
   NTest test = report.createTest("Test Name", "Test description");
   test.pass("First Step Passed");
   test.addScreenshot("https://dummyimage.com/600x400/000/fff.png&text=first passed Shot");
   test.skip("First Step Failed");
   test.addScreenshot("https://dummyimage.com/600x400/000/fff.png&text=first Failed Shot");
   test.pass("First Step Debug", "https://dummyimage.com/600x400/000/fff.png&text=debug Pic");
}
```
NB: Report is generated as you log your event
### Basic Code to generate report with JSON file 
```
public void reportWithJSON() throws Exception {
   // Initialiaze reporting
   NReporter report = new NReporter("/path/to/report/folder");
   // Set Report logo
   report.setLogo("path");
   // Set Report name
   report.setReportName("NReportering Name");
   // Set Project Name
   report.setProjectName("NReporter Project");
   // Create Report
   report.createReportFromJson("/path/to/json/file");
}
```
## Built With
-   [Boostrap 4](https://getbootstrap.com/docs/4.0/getting-started/introduction/) 
-   [Freemaker Apache](https://freemarker.apache.org/)
-   [Google Gson](https://github.com/google/gson)
-   [Unirest](http://unirest.io/java.html)
-   Commons-codec
-   Commons-io
-   Commons-logging
-   Joda-time
-   log4j
-   JUnit5

## Authors

-   **Nelson Dick** - *Author & Developer* 

## License

This project is licensed under the Inspired Testing License - see the [LICENSE.md](LICENSE.md) file for more details.

## Acknowledgments  
-   [Inspired Testing](https://www.inspiredtesting.com/) 