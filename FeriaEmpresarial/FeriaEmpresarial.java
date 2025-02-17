public class FeriaEmpresarial {
    
    private static void mostrarMenu() { //Menu principal
        String textoMenuEmpresa = """
            \n------ Menú de Gestión Feria Empresarial ------
            1. Empresas
            2. Visitantes
            3. Reportes
            0. Salir
            \nSeleccione una opción: """;

        System.out.print(textoMenuEmpresa);
    }

    private static int obtenerOpcion() { //Accedemos a utilidades.scanner para obtener los datos ingresados
        return Utilidades.scanner.nextInt(); 

    }

    public static void main(String[] args) {
        int OpMenu = 1;

        while (OpMenu != 0) {
            mostrarMenu();

            OpMenu = obtenerOpcion();

            switch (OpMenu) { //Switch principal para acceder a distintos metodos publicos
                case 1:
                    Empresas.mostrarMenuEmpresa();
                    break;

                case 2:
                    Visitantes.mostrarMenuVisitantes();
                    break;

                case 3:
                    Reportes.mostrarMenuReportes();
                    break;
            
                default:
                    System.out.println("---- Opción invalida. Intente nuevamente ----");
                    break;
            }
        }
    }

}