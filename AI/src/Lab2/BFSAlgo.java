package Lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node Child : children) {
				if (!frontier.contains(Child) && !explored.contains(Child)) {
					frontier.add(Child);
					Child.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		if (root.getLabel().equals(start)) {
			return root;
		}
		for (Node child : root.getChildrenNodes()) {
			Node result = execute(child, start, goal);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
