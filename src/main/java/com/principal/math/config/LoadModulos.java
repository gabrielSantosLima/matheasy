package com.principal.math.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.principal.math.enums.AnoCurso;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.repository.ModuloRepository;

//@Component
public class LoadModulos implements ApplicationRunner{

	@Autowired
	private ModuloRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//id, titulo, subconteudos, ano, aluno, atividades
		
		//Sexto Ano
		repository.save(new Modulo(null, 
		"Números Naturais e Operações com números naturais",
		"<li><a>Representação Geométrica dos números naturais</a></li>"+
		"<li><a>Operações com números naturais</a></li>"+
		"<li><a>MMC e MDC</a></li>"+
		"<li><a>Divisibilidade por 2, 3, 4, 5, 6, 7, 8, 9 e 10</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"nn"
		));
		
		repository.save(new Modulo(null, 
		"Números racionais",
		"<li><a>Notação</a></li>"+
		"<li><a>Leitura e Classificação</a></li>"+
		"<li><a>Operações com frações</a></li>"+
		"<li><a>Números decimais</a></li>"+
		"<li><a>Leitura de números decimais</a></li>"+
		"<li><a>Operações com números decimais</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"nr"
		));

		repository.save(new Modulo(null, 
		"Matemática Financeira",
		"<li><a>Noções de porcentagem</a></li>"+
		"<li><a>Situações práticas com porcentagem</a></li>"+
		"<li><a>Calculando descontos</a></li>"+
		"<li><a>Cálculo de acréscimo</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"mf"
		));

		repository.save(new Modulo(null, 
		"Unidades de Medida",
		"<li><a>Medidas de comprimento</a></li>"+
		"<li><a>Medidas de massa</a></li>"+
		"<li><a>Medidas de capacidade</a></li>"+
		"<li><a>Medidas de volume</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"um"
		));

		repository.save(new Modulo(null, 
		"Geometria Plana e Espacial",
		"<li><a>Ponto, reta e plano</a></li>"+
		"<li><a>Retas paralelas e perpendiculares</a></li>"+
		"<li><a>Polígonos</a></li>"+
		"<li><a>Quadriláteros</a></li>"+
		"<li><a>Cálculo de perímetro</a></li>"+
		"<li><a>Cálculo de área</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"gpe"
		));

		repository.save(new Modulo(null, 
		"Sistema Cartesiano e Estatística",
		"<li><a>Como fazer um plano cartesiano?</a></li>"+
		"<li><a>Localizar no plano cartesiano</a></li>"+
		"<li><a>Tipos de gráficos</a></li>"+
		"<li><a>Construção de gráficos</a></li>"+
		"<li><a>Média aritmética</a></li>",
		AnoCurso.SEXTO_ANO,
		null,
		null,
		"sc"
		));

		//Sétimo Ano
		repository.save(new Modulo(null, 
		"Números Inteiros e Operações com números inteiros",
		"<li><a>Representação geométrica dos números inteiros</a></li>"+
		"<li><a>Número oposto</a></li>"+
		"<li><a>Operação com números inteiros</a></li>"+
		"<li><a>Expressão numérica</a></li>",
		AnoCurso.SETIMO_ANO,
		null,
		null,
		"ni"
		));
		
		repository.save(new Modulo(null, 
		"Números racionais e operações com números racionais",
		"<li><a>Representação geométrica dos números racionais</a></li>"+
		"<li><a>Números decimais</a></li>"+
		"<li><a>Raiz quadrada e cúbica</a></li>",
		AnoCurso.SETIMO_ANO,
		null,
		null,
		"nr"
		));
		
		repository.save(new Modulo(null, 
		"Matemática Financeira",
		"<li><a>Razão e proporção</a></li>"+
		"<li><a>Grandezas</a></li>"+
		"<li><a>Regra de três</a></li>"+
		"<li><a>Porcentagem</a></li>"+
		"<li><a>Juros simples e composto</a></li>",
		AnoCurso.SETIMO_ANO,
		null,
		null,
		"mf"
		));
		
		repository.save(new Modulo(null, 
		"Geometria plana e espacial",
		"<li><a>Ângulos</a></li>"+
		"<li><a>Ângulos Congruentes</a></li>"+
		"<li><a>Ângulos Consecutivos</a></li>"+
		"<li><a>Ângulos Adjacentes</a></li>"+
		"<li><a>Simetria</a></li>"+
		"<li><a>Poliedros</a></li>"+
		"<li><a>Cálculo de volume</a></li>",
		AnoCurso.SETIMO_ANO,
		null,
		null,
		"gpe"
		));
		
		//Oitavo Ano
		repository.save(new Modulo(null, 
		"Números reais",
		"<li><a>Potenciação</a></li>"+
		"<li><a>Radiciação</a></li>"+
		"<li><a>Raízes exatas e aproximadas</a></li>"+
		"<li><a>Números irracionais</a></li>"+
		"<li><a>Conjunto dos números reais</a></li>",
		AnoCurso.OITAVO_ANO,
		null,
		null,
		"nr"
		));
		
		repository.save(new Modulo(null, 
		"Álgebra",
		"<li><a>Simplificação de expressões algébricas</a></li>"+
		"<li><a>Monômios</a></li>"+
		"<li><a>Polinômios</a></li>"+
		"<li><a>Produtos notáveis</a></li>"+
		"<li><a>Fatoração</a></li>"+
		"<li><a>Frações algébricas</a></li>"+
		"<li><a>Equação do primeiro grau</a></li>"+
		"<li><a>Sistema de equação do primeiro grau</a></li>"+
		"<li><a>Sistema de inequação do primeiro grau</a></li>"+
		"<li><a>Inequação do primeiro grau</a></li>",
		AnoCurso.OITAVO_ANO,
		null,
		null,
		"a"
		));
		
		repository.save(new Modulo(null, 
		"Geometria plana e espacial",
		"<li><a>Polígonos</a></li>"+
		"<li><a>Triângulo</a></li>"+
		"<li><a>Quadrilátero</a></li>"+
		"<li><a>Circunferência e círculo</a></li>"+
		"<li><a>Área e perímetro</a></li>"+
		"<li><a>Sólidos geométricos</a></li>"+
		"<li><a>Planificaçãõ de prisma</a></li>",
		AnoCurso.OITAVO_ANO,
		null,
		null,
		"ge"
		));
		
		repository.save(new Modulo(null, 
		"Estatística e probabilidade",
		"<li><a>Gráfico e Tabela</a></li>"+
		"<li><a>Média aritmética e ponderada</a></li>"+
		"<li><a>Mediana e moda</a></li>"+
		"<li><a>Probabilidade</a></li>",
		AnoCurso.OITAVO_ANO,
		null,
		null,
		"e"
		));
		
		//Nono Ano
		repository.save(new Modulo(null, 
		"Radiciação",
		"<li><a>Definição</a></li>"+
		"<li><a>Propriedades da radiciação</a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"nn"
		));
		
		repository.save(new Modulo(null, 
		"Potenciação",
		"<li><a>Definição<a></li>"+
		"<li><a>Propriedades da potencição<a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"p"
		));
		
		repository.save(new Modulo(null, 
		"Unidades de medida",
		"<li><a>Medidas em informática<a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"um"
		));

		repository.save(new Modulo(null, 
		"Geometria plana e espacial",
		"<li><a>Teorema de Tales<a></li>"+
		"<li><a>Teorema de pitágoras<a></li>"+
		"<li><a>Relações métricas do triângulo retângulo<a></li>"+
		"<li><a>Relações métricas da circunferência<a></li>"+
		"<li><a>Trigonometria<a></li>"+
		"<li><a>Razões Trigonométricas<a></li>"+
		"<li><a>Relações entre seno, cosseno e tangente.<a></li>"+
		"<li><a>As razões trigonométricas de 30, 45 e 60 grau<a></li>"+
		"<li><a>Geometria espacial<a></li>"+
		"<li><a>Prisma e Cilindro<a></li>"+
		"<li><a>Volume do Cilindro<a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"gpe"
		));
		
		repository.save(new Modulo(null, 
		"Álgebra",
		"<li><a>Equação do segundo grau<a></li>"+
		"<li><a>Equação Biquadrada<a></li>"+
		"<li><a>Sistema de equação do segundo grau<a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"a"
		));
		
		repository.save(new Modulo(null, 
		"Noção de funções",
		"<li><a>Coordenadas Cartesianas<a></li>"+
		"<li><a>Construção de um gráfico de funções<a></li>"+
		"<li><a>Função Afim<a></li>"+
		"<li><a>Função Quadrática<a></li>",
		AnoCurso.NONO_ANO,
		null,
		null,
		"nf"
		));
	}

}
