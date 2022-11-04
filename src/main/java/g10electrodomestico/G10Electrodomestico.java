package g10electrodomestico;

import entity.Lavadora;
import entity.Televisor;

public class G10Electrodomestico {

    public static void main(String[] args) {
       Televisor tele2 = new Televisor();
        tele2.crearElectrodomestico();
       Lavadora lava =  new Lavadora();
       lava.crearElectrodomestico();
    }
}
