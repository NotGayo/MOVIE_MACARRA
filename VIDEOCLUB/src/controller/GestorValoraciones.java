package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import BBDD.DatabaseInsertion;
import model.Pelicula;
import model.Usuario;
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
	
	public boolean anadirVal(String correo, int codPelicula, Double puntuacion, String resena) {
        for(Valoracion v : lista) {
            if(v.getPelicula().getCodPeli() == codPelicula) {
                return false;
                }
        }
        if(puntuacion >= 0 && puntuacion <= 10) {
            Usuario usuario = GestorUsuarios.getGUsuarios().buscarUsuario(correo);
            Pelicula pelicula;
            lista.add(new Valoracion(usuario, pelicula, puntuacion, resena));
            DatabaseInsertion.insertarValoracion(correo, codPelicula, puntuacion, resena);
            return true;
                }
        else {
            return false;
        }
	}
}
