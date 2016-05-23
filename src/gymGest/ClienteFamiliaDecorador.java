package gymGest;

public class ClienteFamiliaDecorador extends ClienteDecorador{

	private Cliente cliente;
	
	public ClienteFamiliaDecorador(Cliente cli) {
		this.cliente = cliente;
	}
	

	@Override
	public int getMiembros() {
		return cliente.getMiembros()+5;
	}

	@Override
	public int fijo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alquilerMaterial() {
		// TODO Auto-generated method stub
		return 0;
	}
}
