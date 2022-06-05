package com.encrypt.starter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class EncryptApplicationTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        System.out.println("################################################");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/user")//get请求方法
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)//请求内容类型
                                .param("username","Li Da Hai2"))//参数
                .andExpect(MockMvcResultMatchers.status().isOk())//期望返回状态200
                .andDo(MockMvcResultHandlers.print())//指定打印信息
                .andReturn();//返回值
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void test2() throws Exception {
//        ObjectMapper om = new ObjectMapper();
//        User user = new User((long)101, "dahai");
//        String s = om.writeValueAsString(user);
//        System.out.println(s);
        String str = "z3ZUAauk0UHOUNXMfDRTqlBUUL1gCQNe6wHpPNY29oFusPxYlQXFd35DJUnuvjX+";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
