package models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");
        user.setPhone(123456789);
    }

    @Test
    public void testGetId() {
        assertEquals(1L, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId(2L);
        assertEquals(2L, user.getId());
    }

    @Test
    public void testGetUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testGetPhone() {
        assertEquals(123456789, user.getPhone());
    }

    @Test
    public void testSetPhone() {
        user.setPhone(987654321);
        assertEquals(987654321, user.getPhone());
    }

    @Test
    public void testUserConstructor() {
        User newUser = new User();
        assertNotNull(newUser);
    }
}

