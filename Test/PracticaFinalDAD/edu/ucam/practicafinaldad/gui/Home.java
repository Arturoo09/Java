package edu.ucam.practicafinaldad.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.gui.buttons.AddNewClientButton;
import edu.ucam.practicafinaldad.gui.buttons.ComboBoxSelectionButton;
import edu.ucam.practicafinaldad.gui.buttons.NewConfigButton;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FONT = "Hack Nerd Font Propo";
	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtPort;
	private JLabel lblPort;
	private JLabel lblHost;
	private JButton btnConnect;
	private JComboBox<String> cbxConnections;
	private JButton btnAddNewClient;
	
	private NewConfigButton newConfigButton;
	private AddNewClientButton addNewClient;
	private ComboBoxSelectionButton boxSelectionButton;


	/**
	 * Create HOME.
	 */
	public Home(User user) {
		setTitle("IMAP Controller");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewConfg = new JButton("NEW CONFIG ");
		btnNewConfg.setBackground(SystemColor.scrollbar);
		btnNewConfg.setFont(new Font(FONT, Font.BOLD, 14));
		btnNewConfg.setBounds(33, 63, 132, 46);
		contentPane.add(btnNewConfg);
		
		cbxConnections = new JComboBox<>();
		cbxConnections.setEnabled(false);
		cbxConnections.setVisible(false);
		cbxConnections.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "IMAP", "SMTP"}));
		cbxConnections.setBounds(193, 77, 132, 22);
		contentPane.add(cbxConnections);
		
		txtHost = new JTextField();
		txtHost.setEnabled(false);
		txtHost.setVisible(false);
		txtHost.setBounds(361, 75, 116, 27);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		lblHost = new JLabel("HOST");
		lblHost.setEnabled(false);
		lblHost.setVisible(false);
		lblHost.setFont(new Font(FONT, Font.BOLD, 14));
		lblHost.setBounds(399, 50, 46, 14);
		contentPane.add(lblHost);
		
		lblPort = new JLabel("PORT");
		lblPort.setEnabled(false);
		lblPort.setVisible(false);
		lblPort.setFont(new Font(FONT, Font.BOLD, 14));
		lblPort.setBounds(535, 50, 46, 14);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setVisible(false);
		txtPort.setEnabled(false);
		txtPort.setColumns(10);
		txtPort.setBounds(495, 75, 116, 27);
		contentPane.add(txtPort);
		
		btnConnect = new JButton("CONNECT");
		btnConnect.setEnabled(false);
		btnConnect.setVisible(false);
		btnConnect.setFont(new Font(FONT, Font.BOLD, 14));
		btnConnect.setBackground(SystemColor.scrollbar);
		btnConnect.setBounds(631, 70, 115, 35);
		contentPane.add(btnConnect);
		
		btnAddNewClient = new JButton("ADD CLIENT");
		btnAddNewClient.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		btnAddNewClient.setBackground(SystemColor.scrollbar);
		btnAddNewClient.setBounds(631, 12, 115, 27);
		contentPane.add(btnAddNewClient);
		
		if (user != null && user.getAdmin()) {
			btnAddNewClient.setEnabled(true);
			btnAddNewClient.setVisible(true);
        } else {
        	btnAddNewClient.setEnabled(false);
            btnAddNewClient.setVisible(false);
        }
		
		JLabel lblTitleWelcome = new JLabel("Bienvenido " + user.getUsername());
		lblTitleWelcome.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 18));
		lblTitleWelcome.setBounds(10, 11, 306, 27);
		contentPane.add(lblTitleWelcome);
		
		newConfigButton = new NewConfigButton(this);
		btnNewConfg.addActionListener(newConfigButton);
		
		addNewClient = new AddNewClientButton();
		btnAddNewClient.addActionListener(addNewClient);
		
		boxSelectionButton = new ComboBoxSelectionButton(cbxConnections, txtHost, txtPort);
		cbxConnections.addActionListener(boxSelectionButton);
		
	}
	
	public void showConnectionFields(boolean show) {
	    lblHost.setEnabled(show);
	    lblPort.setEnabled(show);
	    cbxConnections.setEnabled(show);
	    txtPort.setEnabled(show);
	    txtHost.setEnabled(show);
	    btnConnect.setEnabled(show);
	    
	    lblHost.setVisible(show);
	    lblPort.setVisible(show);
	    cbxConnections.setVisible(show);
	    txtPort.setVisible(show);
	    txtHost.setVisible(show);
	    btnConnect.setVisible(show);
	}

}
