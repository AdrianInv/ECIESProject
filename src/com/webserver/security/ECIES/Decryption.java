

package com.webserver.security.ECIES;

import java.io.*;
import java.math.BigInteger;
 
 
//import com.gts.Process.*;

public class Decryption implements Serializable
{
	ECPrivKey skB;
	ECIES crypt;
	DerIOBuffer der;
	ECIES crypted1;
	int[] crypted;
	public Decryption()
	{

	}

	public String decrypt(int[] crypt)
	{
	String decrypteddata="";
	//int a[]=(int [])crypt;

		try {
			//System.out.println("IN DEC"+crypt);
			//crypted1=(DerIOBuffer)crypt;
			ECDomainParameters dp = ECDomainParameters.NIST_B_163();
			ECPrivKey skB = new ECPrivKey(dp, BigInteger.valueOf(230));
 			ECPubKey pkB = new ECPubKey(skB);
 			der=new DerIOBuffer();
			ECIES decrypt = der.toECIES(crypt);
			//System.out.print("(2)Cipher Text: ");
			//System.out.println(decrypt.toString());
			byte[] pt2 = decrypt.decrypt(skB); // decrypt the data
			//System.out.print("(3)Plain Text: ");
			//System.out.println(new String(pt2));
			decrypteddata= new String(pt2);
			//System.out.println(decrypteddata);


			}
		catch (Exception e)
			{
				e.printStackTrace();
			}
		return decrypteddata;
	}
}




