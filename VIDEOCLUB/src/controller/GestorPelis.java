package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Alquiler;
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
	
	public Iterator<Pelicula> getIterador(){
		return this.lista.iterator();
	}
	
	public Pelicula buscarPeliculaPorTitulo(String titulo) {
		Iterator<Pelicula> it = GestorPelis.getGPelis().getIterador();
		while (it.hasNext()) {
			Pelicula pelicula = it.next();
			if (pelicula.getTitulo().equals(titulo)) {
				return pelicula;
			}
		}
		return null;
	}
	
	public Pelicula buscarPeliculaPorCodigo(int codPelicula) {
		Iterator<Pelicula> it = GestorPelis.getGPelis().getIterador();
		while (it.hasNext()) {
			Pelicula pelicula = it.next();
			if (pelicula.getCodPeli() == codPelicula) {
				return pelicula;
			}
		}
		return null;
	}

}
