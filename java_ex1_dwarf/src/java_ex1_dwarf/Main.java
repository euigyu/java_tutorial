package java_ex1_dwarf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static boolean[] check=new boolean[9];
	static int[] nanjang=new int[9];
	static int[] realnanjang=new int[7];
	static ArrayList<Integer> arrlist= new ArrayList<Integer>(); 
	public static void sort(){
		
	}
	public static void search(int sum, int cnt) {
		if(sum==100 && cnt==7) {
			for(int i=0;i<arrlist.size();i++) {
				Collections.sort(arrlist);
				System.out.print(arrlist.get(i)+" ");
				System.out.println("");
			}
			System.exit(0);
		}
		if(sum>100 || cnt>7) {
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(check[i]==false) {
				check[i]=true;
				arrlist.add(nanjang[i]);
				search(sum+nanjang[i],cnt+1);
				check[i]=false;
				arrlist.remove(arrlist.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<9;i++) {
			nanjang[i]= sc.nextInt();
		}
		search(0,0);
	}
	
}
		



