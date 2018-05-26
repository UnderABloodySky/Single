package resultados;

import oponentes.Oponente;

public class Empate extends Resultado {

	@Override
	public Oponente getGanador() {
		return null;//A nada mejor
		//return this.errorNoGanador();
	}

	private Exception errorNoGanador() {
		return new Exception("El partido no tuvo ningun ganador. ");
	}

	@Override
	public Integer cantidadEmpates() {
		return one ;
	}

	@Override
	public Integer cantidadVictoria() {
		return zero;
	}

}
