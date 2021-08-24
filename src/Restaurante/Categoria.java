package Restaurante;
import static java.lang.System.out;
import java.util.Scanner;

public class Categoria {
	Scanner l = new Scanner(System.in);
	private int categoria;
	private Categoria proxC;
	private Prato primP = null;
	private Prato ult;
	
	public Categoria(int categoria)
	{   this.categoria = categoria;
	   
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Categoria getProxC() {
		return proxC;
	}
	public void setProxC(Categoria proxC) {
		this.proxC = proxC;
	}
	
	public void AddPrato(Prato novoP)
	{
	  if(primP==null)
	  {primP = novoP;  
	    ult = novoP;}
	  else {ult.setProxP(novoP);
		   ult = novoP;
		}
	  
     }//fim de addPrato
		
	public void imprimir()
	{
		Prato tempP = primP;
		while(tempP!=null)
		{
			out.println();
			out.println(tempP.getNome());
			out.println(tempP.getPreco());
			out.println();	
			tempP= tempP.getProxP();
		}
	}
	
	public void eliminarP(String prato)
	{
		if (prato.equalsIgnoreCase(primP.getNome())){
			primP = primP.getProxP();
			 if (primP==null)
				 ult =null;
			}
		else { 
		Prato temp=primP.getProxP();
	    Prato antTemp= primP;
	    
		while (temp!=null && prato.equalsIgnoreCase(temp.getNome()))
			{
			antTemp=temp;
			temp=temp.getProxP();}
		if (temp!=null)
		{ 
			antTemp.setProxP(temp.getProxP());
		}
		else System.out.println("Este prato nao existe");
		} 
	} 
	
}
