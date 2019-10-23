package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main_1268 {

	public int[][] change_row(int[][] nums){
		int len=nums.length;
		int[][] res=new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				res[i][j] = nums[len-1-i][j];
			}
		}
		return res;
	}
	
	public int[][] change_column(int[][] nums){
		int len=nums.length;
		int[][] res=new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				res[i][j]=nums[i][len-1-j];
			}
		}
		return res;
	}
	
	public int[][] rotate_90(int[][] nums){
		int len=nums.length;
		int[][] res=new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				res[i][j]=nums[j][len-1-i];
			}
		}
		return res;
	}
	
	public int[][] rotate_180(int[][] nums){
		int[][] res1=rotate_90(nums);
		int[][] res2=rotate_90(res1);
		return res2;
	}
	
	public int[][] rotate_270(int[][] nums){
		int[][] res1=rotate_180(nums);
		int[][] res2=rotate_90(res1);
		return res2;
	}
	
	public boolean is_same(int[][] nums_1,int[][] nums_2){
		int len=nums_1.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(nums_1[i][j]!=nums_2[i][j])
					return false;
			}
		}
		return true;
	}
	
	public List<int[][]> get_cal_nums(int[][] nums){
		List<int[][]> list=new ArrayList<int[][]>();
		list.add(nums);
		int cur=0;
		while(cur<list.size()){
			int[][] tmp_nums=list.get(cur);
			
			int[][] tmp_1=change_row(tmp_nums);
			if(!is_contains(list,tmp_1)){
				list.add(tmp_1);
			}
			
			int[][] tmp_2=change_column(tmp_nums);
			if(!is_contains(list,tmp_2)){
				list.add(tmp_2);
			}
			
			int[][] tmp_3=rotate_90(tmp_nums);
			if(!is_contains(list,tmp_3)){
				list.add(tmp_3);
			}
			
			int[][] tmp_4=rotate_180(tmp_nums);
			if(!is_contains(list,tmp_4)){
				list.add(tmp_4);
			}
			
			int[][] tmp_5=rotate_270(tmp_nums);
			if(!is_contains(list,tmp_5)){
				list.add(tmp_5);
			}
			
			cur++;
		}
		return list;
	}
	
	public boolean is_contains(List<int[][]> list,int[][] nums){
		for(int i=0;i<list.size();i++){
			int[][] tmp_nums=list.get(i);
			if(is_same(tmp_nums,nums))
				return true;
		}
		return false;
	}
	
	public List<Integer> resolve(List<int[][]> list,int[][] nums){
		int len=nums.length;
		List<Integer> res_list=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			if(is_match(nums,list.get(i)))
				res_list.add(i);
		}
		return res_list;
	}
	
	public boolean is_match(int[][] nums_1,int[][] nums_2){
		int len=nums_1.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(nums_1[i][j]==0)
					continue;
				if(nums_1[i][j]!=nums_2[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1268 obj=new Main_1268();
		int[][] nums=new int[3][3];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				nums[i][j]=scan.nextInt();
			}
		}
		int[][] nums_1={{4,9,2},{3,5,7},{8,1,6}};
		
		List<int[][]> list=obj.get_cal_nums(nums_1);
		List<Integer> list_index=obj.resolve(list, nums);
		if(list_index.size()>1){
			System.out.println("Too Many");
		}else{
			int[][] tmp_nums=list.get(list_index.get(0));
			for(int i=0;i<3;i++){
				System.out.print(tmp_nums[i][0]);
				for(int j=1;j<3;j++){
					System.out.print(" "+tmp_nums[i][j]);
				}
				System.out.println();
			}
		}
		scan.close();
	}

}
