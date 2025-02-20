import java.time.LocalDate; // Importa formato de hora y fecha local
import java.util.ArrayList;

public class Comentarios {

	private Visitantes visitanteComentario;

	private Stands standComentario;

	private LocalDate fechaVisita;

	private int calificacion;

	private String textoComentario;

	private static ArrayList<Comentarios> listaComentarios = new ArrayList<>(); //Array para almacenar comentarios

    //Constructor
	public Comentarios (Visitantes visitanteComentarios, Stands standComentario, LocalDate fechaVisita, int calificacion, String textoComentario) {
		this.visitanteComentario = visitanteComentarios;
		this. standComentario = standComentario;
		this.fechaVisita = fechaVisita;
		this.calificacion = calificacion;
		this.textoComentario = textoComentario;
	}




	public static void dejarComentario() {
        System.out.println("\n--- Dejar un Comentario ---");

        System.out.print("Ingrese su número de identificación: ");
        int idVisitante = Utilidades.scanner.nextInt();
        Utilidades.scanner.nextLine();

        Visitantes visitante = null; //Verificamos existencia del usuario usando getNumeroIdentificación
        for (Visitantes visitantes : Visitantes.getListaVisitantes()) {
            if (visitantes.getNumeroIdentificacion() == idVisitante) {
                visitante = visitantes;
                break;
            }
        }
        if (visitante == null) {
            System.out.println("\nVisitante no encontrado.");
            return;
        }

        Stands.listarStands();
        System.out.print("\nIngrese el id del stand que desea calificar: "); // Solicitamos id para calificar el stand
		int nombreStand = Utilidades.scanner.nextInt();

        Stands stand = null; //Verificamos existencia del stand a calificar
        for (Stands stands : Stands.getListaStands()) {
            if (stands.getIdStand() == nombreStand) {
                stand = stands;
                break;
            }
        }
        if (stand == null) {
            System.out.println("\nStand no encontrado.");
            return;
        }

        System.out.print("\nIngrese una calificación (1 a 5): "); //Almacenamos calificacion
        int calificacion = Utilidades.scanner.nextInt();
        Utilidades.scanner.nextLine();

        if (calificacion < 1 || calificacion > 5) { // Si el valor ingresado no esta entre 1 y 5
            System.out.println("Calificación inválida. Debe estar entre 1 y 5.");
            return;
        }

        System.out.print("\nIngrese su comentario: ");
        String textoComentario = Utilidades.scanner.nextLine();

        Comentarios nuevoComentario = new Comentarios(visitante, stand, LocalDate.now(), calificacion, textoComentario);
        listaComentarios.add(nuevoComentario); //Agregamos el objeto nuevoComentario a la lista de comentarios

        System.out.println("\nComentario agregado exitosamente.");
    }

	public static void verComentariosPorStand() {
		System.out.println("\n--- Ver Comentarios por Stand ---");
	
		System.out.print("Ingrese el ID del stand: ");
		int idStand = Utilidades.scanner.nextInt();
		Utilidades.scanner.nextLine();
	
		boolean encontrado = false;
	
		for (Comentarios comentario : listaComentarios) {
			if (comentario.getStandComentario().getIdStand() == idStand) { //Imprimimos todos los comentarios si el stand existe
				System.out.println("\n--- Comentario ---");
				System.out.println("Visitante: " + comentario.getVisitanteComentario().getNombreVisitante()); //Llamamos getNombreVisitante para ver quien comento
				System.out.println("Fecha: " + comentario.getFechaVisita());
				System.out.println("Calificación: " + comentario.getCalificacion());
				System.out.println("Comentario: " + comentario.getTextoComentario());
				encontrado = true; //Si es encontrado imprimimos
			}
		}
	
		if (!encontrado) {
			System.out.println("No hay comentarios para este stand.");
		}
	}

    public static void promedioCalificacionesPorStand() {
        System.out.println("\n--- Promedio de Calificaciones por Stand ---");
    
        System.out.print("Ingrese el ID del stand: ");
        int idStand = Utilidades.scanner.nextInt();
        Utilidades.scanner.nextLine();
    
        int sumaCalificaciones = 0; //Variable donde almacenamos la suma de todas las calificaciones
        int cantidadComentarios = 0; //Cantidad de comentarios por stand
    
        for (Comentarios comentario : listaComentarios) {
            if (comentario.getStandComentario().getIdStand() == idStand) { //Iteramos en cada stand para sumar la "cantidad" de comentarios
                sumaCalificaciones += comentario.getCalificacion();
                cantidadComentarios++;
            }
        }
    
        if (cantidadComentarios == 0) {
            System.out.println("No hay calificaciones para este stand."); // Si hay comentarios calculamos el promedio e imprimimos, si no, mostramos notificación
        } else {
            double promedio = (double) sumaCalificaciones / cantidadComentarios;
            System.out.printf("El promedio de calificación para el stand %d es: %.2f%n", idStand, promedio);
        }
    }

	//Getters
    public Visitantes getVisitanteComentario() {
        return visitanteComentario;
    }
	public Stands getStandComentario() {
		return standComentario;
	}
	public LocalDate getFechaVisita() {
		return fechaVisita;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public String getTextoComentario() {
        return textoComentario;
    }

	//Setters
    public void setVisitanteComentario(Visitantes visitanteComentario) {
        this.visitanteComentario = visitanteComentario;
    }
    public void setStandComentario(Stands standComentario) {
        this.standComentario = standComentario;
    }
    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
	public void setCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) { //Condicional para asegurar el rango de calificación
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación debe estar entre 1 y 5");
        }
    }
	public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }
}
