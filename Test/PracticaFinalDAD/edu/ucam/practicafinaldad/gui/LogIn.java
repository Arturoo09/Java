package edu.ucam.practicafinaldad.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import edu.ucam.practicafinaldad.gui.buttons.LogInButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String FONT = "Hack Nerd Font Propo";
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private LogInButton logInButton;
    

    /**
     * Create LOGIN.
     */
    public LogIn() {
    	setTitle("LOGIN");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
    	setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 258, 164);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font(FONT, Font.BOLD, 14));
        lblUsername.setBounds(10, 34, 64, 17);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font(FONT, Font.BOLD, 14));
        lblPassword.setBounds(10, 62, 64, 17);
        contentPane.add(lblPassword);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(100, 33, 118, 20);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);
        
        txtPassword = new JPasswordField();
        txtPassword.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                     // Simula un clic en el botón "LOG IN" cuando se presiona "Enter"
                     logInButton.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                 }
        	}
        });
        txtPassword.setColumns(10);
        txtPassword.setBounds(100, 61, 118, 20);
        contentPane.add(txtPassword);
        
        JButton btnLogIn = new JButton("LOG IN");
        btnLogIn.setBackground(SystemColor.scrollbar);
        btnLogIn.setFont(new Font(FONT, Font.BOLD, 14));
        btnLogIn.setBounds(100, 92, 118, 23);
        contentPane.add(btnLogIn);
        
        logInButton = new LogInButton(txtUsername, txtPassword);
        
        btnLogIn.addActionListener(logInButton);
    }
}