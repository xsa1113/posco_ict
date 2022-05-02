import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class InsertEx extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertEx frame = new InsertEx();
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
	public InsertEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel vid = new JLabel("회원아이디");
		vid.setBounds(12, 27, 72, 15);
		contentPane.add(vid);
		
		textField = new JTextField();
		textField.setBounds(118, 24, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(118, 90, 116, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(118, 140, 116, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(118, 182, 116, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(118, 218, 116, 21);
		contentPane.add(textField_5);
		
		JLabel vpassword = new JLabel("비밀번호");
		vpassword.setBounds(12, 93, 72, 15);
		contentPane.add(vpassword);
		
		JLabel vname = new JLabel("이    름");
		vname.setBounds(12, 143, 72, 15);
		contentPane.add(vname);
		
		JLabel vage = new JLabel("나    이");
		vage.setBounds(12, 185, 72, 15);
		contentPane.add(vage);
		
		JLabel vtel = new JLabel("전화번호");
		vtel.setBounds(12, 221, 72, 15);
		contentPane.add(vtel);
		
		JButton btnNewButton = new JButton("삽 입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "jdbc:mysql://localhost:3306/web";
				String id = "root";
				String password = "1234";
				String struserid = textField.getText();
				String strpwd = textField_2.getText();
				String strname = textField_3.getText();
				String strage = textField_4.getText();
				String stel = textField_5.getText();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 로딩
					conn = DriverManager.getConnection(url, id, password);
					
					String sql = "insert into loginbl values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, struserid);
					pstmt.setString(2, strpwd);
					pstmt.setString(3, strname);
					pstmt.setString(4, strage);
					pstmt.setString(5, stel);
					
					int tmp = pstmt.executeUpdate();
					if(tmp > 0 ) {
						System.out.println("데이터 입력 성공");
					}else {
						System.out.println("데이터 입력 실패 ");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(286, 206, 97, 23);
		contentPane.add(btnNewButton);
	}
}
