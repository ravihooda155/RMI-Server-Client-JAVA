# RMI-Server-Client-JAVA



## Code Files

```
- Server.java
- Client.java
- ServerInterface.java
- ServerAdder.java

```

## Execution
```
=> Compile both server and client code by running commands.
=> javac Client.java
=> javac Server.java
=> Run Server code on the server machine.
=> Run client code on the client machine.
=> Command for running
=> java Client
=> java Server
=> rmiregistry &


=======================================================================
 Menu
=======================================================================
=> Add Edges In Graph : add_edge graph_name node1 node2
=> shortest distance in graph : shortest_distance graph_name node1 node2 ||
=> Printing graph : get_graph graph_name

```

## Implementation Details

```
=> After running both server and client,server will handle the commands that were fired by client.
=> Interface is implemented at the server side and method is invoked by client using interface.
```

## Command Details

```
=> add_edge graph_name node1 node2:
This command will add the edge between two nodes of the corresponding graph specified in
the command.
=> shortest_distance graph_name node1 node2
This command will return between two nodes specified of corresponding graph.BFS
algorithm is implemented to calculate the distance.
=> get_graph graph_name :
Graph structure of graph mentioned will be printed at the console.
```
