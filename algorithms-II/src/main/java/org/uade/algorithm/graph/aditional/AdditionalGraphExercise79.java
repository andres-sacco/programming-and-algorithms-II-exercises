package org.uade.algorithm.graph.aditional;


import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un grafo dirigido y un conjunto de rutas almacenadas en un Diccionario Multiple cada clave es un nodo y los valores son los nodos con los que se comunica. Mostrar cuales nodos se comunican en ambas estructuras.
public class AdditionalGraphExercise79 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();
        MultipleDictionaryADT routes = new StaticMultipleDictionaryADT();

        // Grafo dirigido
        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);

        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 1, 1);
        graph.addEdge(2, 4, 1);

        routes.add(1, 2);
        routes.add(2, 3);
        routes.add(3, 4);
        routes.add(4, 1);
        routes.add(2, 4);

        SetADT commonNodes = findCommonCommunications(graph, routes);

        // Mostrar nodos en común
        while (!commonNodes.isEmpty()) {
            int node = commonNodes.choose();
            commonNodes.remove(node);
            System.out.println("Nodo en común: " + node);
        }
    }

    public static SetADT findCommonCommunications(GraphADT graph, MultipleDictionaryADT routes) {
        SetADT commonNodes = new StaticSetADT(); // Conjunto de nodos en común
        SetADT graphVertices = SetADTUtil.copy(graph.getVertxs()); // Copia de los vértices del grafo

        while (!graphVertices.isEmpty()) {
            int node = graphVertices.choose();
            graphVertices.remove(node);

            if (contains(routes.getKeys(),(node))) {
                SetADT graphConnections = getGraphConnections(graph, node);
                SetADT routeConnections = arrayToSet(routes.get(node)); 

                while (!graphConnections.isEmpty()) {
                    int target = graphConnections.choose();
                    graphConnections.remove(target);

                    if (contains(routeConnections, target)) { 
                        commonNodes.add(node);
                        break;
                    }
                }
            }
        }
        return commonNodes;
    }

    private static boolean contains(SetADT routeConnections, int target) {
        SetADT routeConnectionsTemp = SetADTUtil.copy(routeConnections);

        boolean found = false;

        while (!routeConnectionsTemp.isEmpty()) {
            int value = routeConnectionsTemp.choose();
            routeConnectionsTemp.remove(value);

            if (value == target) {
                found = true;
            }
        }

        return found;
    }


    private static SetADT arrayToSet(int[] values) {
        SetADT set = new StaticSetADT();
        for (int value : values) {
            set.add(value);
        }
        return set;
    }

    private static SetADT getGraphConnections(GraphADT graph, int node) {
        SetADT connections = new StaticSetADT();
        SetADT allVertices = SetADTUtil.copy(graph.getVertxs());

        while (!allVertices.isEmpty()) {
            int target = allVertices.choose();
            allVertices.remove(target);

            if (graph.existsEdge(node, target)) {
                connections.add(target);
            }
        }
        return connections;
    }

}
