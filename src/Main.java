import java.util.HashMap;

public class Main {
	
	

	public static void main(String[] args) throws Exception {
		GraphMesh graph =new GraphMesh (10,10);
		graph.fullramdon();
		graph.show();
		GraphMesh new_graph=graph.kruskal();
		new_graph.show();
	}
}