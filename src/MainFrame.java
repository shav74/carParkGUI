import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
        public MainFrame(){
            this.setTitle("Car Parking System");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new BorderLayout());
            this.setVisible(true);
            this.setSize(950, 600);
        }
}
