package com.fransoufil.comercial.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int codigoEstadoPagamento;
	private String descricaoEstadoPagamento;
	
	
	private EstadoPagamento(int codigoEstadoPagamento, String descricaoEstadoPagamento) {
		this.codigoEstadoPagamento = codigoEstadoPagamento;
		this.descricaoEstadoPagamento = descricaoEstadoPagamento;
	}
	
	public int getCodigoEstadoPagamento() {
		return codigoEstadoPagamento;
	}
	
	public String descricaoEstadoPagamento() {
		return descricaoEstadoPagamento;
	}
	
	public static EstadoPagamento toEnum(Integer codigoEstadoPagamento) {
		if (codigoEstadoPagamento == null) {
			return null;
		}
		
		for (EstadoPagamento x :EstadoPagamento.values()) {
			if (codigoEstadoPagamento.equals(x.getCodigoEstadoPagamento())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigoEstadoPagamento);
	}


}
