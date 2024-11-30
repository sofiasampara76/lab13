package ua.edu.ucu.apps.Task2;

public class DB extends БазаДаних {
    public String getUserData() {
        return super.отриматиДаніКористувача();
    }

    public String getStatisticalData() {
        return super.отриматиСтатистичніДані();
    }

    @Override @Deprecated
    public String отриматиДаніКористувача() {
        return super.отриматиДаніКористувача();
    }

    @Override @Deprecated
    public String отриматиСтатистичніДані() {
        return super.отриматиСтатистичніДані();
    }
}
