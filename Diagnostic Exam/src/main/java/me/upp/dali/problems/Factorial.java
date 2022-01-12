package me.upp.dali.problems;

import java.util.Scanner;

public class Factorial implements Problem {

    private final Scanner scanner;

    public Factorial(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void compute() {
        final int number = this.getNumber();
        final int factorial = this.getFactorial(number);
        System.out.printf("El factorial de %s es %s.%n", number, factorial);
    }

    private int getFactorial(final int number) {
        int result = 1;
        for (int i = number; i > 0; i--) result *= i;
        return result;
    }

    private int getNumber() {
        System.out.print("Ingresa un numero entero para obtener su factorial: ");
        final String value = this.scanner.next();
        final int finalValue;
        try {
            finalValue = Integer.parseInt(value);
        } catch (final Exception ignored) {
            System.out.println("El numero no es un valor entero.");
            return getNumber();
        }
        return finalValue;
    }
}
