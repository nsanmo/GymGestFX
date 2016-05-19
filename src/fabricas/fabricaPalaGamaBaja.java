package fabricas;

import gymGest.PalaGamaBaja;
import interfaces.fabricaAbstractaPalaDePadel;
import interfaces.palaPadel;

public class fabricaPalaGamaBaja implements fabricaAbstractaPalaDePadel {

	@Override
	public palaPadel crearPala() {
		PalaGamaBaja pgm = new PalaGamaBaja();
		pgm.generarCodigo();
		return pgm;
	}	

}
