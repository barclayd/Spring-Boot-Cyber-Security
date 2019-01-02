# Spring Boot Cyber Security

### Motivation

Demonstration of typical security flaws in a web application and how to fix them:

- [x] Exception Handling/Information Leakage
- [x] Logging
- [x] HTTPS - HTTP vulnerability shown using Wireshark inspecting packet, fixed using HTTPS .jks file and RSA private key with a default signature algorithm of MD5.
- [x] SSL/TLS - enabled SSL connection on MySQL with OpenSSL
- [x] Database Sensitive Storage - storage of passwords with hash and salt
- [x] User Input Validation - prevent SQL injections or XSS
- [x] Custom Error Handling
- [x] Brute Force Attacks - repeated login attempts, vulnerability shown using Hydra - fixed using IP blocking function and Google Captcha

Brute Force attack can be shown by running the web app on a host machine and setting up a virtual machine Ubuntu 32bit using Hydra. 

### Tutorials to Demonstrate Cyber Security Vulnerability and Fixes

5 part walkthrough series hosted on YouTube:

[Brute Force Attacks with Hydra - YouTube](https://www.youtube.com/playlist?list=PLJTaTSlR4DswsHAqim4B3I5bpOhAWApHo)

<a href="http://www.youtube.com/watch?feature=player_embedded&v=PLJTaTSlR4DswsHAqim4B3I5bpOhAWApHo
" target="_blank"><img src="http://img.youtube.com/vi/ToplCJiULNY/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="560" height="315" border="10" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen /></a>

### Demo

##### Hydra on VM successfully identifying username and password - based on a given username and a list of 10,000 random passwords
![screenshot 2018-12-28 at 13 52 59](https://user-images.githubusercontent.com/39765499/50517374-03708500-0aa8-11e9-98a3-0b2d3d3db59d.png)
##### Code to implement Google Captcha and demonstration of IP blocking feature
![screenshot 2018-12-28 at 13 53 23](https://user-images.githubusercontent.com/39765499/50517373-03708500-0aa8-11e9-9c37-ae363d98bb0e.png)
##### Hydra no longer able to identify username and password after implentation of IP blocking and Google Chrome
![screenshot 2018-12-28 at 13 53 44](https://user-images.githubusercontent.com/39765499/50517372-03708500-0aa8-11e9-8fa7-3209d212a1da.png)


### Set-up and Run the Web App:

Open project in IntelliJ

Please ensure that Lombok annotation is installed and annotations are enabled.

If running of project via RunSpringBootApp does not work, please follow these steps:

```
$ git clone https://github.com/barclayd/Spring-Boot-Cyber-Security.git
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
