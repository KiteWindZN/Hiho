import java.util.Scanner;

public class Main_1033 {

	static class node{
		long s;
		long n;
	}
	int mod=1000000007;
	
	node[][][] dp=new node[21][20][400];
	int[] bits=new int[21];
	long [] base=new long[21];
	
	public node dfs(int len,int dig,boolean begin_zero,boolean limit, int sum){
		node t=new node();
		t.s=0;
		t.n=0;
		
		if(len<=0|| len>=20 ||dig<0||dig>9||sum<-200||sum>200){
			return t;
		}
		
		if(!limit && dp[len][dig+(begin_zero?0:10)][sum+200].n!=-1){
			return dp[len][dig+(begin_zero?0:10)][sum+200];
		}
		
		if(len ==1){
			if(dig!=sum)
				return t;
			t.n=1;
			t.s=sum;
			return t;
		}
		int end = limit?bits[len-2]:9;
		int newSum= dig-sum;
		node tmp;
		for(int j=0;j<end+1;j++){
			if(begin_zero){
				tmp=dfs(len-1,j,j==0,limit&&(j==end),sum);
			}else{
				tmp=dfs(len-1,j,false,limit&&(j==end),newSum);
			}
			
			t.n+=tmp.n;
			t.s=((t.s+tmp.s)%mod + ((tmp.n*dig)%mod *base[len])%mod)%mod;
			
		}
		if(!limit)
			dp[len][dig+(begin_zero ? 0:10)][sum+200]=t;
		return t;
	}
	
	public int solve(long n, int s){
		if(n<=0)
			return 0;
		int l=0;
		for(int i=0;i<21;i++){
			bits[i]=0;
		}
		
		while(n>0){
			bits[l++]=(int) (n%10);
			n=n/10;
		}
		return (int) (dfs(l+1,0,true,true,s).s);
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1033 obj=new Main_1033();
		long l,r;
		int s;
		node t=new node();
		t.n=-1;
		t.s=0;
		for(int i=0;i<21;i++){
			for(int j=0;j<20;j++){
				for(int k=0;k<400;k++){
					obj.dp[i][j][k]=t;
				}
			}
		}
		obj.base[1]=1;
		for(int i=2;i<21;i++){
			obj.base[i]=obj.base[i-1]*10%obj.mod;
		}
		
		Scanner scan=new Scanner(System.in);
		l=scan.nextLong();
		r=scan.nextLong();
		s=scan.nextInt();
		int res=(obj.solve(r, s)-obj.solve(l-1, s)+obj.mod)%obj.mod;
		System.out.println(res);
		scan.close();
	}

}
