package graph.diconnected_subgraph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphIII {
    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));


        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[5].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int vertices, boolean visited[], int start){
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(start);
       while(!queue.isEmpty()){
          int current = queue.remove();
           if(visited[current] == false){
               System.out.printf(current+ " ");
               visited[current] = true;

               for(int i=0; i<graph[current].size(); i++){
                   Edge edge = graph[current].get(i);
                   queue.add(edge.destination);
               }
           }
       }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);

        //disconnected graph
        boolean visited[] = new boolean[vertices];
        for(int i=0; i<vertices; i++){
            if(visited[i]==false){
                bfs(graph, vertices, visited, i);
            }
        }
        System.out.println();
    }
}
