package com.webserver.util;

import java.util.Random;

public class GeneradorPrimoAleatorio {
	private long valor;

	public GeneradorPrimoAleatorio(){
	           this.valor=0;
	}

    public void setValor(int valor) {
	         this.valor = valor;
	}
    
    public long PrimoAleatorio(){
    	       
          for(int i=1; i<=10; i++){
         
          long num = (long)(Math.random()*(999999999-100000000+1)+99999999); 
          this.valor = num;
          if(VerificarSiEsPrimo())

               System.out.println("es un numero primo:  " + num);
          else
               System.out.println("no es numero primo:  " + num);
          }
    	return valor;
    }
    
    
	public boolean VerificarSiEsPrimo(){
	    int cont=0;
	    for (int p=1; p<=this.valor; p++)
	    {

	        if (this.valor % p ==0)
	            cont++;
	    }
	    if (cont<=2)
	        return true;
	    else
	        return false;
	}
	
	
}
