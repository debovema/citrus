### Changes in Citrus 2.3?!

We want to give you a short overview of what has changed in Citrus 2.3. The release adds some new features and improvements to the box. Bugfixes of course are also part of the package. See the following overview on what has changed.

### Test runner and test designer

One of the biggest issues with the Citrus Java DSL is the fact that the Citrus Java DSL methods first build the whole test case together before the actual execution takes place. So calling a Java DSL method **send** for instance just prepares the sending test action. The actual sending of the message takes place to a later time when all test actions are setup and the test case is ready to run. This separation of design time and runtime of a test case leads to misunderstandings as a Java developer is used to work with statements and method calls that perform immediately. Based on that the mixture of Citrus Java DSL method calls and normal Java code logic in your test may have lead to unexpected behavior. Following from that we decided to refactor the Java DSL method execution. The result is a new **TestRunner** concept that executes all Java DSL method calls immediately. The old way of building the whole test case before execution is represented with **TestDesigner** concept. So both worlds are now available to you. See [testcase](testcase) for details.

### WebSocket support

The WebSocket message protocol builds on top of Http standard and brings bidirectional communication to the Http client-server world. With this release Citrus users are able to send and receive messages with WebSocket connections. The Http server implementation is now able to define multiple WebSocket endpoints. The new Citrus WebSocket client is able to publish messages to the server via bidirectional WebSocket protocol. See[http-websocket](http-websocket)for details.

### JSONPath support

Citrus is able to work with Xpath expressions in several fields within the testing domain (overwrite elements, ignore elements, extract values from payloads). Now this support of manipulating message payloads via expressions is extended with JSONPath. Similar to Xpath the JSONPath expression statements enable you to find elements and values within a message payload. Not very surprising the JSONPath expressions work with Json message payloads. With the new release you can overwrite, ignore and manipulate Json elements using JSONPath expressions. See[json-path](json-path)for details.

### Customize message validators

The framework offers several message validator implementations for different message formats like XML, JSON, plaintext and so on. In addition to that Citrus has a set of Groovy script message validators. All these validator implementations are active by default so you are able to validate incoming messages accordingly in Citrus. Now with this release we added a more comfortable way of changing the framework validation functionality, particular when adding new customized message validator implementations. See [validation](validation) for details.

### Library upgrades

We have upgraded the versions of the major dependency libraries of Citrus. This includes TestNG, JUnit, Spring Framework, Spring WS, Spring Integration, Apache Camel, Arquillian, Jetty and more. So Citrus is now working with up-to-date versions of the whole messaging and middleware integration gang.

### Upgrade from Citrus 2.2

Along with new features and improvements we refactored and changed some parts of Citrus so you might have to set things straight when upgrading to 2.3. See the following list of things that might be brought up to you:

*  **@CitrusTest annotation:** We have moved the **@CitrusTest** annotation to a more common package. The old package was **com.consol.citrus.dsl.annotations.CitrusTest** . The new package is **com.consol.citrus.annotations.CitrusTest** . So you have to change the Java import statements in your Test classes when upgrading.

*  **TestResult:** We changed the **TestResult** instantiation when generating the test reports. The **TestResult** class now works with static instantiation methods for success, skipped and failed tests. This only affects your code when you have created custom test reporters.

*  **CitrusTestBuilder deprecation:** A major refactoring was done in the **TestBuilder** Java DSL code. **com.consol.citrus.dsl.TestBuilder** and all its subclasses were marked as deprecated and will disappear in next versions. So instead we now support **com.consol.citrus.dsl.design.TestDesigner** which basically offers the same functionality as former TestBuilder. In addition that refactoring brought a new way of executing the Java DSL test cases. Instead of building the whole test case before execution is done as a whole you can now use the **com.consol.citrus.dsl.runner.TestRunner** implementation in order to execute each test action in the Java DSL immediately. This is a more Java like way of writing Citrus test cases as you can mix Citrus test action execution with normal Java statements as usual. Read more about the new approach in [testcase](testcase)



### Bugfixes

Bugs are part of our software developers world and fixing them is part of your daily business, too. Finding and solving issues makes Citrus better every day. For a detailed listing of all bugfixes please refer to the complete changes log of each release in JIRA ([http://www.citrusframework.org/changes-report.html](http://www.citrusframework.org/changes-report.html)).

