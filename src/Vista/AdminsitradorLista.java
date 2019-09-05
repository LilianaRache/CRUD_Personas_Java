package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Controlador.CRUD;
import Modelo.Persona;

public class AdminsitradorLista {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		CRUD crud = new CRUD();
		
		System.out.println("Bienvenido a la adminsitracion de personas. Selecciones la opcion que desea realizar"
				+ "\n 1 Mostrar personas "
				+ "\n 2 Crear persona "
				+ "\n 3 Editar persona "
				+ "\n 4 Borrar persona"
				+ "\n 0 Salir");
		
		int opcion = Integer.parseInt(entrada.nextLine());
		
		switch (opcion) {
		case 0:
			break;
		case 1:
			
			ArrayList<Persona> listaPerso = crud.mostrarPersonas();
			
			for (Persona objeto : listaPerso) {
				
				System.out.println("id: " + objeto.getId() + " nombre: " + objeto.getNombre() + " edad: " + objeto.getEdad());
			}
			
			main(null);
			break;
		case 2:
			
			System.out.println("Por favor ingrese el ID de la persona:");
			int idPersona = Integer.parseInt(entrada.nextLine());
			
			System.out.println("Por favor ingrese el NOMBRE de la persona:");
			String nombre = entrada.nextLine();
			
			System.out.println("Por favor ingrese la EDAD de la persona:");
			int edad = Integer.parseInt(entrada.nextLine());
			
			Persona personaNueva = new Persona(idPersona, nombre, edad);
			
			crud.addPerson(personaNueva);
			
			main(null);
			
			break;
		case 3:
			
			System.out.println("Digite el ID de la persona que va a editar");
			int id = Integer.parseInt(entrada.nextLine());
			
			Persona personaSeleccionada = crud.buscarPersona(id);
			
			System.out.println("La informaciòn de la persona es: \n"
					+ "Id: " + personaSeleccionada.getId() + " Nombre: " + personaSeleccionada.getNombre() + " Edad: " + personaSeleccionada.getEdad());
			
			System.out.println("Digite el nuevo nombre: ");
			String nuevoNombre = entrada.nextLine();
			
			System.out.println("Digite la nueva edad: ");
			int nuevaEdad = Integer.parseInt(entrada.nextLine());
			
			personaSeleccionada.setNombre(nuevoNombre);
			personaSeleccionada.setEdad(nuevaEdad);
			
			crud.actualizarPersona(personaSeleccionada);
			
			main(null);
			
			break;
		case 4:
			
			System.out.println("Digite el ID de la persona que va a eliminar");
			int idEliminar = Integer.parseInt(entrada.nextLine());
			
			Persona personaEliminar = crud.buscarPersona(idEliminar);
			
			crud.eliminarPersona(personaEliminar);
			
			System.out.println("El registro se ha eliminado correctamente");
			
			main(null);
	
			break;

		default:
			
			System.out.println("Digite una opcion correcta");
			
			break;
		}
	}

	
}
