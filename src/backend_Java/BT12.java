package backend_Java;

import java.util.Scanner;

public class BT12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hay nhap so tu nhien N tu 1-9 : ");
		int temp = 0;
		while(true) {
			if(!sc.hasNextInt()) {
				System.out.println("Not an Integer, please try again");
				sc.next();
			}
			else{
				temp = sc.nextInt();
				if(temp < 1 || temp > 9) {
					System.out.println("N must be in range of 1-9, please try again");
				}
				else {
					break;
				}
			}
			
		}
		
		for(int i = 1; i <= temp; i ++) {
			for(int j = 1; j <= i; j ++) {
				System.out.print(j);
			}
			System.out.println();
		}
		sc.close();
	}

}
