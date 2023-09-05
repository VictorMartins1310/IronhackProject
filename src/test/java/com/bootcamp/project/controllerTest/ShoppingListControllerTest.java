package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.ShoppingListControllerImpl;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.ShoppingListProductsDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ShoppingListControllerImpl.class)
public class ShoppingListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private ShoppingListService shoppingListService;
    @MockBean private UserService userService;
    @MockBean private TodoListMapper shoppingLMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Test: Create Shopping List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateShoppingList() throws Exception {
        Long shopID = 1L;
        User user = new User("User@mail.de", "badPassword");

        String shopname = "Test";

        ShoppingList shoppingList = new ShoppingList(user, shopname);
        shoppingList.setTodoListID(shopID);

        ShoppingListDTO shoppingListDTO1 = new ShoppingListDTO();
        shoppingListDTO1.setMarketName(shopname);
        shoppingListDTO1.setTodoListName(shoppingList.getTodoListName());

        ShoppingListDTO shoppingListDTO2 = new ShoppingListDTO();
        shoppingListDTO2.setMarketName(shopname);
        shoppingListDTO2.setTodoListName(shoppingList.getTodoListName());


        when(shoppingLMapper.toDto(shoppingListService.newShoppingList(user, shopname))).thenReturn(shoppingListDTO1);
        System.out.println(objectMapper.writeValueAsString(shoppingList));
        System.out.println(objectMapper.writeValueAsString(shoppingListDTO1));
        System.out.println(objectMapper.writeValueAsString(shoppingListDTO2));
        mockMvc.perform(post("/todolist/shoppinglist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shoppingListDTO1)))

                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(shoppingListDTO2)));
    }
    @DisplayName("Test: Get All Shoppinglists")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testGetAllShoppingLists() throws Exception {
        Long shopID = 13L;
        User user = new User("User@mail.de", "badPassword");

        String shopname = "Test";

        ShoppingList shoppingList = new ShoppingList(user, shopname);
        shoppingList.setTodoListID(shopID);
        List<ShoppingList> shoppingLists = new ArrayList<>();
        shoppingLists.add(shoppingList);

        ShoppingListDTO shoppingListDTO = new ShoppingListDTO();
        shoppingListDTO.setMarketName(shopname);
        List<ShoppingListDTO> shoppingListDTOs = new ArrayList<>();
        shoppingLists.add(shoppingList);


        when(shoppingListService.getShoppingLists(user)).thenReturn(shoppingLists);

        mockMvc.perform(get("/todolist/shoppinglist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(shoppingListDTOs)));
    }
    @DisplayName("Test: Get Shoppinglists + Products")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testGetShoppingList() throws Exception {
        Long shopID = 13L;
        User user = new User("User@mail.de", "badPassword");

        String shopname = "Test";

        ShoppingList shoppingList = new ShoppingList(user, shopname);
        shoppingList.setTodoListID(shopID);

        ShoppingListProductsDTO shoppingListDTO = new ShoppingListProductsDTO();



        when(shoppingLMapper.toDTO(shoppingListService.getShoppingList(shopID))).thenReturn(shoppingListDTO);

        mockMvc.perform(get("/todolist/shoppinglist/{shopID}", shopID.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(shoppingListDTO)));
    }

    @DisplayName("Test: Update Shopping List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testUpdateShoppingList() throws Exception {
        Long id = 13L;
        User user = new User("User@mail.de", "badPassword");

        user.setUserID(UUID.randomUUID());

        String
                todolistname = "Test Shopping List",
                marketname = "Market Name",
                newmarketname = "New Market Name";


        ShoppingList shoppingListA = new ShoppingList(user, todolistname);
        shoppingListA.setTodoListID(id);
        shoppingListA.setTodoListName(todolistname);
        shoppingListA.setMarketName(marketname);

        ShoppingList shoppingListB = new ShoppingList(user, todolistname);
        shoppingListB.setTodoListID(id);
        shoppingListB.setTodoListName(todolistname);
        shoppingListB.setMarketName(newmarketname);

        System.out.println(objectMapper.writeValueAsString(shoppingListA));
        System.out.println(objectMapper.writeValueAsString(shoppingListB));

        when(shoppingListService.updateShoppingList(id, todolistname, marketname)).thenReturn(shoppingListB);

        mockMvc.perform(
                        patch("/todolist/shoppinglist/{id}", id.toString())
                                .queryParam("todolistname", todolistname)
                                .queryParam("marketname", newmarketname))
                .andExpect(status().isOk());
    }

    @DisplayName("Test: Delete Shopping List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testDeleteShoppingList() throws Exception {

        UUID uuid = UUID.randomUUID();
        User user = new User("email@mail.com", "DumpPass1234");
        user.setUserID(uuid);
        Long id = 13L;
        String todoListName1 = "TASK LIST TODO";
        String todoListName2 = "NEW TASK LIST NAME";
        ShoppingList shopList1 = new ShoppingList(user, todoListName1);
        ShoppingList shopList2 = new ShoppingList(user, todoListName2);

        shopList1.setTodoListID(id);
        shopList2.setTodoListID(id);

        System.out.println(objectMapper.writeValueAsString(shopList1));
        System.out.println(objectMapper.writeValueAsString(shopList2));

        when(shoppingListService.deleteShoppingLists(id)).thenReturn(true);
        mockMvc.perform(
                        delete("/todolist/shoppinglist/{id}", id.toString()))
                .andExpect(status().isNoContent());
    }


}