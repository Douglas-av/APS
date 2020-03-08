package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.DB;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField password;
	private String dbName;

	public Login(String dbName) {
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

		password = new JPasswordField();
		password.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnVoltar = new JButton("Sair");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checar();
				limpar();
			}
		});
		btnConfirmar.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnLimpar = new JButton("Cadastrar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro telaCad = new Cadastro(dbName);
				telaCad.setVisible(true);
				dispose();
			}
		});
		btnLimpar.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(76)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														641, Short.MAX_VALUE)
												.addComponent(textUsuario, Alignment.LEADING)
												.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														647, Short.MAX_VALUE)
												.addComponent(lblSenha, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														641, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 185,
												GroupLayout.PREFERRED_SIZE)
										.addGap(45)
										.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
										.addGap(41).addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 191,
												GroupLayout.PREFERRED_SIZE)
										.addGap(51)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(115)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}

	public void checar() {
		String usuario = textUsuario.getText().strip();
		@SuppressWarnings("deprecation")
		String passwd = password.getText().strip();

		DB banco = new DB(this.dbName);
		banco.connect();
		ResultSet res = banco.query("Select * from usuarios");
		boolean condicao = true;
		try {
			while ((res.next()) & condicao) {
				System.out.println(usuario.equals(res.getString("usuario").strip()));
				if ((usuario.equals(res.getString("usuario").strip())) & (passwd.equals(res.getString("senha").strip()))) {
					Home homePag = new Home();
					homePag.setVisible(true);
					dispose();
					condicao = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (condicao) {
			System.out.println("Usuario ou senha errados!");
		}
	}

	public void limpar() {
		textUsuario.setText("");
		password.setText("");
	}
}
