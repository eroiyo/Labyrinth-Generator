import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.math.*;
public class GraphMesh {
	private ArrayList<HashMap<String,Integer>> list;
	private int anchor=0;
	private int height=0;
	private int numvertexs;
	private PriorityQueue<Edge> edgeL= new  PriorityQueue<Edge>(new EdgeComparator()); 
	private int edge_id=0;
	private int[] character;
	
	public GraphMesh(int anchor, int lenght) {
		this.numvertexs = anchor*lenght;
		this.anchor=anchor;
		this.height=lenght;
		this.list =new  ArrayList<HashMap<String,Integer>>();
		character = new int[this.numvertexs];
		for(int i=0; i<numvertexs; i++)
		{
			list.add(new HashMap<String,Integer>());
			character[i]=0;
		}
	}
	
	public void fullramdon()
	{
		int ramdon=0;
		for(int i=1; i<=height; i++)
		{
			for(int e=1; e<=anchor; e++)
			{
				
				if(i>1)
				{
					ramdon= (int) (Math.random() * 100) + 1;
					this.aristand_UP(i, e,ramdon,true);
				}
				if(e<anchor)
				{
					ramdon= (int) (Math.random() * 100) + 1;
					this.aristand_RIGHT(i, e, ramdon,true);
				}
			}
		}
	}
	class EdgeComparator implements Comparator<Edge>{ 
        
        // Overriding compare()method of Comparator  
                    // for descending order of cgpa 
        public int compare(Edge s1, Edge s2) { 
            if (s1.weight > s2.weight) 
                return 1; 
            else if (s1.weight < s2.weight) 
                return -1; 
                            return 0; 
            } 
    }

	public void addVertex(int number) {
		numvertexs=numvertexs++;
				list.add(new HashMap<String,Integer>());
			}
	
	public void delVertex(int id) {
		list.remove(id);
	}

	public void aristand_UP(int row, int column,int weight,boolean conditional)
	{ if((column>=1 && column<=anchor) || conditional==false)
	{
		if(((row>1) && (row<=height))|| conditional==false)
		{
			int rowo=row;
		row = row*anchor;
		row=row-anchor;
		int vertex =row+column;
		
		
		Edge newA= new Edge((vertex),(vertex-anchor),weight,rowo,column,"up");
		Edge newB= new Edge((vertex-anchor),(vertex),weight,rowo-1,column,"down");
		
		
		edge_id++;
		this.list.get(vertex-1).put("up",edge_id);
		edgeL.add(newA);
		character[vertex-1]=character[vertex-1]+8;
		
		edge_id++;
		this.list.get((vertex-anchor)-1).put("down", edge_id);
		edgeL.add(newB);
		character[(vertex-anchor)-1]=character[(vertex-anchor)-1]+4;
		}
	}
			else{System.out.println("up error");}
	}
	public void aristand_DOWN(int row, int column,int weight,boolean conditional)
	{
		if((row>0 && row<=height) || conditional==false)
		{
		if(((column<anchor) &&  (column >=1)) || conditional==false)
		{

		int rowo=row;
		row = row*anchor;
		row=row-anchor;
		int vertex =row+column;
		
		Edge newA= new Edge((vertex-1),(vertex+anchor)-1,weight,rowo,column,"down");
		Edge newB= new Edge((vertex+anchor)-1,(vertex-1),weight,rowo+1,column,"up");
		
		
		edge_id++;
		this.list.get(vertex-1).put("down",edge_id);
		edgeL.add(newA);
		character[vertex-1]=character[vertex-1]+4;
		
		edge_id++;
		this.list.get((vertex+anchor)-1).put("up", edge_id);
		edgeL.add(newB);
		character[vertex+anchor-1]=character[vertex+anchor-1]+8;
		}
		}
		else{System.out.println("down error");}
	}
	public void aristand_RIGHT(int row, int column,int wheight, boolean conditional)
	{
		if((row>0 && row<=height) || conditional==false)
		{
		if(((column<anchor) &&  (column >=1)) || conditional==false)
		{
		int rowo=row;
		row = row*anchor;
		row=row-anchor;
		int vertex =row+column;
		
		
		Edge newA= new Edge((vertex),vertex+1,wheight,rowo,column,"right");
		Edge newB= new Edge(vertex+1,(vertex),wheight,rowo,column+1,"left");
		
		
		edge_id++;
		this.list.get(vertex-1).put("right",edge_id);
		edgeL.add(newA);
		character[vertex-1]=character[vertex-1]+1;
		
		edge_id++;
		this.list.get(vertex).put("left", edge_id);
		edgeL.add(newB);
		character[vertex]=character[vertex]+2;
		}
		}
				else{System.out.println("right error");}
	}
	public void aristand_LEFT(int row, int column,int wheight, boolean conditional)
	{
		if((row>0 && row<=height) || conditional==false)
		{
		if(((column<anchor) &&  (column >=1)) || conditional==false)
		{
		int rowo=row;
		row = row*anchor;
		row=row-anchor;
		int vertex =row+column;
		
		
		Edge nuevaA= new Edge((vertex-1),(vertex-2),wheight,rowo,column,"left");
		Edge nuevaB= new Edge((vertex-2),(vertex-1),wheight,rowo,column-1,"right");
		
		
		edge_id++;
		this.list.get(vertex-1).put("left",edge_id);
		edgeL.add(nuevaA);
		character[vertex-1]=character[vertex-1]+2;
		
		edge_id++;
		this.list.get(vertex-2).put("right", edge_id);
		edgeL.add(nuevaB);
		character[vertex-2]=character[vertex-2]+1;
		}
		}
		else {System.out.println("left error");}
	}
	
	public int vertex_grade(int id)
	{
		return this.list.get(id-1).size();
	}

	public int vertexQ() {
		return this.numvertexs;
	}
	public HashMap<String,Integer> debug(int id)
	{
		return this.list.get(id-1);
	}
	
	public void show()
	{
		int d=0;
		for(int i=1; i<=height; i++)
		{
			System.out.println("");
			for(int e=1; e<=anchor; e++)
			{
				System.out.print((decode(character[d])));
				d++;
			}
		}
	}
	 static public char decode (int numer) {
		switch (numer)
		{
		default:
			return ' ';
		case 1:
			return '╶';
		case 2:
			return '╴';
		case 3:
			return '─';
		case 4:
			return '╷';
		case 5:
			return '┌';
		case 6:
			return '┐';
		case 7:
			return '┬';
		case 8:
			return '╵';
		case 9:
			return '└';
		case 10:
			return '┘';
		case 11:
			return '┴';
		case 12:
			return '│';
		case 13:
			return '├';
		case 14:
			return '┤';
		case 15:
			return '┼';
		}
		
			
			
				
		}
	 boolean find( int Arr[ ], int A, int B)   {
	 if(Arr[A] == Arr[B])
	 return true;
	 else
	 return false;   
	 }
	 
	 
	 void union(int Arr[ ], int N, int A, int B)
	 {
	     int TEMP = Arr[ A ];
	 for(int i = 0; i < N;i++)
	     {
	     if(Arr[ i ] == TEMP)
	     Arr[ i ] = Arr[ B ]; 
	     }
	 }
	 void addEdge(Edge edge)
	 {
		 switch (edge.direction)
		 {
		 case "up":
			 this.aristand_UP(edge.row,edge.column, edge.weight,false);
			 break;
		 case "down":
			 this.aristand_DOWN(edge.row,edge.column, edge.weight,false);
			 break;
		 case "right":
			 this.aristand_RIGHT(edge.row,edge.column, edge.weight,false);
			 break;
		 case "left":
			 this.aristand_LEFT(edge.row,edge.column, edge.weight,false);
			 break;
		 }
	 }
	 void addEdgeF(Edge edge)
	 {
		 int d=0;
		 int i=0;
		 int e=0;
			for(i=0; i<=height; i++)
			{
				for(e=0; e<=anchor; e++)
				{
					d++;
					if(d==edge.vertex_A())
						break;
				}
				if(d==edge.vertex_A())
					break;
			}
		 switch (edge.direction)
		 {
		 case "up":
			 this.aristand_UP(i,e, edge.weight,false);
			 break;
		 case "down":
			 this.aristand_DOWN(i,e, edge.weight,false);
			 break;
		 case "right":
			 this.aristand_RIGHT(i,e, edge.weight,false);
			 break;
		 case "left":
			 this.aristand_LEFT(i,e, edge.weight,false);
			 break;
		 }
	 }
	 public GraphMesh kruskal()
	 {
		 GraphMesh minimun = new GraphMesh(this.anchor, this.height);
		 
		 int[] Arr =new int[this.numvertexs];
		 
		    for(int i = 0;i<this.numvertexs;i++) {
		    Arr[ i ] = i ;
		    }
		    
		    while(edgeL.isEmpty()!= true)
		    {
		    Edge a=edgeL.poll();
		    if(find(Arr,a.vertex_A()-1,a.vertex_B()-1) ==false)
		    		{
		    union(Arr,this.numvertexs,a.vertex_A()-1,a.vertex_B()-1);
		    minimun.addEdge(a);
		    		}
		    }
		 return minimun;
	 }
	}