package tela1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class login {

	JFrame frmTelaDeLogin;
	private JTextField userLogin;
	private JTextField senhaLogin;
	public String validarSenha;
	public String validarUser;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmTelaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.setTitle("Tela de Login");
		frmTelaDeLogin.setBounds(100, 100, 450, 300);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeLogin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home window = new home();
				window.frmHome.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(235, 199, 89, 23);
		frmTelaDeLogin.getContentPane().add(btnNewButton);
		
		userLogin = new JTextField();
		userLogin.setBounds(115, 63, 209, 20);
		frmTelaDeLogin.getContentPane().add(userLogin);
		userLogin.setColumns(10);
		
		senhaLogin = new JTextField();
		senhaLogin.setBounds(115, 117, 209, 20);
		frmTelaDeLogin.getContentPane().add(senhaLogin);
		senhaLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(40, 66, 65, 14);
		frmTelaDeLogin.getContentPane().add(lblNewLabel);
		
		JLabel senha = new JLabel("Senha:");
		senha.setBounds(40, 120, 46, 14);
		frmTelaDeLogin.getContentPane().add(senha);
		
		JButton logar = new JButton("Logar");
		logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String result = senhaLogin.getText();
				String userLog = userLogin.getText();
				if(result.equals(validarSenha) == true && userLog.equals(validarUser) == true){
					JOptionPane.showMessageDialog(null, "Login efetuado! ");
					
				}else {
					JOptionPane.showMessageDialog(null, "O usuário não existe ou a senha esta incorreta!");
					
				}
			}
			
		});
		logar.setBounds(115, 199, 89, 23);
		frmTelaDeLogin.getContentPane().add(logar);
	}

	public void exportaUser(objUser user) {
		userLogin.setText(user.getUser());
	}
	public void exportaValidarUser(objUser user) {
		validarUser = user.getUser();
	}
	public void exportaSenha(objSenha senha) {
		validarSenha = senha.getSenhaCad();
	}


}
	
	
