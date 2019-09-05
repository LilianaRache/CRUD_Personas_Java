package Controlador;

import java.util.ArrayList;

import Modelo.Persona;

public class CRUD {
	
	static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	public static ArrayList<Persona> mostrarPersonas() {
		
		return listaPersonas;
	}
	
	public static void addPerson(Persona persona) {
		
		listaPersonas.add(persona);
	}
	
	public static Persona buscarPersona(int id) {
		
		Persona encontrada = new Persona();
		
		for (Persona persona : listaPersonas) {
			
			if (id == persona.getId()) {
				
				encontrada = persona;
				
			}
		}
		
		return encontrada;
	}
	
	public static void actualizarPersona(Persona personaActualizada) {
		
		Persona personaActualizar = buscarPersona(personaActualizada.getId());
		
		listaPersonas.remove(personaActualizar);
		
		listaPersonas.add(personaActualizada);
		
	}
	
	public static void eliminarPersona(Persona personaEliminar) {
		
		listaPersonas.remove(personaEliminar);
		
	}
}
