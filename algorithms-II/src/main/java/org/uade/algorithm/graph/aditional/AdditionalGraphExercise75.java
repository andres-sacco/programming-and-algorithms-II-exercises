package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.SetADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Dado un diccionario simple se lo quiere convertir en un grafo considerando:
// Las claves representan a los vertices
// Los valores son con que vertices se conectan
// Todas las aristas tienen un valor de 1
public class AdditionalGraphExercise75 {

    public static void main(String[] args) {
        SimpleDictionaryADT dict = new StaticSimpleDictionaryADT();
        dict.add(1, 2);
        dict.add(2, 3);
        dict.add(3, 4);
        dict.add(4, 1);

        GraphADT graph = convertDictToGraph(dict);

        System.out.println("Vértices del grafo: " );
        SetADTUtil.print(graph.getVertxs());

        System.out.println("Existe arista (1 -> 2): " + graph.existsEdge(1, 2));
        System.out.println("Existe arista (2 -> 3): " + graph.existsEdge(2, 3));
        System.out.println("Existe arista (3 -> 4): " + graph.existsEdge(3, 4));
        System.out.println("Existe arista (4 -> 1): " + graph.existsEdge(4, 1));
    }

    public static GraphADT convertDictToGraph(SimpleDictionaryADT dict) {
        GraphADT graph = new StaticGraphADT();

        SimpleDictionaryADT dictTemp = SimpleDictionaryADTUtil.copy(dict);

        SetADT keys = dictTemp.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            keys.remove(key);
            graph.addVertx(key);

            int value = dictTemp.get(key);
            graph.addVertx(value);
            graph.addEdge(key, value, 1);
        }
        return graph;
    }
}
