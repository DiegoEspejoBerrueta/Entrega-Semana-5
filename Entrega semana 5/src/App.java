import java.io.Console;

import modelo.Animal;
import modelo.Cuidador;
import modelo.Refugio;

public class App {
    public static void main(String[] args) throws Exception {
        Console consola = System.console();
        if (consola == null) {
            System.out.println("No hay consola disponible en este entorno.");
            return;
        }
        
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| GESTIÓN DEL REFUGIO                                         |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1) Crear un nuevo registro de animales                      |");
        System.out.println("| 2) Configurar el precio del alimento por kg                 |");
        System.out.println("| 3) Añadir un nuevo animal al refugio                        |");
        System.out.println("| 4) Mostrar información de lso animales                      |");
        System.out.println("| 5) Salir (se borrará toda la información)                   |");
        System.out.println("|-------------------------------------------------------------|");
        
        String a = consola.readLine("Seleccione una opción (1-5): ");
        int opcion = Integer.parseInt(a);

        if (opcion == 1){
            System.out.println("1");
        }
        else if (opcion == 2){
            System.out.println("2");
        }
        else if (opcion == 3){
            System.out.println("3");
        }
        else if (opcion == 4){
            System.out.println("4");
        }
        else if (opcion == 5){
            System.out.println("5");
        }
        else {
            System.out.println("Opción no válida");
        }

    }
}
