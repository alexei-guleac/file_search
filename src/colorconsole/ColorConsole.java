package colorconsole;

import java.awt.*;

public class ColorConsole {

    //цветной вывод в консоль
    public static void colorSystemOut(String text, Color color, boolean bold, boolean underlined) {
        StringBuilder cString = new StringBuilder("\033[");

        if (color == Color.WHITE) {
            cString.append("30");
        } else if (color == Color.RED) {
            cString.append("31");
        } else if (color == Color.GREEN) {
            cString.append("32");
        } else if (color == Color.YELLOW) {
            cString.append("33");
        } else if (color == Color.BLUE) {
            cString.append("34");
        } else if (color == Color.MAGENTA) {
            cString.append("35");
        } else if (color == Color.CYAN) {
            cString.append("36");
        } else if (color == Color.GRAY) {
            cString.append("37");
        } else {
            cString.append("30");
        }

        if (bold) {
            cString.append(";1");
        }
        if (underlined) {
            cString.append(";4");
        }

        cString.append(";0m" + text + "\033[0m");
        System.out.print(cString.toString());
    }
}
