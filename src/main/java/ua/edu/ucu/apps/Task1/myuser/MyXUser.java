package ua.edu.ucu.apps.Task1.myuser;

import java.time.LocalDate;

import ua.edu.ucu.apps.Task1.meta.FacebookUser;
import ua.edu.ucu.apps.Task1.twitter.XUser;

public class MyXUser implements User {
    private XUser xUser;
    public MyXUser(XUser facebookUser) {
        this.xUser = facebookUser;
    }

    @Override
    public String getEmail() {
        return xUser.getEmail();
    }

    @Override
    public String getCountry() {
        return xUser.getUserCountry().toString();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return xUser.getUserActiveTime();
    }
}
