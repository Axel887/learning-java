package fr.hetic;

public class OperationFactory {
    public static Operation createOperation(String operateur) {
        switch (operateur) {
            case "+":
                return new Addition();
            case "-":
                return new Soustraction();
            case "*":
                return new Multiplication();
            default:
                return null;
        }
    }
}
