package algoritmo;

import java.util.List;

import bbdd.BBDD;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;
import resultados.Resultado;

public interface AlgoritmoProbabilidades {

	Float calcularProbabilidades(List<EventoDeportivo> partidosguardados, Resultado _resultado,
			EventoDeportivo _evento);

}
