package java_baseball;

import java.util.Random;
import java.util.Scanner;

public class baseball_test { 
	//컴퓨터 랜덤값 3개 입력 (범위: 1~9)
	public static int[] com_input() {
		int[] com_arr=new int[3];
		Random rand=new Random();
		for(int i=0;i<com_arr.length;i++) { 
			com_arr[i]=rand.nextInt(9)+1;
			for(int j=0;j<i;j++) {
				if(com_arr[i]==com_arr[j]) {
					i--;
				}
			}
		}
//		for(int i=0;i<com_arr.length;i++) {
//			System.out.println(com_arr[i]);
//		}
		return com_arr;	
	}

	//사용자 3개숫자 입력 
	public static int[] input() {
		Scanner sc=new Scanner(System.in);
		int[] input=new int[3];
		System.out.println("숫자를 입력해주세요 ex)123");
		String input_str=sc.next();
		String[] input_num=input_str.split("");
		for(int i=0;i<input_num.length;i++) {
			input[i]=Integer.parseInt(input_num[i]);
		}
//		for(int i=0;i<input.length;i++) {
//			System.out.println(input[i]);	
//		}
		return input;
	}
	
	//스트라이크 갯수 확인 
	public static int compare_strike(int[] com, int[] gamer) {
		int strike=0;
		for(int i=0;i<com.length;i++) {
			if(com[i]==gamer[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	//볼 갯수 확인 
	public static int compare_ball(int[] com, int[] gamer) {
		int ball=0;
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<gamer.length;j++) {
				if(com[i]==gamer[j] && i!=j) {
					ball++;
				}
			}
		}
		return ball;
	}
	
	//야구게임 진행 메소드 
	public static void start() {
		int[] com=com_input();
		int result_strike=0;
		int result_ball=0;
		while(true) {
			int[] gamer=input();
			result_strike=compare_strike(com,gamer);
			result_ball=compare_ball(com,gamer);
			if(result_strike==3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
			if(result_strike==0 && result_ball==0){
				System.out.println(" 낫싱 ");
				continue;
			}
			else{
				System.out.println(result_strike +"스트라이크 "+ result_ball +"볼 입니다.");
				continue;
			}
			
		}		
	}
	public static void main(String[] args) {
		start();
	}

}
