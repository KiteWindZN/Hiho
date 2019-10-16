import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1121 {

	public boolean solve(List<List<Integer>> map) {
		int n = map.size();
		int[] color = new int[n];
		
		List<Integer> list = new ArrayList<Integer>();
		
		int start=1; ;
		color[1] = 1;
		while (start != 0) {
			list.add(start);
			color[start]=1;
			while (list.size() > 0) {
				int top = list.get(0);
				list.remove(0);
				int c = color[top];
				for(int i=0;i<map.get(top).size();i++){
					int num=map.get(top).get(i);
					if(color[num]==0){
						color[num]=c*(-1);
						list.add(num);
					}else if(color[num]==c){
						return false;
					}
				}
				
			}
			start=isEnd(color,map);
		}
		return true;
	}

	public int isEnd(int[] color,List<List<Integer>> map) {
		int n = color.length;
		for (int i = 1; i < n; i++){
			if (color[i] == 0){
				if(map.get(i).size()>0)
					return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1121 obj = new Main_1121();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while (T > 0) {
			int n = 0;
			int m = 0;
			n = scan.nextInt();
			m = scan.nextInt();

			
			List<List<Integer>> map=new ArrayList<List<Integer>>();
			for(int i=0;i<n+1;i++){
				map.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < m; i++) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				map.get(start).add(end);
				map.get(end).add(start);
			}

			if (obj.solve(map))
				System.out.println("Correct");
			else
				System.out.println("Wrong");
			T--;
		}
		scan.close();
	}

}
