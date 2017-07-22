package language.handler;

import language.component.operator.Assigner;
import language.component.operator.Printer;
import language.component.operator.VariableCreator;
import language.component.variable.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by Ana on 21.07.2017.
 */
public class ConsoleHandler {
    private ProgramManager programManager;
    public boolean stoped;

    public ConsoleHandler(ProgramManager programManager) {
        this.programManager = programManager;
    }

    //Создание переменной - переменная %тип %имя
    // присвоить значение - %имя = %контейнер (имя переменной либо выражение) выражение имеет вид - (первый знак второй)
    // вывести на экран - печатать %контейнер
    public void handle(String str) {
        String[] words = str.split(" ");
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(words));
        String var = null;
        switch (var = deque.pop()) {
            case "переменная":
                handleCreateVariable(deque);
                break;
            case "печатать":
                handlePrint(deque);
                break;
            default:
                if (deque.pop().equals("=") && programManager.getVariables().containsKey(var)) {
                    handleAssign(var, deque);
                } else
                    ConsoleHelper.printLine("!Неверное выражение!");
        }
    }

    private void handleAssign(String var, Deque<String> deque) {
        programManager.getOperations().add(new Assigner(programManager.getVariables().get(var), handleContainer(deque)));
    }

    private void handlePrint(Deque<String> deque) {
        Container container = handleContainer(deque);
        programManager.getOperations().add(new Printer(container));
    }

    private Container handleContainer(Deque<String> deque) {
        String var = deque.pop();
        if (var.length() >= 2 && var.substring(var.length() - 1).equals(")")) {
            var = var.substring(0, var.length() - 1);
        }
        if (var.substring(0, 1).equals("(")) {
            var = var.substring(1);
            deque.push(var);
            Container first = handleContainer(deque);
            String sign = deque.pop();
            Container second = null;
            if (!sign.equals("строка)") && !sign.equals("значение)")) {
                second = handleContainer(deque);
            }
            return ExpressionFactory.getExpression(first, second, sign);
        }
        else if (programManager.getVariables().containsKey(var)) {
            return programManager.getVariables().get(var);
        }
        else if (var.replaceAll("\\d", "").length() == 0) {
            return new IntegerExpression(Integer.parseInt(var));
        }
        else if (var.equals("правда") || var.equals("ложь")) {
            return new BooleanExpression(Boolean.parseBoolean(var));
        }
        else
            ConsoleHelper.printLine("!Неверное выражение!");
        return null;
    }

    private void handleCreateVariable(Deque<String> deque) {
        VariableCreator.Type type = null;
        switch (deque.pop()) {
            case "строка":
                type = VariableCreator.Type.STRING;
                break;
            case "логика":
                type = VariableCreator.Type.BOOLEAN;
                break;
            case "число":
                type = VariableCreator.Type.INTEGER;
                break;
            default:
                ConsoleHelper.printLine("!Неверное выражение!");
                return;
        }
        VariableCreator.createVariable(programManager.getVariables(), deque.pop(), type);
    }

    public void startProgram(){
        if (stoped) {
            programManager.start();
        }
    }
}
