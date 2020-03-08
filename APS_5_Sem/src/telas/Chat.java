package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Chat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMensagem;
	private JTextField textField;
	private JTextField txtPergunta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPergunta = new JTextField();
		txtPergunta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPergunta.setEditable(false);
		txtPergunta.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtPergunta.setColumns(10);
		txtPergunta.setBounds(398, 10, 388, 408);
		contentPane.add(txtPergunta);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setEditable(false);
		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setBounds(10, 10, 388, 408);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollPane.setBounds(10, 10, 776, 408);
		contentPane.add(scrollPane);
		
		txtMensagem = new JTextField();
		txtMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		txtMensagem.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtMensagem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10 & e.isShiftDown() || e.getKeyCode() == 10 & e.isControlDown() || e.getKeyCode() == 10) {
					enviarMensagem();
				}
			}
		});
		txtMensagem.setBounds(10, 424, 696, 139);
		contentPane.add(txtMensagem);
		txtMensagem.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarMensagem();
			}
		});
		btnEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10 & e.isShiftDown() || e.getKeyCode() == 10 & e.isControlDown()) {
					enviarMensagem();
				}
			}
		});
		btnEnviar.setBounds(701, 424, 85, 139);
		contentPane.add(btnEnviar);
	}
	
	public void enviarMensagem() {
		String mensagem = txtMensagem.getText();
		if(!mensagem.isEmpty()) {
			txtPergunta.setText(mensagem);
			txtMensagem.setText(null);
		}
	}
}
