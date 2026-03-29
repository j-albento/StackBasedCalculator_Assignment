------------------------------------------------------------
README – Stack-Based Calculator for Postfix Notation with BST
------------------------------------------------------------

Assignment: Stack-Based Calculator for Postfix Notation with BST

------------------------------------------------------------
1. PROJECT DESCRIPTION
------------------------------------------------------------
This program implements a text-based calculator that evaluates
arithmetic expressions written in postfix notation.

The calculator uses:
- An array-based stack to evaluate postfix expressions.
- A binary search tree (BST) to store variables and their integer values.

The program supports integer operands, variables, and the
operators +, -, *, and /.

------------------------------------------------------------
2. PROGRAM STRUCTURE
------------------------------------------------------------
The project consists of the following main components:

- StackInterface.java
  Defines the abstract data type (ADT) for the stack.

- StackImplementation.java
  Provides an array-based implementation of the stack.

- BinarySearchTree.java
  Implements a BST to store variables and their values.
  Supports insert, search, delete, deleteAll, and display operations.

- PostfixCalculator.java
  Integrates the stack and BST to evaluate postfix expressions.
  Contains the main() method and runs all sample test cases.

------------------------------------------------------------
3. HOW TO RUN THE PROGRAM
------------------------------------------------------------
Option 1: Run using the JAR file (recommended)

1. Open a terminal in the project directory.
2. Run the following command:

   java -jar StackBasedCalculator.jar

3. A popup window will appear. Click OK to start the program.
4. The program will display the postfix expressions, the binary
   search tree structure, the evaluation result, and a confirmation
   that variables were deleted after each test case.

------------------------------------------------------------
4. SAMPLE TEST CASES
------------------------------------------------------------
The program evaluates the following postfix expressions:

1. g h i + * j /
2. x y + z *
3. a b + c *
4. m n / p +
5. q r - s *
6. d e + f +
7. k l + m n + *
8. o p / q r * s + -

Each test case:
- Sets variables in the BST
- Evaluates the postfix expression using the stack
- Displays the BST structure
- Displays the result
- Deletes all variables before the next test case

------------------------------------------------------------
5. NOTES
------------------------------------------------------------
- The stack and BST are implemented from scratch without using
  built-in Java utilities.
- The program demonstrates correct usage of data structures
  and postfix evaluation algorithms.
- Integer division is used for the division operator.

------------------------------------------------------------
END OF README
------------------------------------------------------------
