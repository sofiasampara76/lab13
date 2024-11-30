package ua.edu.ucu.apps.Task1.meta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class FacebookUser {
    private String userEmail;
    private String country;
    private LocalDate LastActiveTime;
}
