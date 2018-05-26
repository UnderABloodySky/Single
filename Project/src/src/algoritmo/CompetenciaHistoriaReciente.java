package algoritmo;

import java.util.List;

import bbdd.BBDD;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;
import resultados.Resultado;

public class CompetenciaHistoriaReciente implements AlgoritmoProbabilidades {
	
	Integer ultimosPartidosAContemplat = new Integer (10);

	//Falta implementar
	@Override
	public Float calcularProbabilidades(List<EventoDeportivo> partidosguardados, Resultado _resultado,
			EventoDeportivo _evento) {
		return null;
	}
	
	

}
