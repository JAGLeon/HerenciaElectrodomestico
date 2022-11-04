package entity;

public abstract class Electrodomestico {

    protected double precio;
    protected String color;
    protected char letra;

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, char letra) {
        this.precio = precio;
        this.color = color;
        this.letra = letra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
    public abstract char comprobarConsumoEnergetico(char letra);

    public abstract String comprobarColor(String color);

    public abstract void crearElectrodomestico();

    public abstract double precioFinal(double precio, char letra);
}
