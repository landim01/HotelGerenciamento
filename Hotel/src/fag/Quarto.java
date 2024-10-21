package fag;

public class Quarto {
	int numero;
	String tipo;
	double precoDiario;
	boolean disponivel;
	
	public Quarto(int numero, String tipo, double precoDiario) {
		this.numero = numero;
		this.tipo = tipo;
		this.precoDiario = precoDiario;
		this.disponivel = true;
	}
	
	public void atualizarDisponibilidade(boolean status) {
		this.disponivel = status;
	}
	
	public String toString() {
        return "Quarto " + numero + " (" + tipo + "), Preço: R$" + precoDiario + ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}