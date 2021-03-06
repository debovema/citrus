### XHTML message validation

When Citrus receives plain Html messages we likely want to use the powerful XML validation capabilities such as XML tree comparison or XPath support. Unfortunately Html messages do not follow the XML well formed rules very strictly. This implies that XML message validation will fail because of non well formed Html code.

XHTML closes this gap by automatically fixing the most common Html XML incompatible rule violations such as missing end tags (e.g. <br>).

Let's try this with a simple example. Very first thing for us to do is to add a new library dependency to the project. Citrus is using the **jtidy** library in order to prepare the HTML and XHTML messages for validation. As this 3rd party dependency is optional in Citrus we have to add it now to our project dependency list. Just add the **jtidy** dependency to your Maven project POM.

```xml
<dependency>
    <groupId>net.sf.jtidy</groupId>
    <artifactId>jtidy</artifactId>
    <version>r938</version>
  </dependency>
```

Please refer to the **jtidy** project documentation for the latest versions. Now everything is ready. As usual the Citrus message validator for XHTML is active in background by default. You can overwrite this default implementation by placing a Spring bean with id **defaultXhtmlMessageValidator** to the Citrus application context.

```xml
<bean id="defaultXhtmlMessageValidator" class="com.consol.citrus.validation.xhtml.XhtmlMessageValidator"/>
```

Now we can tell the test case receiving action that we want to use the XHTML message validation in our test case.

```xml
<receive endpoint="httpMessageEndpoint">
    <message type="xhtml">
        <data>
          <![CDATA[
            <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "org/w3c/xhtml/xhtml1-strict.dtd">
            <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
              <title>Citrus Hello World</title>
            </head>
            <body>
              <h1>Hello World!</h1>
              <br/>
              <p>This is a test!</p>
            </body>
          ]]>
        </data>
    </message>
</receive>
```

The message receiving action in our test case has to specify a message format type **type="xhtml"** . As you can see the Html message payload get XHTML specific DOCTYPE processing instruction. The **xhtml1-strict.dtd** is mandatory in the XHTML message validation. For better convenience all XHTML dtd files are packaged within Citrus so you can use this as a relative path.

The incoming Html message is automatically converted into proper XHTML code with well formed XML. So now the XHTML message validator can use the XML message validation mechanism of Citrus for comparing received and expected data. As usual you can use test variables, ignore element expressions and XPath expressions.

