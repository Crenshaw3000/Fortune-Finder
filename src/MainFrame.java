import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    final private Font mainFont =  new Font("Arial", Font.BOLD, 20);
    JTextField rfFirstName, rfColor, rfNumber;



    public void initialize () {
        /**********Form Panel*******/
        JLabel mbFirstName = new JLabel("Name");
        mbFirstName.setFont(mainFont);
        JLabel mbFortune;

        rfFirstName = new JTextField();
        rfFirstName.setFont(mainFont);

        rfColor = new JTextField();
        rfColor.setFont(mainFont);

        JLabel mbColor= new JLabel("Color");
        mbColor.setFont(mainFont);

        rfColor = new JTextField();
        rfColor.setFont(mainFont);


        JLabel mbNumber = new JLabel("Number");
        mbNumber.setFont(mainFont);

        rfNumber = new JTextField();
        rfNumber.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4 , 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(mbFirstName);
        formPanel.add(rfFirstName);
        formPanel.add(mbColor);
        formPanel.add(rfColor);
        formPanel.add(mbNumber);
        formPanel.add(rfNumber);


        /*******Title Label **********/
        mbFortune = new JLabel();
        mbFortune.setFont(mainFont);


        /********Button Panel ********/
        JButton btnOK = new JButton("Submit");
        btnOK.setFont(mainFont);
        btnOK.addActionListener((ActionEvent e) -> {
            String getName = rfFirstName.getText();
            String getColor = rfColor.getText();
            String getNumber = rfNumber.getText();
            mbFortune.setText(getName + " you look good in " + getColor + " and you will be happy in " + getNumber + " days.");
            
        });
        

        JButton btnClear =  new JButton("Start over");
        btnClear.setFont(mainFont);
        btnClear.addActionListener((ActionEvent e) -> {
            rfFirstName.setText("");
            rfColor.setText("");
            rfNumber.setText("");
        });


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 125, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(mbFortune, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);


        setTitle("Fortune Finder");
        setSize(500, 600);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public Font getMainFont() {
        return mainFont;
    }


    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}


