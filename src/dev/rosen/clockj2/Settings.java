package dev.rosen.clockj2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Settings {
    public static String defaultBackgroundColor = "#171717";
    public static String defaultClockTextColor = "#FFFAFA";
    private static String settingsFileName = "clocksettings.txt";
    public static Map<String, String> settings = new HashMap<String, String>();
    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    public static void LoadSettings() throws Exception {
        File settingsFile = new File(settingsFileName);

        if (!settingsFile.exists())
        {
            settingsFile.createNewFile();
            FileWriter writer = new FileWriter(settingsFileName);

            // Set the defaults
            settings.put("backgroundColor", defaultBackgroundColor);
            settings.put("clockTextColor", defaultClockTextColor);
            writer.write(
                    "backgroundColor:" + defaultBackgroundColor +
                            "\n" +
                            "clockTextColor:" + defaultClockTextColor
            );
            writer.close();
        }
        else {
            String data = readFileAsString(settingsFileName);
            for (String i: data.split("\n")) {
                String setting = i.split(":")[0];
                String value = i.split(":")[1];
                settings.put(setting, value);
            }

        }
    }
    public static String getOptionValue(String option, String _default)
    {
        if (settings.get(option) != null) {
            return settings.get(option);
        }
        else {
            return _default;
        }
    }

}
