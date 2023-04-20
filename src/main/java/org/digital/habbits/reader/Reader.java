package org.digital.habbits.reader;

import java.util.Scanner;

@FunctionalInterface
public interface Reader {
    String readFromConsole(Scanner source, String consoleText, String wrongInfoMessage);
}
