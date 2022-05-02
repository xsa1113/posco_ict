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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class updateEx extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateEx frame = new updateEx();
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
	public updateEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("나 이");
		lblNewLabel_5.setBounds(39, 67, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(143, 64, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("변경");
		btnNewButton.setBounds(298, 63, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(39, 42, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 39, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "jdbc:mysql://localhost:3306/web";
				String id = "root";
				String password = "1234";
				String struserid = textField.getText();
				String strage = textField_1.getText();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 로딩
					conn = DriverManager.getConnection(url, id, password);
					
					String sql = "update loginbl set  age = ? where userid = ?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, struserid);
					pstmt.setString(2, strage);
					
					int tmp = pstmt.executeUpdate();
					if(tmp > 0 ) {
						System.out.println("데이터 업데이트 성공");
					}else {
						System.out.println("데이터 업데이트 실패 ");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
	}

}
