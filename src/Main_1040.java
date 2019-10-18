import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1040 {

	static class Vector{
		int start;
		int end;
		public Vector(int s,int e){
			this.start=s;
			this.end=e;
		}
	}
	
	public int multiply(Vector v1,Vector v2){
		int res=0;
		res=v1.start*v2.start+v1.end*v2.end;
		return res;
	}
	
	public boolean parallel(Vector v1,Vector v2){
		if(v1.start==0&&v2.start==0)
			return true;
		return v1.end*v2.start==v1.start*v2.end;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1040 obj=new Main_1040();
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		while(T>0){
			List<Vector> list=new ArrayList<Vector>();
			for(int i=0;i<4;i++){
				int s1=scan.nextInt();
				int e1=scan.nextInt();
				int s2=scan.nextInt();
				int e2=scan.nextInt();
				int s=s2-s1;
				int e=e2-e1;
				Vector v=new Vector(s,e);
				list.add(v);
			}
			int parallel=0;
			int vertical=0;
			Vector v=list.get(0);
			for(int i=1;i<4;i++){
				if(obj.multiply(v, list.get(i))==0)
					vertical++;
				if(obj.parallel(v, list.get(i)))
					parallel++;
			}
			if(parallel==1&&vertical==2)
				System.out.println("YES");
			else{
				System.out.println("NO");
			}
			T--;
		}
	}

}
