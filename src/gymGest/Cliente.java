package gymGest;

public abstract class Cliente {
	
	int miembros;

	public int getMiembros(){
		return miembros;
	}
	
	
	public final int cuotaMensual(){
		int cuota = 0;
			if(true){return fijo()+alquilerMaterial();}
		return fijo();
	}
	public abstract int fijo();
	public abstract int alquilerMaterial();

}
