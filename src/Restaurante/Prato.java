package Restaurante;
public class Prato {

	private String nome;
	private float  preco;
	private Prato proxN;
	private Prato proxP;
	public Prato(String no,float preco) {
		// TODO Auto-generated constructor stub
		 nome =no;
		 this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Prato getProxN() {
		return proxN;
	}

	public void setProxN(Prato proxN) {
		this.proxN = proxN;
	}

	public Prato getProxP() {
		return proxP;
	}

	public void setProxP(Prato proxP) {
		this.proxP = proxP;
	}

    
	
	

}
