package controller;



import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

import BBDD.DatabaseConnection;
import BBDD.DatabaseInsertion;
import BBDD.DatabaseSetup;

public class VideoClub {

	private static VideoClub miVideoClub = new VideoClub();
	private Timer timer = null;
	private int seconds = 0;
	
	private VideoClub() {
		
		//DatabaseSetup.deleteAllData();
		//DatabaseSetup.createTables();
		//DatabaseSetup.checkDB();
		DatabaseSetup.dropDatabase();
		
		latenteBorrar();

	}
	
	public static VideoClub getVC() {
		return miVideoClub;
	}
	
	public void startVC() {
		
	}
	
	public void latenteBorrar() {
		TimerTask timerTask = new TimerTask() {
			public void run() {
				seconds ++;
				
				GestorAlquileres.getGAlquileres().finalizarAlquiler();
				
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
}
