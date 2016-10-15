package hurned;

import java.util.Scanner;

public class one {
	public static void main(String[] args) {
		int n,i,j,k;
		System.out.println("输入金字塔行数");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		for(i=1;i<=n;i++){
			for(j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			for(k=1;k<=2*i-1;k++){
				System.out.print("*");
			}
			    System.out.println();
			}
			
		}
	}
