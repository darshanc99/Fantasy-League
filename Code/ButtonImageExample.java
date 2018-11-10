//import all dependencies
import java.awt.*;                          //used this package to use BorderLayout() method
import java.awt.event.ActionEvent;          //Used the package for EventHandling
import java.awt.event.ActionListener;       //Used the package to implement the method ActionListener
import java.io.File;                        //Used to create the song file
import java.io.IOException;                 //To handle exceptions
import java.net.MalformedURLException;      // MalformedURLException is an exception that occurs when you are trying to connect to a URL from your program but your client cannot parse the URL correctly.
import java.net.URL;                        // This class represents a Uniform Resource Locator, a pointer to a “resource” on the World Wide Web.
import java.sql.Connection;                 //This package is for establishing a connection with the database
import java.sql.DriverManager;              //The Connection object uses a DriverManager.The DriverManager passes in your database username, your password, and the location of the database.
import java.sql.PreparedStatement;          //Use the when you plan to use the SQL statements many times. 
import java.sql.Statement;                  //Use the for general-purpose access to your database.
import java.sql.ResultSet;                  //It is a table of data representing a database query result, which is obtained by executing the execute method of statement.
import java.sql.SQLException;               //To handle sql exceptions
import javax.swing.*;                       //Importing the swing class
import javax.swing.table.DefaultTableModel; //To use JTables
import javax.imageio.ImageIO;               //To accept images
import javax.sound.sampled.*;               //To accept sound

public class ButtonImageExample             //This is our main Parent class
{
    //Declaring all the variables
    private static Connection Con2;         
    private static ImageIcon imageForLabel;
    private static JLabel imageLabel;
    public static JTextField userField,label;
    private JPasswordField passField;
    private JButton loginButton;
    public static JFrame frame1=new JFrame("Frame1");   //Transfers season
    public static JFrame frame2=new JFrame("Frame2");   //Login Frame
    public static JFrame frame3=new JFrame("Frame3");   //User-Stats Frame
    public static JFrame frame = new JFrame("LOG-IN");  //Main-Menu Frame
    public static JFrame musicframe=new JFrame("MUSIC");//Music Frame
    public static JPanel p2;
    public static JButton b1,b2,b3,b6,quitgame,menuButton,exchangeButton;
    public static JTextField label1;
    static int pid,bid;
    public static JPanel basePanel;
    public static Connection Con;
    public static Statement st;
    public static ResultSet rs;
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()   //Implementing the Runnable interface
        {
            public void run()   
            {
                new ButtonImageExample().displayGUI();   //Creating an object for the main class and calling the method to create Login frame
                music();                        //Calling the audio frame to play audio onclick of login button 
            }
        });
    }
    private void displayGUI()       //The method to call build the login frame
    {
        frame2 = new JFrame("LOG-IN");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Closes the frame on click of close button
        JPanel contentPane = new JPanel();  //This Panel to insert background image and the other components of login
        contentPane.setLayout(new BorderLayout(5, 5));
        try
        {
            imageForLabel = new ImageIcon(ImageIO.read(new URL("https://steemitimages.com/0x0/https://cdn.steemitimages.com/DQmVtZqmCtH7YL1fB8E46ziGpTw5UeFEbKmNuKenrS628EC/aifzotmwbqkaqsngabpf.jpg")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        imageLabel = new JLabel(imageForLabel); //This would include the BasePanel
        JPanel basePanel = new JPanel();    //BasePanel included to add components of the frame in this frame
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel();     //TopPanel to include the username panel and password labels 
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));
        JLabel userLabel = new JLabel("USERNAME : ", JLabel.CENTER);    //This label includes username feature
        userLabel.setForeground(Color.YELLOW);
        userLabel.setFont(new Font("TimesRoman",Font.BOLD,15));
        userField = new JTextField(10);
        JLabel passLabel = new JLabel("PASSWORD : ", JLabel.CENTER);    //This label includes password feature
        passLabel.setForeground(Color.YELLOW);
        passLabel.setFont(new Font("TimesRoman",Font.BOLD,15));
        passField = new JPasswordField(10);

        //Adding the labels 
        topPanel.add(userLabel);
        topPanel.add(userField);
        topPanel.add(passLabel);
        topPanel.add(passField);

        JPanel bottomPanel = new JPanel();  //The bottomPanel includes login button
        bottomPanel.setOpaque(false);
        loginButton = new JButton("Click to LOGIN");
        loginButton.setHorizontalTextPosition(AbstractButton.CENTER);
        loginButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        bottomPanel.add(loginButton);

        //Adding topPanel and bottomPanel in the basePanel
        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);                  //Adding the basepanel in the imageLabel
        
        contentPane.add(imageLabel, BorderLayout.CENTER);//Finally adding the imageLabel in ContentPane
        frame2.setContentPane(contentPane);
        frame2.pack();
        frame2.setLocationByPlatform(true);
        frame2.setVisible(true);

        //Event handling for loginButton
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                String uname=userField.getText();
                String psd=passField.getText();
                if(uname.equals("name") && psd.equals("password"))
                {
                    frame2.setVisible(false);
                    creategui();        //Calling the method to create the Main-menu frame
                }
                else{
                    JOptionPane.showMessageDialog(imageLabel,"Wrong Username or Password!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void music()  //Music frame is initialized
    {
        musicframe=new JFrame("Music");
        musicframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        musicframe.setSize(10, 10);
        musicframe.setVisible(false);
        String audioFilePath = "C:\\Users\\dell\\Downloads\\waving.wav";   //Obtaining the audio path
        play(audioFilePath);       //Calling the method to play the audio
    }

    public static void play(String audioFilePath)   //The method that plays your song
    {
        File audioFile = new File(audioFilePath);  //Creates the file
         
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);  //Takes the input
 
            AudioFormat format = audioStream.getFormat();
 
            DataLine.Info info = new DataLine.Info(Clip.class, format);
 
            Clip audioClip = (Clip) AudioSystem.getLine(info);
 
            audioClip.open(audioStream);
             
            audioClip.start();

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
    }
     
    //The method that shapes your Main-Menu 
    private void creategui() {
        
        frame = new JFrame("MAIN MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);


        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));      //Contents all the components of the frame
        try {
            imageForLabel = new ImageIcon(ImageIO.read(new URL( "https://img.fifa.com/image/upload/t_l4/lvhoyndpusiefxhcdha8.jpg")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        imageLabel = new JLabel(imageForLabel);     //imageLabel would contain the basePanel
        
        JPanel basePanel = new JPanel();            //The basePanel consists of bottomPannel
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        
        JPanel bottomPanel = new JPanel();          //The bottomPanel consists of 4 buttons explained below
        bottomPanel.setOpaque(false);

        b1 = new JButton("Transfer Season");        //The button that would direct you to transfers frame
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);

        b2 = new JButton("User Statistics");        //The button that would direct you to user statistics
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);

        b3 = new JButton("LOG-OUT");                //The logout button that directs you to the login frame
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setVerticalTextPosition(AbstractButton.BOTTOM);

        quitgame = new JButton("Quit Game");        //The button that ends the game
        quitgame.setHorizontalTextPosition(AbstractButton.CENTER);
        quitgame.setVerticalTextPosition(AbstractButton.BOTTOM);

        //Adding all the buttons in the bottomPanel
        bottomPanel.add(b1);
        bottomPanel.add(b2);
        bottomPanel.add(b3);
        bottomPanel.add(quitgame);

        //Adding the bottomPanel in the basePanel
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        //Adding the basePanel in the imageLabel
        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);

        //Finally adding the imageLabel in the contentPane
        contentPane.add(imageLabel, BorderLayout.CENTER);

        //Adding the contentPane in the Main Menu frame
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        //Button directs you to Transfers frame
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                DisplayPlayerData();
            }
        });

        //Button directs you to User section frame
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                creategui1();
            }
        });
        //Button directs you to Login frame
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                close();
            }
            private void close() {
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });

        //Button directs you to end the game
        quitgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                tclose();
            }
            private void tclose() {
                frame.setVisible(false);
                System.exit(0);
            }
        });
        
    }
    

    public static void creategui1() {       //Creates the User Section Frame
        frame3=new JFrame("User stats");
        frame3.setSize(800, 500);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel contentPane = new JPanel();      //The contentPane will consist of all the components of the frame
        contentPane.setLayout(new BorderLayout(5, 5));
        try
        {
            imageForLabel = new ImageIcon(ImageIO.read(new URL("https://www.newstatesman.com/sites/default/files/styles/nodeimage/public/blogs_2018/10/gettyimages-958057654.jpg?itok=K4t5lUiB")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        //imageLabel would consist the basePanel
        imageLabel = new JLabel(imageForLabel);

        //basePanel would consist of topPanel and bottomPanel
        JPanel basePanel = new JPanel();
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));

        //topPanel would consist of the user's score
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));

        //bottomPanel would consist of Main-Menu button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);

        //The Main Menu button is created
        b6 = new JButton("MAIN MENU");

        //Logic for calculating the total score
        int points=0;
        try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");
         st=(Statement) Con2.createStatement();
         String query = "SELECT * FROM user";
         PreparedStatement preparedStmt;
         preparedStmt = Con2.prepareStatement(query);
         ResultSet res = preparedStmt.executeQuery();
         res.next();
         points = res.getInt("Total");
        }
        catch(Exception e)
        {
        System.out.print("Do not connect to DB - Error:"+e);
        }

        //Score Label would display the score
        JLabel score=new JLabel("Your score is:"+points);
        score.setForeground(Color.WHITE);
        score.setFont(new Font("TimesRoman",Font.BOLD,30));
        //score.setPreferredSize(new Dimension(200, 70));;
        score.setSize(200, 70);

        //Adding the score in the topPanel
        topPanel.add(score);

        //Adding the Main-Menu button in the bottomPanel
        bottomPanel.add(b6);

        //Adding the topPanel and bottomPanel in the basePanel
        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        //Adding the basePanel in the imageLabel
        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);

        //Finally, adding the imageLabel in the contentPane
        contentPane.add(imageLabel, BorderLayout.CENTER);

        //Adding the contentPane in the frame
        frame3.setContentPane(contentPane);
        frame3.pack();
        frame3.setLocationByPlatform(true);
        frame3.setVisible(true);

        //Event Handling for Main-Menu button
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                close();
            }
            private void close() {
                frame3.setVisible(false);
                frame.setVisible(true);
            }
        });  
    }

    
    public static void DisplayPlayerData()  //The method to display the Transfers frame
    {
        Connection con=null;
        ResultSet rs = null,rs1 = null;
        Statement st;
        PreparedStatement pst;
        JTable table,usertable;
        String[] columnNames = {"ID","NAME","TEAM","PRICE","GOAL","ASSIST","YELLOW CARD","RED CARD","SAVES","TOTAL"};

        //Establishing the connection with the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // (1)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");  // (2)
            st = con.createStatement();
            rs = st.executeQuery("select uname from emp");
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Work on the connection");
        }


        frame1 = new JFrame("Player Data");         //Creating the Frame for Player Data
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());


        DefaultTableModel model = new DefaultTableModel();  //Creating a model for including table of data of players not in User's team
        model.setColumnIdentifiers(columnNames);


        final DefaultTableModel model1 = new DefaultTableModel();   //Creating a model for including table of data of players in User's team
        model1.setColumnIdentifiers(columnNames);

        //Creating a table of players not in the team
        table = new JTable();       
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        //Creating scroll for table of players not in user's team
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //Creating a table of players in the team
        usertable=new JTable();
        usertable.setModel(model1);
        usertable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        usertable.setFillsViewportHeight(true);
        
        //Creating scroll1 for table of players in the user's team
        JScrollPane scroll1=new JScrollPane(usertable);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //Creating a basePanel that would include all the components of the frame
        basePanel = new JPanel();
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));

        //topPanel includes table of players not in user's team
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(800,100));
        topPanel.setOpaque(false);
        topPanel.add(scroll);       //Adding the scroll

        //Creating a bottomPanel for including exchange components and Main-Menu button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3,5,5));
        label = new JTextField(10);     //This is for player to be removed
        bottomPanel.setOpaque(false);

        //midPanel contains table of players in the user's team
        JPanel midPanel=new JPanel();
        midPanel.setLayout(new GridLayout(1,3,5,5));
        midPanel.setOpaque(false);
        midPanel.add(scroll1);      //Adding the scroll1

        //Creating the menu button
        menuButton = new JButton("Main Menu");
        menuButton.setHorizontalTextPosition(AbstractButton.CENTER);
        menuButton.setVerticalTextPosition(AbstractButton.BOTTOM);

        //Event Handling for menuButton
        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                frame1.setVisible(false);
                frame.setVisible(true);
            }
        });

        //Exchange button creation
        exchangeButton=new JButton("Exchange");
        exchangeButton.setHorizontalTextPosition(AbstractButton.CENTER);
        exchangeButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        label1=new JTextField(10);      //This is for player to be added in place of player to be removed

        //Adding components in the bottomPanel
        bottomPanel.add(label);
        bottomPanel.add(exchangeButton);
        bottomPanel.add(label1);
        bottomPanel.add(menuButton);

        //Adding the topPanel, midPanel and bottomPanel in the basePanel
        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);
        basePanel.add(midPanel,BorderLayout.CENTER);

        //Getting the table data of players in the user's team
        try {
            pst = con.prepareStatement("select * from league");
            rs1 = pst.executeQuery();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        for(int z=0;z<20;z++)
        {
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

        //Getting the table data of players not in the user's team
        try {
            pst = con.prepareStatement("select * from league");
            rs = pst.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        for(int z=0;z<20;z++)
        {
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

        //Event Handling for exchangeButton
        exchangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pid = Integer.parseInt(label.getText());
                bid=Integer.parseInt(label1.getText());
                if (pid > 0 && pid <= 20 && bid>0 && bid<=20) {
                    try{
                        model1.removeRow(model1.getRowCount() - 1); //First removing the user team table contents after exchanging the players
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        model1.removeRow(model1.getRowCount() - 1);
                        rem(pid, bid);          //Remove method called

                        //refreshing the frame to get the contents
                        frame1.setVisible(false);           //setting the visibility of unrefresed frame first
                        DisplayPlayerData();                //And then, re-calling the method to make the transfers frame again
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


    public static void rem(int pid, int bid)    //Remove method
    {
        //Establishing the connection
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

        int n , p = pid, i = 1;     //p is player to be removed
        try {             
                PreparedStatement preparedStmt;
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
                n = i;
                add(n , bid);       //Now adding the player in exchange of removed player
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void add(int n, int bid)      //Add method
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

        int p = bid;    //ID of player to be replaced
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
    {                           //FALSE IF FOUND
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
            e.printStackTrace();
        }
        return true;
    }

}