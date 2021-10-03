package br.dev.mtparreira.estudos.exemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 * Exemplo de utilização da classe Input|Output Stream
 * Exemplo de utilização da classe Scanner com algumas funções de formatação
 * 
 * @author mtparreira
 *
 */
public class ArquivoConfiguracoes {
	
	/**
	 *  
	 * @throws IOException  (exceção ignorada)
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		// Criando
		OutputStream fos = new FileOutputStream("arquivos/estudos.conf");
		Writer osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("key,value"); 			bw.newLine();
		bw.write("linguagem,Java");		bw.newLine();
		bw.write("projeto,estudos");	bw.newLine();
		bw.write("autor,@mtparreira");  bw.newLine();
		bw.write("versao,1.0.0");
		bw.close();		
		
		// Acessando
		InputStream fis = new FileInputStream("arquivos/estudos.conf");
		Reader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		br.close();
		
		// Utilizando Scanner e formatação de String
		long processamento = System.currentTimeMillis();
		Scanner scn = new Scanner(new File("arquivos/estudos.conf"), "UTF-8");
		int contador = 0;
		scn.useDelimiter(",|\\s");
		System.out.println(System.lineSeparator() + " -------------------------------------------");
		while (scn.hasNext()) {
			String chave = scn.next();
			String valor = scn.next();
			if (contador > 0) {
				System.out.format(new Locale("pt","BR"), " | %03d | %15s | %15s | %n", contador, chave, valor);
			} else {
				System.out.format(new Locale("pt","BR"), " | POS | %15s | %15s | %n", chave.toUpperCase(), valor.toUpperCase());
				System.out.println(" -------------------------------------------");
			}
			contador++;
		}
		scn.close();
		System.out.println(" -------------------------------------------");
		System.out.println(" Quantidade de linhas: " + contador);
		processamento = System.currentTimeMillis() -  processamento;
		System.out.println(" Tempo de processamento Scanner: " + processamento + "ms");

	}

}
