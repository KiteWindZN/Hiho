import java.util.Scanner;

public class Main_1049 {

	String str="";
	public void solve(String pre,String mid){
		if(pre==null||pre.length()==0)
			return;
		char ch=pre.charAt(0);
		str=ch+str;
		int lenL=mid.lastIndexOf(ch);
		String pre1=pre.substring(1, lenL+1);
		String pre2="";
		
		
		String mid1=mid.substring(0, lenL);
		String mid2="";
		if(lenL+1<(pre.length())){
			pre2=pre.substring(lenL+1, pre.length());
		    mid2=mid.substring(lenL+1, mid.length());
		}
		solve(pre2,mid2);
		solve(pre1,mid1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1049 obj=new Main_1049();
		Scanner scan=new Scanner(System.in);
		String pre=scan.nextLine();
		String mid=scan.nextLine();
		obj.solve(pre, mid);
		System.out.println(obj.str);
		scan.close();
	}

}
