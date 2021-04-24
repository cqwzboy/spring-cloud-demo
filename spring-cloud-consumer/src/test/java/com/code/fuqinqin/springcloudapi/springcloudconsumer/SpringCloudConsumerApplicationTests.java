package com.code.fuqinqin.springcloudapi.springcloudconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = {SpringCloudConsumerApplication.class})
@WebAppConfiguration
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
@Slf4j
public class SpringCloudConsumerApplicationTests extends AbstractTestNGSpringContextTests {

}
