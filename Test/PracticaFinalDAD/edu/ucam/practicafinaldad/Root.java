package edu.ucam.practicafinaldad;
import java.awt.EventQueue;

import edu.ucam.practicafinaldad.back.connectionDB.MySQL.DatabaseManager;
import edu.ucam.practicafinaldad.gui.LogIn;

public class Root {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseManager dbManager = new DatabaseManager();
//					FileManager fileManager = new FileManager("C:\\Users\\34625\\git\\Java\\Test\\PracticaFinalDAD\\edu\\ucam\\practicafinaldad\\dad_database.csv");
			        
					dbManager.ensureAdminUserExists();
//			        fileManager.ensureAdminUserExists();
					
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
