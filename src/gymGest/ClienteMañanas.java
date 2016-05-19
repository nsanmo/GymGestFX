package gymGest;

import interfaces.palaPadel;

/**
 * Created by ignaciosantonjamolina on 16/5/16.
 */
public class ClienteMañanas extends Cliente{

   ClienteMañanas(String dni, String nombre, String direccion, String telefono, String gama, boolean material){
       super(dni, nombre, direccion, telefono, gama, material);
   }

    @Override
    int fijo() {
       return 20;
    }

    @Override
    int alquilerMaterial() {
        return 30;
    }
}
