package Restaurante;

public class Cliente {
	private String nome;
	private String telefone;
	private Reserva recentR;
	private Cliente proxC;
	
	public void listarReservas()
	{
		System.out.println(this.toString());
		if(isEmpty()) {
			System.out.println("Nao tem reservas");
		}
		else {
			Reserva temp = recentR;
			while(temp.getProxRCliente()!=null)
			{
				System.out.println(temp);
				temp = temp.getProxRCliente();
			}
			System.out.println(temp);
		}
	}
	
	public void adicionarReserva(Reserva reserva)
	{
		if(isEmpty()) {
			recentR = reserva;
		}
		else {
			reserva.setProxRCliente(recentR);
			recentR = reserva;
		}
	}
	
	public boolean isEmpty() {
		if(recentR == null) return true;
		return false;
	}
	
	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Reserva getRecentR() {
		return recentR;
	}

	public void setRecentR(Reserva recentR) {
		this.recentR = recentR;
	}

	public Cliente getProxC() {
		return proxC;
	}

	public void setProxC(Cliente proxC) {
		this.proxC = proxC;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + "]";
	}
	
	
}
