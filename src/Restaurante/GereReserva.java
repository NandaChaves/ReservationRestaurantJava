package Restaurante;

public class GereReserva {
	
	private Reserva primRes;
	private Reserva ultRes;
	
	public Reserva procurarReserva(int id)
	{
		if(isEmpty()) //Se nao existirem reservas
		{
			return null;
		} 
		else { //Se existirem reservas vai procura
			Reserva temp = primRes;
			while(temp != null && temp.getId()!=id)
			{
				temp = temp.getProxR();
			}
			if(temp==null) return null;
			else return temp;
		}
	}
	
	public void adicionarReserva(Reserva novaRes) {
		if(isEmpty()) //Se nao existirem reservas
		{
			primRes = novaRes;
			ultRes = novaRes;
		} 
		else { //Se existirem reservas adiciona ao fim da lista
			ultRes.setProxR(novaRes);
			ultRes = novaRes;
		}
	}
	
	public void listarReservas()
	{
		if(isEmpty()) //Se nao existirem reservas
		{
			System.out.println("Nao ha reservas");
		}
		else {
			Reserva temp = primRes;
			while(temp != null)
			{
				System.out.println(temp);
				temp = temp.getProxR();
			}	
		}
		
	}
	
	public void listarReservas(String data)
	{
		if(isEmpty()) //Se nao existirem reservas
		{
			System.out.println("Nao ha reservas");
		}
		else {
			Reserva temp = primRes;
			while(temp != null)
			{
				if(temp.getData().compareToIgnoreCase(data)==0)
					System.out.println(temp);
				temp = temp.getProxR();
			}	
		}
	}
	
	public boolean isEmpty() {
		if(primRes == null && ultRes== null) return true;
		return false;
	}

}
