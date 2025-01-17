package controller;

import java.sql.Date;
import java.util.ArrayList;

import BBDD.DatabaseInsertion;
import model.*;

public class GestorUsuarios {

	
	private static GestorUsuarios miGUsuarios = new GestorUsuarios();
	private ArrayList<Usuario> listaUsuarios;
	
	private GestorUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();
	}
	
	public static GestorUsuarios getGUsuarios() {
		return miGUsuarios;
	}
	
	public boolean esAceptadoUsuario(int codUser) {
		boolean valido = false;
		
		for(Usuario u : listaUsuarios) {
			if(u.getCodUsuario() == codUser) {
				if(u.esValidoUsuario()) {
					return true; 
				}
			}
		}
		return valido;
		
	}
	
	public boolean anadirRegistro(String nombre, String correo, String contrasena, String fechaN) {
		//MODFICAR STRING INTO DATE(INT,INT,INT)
		int dia = 0;
		int mes = 0;
		int ano = 0;
		if (ano >= 1) { // Validar año
		    if (mes >= 1 && mes <= 12) { // Validar mes
		        if (dia >= 1 && dia <= diasEnMes(mes, ano)) { // Validar día según mes y año
		            System.out.println("La fecha es válida: " + dia + "/" + mes + "/" + ano);
		        } else {
		            return false;
		        }
		    } else {
		    	return false;
		    }
		} else {
		    return false;
		}
	
		
		for(Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(correo)) {
				return false;
			}
		}
		Date fechaAdaptada = new Date(dia,mes,ano);
		listaUsuarios.add(new Usuario(nombre, correo, contrasena, fechaAdaptada));
		DatabaseInsertion.insertarUsuario(nombre, correo, contrasena, fechaAdaptada);
		return true;
	}
	
	
	public int diasEnMes(int mes, int ano) {
	    switch (mes) {
	        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	            return 31; // Meses con 31 días
	        case 4: case 6: case 9: case 11:
	            return 30; // Meses con 30 días
	        case 2:
	            return esBisiesto(ano) ? 29 : 28; // Febrero
	        default:
	            return 0; // Mes inválido
	    }
	}
	
	
	public boolean esBisiesto(int ano) {
	    return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
	}
	
	public boolean checkLogIn(String email, String password) {
		boolean logInCorrecto = false; 
		for (Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(email) && u.getContrasena().equalsIgnoreCase(password)) {
				return true;
			}
			
		}
		return logInCorrecto;
	}
}
