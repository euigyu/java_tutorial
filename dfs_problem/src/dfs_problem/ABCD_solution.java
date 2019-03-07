package dfs_problem;

import java.util.*;

public class ABCD_solution {
	static int flag; 
	public static void dfs(ArrayList<Integer>[] arr,int[]check,int start,int cnt ){
		if(cnt==4) {
			flag=1;
			return;
		} 
		check[start]=1; //방문노드 표시 
		for(int i=0;i<arr[start].size();i++) {
			int new_start = arr[start].get(i); //새로운 노드 선정 
			if(check[new_start]==0) {
				dfs(arr,check,new_start,cnt+1);
			}
		}check[start]=0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] input=sc.nextLine().split(" ");
		int v=Integer.parseInt(input[0]);
		int e=Integer.parseInt(input[1]);
		int cnt=0; //연결노드의 레벨 확인
		int[] check=new int[v];
		ArrayList<Integer>[] arr= new ArrayList[v];
		
		//2차원 동적배열초기화 
		for(int i=0;i<v;i++) {
			arr[i]= new ArrayList<Integer>();
		}
		//연결노드 배열에 담기 
		for(int i=0;i<e;i++) {
			input=sc.nextLine().split(" ");
			int from=Integer.parseInt(input[0]);
			int to=Integer.parseInt(input[1]);
			arr[from].add(to);
			arr[to].add(from);
		}
		//순차적 노드 방문을 위한 오름차순 정리 
		for(int i=0;i<v;i++) {
			Collections.sort(arr[i]);
		}
		for(int i=0;i<v;i++) {
			dfs(arr,check,i,cnt);
			if(flag==1)break;
		}
		System.out.println(flag);
	}
}
