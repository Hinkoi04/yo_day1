package com.yo.day1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class SwaggerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSwagger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs"))
               .andDo(org.springframework.test.web.servlet.result.MockMvcResultHandlers.print());
    }
}
