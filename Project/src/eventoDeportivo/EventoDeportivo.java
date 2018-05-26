package eventoDeportivo;

import java.util.ArrayList;
import java.util.List;

import casaDeApuestas.*;
import estado.EstadoEventoDeportivo;
import estado.*;
import oponentes.*;
import resultados.*;

public class EventoDeportivo {
	
	Deporte deporte;
	List<Oponente> oponentes;
	String lugar; //String o clase?
	EstadoEventoDeportivo estado;
	Resultado resultado;
	
		public EventoDeportivo(Deporte _deporte, Oponente oponente1, Oponente oponente2) {
			deporte = _deporte;
			oponentes = new ArrayList<Oponente>(2);
			this.setOponentes(oponente1, oponente2);
			estado = new NoComenzado();
			resultado = new Empate();
		}

			private void setOponentes(Oponente _oponente1, Oponente _oponente2) {
				oponentes.add(_oponente1);
				oponentes.add(_oponente2);
			}
			
			private Boolean participo(Oponente _oponente) {
				return oponentes.contains(_oponente);
			}
			
			public Boolean participaronVs(Oponente _oponente1, Oponente _oponente2) {
				return this.participo(_oponente1) && this.participo(_oponente2);
			}

			//Falta implementar
			public Boolean estaFinalizado() {
				return estado.estaFinalizado();
			}
			
			public Float cuota(CasaDeApuestas _casa, EventoDeportivo _evento, Oponente _oponenteAlQueSeApuesta) {
				return this.probabilidades(_casa, this, _oponenteAlQueSeApuesta);
			}
			
			private Float probabilidades(CasaDeApuestas _casa, EventoDeportivo _evento, Oponente _alQueSeApuesta){
				return 1 + (1 - _casa.calcularProbabilidadesDe(_evento.elOponenteDe(_alQueSeApuesta), _evento)); 
			}
			
			private Oponente primerOponente() {
				return oponentes.get(0);
			}
			
			private Oponente segundoOponente() {
				return oponentes.get(1);
			}

			//Esto hace (mucho) ruido
			public Oponente elOponenteDe(Oponente _oponente) {
				Oponente contrario;
				if(! this.participo(_oponente)) {
					this.errorNoParticipa();
				}
				if(_oponente.es(this.primerOponente())) {
					contrario = this.segundoOponente(); 
				}
				else {
					contrario = this.primerOponente();
				}
				return contrario;
			}

			private Exception errorNoParticipa() {
				return new Exception("El oponente no pertenece a este evento.");
			}

			public Boolean empezo() {
				return estado.empezo();
			}
			
			public void setEstado(EstadoEventoDeportivo _estado) {
				estado = _estado;
			}
			
			public Resultado resultadoParcial() {
				return resultado;
			}
			
			//Este mensaje necesita que se mande en un momento justo y nunca a un partido finalizado
			public void setResultado(Resultado _resultado) {
				
				if(this.estaFinalizado()) {
					this.errorEventoTerminado();
				}
					resultado = _resultado;
			}

			private Exception errorEventoTerminado() {
				return new Exception(" El evento no puede ser modificado ya que ha concluido. ");
			}
}
