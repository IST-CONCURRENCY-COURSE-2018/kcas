# Atomic Array with 2-word CAS

[![Build Status](https://travis-ci.com/IST-CONCURRENCY-COURSE-2018/kcas-<your_GitHub_account>.svg?token=B2yLGFz6qwxKVjbLm9Ak&branch=master)](https://travis-ci.com/IST-CONCURRENCY-COURSE-2018/kcas-<your_GitHub_account>)

## Project description
This project includes the following files:

* `AtomicArray.java` contains the queue interface.
* `pom.xml` contains information about the project and configuration details used by Maven.

It is simpler to use Java 8 in order not to have problems with modules.

## Task description
You need to implement `cas2` method in `AtomicArray` class. Use the multiword CAS algorithm (aka k-CAS and CASN) for this purpose. 
Don't forget to modify other methods with respect to your changes, and keep in mind that descriptors should always be set in the same order.

## Build and testing
Use `mvn test` command to test your solution. The following tests are automatically executed:

* `FunctionalTest.java` tests the basic correctness (sequential);
* `LinearizabilityTest.java` checks for linearizability (concurrent).

## Submission format
Do the assignment in this repository, and commit (and push!) your solution to submit it. 

Replace `<your_GitHub_account>` in the beginning of this file with your GitHub account before submission (two places: image and build links). This is required to show a build status in Travis.