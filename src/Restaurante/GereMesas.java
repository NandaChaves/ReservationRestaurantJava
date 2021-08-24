package Restaurante;

import static java.lang.System.out;

public class GereMesas {
	private Mesa primM; 

	public void imprimeMesa() {
		Mesa temp =  primM;
		while (temp!=null) {
			System.out.println(temp);
			temp=temp.getProxMesa();
		}
	}
	public void addMesa(Mesa novaM) {
		Mesa temp = primM;
		if (existe(novaM.getId())==null) {
			if (primM==null) {
				primM = novaM;
			}
			else {novaM.setProxMesa(temp);
				  primM = novaM;}
		}
		else 
		out.println("Ja existe uma mesa com este id");
	}
	public void pesquisarMesa(int id) {  
		Mesa resu = existe(id);
		if(resu==null)
		out.println("Esta mesa não existe");
		else out.println("A mesa" + resu.getId() + " tem " + resu.getnLugares() + " lugares");
	} 
	public void elimina(int n)
	{	
		if (n==primM.getId()){
			primM = primM.getProxMesa();
			}
		else { // procurar a primeira ocorrencia do nï¿½
		Mesa temp=primM.getProxMesa();
	    Mesa antTemp= primM;
	    
		while (temp!=null && n!=temp.getId())
			{antTemp=temp;
			temp=temp.getProxMesa();}
		if (temp!=null) // quer dizer que encontrou um igual 
		{ 
			antTemp.setProxMesa(temp.getProxMesa());
		}
		else System.out.println("O numero " + n + " nao existe");
		} 
	}//fim de elimina

	public Mesa existe(int n)
	{  Mesa temp = primM;
	   while (temp!=null && n!=temp.getId())
			temp=temp.getProxMesa();
		return temp;
	}
}
