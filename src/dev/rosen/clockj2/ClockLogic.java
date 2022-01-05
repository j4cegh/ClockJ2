package dev.rosen.clockj2;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockLogic {
    static JLabel _timeLbl;
    static JFrame _frame;
    static Preferences _prefs;

    public ClockLogic(JLabel label, JFrame frame)
    {
        _timeLbl = label;
        _frame = frame;
    }

    public static void Handle()
    {

        new Thread(() -> {
            while(true)
            {
                Calendar cal = new GregorianCalendar();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);
                int sec = cal.get(Calendar.SECOND);

                String time = String.format("%02d", hour) +
                        ":" +
                        String.format("%02d", min) +
                        (Preferences.withSeconds ? ":" + String.format("%02d", sec) : "");

                _timeLbl.setText(time);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) { }

            }
        }).start();
    }
}
