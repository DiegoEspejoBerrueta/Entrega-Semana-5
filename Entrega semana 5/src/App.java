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
            System.out.println("| 4) Mostrar información de los animales                      |");
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
            System.out.println("Registro creado correctamente con capacidad para: " + capacidad + " animales.");
        }

        //Opción 2: Configurar precio del alimento
        private static void opcion2ConfigurarPrecio(Refugio refugio, Console consola){
            double precio = 0.0;
            do{
                String entrada = consola.readLine("Introduce el precio del alimento por kg (EUR/kg, mayor que 0): ");
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
            System.out.printf("El precio se ha fijado a %.2f EUR/kg.\n", precio);
        }

        //Opción 3: Añadir un animal
        private static void opcion3AnadirAnimal(Refugio refugio, Console consola){
            if (!refugio.isRegistroCreado()) {
                System.out.println("Error: Primero debe crear un registro de animales (Opción 1).");
                return;
            }
            if (refugio.getn_animales_reg() >= refugio.getAnimales().length ) {
                System.out.println("Error: El refugio está lleno.");
                return;
            }

            System.out.println("Introduzca los datos del animal");
            String nombre_animal = consola.readLine("Introduce el nombre del animal: ");
            String especie = consola.readLine("Introduce la especie del animal: ");
            
            double peso = 0.0;
            do{
                String entrada = consola.readLine("Introduce el peso del animal: ");
                try {
                    entrada = entrada.replace(",", ".");
                    peso = Double.parseDouble(entrada);
                    if (peso <= 0) {
                        System.out.println("El peso no puede ser menor o igual que 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El peso debe ser un número válido.");
                }
            } while (peso <= 0);

            double consumo = 0.0;
            do{
                String entrada = consola.readLine("Introduce el consumo del animal (kg): ");
                try {
                    entrada = entrada.replace(",", ".");
                    consumo = Double.parseDouble(entrada);
                    if (consumo <= 0) {
                        System.out.println("El consumo no puede ser menor o igual que 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El consumo debe ser un número válido.");
                }
            } while (consumo <= 0);

            
            System.out.println("Introduzca los datos del cuidador");
            String nombre_cuidador = consola.readLine("Introduce el nombre del cuidador: ");
            String apellidos = consola.readLine("Introduce los apellidos del cuidador: ");

            boolean formacion = false;
            boolean respuestavalida = false;
            do{
                String resp = consola.readLine("¿Tiene formación? (Si/No): ");
                if (resp.equals("Si") || resp.equals("Sí") || resp.equals("si") || resp.equals("sí") || resp.equals("s") || resp.equals("1")) {
                    formacion = true;
                    respuestavalida = true;
                } else if (resp.equals("No") || resp.equals("no") || resp.equals("no") || resp.equals("0")) {
                    formacion = false;
                    respuestavalida = true;
                } else {
                    System.out.println("Por favor, responda 'Si' o 'No'.");
                }
            } while (respuestavalida == false);

            Cuidador cuidador = new Cuidador(nombre_cuidador, apellidos, formacion);
            Animal nuevoAnimal = new Animal(cuidador, nombre_animal, especie, peso, consumo);

            if (refugio.anadirAnimal(nuevoAnimal)) {
                System.out.println("\n¡Animal registrado correctamente!");
            } else {
                System.out.println("\nError al guardar el animal.");
            }

        }






        //Opción 4: Mostrar información
        private static void opcion4MostrarInformacion(Refugio refugio){
            if (!refugio.isRegistroCreado()) {
                System.out.println("Error: Primero debe crear un registro de animales (Opción 1).");
                return;
            }

            if (refugio.getn_animales_reg() == 0) {
                System.out.println("El registro está vacío.");
                return;
            }

            System.out.println("\n|------------------------------------------------------------------------------------------------------------|");
            System.out.println("| ANIMALES DEL REFUGIO                                                                                       |");
            System.out.println("|------------------------------------------------------------------------------------------------------------|");
            System.out.printf("| %-10s | %-10s | %-22s | %-10s | %-12s | %-12s | %-12s |\n",
                "Nombre", "Especie", "Cuidador", "Formación", "Peso (kg)", "Consumo kg", "Coste EUR");
            System.out.println("|------------------------------------------------------------------------------------------------------------|");
            
            Animal[] lista = refugio.getAnimales();
            for(int i=0; i < lista.length; i++){
                if(lista[i] != null){
                    Animal a = lista[i];
                    String formacion = a.getcuidador().getformacion() ? "Si":"No";
                    double coste = a.calcularCosteDiario(refugio.getprecio_alimento_kg());

                    System.out.printf("| %-10s | %-10s | %-22s | %-10s | %12.2f | %12.2f | %12.2f |\n",
                        a.getnombre(),
                        a.getEspecie(),
                        a.getcuidador().getNombreCompleto(),
                        formacion,
                        a.getpeso_kg(),
                        a.getconsumo_kg(),
                        coste);
                }
            }

            System.out.println("|------------------------------------------------------------------------------------------------------------|");
            System.out.printf("| %-106s |\n", 
                String.format("Coste diario total de alimentación: %.2f EUR", refugio.calcularCosteTotalDiario()));
            System.out.printf("| %-106s |\n", 
                String.format("Peso medio de los animales: %.2f kg", refugio.calcularPesoMedio()));
            System.out.println("|------------------------------------------------------------------------------------------------------------|");

        }



}
