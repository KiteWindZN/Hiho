import java.util.Scanner;

public class Main_1042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int L=scan.nextInt();
		
		int l=scan.nextInt();
		int r=scan.nextInt();
		int t=scan.nextInt();
		int b=scan.nextInt();
		
		int l1=0;
		int r1=0;
		int t1=0;
		int b1=0;
		
		if(l+r<=m&&t+b<=n){
			l1=m-r;
			r1=m-l;
			t1=n-b;
			b1=n-t;
		}else if(l+r>m&&t+b<=n){
			l1=l;
			r1=r;
			t1=n-b;
			b1=n-t;
		}else if(l+r<=m&&t+b>n){
			l1=m-r;
			r1=m-l;
			t1=t;
			b1=b;
		}
		int ans=0;
		for(int i=0;i<=L/2&&i<=m;i++){
			for(int j=0;(j+i)<=L/2&&j<=n;j++){
				if(i<=l1||j<=t1){
					ans=Math.max(ans, i*j);
				}
				else if(i>l1&&i<=r1&&j>t1&&j<=b1){
					ans=Math.max(ans, i*j-(i-l1)*(j-t1));
				}else if(i>r1&&j>b1){
					ans=Math.max(ans, i*j-(b1-t1)*(r1-l1));
				}
			}
		}
		System.out.println(ans);
		scan.close();
	}

}
