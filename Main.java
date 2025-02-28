import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackFactory<Integer> stackFactory = new StackFactory<>();
        StackFactory<Character> stackFactoryChar = new StackFactory<>();
        Calculator calculator = Calculator.getInstance();
        IStack<Integer> stack = null;
        IStack<Character> stackChar = null;

        try {
            // Solicitar tipo de stack
            System.out.println("Seleccione el tipo de implementación para la pila:");
            System.out.println("1. ArrayList");
            System.out.println("2. Vector");
            System.out.println("3. Lista");
            int stackChoice = scanner.nextInt();

            StackFactory.StackType stackType;
            try {
                stackType = StackFactory.StackType.fromValue(stackChoice);
            } catch (IllegalArgumentException e) {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                return;
            }

            if (stackType == StackFactory.StackType.List) {
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");
                int listChoice = scanner.nextInt();

                ListFactory.ListType listType;
                try {
                    listType = ListFactory.ListType.fromValue(listChoice);
                } catch (IllegalArgumentException e) {
                    System.out.println("Opción de lista inválida. Por favor, seleccione una opción válida.");
                    return;
                }

                stack = new ListFactory<Integer>().createList(listType);
            } else {
                stack = stackFactory.createStack(stackType);
            }

            // Leer la expresión desde el archivo
            String infixExpression = readExpressionFromFile("datos.txt");
            if (infixExpression == null || infixExpression.trim().isEmpty()) {
                System.out.println("El archivo está vacío o no pudo leerse correctamente.");
                return;
            }

            // Convertir a postfix usando la pila seleccionada
            stackChar = stackFactoryChar.createStack(stackType);
            String postfixExpression = calculator.infixToPostfix(infixExpression, stackChar);
            System.out.println("Expresión Postfix: " + postfixExpression);

            // Verificar que la expresión postfix no esté vacía antes de evaluar
            if (postfixExpression.isEmpty()) {
                System.out.println("Error: la conversión a postfix falló.");
                return;
            }

            // Evaluar la expresión postfix usando la misma pila
            int result = calculator.evaluatePostfix(postfixExpression, stack);
            System.out.println("Resultado: " + result);
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        } 
        
        finally {
            scanner.close();
        }
    }

    private static String readExpressionFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
}