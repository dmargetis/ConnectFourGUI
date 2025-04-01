import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    Font font = new Font("Arial", Font.PLAIN, 35);

    public Cell(String s) {
        super(s);
        setFocusPainted(false);
        setFont(font);
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
    }
}
