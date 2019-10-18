import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1039 {

	public int cal(String str) {
		int res = 0;

		while (true) {
			int flag1 = 0;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == str.charAt(i - 1)) {
					flag1 = 1;
					int j = i + 1;
					for (; j < str.length(); j++) {
						if (str.charAt(j) != str.charAt(j - 1))
							break;
					}
					int tmp = j;
					res += j - i + 1;
					String str1 = str.substring(0, i - 1);
					String str2 = str.substring(tmp, str.length());
					str = str1 + str2;
					i--;
				}
			}
			if (flag1 == 0)
				break;
		}
		if (str.length() == 0) {
			res = res + 1;
		} else if (str.length() == 1) {
			res = res + 2;
		} else {
			int max = 0;
			for (int i = 1; i < str.length(); i++) {

				int tmpM = 1;
				int tmp1 = i - 1;
				int tmp2 = i + 1;
				while (tmp1 >= 0 && tmp2 <= str.length() - 1) {
					if (str.charAt(tmp1) == str.charAt(tmp2))
						tmpM += 2;
					tmp1--;
					tmp2++;
				}
				if (max < tmpM)
					max = tmpM;
			}
			res = res + max + 1;
		}
		return res;

	}

	public int myCal(String str) {
		int res = 0;

		while (true) {
			int flag1 = 0;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == str.charAt(i - 1)) {
					flag1 = 1;
					int j = i + 1;
					for (; j < str.length(); j++) {
						if (str.charAt(j) != str.charAt(j - 1))
							break;
					}
					int tmp = j;
					res += j - i + 1;
					String str1 = str.substring(0, i - 1);
					String str2 = str.substring(tmp, str.length());
					str = str1 + str2;
					i--;
				}
			}
			if (flag1 == 0)
				break;
		}
		return res;
	}

	public int Solve(String str) {
		int res = 0;
		char[] ch = { 'A', 'B', 'C' };
		for (int i = 0; i <= str.length(); i++) {
			for (int j = 0; j < 3; j++) {
				String str1 = str.substring(0, i) + ch[j];
				String str2 = str.substring(i, str.length());
				String str3 = str1 + str2;

				int tmp=myCal(str3);
				if(res<tmp)
					res=tmp;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Main_1039 obj = new Main_1039();
		int num = Integer.parseInt(sc.nextLine());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			list.add(sc.nextLine());
		}

		for (int i = 0; i < num; i++) {
			int tmp = obj.Solve(list.get(i));
			System.out.println(tmp);
		}
	}

}
