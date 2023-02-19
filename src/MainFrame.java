import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    final private Font mainFont =  new Font("Arial", Font.BOLD, 16);
    final private Font nextFont =  new Font("Arial", Font.PLAIN, 16);
    final private Font lastFont =  new Font("Arial", Font.BOLD, 16);

    JTextField rfFirstName, rfColor, rfNumber;



    public void initialize () {
        /**********Form Panel*******/
        ImageIcon img = new ImageIcon("fortune3.png");
        // resize image
        Image i = img.getImage();
        Image new_img = i.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        img = new ImageIcon(new_img);

        // JLabel mbDirections = new JLabel("Enter the your information the fields below for a horoscope.");
        // mbDirections.setFont(mainFont);
        // mbDirections.setVerticalTextPosition(JLabel.TOP);
        JLabel mbLogo = new JLabel("Enter the your information for a horoscope.", img, JLabel.CENTER);
        mbLogo.setFont(mainFont);
        // mbLogo.setHorizontalTextPosition(JLabel.CENTER);
        // mbDirections.setIcon(pimage);
        JLabel blank1 = new JLabel();
        JLabel mbFortune;
        // JLabel blank2 = new JLabel();

        JLabel mbFirstName = new JLabel("First Name:");
        mbFirstName.setFont(mainFont);

        rfFirstName = new JTextField();
        rfFirstName.setFont(nextFont);

        rfColor = new JTextField();
        rfColor.setFont(nextFont);

        JLabel mbColor= new JLabel("Pick a Color:");
        mbColor.setFont(mainFont);

        rfColor = new JTextField();
        rfColor.setFont(nextFont);


        JLabel mbNumber = new JLabel("Pick a Number:");
        mbNumber.setFont(mainFont);

        rfNumber = new JTextField();
        rfNumber.setFont(nextFont);



        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5 , 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(mbLogo);
        // formPanel.add(mbDirections);
        formPanel.add(blank1);
        formPanel.add(mbFirstName);
        formPanel.add(rfFirstName);
        formPanel.add(mbColor);
        formPanel.add(rfColor);
        formPanel.add(mbNumber);
        formPanel.add(rfNumber);


        /*******Title Label **********/
        mbFortune = new JLabel();
        mbFortune.setFont(lastFont);


        /********Button Panel ********/
        JButton btnOK = new JButton("Submit");
        btnOK.setFont(mainFont);


        btnOK.addActionListener((ActionEvent e) -> {
            String getName = rfFirstName.getText().substring(0, 1).toUpperCase() + rfFirstName.getText().substring(1);
            String getColor = rfColor.getText().toLowerCase();
            String getNumber = rfNumber.getText().toLowerCase();
            String[] Fortunes = {getName + " you look good in " + getColor + " and you will be happy in " + getNumber + " days.", 
            getName + " do not wear " + getColor + " for  " + getNumber + " days or you will step in dog poop.", 
            getName + " change your hair to " + getColor + " in " + getNumber + " days to have luck with your finances.",
            getName + " you are boring so no horoscope for you.", 
            getName + ", " + getNumber + " is not as lucky as the number 1111. " + "Play the Lotto in using 1111 and take a lucky charm that has " + getColor + " somewhere in it with you.", 
            getName + " you will be hungry in " + getNumber + " minutes. You should eat something " + getColor + ".",
            getName + " dress as a Sailormoon character that wears " + getColor + " for your " + getNumber + "th event this year for fame.", 
            getName + " wear " + getColor + " and run for  " + getNumber + " minutes. Then, ask yourself could you pass the hunter exam with Gon and Killua. If not, do it again."};
            Random rand = new Random();
            int r = rand.nextInt(Fortunes.length);
            mbFortune.setText(Fortunes[r], SwingConstants.CENTER);

            // mbFortune.setText(getName + " you look good in " + getColor + " and you will be happy in " + getNumber + " days.");
            // mbFortune.setHorizontalTextPosition(JLabel.CENTER);
            // mbFortune.setBounds(50,50,50,50);

        });
        

        JButton btnClear =  new JButton("Start over");
        btnClear.setFont(mainFont);
        btnClear.addActionListener((ActionEvent e) -> {
            rfFirstName.setText("");
            rfColor.setText("");
            rfNumber.setText("");
            mbFortune.setText("");
        });


        JPanel buttonsPanel = new JPanel();
        // buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        // buttonsPanel.grid[0][0].setBackground(Color.RED);
        // buttonsPanel.setOpaque(true);
        buttonsPanel.setBackground(new Color(100, 125, 255));
        btnClear.setOpaque(true); 
        btnOK.setOpaque(true);
        btnOK.setBackground(Color.PINK);
        btnClear.setBackground(Color.pink);
        btnOK.setBorderPainted(false);
        btnClear.setBorderPainted(false);
        btnOK.setFocusPainted(true);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(100, 125, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 50, 20));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        // mainPanel.add(mbDirections, BorderLayout.NORTH);
        // mainPanel.add(mbLogo, BorderLayout.NORTH);
        mainPanel.add(mbFortune, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);


        setTitle("Fortune Finder");
        setSize(850, 600);
        setMinimumSize(new Dimension(850,600));
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


