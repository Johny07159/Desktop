package epic.play;

import javax.swing.JTextArea;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DebugLoggerSwing {

    private static JTextArea logArea;

    public static void setLogArea(JTextArea area) {
        logArea = area;
        log("[Logger] Conectado à interface.");
    }

    public static void log(String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String fullMessage = "[DEBUG] " + time + ": " + message + "\n";

        System.out.print(fullMessage); // Também exibe no terminal

        if (logArea != null) {
            logArea.append(fullMessage);
            logArea.setCaretPosition(logArea.getDocument().getLength());
        }
    }

    public static void log(String message, Object extraData) {
        log(message);
        if (extraData != null && logArea != null) {
            logArea.append("           ↳ " + extraData.toString() + "\n");
        }
    }

    public static void clear() {
        if (logArea != null) {
            logArea.setText("");
        }
    }
}
