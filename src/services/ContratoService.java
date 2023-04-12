package services;

import java.time.LocalDate;

import Entities.Contrato;
import Entities.Parcelas;

public class ContratoService {
	
	private PagamentoOnlineService pagamentoOnlineService;
	
	public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
		this.pagamentoOnlineService = pagamentoOnlineService;
	}
	
	public void processoContrato(Contrato contrato, int meses) {
		
		double parcelaBasica = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			LocalDate dataContrato = contrato.getData().plusMonths(i);
			
			double juros = pagamentoOnlineService.juros(parcelaBasica, i);
			double taxa = pagamentoOnlineService.taxaPagamento(parcelaBasica + juros);
			double quota = parcelaBasica + juros + taxa;
			
			contrato.getParcelas().add(new Parcelas(dataContrato, quota));
			
		}

		
		
	}

}
