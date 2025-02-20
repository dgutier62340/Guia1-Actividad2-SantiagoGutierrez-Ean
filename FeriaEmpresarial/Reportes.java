public class Reportes {

	public static void mostrarMenuReportes() {

        int OpReportes = 1; //Switch para habilitar el bucle

		while ( OpReportes !=0 ) {
			String textoMenuReportes = """
				\n------ Menú Reportes ------
				1. Reporte empresas registradas
				2. Reporte Visitantes registrados
				3. Calificación promedio de stand
				0. Salir
				\nSeleccione una opción: """; //Menu reportes
	
			System.out.print(textoMenuReportes);

			OpReportes = Utilidades.scanner.nextInt();
			Utilidades.scanner.nextLine();

			switch (OpReportes) {
				case 1:
					Empresas.listarEmpresas();
					Stands.listarStands();
					break;
				
				case 2:
					Comentarios.verComentariosPorStand();
					break;

				case 3:
					Comentarios.promedioCalificacionesPorStand();
					break;

				case 0:
					break;

				default:
					System.out.println("\n---- Opción invalida. Intente nuevamente ----");
					break;
			}
		}
    }

}
