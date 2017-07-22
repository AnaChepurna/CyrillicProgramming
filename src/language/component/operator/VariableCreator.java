package language.component.operator;

import language.component.variable.Variable;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Ana on 21.07.2017.
 */
public abstract class VariableCreator {

    public static void createVariable(TreeMap<String, Variable> map, String name, Type type) {

        switch (type) {
            case STRING:
                map.put(name, new Variable<String>(name));
                break;
            case BOOLEAN:
                map.put(name, new Variable<Boolean>(name));
                break;
            case INTEGER:
                map.put(name, new Variable<Integer>(name));
        }
    }

    public enum Type {
        INTEGER, BOOLEAN, STRING
    }
}
