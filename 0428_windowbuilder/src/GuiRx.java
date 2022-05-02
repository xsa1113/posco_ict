import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GuiRx extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel result;
	private JLabel name;
	private JLabel vage;
	private JLabel telno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRx frame = new GuiRx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiRx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("아이디");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 73, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 53, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비번");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 35, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("로그인");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -68, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -80, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String url = "jdbc:mysql://localhost:3306/web";
				String id = "root";
				String password = "1234";
				String strUserid = textField.getText();
				String strPwd = String.valueOf(passwordField.getPassword());
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					System.out.println("1");
					Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 로딩
					conn = DriverManager.getConnection(url, id, password);
					
					String sql = "select * from loginbl where userid = ? and pwd = ?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, strUserid);
					pstmt.setString(2, strPwd);
					
					rs = pstmt.executeQuery();
					if(rs.next()) {
//						result.setText(rs.getString("name") + " 님 환영 합니다.");
						name.setText(rs.getString("name"));
						vage.setText(rs.getString("age"));
						System.out.println(rs.getString("age"));
						System.out.println(rs.getInt("age"));
						telno.setText(rs.getString("tel"));
					}else {
						result.setText("아이디 또는 비밀번호가 일치하지 않습니다");
						name.setText("");
						vage.setText("");
						telno.setText("");
						
					}
				}catch(Exception e2){
					e2.printStackTrace();
					
				}
				
			}
		});		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 22, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, 150, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(passwordField);
		
		result = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, result, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, result, 61, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, result, -72, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, result, -40, SpringLayout.WEST, btnNewButton);
		contentPane.add(result);
		
		JLabel lblNewLabel_2 = new JLabel("이      름");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, result);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -48, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -320, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("나      이");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -5, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 109, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
		name = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.SOUTH, result);
		sl_contentPane.putConstraint(SpringLayout.WEST, name, 36, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(name);
		
		vage = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, vage, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, vage, 0, SpringLayout.WEST, name);
		contentPane.add(vage);
		
		telno = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, telno, 0, SpringLayout.WEST, name);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, telno, 0, SpringLayout.SOUTH, lblNewLabel_4);
		contentPane.add(telno);
	}
}
