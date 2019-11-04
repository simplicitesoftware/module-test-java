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

This module is for testing Java features.

`TestJavaService` business object definition
--------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `testSrv1`                                                   | char(100)                                |          | yes       |          | -                                                                                |
| `testSrv2`                                                   | text(1000000)                            |          | yes       |          | -                                                                                |

### Custom actions

No custom action

`TestJavaUser` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |

### Custom actions

No custom action

`TestjObject` business object definition
----------------------------------------

Test Java object

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `testjObjCode`                                               | char(50)                                 | yes*     | yes       |          | -                                                                                |
| `testjObjDesc`                                               | html(4000)                               |          | yes       |          | -                                                                                |
| `testjObjFlag`                                               | boolean                                  |          | yes       |          | -                                                                                |

### Custom actions

No custom action

`TestjObjectChild` business object definition
---------------------------------------------

Child of TestJavaObject

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |

### Custom actions

No custom action

`TestjObjectGrandChild` business object definition
--------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |

### Custom actions

No custom action

`TestjObjectHierarchy` business object definition
-------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |

### Custom actions

No custom action

`TestJavaWorkflow` business process definition
----------------------------------------------



### Activities

* `Begin`: 
* `Create`: 
* `End`: 

`TestJavaExtObject` external object definition
----------------------------------------------




`TestJavaRESTExtObject` external object definition
--------------------------------------------------

Test REST service external object


