import java.util.Scanner;

public class Main_1038 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int[] need=new int[N];
		int[] value=new int[N];
		
		for(int i=0;i<N;i++){
			need[i]=scan.nextInt();
			value[i]=scan.nextInt();
		}
		
		int[] f=new int[M+1];
		f[0]=0;
		
		for(int i=0;i<N;i++){
			for(int j=M;j>=need[i];j--){
				f[j]=Math.max(f[j-need[i]]+value[i], f[j]);
			}
		}
		System.out.println(f[M]);
		scan.close();
	}

}
