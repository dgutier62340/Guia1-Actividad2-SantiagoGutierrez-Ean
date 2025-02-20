import java.util.ArrayList;

public class Visitantes {

	private String nombreVisitante;
	private int numeroIdentificacion;
	private String correoVisitante;
	
	private static ArrayList<Visitantes> listaVisitantes = new ArrayList<>(); //Creamos un Array de clase Visitantes

	public Visitantes (String nombreVisitante, int numeroIdentificacion, String correoVisitante) {
		this.nombreVisitante = nombreVisitante;
		this.numeroIdentificacion = numeroIdentificacion;
		this.correoVisitante = correoVisitante;

	}

	public static void mostrarMenuVisitantes() {  //Creamos un menu para los visitantes

		int OpVisitante = 1; //Switch para habilitar el bucle

		while ( OpVisitante !=0 ) {
			String textoMenuVisitante = """
				\n------ Menú Visitantes ------
				1. Registrar Visitante
				2. Editar Visitante
				3. Eliminar Visitante
				4. Dejar Comentario
				0. Salir
				\nSeleccione una opción: """;
	
			System.out.print(textoMenuVisitante);

			OpVisitante = Utilidades.scanner.nextInt();
			Utilidades.scanner.nextLine();

			switch (OpVisitante) {
				case 1:
					registrarVisitante();
					break;
				
				case 2:
					editarVisitante();
					break;

				case 3:
					eliminarVisitante();
					break;

				case 4:
					Comentarios.dejarComentario();
					break;

				case 0:
					break;

				default:
					System.out.println("\n---- Opción invalida. Intente nuevamente ----");
					break;
			}
		}

    }

	public static void registrarVisitante () { //Solicitamos los datos al visitante y almacenamos la información en el array listaVisitantes

		System.out.print("\n---------------------------------\n");
		System.out.print("Ingrese el nombre del visitante: ");
		String nombreVisitante = Utilidades.scanner.nextLine();

		System.out.print("Ingrese numero de identificacion: ");
		int numeroIdentificacion = Utilidades.scanner.nextInt();
		Utilidades.scanner.nextLine();

		System.out.print("Ingrese correo del visitante: ");
		String correoVisitante = Utilidades.scanner.nextLine();

		Visitantes nuevoVisitante = new Visitantes(nombreVisitante, numeroIdentificacion, correoVisitante); //Creamos objeto con los datos ingresados, claseVisitantes

		listaVisitantes.add(nuevoVisitante); // Agregamos el objeto creado al array

		System.out.println("\n"+ nombreVisitante + " ha sido registrado correctamente");
	}

	public static void editarVisitante() {
		System.out.println("\nIngrese el numero de identificacion del visitante a editar: "); //Solicitamos un id unico, en este caso el nombre de la empresa
		int idBuscado = Utilidades.scanner.nextInt();
		Utilidades.scanner.nextLine();

		for (Visitantes visitantes : listaVisitantes) { //por medio de for buscamos el id del objeto en la lista
			if (visitantes.numeroIdentificacion == idBuscado) { // int == int
				System.out.println("\n---------------- Visitante encontrado ----------------"); // Si es encontrado, volvemos a solicitar los datos
				System.out.println("Nombre actual: " + visitantes.nombreVisitante);
				System.out.println("Correo actual: " + visitantes.correoVisitante);

				System.out.print("\nIngrese el nuevo nombre del visitante: ");
				visitantes.nombreVisitante = Utilidades.scanner.nextLine();

				System.out.print("Ingrese el nuevo correo del visitante: ");
				visitantes.correoVisitante = Utilidades.scanner.nextLine();

				System.out.print("Ingrese el nuevo numero de identificacion del estudiante: ");
				visitantes.numeroIdentificacion = Utilidades.scanner.nextInt();
				Utilidades.scanner.nextLine();

				System.out.println("\nVisitante actualizado correctamente.");
				return;
			}
		}
		System.out.println("\nNo se encontró un visitante con ese número de identificación");
			
	}

	public static void eliminarVisitante() { //Por medio de un id buscamos el objeto de interes
		System.out.println("\nIngrese el numero de identificacion del visitante a eliminar: ");
		int idBuscado = Utilidades.scanner.nextInt();
		Utilidades.scanner.nextLine();

		for (Visitantes visitantes : listaVisitantes) {
			if (visitantes.numeroIdentificacion == idBuscado) {
				listaVisitantes.remove(visitantes); //Eliminamos el objeto del array listaVisitantes
				System.out.println("\nVisitante eliminado correctamente.");
				return;
			}
		}
	}

	//Getters
	
	public String getNombreVisitante() {
		return nombreVisitante;
	}
	
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
	public String getCorreoVisitante() {
		return correoVisitante;
	}

	public static ArrayList<Visitantes> getListaVisitantes() {
		return listaVisitantes;
	}

}

