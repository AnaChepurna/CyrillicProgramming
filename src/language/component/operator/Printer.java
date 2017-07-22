package language.component.operator;

import language.component.variable.Container;
import language.handler.ConsoleHelper;

/**
 * Created by Ana on 21.07.2017.
 */
public class Printer implements Operation {
    private Container container;

    public Printer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        String string = container.getValue().toString();
        ConsoleHelper.printLine(string);
    }
}
