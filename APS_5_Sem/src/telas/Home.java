package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField txtTexto;

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(15, 15, 756, 74);
		txtTexto.setEditable(false);
		txtTexto.setHorizontalAlignment(SwingConstants.CENTER);
		txtTexto.setFont(new Font("Calibri", Font.BOLD, 22));
		txtTexto.setText("Texto aleatorio com mensagem aleatoria");
		txtTexto.setColumns(10);
		
		JButton btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chat telaChat = new Chat();
				telaChat.setVisible(true);
				dispose();
			}
		});
		btnChat.setBounds(15, 107, 756, 118);
		btnChat.setFont(new Font("Calibri", Font.BOLD, 22));
		
		JButton button_1 = new JButton("x");
		button_1.setBounds(275, 275, 225, 118);
		button_1.setFont(new Font("Calibri", Font.BOLD, 22));
		
		JButton button_2 = new JButton("x");
		button_2.setBounds(275, 440, 225, 118);
		button_2.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.setLayout(null);
		contentPane.add(txtTexto);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(btnChat);
	}
}
