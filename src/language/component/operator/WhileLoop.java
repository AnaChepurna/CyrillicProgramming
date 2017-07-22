package language.component.operator;

import language.component.operator.Operation;
import language.component.variable.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ana on 21.07.2017.
 */
public class WhileLoop implements Operation {
    private List<BooleanExpression> conditions = new ArrayList<>();
    private List<Operation> acts = new ArrayList<>();

    @Override
    public void run() {

    }
}
