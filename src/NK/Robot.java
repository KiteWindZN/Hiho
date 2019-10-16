package NK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Robot {

	public int calSum(int num1, int num2) {
		int res = 0;
		while (num1 > 0) {
			int tmp = num1 % 10;
			res += tmp;
			num1 = num1 / 10;
		}
		while (num2 > 0) {
			int tmp = num2 % 10;
			res += tmp;
			num2 = num2 / 10;
		}
		return res;
	}

	public int movingCount(int threshold, int rows, int cols) {

		int[][] visited = new int[rows][cols];
		int res = 0;
		List<String> list = new ArrayList<String>();
		if (calSum(0, 0) <= threshold) {
			// res++;
			String str = "0 0";
			visited[0][0]=1;
			list.add(str);
		}
		while (list.size() > 0) {
			String str = list.get(0);
			list.remove(0);
			String[] nums = str.split(" ");
			int i = Integer.parseInt(nums[0]);
			int j = Integer.parseInt(nums[1]);
			res++;
			if (i - 1 >= 0) {
				if (calSum(i - 1, j) <= threshold&&visited[i-1][j]==0) {
					int tmp = i - 1;
					String tmpS = "" + tmp + " " + j;
					list.add(tmpS);
					visited[i-1][j]=1;
				}
			}

			if (j - 1 >= 0) {
				if (calSum(i, j - 1) <= threshold&&visited[i][j-1]==0) {
					int tmp = j - 1;
					String tmpS = "" + i + " " + tmp;
					list.add(tmpS);
					visited[i][j-1]=1;
				}
			}

			if (i + 1 < rows) {
				if (calSum(i + 1, j) <= threshold&&visited[i+1][j]==0) {
					int tmp = i + 1;
					String tmpS = "" + tmp + " " + j;
					list.add(tmpS);
					visited[i+1][j]=1;
				}
			}

			if (j + 1 < cols) {
				if (calSum(i, j + 1) <= threshold&&visited[i][j+1]==0) {
					int tmp = j + 1;
					String tmpS = "" + i + " " + tmp;
					list.add(tmpS);
					visited[i][j+1]=1;
				}
			}
		}
		return res;
	}

	
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    
        duplication[0]=-1;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],map.get(numbers[i])+1);
                if(duplication[0]==-1)
                    duplication[0]=numbers[i];
            }else{
                map.put(numbers[i],1);
            }
        }
        if(map.size()<length)
            return true;
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int threshold=sc.nextInt();
		int rows=sc.nextInt();
		int cols=sc.nextInt();
		Robot myRobot=new Robot();
		int res=myRobot.movingCount(threshold, rows, cols);
		System.out.println(res);
	}

}
