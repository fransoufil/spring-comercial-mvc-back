package com.fransoufil.comercial.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigoTipoCliente;
	private String descricaoTipoCliente;
	
	private TipoCliente(int codigoTipoCliente, String descricaoTipoCliente) {
		this.codigoTipoCliente = codigoTipoCliente;
		this.descricaoTipoCliente = descricaoTipoCliente;
	}
	
	public int getCodigoTipoCliente() {
		return codigoTipoCliente;
	}
	
	public String descricaoTipoCliente() {
		return descricaoTipoCliente;
	}
	
	public static TipoCliente toEnum(Integer codigoTipoCliente) {
		if (codigoTipoCliente == null) {
			return null;
		}
		
		for (TipoCliente x :TipoCliente.values()) {
			if (codigoTipoCliente.equals(x.getCodigoTipoCliente())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigoTipoCliente);
	}

}
