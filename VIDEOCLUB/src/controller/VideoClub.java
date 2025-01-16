package controller;

import BBDD.DatabaseConnection;
import BBDD.DatabaseInsertion;
import BBDD.DatabaseSetup;

public class VideoClub {

	private static VideoClub miVideoClub = new VideoClub();
	
	private VideoClub() {
		DatabaseSetup.createTables();
		DatabaseInsertion.insertarUsuario(0, "first", "first@firstmai.first", "first123", "no");
	}
	
	public static VideoClub getVC() {
		return miVideoClub;
	}
	
	public void startVC() {
		
	}
}
