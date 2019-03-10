package questionnaire.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class User")
class UserTest {

    @Test
    @DisplayName("creates correctly")
    void userNameSurname(){
        User user = new User("Vasya","Sidorov");
        assertEquals("Sidorov", user.getSurname());
        assertThat(user).hasFieldOrPropertyWithValue("name","Vasya");
    }
}
