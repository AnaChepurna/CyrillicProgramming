package language.component.variable;

/**
 * Created by Ana on 21.07.2017.
 */
public class IntegerExpression extends Expression {
    private int value;
    private int firstValue;
    private int secondValue;
    private Act act;

    public IntegerExpression(int value) {
        this.value = value;
        act = Act.NONE;
    }

    public IntegerExpression(Container first, Container second, Act act) throws IllegalArgumentException {
        super(first, second);
        this.act = act;
    }

    private int remainder() {
        return firstValue % secondValue;
    }

    private int multiply() {
        return firstValue * secondValue;
    }

    private int divide() {
        return firstValue / secondValue;
    }

    private int minus() {
        return firstValue - secondValue;
    }

    private int plus() {
        return firstValue + secondValue;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void run() {
        if (act == Act.NONE)
            return;
        firstValue = first.getValue();
        secondValue = second.getValue();
        switch (act) {
            case PLUS:
                value = plus();
                break;
            case MINUS:
                value = minus();
                break;
            case DIVIDE:
                value = divide();
                break;
            case MULTIPLY:
                value = multiply();
                break;
            case REMAINDER:
                value = remainder();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public enum Act {
        PLUS, MINUS, MULTIPLY, DIVIDE, REMAINDER, NONE
    }
}
