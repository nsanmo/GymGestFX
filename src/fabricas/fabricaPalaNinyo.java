package fabricas;


import gymGest.PalaGamaAlta;
import gymGest.PalaNinyo;
import interfaces.fabricaAbstractaPalaDePadel;
import interfaces.palaPadel;

public class fabricaPalaNinyo implements fabricaAbstractaPalaDePadel {
	
	@Override
	public palaPadel crearPala() {
		PalaNinyo pn = new PalaNinyo();
		pn.generarCodigo();
		return pn;
	}	

}
