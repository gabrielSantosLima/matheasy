package com.principal.math.enums;

import java.util.Arrays;

public enum AnoCurso {

	SEXTO_ANO(6),
	SETIMO_ANO(7),
	OITAVO_ANO(8),
	NONO_ANO(9);
	
	private Integer ano;
	
	AnoCurso(Integer ano) {
		this.ano = ano;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public static AnoCurso of(Integer ano) {
		return Arrays.asList(AnoCurso.values())
				.stream()
				.filter(a -> a.getAno() == ano)
				.findFirst()
				.get();
	}
}
