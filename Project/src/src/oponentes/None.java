package oponentes;

public class None implements Oponente {

	@Override
	public String nombre() {
		return " ";
	}

	@Override
	public boolean es(Oponente _ponente) {
		return false;
	}

}
