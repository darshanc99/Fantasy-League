//Importing all dependencies
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//The main class of the game Developer
public class User {
	private static Connection Con;
	private static Connection Con2;
	private static Statement st;
	public static JFrame frame1=new JFrame("Frame1");
  public static JFrame frame = new JFrame("LOG-IN");
  public static JPanel p;
  public static JButton b1,b3,quitgame;
  public static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
  public static JTextField t1,t2,t3,t4,t5,t6;
  static int as, ycard, sav, rcard, goals, pid;

  //Builds Connection 1
	private static void build_con()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/league ","root", "");
		 st =(Statement) Con.createStatement();
		}
		catch(Exception e)
		{
		System.out.print("Do not connect to DB - Error:"+e);
		}
	}
	
  //Builds Connection 2
	private static void build_con2()
	{
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
	}

  //Create a frame for Login
	public static void main(String[] args) {

       frame.setSize(300, 150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panel = new JPanel();
       frame.add(panel);
       placeComponents(panel);
       frame.setVisible(true);
   }

   //Placing all the components
   public static void placeComponents(JPanel panel) {
       panel.setLayout(null);

       JLabel userLabel = new JLabel("User");
       userLabel.setBounds(10, 10, 80, 25);
       panel.add(userLabel);

       final JTextField userText = new JTextField(20);
       userText.setBounds(100, 10, 160, 25);
       panel.add(userText);

       JLabel passwordLabel = new JLabel("Password");
       passwordLabel.setBounds(10, 40, 80, 25);
       panel.add(passwordLabel);

       final JPasswordField passwordText = new JPasswordField(20);
       passwordText.setBounds(100, 40, 160, 25);
       panel.add(passwordText);

       JButton loginButton = new JButton("login");
       loginButton.setBounds(100, 80, 80, 25);
       panel.add(loginButton);

       loginButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0){
               String uname=userText.getText();
               String psd=passwordText.getText();
               if(uname.equals("name") && psd.equals("password"))
               {
                   frame.setVisible(false);
                   creategui();
               }
           }
       });
   }

   //Creating GUI for Update
   public static void creategui() {
       frame1 = new JFrame("Main Menu");
       frame1.setVisible(true);
       frame1.setSize(800, 800);
       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       p = new JPanel(new BorderLayout(8, 8));
       p.setBackground(Color.LIGHT_GRAY);

       l2=new JLabel("Player ID:");
       l2.setBounds(150,70,200,70);
       p.add(l2);
       t1 = new JTextField(20);
       t1.setBounds(250,100,150,20);
       t1.setText(null);
       p.add(t1);


       l4=new JLabel("Goals:");
       l4.setBounds(150,170,200,70);
       p.add(l4);
       t2 = new JTextField(20);
       t2.setBounds(250,200,150,20);
       t2.setText(null);
       p.add(t2);


       l5=new JLabel("Assist:");
       l5.setBounds(150,270,200,70);
       p.add(l5);
       t3 = new JTextField(20);
       t3.setBounds(250,300,150,20);
       t3.setText(null);
       p.add(t3);


       l6=new JLabel("Yellow Card:");
       l6.setBounds(150,370,200,70);
       p.add(l6);
       t4 = new JTextField(20);
       t4.setBounds(250,400,150,20);
       t4.setText(null);
       p.add(t4);


       l7=new JLabel("Red Card:");
       l7.setBounds(150,470,200,70);
       p.add(l7);
       t5 = new JTextField(20);
       t5.setBounds(250,500,150,20);
       t5.setText(null);
       p.add(t5);


       l8=new JLabel("Saves:");
       l8.setBounds(150,570,200,70);
       p.add(l8);
       t6 = new JTextField(20);
       t6.setBounds(250,600,150,20);
       t6.setText(null);
       p.add(t6);


       b3 = new JButton("Log Out");
       b3.setBounds(50, 700, 120, 40);
       l3 = new JLabel("");
       p.add(b3, BorderLayout.CENTER);
       p.add(l3);

       b1 = new JButton("Update");
       b1.setBounds(320, 700, 120, 40);
       l1 = new JLabel("");
       p.add(b1, BorderLayout.CENTER);
       p.add(l1);

       quitgame = new JButton("Quit");
       quitgame.setBounds(600, 700, 120, 40);
       l9 = new JLabel("");
       p.add(quitgame, BorderLayout.CENTER);
       p.add(l9);
       frame1.getContentPane().add(p);
       frame1.setLocationRelativeTo(null);

       b1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               pid = Integer.parseInt(t1.getText());
               goals = Integer.parseInt(t2.getText());
               as = Integer.parseInt(t3.getText());
               ycard = Integer.parseInt(t4.getText());
               rcard = Integer.parseInt(t5.getText());
               sav = Integer.parseInt(t6.getText());
               if (pid > 0 && pid <= 20 && (ycard == 1 || ycard == 0) && (rcard == 1 || rcard == 0)) {
                   JOptionPane.showMessageDialog(p,"Updated Successfully","UPDATE",JOptionPane.PLAIN_MESSAGE);            		
            	}     
              else{
                   JOptionPane.showMessageDialog(p,"WRONG INPUTS!!","ERROR",JOptionPane.ERROR_MESSAGE);
               }
           }

           //Update code
		private void up_user(int a) {
			// TODO Auto-generated method stub
			build_con2();
			
			try {
				ResultSet r = null; 
					String query = "SELECT * FROM user";
					PreparedStatement preparedStmt;
					preparedStmt = Con.prepareStatement(query);
					r = preparedStmt.executeQuery();
					r.next();
					int t = r.getInt("Total");
					t += a;
					query = "UPDATE user Set Total = " +t;
					preparedStmt = Con.prepareStatement(query);
					preparedStmt.executeUpdate();	
				Con2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public boolean check(int id)//TO CHECK IF PLAYER IS IN USERS SQUAD
		{							//TRUE IF FOUND
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
					return true;	
				}
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
       }
       
    		   
    		   );

       b3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
           {
               close();
           }
           private void close() {
               frame1.setVisible(false);
               frame.setVisible(true);
           }
       });

       quitgame.addActionListener(new ActionListener() {
           public void actionPerformed(final ActionEvent e) {
               tclose();
           }

           private void tclose() {
               frame1.setVisible(false);
               System.exit(0);
           }
       });

   }
}
