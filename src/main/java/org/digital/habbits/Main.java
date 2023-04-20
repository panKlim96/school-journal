package org.digital.habbits;

import org.digital.habbits.service.OperationService;
import org.digital.habbits.service.OperationServiceImpl;
import org.digital.habbits.utils.enums.OperationsEnum;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        OperationService operationService = OperationServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        String operationName = "";
        while (!operationName.equals("exit")) {
            System.out.println("enter command name or exit: ");
            operationName = scanner.nextLine();
            String finalOperationName = operationName;
            if (Arrays.stream(OperationsEnum.values())
                    .anyMatch(e -> e.getOperationName().equals(finalOperationName))) {
                operationService.findAndExecuteOperation(scanner, operationName);
            }
        }

    }
}