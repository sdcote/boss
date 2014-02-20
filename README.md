Back Office System Simulator
============================

This is a development environment for testing, demonstration and Proof of Concept (PoC) projects.  It is not a library, or stand-alone product, but a template for rapidly standing-up RESTful web services in support of development, testing and demonstration activities.

This is not a production environment. It is designed to be run simply and require very little resources will providing a high degree of configuration for developers in support of development activities.

This environment was created when a development team needed to create a Proof of Concept system using a third-party integration technology. This technology allows back office services to be easily integrated in the development of mobile applications. The problem the team had was there were no back office services to integrate.

The solution to this problem was the creation of a technology stack configured to be quickly deployed which allowed developers to create simple web services in short order. Because the third-party technology supported JDBC and JMS, those services were added to enable testing all of the technology’s capabilities. Through this packaged environment, developers can quickly implement and deploy web services, data bases and messaging to simulate modern back office infrastructure.

Another important feature this environment was designed to support is the easy operation by testers and product owners which need simple way to run demonstrations. This template includes scripts which support quick execution of the environment on Windows and UNIX systems.

While it is intended for use in Java environments, other Java compatible technologies (Groovy, Scala, etc.) can be used.

Technology Stack
----------------
The BOSS uses the following technologies:
* Gradle – Automated Build Tool
* Jetty – Web Server and J2EE container
* Jersey – Web Service Toolkit
* H2 – Relational Data Base
* Active MQ – Messaging Oriented Middleware
*	JUnit – Unit Testing Toolkit
*	Emma – Code Coverage Reporting
