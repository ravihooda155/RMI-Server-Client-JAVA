import java.rmi.*;
import java.util.*;
public class Client {
	public static void main(String args[]) {
		try{
			ServerInterface st = (ServerInterface)Naming.lookup("rmi://0.0.0.0:6600/Add");
			String attr1,attr2,attr3,user_command,command_type;
			do
			{
			System.out.println("=================================================================================");
			System.out.println("Menu");
			System.out.println("=================================================================================");
			System.out.println("=> Add Edges In Graph :         || add_edge graph_name node1 node2	    ||");
			System.out.println("=> shortest distance in graph : || shortest_distance graph_name node1 node2 ||");
			System.out.println("=> Printing graph :             || get_graph graph_name                     ||");
			System.out.println("=================================================================================");
			System.out.println("             ");
			System.out.print("Command:");
			
			Scanner scn = new Scanner(System.in);
			user_command=scn.nextLine();
			String str[]=user_command.split("\\s+");
			command_type=str[0];
			switch(command_type)
			{
				case "add_edge":
								if(str.length!=4)
								{
									System.out.println("Enter appropriate command");
									break;
								}
								attr1=str[1];
								attr2=str[2];
								attr3=str[3];
								System.out.println("Mesg:-"+st.add_edge(attr1,attr2,attr3));

								break;

				case "shortest_distance":
								if(str.length!=4)
								{
									System.out.println("Enter appropriate command");
									break;
								}
								attr1=str[1];
								attr2=str[2];
								attr3=str[3];

								System.out.println("Shortest Distance Is :-"+st.shortest_distance(attr1,attr2,attr3));
								break;

				case "get_graph":
								if(str.length!=2)
								{
									System.out.println("Enter appropriate command");
									break;
								}
								attr1=str[1];
								ArrayList<String>graph_rep=new ArrayList<String>();
								graph_rep=st.get_graph(attr1);
								System.out.println("Graph Structure:");
								for(int i=0;i<graph_rep.size();i++)
								{
									System.out.println(graph_rep.get(i));
								}
								
								break;
			}

			//System.out.println(st.sum(25,8));
			}while(!command_type.equals("exit"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
