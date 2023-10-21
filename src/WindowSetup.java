import javax.swing.*;
import java.awt.*;

public class WindowSetup {
   public JPanel panelTop = new JPanel();
   JPanel panelBottom = new JPanel();
   JPanel panelMain = new JPanel();

   JLabel title;
   JLabel logoLabel = new JLabel();
   static JLabel message = new JLabel("-");
   JButton btnClearMessages;
   public static JPanel panelMainMessage;

   public void setMainWindow(JFrame frame){

        title = new JLabel("Parking Spot System");
        title.setFont(new Font("Ariel", Font.BOLD, 25));

       panelTop.setPreferredSize(new Dimension(100,50));
       panelBottom.setPreferredSize(new Dimension(100,100));
       panelMain.setPreferredSize(new Dimension(100,100));

       //setting up panel top
       panelTop.setLayout(new FlowLayout());
       panelTop.add(title);

       //setting up the bottom panel for messages
       panelBottom.setLayout(new BorderLayout(0,5));
       JPanel panelTopMessage = new JPanel();
       panelMainMessage = new JPanel(new FlowLayout());
       JPanel panelRightMessage = new JPanel();

       panelTopMessage.setPreferredSize(new Dimension(100,25));
       panelMainMessage.setPreferredSize(new Dimension(100,75));
       panelRightMessage.setPreferredSize(new Dimension(100,40));

       panelTopMessage.setLayout(new FlowLayout(FlowLayout.LEADING));
       panelTopMessage.add(new JLabel("Status Messages"));

       panelMainMessage.setBackground(Color.lightGray);
       message = new JLabel("Welcome!");
       message.setFont(new Font("Consolas", Font.ITALIC, 16));

       message.setHorizontalAlignment(JLabel.CENTER);
       panelMainMessage.add(message);

       //clear messages and right panel
       panelRightMessage.setLayout(new BorderLayout());
       btnClearMessages = new JButton("Clear");
       btnClearMessages.addActionListener(e -> {
           message.setText("");
           panelMainMessage.removeAll();
           panelMainMessage.repaint();
           panelMainMessage.revalidate();
       });
       btnClearMessages.setFocusable(false);
       btnClearMessages.setHorizontalTextPosition(JButton.CENTER);
       btnClearMessages.setVerticalTextPosition(JButton.CENTER);
       btnClearMessages.setFont(new Font("Arial", Font.ITALIC, 15));
       btnClearMessages.setBackground(new Color(0x72AA72));
       btnClearMessages.setBorder(BorderFactory.createEtchedBorder());
       panelRightMessage.add(btnClearMessages);

       panelBottom.add(panelTopMessage, BorderLayout.NORTH);
       panelBottom.add(panelRightMessage, BorderLayout.EAST);
       panelBottom.add(panelMainMessage, BorderLayout.CENTER);

       //adding panels to the main frames border layout
       frame.add(panelTop, BorderLayout.NORTH);
       frame.add(panelBottom, BorderLayout.SOUTH);
       frame.add(panelMain, BorderLayout.CENTER);
       new MainPanel().setMainPanel(panelMain);
       new SlotsPanel().setSlotsPanel(panelMain);

       panelMain.revalidate();
       panelMain.repaint();
   }

   public static void setMessage(String _message){
       message.setText(_message);
       panelMainMessage.add(message);
   }

    public static void setMessage(String[] _messages) {
        panelMainMessage.removeAll(); // Clear the existing messages

        for (int i = 0; i < _messages.length; i++) {
            if (_messages[i] != null) {
                JLabel messageLabel = new JLabel(_messages[i]);
                messageLabel.setFont(new Font("Consolas", Font.ITALIC, 16));
                messageLabel.setHorizontalAlignment(JLabel.CENTER);
                panelMainMessage.add(messageLabel);
            }
        }

        panelMainMessage.repaint();
        panelMainMessage.revalidate();
    }

}

