import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Two large prime numbers n & p
		int n,p,q,e = 0,m,c,d = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two large prime numbers");
		p = sc.nextInt();
		q = sc.nextInt();
		n = p*q;
		
		//Find e less than n that is co-prime with (p-1)(q-1)
		for(int i=2;i<n;i++) {
			// if gcd of two numbers is 1, then the two numbers are co-prime 
			if(gcd(i,(p-1)*(q-1)) == 1) {
				e=i;
				break;
			}
		}
		
		int i=1;
		//Find d such that d = k(phi(n)+1/e  for k belongs to an integer
		while(true) {
		  if((((p-1)*(q-1))*i+1)%e == 0) {
			  d = (((p-1)*(q-1))*i+1)/e;
			  break;
		  }
		  i++;
		}
		
		System.out.println("Public Key (e,n) (" + e + "," + n + ")" );
		System.out.println("Private Key (d,n) (" + d + "," + n + ")" );
		
		System.out.println("Enter the message (Integer value only)");
		m = sc.nextInt();
		sc.close();
		
		//Encypt the message c = m^e mod n
		c = encrypt(m, e, n);
		System.out.println("Ciphertext c= " + c);
		
		//decrypt the cipher text m=c^d mod n
		m = decrypt(c, d, n);
		System.out.println("Message m= " + m);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
	
	public static int encrypt(int m,int e,int n) {
		return calcModulus(m, e, n);
	}
	
	public static int decrypt(int c,int d, int n) {
		return calcModulus(c, d, n);
	}
	
	public static int calcModulus(int m,int e, int n) {
		int quotient = e/2;
		int remainder = e%2;
		int product = 1;
		for(int i=1;i<=quotient;i++) {
			product = (int)(product*(Math.pow((double)m%n,2))%n);
		}
		product = product%n;
		if(remainder !=0) {
			product = (product*(m%n)%n)%n;
		}
		return product%n;
	}
}