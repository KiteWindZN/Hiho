import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1050 {

	int max=0;
	public int dfs(List<List<Integer>> list,int index){
		if(list.get(index).size()==0){
			return 0;
		}
		if(list.get(index).size()==1){
			int m=1+dfs(list,list.get(index).get(0));
			if(max<m)
				max=m;
			return m;
		}
			int len=list.get(index).size();
		int[] res=new int[len];
		for(int i=0;i<len;i++){
			res[i]=1+dfs(list,list.get(index).get(i));
		}
		int max1=0;
		int max2=0;
		for(int i=0;i<len;i++){
			if(max1<res[i]){
				max2=max1;
				max1=res[i];
			}else if(max2<res[i]){
				max2=res[i];
			}
		}
		if(max<(max1+max2))
			max=max1+max2;
		return max1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Main_1050 obj=new Main_1050();
		int N=scan.nextInt();
		List<List<Integer>> map=new ArrayList<List<Integer>>();
		for(int i=0;i<N+1;i++){
			map.add(new ArrayList<Integer>());
		}
		for(int i=1;i<N;i++){
			int start=scan.nextInt();
			int end=scan.nextInt();
			map.get(start).add(end);
		}
		obj.dfs(map, 1);
		System.out.println(obj.max);
	}

}
