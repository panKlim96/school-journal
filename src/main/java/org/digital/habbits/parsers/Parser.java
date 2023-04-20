package org.digital.habbits.parsers;

import java.util.List;

public interface Parser<T> {
    List<T> parse(String filePath);
}
