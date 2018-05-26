package resultados;

import oponentes.Oponente;

public class Ganado extends Resultado {

	private Oponente ganador;
	
	public Ganado(Oponente _ganador) {
		ganador = _ganador;
	}
	
		@Override
		public Oponente getGanador() {
			return ganador;
		}

		@Override
		public Integer cantidadEmpates() {
			return zero;
		}

		@Override
		public Integer cantidadVictoria() {
			return one;
		}

}
