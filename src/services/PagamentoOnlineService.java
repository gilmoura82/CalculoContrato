package services;

public interface PagamentoOnlineService {
	
	double taxaPagamento(double quantidade);
	double juros(double quantidade, int meses);

}
