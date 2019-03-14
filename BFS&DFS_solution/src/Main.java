import java.util.*;

public class Main {
    static boolean check[] = new boolean[10001];
    static boolean check_bfs[]=new boolean[10001];
	public static void dfs(ArrayList<Integer>[] arr,int start) {
		if(check[start]==true) {
			return;
		}
		System.out.print(start+" ");
		check[start]=true;
		
		for(int i=0;i<arr[start].size();i++) {
			int next=arr[start].get(i);
			if(check[next]==false) {
				dfs(arr,next);
			}
		}
	}
	public static void bfs(ArrayList<Integer>[] arr,int start) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(start);
		check_bfs[start]=true;
		while(!q.isEmpty()) {
			int node=q.poll();
			System.out.print(node+" ");
			for(int i=0;i<arr[node].size();i++) {
				if(check_bfs[arr[node].get(i)]==false) {
					q.offer(arr[node].get(i));
					check_bfs[arr[node].get(i)]=true;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] input=sc.nextLine().split(" ");
		int v=Integer.parseInt(input[0]);
		int e=Integer.parseInt(input[1]);
		int start=Integer.parseInt(input[2]);
		int[] check=new int[v];
		int cnt=0;
		ArrayList<Integer>[] arr=new ArrayList[v+1];
	
		for(int i=0;i<=v;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		//input 연결된노드의 엣지  
		for(int i=0;i<e;i++) {
			input=sc.nextLine().split(" ");
			int from=Integer.parseInt(input[0]);
			int to=Integer.parseInt(input[1]);
			arr[from].add(to);
			arr[to].add(from);
		}
	
		//input 순차 방문을 위한 정렬 
		for(int i=0;i<=v;i++) {
			Collections.sort(arr[i]);
		}
	
		dfs(arr,start);
		System.out.println(" ");
		bfs(arr,start);
	
	
	}
}
