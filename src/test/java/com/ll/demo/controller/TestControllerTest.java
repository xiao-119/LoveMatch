package com.ll.demo.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import com.ll.demo.common.R;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
@AutoConfigureMybatisPlus
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TestController testController;

    //    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }


    @Test
    void testTestGet() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/test/test")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        String expected = JSONUtil.toJsonStr(JSONUtil.parseObj(R.success("Hello World"), false));
        assertThat(response.getContentAsString()).isEqualTo(expected);

        System.out.println(expected);
    }
}
