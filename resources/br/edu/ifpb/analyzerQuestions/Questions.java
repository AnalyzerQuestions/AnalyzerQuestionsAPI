package br.edu.ifpb.analyzerQuestions;

public class Questions {

	/**
	 * t(x) - titulo da pergunta x
	 * d(x) - descrição da pergunta x
	 * x - número da pergunta de acordo a  <a href="https://docs.google.com/spreadsheets/d/1EWr6JmS6mA3iSdOlRbN6iyHHETZVm8cyOYHxf_witFs/edit#gid=1252856087">Tabela</a>
	 */
	
	public static String t1 = " Busca de numero em um Array";
	public static String d1 = "Galera bom dia,Seguinte aleatoriamente 1000 números utilizando um array bidimensional, depois preciso digitar um número e pesquisar se tem no array. Gerei os números, porém, não estou conseguindo fazer ele buscar corretamente. Mesmo que eu digite um número que foi gerado ele cai no else e informa que não foi encontrado o número:Segue o código: import javax.swing.JOptionPane; public class Exercicio3_cap5 { public static void main(String[] args) { int [] [] numeros = new int [50] [20]; for (int linha = 0; linha < 50; linha++){ for(int coluna = 0; coluna < 20; coluna++){ numeros [linha] [coluna] = (int) (Math.random() * 1000); System.out.println(numeros[linha][coluna]); } } int numDigitado = Integer.parseInt(JOptionPane.showInputDialog(Digite um número para pesquisar:)); String mensagem=; for(int[] busca: numeros){ if(busca.equals(numDigitado)){ mensagem = Número encontrado!; } else{ mensagem = Número não encontrado!; } } JOptionPane.showMessageDialog(null, mensagem); }}  Obrigado!";

}
