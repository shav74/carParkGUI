import javax.swing.*;
import java.awt.*;

public class AddSlot {
    CarPark carPark = CarPark.getInstance();

    public JFrame frame = new JFrame();
    AddSlot(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,200);
        frame.setLayout(new GridLayout(2,2,5,5));
        frame.setVisible(true);

        JTextField txtSlotID = new JTextField();
        txtSlotID.setFont(new Font("Arial", Font.BOLD, 17));


        frame.add(new JLabel("  Slot ID : "));
        frame.add(txtSlotID);

        JButton btnOk = new JButton("Add Slot");
        btnOk.setFont(new Font("Arial", Font.BOLD, 15));
        btnOk.setBackground(new Color(0x72AA72));
        btnOk.setBorder(BorderFactory.createEtchedBorder());
        btnOk.addActionListener(e -> {
                carPark.addParkingSlot(txtSlotID.getText());
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setBackground(new Color(0xBB7272));
        btnClear.setBorder(BorderFactory.createEtchedBorder());
        btnClear.addActionListener(e -> {
            txtSlotID.setText("");
        });

        frame.add(new JPanel(new BorderLayout()).add(btnClear));
        frame.add(new JPanel(new BorderLayout()).add(btnOk));
    }
}
