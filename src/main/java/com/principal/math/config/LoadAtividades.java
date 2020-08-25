package com.principal.math.config;

import org.springframework.boot.ApplicationArguments;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.principal.math.controller.services.AtividadeService;
import com.principal.math.controller.services.ModuloService;
import com.principal.math.model.entity.Atividade;
import com.principal.math.model.entity.Modulo;
import com.principal.math.model.repository.AtividadeRepository;

@Component
@SuppressWarnings(value = "unused")
@Order(3)
public class LoadAtividades implements ApplicationRunner{

	@Autowired
	private AtividadeService service;

	@Autowired
	private ModuloService moduloService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		createAtividadesIfNotExists(new Atividade(null,
			"1) Veja o significado dos sinais no quadro abaixo:\r\n" + 
			"<figure><a href=\"https://azup.com.br/wp-content/uploads/1-2.png\"><img\r\n" + 
			"            src=\"https://azup.com.br/wp-content/uploads/1-2.png\" /></a></figure>\r\n" + 
			"<p>Agora responda: quais opções estão corretas?</p>",
			"a) 43 = 34",
			"b) 43 ≠ 43	",
			"c) 43 &gt; 34",
			"d) 43 &lt; 34",
			"e) 34 &gt; 43",
			1,
			1,
			moduloService.findById(1).get()
		));
		
		createAtividadesIfNotExists(new Atividade(null,
				"2) A diferença entre os números naturais 20010 e 3291\r\n" + 
				"    é igual a:",
				"a) 1414",
				"b) 16719",
				"c) 15446",
				"d) 32450",
				"e) 1229",
				1,
				1,
				moduloService.findById(1).get()
		));
		
		createAtividadesIfNotExists(new Atividade(null,
				"3) Utilizando esses números 341.926.87.Ele é formado\r\n" + 
				"    por quantos algarismos?",
				"a) 7",
				"b) 13",
				"c) 9",
				"d) 10",
				"e) 8",
				1,
				1,
				moduloService.findById(1).get()
		));
		
		createAtividadesIfNotExists(new Atividade(null,
				"4) Excetuando-se o 1, sabe-se que o menor divisor\r\n" + 
				"    positivo de cada um de três números naturais diferentes são, respectivamente, 7; 3 e 11. Excetuando-se o\r\n" + 
				"    próprio número, sabe-se que o maior divisor de cada um dos três números naturais já citados são,\r\n" + 
				"    respectivamente, 11; 17 e 13. A soma desses três números naturais é igual a:",
				"a) 271",
				"b) 159",
				"c) 62",
				"d) 303",
				"e) 417",
				1,
				1,
				moduloService.findById(1).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) Se x = 3 200 000 e y = 0,00002,\r\n" + 
				"    então <strong>x.y</strong> vale:",
				"a) 0,64",
				"b) 6,4",
				"c) 64",
				"d) 640",
				"e) 6 400",
				1,
				1,
				moduloService.findById(2).get()
		));
		createAtividadesIfNotExists(new Atividade(null,
				"2) Considere <strong>a</strong> e <strong>b</strong> números racionais quaisquer. Podemos\r\n" + 
				"    afirmar que é\r\n" + 
				"    INCORRETA a alternativa:",
				"a) a/2 será um número racional.",
				"b) √a será um número racional.",
				"c) a – b será um número racional.",
				"d) a + b será um número racional.",
				"e) a.b será um número racional.",
				1,
				1,
				moduloService.findById(2).get()
		));
		createAtividadesIfNotExists(new Atividade(null,
				"3) Joana comeu 1/5 (um quinto) de um bolo, qual a\r\n" + 
				"    fração que restou do bolo?",
				"a) 4/5",
				"b) 5/7",
				"c) 9/3",
				"d) 5/6",
				"e) 1/2",
				1,
				1,
				moduloService.findById(2).get()
		));
		
		createAtividadesIfNotExists(new Atividade(null,
				"3) Joana comeu 1/5 (um quinto) de um bolo, qual a\r\n" + 
				"    fração que restou do bolo?",
				"a) 23/5",
				"b) -45/8",
				"c) 42/8",
				"d) 77/5",
				"e) -77/10",
				1,
				1,
				moduloService.findById(2).get()
		));
		createAtividadesIfNotExists(new Atividade(null,
				"1) Convertendo a fração 2/5 em uma fração centesimal,qual o resultado em porcentagem?\r\n" + 
				"<figure><a href=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAAjCAYAAACZ6FpfAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAABGJhU0UAAAAXQ/cXWQAAAMBJREFUeNpjYMAOrIF4DRB/AuJfQHwBiKMZyAAHgTgSiHmgfC0gPgoVoxjIA/ElBiqBH9QwxBLqPYoABxCfhEYC2UAQiDcAsRslhihBDVGhxBANIJ4NxFyUGCIOxKuAmIXSwN0CdRHF4D8ePAoGE/hPJh4FQyEGSTaIai4axgb9gtb924C4CKn6JguAymxjIK4F4hvUKn7doI2LwVP36wDxXVI1rYM2Gpig2ANqSBCpBoUC8S0g/gPE76CVpSk+DQBe0j3gm92kxAAAAGJ0RVh0TWF0aE1MADxtYXRoIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8xOTk4L01hdGgvTWF0aE1MIj48bWZyYWM+PG1uPjI8L21uPjxtbj41PC9tbj48L21mcmFjPjwvbWF0aD5O8RyGAAAAAElFTkSuQmCC\"><img\r\n" + 
				"            src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAAjCAYAAACZ6FpfAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAABGJhU0UAAAAXQ/cXWQAAAMBJREFUeNpjYMAOrIF4DRB/AuJfQHwBiKMZyAAHgTgSiHmgfC0gPgoVoxjIA/ElBiqBH9QwxBLqPYoABxCfhEYC2UAQiDcAsRslhihBDVGhxBANIJ4NxFyUGCIOxKuAmIXSwN0CdRHF4D8ePAoGE/hPJh4FQyEGSTaIai4axgb9gtb924C4CKn6JguAymxjIK4F4hvUKn7doI2LwVP36wDxXVI1rYM2Gpig2ANqSBCpBoUC8S0g/gPE76CVpSk+DQBe0j3gm92kxAAAAGJ0RVh0TWF0aE1MADxtYXRoIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8xOTk4L01hdGgvTWF0aE1MIj48bWZyYWM+PG1uPjI8L21uPjxtbj41PC9tbj48L21mcmFjPjwvbWF0aD5O8RyGAAAAAElFTkSuQmCC\" /></a>\r\n" + 
				"</figure>",
				"a) 10%",
				"b) 20%",
				"c) 30%",
				"d) 45%",
				"e) 40%",
				1,
				1,
				moduloService.findById(3).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2)Em uma sala de aula há 30 alunos, dos quais 40% são\r\n" + 
				"    meninas. Quantas meninas têm na sala?",
				"a) 10 meninas",
				"b) 12 meninas",
				"c) 15 meninas",
				"d) 18 meninas",
				"e) 24 meninas",
				1,
				1,
				moduloService.findById(3).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) 25 representa quantos por cento de 200?",
				"a) 12,5%",
				"b) 15,5%",
				"c) 16%",
				"d) 20%",
				"e) 26%",
				1,
				1,
				moduloService.findById(3).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4) 30 representa 15% de qual número?",
				"a) 150",
				"b) 205",
				"c) 350",
				"d) 400",
				"e) 200",
				1,
				1,
				moduloService.findById(3).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) Um mecânico de uma equipe de\r\n" + 
				"    corrida necessita que as seguintes medidas realizadas em um carro sejam obtidas em metros: a) distância\r\n" + 
				"    a entre os eixos dianteiro e traseiro;\r\n" + 
				"<figure><a href=\"https://beduka.com/blog/wp-content/uploads/2019/07/enem-2011-conversao-de-unidades-exercicio-1.gif\"><img\r\n" + 
				"            style=\"width:480px\"\r\n" + 
				"            src=\"https://beduka.com/blog/wp-content/uploads/2019/07/enem-2011-conversao-de-unidades-exercicio-1.gif\" /></a>\r\n" + 
				"</figure>\r\n" + 
				"<p>Ao optar pelas medidas a e b em metros, obtêm-se,\r\n" + 
				"    respectivamente,</p>",
				"a) 0,23 e 0,16",
				"b) 2,3 e 1,6",
				"c) 23 e 16",
				"d) 230 e 160",
				"e) 2.300 e 1.600",
				1,
				1,
				moduloService.findById(4).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2) Foram construídos dois\r\n" + 
				"    reservatórios de água. A razão entre os volumes internos do primeiro e do segundo é de 2 para 5, e a\r\n" + 
				"    soma desses volumes é 14 m³. Assim, o valor absoluto da diferença entre as capacidades desses dois\r\n" + 
				"    reservatórios, em litros, é igual a",
				"a) 8 000.",
				"b) 6 000.",
				"c) 4 000.",
				"d) 6 500.",
				"e) 9 000.",
				1,
				1,
				moduloService.findById(4).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) Determine o valor em decímetros de 0,375 dam.",
				"a) 3,75dm",
				"b) 0,0375dm",
				"c) 3750dm",
				"d) 37,5dm",
				"e) 375dm",
				1,
				1,
				moduloService.findById(4).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4) Quantos cm³ existem em 10 litros?",
				"a) 10",
				"b) 100",
				"c) 1.000",
				"d) 10.000",
				"e) 100.000",
				1,
				1,
				moduloService.findById(4).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) Observe a caixa representada abaixo:\r\n" + 
				"<figure><a href=\"https://4.bp.blogspot.com/-exn7b1AKm24/VgCFir19HuI/AAAAAAAABGU/5YfsrmOlYwQ/s1600/m1.png\"><img\r\n" + 
				"            style=\"width:240px\"\r\n" + 
				"            src=\"https://4.bp.blogspot.com/-exn7b1AKm24/VgCFir19HuI/AAAAAAAABGU/5YfsrmOlYwQ/s1600/m1.png\" /></a>\r\n" + 
				"</figure>\r\n" + 
				"<p>Uma planificação dessa caixa é:</p>\r\n" + 
				"<figure><a href=\"https://2.bp.blogspot.com/-BOQhG9vJcZM/VgCGJ-FjylI/AAAAAAAABGc/sNxnPW2-g9o/s1600/m2.png\"><img\r\n" + 
				"            style=\"width:336px\"\r\n" + 
				"            src=\"https://2.bp.blogspot.com/-BOQhG9vJcZM/VgCGJ-FjylI/AAAAAAAABGc/sNxnPW2-g9o/s1600/m2.png\" /></a>\r\n" + 
				"</figure>",
				"a)",
				"b)",
				"c)",
				"d)",
				"e) nenhuma das anteriores.",
				1,
				1,
				moduloService.findById(5).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2) A forma geométrica espacial que pode ser associada\r\n" + 
				"    à planificação abaixo é:\r\n" + 
				"<figure><a href=\"https://4.bp.blogspot.com/-Vyk15AZGoBY/VgCGrHG1mtI/AAAAAAAABGo/S8_BWKLwxtQ/s1600/m3.png\"><img\r\n" + 
				"            style=\"width:240px\"\r\n" + 
				"            src=\"https://4.bp.blogspot.com/-Vyk15AZGoBY/VgCGrHG1mtI/AAAAAAAABGo/S8_BWKLwxtQ/s1600/m3.png\" /></a>\r\n" + 
				"</figure>",
				"a) um cilindro.",
				"b) uma pirâmide de base pentagonal.",
				"c) um prisma de base pentagonal.",
				"d)um paralelepípedo.",
				"e) um triângulo.",
				1,
				1,
				moduloService.findById(5).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) As figuras 1, 2 e 3 correspondem, respectivamente,\r\n" + 
				"    às planificações dos sólidos:\r\n" + 
				"<figure><a href=\"https://4.bp.blogspot.com/-DxQ01ruSVcc/VgCHTm2W7OI/AAAAAAAABGw/1F3_daPCCFo/s1600/m4.png\"><img\r\n" + 
				"            style=\"width:432px\"\r\n" + 
				"            src=\"https://4.bp.blogspot.com/-DxQ01ruSVcc/VgCHTm2W7OI/AAAAAAAABGw/1F3_daPCCFo/s1600/m4.png\" /></a>\r\n" + 
				"</figure>",
				"a) Cubo, cone, pirâmide.",
				"b) Pirâmide, cilindro, cubo.",
				"c) Cubo, cilindro, pirâmide.",
				"d) Pirâmide, cone, cubo.",
				"e) Pirâmide, cone,triângulo.",
				1,
				1,
				moduloService.findById(5).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4) Observe abaixo o modelo de um cubo. Ele tem 11\r\n" + 
				"    planificações diferentes, isto é,\r\n" + 
				"<p>existem 11 diferentes moldes possíveis para se montar\r\n" + 
				"    um cubo, por meio de dobradura.</p>\r\n" + 
				"<figure><a href=\"https://1.bp.blogspot.com/-W2NkAiLXYuM/VgCHkhvl2aI/AAAAAAAABG4/P_IJ7w4TDPA/s1600/m5.png\"><img\r\n" + 
				"            style=\"width:192px\"\r\n" + 
				"            src=\"https://1.bp.blogspot.com/-W2NkAiLXYuM/VgCHkhvl2aI/AAAAAAAABG4/P_IJ7w4TDPA/s1600/m5.png\" /></a>\r\n" + 
				"</figure>\r\n" + 
				"<p>Identifique dentre as alternativas abaixo, uma dessas\r\n" + 
				"    planificações:</p>\r\n" + 
				"<figure><a href=\"https://4.bp.blogspot.com/-npH9PsXk5dA/VgCH8MxoONI/AAAAAAAABHA/k9EsJN1eLEI/s1600/m6.png\"><img\r\n" + 
				"            style=\"width:384px\"\r\n" + 
				"            src=\"https://4.bp.blogspot.com/-npH9PsXk5dA/VgCH8MxoONI/AAAAAAAABHA/k9EsJN1eLEI/s1600/m6.png\" /></a>\r\n" + 
				"</figure>",
				"a)",
				"b)",
				"c)",
				"d)",
				"e) Nenhuma das anteriores.",
				1,
				1,
				moduloService.findById(5).get()
		));
		
		createAtividadesIfNotExists(new Atividade(null,
				"1) Qual par ordenado não está representado no plano\r\n" + 
				"    cartesiano?\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled.png\"><img style=\"width:336px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled.png\" /></a></figure>",
				"a) (3, -4)",
				"b) (4, -3)",
				"c) (-8, -9)",
				"d) (8, 9)",
				"e) (9, -8)",
				1,
				1,
				moduloService.findById(6).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2) Quais pares ordenados estão representado no plano\r\n" + 
				"    cartesiano?\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled%201.png\"><img style=\"width:384px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled%201.png\" /></a></figure>",
				"a) (-2, -4), (3, 1),(0,6),(8, -7),(9, -3)",
				"b) (-9, -4), (6, 1),(8, 7),(5, -3),(8, -3)",
				"c) (-7, -4), (1, 1),(0, 4),(6, -4),(9, -3)",
				"d) (-2, -4), (3, 1),(1, 3),(9, -6),(9, -9)",
				"e) (-7, -4), (7, 1),(0, 2),(8, -7),(9, -2)",
				1,
				1,
				moduloService.findById(6).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) Quais pares ordenados estão representado no plano\r\n" + 
				"    cartesiano?\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled%202.png\"><img style=\"width:384px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled%202.png\" /></a></figure>",
				"a) (-8, 4),(8, 3),(7, -3),(-4, -3),(7, 0)",
				"b) (-9, 9),(8, 3),(6, -3),(-4, -4),(8, 6)",
				"c) (-8, 4),(8, 3),(0, -3),(-9, -9),(0, 0)",
				"d) (-9, 4),(8, 3),(0, -3),(-4, -9),(8,0)",
				"e) (-9, 5),(8, 3),(0, -3),(-5, -9),(6, 0)",
				1,
				1,
				moduloService.findById(6).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4) Em quais quadrantes estão localizados os ponto\r\n" + 
				"    respectivamente: (-2, -4),(3, 1),(0, 6),(8, -7),(9, -3)\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled%203.png\"><img style=\"width:384px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled%203.png\" /></a></figure>",
				"a) 3.° quadrante, 2.° quadrante,4.° quadrante,4.° quadrante,1.° quadrante.",
				"b) 2.° quadrante, 1.° quadrante,1.° quadrante,4.° quadrante,2.° quadrante.",
				"c) 4.° quadrante, 3.° quadrante,1.° quadrante,2.° quadrante,3.° quadrante.",
				"d) 1.° quadrante, 1.° quadrante,2.° quadrante,4.° quadrante,4.° quadrante.",
				"e) 3.° quadrante, 1.° quadrante,1.° quadrante,4.° quadrante,4.° quadrante.",
				1,
				1,
				moduloService.findById(6).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) O número natural (2103 + 2102 + 2101 – 2100) é\r\n" + 
				"    divisível por:",
				"a) 6",
				"b) 10",
				"c) 14",
				"d) 22",
				"e) 26",
				1,
				1,
				moduloService.findById(7).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2)Se a soma e a diferença entre dois números inteiros\r\n" + 
				"    são, respectivamente, iguais a 33 e 7, o produto desses números é :",
				"a) 400",
				"b) 260",
				"c) 13",
				"d) 20",
				"e) 169",
				1,
				1,
				moduloService.findById(7).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) XYZ4 e X4YZ representam dois números inteiros de\r\n" + 
				"    quatro algarismos. Se X4YZ excede XYZ4 em 288 unidades, então Z-Y é igual a:",
				"a) -3",
				"b) -1",
				"c) 1",
				"d) 3",
				"e) 5",
				1,
				1,
				moduloService.findById(7).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4)Pedro tirou menos de uma centena de fotos da festa\r\n" + 
				"    de comemoração ao seu aniversário e quer colocá-las todas num álbum de 20 páginas. Em cada página desse\r\n" + 
				"    álbum cabem, no máximo, 10 fotos. Inicialmente, Pedro tentou colocar 6 fotos em cada página. Ao final,\r\n" + 
				"    depois de preenchidas algumas páginas do álbum, ficou sobrando uma foto. Em nova tentativa, dispôs 7\r\n" + 
				"    fotos por página e ainda assim sobrou uma foto. Finalmente, Pedro conseguiu colocar todas as fotos, de\r\n" + 
				"    modo que cada página contivesse o mesmo número de fotos. Quantas páginas do álbum Pedro preencheu?",
				"a) 9",
				"b) 17",
				"c) 18",
				"d) 19",
				"e) 20",
				1,
				1,
				moduloService.findById(7).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) Qual alternativa representa a fração 9/2 em números decimais?",
				"a) 3,333 ",
				"b) 4,25 ",
				"c) 5,01",
				"d) 4,5",
				"e)5,7",
				1,
				1,
				moduloService.findById(8).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2) Qual alternativa representa a fração 35/1000 em números decimais?",
				"a) 0,35",
				"b) 3,5",
				"c) 0,035",
				"d) 35",
				"e) 45",
				1,
				1,
				moduloService.findById(8).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"3) Qual é a alternativa que representa o número 0,65 na forma de fração?",
				"a)65/10",
				"b) 65/100",
				"c)65/1000",
				"d) 65/10000",
				"e) 65/100000",
				1,
				1,
				moduloService.findById(8).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"4) Observe as frações e suas respectivas representações decimais.\r\n" + 
				"<p>I) 3/1000 = 0,003</p>\r\n" + 
				"<p>II) 2367/100 = 23,67</p>\r\n" + 
				"<p>III) 129/1000 = 0,129</p>\r\n" + 
				"<p>Utilizando as igualdades acima, escolha a alternativa correta?</p>\r\n",
				"a) I e II",
				"b) I e IV",
				"c) I, II e III",
				"d) I, II, III e IV ",
				"e) nenhuma das anteriores.",
				1,
				1,
				moduloService.findById(8).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"1) A Figura 1 representa uma gravura retangular com 8 m\r\n" + 
				"    de comprimento e 6 m de altura.\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled%204.png\"><img style=\"width:292px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled%204.png\" /></a></figure>\r\n" + 
				"<p>Deseja-se reproduzi-la numa folha de papel retangular\r\n" + 
				"    com 42 cm de comprimento e 30 cm de altura, deixando livres 3 cm em cada margem, conforme a Figura 2</p>\r\n" + 
				"<figure><a href=\"https://mundoeducacao.uol.com.br/upload/conteudo/folha-de-papel-retangular.JPG\"><img\r\n" + 
				"            style=\"width:432px\"\r\n" + 
				"            src=\"https://mundoeducacao.uol.com.br/upload/conteudo/folha-de-papel-retangular.JPG\" /></a>\r\n" + 
				"</figure>\r\n" + 
				"<p>A reprodução da gravura deve ocupar o máximo possível\r\n" + 
				"    da região disponível, mantendo-se as proporções da Figura 1.</p>\r\n" + 
				"<p>PRADO, A. C. Superinteressante, ed. 301, fev. 2012\r\n" + 
				"    (adaptado).</p>\r\n" + 
				"<p>A escala da gravura reproduzida na folha de papel é\r\n" + 
				"</p>\r\n",
				"a) 1 : 3",
				"b) 1 : 4",
				"c) 1 : 20",
				"d) 1 : 25",
				"e) 1 : 32",
				1,
				1,
				moduloService.findById(9).get()
		));

		createAtividadesIfNotExists(new Atividade(null,
				"2) Em um certo teatro, as poltronas são divididas em\r\n" + 
				"    setores. A figura apresenta a vista do setor 3 desse teatro, no qual as cadeiras escuras estão\r\n" + 
				"    reservadas e as claras não foram vendidas\r\n" + 
				"<!-- -->\r\n" + 
				"<figure><a href=\"http://localhost:8080/img/atividades/Untitled%205.png\"><img style=\"width:335px\"\r\n" + 
				"            src=\"http://localhost:8080/img/atividades/Untitled%205.png\" /></a></figure>\r\n" + 
				"<p>A razão que representa a quantidade de cadeiras\r\n" + 
				"    reservadas do setor 3 em relação ao total de cadeiras desse mesmo setor é</p>",
				"a) 17 70",
				"b) 17 53",
				"c) 53 70",
				"d) 53 17",
				"e) 70 17",
				1,
				1,
				moduloService.findById(9).get()
		));
		
	}

	private Atividade createAtividadesIfNotExists(Atividade newAtividade) {
		Optional<Atividade> atividade = service.findByAnswer(newAtividade.getAnswer());
		
		if(atividade.isPresent()) {
			return atividade.get();
		}
		
		return service.save(newAtividade);
	}
}
