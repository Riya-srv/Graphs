import java.util.*;

public class BFS{
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,5));
        
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr + " ");
            visited[curr] = true;
            for(int i = 0 ; i < graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if (!visited[e.dest]) { 
                    q.add(e.dest);      
                    visited[e.dest] = true;
            }
        }
    }
}
    
    public static void main(String[] args) {
        /*
               1 --- 3
              /       \
            0          5 -- 6
            \         /
            2 ------ 4
         */
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
