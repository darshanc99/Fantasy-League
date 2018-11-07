import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
public class ButtonImageExample
{
    private static Connection Con2;
    private static ImageIcon imageForLabel;
    private static JLabel imageLabel;
    public static JTextField userField,label;
    private JPasswordField passField;
    private JButton loginButton;
    public static JFrame frame1=new JFrame("Frame1");
    public static JFrame frame2=new JFrame("Frame2");
    public static JFrame frame3=new JFrame("Frame3");
    public static JFrame frame = new JFrame("LOG-IN");
    public static JPanel p,p1,p2;
    public static JButton b1,b2,b3,b6,addplayer,removeplayer,b7,quitgame,menuButton,exchangeButton;
    public static JLabel l1,l2,l3,l7,l8,l9,background,remove,add;
    public static JTextField label1;
    static int pid,bid,id1,id2,id3,id4,id5;
    public static JPanel basePanel;
    public static void main(String[] args)
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
            imageForLabel = new ImageIcon(ImageIO.read(new URL("https://www.khaosod.co.th/wp-content/uploads/2018/02/premier-league-logo-07-1510035706.jpg")));
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
                DisplayPlayerData();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
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
        frame3.setSize(500, 500);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        try
        {
            //image = new ImageIcon(ImageIO.read(
            // new URL("http://i.imgur.com/jwyrvXC.gif")));
            imageForLabel = new ImageIcon(ImageIO.read(new URL("http://zinder.info/wp-content/uploads/2018/07/light-green-texture-download-light-green-watercolor-abstract-background-stock-photo-image-of-colorful-beige-light-green-fabric-texture-light-green-texture-paint.jpg")));
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
        b6 = new JButton("MAIN MENU");
        bottomPanel.add(b6);
        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);
        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);
        contentPane.add(imageLabel, BorderLayout.CENTER);
        frame3.setContentPane(contentPane);
        frame3.pack();
        frame3.setLocationByPlatform(true);
        frame3.setVisible(true);
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
    /*public static void creategui2() {
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
                /*}
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
    }*/
    public static void DisplayPlayerData()
    {
        Connection con=null;
        ResultSet rs = null,rs1 = null,rs2;
        Statement st,st1;
        PreparedStatement pst;
        String ids;
        JTable table,usertable;
        String[] columnNames = {"ID","NAME","TEAM","PRICE","GOAL","ASSIST","YELLOW CARD","RED CARD","SAVES","TOTAL"};

        String from=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // (1)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");  // (2)
            st = con.createStatement();
            rs = st.executeQuery("select uname from emp");
            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Connection unestablished");
        }
        frame1 = new JFrame("Player Data");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        final DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        usertable=new JTable();
        usertable.setModel(model1);
        usertable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        usertable.setFillsViewportHeight(true);
        JScrollPane scroll1=new JScrollPane(usertable);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        basePanel = new JPanel();
        // setOpaque(false) is used to make the JPanel translucent/transparent.
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(800,100));
        topPanel.setOpaque(false);
        //topPanel.setLayout(new GridLayout(1, 1, 5, 5));
        topPanel.add(scroll);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3,5,5));
        label = new JTextField(10);
        bottomPanel.setOpaque(false);

        JPanel midPanel=new JPanel();
        midPanel.setLayout(new GridLayout(1,3,5,5));
        midPanel.setOpaque(false);
        midPanel.add(scroll1);

        menuButton = new JButton("Main Menu");
        menuButton.setHorizontalTextPosition(AbstractButton.CENTER);
        menuButton.setVerticalTextPosition(AbstractButton.BOTTOM);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                frame1.setVisible(false);
                frame.setVisible(true);
            }
        });
        exchangeButton=new JButton("Exchange");
        exchangeButton.setHorizontalTextPosition(AbstractButton.CENTER);
        exchangeButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        label1=new JTextField(10);
        bottomPanel.add(label);
        bottomPanel.add(exchangeButton);
        bottomPanel.add(label1);
        bottomPanel.add(menuButton);
        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);
        basePanel.add(midPanel,BorderLayout.CENTER);

        try {
            pst = con.prepareStatement("select * from league");
            rs1 = pst.executeQuery();
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        for(int z=0;z<20;z++)
        {

//String textvalue = textbox.getText();
            String name = "";
            String teamname = "";
            String goal = "";
            String yellowcard = "";
            String id="";
            String price="";
            String assist="";
            String redcard="";
            String saves="";
            String total="";
            try {
                int i = 0;
                if (rs1.next()) {
                    name = rs1.getString("player_name");
                    teamname = rs1.getString("team");
                    goal = rs1.getString("Goal");
                    yellowcard = rs1.getString("Yellow_Card");
                    id=rs1.getString("player_id");
                    price=rs1.getString("price");
                    assist=rs1.getString("Assist");
                    redcard=rs1.getString("Red_Card");
                    saves=rs1.getString("Saves");
                    total=rs1.getString("Total");
                    if(!check(z+1))
                        model1.addRow(new Object[]{id,name, teamname,price,goal,assist, yellowcard,redcard,saves,total});
                    i++;
                }
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            frame1.add(basePanel);
            frame1.setVisible(true);
            frame1.setSize(1000,1000);
        }
        try {
            pst = con.prepareStatement("select * from league");
            rs = pst.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        for(int z=0;z<20;z++)
        {
            //String textvalue = textbox.getText();
            String name = "";
            String teamname = "";
            String goal = "";
            String yellowcard = "";
            String id="";
            String price="";
            String assist="";
            String redcard="";
            String saves="";
            String total="";
            try {

                int i = 0;
                if (rs.next()) {
                    name = rs.getString("player_name");
                    teamname = rs.getString("team");
                    goal = rs.getString("Goal");
                    yellowcard = rs.getString("Yellow_Card");
                    id=rs.getString("player_id");
                    price=rs.getString("price");
                    assist=rs.getString("Assist");
                    redcard=rs.getString("Red_Card");
                    saves=rs.getString("Saves");
                    total=rs.getString("Total");
                    if(check(z+1))
                    {
                        model.addRow(new Object[]{id,name, teamname,price,goal,assist, yellowcard,redcard,saves,total});
                    }
                    i++;
                }
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            frame1.add(basePanel);
            frame1.setVisible(true);
            frame1.setSize(1000,1000);
        }
        exchangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pid = Integer.parseInt(label.getText());
                bid=Integer.parseInt(label1.getText());
                if (pid > 0 && pid <= 20 && bid>0 && bid<=20) {
                    try{
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        rem(pid, bid);
                    }catch(Exception ex)
                    {
                        System.out.println(ex);
                    }




                }
                else if(bid>20 || pid>20){
                    JOptionPane.showMessageDialog(p2,"WRONG PLAYER ID!!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void rem(int pid, int bid)//need to add if player not in team then what to do
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");
            Statement st = (Statement) Con2.createStatement();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
        int n , p = pid, i = 1;//p is player to be removed
        try {		      PreparedStatement preparedStmt;
            ResultSet res = null;
            String query = "SELECT * FROM user";
            preparedStmt = Con2.prepareStatement(query);
            res = preparedStmt.executeQuery(query);
            res.next();
            String a = null;
            while(i < 6)
            {
                a = "P_"+i;
                int x = res.getInt(a);
                if(x == p)
                {
                    break;
                }
                i++;
            }
            if(i == 6)
            {
                JOptionPane.showMessageDialog(p2,"PLAYER IS NOT IN THE TEAM","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Con2.close();
                n = i;//sending position where the player is to be added
                add(n , bid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void add(int n, int bid)
    {
        Statement st = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");
            st=(Statement) Con2.createStatement();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
        int p = bid;//p is the player to be added & n is the position to be added
        try {
            ResultSet res = null;
            String query = "SELECT * FROM user";
            res = ((java.sql.Statement) st).executeQuery(query);
            res.next();
            String a = null;
            int i = 1;
            while(i  < 6)
            {
                a = "P_"+i;
                int x = res.getInt(a);
                if(x == p)
                {
                    JOptionPane.showMessageDialog(p2,"PLAYER ALREADY IN TEAM","ERROR",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                i++;
            }if(i == 6)
            {
                query = "UPDATE user SET P_? = ?";
                PreparedStatement preparedStmt;
                preparedStmt = Con2.prepareStatement(query);
                preparedStmt.setInt   (1, n);
                preparedStmt.setInt   (2, p);
                preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog(p2, "DONE", "UPDATE", JOptionPane.PLAIN_MESSAGE);
            }

            Con2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean check(int id)//TO CHECK IF PLAYER IS IN USERS SQUAD
    {							//FALSE IF FOUND
        Statement st = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");
            st=(Statement) Con2.createStatement();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
        ResultSet res = null;
        String query = "SELECT * FROM user";
        try {

            res = ((java.sql.Statement) st).executeQuery(query);
            res.next();

            int i = 1;
            while(i < 6)
            {
                String a = "P_"+i;
                int x = res.getInt(a);

                if(x == id)
                {
                    res.close();
                    Con2.close();
                    return false;
                }
                i++;
            }
            res.close();
            Con2.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

}