package org.digital.habbits.operations.add.student;

import org.digital.habbits.parsers.JsonParser;
import org.digital.habbits.service.OperationService;
import org.digital.habbits.service.OperationServiceImpl;

public class BaseTest {
    protected OperationService operationService = OperationServiceImpl.getInstance();
    protected static JsonParser jsonParser = JsonParser.getInstance();
}
