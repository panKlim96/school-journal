package org.digital.habbits.reader;

import java.util.Objects;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.messagesBundle;

public class ConsoleReader implements Reader {
    private static ConsoleReader instance;

    private ConsoleReader() {
    }

    public static ConsoleReader getInstance() {
        if (Objects.isNull(instance)) {
            return new ConsoleReader();
        }
        return instance;
    }

    @Override
    public String readFromConsole(Scanner scanner, String consoleText, String wrongInfoMessage) {
        System.out.println(messagesBundle.getString(consoleText));
        String data = scanner.nextLine();

        return data;
    }

}
