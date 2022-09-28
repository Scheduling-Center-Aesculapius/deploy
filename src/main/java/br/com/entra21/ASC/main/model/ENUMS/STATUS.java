package br.com.entra21.ASC.main.model.ENUMS;

public enum STATUS {


	OPEN(0, "ABERTO"), PROGRESS(1, "EM ANDAMENTO"), CLOSED(2, "FECHADO");

	private Integer cod;
	private String description;

	private STATUS(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static STATUS toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (STATUS x : STATUS.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("STATUS INVALIDO! "+ cod);
	}

}
