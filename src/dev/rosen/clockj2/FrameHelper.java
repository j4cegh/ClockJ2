package dev.rosen.clockj2;

import javax.swing.*;
import java.awt.*;

/**
 * A shortcut library for using JFrame easier.
 */
public class FrameHelper {
    JFrame _frame;

    /**
     * Initialize the class.
     * @param frame The JFrame you're going to use.
     */
    public FrameHelper(JFrame frame)
    {
        _frame = frame;
    }

    /**
     * Self-explanatory, takes hex and returns Color
     * @param hex Hex string
     * @return Color
     */
    private Color HexToColor(String hex) { return Color.decode(hex); }
    /**
     * Set the background's color to a hex provided as a parameter.
     * @param hex The hex color.
     */
    public void SetBGHex(String hex)
    {
        _frame.getContentPane().setBackground(HexToColor(hex));
    }

    public void SetJCColHex(JComponent jComponent, String hex) { jComponent.setForeground(HexToColor(hex)); }
    /**
     * Set the frame to "full fullscreen": uses maximum resolution of the monitor.
     */
    public void MaxFullScreen()
    {
        _frame.setExtendedState(_frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Show the frame.
     */
    public void ShowFrame()
    {
        _frame.setVisible(true);
    }

    /**
     * Remove the frame's decorations, works good with custom decorations or <code><strong>MaxFullScreen()</strong></code>.
     */
    public void UndecoratedWindowStyle()
    {
        _frame.setUndecorated(true);
    }

    /**
     * Tells the frame to close properly.
     */
    public void SetOnClose() { _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); }
}
