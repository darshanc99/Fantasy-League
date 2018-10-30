import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ButtonImageExample
{
    private ImageIcon imageForLabel;
    private JLabel imageLabel;

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    public static JFrame frame1=new JFrame("Frame1");
    public static JFrame frame2=new JFrame("Frame2");
    public static JFrame frame3=new JFrame("Frame3");
    public static JFrame frame = new JFrame("LOG-IN");
    public static JPanel p,p1,p2;
    public static JButton b1,b2,b3,b6,addplayer,removeplayer,b7,quitgame;
    public static JLabel l1,l2,l3,l7,l8,l9,background;
    static int pid;

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonImageExample().displayGUI();
            }
        });
    }

    private void displayGUI()
    {
        frame2 = new JFrame("LOG-IN");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        try
        {
            //image = new ImageIcon(ImageIO.read(
                   // new URL("http://i.imgur.com/jwyrvXC.gif")));
            imageForLabel = new ImageIcon(ImageIO.read(new URL("https://sport360.com/wp-content/uploads/2017/08/04-08-FPL-2-e1504854530482.jpg")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        imageLabel = new JLabel(imageForLabel);
        JPanel basePanel = new JPanel();
        // setOpaque(false) is used to make the JPanel translucent/transparent.
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));
        JLabel userLabel = new JLabel("USERNAME : ", JLabel.CENTER);
        userLabel.setForeground(Color.WHITE);
        userField = new JTextField(10);
        JLabel passLabel = new JLabel("PASSWORD : ", JLabel.CENTER);
        passLabel.setForeground(Color.WHITE);
        passField = new JPasswordField(10);

        topPanel.add(userLabel);
        topPanel.add(userField);
        topPanel.add(passLabel);
        topPanel.add(passField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        loginButton = new JButton("Click to LOGIN");
        //loginButton.setIcon(image);
        loginButton.setHorizontalTextPosition(AbstractButton.CENTER);
        loginButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        bottomPanel.add(loginButton);

        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);

        contentPane.add(imageLabel, BorderLayout.CENTER);

        frame2.setContentPane(contentPane);
        frame2.pack();
        frame2.setLocationByPlatform(true);
        frame2.setVisible(true);

        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                String uname=userField.getText();
                String psd=passField.getText();
                if(uname.equals("name") && psd.equals("password"))
                {
                    frame2.setVisible(false);
                    creategui();
                }
                else{
                    JOptionPane.showMessageDialog(imageLabel,"Wrong Username or Password!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void creategui() {
        frame = new JFrame("MAIN MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        try {
            //image = new ImageIcon(ImageIO.read(
            //new URL("http://i.imgur.com/jwyrvXC.gif")));
            imageForLabel = new ImageIcon(ImageIO.read(new URL("http://spojrzeniezkanapy.pl/wp-content/uploads/2017/07/fantasy3.png")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        imageLabel = new JLabel(imageForLabel);
        JPanel basePanel = new JPanel();
        // setOpaque(false) is used to make the JPanel translucent/transparent.
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        b1 = new JButton("Transfer Season");
        //loginButton.setIcon(image);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2 = new JButton("User Statistics");
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b3 = new JButton("LOG-OUT");
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setVerticalTextPosition(AbstractButton.BOTTOM);
        quitgame = new JButton("Quit Game");
        quitgame.setHorizontalTextPosition(AbstractButton.CENTER);
        quitgame.setVerticalTextPosition(AbstractButton.BOTTOM);


        bottomPanel.add(b1);
        bottomPanel.add(b2);
        bottomPanel.add(b3);
        bottomPanel.add(quitgame);

        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);

        contentPane.add(imageLabel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                creategui2();
            }

        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame1.setVisible(false);
                creategui1();
            }

        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                close();
            }
            private void close() {
                // TODO Auto-generated method stub
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });

        quitgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                tclose();
            }

            private void tclose() {
                // TODO Auto-generated method stub
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }
    public static void creategui1() {
        frame3=new JFrame("User stats");
        frame3.setSize(1280, 720);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);
        background=new JLabel(new ImageIcon("C:/Users/bhard/Desktop/template.jpg"));
        background.setVerticalAlignment(JLabel.BOTTOM);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setLayout(null);
        frame3.add(background);

        p1=new JPanel(new BorderLayout(8,8));
        p1.setOpaque(false);
        p1.setLayout(new BorderLayout());
        background.setLayout(new FlowLayout());
        b6=new JButton("Main Menu");
        b6.setBounds(450,200,120,40);
        //l6=new JLabel("");
        p1.add(b6,BorderLayout.SOUTH);
        background.add(p1,BorderLayout.SOUTH);
        //background.add(l6);

        //frame2.getContentPane().add(p1);
        frame3.pack();
        //frame2.setLocationRelativeTo(null);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                close();
            }
            private void close() {
                // TODO Auto-generanted method stub
                frame3.setVisible(false);
                frame.setVisible(true);
            }
        });
    }
    public static void creategui2() {
        frame1=new JFrame("Data");
        frame1.setSize(800,800);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        p2=new JPanel(new BorderLayout(8,8));
        p2.setLayout(null);
        addplayer=new JButton("Add/Remove");
        addplayer.setBounds(400,670,200,20);
        l7=new JLabel("Add/Remove player by ID:");
        l7.setBounds(100,645,300,70);
        p2.add(addplayer,BorderLayout.SOUTH);
        p2.add(l7);
        frame1.getContentPane().add(p2);
        frame1.setLocationRelativeTo(null);

        JTextField idText = new JTextField(20);
        idText.setBounds(250,670,150,20);
        p2.add(idText);
        b7=new JButton("Main Menu");
        b7.setBounds(250,700,120,40);
        l8=new JLabel("");
        p2.add(b7,BorderLayout.SOUTH);
        p2.add(l8);

        addplayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pid = Integer.parseInt(idText.getText());
                if (pid > 0 && pid <= 20) {
                    JOptionPane.showMessageDialog(p2, "DONE", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                        //JOptionPane.showMessageDialog(p, "", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                        //Please check and throw error if the player to be removed is not present in the squad.
                        /*Enter Your code here. Use pid for Player ID*/
                }
                else{
                    JOptionPane.showMessageDialog(p2,"WRONG PLAYER ID!!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
                {
                    close();
                }
                private void close() {
                    // TODO Auto-generated method stub
                    frame1.setVisible(false);
                    frame.setVisible(true);
            }
        });
    }
}