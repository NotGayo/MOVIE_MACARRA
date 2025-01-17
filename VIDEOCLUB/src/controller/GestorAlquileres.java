package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Alquiler;
import model.Pelicula;
import model.Usuario;

public class GestorAlquileres {

	private static GestorAlquileres miGAlquileres = new GestorAlquileres();
	private ArrayList<Alquiler> lista;
	
	private GestorAlquileres() {
		lista = new ArrayList<Alquiler>();
	}
	
	public static GestorAlquileres getGAlquileres() {
		return miGAlquileres;
	}
	
	private Iterator<Alquiler> getIterador(){
		return this.lista.iterator();
	}
	
	public Alquiler crearAlquiler(Usuario usuario, Pelicula pelicula) {
		return Alquiler.crearAlquiler(usuario,pelicula); 
	}
	
	public void anadirAlquiler(Alquiler alquiler) {
		this.lista.add(alquiler);
	}
	
	public void finalizarAlquiler(){
		Iterator<Alquiler> itr = this.getIterador();
		Alquiler unAlquiler;
		while(itr.hasNext()) {
			unAlquiler = itr.next();
			if (unAlquiler.haFinalizado()) {
				itr.remove();
			}
		}
	}

}
