package fabricas;

import interfaces.fabricaAbstractaPalaDePadel;

/**
 * Created by ignaciosantonjamolina on 10/5/16.
 */
public class factoryProducer {
    public static fabricaAbstractaPalaDePadel getFactory(String choice){

        if(choice.equals("alta")){
            return new fabricaPalaGamaAlta();
        } else if(choice.equals("media")){
            return new fabricaPalaGamaMedia();
        } else if(choice.equals("baja")){
            return new fabricaPalaGamaBaja();
        } else if(choice.equals("ninyo")){
            return new fabricaPalaNinyo();
        }
        return null;
    }
}
