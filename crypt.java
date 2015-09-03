import java.lang.*;
public class crypt {
public static void main(String args[])
{
	long p =24852977;//varibles
	long g = 2744;
	long sum = 8414508;
	long c1 = 15268076;
	long c2 = 743675;
	long temp =g;
	long power=1;
	
	
	while(temp!=sum)
	{
		power++;
		temp=modMult(temp, g, p);
		if(temp>p)
		{
			temp %= p;
		}
		
	}
	
	System.out.println("The power is "+power);
	long key=power;
	long div=modpow(c1, p-1-key, p);
	long message= modMult(div, c2, p);
	System.out.println("The value is "+message);
	
}

 public static long modpow(long number, long power, long modulus)
 {
	 if(power==0)
	 {
		 return 1;
	 }
	 else if (power%2==0)
	 {
		 long halfpower=modpow(number,power/2, modulus);
		 return modMult(halfpower, halfpower, modulus);
	 }
	 else
	 {
		 long halfpower=modpow(number, power/2, modulus);
		 long firstbit=modMult(halfpower,halfpower,modulus);
		 return modMult(firstbit, number, modulus);
	 }
 }
 public static long modMult(long first, long second, long modulus)
 {
	 if(second==0)
	 {
		 return 0;
	 }
	 else if (second%2==0)
	 {
		 long half=modMult(first, second/2, modulus);
		 return (half+half)%modulus;
	 }
	 else
	 {
		 long half=modMult(first, second/2, modulus);
		 return (half+half+first)%modulus;
	 }
 }
}
