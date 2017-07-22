package language;

import language.handler.ConsoleHandler;
import language.handler.ConsoleHelper;
import language.handler.ProgramManager;

/**
 * Created by Ana on 20.07.2017.
 */
public class CreateProgram {

    public static void main(String[] args) throws Exception {
        ConsoleHandler handler = new ConsoleHandler(new ProgramManager());

        while (true) {
            String line = ConsoleHelper.readLine();
            if (line.equals("ок")) {
                handler.stoped = true;
                break;
            }
            handler.handle(line);
        }

        ConsoleHelper.printLine("---------------------------------------------");
        handler.startProgram();
    }
}
