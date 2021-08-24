package Restaurante;

public class GereCliente {
	
	private Cliente primCli;
	private Cliente ultCli;
	
	public void printAllClientes()
	{
		if(isEmpty()) System.out.println("Nao existem clientes");
		else {
			Cliente temp = primCli;
			while(temp!=null)
			{
				System.out.println(temp.toString());
				temp = temp.getProxC();
			}
		}
	}
	
	public Cliente addCliente(String nome,String cont)
	{
		Cliente novoCliente = new Cliente(nome, cont); 
		if(isEmpty()) { //Ainda nao existem clientes
			primCli = novoCliente;
			ultCli = novoCliente;
		}
		else{ //Ja existem clientes, vamos adicionar o cliente por ordem alfabetica
			
			if(ultCli.getNome().compareToIgnoreCase(nome)<0) //Cliente vai ser adicionado ao fim da lista. Exemplo: Ze
			{
				ultCli.setProxC(novoCliente);
				ultCli = novoCliente;
			}
			else if(primCli.getNome().compareToIgnoreCase(nome)>0) //Cliente vai ser adicionado ao inicio da lista. Exemplo: Ana
			{
				novoCliente.setProxC(primCli);
				primCli = novoCliente;
			}
			else //Cliente vai ser adicionado no meio da lista. Exemplo: Hugo
			{
				Cliente temp = primCli;
				
				while(nome.compareTo(temp.getProxC().getNome())>0)
				{
					temp = temp.getProxC();
				}
				
				novoCliente.setProxC(temp.getProxC());
				temp.setProxC(novoCliente);
			}
			
		}
		return novoCliente;
	}

	public Cliente pesquisarCliente(String num) {
		
		if(isEmpty()) return null; //Se nao existirem clientes
		else {
			Cliente temp = primCli;
			while((temp!=null) && (!temp.getTelefone().equals(num))){
				temp = temp.getProxC();
			}			
			if(temp==null) return null; //Cliente nao existe
			else return temp; //Cliente existe
		}
	}
	
	public boolean isEmpty() {
		if(primCli == null) return true;
		return false;
	}
	
	public Cliente getPrimCli() {
		return primCli;
	}

	public void setPrimCli(Cliente primCli) {
		this.primCli = primCli;
	}


}
