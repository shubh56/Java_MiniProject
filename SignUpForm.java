import javax.swing.*;
import java.awt.event.*;
import java.awt.*;					// x=1275(638)  y=668(334)
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

class SignInForm
{
	JLabel signin = new JLabel("Sign In");
	JLabel username = new JLabel("Username:");
	JLabel password = new JLabel("Password:");
	JTextField usernametext = new JTextField();
	JPasswordField passwordtext = new JPasswordField();
	JButton signinbtn = new JButton("Submit");
	JButton signupbtn = new JButton("Sign Up");
	JFrame f = new JFrame("User Sign In");			
	SignInForm()
	{	
		
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,500);
		f.getContentPane().setBackground(Color.decode("#f1f3f8"));
		f.add(username);
		f.add(password);
		f.add(signin);
		f.add(usernametext);
		f.add(passwordtext);
		f.add(signinbtn);
		f.add(signupbtn);
		signin_labels();
		text_fields_signin();
		signin_btns();
		signin_action_listeners();
		
	}
	void signin_labels()
	{
		
		signin.setBounds(550,0,200,100);
		signin.setFont(new Font("Roboto Condensed",Font.BOLD,50));
		signin.setForeground(Color.decode("#8d93ab"));
		username.setBounds(250,200,200,150);
		username.setFont(new Font("Arial",Font.PLAIN,25));
		password.setBounds(250,300,200,150);
		password.setFont(new Font("Arial",Font.PLAIN,25));
	}
	void text_fields_signin()
	{
		usernametext.setBounds(390,262,500,25);
		passwordtext.setBounds(390,362,500,25);
		
	}
	void signin_btns()
	{
		signinbtn.setBounds(500,500,100,25);
		signupbtn.setBounds(650,500,100,25);
	}
	void signin_action_listeners()
	{
		signinbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String username= usernametext.getText();
				String password = new String(passwordtext.getPassword());
				System.out.println(username);
				System.out.println(password);
				
			}
		});
		signupbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new SignUpPage();
				f.setVisible(false);
				
				
			}
		});
	}
}
class SignUpPage extends SignInForm
{
	JButton signupbutton = new JButton("Sign up");
	JButton prev = new JButton("Previous");
	JFrame f2 = new JFrame("User Sign Up");
	JLabel signuplabel = new JLabel("Sign Up");
	JLabel newusername = new JLabel("Username:");
	JLabel newpass = new JLabel("Password:");
	JLabel newpass2 = new JLabel("Confirm Password:");
	JLabel email = new JLabel("Email:");
	JTextField usernamefield = new JTextField();
	JTextField emailfield = new JTextField();
	JTextField passwordfield = new JTextField();
	JTextField confirmpassword = new JTextField();
	SignUpPage()
	{
		
		f2.setLayout(null);
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setSize(600,500);
		f2.add(prev);
		f2.add(signupbutton);
		f2.add(signuplabel);
		f2.add(newusername);
		f2.add(email);
		f2.add(newpass);
		f2.add(newpass2);
		f2.add(usernamefield);
		f2.add(passwordfield);
		f2.add(confirmpassword);
		f2.add(emailfield);
		signup_labels();
		signup_acctionlisteners();
		signup_textareas();
		signup_buttons();
	}
	void signup_labels()
	{
		signuplabel.setBounds(550,0,200,100);
		signuplabel.setFont(new Font("Roboto Condensed",Font.BOLD,50));
		signuplabel.setForeground(Color.decode("#8d93ab"));
		newusername.setBounds(250,200,100,50);
		newusername.setFont(new Font("Arial",Font.PLAIN,20));
		email.setBounds(250,250,100,50);
		email.setFont(new Font("Arial",Font.PLAIN,20));
		newpass.setBounds(250,300,100,50);
		newpass.setFont(new Font("Arial",Font.PLAIN,20));
		newpass2.setBounds(250,325,400,100);
		newpass2.setFont(new Font("Arial",Font.PLAIN,20));
		
	}
	void signup_buttons()
	{
		prev.setBounds(500,500,100,25);	
		signupbutton.setBounds(650,500,100,25);
	}
	void signup_textareas()
	{
		usernamefield.setBounds(450,200,400,40);
		emailfield.setBounds(450,250,400,40);
		passwordfield.setBounds(450,300,400,40);
		confirmpassword.setBounds(450,350,400,40);
	}
	void signup_acctionlisteners()
	{
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new SignInForm();
				f2.setVisible(false);
				f.setVisible(true);
			}
		});
		signupbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				// passwordfield.setText("Shubhharde");
				// confirmpassword.setText("Shubhharde");
				String signupusername = usernamefield.getText();
				String email = emailfield.getText();
				
				String signuppassword = passwordfield.getText();
				String confirmsignuppassword = confirmpassword.getText();
				
				System.out.println(signuppassword);
				System.out.println(confirmsignuppassword);
				
				if(confirmpassword.getText() == passwordfield.getText() )
				{
					try
					{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users","root","");
							Statement stmt = con.createStatement();
							String sql = "INSERT INTO user_data VALUES('"+email+"','"+signupusername+"','"+signuppassword+"')";
							stmt.executeUpdate(sql);
							// while(rs.next())
							// 	System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+ rs.getString(3));
							con.close();
					}catch(Exception e)
					{
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(f2,"You Can Sign In now","Signed Up!",JOptionPane.INFORMATION_MESSAGE);
				}	
				else
				{
					JOptionPane.showMessageDialog(f2,"Passwords do not match","Alert",JOptionPane.ERROR_MESSAGE);
						
				}	

				
			}
		});
	}

}
public class SignUpForm
{
	public static void main(String[] args)
	{
		new SignInForm();
	}
}