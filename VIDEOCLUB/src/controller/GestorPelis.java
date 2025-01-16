package controller;

import java.util.ArrayList;

import model.Pelicula;

public class GestorPelis {

	private ArrayList<Pelicula> lista;
	private static GestorPelis miGPelis = new GestorPelis();
	
	private GestorPelis() {
		this.lista = new ArrayList<Pelicula>();
	}
	
	public static GestorPelis getGPelis() {
		return miGPelis;
	}

	public void anadirPelicula(Pelicula pelicula) {
		this.lista.add(pelicula);
	}
}
