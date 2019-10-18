import java.util.Scanner;

public class Main_1044 {

	public int solve2(int N, int M, int Q, int[] nums) {
		int max_num = 1 << M;
		boolean[] ok = init(M, Q);
		int[][] dp = new int[N + 1][max_num];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < (1 << (M)); j++) {

				int s0 = ((j << 1) & ((1 << M) - 1));
				int s1 = ((j << 1 | 1) & ((1 << M) - 1));
				
				dp[i][s0] = Math.max(dp[i - 1][j], dp[i][s0]);
				if (ok[s1]) {
					//System.out.println(i + " " + s0 + " " + s1 + " " + j);
					dp[i][s1] = Math.max(dp[i][s1], dp[i - 1][j] + nums[i - 1]);
				}
			}
		}

		int max = get_max_num(dp[nums.length]);
		return max;
	}

	public static boolean[] init(int m, int q) {
		boolean[] lte = new boolean[1 << m];
		for (int i = 0; i < (1 << m); i++) {
			int cnt = 0;
			for (int j = i; j > 0; j >>= 1) {
				cnt += j & 1;
			}
			lte[i] = cnt <= q;
		}
		return lte;
	}

	public int get_max_num(int[] nums) {
		int max = nums[0];
		for (int n : nums) {
			max = Math.max(max, n);
		}
		return max;
	}

	public int cal_one_num(int num) {
		int res = 0;
		while (num > 0) {
			int mod = num % 2;
			num = num / 2;
			if (mod == 1)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1044 obj = new Main_1044();
		int N = 0;
		int M = 0;
		int Q = 0;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		Q = scan.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = scan.nextInt();
		}

		int ans = obj.solve2(N, M, Q, nums);
		System.out.println(ans);
		scan.close();

	}

}
