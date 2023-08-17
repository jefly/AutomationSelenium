# AutomationSelenium (Java, Selenium & Page Object Model)

# Setup Guide
## Prerequisites
### Step 1: Installing Java

Download Java 19 from `https://www.oracle.com/java/technologies/downloads/`, install it.

### Step 2: Installing Maven

Download Maven from `https://maven.apache.org/install.html`, copy the path to the bin folder and add it to the 'PATH' variable under environment variables (user & system).

### Step 3: Verify Maven is set up

To verify whether the Maven is set up properly, run `mvn -version` on the terminal.

### Step 4: Compile the source code and install dependencies

Go to the root of the extracted project, open a terminal for that location. <br/>
Type `mvn clean install` which will download the necessary dependencies for the project.

### Step 5: Run the project

Run `mvn test`.<br/> 
This will give you a URL to view the test results in the end of the log inside the terminal.<br/> 
`View your Cucumber Report at: and the next line URL starts as https://reports.cucumber.io/reports/...`

### Step 6: See the Test Results

Copy the URL to the browser, paste it and hit enter to see the test results.
