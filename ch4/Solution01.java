import java.util.LinkedList;
public class Solution01 {
	class Graph{
		private Node[] nodes;
		public Node[] getNodes(){
			return nodes;
		}
	}
enum State{Unvisited,Vistied,Visiting;}

boolean existRoute(Graph g,Node begin,Node end){
	if(begin==end) return true;
	LinkedList<Node> queue=new LinkedList<Node>();
	for(Node s:g.getNodes()) {
		s.setState(State.Unvisited);
	}
	begin.setState(State.Visiting);
	queue.add(begin);
	Node firstNode;
	while(!queue.isEmpty()){
		firstNode=queue.removeFirst();
		if(firstNode!=null){
			for(Node nextNode:firstNode.getAdjacent()){
				if(nextNode.getState()==State.Unvisited){
					if(nextNode==end){
						return true;
					}else{
						nextNode.setState(State.Visiting);
						queue.add(nextNode);
					}
				}
			}
			firstNode.setState(State.Vistied);
		}
	}
	return false;
}
	public static void main(String[] args) {

	}

}
