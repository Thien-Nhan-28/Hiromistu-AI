package Lab4;

public class TestGBFS {
	public static void main(String[] args) {
		Node S = new Node("S", 6);
		Node A = new Node("A", 4);
		Node B = new Node("B", 4);
		Node C = new Node("C", 4);
		Node D = new Node("D", 3.5);
		Node E = new Node("E", 1);
		Node F = new Node("F", 1);
		Node G = new Node("G", 0);

		S.addEdge(A);
		S.addEdge(B);
		A.addEdge(C);
		B.addEdge(C);
		B.addEdge(D);
		C.addEdge(E);
		C.addEdge(D);
		E.addEdge(G);
		D.addEdge(F);
		F.addEdge(G);



		IInformedSearchAlgo gbfs = new GreedyBestFirstSearchAlgo();
		Node goal = gbfs.execute(S, "G");
		System.out.println(NodeUtils.printPath(goal));
	}
}
