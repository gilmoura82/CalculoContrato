package services;

public class PayPalService implements PagamentoOnlineService{ {
	
}

@Override
public double taxaPagamento(double quantidade) {
	return quantidade * 0.02;
}

@Override
public double juros(double quantidade, int meses) {
	return quantidade * 0.01 * meses;
}

}
