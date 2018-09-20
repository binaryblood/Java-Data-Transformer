# Java-Data-Transformer
A data transformer that transforms data from and to XML, JSON and CSV. Written with FasterXML's Jackson library
-----------------------------------------------------------------------------------------------------------------------------------
## Documentation

All you need to do is to import the jar as a dependency and create an instance for the Controller class and use the conversion methods in it.
```java
Controller ctrl = new Controller();
InputStream stream = new FileInputStream(new File("path/to/file"));

System.out.println(ctrl.csvToJson(stream)); //#CSV TO JSON
System.out.println(ctrl.csvToXml(stream)); //#CSV TO XML
System.out.println(ctrl.jsonToCsv(stream)); //#JSON TO CSV
System.out.println(ctrl.jsonToXml(stream)); //#JSON TO XML
System.out.println(ctrl.xmlToJson(stream)); //#XML TO JSON
System.out.println(ctrl.xmlToCsv(stream)); //#XML TO CSV
```
