package modelo;

public class Refugio {
    private Animal[] animales;
    private double precio_alimento_kg;
    private int n_animales_reg;

    public Refugio(){
        animales = null;
        n_animales_reg = 0;
        precio_alimento_kg = 5.0;
    }

    // Opcion 1: Crear un nuevo registro con una capacidad mayor que cero
    public void crearRegistro(int capacidad){
        this.animales = new Animal[capacidad];
        this.n_animales_reg = 0;
    }

    // Comprueba si el registro de animales ya ha sido creado
    public boolean isRegistroCreado() {
        return this.animales != null;
    }

    // Opción 2: Configurar el precio del alimento (debe ser > 0)
    public boolean setprecio_alimento_kg(Double precio) {
        if (precio > 0) {
            this.precio_alimento_kg = precio;
            return true;
        }
        return false;
    }
    public double getprecio_alimento_kg() {
        return precio_alimento_kg;
    }

    // Opción 3: Añadir un animal 
    public boolean anadirAnimal(Animal animal) {
        if (animales == null || n_animales_reg >= animales.length) {
            return false;
        }

        for (int i = 0; i < animales.length; i++) {
            if (animales[i] == null) {
                animales[i] = animal;
                n_animales_reg++;
                return true; 
            }
        }
        return false;
    }

    // Opción 4: mostrar información
    public double calcularCosteTotalDiario(){
        double total = 0;
        if (animales != null){
            for (int i = 0; i < animales.length; i++){
                if (animales[i] != null) {
                    total += animales[i].calcularCosteDiario(precio_alimento_kg);
                }
            }
        }

        return total;
    }
    public double calcularPesoMedio(){
        if (n_animales_reg == 0){
            return 0.0;
        }

        double sumaPesos = 0.0;
        for(int i = 0; i < animales.length; i++){
            if(animales[i] != null){
                sumaPesos += animales[i].getpeso_kg();
            }
        }

        return sumaPesos / n_animales_reg;
    }

    public Animal[] getAnimales(){
        return animales;
    }

    public int getn_animales_reg(){
        return n_animales_reg;
    }

}
