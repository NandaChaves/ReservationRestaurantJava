package Restaurante;

import static java.lang.System.out;

import java.util.Scanner;

public class GereRest {
  Scanner s = new Scanner(System.in);	
  private Categoria primC;
  private Funcionario primF;
  private Funcionario ultF;
  
  public GereRest() {
	  primF = null;
	  primC=null;

  }//fim da instancia
	Categoria fim=null;
    /**Categoria**/
  public void addCategoria(Categoria novoC)
  {
      if(primC==null)
	  {   primC = novoC;
	      fim = novoC;
	      novoC.setProxC(null);}
	      else {
	    	  fim.setProxC(novoC);
	    	  novoC.setProxC(null);
	    	  fim = novoC;
	      }      
  }//fim de addCat
	
  public Categoria pesquisarC(int busca)
  {
	  Categoria tempC = primC;
	  while((tempC!=null) &&(tempC.getCategoria()!=busca))
	  {tempC = tempC.getProxC();}
	  if(tempC ==null)
		  return null;
	  else return tempC;	 
  }//fim do pesquisarC
  
      /*************Funcionario**************/
  public Funcionario pesquisarF(int id,int senha)
  {  Funcionario tempF = primF;
	 while((tempF!=null)&&(tempF.getId()!=id)&&(tempF.getSenha()!=senha))
	 {tempF = tempF.getProxF();}
	 if(tempF==null)
		 return null;
	 else return tempF;
  }//fim de addFun
  
  public void AddFunRest(Funcionario novoF)
  {
	  if(primF==null)
	  {   primF =  novoF;
		  ultF = novoF;
	  }else {
		  ultF.setProxF(novoF);
		  ultF = novoF;}
  }//addFunRest
	
  public void imprimirFun()
  {
	  Funcionario temp = primF;
	  while(temp!=null)
	  {
		  System.out.println("Id:"+ temp.getId());
		  temp = temp.getProxF();
	  }  
  }//imprimirFun
  
  /******************Prato**********************/
  public void AddPratoCat(int cat)
	{ 
		  Categoria resu = pesquisarC(cat);
			if(resu==null)
				 out.println("Esta categoria nï¿½o existe");
			else {
				out.println("Nome do prato?");
				String name = s.next();

				out.println("E o preço?");
				float prc = s.nextFloat();
				Prato novoP = new Prato(name,prc);
				resu.AddPrato(novoP); 
	    }//fim do else1	
	}//fim do AddPratoCat

  
  	public void imprimirPratoCat(int cat)
  	{   
	  Categoria result = pesquisarC(cat);
	  if(result == null)
		  out.println("Esta categoria não existe");
	  else {
		  //imprimir os pratos desta categoria
		  result.imprimir();
	}
  		}//fim de imprirmirPratoCat
  
  	public void eliminarP(int categoria,String prato)
 	{
 	  Categoria resu = pesquisarC(categoria);
 	  if(resu!=null) {
 		  resu.eliminarP(prato);
 	  }
 	  else {
 		  out.println("Categoria ou prato não existe");
 	  }
 	}
	
}//fim de GereEmenta
