package fabricas;

import gymGest.PalaGamaAlta;
import interfaces.fabricaAbstractaPalaDePadel;
import interfaces.palaPadel;

public class fabricaPalaGamaAlta implements fabricaAbstractaPalaDePadel {
	
	@Override
	public palaPadel crearPala() {
		PalaGamaAlta pga = new PalaGamaAlta();
		pga.generarCodigo();
		return pga;
	}
}
