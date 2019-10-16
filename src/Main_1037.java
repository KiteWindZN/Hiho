import java.util.Scanner;

public class Main_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[][] map=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				map[i][j]=scan.nextInt();
			}
		}
		
		int[][] dp=new int[n][n];
		dp[0][0]=map[0][0];
		
		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==0)
				    dp[i][j]=dp[i-1][j]+map[i][j];
				else{
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
				}
			}
		}
		
		int max=dp[n-1][0];
		for(int i=1;i<n;i++){
			max=Math.max(max, dp[n-1][i]);
		}
		System.out.println(max);
	}

}
