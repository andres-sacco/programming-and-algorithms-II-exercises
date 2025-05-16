package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;

// Crea una aplicacion en la se pueda almacenar acciones y luego deshacerlas o rehacerlas.
// Considerandos:
// Se deben usar al menos dos TDA distintos.
// Garantizar que no se pierdan datos al mostrar el contenido.
public class AdditionalDictionaryExercise45 {

    private static QueueADT executedActions;
    private static StackADT undoneActions;
    private static SimpleDictionaryADT actionDetails;
    private static int actionCounter;

    public static void main(String[] args) {

        init();
        executeAction("Save", "File 1");
        executeAction("Print", "File 2");
        executeAction("Delete", "File 3");

        showHistory();

        undoAction();
        redoAction();
    }

    public static void init() {
        executedActions = new StaticQueueADT();
        undoneActions = new StaticStackADT();
        actionDetails = new StaticSimpleDictionaryADT();
        actionCounter = 0;
    }

    private static void executeAction(String actionType, String details) {
        actionCounter++;
        executedActions.add(actionCounter);
        actionDetails.add(actionCounter, actionType.hashCode());

        System.out.println("Executed Action: " + actionType + " - Details: " + details);
    }

    public static void undoAction() {
        if (!executedActions.isEmpty()) {
            int action = executedActions.getElement();
            executedActions.remove();
            undoneActions.add(action);

            String actionType = getActionType(action);
            System.out.println("Undone Action: " + actionType);
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public static void redoAction() {
        if (!undoneActions.isEmpty()) {
            int action = undoneActions.getElement();
            undoneActions.remove();
            executedActions.add(action);

            String actionType = getActionType(action);
            System.out.println("Redone Action: " + actionType);
        } else {
            System.out.println("No actions to redo.");
        }
    }

    private static String getActionType(int actionId) {
        int typeHash = actionDetails.get(actionId);
        return String.valueOf(typeHash);
    }

    public static void showHistory() {
        QueueADT auxQueue = QueueADTUtil.copy(executedActions);
        System.out.println("Action History:");
        while (!auxQueue.isEmpty()) {
            int actionId = auxQueue.getElement();
            String actionType = getActionType(actionId);
            System.out.println("Action: " + actionType);
            auxQueue.remove();
        }
    }

}
