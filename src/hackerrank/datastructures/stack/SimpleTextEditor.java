package hackerrank.datastructures.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    static String text = "";
    static Stack<String> textHistory = new Stack<>();

    final static int APPEND_ID = 1;
    final static int DELETE_ID = 2;
    final static int PRINT_ID = 3;
    final static int UNDO_ID = 4;

    static void edit(String command) {
        String[] commandSplit = command.split("\\s");
        int commandId = Integer.parseInt(commandSplit[0]);

        switch (commandId) {
            case APPEND_ID: {
                textHistory.push(text);
                String word = commandSplit[1];
                text += word;
                break;
            }
            case DELETE_ID: {
                textHistory.push(text);
                int deleteCount = Integer.parseInt(commandSplit[1]);
                int beginDeletePos = text.length() - deleteCount;
                text = text.substring(0, beginDeletePos);
                break;
            }
            case PRINT_ID: {
                int printPos = Integer.parseInt(commandSplit[1]) - 1;
                System.out.println(text.charAt(printPos));
                break;
            }
            case UNDO_ID: {
                if (!textHistory.isEmpty()) {
                    text = textHistory.pop();
                }
                break;
            }
        }
    }

//    static Scanner scanner = new Scanner(System.in);

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int editCount = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < editCount; i++) {
            edit(br.readLine().trim());
        }
    }
}

/*
8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
 */