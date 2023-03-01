import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tree = new int[N+1][2]; // 자식 노드를 담을 배열
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int self = st.nextToken().charAt(0)-'0'-16;
			int left = st.nextToken().charAt(0)-'0'-16;
			int right = st.nextToken().charAt(0)-'0'-16;

			tree[self][0] = left;
			tree[self][1] = right;			
		}		
		

		preOrder(1, tree);
		System.out.println();
		inOrder(1, tree);
		System.out.println();
		PostOrder(1, tree);
	}

	
	private static void PostOrder(int i, int[][] tree) {
		if( i > tree.length ) {
			return;
		}
		
		if(tree[i][0] != -18) {
			PostOrder(tree[i][0], tree);
		}		
		if(tree[i][1] != -18) {
			PostOrder(tree[i][1], tree);
		}
		char value = (char)(i+16+'0');
		System.out.print(value);
	}

	private static void inOrder(int i, int[][] tree) {
		if( i > tree.length ) {
			return;
		}
		
		if(tree[i][0] != -18) {
			inOrder(tree[i][0], tree);
		}
		char value = (char)(i+16+'0');
		System.out.print(value);
		if(tree[i][1] != -18) {
			inOrder(tree[i][1], tree);
		}
	}

	private static void preOrder(int i, int[][] tree) {
		if( i > tree.length ) {
			return;
		}
		
		char value = (char)(i+16+'0');
		System.out.print(value);
		if(tree[i][0] != -18) {
			preOrder(tree[i][0], tree);
		}
		if(tree[i][1] != -18) {
			preOrder(tree[i][1], tree);
		}
	}	
	
}