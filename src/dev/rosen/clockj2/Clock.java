package dev.rosen.clockj2;

import javax.swing.*;
import java.awt.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Clock extends JFrame {
    JFrame _clock; // Window frame
    FrameHelper frameHelper; // Framehelper instance
    JLabel timeLabel; // The label that shows the time
    ClockLogic clockLogic; // ClockLogic instance


    private void FrameSettings()
    {
        frameHelper = new FrameHelper(_clock);
        frameHelper.SetBGHex(Settings.backgroundColor);
        frameHelper.MaxFullScreen();
        frameHelper.UndecoratedWindowStyle();
        frameHelper.SetOnClose();
    }
    private void InitControls()
    {
        timeLabel = new JLabel("", SwingConstants.CENTER);
        clockLogic = new ClockLogic(timeLabel, _clock);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 250));
        frameHelper.SetJCColHex(timeLabel, Settings.clockTextColor);

        _clock.add(timeLabel);
        clockLogic.Handle();
    }

    public void Create()
    {
        Settings.settings.put("a", "b");
        for(String i : Settings.settings.keySet())
        {
            System.out.println(i);
        }
        _clock = new JFrame("ClockJ2 - A complete rewrite");
        FrameSettings();
        InitControls();
        frameHelper.ShowFrame();
    }
}
