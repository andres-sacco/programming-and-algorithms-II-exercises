package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.SetADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Dado un grafo dirigido, implementa un metodo que identifique las aristas críticas, es decir, aquellas cuya eliminación desconecta componentes del grafo o elimina caminos dirigidos entre ciertos nodos.
public class AdditionalGraphExercise77 {
    private static int time;

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();
        graph.addVertx(0);
        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 0, 1);
        graph.addEdge(1, 3, 1);

        findCriticalEdges(graph);
    }

    public static void findCriticalEdges(GraphADT graph) {
        int vertexCount = countElements(graph.getVertxs());
        boolean[] visited = new boolean[vertexCount];
        int[] disc = new int[vertexCount]; // Tiempos de descubrimiento de los nodos
        int[] low = new int[vertexCount];  // Menor tiempo de llegada alcanzable
        int[] parent = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            parent[i] = -1;
            visited[i] = false;
        }

        time = 0;

        SetADT vertices = graph.getVertxs();
        while (!vertices.isEmpty()) {
            int vertex = vertices.choose();
            vertices.remove(vertex);
            if (!visited[vertex]) {
                dfs(graph, vertex, visited, disc, low, parent);
            }
        }
    }

    private static void dfs(GraphADT graph, int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        SetADT neighbors = getNeighbors(graph, u);
        while (!neighbors.isEmpty()) {
            int v = neighbors.choose();
            neighbors.remove(v);

            if (!visited[v]) {
                parent[v] = u;
                dfs(graph, v, visited, disc, low, parent);

                low[u] = Math.min(low[u], low[v]);

                // Si el valor de low[v] es mayor que disc[u], (u, v) es una arista crítica
                if (low[v] > disc[u]) {
                    System.out.println("Arista crítica: " + u + " -> " + v);
                }
            } else if (v != parent[u]) {
                // Si el nodo ya fue visitado, actualizar el valor de low[u]
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    private static SetADT getNeighbors(GraphADT graph, int vertex) {
        SetADT neighbors = new StaticSetADT();
        SetADT allVertices = graph.getVertxs();

        while (!allVertices.isEmpty()) {
            int v = allVertices.choose();
            allVertices.remove(v);
            if (graph.existsEdge(vertex, v)) {
                neighbors.add(v);
            }
        }
        return neighbors;
    }

    private static int countElements(SetADT set) {
        int count = 0;
        SetADT tempSet = SetADTUtil.copy(set);
        while (!tempSet.isEmpty()) {
            tempSet.remove(tempSet.choose());
            count++;
        }
        return count;
    }

}
