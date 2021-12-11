package backend_Java;

import java.util.Scanner;

public class BT11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hay nhap N: ");
		while(!sc.hasNextInt()) {
			System.out.println("Not an Integer, please try again: ");
			sc.next();
		}
		int N = sc.nextInt();
		double result = log2(N);
		double temp = Math.floor(result);
		System.out.println("So tu nhien lon nhat nho hon Log2 cua N la: " + temp);
		sc.close();
	}
	
    public static double log2(int N)
    {
  
        // calculate log2 N indirectly
        // using log() method
        double result = Math.log(N) / Math.log(2);
  
        return result;
    }

}
