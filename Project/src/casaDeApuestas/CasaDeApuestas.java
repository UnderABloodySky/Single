package casaDeApuestas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import algoritmo.*;
import bbdd.*;
import eventoDeportivo.*;
import notifier.*;
import oponentes.*;
import resultados.*;
import usuario.User;

public class CasaDeApuestas {

	private List<User> usuarios;
	private AlgoritmoProbabilidades algoritmo; 
	private BalanceNotifier textMessageBalanceNotifier;
	private BBDD baseDeDatos;
	
		public CasaDeApuestas() {
			usuarios = new ArrayList<User>();
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
			this.setBBDD(new BaseDeDatos());
		}
		
		
		public CasaDeApuestas(List<User> _usuarios, AlgoritmoProbabilidades _algoritmo,BalanceNotifier _notifier, BBDD _baseDeDatos) {
			usuarios = _usuarios;
			this.setAlgoritmo(new CompetenciaHistoricaDirecta());
			this.setNotifier(new TextMessageBalanceNotifier());
			this.setBBDD(_baseDeDatos);
		}
		
			//Flexibility
			public void setAlgoritmo(AlgoritmoProbabilidades _algoritmo) {
				algoritmo = _algoritmo;
			}
			
			public void setNotifier(BalanceNotifier _notifier) {
				textMessageBalanceNotifier = _notifier;
			}

			//Flexibility
			public void setBBDD(BBDD _baseDeDatos) {
				baseDeDatos = _baseDeDatos;
			}

			//Flexibility
			public void agregarusuario(User _usuario) {
				usuarios.add(_usuario);
			}
			
			public void notificarBalanceUsuarios() {
				Integer month = new Integer(this.numeroDelMes());
				
				for(User user : usuarios) {
					textMessageBalanceNotifier.notifyBalance(user, month, this.ganancias());
				}
			}
		
			//LLevar esto al calendario?
			private int numeroDelMes() {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				return month;
			}

			//Falta implementar
			private BigDecimal ganancias() {
				return null;	
			}
			
			public Float calcularProbabilidadesDe(EventoDeportivo _evento, Resultado _resultado) {
				return algoritmo.calcularProbabilidades(baseDeDatos.eventosTerminados(), _resultado, _evento);
			}
}