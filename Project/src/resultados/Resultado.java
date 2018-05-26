package resultados;

import oponentes.Oponente;



public abstract class Resultado {

	protected final Integer zero = new Integer(0);
	protected final Integer one = new Integer(1);
	
		public abstract Oponente getGanador();
	
		public abstract Integer cantidadEmpates();
	
		public abstract Integer cantidadVictoria();

	
}
