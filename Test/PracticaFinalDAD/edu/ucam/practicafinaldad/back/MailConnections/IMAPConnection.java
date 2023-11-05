package edu.ucam.practicafinaldad.back.MailConnections;

import java.io.*;
import javax.net.ssl.*;

public class IMAPConnection extends Connections {

    private int imapId;
    private SSLSocket sc;
    private BufferedReader reader;
    private PrintWriter writer;
    private String host;
    private int port;

    public IMAPConnection(int imapId, String userId, String email, String pswdMail) {
        super(userId, email, pswdMail);
        this.imapId = imapId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPswdMail() {
        return pswdMail;
    }
    
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void connect() throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        this.sc = (SSLSocket) sslSocketFactory.createSocket(this.host, this.port);
        System.out.println("[OK]");
        this.reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        this.writer = new PrintWriter(sc.getOutputStream(), true);
    }

    public String getGreeting() throws IOException {
        return reader.readLine();
    }

    public void login(String email, String password) throws IOException {
    	writer.println("A1 LOGIN \"" + email + "\" \"" + password + "\"");
        System.out.println("Server Response (LOGIN): " + reader.readLine());
    }

    public void selectMailbox(String mailbox) throws IOException {
        writer.println("A2 SELECT " + mailbox);
        String response;
        while (!(response = reader.readLine()).startsWith("A2")) {
        	System.out.println("Server Response (SELECT): " + response);
        }
    }

    public String[] fetchEmailIDs() throws IOException {
        writer.println("A3 SEARCH ALL");
        String response = reader.readLine();
        return response.substring(response.indexOf(' ') + 1).split(" ");
    }

    public String fetchEmailSubject(String emailId) throws IOException {
        writer.println("A4 FETCH " + emailId + " (BODY[HEADER.FIELDS (FROM SUBJECT DATE)])");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).startsWith("A4")) {
            sb.append(line).append("\n");
        }
        return sb.toString().trim();
    }

    public String fetchEmailBody(String emailId) throws IOException {
        writer.println("A5 FETCH " + emailId + " (BODY[TEXT])");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).startsWith("A5")) {
            sb.append(line).append("\n");
        }
        return sb.toString().trim();
    }
    
    public void deleteEmail(String emailId) throws IOException {
        // Marca el email como eliminado
        writer.println("A7 STORE " + emailId + " +FLAGS (\\Deleted)");
        String response;
        while (!(response = reader.readLine()).startsWith("A7")) {
            System.out.println("Server Response (DELETE MARK): " + response);
        }

        // Expulsa el email marcado como eliminado
        writer.println("A8 EXPUNGE");
        while (!(response = reader.readLine()).startsWith("A8")) {
            System.out.println("Server Response (EXPUNGE): " + response);
        }
    }

    public void logout() {
        writer.println("A6 LOGOUT");
    }

    public void close() throws IOException {
        if (reader != null) reader.close();
        if (writer != null) writer.close();
        if (sc != null) sc.close();
    }

    public int getImapId() {
        return imapId;
    }

    public void setImapId(int imapId) {
        this.imapId = imapId;
    }

    @Override
    public String toString() {
        return "IMAPConnection{" +
               "imapId=" + imapId +
               ", userId=" + getUserId() +
               ", email=" + getEmail() +
               ", pswdMail=" + getPswdMail() +
               '}';
    }
}

