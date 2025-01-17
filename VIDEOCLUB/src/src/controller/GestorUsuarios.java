package controller;

import java.util.ArrayList;

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
}
