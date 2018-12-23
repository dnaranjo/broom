# Broom (RESTful web service to cleanup data)
## Development Environment
|                     |                                 |
|---------------------|---------------------------------|
| **OS**              | Linux Mint                      |
| **Kernel**          | x86_64 Linux 4.15.0-43-generic  |
| **JDK**             | OpenJDK 1.8                     |
| **App Server**      | Apache TomEE JAX-RS 1.7.5       |
| **IDE**             | Eclipse 2018-09                 |
| **Version control** | Git 2.19.1 / GitHub             |

## Deployment
### Prerequisites
Although some of the components previously mentioned are not relevant when deploying the application, some others are definitely needed before moving forward, and are listed in this section:
1. An instance of TomEE must already exist in the local machine under /opt/tomcat/. The version used for development was 1.7.5 and was installed following this tutorial https://linuxize.com/post/how-to-install-tomcat-8-5-on-ubuntu-18.04/
2. OpenJDK version 1.8 must be installed under /usr/lib/jvm/. This is needed for both Eclipse and TomEE.
3. Likewise, a version of git and Eclipse is needed.

### Installation Guide
This section lists the steps required in order to deploy the application locally.
1. Download the repository to your local machine: git clone https://github.com/dnaranjo/broom.git
2. Copy directory broom/workspaces/**neustar** inside your own Eclipse *workspaces* directory.
3. Open Eclipse.
4. When selecting the Workspace, browse to the folder you just copied (neustar) and launch it.
5. Start the **Tomcat v7.0** Server under the Servers tab.
6. That's it. The server should be up and listening for incoming requests.

## Unit testing
JUnit tests have been provided as part of the solution. In order to execute them, right-click the **broom** project and select *Run As > JUnit Test*

## Endpoints
The services' functionality is exposed in the following addresses:
### Categories
| Feature               | Endpoint                                                    |
|-----------------------|-------------------------------------------------------------|
| List Valid Categories | GET http://server_name:8080/broom/category                       |
| Add Category          | PUT http://server_name:8080/broom/category?name=category_name     |
| Delete Category       | DELETE http://server_name:8080/broom/category?name=category_name  |
  
### Pairs
| Feature         | Endpoint                                                   |
|---------------- |------------------------------------------------------------|
| Cleanup feature | POST http://server_name:8080/broom/pair                         |

**NOTE:** The body for this request must consist of a valid JSON string (see format in next section)

## Input/Output format for pairing requests
### Input
A valid JSON input string must follow this format:
```{
  "pairs": [
    {
      "category": {
        "name": "CATEGORY_1"
      },
      "subCategory": "Sub category 1"
    },
    {
      "category": {
        "name": "CATEGORY_2"
      },
      "subCategory": "Sub category 2"
    },
    ...
    {
      "category": {
        "name": "CATEGORY_N"
      },
      "subCategory": "Sub category N"
    }
  ]
}
```

### Output
After cleaning up and processing the input, the service will reply with a JSON string that implements the following format:
```{
  "processedList": [
    {
      "category": {
        "name": "CATEGORY_1"
      },
      "subCategory": "Sub category 1"
    },
    {
      "category": {
        "name": "CATEGORY_2"
      },
      "subCategory": "Sub category 2"
    },
    ...
    {
      "category": {
        "name": "CATEGORY_N"
      },
      "subCategory": "Sub category N"
    }
  ],
  "count": [
    {
      "category": {
        "name": "CATEGORY_1"
      },
      "occurrences": number_of_occurrences
    },
    {
      "category": {
        "name": "CATEGORY_2"
      },
      "occurrences": number_of_occurrrences
    },
    ...
    {
      "category": {
        "name": "CATEGORY_n"
      },
      "occurrences": number_of_occurrences
    }
  ]
}
```

## Monitoring
Since the service is hosted by a TomEE server, the Tomcat Manager app (available at http://server_name:8080/manager/html) can be used for monitoring purposes. The only configuration change required is defining a user and password in file conf/tomcat-users.xml:
```<role rolename="manager-gui"/>
<role rolename="manager-jmx"/>
<user username="tomcat" password="s3cret" roles="manager-gui, manager-jmx"/>
```
## Additional considerations
JRE and Tomcat settings in Eclipse provided for reference:
![JRE settings in Eclipse](https://raw.githubusercontent.com/dnaranjo/broom/master/misc/jre.png)
![TomEE settings in Eclipse](https://raw.githubusercontent.com/dnaranjo/broom/master/misc/tomcat.png)
