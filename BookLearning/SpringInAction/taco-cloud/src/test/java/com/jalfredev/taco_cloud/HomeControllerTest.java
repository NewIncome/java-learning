package com.jalfredev.taco_cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


// @WebMvcTest implicitly handles the Spring context setup,
// so you don't need to specify an @ExtendWith annotation directly.
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;        // Injects MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))           // Performs GET /
                .andExpect(status().isOk())            // Expects HTTP 200
                .andExpect(view().name("home"))     // Expects home view
                .andExpect(content().string(
                        containsString("Welcome to...")     // Expects Welcome to...
                ));
    }
}
/* *
 * • When using Spring Boot's @WebMvcTest (and other @...Test annotations), 
 * the necessary extension (SpringExtension) is implicitly registered, so
 * you don't even need to include the @ExtendWith annotation. This makes
 * the code cleaner.
 * 
 * • While not required, test methods in JUnit 5 do not need to be public.
 * You can declare them with default (package-private) visibility.
 */