package backend_Java;

import java.util.Scanner;

public class BT15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hay nhap chuoi");
		String str = sc.nextLine();
		System.out.println("Type 1 de in ra do dai chuoi");
		System.out.println("Type 2 de in ra char tai 1 vi tri nhat dinh");
		System.out.println("Type 3 de kiem tra chuoi phu");
		System.out.println("Type exit de thoat");
		while(!sc.hasNext("exit")) {
			if(!sc.hasNextInt()) {
				System.out.println("Hay chon lai chuc nang");
				sc.next();
			}
			else {
				int function = sc.nextInt();
				switch (function) {
					case 1: {
						StrLen(str);
						break;
					}
					case 2: {
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Hay nhap index: ");
						while(true) {
							if(!sc2.hasNextInt()) {
								System.out.println("Index must be an Integer, please try again");
								sc2.next();
							}
							else {
								int tempIndx = sc2.nextInt();
								if(tempIndx < 0 || tempIndx > str.length()) {
									System.out.println("Index must be in range of 0 to " + (str.length() - 1));
								}
								else {
									CharIndx(str, tempIndx);
									break;
								}
							}
						}
						break;
					}
					case 3: {
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Hay nhap substring de kiem tra: ");
						String sub = sc2.nextLine();
						boolean check = subStrCheck(str, sub);
						if(check) {
							System.out.println("Chuoi phu thuoc chuoi chinh");
						}
						else {
							System.out.println("Chuoi phu khong nam trong chuoi chinh");
						}
						break;
					}
					default: {
						System.out.println("Hay chon lai chuc nang");
					}
				}
			}
			System.out.println("Hay chon chuc nang tiep theo, hoac nhan exit de thoat");
		}
	}
	
	public static void StrLen(String str) {
		System.out.println("Do dai cua chuoi la: " + str.length());
	}
	
	public static void CharIndx(String str, int pos) {
		System.out.println("Ki tu tai vi tri "+ pos+" la: "+Character.valueOf(str.charAt(pos)));
	}
	
	public static boolean subStrCheck(String str, String sub) {
		if(str.contains(sub)) {
			return true;
		}
		else {
			return false;
		}
	}

}
