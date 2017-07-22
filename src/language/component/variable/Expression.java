package language.component.variable;

import language.component.operator.Operation;

/**
 * Created by Ana on 21.07.2017.
 */
public abstract class Expression implements Container, Operation {
    protected Container first;
    protected Container second;

    public Expression(Container first, Container second) {
        this.first = first;
        this.second = second;
    }

    public Expression(){

    }

}
