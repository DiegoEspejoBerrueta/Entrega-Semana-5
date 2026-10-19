package modelo;

public class Animal {
    private Cuidador cuidador;
    private String nombre;
    private String especie;
    private double peso_kg;
    private double consumo_kg;
    
    public Animal(Cuidador cuidador, String nombre, String especie, double peso_kg, double consumo_kg){
        if (peso_kg <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }

        if (consumo_kg <= 0) {
            throw new IllegalArgumentException("El consumo debe ser mayor que cero.");
        }
        
        this.cuidador = cuidador;
        this.nombre = nombre;
        this.especie = especie;
        this.peso_kg = peso_kg;
        this.consumo_kg = consumo_kg;
    }

    public Cuidador getcuidador() {
        return cuidador;
    }
    public void setcuidador(Cuidador cuidador){
        this.cuidador = cuidador;
    }

    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }
    public void setespecie(String especie){
        this.especie = especie;
    }

    public double getpeso_kg() {
        return peso_kg;
    }
    public void setpeso_kg(Double peso_kg){
        this.peso_kg = peso_kg;
    }

    public double getconsumo_kg() {
        return consumo_kg;
    }
    public void setconsumo_kg(Double consumo_kg){
        this.consumo_kg = consumo_kg;
    }

    public double calcularCosteDiario(double precio_alimento_kg) {
        return consumo_kg * precio_alimento_kg;
    }

}
