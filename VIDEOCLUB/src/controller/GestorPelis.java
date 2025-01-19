package controller;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import model.Alquiler;
import model.Pelicula;
import model.Valoracion;

public class GestorPelis {

	private ArrayList<Pelicula> lista;
	private static GestorPelis miGPelis = new GestorPelis();
	
	private GestorPelis() {
		ArrayList<Valoracion> asd = new ArrayList<Valoracion>();
		this.lista = new ArrayList<Pelicula>();
		lista.add(new Pelicula(1,"a","aa","aaa",20202,"a.mp4","aaaa", asd));
		lista.add(new Pelicula(2,"b","bb","bbb",20202,"b.mp4","bbbb", asd));
		lista.add(new Pelicula(3,"c","aa","bbb",20202,"c.mp4","cccc", asd));
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
