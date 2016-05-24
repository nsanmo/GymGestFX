package gymGest;

import fabricas.factoryProducer;
import interfaces.palaPadel;

public class Tienda {

	//factoryProducer fp;
	Cliente cli;
	palaPadel pa;
	
	public palaPadel alquilarPalaPadel(Cliente cli, String gama){
		//fp = new factoryProducer();
		pa = factoryProducer.getFactory(gama).crearPala();
		return pa;
	}
	
	
	
	
	
	
	
	
}
