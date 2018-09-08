
import java.util.ArrayList;

public class Dijkstra {

    int V = 5;
    Integer dist[] = new Integer[V];
    Boolean[] ptset = new Boolean[V];

    public Dijkstra(int V) {
        this.V = V;
    }

    int minDistance() {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!ptset[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void initSingleSource(int src) {
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            ptset[i] = false;
        }
        dist[src] = 0;
    }

    void printSolution() {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    void dijkstra(int graph[][], int src) {
        initSingleSource(src);
        ArrayList<Integer> Q = new ArrayList<Integer>();
        for (int i = 0; i < V; i++) {
            Q.add(i);
        }
        while(!Q.isEmpty()) {
            Integer u = minDistance();
            Q.remove(u);
            ptset[u] = true;
            for (int v = 0; v < V; v++) {
                relax(u, v, graph[u][v]);
            }
        }
        printSolution();
    }

    void relax(int u, int v, int wt) {
        if (!ptset[v] && wt != 0  && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt) {
            dist[v] = dist[u] + wt;
        }
    }

    public static void main(String[] args) {

        int g[][] = new int[5][5];

        for (int u = 0; u < 5; u++) {
            for (int v = 0; v < 5; v++) {
                g[u][v] = 0;
            }
        }

        g[0][2] = 10;
        g[0][1] = 5;
        g[1][2] = 3;
        g[1][3] = 9;
        g[1][4] = 2;
        g[2][1] = 2;
        g[2][3] = 1;
        g[3][4] = 4;
        g[4][3] = 6;
        g[4][0] = 7;

        Dijkstra t = new Dijkstra(5);
        t.dijkstra(g, 0);
    }
}
