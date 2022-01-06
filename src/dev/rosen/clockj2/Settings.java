package dev.rosen.clockj2;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Settings {
    public static String defaultBackgroundColor = "#171717";
    public static String defaultClockTextColor = "#FFFAFA";
    private static String settingsFileName = "clocksettings.txt";
    public static Map<String, String> settings = new HashMap<>();
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
            settings.put("seconds", "false");
            String optionsString = "";
            Integer settingsIteration = 0;
            for (Map.Entry<String, String> entry: settings.entrySet()) {
                settingsIteration += 1;
                optionsString += entry.getKey() + ":" + entry.getValue() + (!(settingsIteration == settings.keySet().size()) ? "\n" : "");
            }
            writer.write(
                    optionsString
            );
            writer.close();
        }
        else {

            String data = readFileAsString(settingsFileName);
            for (String i: data.split("\n")) {
                try {
                    String setting = i.split(":")[0];
                    String value = i.split(":")[1];
                    settings.put(setting, value);
                } catch(Exception e) {
                    File file = new File(Settings.settingsFileName);
                    file.delete();
                    System.out.println("Restart your ClockJ2.");
                    System.exit(0);
                }

            }

        }
    }
    public static String getOptionStringValue(String option, String _default)
    {
        if (settings.get(option) != null) {
            return settings.get(option);
        }
        else {
            return _default;
        }
    }
    public static Boolean getOptionBoolValue(String option, Boolean _default)
    {
        if (settings.get(option) != null)
        {
            return Boolean.parseBoolean(settings.get(option));
        }
        else {
            return _default;
        }
    }

}
