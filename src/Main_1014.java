import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1014 {

	static class node {
		char value;
		List<node> list = new ArrayList<node>();
		int num;
		public node(char ch) {
			this.value = ch;
			this.num=0;
		}
	}

	public int calLeaf(node root) {
		int res = 0;
		List<node> list = new ArrayList<node>();
		list.add(root);
		while (list.size() > 0) {
			node n = list.get(0);

			list.remove(0);
			if (n.value != 0) {
				res+=n.num;
			}
			for (node tmpNode : n.list) {
				list.add(tmpNode);
			}
		}

		return res;
	}

	public void createTree(node root,List<String> listStr) {
		
		for(String str:listStr){
			node start=root;
			for(int i=0;i<str.length();i++){
				char ch=str.charAt(i);
				int flag=0;
				List<node> listNode=start.list;
				for(node tmpNode:listNode){
					if(tmpNode.value==ch){
						start=tmpNode;
						start.num++;
						flag=1;
						break;
					}
				}
				if(flag==0){
					node newNode=new node(ch);
					listNode.add(newNode);
					start=newNode;
					start.num++;
				}
				
			}
		}
	}

	public node findNode(node root, String str) {
		node res = new node('#');
		node start = root;
		int index = 0;
		while (index < str.length()) {
			char ch = str.charAt(index);
			List<node> nodeList = start.list;
			int tmp=index;
			for (int i = 0; i < nodeList.size(); i++) {
				if (ch == nodeList.get(i).value) {
					start=nodeList.get(i);
					index++;
					break;
				}
			}
			if(tmp==index)
				return res;
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1014 obj=new Main_1014();
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		scan.nextLine();
		node root=new node('#');
		List<String> listStr=new ArrayList<String>();
		for(int i=0;i<num;i++){
			String line=scan.nextLine();
			listStr.add(line);
		}
		obj.createTree(root, listStr);
		
		int prgm=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<prgm;i++){
			String line=scan.nextLine();
			node tmpNode=obj.findNode(root, line);
			if(tmpNode.value=='#'){
				System.out.println(0);
				continue;
			}
				
			//int res=obj.calLeaf(tmpNode);
			System.out.println(tmpNode.num);
		}
		scan.close();
	}

}
