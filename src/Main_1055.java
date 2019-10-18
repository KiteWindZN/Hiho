import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1055 {

	int M = 0;

	public void dfs(List<List<Integer>> list, int u, int p, int[][] dp, int[] values) {
		dp[u][1] = values[u];
		List<Integer> L = list.get(u);
		for (int v : L) {
			dfs(list, v, u, dp, values);
			for (int i = M; i >= 2; i--) {
				for (int j = 1; j < i; j++) {
					dp[u][i] = Math.max(dp[u][i], dp[u][i - j] + dp[v][j]);
				}
			}
		}
	}

	public void solve(List<List<Integer>> list, int[][] dp,int[] values) {
		dfs(list, 1, 0, dp,values);
		System.out.println(dp[1][M]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1055 obj = new Main_1055();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		obj.M = scan.nextInt();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		int[] values = new int[N + 1];
		list.add(new ArrayList<Integer>());
		for (int i = 1; i <= N; i++) {
			values[i] = scan.nextInt();
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < N; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			list.get(start).add(end);
		}
		
		int[][] dp=new int[N+1][obj.M+1];
		obj.solve(list, dp, values);
		
		scan.close();
	}

}
