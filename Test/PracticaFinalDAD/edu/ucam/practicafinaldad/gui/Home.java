package edu.ucam.practicafinaldad.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import edu.ucam.practicafinaldad.back.TextFieldsManager;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;
import edu.ucam.practicafinaldad.gui.buttons.OpenUsersManagerButton;
import edu.ucam.practicafinaldad.gui.buttons.ComboBoxSelectionButton;
import edu.ucam.practicafinaldad.gui.buttons.ComboBoxSelectionConnectionButton;
import edu.ucam.practicafinaldad.gui.buttons.ConnectionButton;
import edu.ucam.practicafinaldad.gui.buttons.DeleteEmailButton;
import edu.ucam.practicafinaldad.gui.buttons.NewConfigButton;
import edu.ucam.practicafinaldad.gui.buttons.PreviewEmailButton;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;

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
	private JButton btnUsers;
	private JButton btnNewConfg;
	private Map<String, IMAPConnection> imapConnectionsMap;
	private NewConfigButton newConfigButton;
	private OpenUsersManagerButton addNewClient;
	private ComboBoxSelectionButton boxSelectionButton;
	private ComboBoxSelectionConnectionButton cbxSelectionConnectionButton;
	private JPasswordField txtMailPswd;
	private JTextField txtMail;
	private JLabel lblStatus;
	private ConnectionButton connectionButton;
	private TextFieldsManager textFieldsManager;
	private JTable emailTable;
    private EmailTableModel tableModel;
    private JTextField txtAmount;
    
    // Entrega Final
    private JButton btnPreview;
    private PreviewEmailButton previewEmailButton;
    private JButton btnDelete;
    private DeleteEmailButton deleteEmailButton;
    private JButton btnNewFolder;
    private JButton btnListEmails;

	/**
	 * Create HOME.
	 */
	public Home(User user) {
		setTitle("IMAP Controller");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewConfg = new JButton("NEW CONFIG ");
		btnNewConfg.setBackground(SystemColor.scrollbar);
		btnNewConfg.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnNewConfg.setBounds(10, 415, 232, 35);
		contentPane.add(btnNewConfg);
		
		cbxConnections = new JComboBox<>();
		cbxConnections.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "IMAP", "SMTP"}));
		cbxConnections.setBounds(10, 66, 116, 22);
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
		btnConnect.setBounds(10, 369, 232, 41);
		contentPane.add(btnConnect);
		
		btnUsers = new JButton("USERS");
		btnUsers.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnUsers.setBackground(SystemColor.scrollbar);
		btnUsers.setBounds(786, 269, 116, 118);
		contentPane.add(btnUsers);
		
		if (user != null && user.getAdmin()) {
			btnUsers.setEnabled(true);
			btnUsers.setVisible(true);
        } else {
        	btnUsers.setEnabled(false);
            btnUsers.setVisible(false);
        }
		
		JLabel lblTitleWelcome = new JLabel("Bienvenido " + user.getUsername());
		lblTitleWelcome.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 18));
		lblTitleWelcome.setBounds(10, 11, 766, 27);
		contentPane.add(lblTitleWelcome);
		
		txtMailPswd = new JPasswordField();
		txtMailPswd.setColumns(10);
		txtMailPswd.setBounds(10, 294, 232, 27);
		contentPane.add(txtMailPswd);
		
		JLabel lblUserMailPswd = new JLabel("TOKEN");
		lblUserMailPswd.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblUserMailPswd.setBounds(26, 269, 46, 14);
		contentPane.add(lblUserMailPswd);
		
		JLabel lblUserMail = new JLabel("MAIL");
		lblUserMail.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblUserMail.setBounds(26, 206, 46, 14);
		contentPane.add(lblUserMail);
		
		JComboBox<String> cbxMailConnections = new JComboBox<>();
		cbxMailConnections.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna"}));
		cbxMailConnections.setBounds(10, 173, 232, 22);
		contentPane.add(cbxMailConnections);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(152, 332, 90, 26);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblNumEmails = new JLabel("AMOUNT");
		lblNumEmails.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblNumEmails.setBounds(92, 332, 58, 26);
		contentPane.add(lblNumEmails);
		
		lblStatus = new JLabel("[*] NOT CONNECT...");
		lblStatus.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblStatus.setBounds(252, 403, 524, 14);
		contentPane.add(lblStatus);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(252, 428, 524, 22);
		contentPane.add(progressBar);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(10, 231, 232, 27);
		contentPane.add(txtMail);
		
		tableModel = new EmailTableModel(new ArrayList<>());
		
		imapConnectionsMap = new HashMap<>();
        fillComboBox(user.getConnections(), cbxMailConnections);

        cbxSelectionConnectionButton = new ComboBoxSelectionConnectionButton(cbxMailConnections, txtMail, txtMailPswd, imapConnectionsMap);
        cbxMailConnections.addActionListener(cbxSelectionConnectionButton);
		
		newConfigButton = new NewConfigButton(user, this);
		btnNewConfg.addActionListener(newConfigButton);
		
		addNewClient = new OpenUsersManagerButton();
		btnUsers.addActionListener(addNewClient);
		
		boxSelectionButton = new ComboBoxSelectionButton(cbxConnections, txtHost, txtPort);
		cbxConnections.addActionListener(boxSelectionButton);
		
		textFieldsManager = new TextFieldsManager(txtHost, txtPort, txtMail, txtMailPswd, txtAmount);
		connectionButton = new ConnectionButton(user, textFieldsManager, tableModel, progressBar, lblStatus);
		btnConnect.addActionListener(connectionButton);
		
		emailTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(emailTable);
		scrollPane.setBounds(252, 49, 524, 343);
		contentPane.add(scrollPane);
		
		// BOTONES ENTREGA FINAL 
		// -------------------------------------------------------------------------------------------
		btnPreview = new JButton("PREVIEW");
		btnPreview.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnPreview.setBackground(SystemColor.scrollbar);
		btnPreview.setBounds(786, 52, 116, 35);
		contentPane.add(btnPreview);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnDelete.setBackground(SystemColor.scrollbar);
		btnDelete.setBounds(786, 99, 116, 35);
		contentPane.add(btnDelete);
		
		btnNewFolder = new JButton("NEW FOLDER");
		btnNewFolder.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnNewFolder.setBackground(SystemColor.scrollbar);
		btnNewFolder.setBounds(786, 145, 116, 35);
		contentPane.add(btnNewFolder);
		
		btnListEmails = new JButton("LIST EMAILS");
		btnListEmails.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnListEmails.setBackground(SystemColor.scrollbar);
		btnListEmails.setBounds(786, 191, 116, 35);
		contentPane.add(btnListEmails);
		
		previewEmailButton = new PreviewEmailButton(emailTable, tableModel);
		btnPreview.addActionListener(previewEmailButton);
		
		deleteEmailButton = new DeleteEmailButton(emailTable, tableModel, txtMail, user, lblStatus);
		btnDelete.addActionListener(deleteEmailButton);
		
		// -------------------------------------------------------------------------------------------
	}
	
	public void fillComboBox(List<IMAPConnection> connectionsList, JComboBox<String> comboBox){
        comboBox.removeAllItems();
        
        for (IMAPConnection connection : connectionsList) {
            comboBox.addItem(connection.getEmail());
            imapConnectionsMap.put(connection.getEmail(), connection);
        }
    }
}
