package tela1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cadastro {

	JFrame frmTelaDeCadastro;
	private JTextField userCadastro;
	private JTextField emailCadastro;
	private JTextField senhaCadastro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro window = new cadastro();
					window.frmTelaDeCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeCadastro = new JFrame();
		frmTelaDeCadastro.setTitle("Tela de Cadastro");
		frmTelaDeCadastro.setBounds(100, 100, 450, 300);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home window = new home();
				window.frmHome.setVisible(true);
			}
		});
		voltar.setBounds(229, 193, 89, 23);
		frmTelaDeCadastro.getContentPane().add(voltar);
		
		userCadastro = new JTextField();
		userCadastro.setBounds(122, 55, 196, 20);
		frmTelaDeCadastro.getContentPane().add(userCadastro);
		userCadastro.setColumns(10);
		
		emailCadastro = new JTextField();
		emailCadastro.setBounds(122, 98, 196, 20);
		frmTelaDeCadastro.getContentPane().add(emailCadastro);
		emailCadastro.setColumns(10);
		
		setSenhaCadastro(new JTextField());
		getSenhaCadastro().setBounds(122, 141, 196, 20);
		frmTelaDeCadastro.getContentPane().add(getSenhaCadastro());
		getSenhaCadastro().setColumns(10);
		
		JLabel user = new JLabel("Username:");
		user.setBounds(52, 58, 69, 14);
		frmTelaDeCadastro.getContentPane().add(user);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(52, 101, 46, 14);
		frmTelaDeCadastro.getContentPane().add(email);
		
		JLabel senha = new JLabel("Senha:");
		senha.setBounds(52, 144, 46, 14);
		frmTelaDeCadastro.getContentPane().add(senha);
		
		JButton cadastrado = new JButton("Cadastrar");
		cadastrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objUser user = new objUser();
				user.setUser(userCadastro.getText());
				login login = new login();
				login.exportaUser(user);
				login.exportaValidarUser(user);
				objSenha senha = new objSenha();
				senha.setSenhaCad(getSenhaCadastro().getText());
				login.exportaSenha(senha);

				
				boolean validarNum = (getSenhaCadastro().getText() != null && emailCadastro.getText() != null 
						&& userCadastro.getText() != null && getSenhaCadastro().getText().matches("[0-9]+"));
				if(validarNum == true) { 
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					login.frmTelaDeLogin.setVisible(true);
								
				}else {
					JOptionPane.showMessageDialog(null, "Todos espaços devem ser preenchidos e senha pode conter apenas numeros");
				}

			}

				
		});
		cadastrado.setBounds(110, 193, 89, 23); 
		frmTelaDeCadastro.getContentPane().add(cadastrado);
	}

	public JTextField getSenhaCadastro() {
		return senhaCadastro;
	}

	public void setSenhaCadastro(JTextField senhaCadastro) {
		this.senhaCadastro = senhaCadastro;
	}


}

