package fag;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Hotel {
	
	ArrayList<Quarto> quartos = new ArrayList<>();
	ArrayList<Reserva> reservas = new ArrayList<>();
	
	public void cadastrarQuarto(int numero, String tipo, Double precoDiario) {
		Quarto quarto = new Quarto(numero, tipo, precoDiario);
		quartos.add(quarto);
	}
	
	public void listarQuartos() {
		for(Quarto quarto : quartos) {
			System.out.println(quarto);
		}
	}
	
	public Quarto buscarQuartoDisponivel(String tipo) {
		for(Quarto quarto : quartos) {
			if (quarto.tipo.equals(tipo) && quarto.disponivel) {
                return quarto;
			}
		}
		return null;
	}
	
	public void cadastrarReserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, String tipoQuarto) {
        Quarto quartoDisponivel = buscarQuartoDisponivel(tipoQuarto);
        if (quartoDisponivel != null) {
            Reserva reserva = new Reserva(nomeHospede, checkIn, checkOut, quartoDisponivel);
            reservas.add(reserva);
            System.out.println("Reserva realizada com sucesso!");
        } else {
            System.out.println("Nenhum quarto disponível do tipo solicitado.");
        }
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

	public static void main(String[] args) {
		
		 Hotel hotel = new Hotel();
	        Scanner scanner = new Scanner(System.in);

	        hotel.cadastrarQuarto(101, "Solteiro", 150.00);
	        hotel.cadastrarQuarto(102, "Casal", 200.00);
	        hotel.cadastrarQuarto(103, "Suite", 350.00);

	        int opcao;
	        do {
	            System.out.println("\n Sistema de Gerenciamento de Hotel ");
	            System.out.println("1- Listar quartos");
	            System.out.println("2- Cadastrar reserva");
	            System.out.println("3- Listar reservas");
	            System.out.println("0- Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();
	            scanner.nextLine();  

	            switch (opcao) {
	                case 1:
	                    hotel.listarQuartos();
	                    break;
	                    
	                case 2:
	                    System.out.print("Nome do hóspede: ");
	                    String nome = scanner.nextLine();
	                    
	                    System.out.print("Data de check-in (aaaa-mm-dd): ");
	                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
	                    
	                    System.out.print("Data de check-out (aaaa-mm-dd): ");
	                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());
	                    
	                    System.out.print("Tipo de quarto (Solteiro/Casal/Suite): ");
	                    String tipoQuarto = scanner.nextLine();
	                    
	                    hotel.cadastrarReserva(nome, checkIn, checkOut, tipoQuarto);
	                    break;
	                case 3:
	                    hotel.listarReservas();
	                    break;
	                    
	                case 0:
	                    System.out.println("Saindo...");
	                    break;
	                    
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            }
	        } while (opcao != 0);

	        scanner.close();
	    }
	
			

	}


