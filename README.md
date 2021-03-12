<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`TestJava` module definition
============================

This module is for testing platform features.

All items in this module are developped in Java.

`TestJavaService` business object definition
--------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `testSrv1`                                                   | char(100)                                |          | yes       |          | -                                                                                |
| `testSrv2`                                                   | text(1000000)                            |          | yes       |          | -                                                                                |

`TestJavaUser` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`TestjObject` business object definition
----------------------------------------

Test Java object

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `testjObjCode`                                               | char(50)                                 | yes*     | yes       |          | -                                                                                |
| `testjObjDesc`                                               | html(4000)                               |          | yes       |          | -                                                                                |
| `testjObjFlag`                                               | boolean                                  |          | yes       |          | -                                                                                |
| `testjObjDocumentURL`                                        | url(255)                                 |          | yes       |          | -                                                                                |
| `testjObjDocument`                                           | document                                 |          | yes       |          | -                                                                                |

`TestjObjectChild` business object definition
---------------------------------------------

Child of TestJavaObject

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`TestjObjectGrandChild` business object definition
--------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`TestjObjectHierarchy` business object definition
-------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`TestJavaWorkflow` business process definition
----------------------------------------------



### Activities

* `Begin`: 
* `Create`: 
* `End`: 

`TestJavaCytoscape` external object definition
----------------------------------------------




`TestJavaExtObject` external object definition
----------------------------------------------




`TestJavaJQPlot` external object definition
-------------------------------------------

Custom jQPlot dashboard


`TestJavaMappedRESTExtObject` external object definition
--------------------------------------------------------

Test **mapped** REST service external object


`TestJavaRESTExtObject` external object definition
--------------------------------------------------

Test REST service external object


`TestJavaSignature` external object definition
----------------------------------------------




`TestJavaStaticSite` external object definition
-----------------------------------------------




`TestJavaTimeline` external object definition
---------------------------------------------




`TestjEDM` external object definition
-------------------------------------

Test EDM


`TestjHTTPTracer` external object definition
--------------------------------------------

Plain HTTP tracer


