package language.component.variable;

/**
 * Created by Ana on 21.07.2017.
 */
public class StringExpression extends Expression {
    private String value;
    private Act act;

    public StringExpression(Container first, Container second, Act act) throws IllegalArgumentException {
        super(first, second);
        this.act = act;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void run() {
        if (act == Act.TRANSFORM)
            value = first.getValue().toString();
        else {
            if (act == Act.CONCAT)
                value = first.getValue().toString() + second.getValue();
            else throw new IllegalArgumentException();
        }
    }

    public enum Act {
        CONCAT, TRANSFORM
    }
}
