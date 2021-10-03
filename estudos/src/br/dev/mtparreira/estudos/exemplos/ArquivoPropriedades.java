package br.dev.mtparreira.estudos.exemplos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * Exemplo de utilização da classe Properties
 * 
 * @author mtparreira
 *
 */
public class ArquivoPropriedades {

	/**
	 *  
	 * @throws IOException (exceção tratada)
	 * 
	 */
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			// Criando
			prop.setProperty("autor", "@mtparreira");
			prop.setProperty("sobrenome", "Parreira");
			prop.setProperty("profissao", "desenvolvedor");
			prop.setProperty("aplicacao", "Estudos");
			prop.setProperty("linguagem", "Java");		
			prop.setProperty("versao", "1.0.0");
			prop.store(new FileWriter("arquivos/estudos.prop"), "Exemplo de uso de arquivo de propriedades");
					
			// Acessando
			prop.load(new FileReader("arquivos/estudos.prop"));		
			System.out.println(prop.getProperty("linguagem"));
			System.out.println(prop.getProperty("aplicacao"));
			System.out.println(prop.getProperty("autor"));
			System.out.println(prop.getProperty("versao"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
