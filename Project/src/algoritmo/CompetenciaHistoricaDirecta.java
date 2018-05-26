package algoritmo;

import java.util.ArrayList;
import java.util.List;

import algoritmo.AlgoritmoProbabilidades;
import eventoDeportivo.EventoDeportivo;
import resultados.*;

public class CompetenciaHistoricaDirecta implements AlgoritmoProbabilidades {

	@Override
	public Float calcularProbabilidades(List<EventoDeportivo> eventosTotales, Resultado _resultado,
			EventoDeportivo _eventoFinalizado) {
		
		List<EventoDeportivo> historico = new ArrayList<EventoDeportivo>(0);
		
		for (EventoDeportivo _evento : eventosTotales) {
			if(_evento.participaronVs(_eventoFinalizado.primerOponente(), _eventoFinalizado.segundoOponente())) {
				historico.add(_evento);
			}
		}
		
		Float resultado = new Float(0);
		
		//NO me gusta esta pregunta po identidad, pero acorta el laburo
		for (EventoDeportivo otroEvento : historico) {
			if(otroEvento.getResultado() == _resultado){
				resultado += new Float(1); 
			}
		}
		return resultado / historico.size();
	}

}


	

