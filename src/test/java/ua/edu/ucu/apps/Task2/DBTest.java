package ua.edu.ucu.apps.Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void testБазаДанихMethods() {
        БазаДаних db = new БазаДаних();
        assertEquals("hello", db.отриматиДаніКористувача(), "отриматиДаніКористувача() should return 'hello'");
        assertEquals("hello2", db.отриматиСтатистичніДані(), "отриматиСтатистичніДані() should return 'hello2'");
    }

    @Test
    void testDBOverrides() {
        DB db = new DB();
        assertEquals("hello", db.getUserData(), "getUserData() should return 'hello'");
        assertEquals("hello2", db.getStatisticalData(), "getStatisticalData() should return 'hello2'");
    }

    @Test
    void testАвторизаціяMethod() {
        Авторизація auth = new Авторизація();
        БазаДаних db = new БазаДаних();
        assertTrue(auth.авторизуватися(db), "авторизуватися() should return true");
    }

    @Test
    void testAuthorizationOverrides() {
        Authorization auth = new Authorization();
        DB db = new DB();
        assertTrue(auth.authorize(db), "authorize() should return true");
    }

    @Test
    void testReportBuilderInitialization() {
        БазаДаних db = new БазаДаних();
        ReportBuilder builder = new ReportBuilder(db);
        assertNotNull(builder, "ReportBuilder should be initialized successfully");
    }

    @Test
    void testMainExecution() {
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            fail("Main method should run without exceptions");
        }
    }
}
