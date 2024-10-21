package fag;

import java.time.LocalDate;

public class Reserva {
	String nomeHospede;
	LocalDate checkIn;
	LocalDate checkOut;
	Quarto quarto;
	
	public Reserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, Quarto quarto) {
        this.nomeHospede = nomeHospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quarto = quarto;
        quarto.atualizarDisponibilidade(false);
	}
	
	public String toString() {
        return "Hóspede: " + nomeHospede + ", Check-in: " + checkIn + ", Check-out: " + checkOut + ", Quarto: " + quarto.numero;
    }
}
