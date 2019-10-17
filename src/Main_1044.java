import java.util.Scanner;

public class Main_1044 {

	public int[] slove(int N,int M,int Q,int[] nums){
		int[] res=new int[nums.length];
		for( int i=0;i<res.length;i++){
			res[i]=1;
		}
		if(nums.length < M)
			return res;
		for(int i=Q;i<res.length;i++){
			int count=0;
			int min=Integer.MAX_VALUE;
			int choose=-1;
			for(int j=i-Q;j<=i;j++){
				if(res[j]==1)
					count++;
				if(min>nums[j]){
					min=nums[j];
					choose=j;
				}
			}
			if(count>Q){
				res[choose]=0;
			}
		}
		return res;
	}
	
	public int sum_array(int[] index,int[] nums){
		int res=0;
		for(int i=0;i<index.length;i++){
			res= res+index[i]*nums[i];
		}
		return res;
	}
	
	public int solve1(int N,int M,int Q,int[] nums){
		int max=(int)Math.pow(2, M-1);
		
		int[][] best=new int[nums.length][max];
		int tmp_m=1;
		best[0][0]=nums[0];
		//best[0][1]=nums[0];
		
		for(int i=0;i<N-1;i++){
			if(i<M)
				best[i][0]=nums[i];
			else
				best[i][0]=get_max_num(best[i-M]) +nums[i];
			int tmp_1=Math.min(i, M-1);
			for(int j=0;j<(int)Math.pow(2, tmp_1);j++){
				int one_num=cal_one_num(j);
				if(one_num<Q){
					int tmp=Math.min(i+1, M-2);
					best[i+1][j/2+(int)(Math.pow(2, tmp))]=best[i][j]+nums[i+1];
				}else{
					best[i+1][j/2] = best[i-1][j];
				}
			}
		}
		
		max=get_max_num(best[nums.length-1]);
		return max;
	}
	
	public int get_max_num(int[] nums){
		int max=nums[0];
		for(int n:nums){
			max=Math.max(max, n);
		}
		return max;
	}
	public int cal_one_num(int num){
		int res=0;
		while(num>0){
			int mod=num%2;
			num=num/2;
			if(mod==1)
				res++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1044 obj=new Main_1044();
		int N=0;
		int M=0;
		int Q=0;
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		Q=scan.nextInt();
		int[] nums=new int[N];
		for(int i=0;i<N;i++){
			nums[i]=scan.nextInt();
		}
		
		int ans=obj.solve1(N, M, Q, nums);
		//int ans=obj.sum_array(index, nums);
		System.out.println(ans);
		scan.close();
		
	}

}
