import java.util.*;

public class NxM_problem {
	static ArrayList<Integer> number = new ArrayList();
	static boolean[] check = new boolean[9];
	static int n=0; //숫자 1~n까지 
	static int m=0; //m자리까지 
	
	//N x M 문제 풀이 재귀 
	public static void search(int cnt) {
		if(cnt==m) {
			for(int i=0;i<number.size();i++) {
				System.out.print(number.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		for(int i=1;i<=n;i++) {
			if(check[i]==true) {
				continue;
			}
			check[i]=true;
			number.add(i);
			search(cnt+1);
			check[i]=false;
			number.remove(number.size()-1);
			
		}
		
	}
	
	//N x M 2번문제 풀이
	public static void search_2(int cnt,int next) {
		
		if(cnt==m) {
			for(int i=0;i<number.size();i++) {
				System.out.print(number.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		
		if(next>n)
			return;
		for(int i=next;i<=n;i++) {
			if(check[i]==true) {
				continue;
			}
			check[i]=true;
			number.add(i);
			search_2(cnt+1,i+1);
			check[i]=false;
			number.remove(number.size()-1);	
		}
	}	
	
	//N x M 2번문제 풀이 다른방
	public static void other_search_2(int cnt,int next){
		if(cnt==m) {
			for(int i=0;i<number.size();i++) {
				System.out.print(number.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		
		if(next>n) {
			return;
		}
		number.add(next);
		search_2(cnt+1,next+1);
		number.remove(number.size()-1);   
		search_2(cnt,next+1);
	}
	
	//N x M 3번문제 풀이
	public static void search_3(int cnt) {
		if(cnt==m) {
			for(int i=0;i<number.size();i++) {
				System.out.print(number.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		for(int i=1;i<=n;i++) {
			number.add(i);
			search_3(cnt+1);
			number.remove(number.size()-1);
			
		}
		
	}	
	
	//N x M 4번문제 풀이
	public static void search_4(int cnt,int next) {
		if(cnt==m) {
			for(int i=0;i<number.size();i++) {
				System.out.print(number.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		for(int i=next;i<=n;i++) {
			number.add(i);
			search_4(cnt+1,i);
			number.remove(number.size()-1);
		}
		
	}	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		int limit=0;

		n=sc.nextInt();
		m=sc.nextInt();
		search(cnt);
		search_2(cnt,1);
		other_search_2(cnt,1);
		search_3(cnt);
		search_4(cnt,1);
	}
}
