package ua.edu.ucu.apps.Task1.myuser;

import java.time.LocalDate;

public interface User {
    public String getEmail();
    public LocalDate getLastActiveTime();
    public String getCountry();
}
