package br.com.entra21.ASC.main.model.ENUMS;

public enum Sex {
	
	M(0, "MASCULINO"), F(1, "FEMININO"), O(2, "OUTROS");
	private Integer cod;
	private String description;

	private Sex(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Sex toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Sex x : Sex.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("SEXO INVALIDO! "+ cod);
	}

}
