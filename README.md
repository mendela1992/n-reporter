# N-Reporter [![Codacy Badge](https://api.codacy.com/project/badge/Grade/fab21886dca9477990f7ed1a93fd4076)](https://www.codacy.com?utm_source=bitbucket.org&amp;utm_medium=referral&amp;utm_content=reserach_n_development/inspired-reporting&amp;utm_campaign=Badge_Grade)

**Inspired Report** is a JAVA based API report generator that empowers you to generate beautiful, interactive and detailed results reports for automation tests. It allows you to keep track of execution tests and over time.
Inspired Report can include screenshots, code blocks, tags, devices, specified author and categorized the execution and any other relevant information many more information can be added dynamically. See Screenshot below:


## Screenshots

### Report 1
![InspiredReport Screenshot](./src/main/resources/InspiredReport2.png)
### Report 2
![InspiredReport Screenshot](./src/main/resources/InspiredReport1.png)
### Report Dashboard
![InspiredReport Screenshot](./src/main/resources/InspiredDashboard.png)

## Getting Started

###Pre-requisites
Minimum requirements:
-   Java 8

### Installation
Insert snippet below into your pom.xml and build your project.
```
<dependency>
  <groupId>com.inspiredtesting</groupId>
  <artifactId>Inspired-Report</artifactId>
  <version>x.x.x</version>
</dependency>
```
Replace x.x.x by version number. 
Find [latest Release](http://10.20.10.126:8081/#browse/browse:maven-releases:com%2Finspiredtesting%2FInspired-Report)
## Features
-   Generate beautiful HTML report.
-   Generate report in offline mode.
-   Generate a JSON payload file.
-   Generate report using JSON file.
-   Log results to Web Portal.
-   Customizable report content.
-   Customizable Report logo.
-   Customizable report name.
-   Customizable project name.
-   Categories execution (Regression execution etc).
-   Include Device information in report (Device name, Device Model, etc).
-   Include tags in tests executed.
-   Customizable status color for your report.
-   Mobile responsive report.
-   Include Dashboard with graphs.
-   Live report and JSON Report generated during execution time.
-   Convert Media content into base64 imaging.

## Usage
### Create report 
To enable a report or start a reporter, create an object of InspiredReport
```
InspiredReport report = new InspiredReport(“folderPath”);
```
### Flush
Calling the flush method will write update of your execution into a:
-   HTML report
-   JSON payload
### Media Content
Create portable (base64 Image) media content from either URL or physical file path:
```
// Using Path
MediaContent.createMediaFromPath("./src/main/resources/InspiredReport2.png").toBase64();

// Using URL
MediaContent.createMediaFromURL("https://www.inspiredtesting.com/images/logo.png").toBase64();
```
### Set report logo
Define the report logo
```
// Using Direct path
report.setLogo("/logo/path/or/url");

// Using base64 image
report.setLogo(MediaContent.createMediaFromURL("https://www.inspiredtesting.com/images/logo.png").toBase64());
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
InspiredCategory category = new InspiredCategory("Category Name", "Category Description");
report.setCategory(category);

// Short-hand
report.setCategory(new InspiredCategory("Category Name", "Category Description"));
```
### Set User
Define user interacting with execution (optional)
```
InspiredUser user = new InspiredUser("superadministrator@dvt.co.za");
report.setUser(user);

// Short-hand
report.setUser(new InspiredUser("User Identifier"));
```
### Set Test Pack name
Define test pack name (optional)
```
report.setTestPackName("test pack name");
```
### Set Offline report
Generates offline HTML report (By Default, it is set to false)
```
report.setOfflineReport(true);
```
### Set Environment
Add extra information regarding the execution environment.
```
report.setEnvironment("Java Version", "1.8");
```
### Set Status Colour
Customize status background colours for HTML report. Use ```setStatusColor``` method. 
```
// With RGB value
report.setStatusColor(Enums.Status.FATAL, "rgb(255, 0, 0)");

// With Hex value 
report.setStatusColor(Enums.Status.INFO, "#09a2ef");
```
### Set JSON generation
To enable or disable JSON payload generation, use ```setJSON```. (by default, set to true)
```
report.setJSON(false);
```
### Create a test
To create a test use ```createTest``` method. This will return an InspiredTest object.
```
InspiredTest test = report.createTest("First Test", "First Steps description");
test.pass("Pass Step message with no screenshot");

// Short-hand
report.createTest("First Test", "First Steps description").pass("Pass Step message with no screenshot");
```
### Add Screenshot manually
To add screenshot to your last test result, use ```addScreenshot```. This will return an InspiredTest object.
```
test.addScreenshot("https:dummyimage.com/600x400/000/fff.png&text=Passed");
```
### Create and assign tag(s)
```
InspiredTag tag = new InspiredTag("Mobile Testing", "");
InspiredTag tag2 = new InspiredTag("Web Automation Testing", "");
test.assignTag(tag, tag2);

// Short-hand
test.assignTag(new InspiredTag("Web Automation Testing", ""), new InspiredTag("Mobile Testing", ""));
```
### Create and assign Device(s)
```
InspiredDevice device = new InspiredDevice("Samsung", "S6");
device.addDeviceInfo("UDID", "KJHD04D").addDeviceInfo("Platform", "Android");
test.assignDevice(device)

// Short-hand
test.assignDevice(new InspiredDevice("Samsung", "S6").addDeviceInfo("UDID", "KJHD04D"), new InspiredDevice("Sony", "XperiaL6"))
```
### Create Report from JSON
To create a report from JSON, use ```createReportFromJson``` method.
```
report.createReportFromJson("Path/to/json/file");
```
## Example
### Basic code
```
public void basicReport() throws Exception {
   // Initialiaze reporting
   InspiredReport report = new InspiredReport("/path/to/report/folder");
   // Set Report logo
   report.setLogo("logoName");
   // Set Report name
   report.setReportName("InspiredReporting Name");
   // Set Project Name
   report.setProjectName("InspiredReport Project");
   // Create New test
   InspiredTest test = report.createTest("Test Name", "Test description");
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
   InspiredReport report = new InspiredReport("/path/to/report/folder");
   // Set Report logo
   report.setLogo("path");
   // Set Report name
   report.setReportName("InspiredReporting Name");
   // Set Project Name
   report.setProjectName("InspiredReport Project");
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