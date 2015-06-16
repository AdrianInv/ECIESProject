
package com.webserver.security.ECIES;

import java.io.Serializable;
import java.math.BigInteger;
//import com.gts.Process.*;

public class Encryption implements Serializable
{
	DerIOBuffer der;
	int data1[];
        String salida;
        
	public Encryption()
	{
	}
	public Encryption(String check)
	{       salida = null;
		der = new DerIOBuffer();
                int[] ecies_ex = new int[90];
		if(!check.equalsIgnoreCase("Encryption"))
		{
                    ecies_ex = ecies_ex(check);
                    System.out.print(ecies_ex.toString());
		}
		else if(check.equalsIgnoreCase("Decryption"))
		{
			Decryption dec =new Decryption();
                        System.out.print("Prueba");
                        
                        salida = dec.decrypt(ecies_ex);
		}
                Decryption dec =new Decryption();
                salida = dec.decrypt(ecies_ex);
                System.out.print(salida);
	}

	public final int[] ecies_ex(String data)
	{
		
		ECDomainParameters dp = ECDomainParameters.NIST_B_163();

		ECPrivKey skA = new ECPrivKey(dp, BigInteger.valueOf(123));
		
		ECPubKey pkA = new ECPubKey(skA);

		ECPrivKey skB = new ECPrivKey(dp, BigInteger.valueOf(230));
		
		ECPubKey pkB = new ECPubKey(skB);

		String pt1 = data;
		
		ECIES crypt = new ECIES(skA, pkB, pt1.getBytes()); // encrypt the data
		
		data1 = DerIOBuffer.DER_Encode(crypt);
		
		return data1;

	}
	public static void main(String[] args)
	{
		Encryption e = new Encryption("askdlajsdlkajsdljakldsjakldjalkdjsakljdslajdlalsdkjlaskd");
                System.out.print(e.salida);

	}

}
