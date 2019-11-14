import java.rmi.*;
import java.rmi.server.*;

import java.io.*; 
import java.util.*; 
public class ServiceAdder extends UnicastRemoteObject implements ServerInterface
{
protected ServiceAdder()throws RemoteException{
	super();
}
//////////////////////////////////////////////////////////
	static HashMap<String, LinkedList<Integer>[]> graphlst = new HashMap<String, LinkedList<Integer>[]>();
	static class Graph 
	{ 
		int vertices; 
		LinkedList<Integer> adjList[]; 
		
		
		Graph(int vertices) 
		{ 
			this.vertices = vertices; 

			this.adjList = new LinkedList[vertices]; 
			
			for(int i = 0; i < vertices ; i++){ 
				this.adjList[i] = new LinkedList<Integer>(); 
			} 
		} 
	} 
	
	static void addEdge(Graph graph, int src, int dest) 
	{ 
		
		graph.adjList[src].add(dest); 
		graph.adjList[dest].add(src); 
	} 
	
	static ArrayList<String>  printGraph(Graph graph) 
	{	 
		ArrayList<String> graph_rep = new ArrayList<String>();
		for(int v = 0; v < 10; v++) 
		{ 
			String temp;
			//System.out.println("List of vertex at vertex "+ v); 
			temp="List of vertex at vertex "+ v;
			graph_rep.add(temp);
			//System.out.print("Front"); 
			temp="Front:";
			//graph_rep.add(temp);
			for(Integer pCrawl: graph.adjList[v]){ 
				//System.out.print(" -> "+pCrawl); 
				temp+="->"+pCrawl;
				graph_rep.add(temp);
			} 
			//System.out.println("\n"); 
		} 
		return graph_rep;
	} 
    static int BFS(int src,int dest,Graph graph)
    {
        boolean[]visited= new boolean[graph.vertices]; 
        LinkedList<Integer> q = new LinkedList<Integer>(); 
        visited[src]=true; 
        q.add(src); 
        int dist=0;
		boolean flag=false;
        while (q.size() != 0) 
        { 
			int size=q.size();
			while(size>0)
			{
				int s = q.poll(); 
				if(s==dest)
				{
					flag=true;
					break;
				}
				
				Iterator<Integer> i = graph.adjList[s].listIterator(); 
				
				while (i.hasNext()) 
				{ 
					int n = i.next(); 
					if (!visited[n]) 
					{ 
						visited[n] = true; 
						q.add(n); 
					} 
			
				}
				size--;
			}
			if(flag)
			break;
			 dist++;
        } 
		if(!flag)
		return -1;
            return dist;
  }

//////////////////////////////////////////////////////////
public String add_edge(String graph_name,String node1,String node2) throws Exception
{
		int V = 1000; 
		if(!graphlst.containsKey(graph_name))
		{
			
			Graph graph = new Graph(V); 
			int n1 = Integer.parseInt(node1);	
			int n2 = Integer.parseInt(node2);	
			addEdge(graph,n1,n2); 
			//addEdge(graph, 0, 4); 
			graphlst.put(graph_name,graph.adjList);
		}
		else
		{
			Graph graph1 = new Graph(V); 
			
			graph1.adjList=graphlst.get(graph_name);
			// addEdge(graph, 0, 1);
			int nn1 = Integer.parseInt(node1);	
			int nn2 = Integer.parseInt(node2);	
			addEdge(graph1,nn1,nn2);  
			//addEdge(graph1, 0, 4); 
			String valueToBeRemoved=graph_name;
			graphlst.entrySet().removeIf(entry -> (valueToBeRemoved.equals(entry.getValue()))); 
			graphlst.put(graph_name,graph1.adjList);
		}
		
      
	return "Succesful addition of edges";
}
public int shortest_distance(String graph_name,String node1,String node2) throws Exception
{
	//BFS(0,1,graph);
	int V=1000;
	Graph g=new Graph(V);
	if(graphlst.containsKey(graph_name))
	{
		g.adjList=graphlst.get(graph_name);
		int nn1 = Integer.parseInt(node1);	
		int nn2 = Integer.parseInt(node2);
		int dist=BFS(nn1,nn2,g);
		return dist;		
	}
 	return 0;
}

public ArrayList<String> get_graph(String graph_name) throws Exception
{
	int V=1000;
	Graph g1=new Graph(V);
	if(graphlst.containsKey(graph_name))
	{
		g1.adjList=graphlst.get(graph_name);
			
	}
 	return printGraph(g1);
}
}
