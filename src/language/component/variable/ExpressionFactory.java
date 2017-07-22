package language.component.variable;

/**
 * Created by Ana on 22.07.2017.
 */
public abstract class ExpressionFactory {

    public static Expression getExpression (Container first, Container second, String sign) {
        switch (sign) {
            case "строка)" :
                return new StringExpression(first, second, StringExpression.Act.TRANSFORM);
            case "+" :
               // if (first.getValue().getClass().getSimpleName().equals("String"))
               //     return new StringExpression(first, second, StringExpression.Act.CONCAT);
               // else
                    return new IntegerExpression(first, second, IntegerExpression.Act.PLUS);
            case "-" :
                return new IntegerExpression(first, second, IntegerExpression.Act.MINUS);
            case "*" :
                return new IntegerExpression(first, second, IntegerExpression.Act.MULTIPLY);
            case "/" :
                return new IntegerExpression(first, second, IntegerExpression.Act.DIVIDE);
            case "%" :
                return new IntegerExpression(first, second, IntegerExpression.Act.REMAINDER);
            case "значение)" :
                return new BooleanExpression(first, second, BooleanExpression.Act.NONE);
            case ">" :
                return new BooleanExpression(first, second, BooleanExpression.Act.MORE);
            case "<" :
                return new BooleanExpression(first, second, BooleanExpression.Act.LESS);
            case "==" :
                return new BooleanExpression(first, second, BooleanExpression.Act.EQUAL);

        }
        return null;
    }
}
