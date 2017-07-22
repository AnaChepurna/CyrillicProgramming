package language.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ana on 21.07.2017.
 */
public abstract class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() throws IOException {
        return reader.readLine().trim();
    }

    public static void printLine(String str) {
        System.out.println(str);
    }
}
