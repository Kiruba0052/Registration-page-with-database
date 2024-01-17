import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class Registrationform implements ActionListener{
JFrame frame;
String[] language={"Tamil","English"};
JLabel nameL=new JLabel("Name");
JLabel languageL=new JLabel("Languages Known:");
JLabel aaddarnoL=new JLabel("Aaddar No");
JLabel passwordL=new JLabel("Password");
JLabel confirmpasswordL=new JLabel("Confirm Password");
JLabel pincodeL=new JLabel("Pincode");
JLabel emailL=new JLabel("EmailID");
JTextField nameT=new JTextField();
JComboBox languageC=new JComboBox(language);
JTextField aaddarnoT=new JTextField();
JPasswordField passwordF=new JPasswordField();
JPasswordField confirmpasswordF=new JPasswordField();
JTextField pincodeT=new JTextField();
JTextField emailT=new JTextField();
JButton registerB=new JButton("Register");
JButton resetB=new JButton("Reset");

Registrationform()
{
createWindow();
setLocationAndSize();
addComponentsToFrame();
actionEvent();
}

public void createWindow()
{
frame=new JFrame();
frame.setTitle("REGISTRATION FORM FOR AADHAR ENROLLMENT");
frame.setBounds(40,40,500,700);
frame.getContentPane().setBackground(Color.orange);
frame.getContentPane().setLayout(null);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
}

public void setLocationAndSize()
{
nameL.setBounds(20,20,40,70);
languageL.setBounds(20,70,80,70);
aaddarnoL.setBounds(20,120,100,70);
passwordL.setBounds(20,170,100,70);
confirmpasswordL.setBounds(20,220,140,70);
pincodeL.setBounds(20,270,100,70);
emailL.setBounds(20,320,100,70);
nameT.setBounds(180,43,165,23);
languageC.setBounds(180,93,165,23);
aaddarnoT.setBounds(180,143,165,23);
passwordF.setBounds(180,193,165,23);
confirmpasswordF.setBounds(180,245,165,23);
pincodeT.setBounds(180,293,165,23);
emailT.setBounds(180,343,165,23);
registerB.setBounds(70,500,100,35);
resetB.setBounds(220,500,100,35);
}

public void addComponentsToFrame()
{
frame.add(nameL);
frame.add(languageL);
frame.add(aaddarnoL);
frame.add(passwordL);
frame.add(confirmpasswordL);
frame.add(pincodeL);
frame.add(emailL);
frame.add(nameT);
frame.add(languageC);
frame.add(aaddarnoT);
frame.add(passwordF);
frame.add(confirmpasswordF);
frame.add(pincodeT);
frame.add(emailT);
frame.add(registerB);
frame.add(resetB);
}

public void actionEvent()
{
registerB.addActionListener(this);
resetB.addActionListener(this);
}

public void actionPerformed(ActionEvent e){
if(e.getSource()==registerB)
{
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kiruba?","cscudt","password");
PreparedStatement Pstatement=con.prepareStatement("insert into stu values(?,?,?,?,?,?,?)");
Pstatement.setString(1,nameT.getText());
Pstatement.setString(2,languageC.getSelectedItem().toString());
Pstatement.setString(3,aaddarnoT.getText());
Pstatement.setString(4,passwordF.getText());
Pstatement.setString(5,confirmpasswordF.getText());
Pstatement.setString(6,pincodeT.getText());
Pstatement.setString(7,emailT.getText());
if(passwordF.getText().equalsIgnoreCase(confirmpasswordF.getText()))
{
Pstatement.executeUpdate();
JOptionPane.showMessageDialog(null,"Data Registered Successfully");
}
else
{
JOptionPane.showMessageDialog(null,"password didn't match");
}
}
catch(Exception a){
System.out.println(a);
}
}
if(e.getSource()==resetB)
{
nameT.setText("");
languageC.setSelectedItem("English");
aaddarnoT.setText("");
passwordF.setText("");
confirmpasswordF.setText("");
pincodeT.setText("");
emailT.setText("");
}
}
}
public class Regform{
public static void main(String args[]){
new Registrationform();
}
}










