package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_1138 {

	static class node implements Comparable<node> {
		int id;
		int x;
		int y;

		public node(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(node n) {
			// TODO Auto-generated method stub
			if (this.x > n.x)
				return 1;
			else if (this.x < n.x)
				return -1;
			else
				return 0;
		}
	}

	class distance {
		int id_1;
		int dis;

		public distance(int id_1, int dis) {
			this.id_1 = id_1;
			this.dis = dis;
		}
	}

	public void swap(node[] ns) {
		for (node n : ns) {
			int tmp = n.x;
			n.x = n.y;
			n.y = tmp;
		}
	}

	public void build(List<List<distance>> list, node[] ns) {
		Arrays.sort(ns);
		int len = ns.length;
		for (int i = 1; i < len; i++) {
			int pre = ns[i - 1].id;
			int cur = ns[i].id;

			distance dis = new distance(pre, ns[i].x - ns[i - 1].x);
			list.get(cur).add(dis);
			distance dis_1 = new distance(cur, ns[i].x - ns[i - 1].x);
			list.get(pre).add(dis_1);
		}
	}

	public int solve_1(List<List<distance>> map) {
		int len = map.size();
		int start = 0;
		int[] dis = new int[len];
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(start);
		boolean[] flag = new boolean[len];
		flag[0] = true;

		for (int i = 1; i < len; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		while (list.size() > 0) {
			int top = list.pollFirst();

			flag[top] = false;
			List<distance> ll = map.get(top);
			for (int i = 0; i < ll.size(); i++) {
				distance dd = ll.get(i);
				int index = dd.id_1;

				if (dis[index] > dis[top] + dd.dis) {
					dis[index] = dis[top] + dd.dis;
					if (flag[index] == false) {
						list.add(index);
						flag[index] = true;
					}
				}
			}

		}
		return dis[len - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1138 obj = new Main_1138();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		node[] ns = new node[T];
		List<List<distance>> list_map = new ArrayList<List<distance>>();

		for (int i = 0; i < T; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			list_map.add(new ArrayList<distance>());
			ns[i] = new node(i, x, y);
		}

		obj.build(list_map, ns);
		obj.swap(ns);
		obj.build(list_map, ns);

		int dis = obj.solve_1(list_map);
		System.out.println(dis);
		scan.close();
	}

}
