package Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node node) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(Node node, boolean rightToLeft) {
		// TODO Auto-generated method stub
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE, rightToLeft);
		System.out.println(v);
	}
	public int maxValue(Node node, int alpha, int beta, boolean rightToLeft) {
		if (node.isTerminal())
			return node.getValue();
		int v = Integer.MIN_VALUE;
		int newV = Integer.MIN_VALUE;

		List<Node> childrens = node.getChildren();
		Collections.sort(childrens, Node.LabelComparator);
		if (rightToLeft)
			Collections.reverse(childrens);
		List<Node> unexplored = new ArrayList<>(childrens);

		for (Node child : childrens) {
			unexplored.remove(child);
			newV = minValue(child, alpha, beta, rightToLeft);
			if (newV > v) {
				node.setBestNextMove(child);
				v = newV;
			}
			if (v >= beta) {
				if (!unexplored.isEmpty())
					System.out.println("Pruned node: " + unexplored);
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}
	public int minValue(Node node, int alpha, int beta, boolean rightToLeft) {
		if (node.isTerminal())
			return node.getValue();
		int v = Integer.MAX_VALUE;
		int newV = Integer.MAX_VALUE;

		List<Node> childrens = node.getChildren();
		Collections.sort(childrens, Node.LabelComparator);
		if (rightToLeft)
			Collections.reverse(childrens);
		List<Node> unexplored = new ArrayList<>(childrens);

		for (Node child : childrens) {
			unexplored.remove(child);
			newV = maxValue(child, alpha, beta, rightToLeft);
			if (newV < v) {
				node.setBestNextMove(child);
				v = newV;
			}
			if (v <= alpha) {
				if (!unexplored.isEmpty())
					System.out.println("Pruned node: " + unexplored);
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
	

}
