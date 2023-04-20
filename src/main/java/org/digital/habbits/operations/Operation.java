package org.digital.habbits.operations;

import org.digital.habbits.reader.ConsoleReader;
import org.digital.habbits.reader.Reader;

import java.util.Scanner;

public interface Operation<T> {
    Reader consoleReader = ConsoleReader.getInstance();

    T execute(Scanner scanner);
}
