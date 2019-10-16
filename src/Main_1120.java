import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1120 {

	int yes = 0;
	int no = 0;

	static class node {
		int x;
		int y;
		

		public node(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
	}

	public boolean check(int[][] map) {
		int n = map.length;
		int m = map[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]<0)
					continue;
				if (map[i][j] != cal(map, i, j))
					return false;
			}
		}
		return true;
	}

	public int cal(int[][] map, int i, int j) {
		int res = 0;
		int n = map.length;
		int m = map[0].length;

		for (int h = -1; h <= 1; h++) {
			if (h + i >= n || h + i < 0)
				continue;
			for (int g = -1; g <= 1; g++) {
				if (g + j >= m || g + j < 0)
					continue;
				if (map[i+h][j+g] == -2)
					res++;
			}
		}
		return res;
	}

	public void solve( List<node> list, int[][] map) {
		int num=list.size();
		int max = 1<<num;
		for (int k = 0; k < max; k++) {
			yes=0;
			no=0;
			//k=1009;
			for (int i = 0; i < num; i++) {
				int x1 = list.get(i).x;
				int y1 = list.get(i).y;
				//System.out.println((k & (1 << i)));
				if ((k & (1 << i)) !=0) {
					map[x1][y1] = -2;
					yes++;
				} else {
					map[x1][y1] = -3;
					no++;
				}
			}
			if(check(map)==true){
				System.out.println(yes+" "+no);
				return ;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1120 obj=new Main_1120();
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		while (T > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] map = new int[n][m];
			List<node> listN = new ArrayList<node>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = scan.nextInt();
					if (map[i][j] == -1) {
						node tmpNode = new node(i, j);
						listN.add(tmpNode);
					}
				}
			}
			obj.solve(listN, map);
			T--;
		}
		scan.close();

	}

}
