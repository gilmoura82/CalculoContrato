package Programa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contrato;
import Entities.Parcelas;
import services.ContratoService;
import services.PayPalService;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Nº do contrato: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato obj = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o nº de parcelas: ");
		int n = sc.nextInt();
		
		ContratoService contratoService = new ContratoService(new PayPalService());
		
		contratoService.processoContrato(obj, n);
		
		System.out.println("Parcelas: ");
		for (Parcelas parcela : obj.getParcelas()) {
			System.out.println(parcela);
		}
		
		
		sc.close();
		
		

	}

}
