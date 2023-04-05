package com.milkman.appbackend;

import com.milkman.appbackend.data.entity.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class ApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }



    @Test
    @Order(1)
    void testCreateOrder() throws Exception {
        String requestBody = "{\"orderName\": \"Sample Order\", \"orderNumber\": 12345, \"orderStatus\": \"PENDING\", \"retry\": 0, \"supplier\": {\"id\": 1, \"name\": \"Supplier 1\"}}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/orders/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void testUpdateOrder() throws Exception {
        String requestBody = "{\"orderName\": \"Updated Order\", \"orderNumber\": 12346, \"orderStatus\": \"COMPLETED\", \"retry\": 1, \"supplier\": {\"id\": 1, \"name\": \"Supplier 1\"}}";

        mockMvc.perform(put("/api/orders/update/{orderId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void testGetOrders() throws Exception {
        mockMvc.perform(get("/api/orders/getOrders")
                        .param("status", "COMPLETED"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderStatus").value(OrderStatus.COMPLETED.toString()));
    }
}

