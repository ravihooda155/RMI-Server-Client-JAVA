import java.rmi.*;
import java.util.*;
public interface ServerInterface extends Remote
{
public String add_edge(String graph_name,String node1,String node2)throws Exception;
public int shortest_distance(String graph_name,String node1,String node2)throws Exception;

public  ArrayList<String> get_graph(String graph_name)throws Exception;
}
