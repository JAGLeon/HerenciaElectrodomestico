package entity;

import java.util.Scanner;

public final class Televisor extends Electrodomestico {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private double pulgadas;
    private boolean tdt;

    public Televisor() {
    }

    public Televisor(double pulgadas, boolean tdt, double precio, String color, char letra) {
        super(precio, color, letra);
        this.pulgadas = pulgadas;
        this.tdt = tdt;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
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
        System.out.println("* Ingresó a la creación del televisor *");
        System.out.println("* ----------------------------------- *");
        System.out.println("¿De que color es?");
        String creaColor = sc.next();
        System.out.println("¿Cuál es el precio? Debe ser mayor a 1000");
        double creaPrecio = sc.nextDouble();
        if(creaPrecio < 1000d){
            creaPrecio = 1000d;
        }
        System.out.println("¿Cuál es el consumo energético? [ a , b , c , d , e , f ]");
        String creaLetra = sc.next();
        System.out.println("¿Cuántas pulgadas poseé?");
        double creaPulgada = sc.nextDouble();
        System.out.println("¿Tiené TDT? [ Si , No ]");
        String scTdt = sc.next();
        boolean creaTdt = false;

        if (scTdt.equalsIgnoreCase("si")) {
            creaTdt = true;
        }

        comprobarColor(creaColor);
        char letraComprobada = comprobarConsumoEnergetico(creaLetra.charAt(0));
        double filtroPrecio = precioFinal(creaPrecio, letraComprobada);
        double precioNeto = precioFinalTele(filtroPrecio, creaPulgada, creaTdt);

        System.out.println("El precio final del producto es: " + precioNeto);

        //Televisor tele = new Televisor(creaPulgada, creaTdt, precioNeto, colorComprobado, letraComprobada);
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

    public double precioFinalTele(double precio, double pulgadas, boolean tdt) {

        if (pulgadas >= 40d) {
            precio = precio + precio * 0.30;
        }
        if (tdt) {
            precio += 500d;
        }
        return precio;
    }

}
