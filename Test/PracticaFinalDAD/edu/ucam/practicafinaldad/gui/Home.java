package edu.ucam.practicafinaldad.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ucam.practicafinaldad.back.Email;
import edu.ucam.practicafinaldad.back.TextFieldsManager;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;
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
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	private JButton btnAddNewClient;
	private JButton btnNewConfg;
	private Map<String, IMAPConnection> imapConnectionsMap;
	private NewConfigButton newConfigButton;
	private AddNewClientButton addNewClient;
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

	/**
	 * Create HOME.
	 */
	public Home(User user) {
		setTitle("IMAP Controller");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewConfg = new JButton("NEW CONFIG ");
		btnNewConfg.setBackground(SystemColor.scrollbar);
		btnNewConfg.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnNewConfg.setBounds(10, 415, 116, 35);
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
		btnConnect.setBounds(10, 369, 232, 35);
		contentPane.add(btnConnect);
		
		btnAddNewClient = new JButton("ADD CLIENT");
		btnAddNewClient.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 12));
		btnAddNewClient.setBackground(SystemColor.scrollbar);
		btnAddNewClient.setBounds(136, 415, 106, 35);
		contentPane.add(btnAddNewClient);
		
		if (user != null && user.getAdmin()) {
			btnAddNewClient.setEnabled(true);
			btnAddNewClient.setVisible(true);
        } else {
        	btnAddNewClient.setEnabled(false);
            btnAddNewClient.setVisible(false);
            
            btnNewConfg.setBounds(10, 389, 232, 35);
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
		lblNumEmails.setBounds(84, 332, 58, 26);
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
		
		addNewClient = new AddNewClientButton();
		btnAddNewClient.addActionListener(addNewClient);
		
		boxSelectionButton = new ComboBoxSelectionButton(cbxConnections, txtHost, txtPort);
		cbxConnections.addActionListener(boxSelectionButton);
		
		textFieldsManager = new TextFieldsManager(txtHost, txtPort, txtMail, txtMailPswd, txtAmount);
		connectionButton = new ConnectionButton(textFieldsManager, tableModel, progressBar, lblStatus);
		btnConnect.addActionListener(connectionButton);
		
		emailTable = new JTable(tableModel);
		configureTableSelectionListener(emailTable, tableModel);
		JScrollPane scrollPane = new JScrollPane(emailTable);
		scrollPane.setBounds(252, 49, 524, 343);
		contentPane.add(scrollPane);
		
	}
	
	public void fillComboBox(List<IMAPConnection> connectionsList, JComboBox<String> comboBox){
        comboBox.removeAllItems();
        
        for (IMAPConnection connection : connectionsList) {
            comboBox.addItem(connection.getEmail());
            imapConnectionsMap.put(connection.getEmail(), connection);
        }
    }
	
    public void configureTableSelectionListener(JTable table, EmailTableModel tableModel) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        Email selectedEmail = tableModel.getEmailAt(selectedRow);
                        if (selectedEmail != null) {
                            showEmailDialog(selectedEmail);
                        }
                    }
                }
            }
        });
    }

    public void showEmailDialog(Email email) {
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setText("Subject: " + email.getSubject() + "\n\n" + email.getBody());
        textArea.setWrapStyleWord(true); // activar el salto de palabras
        textArea.setLineWrap(true); // activar el salto de línea
        textArea.setCaretPosition(0); // poner el cursor al principio del texto
        textArea.setEditable(false); // hacer que el área de texto no sea editable
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "Email Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
