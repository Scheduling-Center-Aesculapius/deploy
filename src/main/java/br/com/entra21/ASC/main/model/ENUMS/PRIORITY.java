package br.com.entra21.ASC.main.model.ENUMS;

public enum PRIORITY {

	LOW(0, "BAIXA"), MEDIUM(1, "MEDIA"), HIGH(2, "ALTA");

	private Integer cod;
	private String description;

	private PRIORITY(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static PRIORITY toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (PRIORITY x : PRIORITY.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("PRIORIDADE INVALIDA! "+ cod);
	}

}
