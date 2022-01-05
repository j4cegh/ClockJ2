package dev.rosen.clockj2;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Settings.LoadSettings();
        Clock _c = new Clock();
        _c.Create();
    }
}
