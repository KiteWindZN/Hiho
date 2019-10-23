package level1;

import java.util.Scanner;

public class Main_1223 {

	public int solve(String[] strs, int[] nums) {
		int res = 0;
		int len = strs.length;
		for (int i = -1; i <= 2000; i++) {
			int cur = 0;
			for (int j = 0; j < len; j++) {
				String ss = strs[j];
				int num = nums[j];
				switch (ss) {
				case "=":
					if(i==num)
						cur++;
					break;
				case "<=":
					if(i<=num)
						cur++;
					break;
				case "<":
					if(i<num)
						cur++;
					break;
				case ">":
					if(i>num)
						cur++;
					break;
				case ">=":
					if(i>=num)
						cur++;
					break;
				default:
					break;
				}
			}
			if(cur > res)
				res=cur;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1223 obj = new Main_1223();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		String[] strs = new String[T];
		int[] nums = new int[T];

		for (int i = 0; i < T; i++) {
			String line = scan.nextLine();
			String[] tmp_strs = line.split(" ");
			strs[i] = tmp_strs[1].trim();
			nums[i] = (int) (Float.parseFloat(tmp_strs[2].trim())*2);
		}
		int res=obj.solve(strs, nums);
		System.out.println(res);
	}

}
