import java.util.Scanner;

public class JiaocuoHe {

	
	public boolean cal(String str,int k){
		int s=1;
		int res=0;
		for(int i=0;i<str.length();i++){
			res+=s*(str.charAt(i)-'0');
			s=s*(-1);
		}
		//System.out.println(res);
		if(res==k)
			return true;
		else return false;
	}
	
	
	
	public String Add(String str1,String str2){
		String res="";
		int cur=0;
		if(str1.length()<str2.length()){
			String tmp=str1;
			str1=str2;
			str2=tmp;
		}
		int i=str1.length()-1,j=str2.length()-1;
		while(i>=0&&j>=0){
			int tmp=str1.charAt(i)-'0'+str2.charAt(j)-'0';
			tmp+=cur;
			cur=tmp/10;
			tmp=tmp%10;
			res=tmp+res;
			i--;
			j--;
		}
		while(i>=0){
			int tmp=str1.charAt(i)-'0';
			tmp+=cur;
			cur=tmp/10;
			tmp=tmp%10;
			res=tmp+res;
			i--;
		}
		if(cur!=0)
			res=cur+res;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JiaocuoHe obj=new JiaocuoHe();
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		long res=0;
		int MOD=(int)Math.pow(10, 9)+7;
		
		String[] nums=line.split(" ");
		int k=Integer.parseInt(nums[2]);
		long startS=-1;
		long start= Long.parseLong(nums[0]);
		long end=Long.parseLong(nums[1]);
		/*for(long  i=start;i<=end;i++){
			String str=i+"";
			if(obj.cal(str, k)){
				startS=i;
				break;
			}
			
		}*/
		
		for(long i=start;i<=end;i++){
			String str=i+"";
			if(obj.cal(str, k)){
				res=(res+i)%MOD;
				i=i+3;
			}
			
		}
		System.out.println(res);
		
	}

}
