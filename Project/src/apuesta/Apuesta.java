package apuesta;

import casaDeApuestas.CasaDeApuestas;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public abstract class Apuesta {
	
	private Float montoApostado;
	private EventoDeportivo eventoDeportivo;
	private Oponente oponenteApostado;
	private TipoApuesta tipo;
	
	public Apuesta(Float _monto, EventoDeportivo _evento, Oponente _oponente, TipoApuesta _tipo) {
		this.setMonto(_monto);
		this.setEvento(_evento);
		this.setOponente(_oponente);
		tipo = _tipo;
	}
	
		private void setMonto(Float _monto) {
			montoApostado = _monto;	
		}
		
		private void setEvento(EventoDeportivo _evento) {
			eventoDeportivo = _evento;	
		}
	
		private void setOponente(Oponente _oponente) {
			oponenteApostado = _oponente;
		}
		
		public Float monto() {
			return montoApostado;
		}
		
		public Boolean empezoPartido() {
			return eventoDeportivo.empezo();
		}
		
		//Ver
		public Float gananciaBruta(CasaDeApuestas _casa) {
			return eventoDeportivo.cuota(_casa, eventoDeportivo, oponenteApostado) * this.monto();
		}
		
		//Ver
		public Float gananciaNeta(CasaDeApuestas _casa) {
			return this.gananciaBruta(_casa) - this.monto();
		}
		
		public void cancelar() {
			tipo.cancelar(this);
		}
	
}
