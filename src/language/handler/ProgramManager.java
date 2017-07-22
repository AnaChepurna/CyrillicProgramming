package language.handler;

import language.component.operator.Operation;
import language.component.variable.Variable;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Ana on 21.07.2017.
 */
public class ProgramManager {
    private ArrayList<Operation> operations = new ArrayList<>();
    private TreeMap<String, Variable> variables = new TreeMap<>();

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public TreeMap<String, Variable> getVariables() {
        return variables;
    }

    public void start() {
        for (Operation d : operations) {
            d.run();
        }
    }
}
