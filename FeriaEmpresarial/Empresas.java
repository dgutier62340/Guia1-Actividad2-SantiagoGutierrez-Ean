import java.util.ArrayList;

public class Empresas {

	private String nombreEmpresa;

	private String sectorEmpresa;

	private String correoEmpresa;

	public static ArrayList<Empresas> listaEmpresas = new ArrayList<>(); // Creamos un array para almacenar los objetos de clase empresas

	public Empresas (String nombreEmpresa, String sectorEmpresa, String correoEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
		this.sectorEmpresa = sectorEmpresa;
		this.correoEmpresa = correoEmpresa;

	}

	public static void mostrarMenuEmpresa() {
        
		int OpEmpresa = 1; //Switch para menu empresas

		while ( OpEmpresa !=0 ) {
			String textoMenuEmpresa = """
				\n------ Menú Empresas ------
				1. Registrar Empresa
				2. Editar Empresa
				3. Eliminar Empresa
				0. Volver
				\nSeleccione una opción: """;
	
			System.out.print(textoMenuEmpresa); // Imprimimos el menu

			OpEmpresa = Utilidades.scanner.nextInt();
			Utilidades.scanner.nextLine(); // Reiniciamos buffer para evitar errores, suele ocurrir con Int

			switch (OpEmpresa) { //Menu que llama los metodos
				case 1:
					registrarEmpresa();
					break;
				
				case 2:
					editarEmpresa();
					break;

				case 3:
					eliminarEmpresa();
					break;

				case 4:
					listarEmpresas();
					break;

				default:
					System.out.println("---- Opción invalida. Intente nuevamente ----");
					break;
			}
		}

    }

	public static void registrarEmpresa () { //Solicitamos datos y creamos un nuevo objeto de la clase Empresa y lo almacenamos en el array

		Stands.inicializarStands();
		Stands.listarStands();

		System.out.print("\n---------------------------------\n");
		System.out.print("Ingrese nombre de la empresa: ");
		String nombreEmpresa = Utilidades.scanner.nextLine();

		System.out.print("Sector al que pertenece (Tecnologia, Salud, Educación, Otro): ");
		String SectorEmpresa = Utilidades.scanner.nextLine();

		System.out.print("Ingrese correo de la empresa: ");
		String correoEmpresa = Utilidades.scanner.nextLine();

		Empresas nuevaEmpresa = new Empresas(nombreEmpresa, SectorEmpresa, correoEmpresa);

		listaEmpresas.add(nuevaEmpresa);

		System.out.println("\nLa empresa "+ nombreEmpresa + " ha sido registrada correctamente");

		Stands.asignarStandEmpresa(nuevaEmpresa);  // Llamamos a asignar un stand inmediatamente después de registrar la empresa

		Stands.listarStands();

	}

	public static void editarEmpresa() { //Solicitamos nombre ya ingresado, accedemos al array y modificamos el objeto actual
		System.out.println("\nIngrese el nombre de la empresa a editar: ");
		String nombreBuscado = Utilidades.scanner.nextLine();

		for (Empresas empresas : listaEmpresas) {
			if (empresas.nombreEmpresa.equals(nombreBuscado)) {  //Usamos equals cuando comparamos dos strings
				System.out.println("\n---------------- Empresa encontrada ----------------");
				System.out.println("Nombre actual: " + empresas.nombreEmpresa);
				System.out.println("Sector actual: " + empresas.sectorEmpresa);

				System.out.print("\nIngrese el nuevo nombre de la empresa: ");
				empresas.nombreEmpresa = Utilidades.scanner.nextLine();

				System.out.print("Ingrese el nuevo sector de la empresa: ");
				empresas.sectorEmpresa = Utilidades.scanner.nextLine();

				System.out.print("Ingrese el nuevo correo de la empresa: ");
				empresas.correoEmpresa = Utilidades.scanner.nextLine();

				System.out.println("\nEmpresa actualizada correctamente.");
				return;
			}
		}
		System.out.println("\nNo se encontró una empresa con este nombre");
			
	}

	public static void eliminarEmpresa() { //Solicitamos nombre ya ingresado, accedemos al array y eliminamos el objeto actual
		System.out.println("\nIngrese nombre de la empresa a eliminar: ");
		String nombreBuscado = Utilidades.scanner.nextLine();

		for (Empresas empresa : listaEmpresas) {
			if (empresa.nombreEmpresa.equals(nombreBuscado)) {
				listaEmpresas.remove(empresa);
				System.out.println("\nEmpresa eliminada correctamente.");
				return;
			}
		}
	}

	public static void listarEmpresas() {
		if (listaEmpresas.isEmpty()) {
			System.out.println("\nNo hay empresas registradas.\n");
		} else {
			System.out.println("\nListado de Empresas:\n");
			for (Empresas empresa : listaEmpresas) {
				System.out.println("Nombre: " + empresa.getNombreEmpresa() + " | Sector: " + empresa.getSectorEmpresa() + " | Correo: " + empresa.getCorreoEmpresa());
			}
		}
	}

	// Getters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getSectorEmpresa() {
        return sectorEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public static ArrayList<Empresas> getListaEmpresas() {
        return listaEmpresas;
    }
}
