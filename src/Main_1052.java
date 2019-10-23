import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1052 {

	public void solve (char[] str,int[] res,int start1,int start2,int k){
		if(k==start1)
			return;
		int flag=0;
		if(is_flag(res,start1))
			flag=1;
		
		if(str[start1] == str[start2]){
			res[start1+1]=res[start1];
			solve(str,res,start1+1,start2+1,k);
		}	
		else{
			if(res[start1+1]==0)
			res[start1+1]=res[start1]+1;
			else
				res[start1+1]=Math.min(res[start1]+1,res[start1+1]);
			char ch1=str[start1];
			char ch2=str[start2];
			
			
			if(flag==1){
				str[start1]=ch2;
				solve(str,res,start1+1,start2+1,k);
				str[start1]=ch1;
			}
			str[start2]=ch1;
			solve(str,res,start1+1,start2+1,k);
			str[start2]=ch2;
			
		}
	}
	
	public int resolve(char[] str,int k){
		int res=0;
		int len=str.length;
		if(len>=2*k){
			int start1=0;
			int start2=len-k;
			for(int i=0;i<k;i++){
				if(str[i+start1]!=str[i+start2])
					res++;
			}
			return res;
		}
		
		int inter=len-k;
		for(int i=0;i<inter;i++){
			StringBuilder ss=new StringBuilder();
			for(int j=i;j<len;){
				ss.append(str[j]);
				j=j+inter;
			}
			String tmp_str=ss.toString();
			int num_1=tmp_str.length()-cal_char_num(tmp_str);
			res+=num_1;
		}
		return res;
	}
	
	public int cal_char_num(String str){
		int res=0;
		Map<Character,Integer> myMap=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(myMap.containsKey(ch))
				myMap.put(ch, myMap.get(ch)+1);
			else{
				myMap.put(ch,1);
			}
		}
		
		for(char key:myMap.keySet()){
			if(res<myMap.get(key))
				res=myMap.get(key);
		}
		return res;
	}
	
	
	public boolean is_flag(int[] nums,int start){
		
		for(int i=0;i<start;i++){
			if(nums[i]>0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1052 obj=new Main_1052();
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		scan.nextLine();
		int[] nums=new int[T];
		int start=0;
		while(T>0){
			String line=scan.nextLine();
			line=line.trim();
			int k=scan.nextInt();
			
			char[] str=line.toCharArray();
			int start1=0;
			int start2=line.length()-k;
			//int[] res=new int[k+1];
			//obj.solve(str,res,start1,start2,k);
			int num_1=obj.resolve(str, k);
			nums[start++]=num_1;
			//System.out.println(res[k]);
			scan.nextLine();
			T--;
		}
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		scan.close();
	}

}
