package gymGest;

import interfaces.palaPadel;

public class PalaGamaBaja implements palaPadel{

	private int codigo;

	public int getCodigo(){
		if (codigo == 0) codigo = generarCodigo();
		return codigo;	
	}
	
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}
	
	@Override
	public int generarCodigo() {
		int codigoPala = (int) (Math.random()*(2000-1000+1)+1000);
		return codigoPala;
	}
	
	@Override
	public void codigoDePala() {
		System.out.println("El código de la pala gama baja es " + getCodigo());
		
	}

	
}
