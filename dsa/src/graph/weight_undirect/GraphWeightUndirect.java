package graph.weight_undirect;

import graph.unweight_undirect.Classroom;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphWeightUndirect {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);

        for(int i=0; i < graph[2].size(); i++) {
           Edge edge = graph[2].get(i);

            System.out.println("Destination: " + edge.destination+ " Weight: " + edge.weight);
        }

    }
}
