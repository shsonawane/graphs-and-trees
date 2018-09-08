
public class Prims {

    int[][] graph ;
    int[] visited;

    public Prims(int[][] G) {
        graph = G;
        visited = new int[G.length];
        int u = 0, v = 0;
        int total = 0;
        for (int i = 0; i < G.length; i++) {
            visited[i] = 0;
            for (int j = 0; j < G.length; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        visited[0] = 1;
        int min;
        System.out.println("V1\tV2\tWeight");
        for (int c = 0; c < G.length-1; c++) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < G.length; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < G.length; j++) {
                        if (visited[j] == 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }
            visited[v] = 1;
            total += min;
            graph[u][v] = graph[u][v] = Integer.MAX_VALUE;
            System.out.println( u + "\t" + v + "\t" + min);
        }
        System.out.println("The total weight of the spanning tree is " + total);
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
        
        new Prims(g);
    }

}
