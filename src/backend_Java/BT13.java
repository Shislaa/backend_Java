package backend_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BT13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hay nhap so phan tu:");
		while(!sc.hasNextInt()) {
			System.out.println("Phai la so nguyen, please try again");
			sc.next();
		}
		int N = sc.nextInt();
		System.out.println("Hay nhap tung phan tu: ");
		int[] nArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			while(true) {
				System.out.println("Phan tu "+( i + 1)+": ");
				if(!sc.hasNextInt()) {
					System.out.println("Phai la so nguyen, please try again");
					sc.next();
				}
				else {
					nArr[i] = sc.nextInt();
					break;
				}
			}
		}
		System.out.println("Type 1 for Gia Tri Trung Binh ");
		System.out.println("Type 2 for Phan tu lon nhat, nho nhat");
		System.out.println("Type 3 for Phan tu am lon nhat, nho nhat");
		System.out.println("Type 4 for Phan tu duong lon nhat, nho nhat");
		System.out.println("Type 5 for Phan tu Chan, Le");
		System.out.println("Type 6 for add 1 phan tu theo index");
		System.out.println("Type 7 for xoa 1 phan tu theo index");
		System.out.println("Type exit de thoat");
		
		while(!sc.hasNext("exit")) {
			if(!sc.hasNextInt()) {
				System.out.println("Please choose the function by number, or type exit: ");
				sc.next();
			}
			else {
				int function = sc.nextInt();
				switch (function) {
					case 1 :{
						System.out.println("Gia Tri Trung Binh cua mang la: " + AVG(nArr));
						break;
					}
					case 2: {
						System.out.println("Phan tu lon nhat : " + MaxMin(nArr,0) + " va be nhat la: " +MaxMin(nArr,1));
						break;
					}
					case 3 :{
						int[] MinMaxNeg = PosNeg(nArr,1);
						System.out.println("Phan tu am lon nhat : " + MaxMin(MinMaxNeg,0) + " va be nhat la: " +MaxMin(MinMaxNeg,1));
						break;
					}
					case 4 :{
						int[] MinMaxPos = PosNeg(nArr, 0);
						System.out.println("Phan tu duong lon nhat : " + MaxMin(MinMaxPos,0) + " va be nhat la: " +MaxMin(MinMaxPos,1));
						break;
					}
					case 5 :{
						OddEven(nArr);
						break;
					}
					case 6:{
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Hay nhap index: ");
						while(true) {
							if(!sc2.hasNextInt()) {
								System.out.println("Index must be an Integer, please try again");
								sc2.next();
							}
							else {
								int tempIndx = sc2.nextInt();
								if(tempIndx < 0 || tempIndx > nArr.length) {
									System.out.println("Index must be in range of 0 to " + nArr.length);
								}
								else {
									System.out.println("Hay nhap value cho index");
									while(!sc2.hasNextInt()) {
										System.out.println("Value phai la so tu nhien");
									}
									int value = sc2.nextInt();
									
									nArr = Add(nArr, value, tempIndx);
									break;
								}
							}
						}
						break;
					}
					case 7: {
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Hay nhap index: ");
						while(true) {
							if(!sc2.hasNextInt()) {
								System.out.println("Index must be an Integer, please try again");
								sc2.next();
							}
							else {
								int tempIndx = sc2.nextInt();
								if(tempIndx < 0 || tempIndx > nArr.length) {
									System.out.println("Index must be in range of 0 to " + (nArr.length - 1));
								}
								else {
									System.out.println("Phan tu :" + nArr[tempIndx] + " voi index: " + tempIndx+" da duoc xoa");
									nArr = Remove(nArr, tempIndx);
									break;
								}
							}
						}
						break;
					}
					default: {
						System.out.println("Vui long chon lai chuc nang");
					}
					
				}
					
			}
			System.out.println("Hay chon chuc nang tiep theo, hoac nhan exit de thoat");
		}
		
		
		
		
		
	}
	
	public static double AVG(int[] nArr) {
		double avg = 0;
		for(int i : nArr) {
			avg += i;
		}
		return avg = avg/nArr.length;
	}
	public static int MaxMin(int[] nArr, int mode) {
		int result = nArr[0] ;
		// Max
		if(mode == 0) {
			for(int i = 0; i < nArr.length; i++) {
				if (nArr[i] > result) {
					result = nArr[i];
				}
			}
		}
		// Min
		else {
			for(int i = 0; i < nArr.length; i++) {
				if (nArr[i] < result) {
					result = nArr[i];
				}
			}
		}
		return result;
	}
	
	public static int[] PosNeg(int[] nArr, int mode) {
		int[] result = new int[2];
		List temp = new ArrayList<Integer>();
		for(int i = 0; i < nArr.length; i ++) {
			// Positive number

			if(mode == 0) {
				if(nArr[i] > 0) {
					temp.add(nArr[i]);
				}
			}
			// Negative number
			else {
				if(nArr[i] < 0) {
					temp.add(nArr[i]);
				}
			}
		}
		Collections.sort(temp);
		result[0] = (int) temp.get(0);
		result[1] = (int) temp.get(temp.size() - 1);
		return result;
			
		
	}
	
	public static void OddEven(int[] nArr) {
		System.out.println("Cac phan tu la so chan: ");
		for(int i = 0; i < nArr.length; i++) {
			if(nArr[i] % 2 == 0) {
				System.out.println(nArr[i]);
			}
		}
		
		System.out.println("Cac phan tu la so le: ");
		for(int i = 0; i < nArr.length; i++) {
			if(nArr[i] % 2 != 0) {
				System.out.println(nArr[i]);
			}
		}
	}
	
	public static int[] Add(int[] nArr, int value, int pos) {
		List temp = new ArrayList<Integer>();
		
		for(int i = 0; i < nArr.length;i++) {
			temp.add(nArr[i]);
		}
		temp.add(pos, value);
		System.out.println("Phan tu " + value +" voi index " + pos +" da duoc them vao mang");
		System.out.println("Mang moi la");
		int[] tempArr = new int[temp.size()];
		for(int i = 0; i < temp.size(); i ++) {
			tempArr[i] = (int) temp.get(i);
			System.out.print(temp.get(i) + " ");
			
		}
		System.out.println();
		return tempArr;
	}
	
	public static int[] Remove(int[] nArr, int pos) {
		List temp = new ArrayList<Integer>();
		
		for(int i = 0; i < nArr.length;i++) {
			temp.add(nArr[i]);
		}
		temp.remove(pos);
		System.out.println("Mang moi la");
		int[] tempArr = new int[temp.size()];
		for(int i = 0; i < temp.size(); i ++) {
			tempArr[i] = (int) temp.get(i);
			System.out.print(temp.get(i) + " ");
		}
		System.out.println();
		return tempArr;
	}
	
}
