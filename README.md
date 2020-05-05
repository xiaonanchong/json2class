## json2class  
This java library project is used to transfer facility description file with JSON format to java class (Message.java). Details on Message class is summarized in the following UML chart:  
![1](https://github.com/xiaonanchong/json2class/blob/master/uml.png "uml")  
The library JAR can be found in: 'build/libs/json2class-uber-0.1.0.jar'  
The test report can be found in: 'build/reports/tests/test/index.html'  
The ways to use JAR file are:  
1-in Eclipse IDE  
copy jar file to directory lib and add it to the build path  
import json2class.Library and json2class.Message, the static method Library.j2c takes a String in json format and returns a Message instance.  
![2](https://github.com/xiaonanchong/json2class/blob/master/sample.png "sample use code")  
2-in gradle project  
copy jar file to directory lib and add following lines in build.gradle:  
```
dependencies {
        compile files('lib/json2class-uber-0.1.0.jar')
}

```
