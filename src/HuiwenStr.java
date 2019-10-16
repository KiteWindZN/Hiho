import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuiwenStr {

	
	
	
	public int Solve(String str) {
		int max = 1;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				int tmp1 = i, tmp2 = j;
				for (; tmp1 < tmp2; tmp1++, tmp2--) {
					if (str.charAt(tmp1) != str.charAt(tmp2)) {
						break;
					}
				}
				if (tmp1 >= tmp2 && (j - i + 1 > max)) {
					max = j - i + 1;
				}
			}
		}
		return max;
	}

	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	      if(pushA.length!=popA.length)
	          return false;
	      int i=0;
	      int j=0;
	      List<Integer> list=new ArrayList<Integer>();
	      for(i=0;i<pushA.length;i++){
	          list.add(pushA[i]);
	          while(list.size()>0){
	              int index=list.size()-1;
	              if(list.get(index)==popA[j]){
	                  list.remove(index);
	                  j++;
	              }
	          }
	      }
	        if(j==popA.length)
	            return true;
	        return false;
	    }
	
	public int Solve2(String str) {
		int max = 1;
		for (int i = 1; i < str.length() - 1; i++) {
			int tmp = 1;
			int tmp1 = i - 1;
			int tmp2 = i + 1;
			for (;; tmp2++, tmp1--) {

				if (str.charAt(tmp1) != str.charAt(tmp2)) {
					if (max < tmp)
						max = tmp;
					break;
				}
				if (tmp1 <= 0 || tmp2 >= str.length() - 1) {
					if (str.charAt(tmp1) == str.charAt(tmp2))
						tmp = tmp + 2;
					if (max < tmp)
						max = tmp;
					break;
				}
				tmp = tmp + 2;
			}

			int tmp3 = 0;
			int tmp4 = i;
			int tmp5 = i - 1;
			for (;; tmp4++, tmp5--) {
				if (str.charAt(tmp4) != str.charAt(tmp5)) {
					if (max < tmp3)
						max = tmp3;
					break;
				}
				if (tmp5 <= 0 || tmp4 >= str.length() - 1) {
					if (str.charAt(tmp4) == str.charAt(tmp5))
						tmp3 = tmp3 + 2;
					if (max < tmp3)
						max = tmp3;
					break;
				}
				tmp3 = tmp3 + 2;
			}
		}

		return max;
	}

	public int Solve3(String str) {
		int max = 0;
		boolean[][] p = new boolean[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			p[i][i] = true;
			if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				p[i][i + 1] = true;
				max = 2;
			}
		}
		for (int len = 3; len <= str.length(); len++) {
			for (int i = 0; i <= str.length() - len; i++) {
				int j = i + len - 1;
				if (p[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					max = len;
					p[i][j] = true;
					// break;
				}
			}
		}

		return max;
	}

	public int Solve4(String str) {
		int max = 1;
		StringBuilder Stb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			Stb.append("#");
			Stb.append(str.charAt(i));
		}

		Stb.append("#");
		str = Stb.toString();
       
		for (int i = 1; i < str.length() - 1; i++) {
			int tmp = 1;
			int tmp1 = i - 1;
			int tmp2 = i + 1;
			for (;; tmp2++, tmp1--) {

				if (str.charAt(tmp1) != str.charAt(tmp2)) {
					if (max < tmp)
						max = tmp;
					break;
				}
				if (tmp1 <= 0 || tmp2 >= str.length() - 1) {
					if (str.charAt(tmp1) == str.charAt(tmp2))
						tmp = tmp + 2;
					if (max < tmp)
						max = tmp;
					break;
				}
				tmp = tmp + 2;
			}
		}

		return (max - 1) / 2;
	}

	public int Solve5(String str) {
		
		int max = 1;
		
		char[] s = new char[str.length() * 2 + 2];
		
		s[0]='#';
		for (int i = 0,j = 1; i < str.length(); i++) {
			s[j++] = str.charAt(i);
			s[j++] = '#';
		}

		for (int i = 1; i < s.length-1; i++) {
			int tmp = 1;
			int tmp1 = i - 1;
			int tmp2 = i + 1;
			for (;; tmp2++, tmp1--) {

				if (s[tmp1] != s[tmp2]) {
					if (max < tmp)
						max = tmp;
					break;
				}
				if (tmp1 <= 0 || tmp2 >= s.length - 1) {
					if (s[tmp1] == s[tmp2])
						tmp = tmp + 2;
					if (max < tmp)
						max = tmp;
					break;
				}
				tmp = tmp + 2;
			}
		}
		
		return (max-1)/2;
	}

	int cal(String str) {
		int id = 1, mx = 1, max1 = 1;
		char[] s = new char[str.length() * 2 + 2];
		int[] P = new int[str.length() * 2];

		
		for (int i = 0, j = 2; i < str.length(); i++) {
			s[j++] = str.charAt(i);
			System.out.println(j);
			s[j++] = '#';
		}
		P[0] = 1;
		P[1] = 1;
		for (int i = 2; i<s.length; i++) // 考虑以i为中心的回文串
		{
			P[i] = i > mx ? 1 : Math.min(P[2 * id - i], mx - i);
			while (s[i + P[i]] == s[i - P[i]]) // 在这比对
				P[i]++;
			if (i + P[i] > mx) // 更新id和mx的位置
			{
				id = i;
				mx = i + P[i];
			}
			if (P[i] - 1 > max1) // 更新最大值
				max1 = P[i] - 1;
		}
		return max1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HuiwenStr obj = new HuiwenStr();
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextLine());
		}

		List<Integer> listInt = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			listInt.add(obj.Solve5(list.get(i)));
		}
		for (int i = 0; i < N; i++) {
			System.out.println(listInt.get(i));
		}
	}

}
