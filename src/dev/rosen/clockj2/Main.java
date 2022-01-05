package dev.rosen.clockj2;

public class Main {

    public static void main(String[] args) throws Exception {
        Settings.LoadSettings();
        Clock _c = new Clock();
        _c.Create();
    }
}
