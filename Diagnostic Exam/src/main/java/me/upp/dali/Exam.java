package me.upp.dali;

import me.upp.dali.problems.Factorial;
import me.upp.dali.problems.InverseNumbers;
import me.upp.dali.problems.Problem;

import java.util.Scanner;

public class Exam {

    public final Problem[] PROBLEMS;

    public Exam() {
        final Scanner scanner = new Scanner(System.in);
        PROBLEMS = new Problem[] {
                new InverseNumbers(scanner),
                new Factorial(scanner)
        };
    }

    public static void main(String[] args) {
        final Exam exam = new Exam();
        for (final Problem problem : exam.PROBLEMS) problem.compute();
    }
}
