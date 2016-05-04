package br.edu.ifpb.analyzerQuestions.util;

public class Questions {

	/**
	 * t(x) - titulo da pergunta x
	 * d(x) - descrição da pergunta x
	 * x - número da pergunta de acordo a  <a href="https://docs.google.com/spreadsheets/d/1EWr6JmS6mA3iSdOlRbN6iyHHETZVm8cyOYHxf_witFs/edit#gid=1252856087">Tabela</a>
	 */
	
	public static String t1 = " Busca de numero em um Array";
	public static String d1 = "Galera bom dia,Seguinte aleatoriamente 1000 números utilizando um array bidimensional, depois preciso digitar um número e pesquisar se tem no array. Gerei os números, porém, não estou conseguindo fazer ele buscar corretamente. Mesmo que eu digite um número que foi gerado ele cai no else e informa que não foi encontrado o número:Segue o código: import javax.swing.JOptionPane; public class Exercicio3_cap5 { public static void main(String[] args) { int [] [] numeros = new int [50] [20]; for (int linha = 0; linha < 50; linha++){ for(int coluna = 0; coluna < 20; coluna++){ numeros [linha] [coluna] = (int) (Math.random() * 1000); System.out.println(numeros[linha][coluna]); } } int numDigitado = Integer.parseInt(JOptionPane.showInputDialog(Digite um número para pesquisar:)); String mensagem=; for(int[] busca: numeros){ if(busca.equals(numDigitado)){ mensagem = Número encontrado!; } else{ mensagem = Número não encontrado!; } } JOptionPane.showMessageDialog(null, mensagem); }}  Obrigado!";
	
	public static String t2 = " Busca de numero em um Array";
	public static String d2 = "Olá pessoal, boa noite! Sou novo em Java, comecei a aprendê-la nessa semana. Fiz um programa simples que calcula o fatorial de um número: import java.util.Scanner; class fatorial{ public static void main(String[] args){Scanner ler = new Scanner(System.in); System.out.printf(Você quer calcular o fatorial de que número maior que zero?\n); int num = ler.nextInt(); int fat = 1; for(int n = 1; n <= num; n++){ fat = fat*n;} System.out.printf(O fatorial de %d é %d\n, num, fat); } Quando calculo o fatorial de 20, obtenho o número negativo -2102132736. Mudei de int para long e assim consegui o resultado certo. Mas aí quando eu quis obter o fatorial de 50, também obtive um número negativo. Escrevi então um pequeno código em python para calcular fatorial, o que não me apresentou números negativos. Assim, cheguei a conclusão que isso se deve a algum aspecto de Java que eu desconheço. Algum de vocês poderia me ajudar?";

}
