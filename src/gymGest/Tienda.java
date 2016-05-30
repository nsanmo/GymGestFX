package gymGest;

import fabricas.factoryProducer;
import interfaces.palaPadel;

public class Tienda {

	//factoryProducer fp;
	
	palaPadel pala;
	
	public palaPadel alquilarPalaPadel(Cliente cli, String gama){
		//fp = new factoryProducer();
		//pala = factoryProducer.getFactory(gama).crearPala();
		setPala(factoryProducer.getFactory(gama).crearPala());
		return pala;
	}

	public palaPadel getPala() {
		return pala;
	}

	public void setPala(palaPadel pala) {
		this.pala = pala;
	}
	
	
	
	
	
	
	
	
	
	
}
