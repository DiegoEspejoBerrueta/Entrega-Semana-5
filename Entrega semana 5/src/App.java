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

        Refugio refugio = new Refugio();
        int opcion = 0;

        do {
            mostrarMenu();
    
            String entrada = consola.readLine("Seleccione una opción (1-5): ");
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número entero del 1 al 5.");
                opcion = 0; 
                continue;
            }

            switch (opcion) {
                case 1:
                    opcion1CrearRegistro(refugio, consola);
                    break;
                case 2:
                    opcion2ConfigurarPrecio(refugio, consola);
                    break;
                case 3:
                    opcion3AnadirAnimal(refugio, consola);
                    break;
                case 4:
                    opcion4MostrarInformacion(refugio);
                    break;
                case 5:
                    System.out.println("\nSaliendo del programa... Se borrará toda la información.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduzca un número del 1 al 5.");
            }
            System.out.println();
        } while (opcion != 5);
    }

        private static void mostrarMenu(){
            System.out.println("|-------------------------------------------------------------|");
            System.out.println("| GESTIÓN DEL REFUGIO                                         |");
            System.out.println("|-------------------------------------------------------------|");
            System.out.println("| 1) Crear un nuevo registro de animales                      |");
            System.out.println("| 2) Configurar el precio del alimento por kg                 |");
            System.out.println("| 3) Añadir un nuevo animal al refugio                        |");
            System.out.println("| 4) Mostrar información de lso animales                      |");
            System.out.println("| 5) Salir (se borrará toda la información)                   |");
            System.out.println("|-------------------------------------------------------------|");
        }
        
        
        //Opción 1: crear un nuevo registro
        private static void opcion1CrearRegistro(Refugio refugio, Console consola){
            int capacidad = 0;
            do{
                String entrada = consola.readLine("Introduce la capacidad del refugio (mayor que 0): ");
                try {
                    capacidad = Integer.parseInt(entrada);
                    if (capacidad <= 0) {
                        System.out.println("La capacidad debe ser mayor que 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número entero válido.");
                }
            } while (capacidad <= 0);

            refugio.crearRegistro(capacidad);
            System.out.println("Registro creado correctamente con capacidad para: " + capacidad + "animales.");
        }

        //Opción 2: Configurar precio del alimento
        private static void opcion2ConfigurarPrecio(Refugio refugio, Console consola){
            double precio = 0.0;
            do{
                String entrada = consola.readLine("Introduce el precio del alimento por kg (€/kg, mayor que 0): ");
                try {
                    entrada = entrada.replace(",", ".");
                    precio = Double.parseDouble(entrada);
                    if (precio <= 0) {
                        System.out.println("El precio debe ser mayor que cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            } while (precio <= 0);

            refugio.setprecio_alimento_kg(precio);
            System.out.printf("El precio se ha fijado a %.2f €/kg.\n", precio);
        }





}
