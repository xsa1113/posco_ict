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

public class deleteEx extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteEx frame = new deleteEx();
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
	public deleteEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원아이디");
		lblNewLabel.setBounds(42, 76, 84, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 73, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.setBounds(280, 72, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel notice = new JLabel("");
		notice.setBounds(146, 141, 197, 15);
		contentPane.add(notice);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "jdbc:mysql://localhost:3306/web";
				String id = "root";
				String password = "1234";
				String struserid = textField.getText();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 로딩
					conn = DriverManager.getConnection(url, id, password);
					
					String sql = "delete from loginbl where name = ?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, struserid);
					
					int tmp = pstmt.executeUpdate();
					if(tmp > 0 ) {
						System.out.println("데이터 삭제 성공");
					}else {
						System.out.println("데이터 삭제 실패 ");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		
	}

}
