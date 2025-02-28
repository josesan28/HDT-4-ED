public class Calculator {
    
    private static Calculator instance = null;
    
    // Constructor privado
    private Calculator() {
    }

    // Método que devuelve la instancia única de la clase
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
    
    // Método que realiza la operación aritmética
    public Number operation(char operator, Number value1, Number value2) {
        int a = value1.intValue();
        int b = value2.intValue();
        int resultado;

        switch (operator) {
            case '+': resultado = b + a; break;
            case '-': resultado = b - a; break;
            case '*': resultado = b * a; break;
            case '%': resultado = b % a; break;
            case '/': 
                if (a == 0) throw new ArithmeticException("División por cero.");
                resultado = b / a;
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }

        return resultado;
    } 

    public String infixToPostfix(String infix, IStack<Character> stack) {
        StringBuilder postfix = new StringBuilder();
        stack.push('#');

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch).append(" ");
            }

            else if (ch == '(' ) {
                stack.push(ch);
            }

            else if (ch == ')' ) {
                while (stack.isEmpty() == false && stack.peek() != '(' && stack.peek() != '#') {
                    postfix.append(stack.pop()).append(" ");
                }

                if (stack.isEmpty() == false && stack.peek() == '(') {
                    stack.pop();
                }
            }  

            else {
                while (stack.isEmpty() == false && precedence(ch) <= precedence(stack.peek()) && stack.peek() != '#' && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }  
       
        }
        
        while (stack.isEmpty() == false && stack.peek() != '#') {
            postfix.append(stack.pop()).append(" ");
        } 

        return postfix.toString().trim();   
    }

    public int precedence(char ch) {
        
        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }
        else if (ch == '+' || ch == '-') {
            return 1;
        }
        else {
            return 0;
        }
    }
}