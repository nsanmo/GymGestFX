package gymGest;

import interfaces.palaPadel;

/**
 * Created by ignaciosantonjamolina on 16/5/16.
 */
public class ClienteFamilia extends Cliente{

    int miembros;

    ClienteFamilia(String dni, String nombre, String direccion, String telefono, String gama , boolean material, int miembros){
        super(dni, nombre, direccion, telefono, gama, material);
        this.miembros=miembros;
    }

    @Override
    int fijo() {
        return 15*miembros;
    }

    @Override
    int alquilerMaterial() {
        return 20*miembros;
    }
}

