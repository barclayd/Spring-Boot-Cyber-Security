# Spring Boot Cyber Security

How to set-up the project:

```
$ git clone https://github.com/barclayd/Spring-Boot-Cyber-Security.git
```

### Running the Web App

Open project in IntelliJ

Please ensure that Lombok annotation is installed and annotations are enabled.

If running of project via RunSpringBootApp does not work, please follow these steps:


```
Run Gradle Build
Gradle Boot Run
```

### Setting up the Database:

Please run the MayDatabaseSchema.sql script found within the SQL folder. (/SQL/MayDatabaseSchema)
This is version is specially designed to populate the database with sample data for testing to demonstrate security fixes.
Please ensure that any login details that differ to:
username: root
password: comsc

are appropriately edited and replaced within application.properties.

### How to view the Project:

Please navigate to  https://localhost:8443/login

Please note, if you access the page on Chrome or Firefox, due to the HTTPS certificate being self-signed, you will see this warning message "Your connection is not private"

To view the web page, please follow the following steps:

1. Click "Advanced"
2. Click "Proceed to locahost:8443 (unsafe)"

You will now be able to view the webpage

Logging into the application:

Please user dummy accounts:

GP Login:
Email: steve@gp.net
Password: ronaldo

### How to set-up VM

Create Ubuntu 32bit VM in image of SecVM-April
Download a list of passwords and store in cd/Documents from
Install Hydra using relevant commands supplied in report or Youtube tutorial

### Security enhancements implemented

* Exception Handling/Information Leakage
* Logging
* HTTPS
* SSL/TLS
* Database Sensitive Storage
* User Input Validation
* Custom Error Handling
* Brute Force Tasks

### Tutorials to Demonstrate Cyber Security Vulnerability and Fixes

[Brute Force Attacks with Hydra - playlist (5 videos)] (https://www.youtube.com/playlist?list=PLJTaTSlR4DswsHAqim4B3I5bpOhAWApHo)


