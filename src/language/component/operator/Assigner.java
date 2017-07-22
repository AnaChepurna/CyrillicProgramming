package language.component.operator;

import language.component.variable.Container;
import language.component.variable.Variable;

/**
 * Created by Ana on 21.07.2017.
 */
public class Assigner implements Operation {
    private Variable var;
    private Container container;

    public Assigner(Variable var, Container container) {
        this.var = var;
        this.container = container;
    }

    @Override
    public void run() {
        if (container instanceof Operation)
            ((Operation) container).run();
        var.setValue(container.getValue());
    }
}
