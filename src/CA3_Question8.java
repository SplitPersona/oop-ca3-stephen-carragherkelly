import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */
public class CA3_Question8 {

    public static double checkexpression(String expression)
    {
        Stack<Double> oprandstack = new Stack<>();
        Stack<Character> operatorstack = new Stack<>();

        for(char ch:expression.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                oprandstack.push((double)(ch - '0'));

            }
            else if(ch == '(')
            {
                operatorstack.push(ch);
            }
            else if(ch == ')')
            {
                while(!operatorstack.isEmpty() && operatorstack.peek() != '(')
                {
                    domaths(oprandstack, operatorstack);
                }
                operatorstack.pop();
            }
            else if(isoperator(ch))
            {
                while(!operatorstack.isEmpty() && hasprecedence(ch, operatorstack.peek()))
                {
                    domaths(oprandstack, operatorstack);
                }
                operatorstack.push(ch);
            }
        }
        while(!operatorstack.isEmpty())
        {
            domaths(oprandstack, operatorstack);
        }

        return oprandstack.pop();
    }

    private static void domaths(Stack<Double> oprandstack, Stack<Character> operatorstack)
    {
        char operation = operatorstack.pop();
        double oprand2 = oprandstack.pop();
        double oprand1 = oprandstack.pop();

        switch(operation)
        {
            case '+':
                oprandstack.push(oprand1 + oprand2);
                break;
            case '-':
                oprandstack.push(oprand1 - oprand2);
                break;
            case '*':
                oprandstack.push(oprand1 * oprand2);
                break;
            case '/':
                oprandstack.push(oprand1 / oprand2);
                break;
        }
    }

    private static boolean isoperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedeure(char operator)
    {
        if(operator == '+' || operator == '-')
        {
            return 1;
        }
        else if (operator == '*' || operator == '/')
        {
            return 2;
        }

        return 0;
    }

    private static boolean hasprecedence(char op1, char op2)
    {
        return precedeure(op1) >= precedeure(op2);
    }


    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        double result = checkexpression(equation);
        System.out.println("Result: " + result);
    }
}
