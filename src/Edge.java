
public class Edge {
	private int vertex_A =0;
	private int vertex_B=0;
	public int weight=0;
	public int row;
	public int column;
	public String direction;
	
	public Edge(int vertex_A, int vertex_B, int weight,int row, int column, String direction)
	{
		this.vertex_A =vertex_A;
		this.vertex_B=vertex_B;
		this.weight=weight;
		this.row=row;
		this.column=column;
		this.direction=direction;
	}
	public int weight()
	{
		return this.weight;
	}
	public int vertex_A()
	{
		return this.vertex_A;
	}
	public int vertex_B()
	{
		return this.vertex_B;
	}
	public void show()
	{
		System.out.println("A= "+this.vertex_A+" B="+this.vertex_B+" direccion="+this.direction);
	}

}
