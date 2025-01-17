package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Valoracion;

public class GestorValoraciones {

	private ArrayList<Valoracion> lista;
	private static GestorValoraciones miGV = new GestorValoraciones();
	
	private GestorValoraciones() {
		this.lista = new ArrayList<Valoracion>();
	}
	
	public static GestorValoraciones getGV() {
		return miGV;
	}

	public void anadirValoracion(Valoracion valoracion) {
		this.lista.add(valoracion);
	}
	
	public Iterator<Valoracion> getIterador(){
		return this.lista.iterator();
	}
	public List<Valoracion> getListaVal(){
		return lista;
	}
}
