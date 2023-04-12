package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelas {
	
	private static	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

	
	private LocalDate data;
	private double parcela;
	
	public Parcelas() {
	}
	
	public Parcelas(LocalDate data, double parcela) {
		this.data = data;
		this.parcela = parcela;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getParcela() {
		return parcela;
	}

	public void setParcela(double parcela) {
		this.parcela = parcela;
	}

	@Override
	public String toString() {
		return data.format(fmt) + " - " + String.format("%.2f", parcela);
	}
	
	
	
	

}
