package me.upp.dali.problems;

import java.util.Scanner;

public class InverseNumbers implements Problem {

    private final Scanner scanner;

    public InverseNumbers(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void compute() {
        final int number = this.getNumber();
        final int invertedNumber = this.getInvertedNumber(number);
        final int numberSum = this.getSumOfDigits(number);
        final int invertedNumerSum = this.getSumOfDigits(invertedNumber);
        System.out.printf("Ingresaste el numero %s y al invertir el orden de los digitos se convierte en %s%n", number, invertedNumber);
        System.out.printf("La suma de los digitos de %s es %s%n", number, numberSum);
        System.out.printf("La suma de los digitos de %s es %s%n", invertedNumber, invertedNumerSum);
        this.printSameCharsIn(number, invertedNumber);
    }

    private void printSameCharsIn(final int firstNumber, final int secondNumber) {
        final String first = String.valueOf(firstNumber);
        final String second = String.valueOf(secondNumber);
        final StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(i)) {
                if (finalResult.length() > 0) finalResult.append(", ");
                finalResult.append(first.charAt(i));
            }
        }
        System.out.printf("Los numeros %s y %s tienen los numeros %s en la misma posicion.", first, second, finalResult);
    }

    private int getSumOfDigits(final int number) {
        final String value = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < value.length(); i++) sum += Integer.parseInt(String.valueOf(value.charAt(i)));
        return sum;
    }

    private int getInvertedNumber(final int number) {
        final StringBuilder builder = new StringBuilder(String.valueOf(number));
        return Integer.parseInt(builder.reverse().toString());
    }

    private int getNumber() {
        System.out.print("Ingresa un numero entero de tres digitos: ");
        final String value = this.scanner.next();
        if (value.length() < 3) {
            System.out.println("El numero es menor de tres digitos.");
            return getNumber();
        } else if (value.length() > 3) {
            System.out.println("El numero es mayor de tres digitos.");
            return getNumber();
        }
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