package Restaurante;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
	public static void menu(){
		
		out.println("Escolha uma das opções abaixo");
	    out.println("0-Sair");
	    out.println("1-Fazer reserva");
	    out.println("2-Procurar reserva por cliente");
	    out.println("3-Imprimir todas as reservas");  
	    out.println("4-Ver reserva de uma dada data");
	    out.println("5-Ver todos os cliente");
	    out.println("6-Alterar estado da reserva");
	    out.println("7-Procurar cliente");
	    out.println("8-Adicionar mesa");
	    out.println("9-Eliminar mesa");
	    out.println("10-Procurar mesa"); 
	    out.println("11-Ver todas as mesas");
	    out.println("12-Inserir funcionario");
        out.println("13-Inserir prato");
	    out.println("14-Imprimir pratos por categoria");
	    out.println("15-Eliminar prato");
	}
	public static void main(String[] args) {
		
		 Scanner ler = new Scanner(System.in);
		 Scanner l = new Scanner(System.in);
	     GereReserva gr =  new GereReserva();
	     GereCliente gc = new GereCliente();
	     GereMesas m = new GereMesas();
	     GereReserva r =  new GereReserva();
	     GereRest lst = new GereRest();
	     Categoria cat = new Categoria(1);
	          
	     lst.addCategoria(cat);
	     cat = new Categoria(2);
	     lst.addCategoria(cat);
	     cat = new Categoria(3);
	     lst.addCategoria(cat);
	     cat = new Categoria(4);
	     lst.addCategoria(cat);
	     cat = new Categoria(5);
	     lst.addCategoria(cat);
	     cat = new Categoria(6);
	     lst.addCategoria(cat);
	     
	     Mesa novaM = new Mesa(1,3);
	     m.addMesa(novaM);
	     novaM = new Mesa(2,2);
	     m.addMesa(novaM);
	     novaM = new Mesa(3,4);
	     m.addMesa(novaM);
	     novaM = new Mesa(4,5);
	     m.addMesa(novaM);
	     novaM = new Mesa(5,5);
	     m.addMesa(novaM);
	     
	     Funcionario f = new Funcionario(1,1);
	     lst.AddFunRest(f);
	     f = new Funcionario(2,2);
	     lst.AddFunRest(f);
	     
	      int contadorReservasID = 0;
	      int key = -1;
	      while(key == -1) {
	      out.println("Faça o login");
    	  out.println("Qual o id do funcionario?");
    	  int id = ler.nextInt();
    	  out.println("Qual a senha?");
    	  int senha = ler.nextInt();
		  Funcionario valid = lst.pesquisarF(id,senha);
		  if(valid==null)
			  out.println("Funcionario inválido");
		  else
			  key = 1;}
		 menu();
		 int op = ler.nextInt();
		 while(op!=0){
				  switch(op)
				  {
				  case 1: //FAZER RESERVA
					  out.println("Nome do cliente?");
					  String nome = ler.next();
					  out.println("Número de contacto?");
					  String num = ler.next();
					  out.println("Qual a data?");    	    
					  String data = ler.next();
					  out.println("Qual a hora");
					  String hora = ler.next();
					  out.println("Qual o nº de pessoas?");
					  int pessoas = ler.nextInt();
					  String estado = "Marcada";
					  contadorReservasID++;
				
				Reserva novaR = new Reserva(nome,contadorReservasID,data,hora,pessoas,estado); //Cria a reserva
				Cliente cliente = gc.pesquisarCliente(num); //Verifica se o cliente ja existe ou nao
				
				if(cliente!=null) { //Cliente ja existe
					System.out.println("Cliente com mesmo telemóvel ja existe:");
					System.out.println(cliente.toString());
				}
				else { //Cliente ainda nao existe
					cliente = gc.addCliente(nome, num);
					System.out.println("Cliente novo:");
					System.out.println(cliente.toString());	
				}
				
				//Adiciona reserva ao Cliente e ao GereReserva
				cliente.adicionarReserva(novaR);
				gr.adicionarReserva(novaR);			
	    		break;
	    	 case 2: //LISTAR RESERVAS DE UM CLIENTE
	    		 	out.println("Qual o telemóvel do cliente?");
					String num1 = ler.next();
					cliente = gc.pesquisarCliente(num1);
					cliente.listarReservas();
		    		break;
	    	 case 3://IMPRIMIR TODAS RESERVAS
	    		 	gr.listarReservas();
		    		break;
	    	 case 4:
	    		 	out.println("Qual a data?");    	    
					String data1 = ler.next();
					gr.listarReservas(data1);
		    		break;
	    	 case 5:
		    		gc.printAllClientes();
		    		break;
	    	 case 6:
	    		 	gr.listarReservas();
		    		out.println("ID da reserva?");
		    		int id = ler.nextInt();
		    		Reserva reserva = gr.procurarReserva(id);
		    		if(reserva == null) System.out.println("Reserva nao existe");
		    		else
		    		{
		    			System.out.println(reserva);
		    			out.println("Modificar o estado de reserva:");
		    			out.println("1)Marcada, 2)Cancelada, 3)Efetuada");
			    		int escolha = ler.nextInt();
			    		if(escolha==1) reserva.setEstado("Marcada");
			    		else if (escolha==2) reserva.setEstado("Cancelada");
			    		else reserva.setEstado("Efetuada");
		    		}
		    		break;
	    	 case 7:
	    		 	out.println("Qual o número?");    	    
					String num2 = ler.next();
					cliente = gc.pesquisarCliente(num2);
					if(cliente==null) System.out.println("Cliente nao existe");
					System.out.println(cliente);
	    		 	break;
	    	case 8:
	    		//Adicionar mesa
	        	  out.println("Digite o id da mesa:");
	        	  id = ler.nextInt();
	        	  out.println("Digite o numero de lugares");
	        	  int nlugares = ler.nextInt();
	        	  novaM = new Mesa(id, nlugares);
	        	  m.addMesa(novaM);
	        	  break;
	    	case 9:
	    		 //Eliminar mesa
	        	 out.println("Digite o id da mesa:");
	        	 id = ler.nextInt();
	        	 m.elimina(id);
	        	 break;
	    	case 10:
	    		//Procurar mesa
	        	 out.println("Digite o id da mesa:");
	        	 id = ler.nextInt();
	        	 m.pesquisarMesa(id);
	        	 break;
	    	case 11:
	    		 m.imprimeMesa();
	        	 break;
	    	case 12:
	    		  out.println("Qual o id?");
	          	  int idF = ler.nextInt();
	          	  out.println("Qual a senha?");
	          	  int password = ler.nextInt();
	          	  f = new Funcionario(idF,password);
	          	  lst.AddFunRest(f);
	          	  break;
	    	case 13:
	    		 out.println("Qual a categoria?");
	              out.println("1-Entrada");
	              out.println("2-Risoto");
	              out.println("3-Pizza");
	              out.println("4-Sushi");
	              out.println("5-Bebida");
	              out.println("6-Sobremesa");
	              
	           	  int cate = ler.nextInt();
	           	  lst.AddPratoCat(cate);  
	           	  break; 
	    	case 14:
	    		  out.println("Qual a categoria?");
	              out.println("1-Entrada");
	              out.println("2-carne");
	              out.println("3-Pizza");
	              out.println("4-Sushi");
	              out.println("5-Bebida");
	              out.println("6-Sobremesa");
	           	  cate = ler.nextInt();
	           	  lst.imprimirPratoCat(cate);
	           	  break;
	    	case 15:
	              out.println("Qual a categoria do prato que deja eliminar? ");
	              out.println("1-Entrada");
	              out.println("2-carne");
	              out.println("3-Pizza");
	              out.println("4-Sushi");
	              out.println("5-Bebida");
	              out.println("6-Sobremesa");
	              cate = ler.nextInt();
	              out.println("Qual o nome do prato que deseja eliminar?");
	              nome = ler.next();
	              lst.eliminarP(cate,nome);
	              break; 
	    	 }
	    	menu();
	 	    op = ler.nextInt();
	     }
	}

}
