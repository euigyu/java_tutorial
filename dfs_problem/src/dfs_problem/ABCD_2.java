//package dfs_problem;
//import java.util.*;
//import java.io.*;
//import java.math.*;
//
//public class ABCD_2  {
//   static int flag = 0;
//  
//   public static void main(String[] args) throws IOException{
//      
//      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//      Scanner sc = new Scanner(System.in);
//      String[] str = bf.readLine().split(" "); 
//      int v = Integer.parseInt(str[0]);  //노드 수   
//      int e = Integer.parseInt(str[1]);  //엣지 수 
//      
//      ArrayList<Integer>[] al = new ArrayList[v];  //2차원 동적배열 선언 
//      
//      for(int i = 0 ; i < v ; i++){  
//         al[i] = new ArrayList<Integer>();
//      }
//      
//      for(int i = 0 ; i < e ; i++){
//         StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
//         int from = Integer.parseInt(token.nextToken());
//         int to = Integer.parseInt(token.nextToken());   
//         al[from].add(to);
//         al[to].add(from);
//      }
//      
//      for(int i = 0 ; i < v ; i++){
//         Collections.sort(al[i]);  //순서대로 방문하기 위해 정리 
//      }
//
//      int[] check = new int[v];
//      
//      //모든 노드를 기준으로 출발해야하므로 노드 갯수만큼 실행 
//      for(int i = 0 ; i < v ; i++){   
//         DFS(al, check, i, 1);
//         if(flag == 1)
//            break;
//      }
//      System.out.println(flag);
//   }
//   
//   public static void DFS(ArrayList<Integer>[] al , int[] check, int start, int cnt){
//      if(cnt == 5)
//      {
//         flag = 1;
//         return;
//      }
//      
//      check[start] = 1;
//      int al_len = al[start].size();
//      for(int i = 0 ; i < al_len ; i++)
//      {
//         int new_start = al[start].get(i);
//         if(check[new_start] == 0)
//            DFS(al, check, new_start, cnt+1);
//         
//      }
//      check[start] = 0;
//   }
//}
//
//// DFS 깊이가 5이상인지 체크해주는 것이다.
////중요점은 check[start] 가 더이상 갈곳이 없으면 check[start]를 0으로 해주는것이다.
////[start]를 0으로 해주는것이다.
//
