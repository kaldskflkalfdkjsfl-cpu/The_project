package advanced;

import java.util.*;

/**
 * Professional Weighted Graph with Dijkstra's Shortest Path Algorithm.
 */
public class ProfessionalGraph {
    private class Edge {
        int to, weight;
        Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }

    private Map<Integer, List<Edge>> adj = new HashMap<>();

    public void addEdge(int u, int v, int w) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, w));
    }

    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dists = new HashMap<>();
        
        pq.add(new int[]{start, 0});
        dists.put(start, 0);

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if(d > dists.getOrDefault(u, Integer.MAX_VALUE)) continue;

            for(Edge e : adj.getOrDefault(u, new ArrayList<>())) {
                if(dists.getOrDefault(e.to, Integer.MAX_VALUE) > d + e.weight) {
                    dists.put(e.to, d + e.weight);
                    pq.add(new int[]{e.to, dists.get(e.to)});
                }
            }
        }
        System.out.println("Shortest distances from node " + start + ": " + dists);
    }
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        visited.add(start);
        q.add(start);

        System.out.print("BFS Traversal: ");
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (Edge e : adj.getOrDefault(u, new ArrayList<>())) {
                if (!visited.contains(e.to)) {
                    visited.add(e.to);
                    q.add(e.to);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        System.out.print("DFS Traversal: ");
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int u, Set<Integer> visited) {
        visited.add(u);
        System.out.print(u + " ");
        for (Edge e : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited.contains(e.to)) {
                dfsRecursive(e.to, visited);
            }
        }
    }
}
