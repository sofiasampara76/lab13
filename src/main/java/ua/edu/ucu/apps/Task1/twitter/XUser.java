package ua.edu.ucu.apps.Task1.twitter;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class XUser {
    private String email;
    private XCountry userCountry;
    private LocalDate userActiveTime;
}
