package com.example.projetotdd.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projetotdd.model.Produto;

@WebMvcTest
public class ProdutoControllerTest {
    // MockMvc
    // Mockito
    // Mock

    @Autowired
    private ProdutoController produtoController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // Aqui será executado antes de qualquer caso de teste
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();

    }

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_o_metodo_obter_todos() throws Exception {
        // Arrange (Preparação)
        // List<Produto> produtos = new ArrayList<Produto>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");

        // Act (Ação)
        this.mockMvc.perform(requestBuilder)
                // Assert (Confirmação)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
