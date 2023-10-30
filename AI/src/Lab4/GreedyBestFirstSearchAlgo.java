package Lab4;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> explored = new HashSet<Node>();
		frontier.offer(root);

		while (!frontier.isEmpty()) {
			Node curr = frontier.poll();
			explored.add(curr);
			if (curr.getLabel().equals(goal))
				return curr;

			List<Edge> childrens = curr.getChildren();
			for (Edge e : childrens) {
				Node child = e.getEnd();
				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(curr);
					child.setG(curr.getG() + e.getWeight());
					frontier.offer(child);
				}
			}
		}
		return null;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdmissible(Node root, String goal) {
		// TODO Auto-generated method stub
		return false;
	}

}
