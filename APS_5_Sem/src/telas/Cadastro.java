package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.CriarConexaoDB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField password;
	private JTextField textIdade;
	private String dbName;

	public Cadastro(String dbName) {
		this.dbName = dbName;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Calibri", Font.BOLD, 20));
		textUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Calibri", Font.BOLD, 20));
		textEmail.setColumns(10);

		password = new JPasswordField();
		password.setFont(new Font("Calibri", Font.BOLD, 20));

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Calibri", Font.BOLD, 20));

		textIdade = new JTextField();
		textIdade.setFont(new Font("Calibri", Font.BOLD, 20));
		textIdade.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login telaLogin = new Login(dbName);
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirBanco();
				limpar();
			}
		});
		btnConfirmar.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(76)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 641,
										Short.MAX_VALUE)
								.addComponent(textUsuario, Alignment.LEADING)
								.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 647,
										Short.MAX_VALUE)
								.addComponent(lblSenha, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 641,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addGap(45).addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addGap(41).addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 191,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
						.addComponent(textIdade, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
				.addGap(51)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(30)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}

	public void inserirBanco() {
		String usuario = textUsuario.getText();
		@SuppressWarnings("deprecation")
		String passwd = password.getText();
		String email = textEmail.getText();
		String idade = textIdade.getText();

		if ((!usuario.isBlank()) & (!passwd.isBlank()) & (!email.isBlank())) {
			System.out.println("Entrou");
			CriarConexaoDB banco = new CriarConexaoDB(this.dbName);
			banco.connect();

			String query = "INSERT INTO usuarios values(null,";
			query += "'" + usuario + "', ";
			query += "'" + passwd + "', ";
			query += "'" + email + "', ";
			query += "'" + idade + "');";
			System.out.println(query);
			banco.execQuery(query);
			System.out.println("Adicionado!");
		}
	}

	public void limpar() {
		textUsuario.setText("");
		textIdade.setText("");
		textEmail.setText("");
		password.setText("");
	}
}
