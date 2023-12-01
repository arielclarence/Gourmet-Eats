package fontys.sem3.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fontys.sem3.school.business.CuisineUseCase;
import fontys.sem3.school.configuration.security.token.AccessTokenDecoder;
import fontys.sem3.school.controller.CuisinesController;
import fontys.sem3.school.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CuisinesController.class)
class CuisinesControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CuisineUseCase cuisineUseCase;
//    @MockBean
//    private AccessTokenDecoder accessTokenDecoder;
//    @Test
//    void testGetCuisines() throws Exception {
//        // Arrange
//        when(cuisineUseCase.getCuisines()).thenReturn(GetCuisinesResponse.builder().cuisines(List.of()).build());
//
//        // Act
//        ResultActions result = mockMvc.perform(get("/cuisine"));
//
//        // Assert
//        result.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.cuisines").isArray())
//                .andExpect(jsonPath("$.cuisines").isEmpty());
//
//        // Verify
//        verify(cuisineUseCase, times(1)).getCuisines();
//    }
//
//    @Test
//    void testGetCuisine() throws Exception {
//        // Arrange
//        long cuisineId = 1L;
//        when(cuisineUseCase.getCuisine(cuisineId)).thenReturn(Optional.of(Cuisine.builder().id(cuisineId).cuisineName("Test Cuisine").build()));
//
//        // Act
//        ResultActions result = mockMvc.perform(get("/cuisine/{id}", cuisineId));
//
//        // Assert
//        result.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(cuisineId))
//                .andExpect(jsonPath("$.cuisineName").value("Test Cuisine"));
//
//        // Verify
//        verify(cuisineUseCase, times(1)).getCuisine(cuisineId);
//    }
//
//    @Test
//    void testDeleteCuisine() throws Exception {
//        // Arrange
//        long cuisineId = 1L;
//
//        // Act
//        ResultActions result = mockMvc.perform(delete("/cuisine/{id}", cuisineId));
//
//        // Assert
//        result.andExpect(status().isNoContent());
//
//        // Verify
//        verify(cuisineUseCase, times(1)).deleteCuisine(cuisineId);
//    }
//
//    @Test
//    void testCreateCuisine() throws Exception {
//        // Arrange
//        CreateCuisineRequest request = new CreateCuisineRequest("Test Cuisine");
//        CreateCuisineResponse response = CreateCuisineResponse.builder().id(1L).build();
//        when(cuisineUseCase.createCuisine(request)).thenReturn(response);
//
//        // Act
//        ResultActions result = mockMvc.perform(post("/cuisine")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(request)));
//
//        // Assert
//        result.andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1));
//
//        // Verify
//        verify(cuisineUseCase, times(1)).createCuisine(request);
//    }
//
//    @Test
//    void testUpdateCuisine() throws Exception {
//        // Arrange
//        long cuisineId = 1L;
//        UpdateCuisineRequest request = new UpdateCuisineRequest(cuisineId, "Updated Test Cuisine");
//        doNothing().when(cuisineUseCase).updateCuisine(request);
//
//        // Act
//        ResultActions result = mockMvc.perform(put("/cuisine/{id}", cuisineId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(request)));
//
//        // Assert
//        result.andExpect(status().isNoContent());
//
//        // Verify
//        verify(cuisineUseCase, times(1)).updateCuisine(request);
//    }
}
