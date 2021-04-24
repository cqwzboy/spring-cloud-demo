package com.code.fuqinqin.springcloudapi.springcloudconsumer.controller;

import com.code.fuqinqin.springcloudapi.springcloudconsumer.SpringCloudConsumerApplicationTests;
import com.code.fuqinqin.springcloudapi.springcloudconsumer.feign.IHelloClient;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConsumerControllerTest extends SpringCloudConsumerApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private IHelloClient helloClient;

    @BeforeClass
    public void beforeClass() {
        logger.info("-- beforeClass --");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Mockito.when(helloClient.sayHello())
                .thenAnswer((Answer<String>) invocationOnMock -> "Hello TestNG...");
    }


    @Test
    public void consumerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consumer/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
