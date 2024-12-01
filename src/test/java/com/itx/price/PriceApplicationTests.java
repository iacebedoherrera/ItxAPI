package com.itx.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


@SpringBootTest
@AutoConfigureMockMvc
class PriceApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	// Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2024-06-14T10:00:00")
				.with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

	// Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2024-06-14T16:00:00")
				.with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    // Petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	@Test
    public void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2024-06-14T21:00:00")
				.with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	@Test
    public void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2024-06-15T10:00:00")
				.with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    // Petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	@Test
    public void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2024-06-16T21:00:00")
				.with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }

}
