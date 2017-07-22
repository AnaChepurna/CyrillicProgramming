package language.component.variable;

/**
 * Created by Ana on 21.07.2017.
 */
public class BooleanExpression extends Expression {
    private boolean value;
    private int firstValue;
    private int secondValue;
    private Act act;

    public BooleanExpression(boolean value) {
        this.value = value;
    }

    public BooleanExpression(Container first, Container second, Act act) throws IllegalArgumentException {
        super(first, second);
        this.act = act;
    }

    private boolean equal() {
        return firstValue == secondValue;
    }

    private boolean less() {
        return firstValue < secondValue;
    }

    private boolean more () {
        return firstValue > secondValue;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void run() {
        if (act == Act.NONE)
            value = first.getValue();
        else {
            firstValue = first.getValue();
            secondValue = second.getValue();
            if (act == Act.MORE)
                value = more();
            else if (act == Act.LESS)
                value = less();
            else if (act == Act.EQUAL)
                value = equal();
            else throw new IllegalArgumentException();
        }
    }

    public enum Act {
        MORE, LESS, EQUAL, NONE
    }
}
