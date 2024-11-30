package ua.edu.ucu.apps.Task2;

public class Authorization extends Авторизація {

    public boolean authorize(DB db) {
        return super.авторизуватися(db);
    }

    @Override @Deprecated
    public boolean авторизуватися(БазаДаних db) {
        return super.авторизуватися(db);
    }
    
}
