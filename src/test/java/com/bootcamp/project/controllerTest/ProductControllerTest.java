package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.ProductControllerImpl;
import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.ShoppingListProductsDTO;
import com.bootcamp.project.mappers.ProductMapper;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ProductType;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ProductService;
import com.bootcamp.project.service.ShoppingListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ProductControllerImpl.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private TodoListMapper shoppingLMapper;
    @MockBean
    private ProductService productService;
    @MockBean
    private ShoppingListService shoppingLService;
    @MockBean
    private ProductMapper productMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Test: Create a Product")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test
    public void testCreateProduct() throws Exception {
        Long id = 13L;
        String name = "Coca Cola",
                brand = "Coca Cola Company";
        int qty = 4;
        ProductType productType = ProductType.Drink;
        BigDecimal price = new BigDecimal("1.23");

        User user = new User();

        ShoppingList shoppingList = new ShoppingList(user, "Test Market");
        shoppingList.setTodoListID(id);

        Product product1 = new Product();
        product1.setName(name);
        product1.setBrand(brand);
        product1.setPrice(price);
        product1.setQty(qty);
        product1.setType(productType);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setBrand(brand);
        productDTO.setPrice(price);
        productDTO.setQty(qty);
        productDTO.setType(productType);

        ShoppingListProductsDTO shoppingListProductsDTO = new ShoppingListProductsDTO();

        when(shoppingLMapper.toDTO(shoppingLService.addProduct2List(id, product1))).thenReturn(shoppingListProductsDTO);
        mockMvc.perform(post("/todolist/shoppinglist/{idOfShoppingList}/products", id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(shoppingListProductsDTO)));
    }
    @DisplayName("Test: Update a Product")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test
    public void testUpdateProduct() throws Exception {
        Long id = 13L;
        String nameA = "Coca Cola",
                nameB = "Pepsi",
                brand = "Coca Cola Company";
        int qty = 4;
        ProductType productType = ProductType.Drink;
        String price = "1.23";

        Product product1 = new Product();
        product1.setProductID(id);
        product1.setName(nameA);
        product1.setBrand(brand);
        product1.setPrice(new BigDecimal(price));
        product1.setQty(qty);
        product1.setType(productType);

        Product product2 = new Product();
        product2.setProductID(id);
        product2.setName(nameB);
        product2.setBrand(brand);
        product2.setPrice(new BigDecimal(price));
        product2.setQty(qty);
        product2.setType(productType);

        when(productService.updateProduct(product1.getProductID(), nameB, null, null)).thenReturn(product2);
        mockMvc.perform(patch("/todolist/shoppinglist/{idOfShoppingList}/product/{id}", id.toString(), id.toString())
                        .queryParam("name", nameB))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(product2)));
    }
}
