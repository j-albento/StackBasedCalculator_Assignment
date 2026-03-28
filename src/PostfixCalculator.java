import javax.swing.JOptionPane;

public class PostfixCalculator {

    private StackInterface<Integer> stack;
    private BinarySearchTree variableTree;

    // -------- Constructor --------
    public PostfixCalculator() {
        stack = new StackImplementation<>();
        variableTree = new BinarySearchTree();
    }

    // -------- Set Variable --------
    public void setVariable(String key, int value) {
        variableTree.insert(key, value);
    }

    // -------- Evaluate Postfix Expression --------
    public int evaluatePostfixExpression(String expression) {

        stack.clear();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {

            // Case 1: Operator
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(token, operand1, operand2);
                stack.push(result);
            }
            // Case 2: Variable
            else if (isVariable(token)) {
                Integer value = variableTree.search(token);
                if (value == null) {
                    throw new RuntimeException("Undefined variable: " + token);
                }
                stack.push(value);
            }
            // Case 3: Integer
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // -------- Delete All Variables --------
    public void deleteAllVariables() {
        variableTree.deleteAll();
    }

    // -------- Display BST --------
    public void displayVariablesTree() {
        variableTree.displayTree();
    }

    // -------- Helper Methods --------
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/");
    }

    private boolean isVariable(String token) {
        return token.matches("[a-zA-Z]+");
    }

    private int applyOperator(String operator, int op1, int op2) {
        switch (operator) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/":
                if (op2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(
            null,
            "Stack-Based Calculator for Postfix Notation with BST\n" +
            "This program evaluates postfix expressions using a stack\n" +
            "and manages variables using a binary search tree.\n\n" +
            "Click OK to begin."
        );

        PostfixCalculator calculator = new PostfixCalculator();

        // ---------- TEST CASE 1 ----------
        calculator.setVariable("g", 2);
        calculator.setVariable("h", 3);
        calculator.setVariable("i", 4);
        calculator.setVariable("j", 5);

        runTest(calculator, "g h i + * j /");

        // ---------- TEST CASE 2 ----------
        calculator.setVariable("x", 5);
        calculator.setVariable("y", 3);
        calculator.setVariable("z", 4);

        runTest(calculator, "x y + z *");

        // ---------- TEST CASE 3 ----------
        calculator.setVariable("a", 2);
        calculator.setVariable("b", 3);
        calculator.setVariable("c", 4);

        runTest(calculator, "a b + c *");

        // ---------- TEST CASE 4 ----------
        calculator.setVariable("m", 8);
        calculator.setVariable("n", 2);
        calculator.setVariable("p", 3);

        runTest(calculator, "m n / p +");

        // ---------- TEST CASE 5 ----------
        calculator.setVariable("q", 7);
        calculator.setVariable("r", 3);
        calculator.setVariable("s", 2);

        runTest(calculator, "q r - s *");

        // ---------- TEST CASE 6 ----------
        calculator.setVariable("d", 1);
        calculator.setVariable("e", 2);
        calculator.setVariable("f", 3);

        runTest(calculator, "d e + f +");

        // ---------- TEST CASE 7 ----------
        calculator.setVariable("k", 2);
        calculator.setVariable("l", 3);
        calculator.setVariable("m", 4);
        calculator.setVariable("n", 5);

        runTest(calculator, "k l + m n + *");

        // ---------- TEST CASE 8 ----------
        calculator.setVariable("o", 9);
        calculator.setVariable("p", 3);
        calculator.setVariable("q", 5);
        calculator.setVariable("r", 2);
        calculator.setVariable("s", 7);

        runTest(calculator, "o p / q r * s + -");
    }
    private static void runTest(PostfixCalculator calculator, String expression) {

        System.out.println("\n----------------------------------");
        System.out.println("Postfix Expression: " + expression);

        int result = calculator.evaluatePostfixExpression(expression);

        System.out.println("Binary Search Tree:");
        calculator.displayVariablesTree();

        System.out.println("Result: " + result);

        calculator.deleteAllVariables();
        System.out.println("All variables deleted.");
    }

}