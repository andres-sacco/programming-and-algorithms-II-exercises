package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;


// Crear un almacen de acciones organizandolos de tal forma que puedas procesar los últimos ingresados o los más antiguos según lo necesites.
// Considerandos:
// Se deben usar al menos dos TDA distintos.
// Garantizar que no se pierdan datos al mostrar el contenido
public class AdditionalDictionaryExercise46 {

    private static QueueADT queueData;
    private static StackADT stackData;
    private static SimpleDictionaryADT dictionaryData;
    private static int dataCounter;

    public static void main(String[] args) {

        init();
        addData("Guardar", "Archivo 1");
        addData("Imprimir", "Archivo 2");
        addData("Borrar", "Archivo 3");

        showStorage();

        processOldestData();
        processNewestData();
    }

    public static void init () {
        queueData = new StaticQueueADT();
        stackData = new StaticStackADT();
        dictionaryData = new StaticSimpleDictionaryADT();
        dataCounter = 0;
    }

    // Metodo para agregar un dato al almacén
    public static void addData(String data, String details) {
        dataCounter++;
        queueData.add(dataCounter);
        stackData.add(dataCounter);
        dictionaryData.add(dataCounter, details.hashCode()); // Guardamos los detalles con el hash

        System.out.println("Dato agregado: " + data + " - Detalles: " + details);
    }

    // Metodo para obtener el dato más antiguo (FIFO)
    public static void processOldestData() {
        if (!queueData.isEmpty()) {
            int dataId = queueData.getElement();
            queueData.remove();
            String details = getDataDetails(dataId);
            System.out.println("Dato más antiguo procesado: " + details);
        } else {
            System.out.println("No hay datos disponibles.");
        }
    }

    // Metodo para obtener el dato más reciente (LIFO)
    public static void processNewestData() {
        if (!stackData.isEmpty()) {
            int dataId = stackData.getElement();
            stackData.remove();
            String details = getDataDetails(dataId);
            System.out.println("Dato más reciente procesado: " + details);
        } else {
            System.out.println("No hay datos disponibles.");
        }
    }

    // Metodo auxiliar para obtener los detalles de un dato desde el diccionario
    private static String getDataDetails(int dataId) {
        int detailsHash = dictionaryData.get(dataId);
        return String.valueOf(detailsHash); // Convertimos el hash en String (ejemplo simple)
    }

    // Metodo para mostrar los datos almacenados sin alterar su estado
    public static void showStorage() {
        System.out.println("Datos en el almacén (FIFO):");
        QueueADT tempQueue = QueueADTUtil.copy(queueData);
        while (!tempQueue.isEmpty()) {
            int dataId = tempQueue.getElement();
            String details = getDataDetails(dataId);
            System.out.println("Dato: " + details);
            tempQueue.remove();
        }
    }
}
