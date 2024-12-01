package ua.edu.ucu.apps.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.Task1.meta.FacebookUser;
import ua.edu.ucu.apps.Task1.myuser.MyFacebookUser;
import ua.edu.ucu.apps.Task1.myuser.MyXUser;
import ua.edu.ucu.apps.Task1.twitter.XCountry;
import ua.edu.ucu.apps.Task1.twitter.XUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private MyFacebookUser myFacebookUser;
    private MyXUser myXUser;

    @BeforeEach
    void setUp() {
        FacebookUser facebookUser = new FacebookUser(
                "user@facebook.com", 
                "Ukraine", 
                LocalDate.of(2024, 11, 29)
        );
        myFacebookUser = new MyFacebookUser(facebookUser);

        XUser xUser = new XUser(
                "user@x.com", 
                XCountry.UKRAINE, 
                LocalDate.of(2024, 11, 30)
        );
        myXUser = new MyXUser(xUser);
    }

    @Test
    void testMyFacebookUser_getEmail() {
        assertEquals("user@facebook.com", myFacebookUser.getEmail());
    }

    @Test
    void testMyFacebookUser_getCountry() {
        assertEquals("Ukraine", myFacebookUser.getCountry());
    }

    @Test
    void testMyFacebookUser_getLastActiveTime() {
        assertEquals(LocalDate.of(2024, 11, 29), myFacebookUser.getLastActiveTime());
    }

    @Test
    void testMyXUser_getEmail() {
        assertEquals("user@x.com", myXUser.getEmail());
    }

    @Test
    void testMyXUser_getCountry() {
        assertEquals("UKRAINE", myXUser.getCountry());
    }

    @Test
    void testMyXUser_getLastActiveTime() {
        assertEquals(LocalDate.of(2024, 11, 30), myXUser.getLastActiveTime());
    }
}
