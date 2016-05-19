package fabricas;

import gymGest.PalaGamaMedia;
import interfaces.fabricaAbstractaPalaDePadel;
import interfaces.palaPadel;

public class fabricaPalaGamaMedia implements fabricaAbstractaPalaDePadel {

	@Override
	public palaPadel crearPala() {
		PalaGamaMedia pgm = new PalaGamaMedia();
		pgm.generarCodigo();
		return pgm;
}
}