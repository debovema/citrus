/*
 * Copyright 2006-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.samples.greeting.jms;

import org.testng.ITestContext;
import org.testng.annotations.*;

import com.consol.citrus.testng.AbstractTestNGCitrusTest;

/**
 * @author Christoph Deppisch
 * @since 2010
 */
public class GreetingJmsTest extends AbstractTestNGCitrusTest {

    private GreetingJmsDemo demo = new GreetingJmsDemo();
    
    @BeforeSuite(alwaysRun = true)
    public void startDemoApplication(ITestContext testContext) throws Exception {
        demo.start();
    }
    
    @AfterSuite(alwaysRun = true)
    public void stopDemoApplication(ITestContext testContext) {
        demo.stop();
    }
    
    @Test
    public void greetingJmsTest(ITestContext testContext) {
        executeTest(testContext);
    }
    
}
