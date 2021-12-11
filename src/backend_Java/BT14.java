package backend_Java;

import java.util.HashMap;
import java.util.Scanner;

public class BT14 {

	public static void main(String[] args) {
		HashMap<String,Integer> UniqueArray = new HashMap<String,Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hay nhap so phan tu");
		while(!sc.hasNextInt()) {
			System.out.println("Hay nhap 1 so tu nhien");
			sc.next();
		}
		int N = sc.nextInt();
		for(int i = 0; i < N; i ++) {
			System.out.println("Phan tu " + (i+1));
			String tempString = sc.next();
			UniqueArray.put(tempString, i);
		}
		System.out.println("Mang moi sau khi da xoa cac phan tu bi lap lai");
		for(String i : UniqueArray.keySet()) {
			System.out.println(i);
		}
	}

}
