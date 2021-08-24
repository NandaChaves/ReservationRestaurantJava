/**
 * 
 */
package Restaurante;

public class Funcionario {
	private int id;
	private int senha;
	private Funcionario proxF;
	
	public Funcionario(int id,int senha) {
		this.id = id;
		this.senha= senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Funcionario getProxF() {
		return proxF;
	}

	public void setProxF(Funcionario proxF) {
		this.proxF = proxF;
	}

	@Override
	public String toString() {
		return "Funcionario " + id;
	}
	
}
