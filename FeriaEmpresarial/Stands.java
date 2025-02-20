import java.util.ArrayList;
import java.util.List;

public class Stands {

	private int idStand;
	private int ubicacion;
	private TamañoStand tamaño;
	private boolean estado; // Para saber si esta disponible u ocupado
	private Empresas empresaAsignada;

	private static List<Stands> listaStands = new ArrayList<>(); //Creamos una lista para almacenar el estado de los Stands
	private static final int MaxStands = 10; // Maximo 10 stands

	public Stands (int idStand, int ubicacion,	TamañoStand tamaño) {
		this.idStand = idStand;
		this.ubicacion = ubicacion;
		this.tamaño = tamaño;
		this.estado = false;
		this.empresaAsignada = null;
	}


	public static void inicializarStands() {
        if (listaStands.isEmpty()) { // Verificamos si ya se han creado los stands, si no, los creamos
            for (int i = 1; i <= MaxStands; i++) {
				new Stands(i, i, TamañoStand.Mediano);
				listaStands.add(new Stands(i, i, TamañoStand.Mediano)); // agregamos los stands a la lista
            }
        }
    }

	public static void asignarStandEmpresa(Empresas empresa) { //La empresa es asignada automaticamente al hacer el registro
		System.out.println("\nAsignando stand a la empresa " + empresa.getNombreEmpresa() + "...");

		TamañoStand tamañoSeleccionado = elegirTamaño(); //Solicitamos el tamaño del stand a la empresa y guardamos el input

		for (Stands stands : listaStands) {
			if (!stands.getEstado()) { // Si hay stands diponibles lo puede asignar
				stands.setEstado(true); // Guardamos la informacion por medio de setters
				stands.setEmpresaAsignada(empresa);
				stands.setTamaño(tamañoSeleccionado);
				stands.setEmpresaAsignada(empresa);  // Asigna la empresa al stand
				System.out.println("La empresa " + empresa.getNombreEmpresa() + " ha sido asignada al stand ID " + stands.getIdStand());
				return;
			}
		}
	
		System.out.println("No hay stands disponibles para asignar.");
	}

	public static TamañoStand elegirTamaño() { //Solicitamos el enum a escoger por la empresa

		System.out.println("Seleccione el tamaño del stand:");
		System.out.println("1. Pequeño");
		System.out.println("2. Mediano");
		System.out.println("3. Grande");
		int opcion = Utilidades.scanner.nextInt();
		Utilidades.scanner.nextLine(); // Limpiar el buffer

		TamañoStand tamañoSeleccionado = TamañoStand.Mediano;  // Tamaño por defecto

		switch (opcion) { //Por medio de un switch guardamos la información
			case 1:
				tamañoSeleccionado = TamañoStand.Pequeño;
				break;
			case 2:
				tamañoSeleccionado = TamañoStand.Mediano;
				break;
			case 3:
				tamañoSeleccionado = TamañoStand.Grande;
				break;
			default:
				System.out.println("Opción inválida. Se asignará el tamaño Mediano por defecto.");
				break;
		}

    	return tamañoSeleccionado; 
	}
	
	public static void listarStands() {
	
		System.out.println("\n------ Lista de Stands ------\n");
		for (Stands stands : listaStands) { // Iteramos en la lista (listaStands)
			String estado = stands.getEstado() ? "Ocupado" : "Disponible";
			String empresa = (stands.getEmpresaAsignada() != null) ? stands.getEmpresaAsignada().getNombreEmpresa() : "Sin asignar"; //Obtenemos datos de los stands
			// Imprimimos información
			System.out.println("ID: " + stands.getIdStand() + 
                           " | Ubicación: " + stands.getUbicacion() + 
                           " | Tamaño: " + stands.getTamaño() + 
                           " | Estado: " + estado + 
                           " | Empresa: " + empresa);
    	}
	}

	//Getters
    public int getIdStand() {
        return idStand;
    }
    public int getUbicacion() {
        return ubicacion;
    }
    public TamañoStand getTamaño() {
        return tamaño;
    }
    public boolean getEstado() {
        return estado;
    }
    public Empresas getEmpresaAsignada() {
        return empresaAsignada;
    }
	public static List<Stands> getListaStands() {
		return listaStands;
	}

	//Setters
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setEmpresaAsignada(Empresas empresa) {
		this.empresaAsignada = empresa;
	}
	public void setTamaño(TamañoStand tamaño) {
		this.tamaño = tamaño;
	}
}