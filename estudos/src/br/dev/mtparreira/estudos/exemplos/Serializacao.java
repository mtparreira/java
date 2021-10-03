package br.dev.mtparreira.estudos.exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * Exemplo de utilização de Serialização
 * Exemplo de classes declaradas dentro de uma classe principal (não usual/recomendado)
 * 
 * @author mtparreira
 *
 */
public class Serializacao {

	/**
	 *  
	 * @throws FileNotFoundException, IOException, ClassNotFoundException (exceções ignoradas)
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Usuario usr = new Usuario ("Parreira", "123.456.789-10", "mtparreira", "Xpto@123", "ID1976");		
		System.out.println(usr);

		// Serialização
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("arquivos/srz_usuario.bin"));
        oos.writeObject(usr);
        oos.close();
        
        // Desserialização
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("arquivos/srz_usuario.bin"));
        usr = (Usuario) ois.readObject();
        ois.close();
        
        System.out.println(usr);

	}

}

/**
 * 
 * Implementa Serializable
 * 
 * @author mtparreira
 *
 */
class Usuario implements Serializable {

	/**
	 * 
	 *  serialVersionUID não é obrigatório e serve para validação da versão da classe
	 *  se não for informado o Java cria um valor para referência e pode disparar exceções na validação
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String login, nome;
	private transient String senha; // valor descartado na serialização
	private Identificacao id = new Identificacao();
	
	public Usuario(final String nome, final String cpf, final String login, final String senha, final String cracha) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.id.setCpf(cpf);
		this.id.setCracha(cracha);
	}

	public String getLogin() {
		return this.login;		
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return ("Nome: " + this.nome + System.lineSeparator()
			  + "Login: " + this.login + " Senha: " + this.senha + System.lineSeparator()
			  + "CPF: " + this.id.getCpf() + " Cracha: " + this.id.getCracha() + System.lineSeparator());
	}
	
}

/**
 * 
 * Para a serialização funcionar as intâncias que compoem o objeto a ser serializado precisam implementar a interface Serializable
 * Por exemplo, se retirar o implements da classe Identificacao a exceção java.io.NotSerializableException é disparada
 * O mesmo é válido para herança e as instancias sob controle do Java (ex.: String) que já implentam a interface
 * 
 * @author mtparreira
 *
 */
class Identificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cracha, cpf;
	
	public Identificacao() {
		
	}
	
	public Identificacao(final String cracha, final String cpf) {
		this.setCracha(cracha);
		this.setCpf(cpf);
	}

	public String getCracha() {
		return this.cracha;
	}

	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
}
