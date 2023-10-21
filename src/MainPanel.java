import javax.swing.*;
import java.awt.*;

public class MainPanel {

    public void setMainPanel(JPanel panelMain){
        CarPark carPark = CarPark.getInstance();
        panelMain.setLayout(new GridLayout(2,1));

        //creating the interface for main options
        JPanel panelMainInterface = new JPanel();
        panelMainInterface.setLayout(new GridLayout(1,4,10,10));

        JPanel panelParkCar = new JPanel(new GridLayout(4,1,5,5));
        JPanel panelFindByReg = new JPanel(new GridLayout(4,1,5,5));
        JPanel panelRemoveByReg = new JPanel(new GridLayout(4,1,5,5));
        JPanel panelFindByMake = new JPanel(new GridLayout(4,1,5,5));

        JLabel lblParkCar = new JLabel("Park a Car");
        lblParkCar.setHorizontalAlignment(JLabel.CENTER);
        lblParkCar.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lblFindByReg = new JLabel("Find a Car by Reg.No");
        lblFindByReg.setHorizontalAlignment(JLabel.CENTER);
        lblFindByReg.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lblRemByReg = new JLabel("Remove a Car by Reg.No");
        lblRemByReg.setHorizontalAlignment(JLabel.CENTER);
        lblRemByReg.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lblFindByMake = new JLabel("Find a Car by its Make");
        lblFindByMake.setHorizontalAlignment(JLabel.CENTER);
        lblFindByMake.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField txtFindByReg = new JTextField();
        txtFindByReg.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField txtRemByReg = new JTextField();
        txtRemByReg.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField txtFindByMake = new JTextField();
        txtFindByMake.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnParkCar = new JButton("Park");
        btnParkCar.addActionListener(e -> {
            new ParkWindow();
        });
        btnParkCar.setFocusable(false);
        btnParkCar.setFont(new Font("Arial", Font.BOLD, 15));
        btnParkCar.setBackground(new Color(0x72AA72));
        btnParkCar.setBorder(BorderFactory.createEtchedBorder());

        JButton btnAddSlot = new JButton("Add Slot");
        btnAddSlot.addActionListener(e -> {
            new AddSlot();
        });
        btnAddSlot.setFocusable(false);
        btnAddSlot.setFont(new Font("Arial", Font.BOLD, 15));
        btnAddSlot.setBackground(new Color(0x197E94));
        btnAddSlot.setBorder(BorderFactory.createEtchedBorder());

        JButton btnRemSlot = new JButton("Delete Slot");
        btnRemSlot.addActionListener(e -> {
            new RemoveSlot();
        });
        btnRemSlot.setFocusable(false);
        btnRemSlot.setFont(new Font("Arial", Font.BOLD, 15));
        btnRemSlot.setBackground(new Color(0xBB7272));
        btnRemSlot.setBorder(BorderFactory.createEtchedBorder());

        JButton btnFindByReg = new JButton("Find");
        btnFindByReg.setFocusable(false);
        btnFindByReg.setFont(new Font("Arial", Font.BOLD, 15));
        btnFindByReg.setBackground(new Color(0x197E94));
        btnFindByReg.setBorder(BorderFactory.createEtchedBorder());
        btnFindByReg.addActionListener(e -> {
            carPark.findCarByRegistrationNumber(txtFindByReg.getText());
            txtFindByReg.setText("");
        });

        JButton btnRemByReg = new JButton("Remove");
        btnRemByReg.setFocusable(false);
        btnRemByReg.setFont(new Font("Arial", Font.BOLD, 15));
        btnRemByReg.setBackground(new Color(0x197E94));
        btnRemByReg.setBorder(BorderFactory.createEtchedBorder());
        btnRemByReg.addActionListener(e -> {
            carPark.removeCarByRegistrationNumber(txtRemByReg.getText());
            txtRemByReg.setText("");
        });

        JButton btnFindByMake = new JButton("Find by Make");
        btnFindByMake.setFocusable(false);
        btnFindByMake.setFont(new Font("Arial", Font.BOLD, 15));
        btnFindByMake.setBackground(new Color(0x197E94));
        btnFindByMake.setBorder(BorderFactory.createEtchedBorder());
        btnFindByMake.addActionListener(e -> {
            carPark.findCarsByMake(txtFindByMake.getText());
            txtFindByMake.setText("");
        });


        JPanel panelManageSlots = new JPanel(new GridLayout(2,1,5,5));
        panelManageSlots.add(btnAddSlot);
        panelManageSlots.add(btnRemSlot);

        panelParkCar.add(lblParkCar);
        panelParkCar.add(btnParkCar);
        panelParkCar.add(panelManageSlots);


        panelFindByReg.add(lblFindByReg);
        panelFindByReg.add(txtFindByReg);
        panelFindByReg.add(btnFindByReg);

        panelRemoveByReg.add(lblRemByReg);
        panelRemoveByReg.add(txtRemByReg);
        panelRemoveByReg.add(btnRemByReg);

        panelFindByMake.add(lblFindByMake);
        panelFindByMake.add(txtFindByMake);
        panelFindByMake.add(btnFindByMake);

        panelMainInterface.add(panelParkCar);
        panelMainInterface.add(panelFindByReg);
        panelMainInterface.add(panelRemoveByReg);
        panelMainInterface.add(panelFindByMake);

        panelMain.add(panelMainInterface);
    }
}
