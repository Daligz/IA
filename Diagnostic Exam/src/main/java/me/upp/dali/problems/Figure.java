package me.upp.dali.problems;

import java.util.Scanner;

public class Figure implements Problem {

    private final Scanner scanner;

    public Figure(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void compute() {
        final int number = this.getNumber();
        int nextNum = 1;
        for (int i = 0; i < number; i++) {
            final StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < (i + 1); j++) {
                stringBuilder.append(" ").append(nextNum).append("  ");
                nextNum++;
            }
            System.out.println(stringBuilder);
        }
    }

    private int getNumber() {
        System.out.print("Ingresa un numero de renglones: ");
        final String value = this.scanner.next();
        final int finalValue;
        try {
            finalValue = Integer.parseInt(value);
        } catch (final Exception ignored) {
            System.out.println("No ingresaste un numero valido.");
            return getNumber();
        }
        return finalValue;
    }
}
