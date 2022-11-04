package entity;

import java.util.Scanner;

public final class Lavadora extends Electrodomestico {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private double carga, peso;

    public Lavadora() {
    }

    public Lavadora(double carga, double peso) {
        this.carga = carga;
        this.peso = peso;
    }

    public Lavadora(double carga, double peso, double precio, String color, char letra) {
        super(precio, color, letra);
        this.carga = carga;
        this.peso = peso;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public char comprobarConsumoEnergetico(char letra) {
        if (!Character.toString(letra).matches("[a-f?]")) {
            letra = 'f';
        }
        return letra;
    }

    @Override
    public String comprobarColor(String color) {
        if (!color.equalsIgnoreCase("blanco") && !color.equalsIgnoreCase("negro") && !color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("azul") && !color.equalsIgnoreCase("gris")) {
            color = "blanco";
        }
        return color;
    }

    @Override
    public void crearElectrodomestico() {
        System.out.println("* ----------------------------------- *");
        System.out.println("* Ingresó a la creación de la Lavadora *");
        System.out.println("* ----------------------------------- *");
        System.out.println("¿De que color es?");
        String creaColor = sc.next();
        System.out.println("¿Cuál es el precio? Debe ser mayor a 1000");
        double creaPrecio = sc.nextDouble();
        if (creaPrecio < 1000d) {
            creaPrecio = 1000d;
        }
        System.out.println("¿Cuál es el consumo energético? [ a , b , c , d , e , f ]");
        String creaLetra = sc.next();

        char letraComprobada = comprobarConsumoEnergetico(creaLetra.charAt(0));
        String colorComprobado = comprobarColor(creaColor);
        double filtroPrecio = precioFinal(creaPrecio, letraComprobada);

        crearLavadora(colorComprobado, filtroPrecio, letraComprobada);
    }

    @Override
    public double precioFinal(double precio, char letra) {
        switch (letra) {
            case 'a':
                precio += 1000d;
                break;
            case 'b':
                precio += 800d;
                break;
            case 'c':
                precio += 600d;
                break;
            case 'd':
                precio += 500d;
                break;
            case 'e':
                precio += 300d;
                break;
            case 'f':
                precio += 100d;
                break;
            default:
                System.out.println("Ese consumo de energia no esta!");
        }

        return precio;
    }

    private void crearLavadora(String color, double precio, char letra) {
        System.out.println("¿Qué peso tiene?");
        double creaPeso = sc.nextDouble();
        System.out.println("¿Cuánta carga aguanta?");
        double creaCarga = sc.nextDouble();

        double precioNeto = precioFinalLavadora(precio, creaPeso, creaCarga);
        Lavadora lavadora = new Lavadora(creaCarga, creaPeso, precioNeto, color, letra);
        System.out.println("El precio final de lavora: " + lavadora.getPrecio());
    }

    public double precioFinalLavadora(double precio, double peso, double carga) {

        if (peso >= 1 && peso < 20) {
            precio += 100;
        } else if (peso > 19 && peso < 50) {
            precio += 500;
        } else if (peso > 49 && peso < 80) {
            precio += 800;
        } else if (peso > 80) {
            precio += 1000;
        } else {
            System.out.println("El peso no puede ser negativo");
        }

        if (carga >= 30) {
            precio += 500;
        }

        return precio;
    }

}
