package edu.ucam.imap_test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Root {
	
	private static final int PORT = 993;
	private static final String HOST = "imap.gmail.com";
	
	public static void main(String[] args) {
		SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket sc = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT)) {
			System.out.println("[OK]");
			
			String username = "alargo@alu.ucam.edu";
			String password = "jwjm iwgs rtal kbcr";
			
			InputStream inputStream = sc.getInputStream();
			OutputStream outputStream = sc.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			PrintWriter writer = new PrintWriter(outputStream, true);
			

			// Read server greeting
            System.out.println("Server Greeting: " + reader.readLine());

            // Send LOGIN command
            writer.println("A1 LOGIN \"" + username + "\" \"" + password + "\"");
            System.out.println("Server Response (LOGIN): " + reader.readLine());

            // Select the INBOX mailbox
            writer.println("A2 SELECT INBOX");
            String response;
            while (!(response = reader.readLine()).startsWith("A2")) {
                System.out.println("Server Response (SELECT): " + response);
            }
            
            // Fetch list of email IDs
            writer.println("A3 SEARCH ALL");
            String emailIdsResponse = reader.readLine();
            System.out.println("Server Response (SEARCH): " + emailIdsResponse);

            String[] parts = emailIdsResponse.split(" ");
            if (parts.length > 2) {
                String emailId = parts[2];

                // Fetch email details
                writer.println("A4 FETCH " + emailId + " (BODY[HEADER])");
                StringBuilder emailHeader = new StringBuilder();
                while (!(response = reader.readLine()).startsWith("A4")) {
                    emailHeader.append(response).append("\n");
                }

                System.out.println("----- Email ID: " + emailId + " -----");
                System.out.println(emailHeader);

                writer.println("A5 FETCH " + emailId + " (BODY[TEXT])");
                StringBuilder emailBody = new StringBuilder();
                while (!(response = reader.readLine()).startsWith("A5")) {
                    emailBody.append(response).append("\n");
                }
                System.out.println("----- Email Body -----");
                System.out.println(emailBody);
            } else {
                System.out.println("No emails found.");
            }

            // Logout
            writer.println("A6 LOGOUT");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
