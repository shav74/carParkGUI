import javax.swing.*;
import java.awt.*;

public class SlotsPanel {
    public static JPanel panelSlots = new JPanel(new GridLayout(2,4,5,5));
    public void setSlotsPanel(JPanel mainFrame){
        JPanel mainFrameSlots = new JPanel();
        mainFrameSlots.setLayout(new BorderLayout());

//        JPanel panelNav = new JPanel(new FlowLayout(FlowLayout.TRAILING));
//        panelNav.setPreferredSize(new Dimension(100,32));
        JButton btnPrev = new JButton("Prev");
        JButton btnNext = new JButton("Next");
//        panelNav.add(btnPrev);
//        panelNav.add(btnNext);

        mainFrameSlots.add(panelSlots, BorderLayout.CENTER);
//        mainFrameSlots.add(panelNav, BorderLayout.SOUTH);
        mainFrame.add(mainFrameSlots);
    }

    public static void setupSlots(){
        if (!CarPark.parkingSlots.isEmpty()){
        panelSlots.removeAll();
            for (ParkingSlot slot : CarPark.parkingSlots) {
                JPanel panelDetails = new JPanel(new GridLayout(3,1));
                panelDetails.add(new JLabel(" Slot ID: " + slot.getSlotID()));
                if (slot.isOccupied()) {
                    Car car = slot.getParkedCar();
                    panelDetails.setBackground(Color.PINK);
                    panelDetails.add(new JLabel(" Occupied by: " + car.getRegistrationNumber()));
                    panelDetails.add(new JLabel(" Make: " + car.getMake()));
                    panelSlots.add(panelDetails);
                } else {
                    panelDetails.setBackground(Color.lightGray);
                    panelDetails.add(new JLabel(" Slot is Empty"));
                    panelSlots.add(panelDetails);
                }
            }
        }else{
            WindowSetup.setMessage(" No slots in the list");
        }
        panelSlots.revalidate();
        panelSlots.repaint();
        panelSlots.getParent().revalidate();
        panelSlots.getParent().repaint();
    }
}
