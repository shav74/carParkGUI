import javax.swing.*;
import java.awt.*;

public class ParkWindow {
    public JFrame frame = new JFrame();
    CarPark carPark = CarPark.getInstance();
    ParkWindow(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(new GridLayout(6,2,5,5));
        frame.setVisible(true);

        JTextField txtSlotID = new JTextField();
        JTextField txtRegNo = new JTextField();
        JTextField txtMake = new JTextField();
        JTextField txtModel = new JTextField();
        JTextField txtYear = new JTextField();

        frame.add(new JLabel("  Slot ID : "));
        frame.add(txtSlotID);

        frame.add(new JLabel("  Reg No : "));
        frame.add(txtRegNo);

        frame.add(new JLabel("  Make : "));
        frame.add(txtMake);

        frame.add(new JLabel("  Model : "));
        frame.add(txtModel);

        frame.add(new JLabel("  Year : "));
        frame.add(txtYear);

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Arial", Font.BOLD, 15));
        btnOk.setBackground(new Color(0x72AA72));
        btnOk.setBorder(BorderFactory.createEtchedBorder());
        btnOk.addActionListener(e -> {
            try{
                int year = Integer.parseInt(txtYear.getText());
                carPark.parkCar(
                        txtSlotID.getText(),
                        txtRegNo.getText(),
                        txtMake.getText(),
                        txtModel.getText(),
                        year
                );
            }catch (Exception ex){
                WindowSetup.setMessage("Model Year have to be an Integer");
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setBackground(new Color(0xBB7272));
        btnClear.setBorder(BorderFactory.createEtchedBorder());
        btnClear.addActionListener(e -> {
            txtSlotID.setText("");
            txtRegNo.setText("");
            txtMake.setText("");
            txtModel.setText("");
            txtYear.setText(null);
        });

        frame.add(new JPanel(new BorderLayout()).add(btnClear));
        frame.add(new JPanel(new BorderLayout()).add(btnOk));
    }
}
