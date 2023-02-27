
<a name="readme-top"></a>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Issues][issues-shield]][issues-url]

<h3 align="center">Doctor's Office</h3>
<h4 align="center">Hackbright Group Capstone Project</h4>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
[:sparkles: Click here to watch a walk-through video of the application! :sparkles:](https://youtu.be/jcNDna1fvb4)

There are a few doctors in the office and several patients. Project has scheduling system
for creating appointments which are meetings between a single doctor and a single patient.
There is also pharmacy that needs to fill prescriptions which are authorized by a single
doctor for a single patient as well.

![Register-Page][Register-Page-shield]

<h5>Appointments:</h5>
* A doctor may have several appointments scheduled and should be able to see them
in order.
* A patient may only have one single appointment scheduled at a time and should be 
able to see their upcoming appointment details.

<h5>Prescriptions:</h5>
* A doctor may also create a zero or more prescriptions for a patient and should be 
able to see al the prescriptions that they have currently authorized for all their patients.
* A patient should be able to view their current prescriptions.

![Patient-Portal][Patient-Portal-shield]
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With
Backend is powered with Java-based **_Spring Boot_** framework and **_Hibernate_** as its ORM.
The front-end is written using modern server-side Java template engine **_Thymeleaf_**.


[![Java][Java-shield]][Java-url] 
[![Thymeleaf][Thymeleaf-shield]][Thymeleaf-url]
[![SpringBoot][SpringBoot-shield]][SpringBoot-url]
[![Hibernate][Hibernate-shield]][Hibernate-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites
This section will help you install the software needed to run Java code if 
you don’t have it installed:

* Visit [jdk.java.net](https://jdk.java.net/)
* Alternatively, AWS provides an easy-to-install JDK known as [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
* Click on the largest version in “Ready for use”
* Click on your preferred OS (Mac, Windows, or Linux) and continue installation depending on your OS

#### Windows
* Download the file and unzip into Program Files directory/folder
* Copy path to the unzipped program
* In Windows Settings app, search for env, and click Edit System Environment Variables
* Under System variables click New
* Variable name = ```JAVA_HOME ```, value = path you pasted to jdk unzip, then click **OK**

Update existing variable- ```PATH```
* Find ```PATH``` in list, click **edit**
* Click **New**
* Paste path to jdk such as ```C:\Program Files\jdk-17.0.1```
* Add ```\bin```

#### Mac
Follow the instructions for [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)

Then in **~/.bash_profile**, execute the following:
```
export PATH=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin:$PATH
```
```
export JAVA_HOME=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin
```
and then…
```shell
$ source .bash_profile
```
#### Verify Successful Installation
Run the following command to verify your install:
```shell
$ java --version
```
### Installation
* Copy the [URL](https://github.com/ileanahi/doctors-office.git) for the repository 
* Open **Terminal**
* Change the current working directory to the location where you want the cloned directory.
* Type git clone, and then paste the URL you copied earlier.
   ```sh
   git clone https://github.com/ileanahi/doctors-office.git
   ```
* Press **Enter** to create your local clone.
```shell
$ git clone https://github.com/ileanahi/doctors-office.git
> Cloning into `CoolProject`...
> remote: Counting objects: 52, done.
> remote: Compressing objects: 100% (50/50), done.
> remove: Total 10 (delta 1), reused 10 (delta 1)
> Unpacking objects: 100% (52/52), done.
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]:https://img.shields.io/badge/CONTRIBUTERS-5-green
[contributors-url]: https://github.com/ileanahi/doctors-office/graphs/contributors
[forks-shield]: https://img.shields.io/badge/FORKS-2-blue
[forks-url]: https://github.com/ileanahi/doctors-office/network/members
[issues-shield]: https://img.shields.io/badge/ISSUES-0%20OPEN-yellow
[issues-url]: https://github.com/ileanahi/doctors-office/issues
[Java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=&logoColor=white
[Java-url]: https://www.java.com/en
[Thymeleaf-shield]: https://img.shields.io/badge/Thymeleaf-48892c?style=for-the-badge&logo=&logoColor=white
[Thymeleaf-url]: https://www.thymeleaf.org/
[SpringBoot-shield]: https://img.shields.io/badge/SpringBoot-8fce00?style=for-the-badge&logo=springboot&logoColor=white
[SpringBoot-url]: https://spring.io/
[Hibernate-shield]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white
[Hibernate-url]: https://hibernate.org/
[Register-Page-shield]: https://user-images.githubusercontent.com/81582376/217858466-336fd40a-c6e1-4d12-a8e1-c3694b91f294.png
[Patient-Portal-shield]: https://user-images.githubusercontent.com/81582376/217858611-4051169d-ce13-4a3c-b498-8366fdad0c62.png
