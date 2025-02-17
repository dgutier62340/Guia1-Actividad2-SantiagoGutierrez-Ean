import java.util.ArrayList;

public class Stands {

	private int idStand;
	private int ubicación;
	private TamañoStand tamaño;
	private boolean estado;
	private String empresaAsignada;


	public Stands (int idStand, int ubicación,	TamañoStand tamaño, boolean estado, String empresaAsignada) {
		this.idStand = idStand;
		this.ubicación = ubicación;
		this.tamaño = tamaño;
		this.estado = estado;
		this.empresaAsignada = empresaAsignada;
		
	}

	public static void mostrarMenuEmpresa() {
        System.out.println("\n--- Menú Registro Empresas ---");
        System.out.println("1. Registrar Empresa");
        System.out.println("2. Editar Empresa");
        System.out.println("3. Eliminar Empresa");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");

    }

	public void MostrarStands() {

	}

	public void AsignarEmpresa() {

	}

}
