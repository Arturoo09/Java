package edu.ucam.practicafinaldad.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.gui.buttons.AddNewClientButton;
import edu.ucam.practicafinaldad.gui.buttons.ComboBoxSelectionButton;
import edu.ucam.practicafinaldad.gui.buttons.ComboBoxSelectionConnectionButton;
import edu.ucam.practicafinaldad.gui.buttons.ConnectionButton;
import edu.ucam.practicafinaldad.gui.buttons.NewConfigButton;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<String, IMAPConnection> imapConnectionsMap;
	private NewConfigButton newConfigButton;
	private AddNewClientButton addNewClient;
	private ComboBoxSelectionButton boxSelectionButton;
	private JTextField txtMailPswd;
	private JTextField txtMail;
	private ConnectionButton connectionButton;

	/**
	 * Create HOME.
	 */
	public Home(User user) {
		setTitle("IMAP Controller");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewConfg = new JButton("NEW CONFIG ");
		btnNewConfg.setBackground(SystemColor.scrollbar);
		btnNewConfg.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnNewConfg.setBounds(10, 378, 116, 46);
		contentPane.add(btnNewConfg);
		
		cbxConnections = new JComboBox<>();
		cbxConnections.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "IMAP", "SMTP"}));
		cbxConnections.setBounds(10, 64, 116, 22);
		contentPane.add(cbxConnections);
		
		txtHost = new JTextField();
		txtHost.setBounds(10, 124, 116, 27);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		lblHost = new JLabel("HOST");
		lblHost.setFont(new Font(FONT, Font.BOLD, 14));
		lblHost.setBounds(20, 99, 39, 14);
		contentPane.add(lblHost);
		
		lblPort = new JLabel("PORT");
		lblPort.setFont(new Font(FONT, Font.BOLD, 14));
		lblPort.setBounds(162, 99, 39, 14);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(152, 124, 90, 27);
		contentPane.add(txtPort);
		
		btnConnect = new JButton("CONNECT");
		btnConnect.setFont(new Font(FONT, Font.BOLD, 14));
		btnConnect.setBackground(SystemColor.scrollbar);
		btnConnect.setBounds(10, 332, 232, 35);
		contentPane.add(btnConnect);
		
		btnAddNewClient = new JButton("ADD CLIENT");
		btnAddNewClient.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnAddNewClient.setBackground(SystemColor.scrollbar);
		btnAddNewClient.setBounds(136, 378, 106, 46);
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
		
		txtMailPswd = new JTextField();
		txtMailPswd.setColumns(10);
		txtMailPswd.setBounds(10, 294, 232, 27);
		contentPane.add(txtMailPswd);
		
		JLabel lblUserMailPswd = new JLabel("PSWD");
		lblUserMailPswd.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblUserMailPswd.setBounds(26, 269, 32, 14);
		contentPane.add(lblUserMailPswd);
		
		JLabel lblUserMail = new JLabel("MAIL");
		lblUserMail.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblUserMail.setBounds(26, 206, 46, 14);
		contentPane.add(lblUserMail);
		
		JComboBox<String> cbxMailConnections = new JComboBox<>();
		cbxMailConnections.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna"}));
		cbxMailConnections.setBounds(10, 175, 232, 22);
		contentPane.add(cbxMailConnections);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(10, 231, 232, 27);
		contentPane.add(txtMail);
		
		imapConnectionsMap = new HashMap<>();
        fillComboBox(user.getConnections(), cbxMailConnections);

        ComboBoxSelectionConnectionButton actionListener = new ComboBoxSelectionConnectionButton(
            cbxMailConnections, txtMail, txtMailPswd, imapConnectionsMap
        );
        cbxMailConnections.addActionListener(actionListener);
		
		newConfigButton = new NewConfigButton(user);
		btnNewConfg.addActionListener(newConfigButton);
		
		addNewClient = new AddNewClientButton();
		btnAddNewClient.addActionListener(addNewClient);
		
		boxSelectionButton = new ComboBoxSelectionButton(cbxConnections, txtHost, txtPort);
		cbxConnections.addActionListener(boxSelectionButton);
		
		connectionButton = new ConnectionButton(txtHost, txtPort, txtMail, txtMailPswd);
		btnConnect.addActionListener(connectionButton);
		
	}
	
	public void fillComboBox(List<IMAPConnection> connectionsList, JComboBox<String> comboBox){
        comboBox.removeAllItems();
        
        for (IMAPConnection connection : connectionsList) {
            comboBox.addItem(connection.getEmail());
            imapConnectionsMap.put(connection.getEmail(), connection);
        }
    }
}
