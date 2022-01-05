package dev.rosen.clockj2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Settings {
    public static String backgroundColor = "#171717";
    public static String clockTextColor = "#FFFAFA";
    public static SortedMap<String, String> settings = new TreeMap<>();
    public static void LoadSettings() throws IOException {
        File settingsFile = new File("clocksettings.txt");
        if (!settingsFile.exists())
        {
            settingsFile.createNewFile();
            FileWriter writer = new FileWriter("clocksettings.txt");
            writer.write(
                    "backgroundColor:#171717" +
                            "\n" +
                            "clockTextColor:#FFFAFA"
            );
            writer.close();
        }
    }

}
