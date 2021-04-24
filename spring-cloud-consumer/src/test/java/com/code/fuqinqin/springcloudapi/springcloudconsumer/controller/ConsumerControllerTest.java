package com.code.fuqinqin.springcloudapi.springcloudconsumer.controller;

import com.code.fuqinqin.springcloudapi.request.UserInfoRequest;
import com.code.fuqinqin.springcloudapi.response.UserInfoResponse;
import com.code.fuqinqin.springcloudapi.springcloudconsumer.SpringCloudConsumerApplicationTests;
import com.code.fuqinqin.springcloudapi.springcloudconsumer.feign.IHelloClient;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
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
        Mockito.when(helloClient.getUserInfo(Mockito.any(UserInfoRequest.class)))
                .thenAnswer((Answer<UserInfoResponse>) this::getUserInfoResponse);
        Mockito.when(helloClient.getUserInfo2(Mockito.any(UserInfoRequest.class)))
                .thenAnswer((Answer<UserInfoResponse>) this::getUserInfoResponse);
    }

    private UserInfoResponse getUserInfoResponse(InvocationOnMock invocationOnMock) {
        UserInfoRequest request = invocationOnMock.getArgument(0);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUserId(request.getUserId());
        userInfoResponse.setUserName(request.getUserName());
        userInfoResponse.setAge(request.getAge());
        return userInfoResponse;
//                    return UserInfoResponse.builder()
//                            .userId(request.getUserId())
//                            .userName(request.getUserName())
//                            .age(request.getAge())
//                            .build();
    }

    @Test
    public void consumerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consumer/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userInfoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consumer/user-info")
                        .param("userId", "1001")
                        .param("userName", "zhangsan")
                        .param("age", "23")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userInfoTest2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consumer/user-info2")
                .param("userId", "1002")
                .param("userName", "lisi")
                .param("age", "24")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
