package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1148 {
	String[] months={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"};
	public int month2num(String month){
		for(int i=0;i<months.length;i++){
			if(months[i].equals(month))
				return i;
		}
		return -1;
	}
		
	public int solve(int year1,int month1,int day1,int year2,int month2,int day2){
		if(month1<1 || (month1==1 && day1<=29))
			year1--;
		if(month2<1 || (month2==1 && day2<29))
			year2--;
		int res=0;
		res=res-( year1/4 - year1/100 + year1/400);
		res=res+ ( year2/4 - year2/100 + year2/400);
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Main_1148 obj = new Main_1148();
		int T=scan.nextInt();
		scan.nextLine();
		List<Integer> list=new ArrayList<Integer>();
		while(T>0){
			String str1=scan.nextLine();
			String str2=scan.nextLine();
			
			String[] strs=str1.split(",");
			int year1 = Integer.parseInt(strs[1].trim());
			String[] tmp_strs=strs[0].split(" ");
			String month_str=tmp_strs[0].trim();
			int month1=obj.month2num(month_str);
			int day1=Integer.parseInt(tmp_strs[1].trim());
			
			String[] strs_2=str2.split(",");
			int year2 = Integer.parseInt(strs_2[1].trim());
			String[] tmp_strs_2=strs_2[0].split(" ");
			String month_str_2=tmp_strs_2[0].trim();
			int month2=obj.month2num(month_str_2);
			int day2=Integer.parseInt(tmp_strs_2[1].trim());
			
			list.add(obj.solve(year1, month1, day1, year2, month2, day2));
			T--;
		}
		for(int i=0;i<list.size();i++){
			System.out.println("Case #"+(i+1)+": "+list.get(i));
		}
	}

}
