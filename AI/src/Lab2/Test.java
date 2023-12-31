package Lab2;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BFSAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println("BFS:	" + NodeUtils.printPath(result));
		
		ISearchAlgo algo2 = new DFSAlgo();
		Node result2 = algo2.execute(nodeS, "G");
		System.out.println("DFS:	" + NodeUtils.printPath(result2));
		
		ISearchAlgo algo3 = new UniformCostSearchAlgo();
		Node result3 = algo3.execute(nodeS, "G");
		System.out.print("UCS: ");
		NodeUtils.print(result3);
		
		System.out.println("LimitedDeepSeach");
		ISearchAlgo algo4 = new DeepLimitedSearchGraph();
		Node result4 = algo4.execute(nodeS, "G",2);
		System.out.println(NodeUtils.printPath(result4));
		System.out.println();
	}
}