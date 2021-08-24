package Restaurante;

public class Reserva {
	private String nome;
	private int id;
	private String data;
	private String hora;
	private int nPessoas;
	private String estado;
	public Reserva proxR;
	public Reserva proxRCliente;
	
	public Reserva(String nome,int id, String data, String hora, int nPessoas, String estado) {
		this.nome= nome;
		this.id = id;
		this.data=data;
		this.hora = hora;
		this.nPessoas = nPessoas;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getnPessoas() {
		return nPessoas;
	}

	public void setnPessoas(int nPessoas) {
		this.nPessoas = nPessoas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Reserva getProxR() {
		return proxR;
	}

	public void setProxR(Reserva proxR) {
		this.proxR = proxR;
	}

	public Reserva getProxRCliente() {
		return proxRCliente;
	}

	public void setProxRCliente(Reserva proxRCliente) {
		this.proxRCliente = proxRCliente;
	}

	@Override
	public String toString() {
		return "Reserva [Nome="+nome +"ID="+ id +" data=" + data + ", hora=" + hora + ", nPessoas=" + nPessoas + ", estado=" + estado + "]";
	}
	
	
}
