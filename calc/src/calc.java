/**
 * @author Haroon
 * 	Data Structures Assingment 4 - March 14, 2017
 * 
 * 	Purpose of the program:
 * 		The purpose of this program is to evaluate an infix expression 
 * 		entered by the user. The expression may contain, Integer constants 
 * 		(a series of decimal digits), x (representing a value to be supplied 
 * 		later), Binary operators (+, -, *, / and %), and finally Parentheses ().
 * 		The program takes in a prefix expression from the user and then checks 
 * 		for errors and then passes it through a method that will convert it from a 
 * 		prefix expression into a postfix expression. Then after it is in postfix form, 
 * 		the program will ask the user for an input for the 'x' value and will evaluate 
 * 		the expression based on that 'x' value. It will keep asking the user for a new 'x'
 * 		value and keep printing the answer until the user inputs "q" to quit.
 * 
 * 	Solution for the problem and algorithms to be used:
 * 		When approaching this problem, the use of a stack was the best idea. The program will
 * 		take an input from the user which is a prefix expression and then it will convert that 
 * 		prefix expression into a postfix expression using a stack where it pushes all the operators 
 * 		in the stack and pops the objects in the stack and evaluate the right and left hand side 
 * 		of an expression when it reaches an operator that has lower precedence than the one that is 
 * 		currently in the top of the stack.
 * 				
 * 
 * 	Data Structures used in solution:
 * 		Stack is the only data structure used in the making of this program.
 * 
 *  Use of program, expected input/output:
 *  	The expected input of this program are the infix expression provided 
 *  	by the user and also the value for x. The expected outputs are the postfix 
 *  	expression that is generated through using a stack, and also the answer to 
 *  	the expression which is also calculated using a stack. Also, some of the 
 *  	outputs of this program may be errors that the users may have gotten by 
 *  	entering an incorrect prefix expression or x value.
 * 	
 * 	Purpose of this class:
 * 		The purpose of this class is that its the main method class where all the 
 * 		methods for converting the prefix expression into the postfix expression 
 * 		and evaluating it are in.
 * 
 */

import java.util.Stack;
import java.util.Scanner;

public class calc {
	/**
	 * Main method where there is a scanner that accepts 
	 * user input for the prefix expression and x value. 
	 * Also it calls other methods to convert the prefix 
	 * expression into the postfix expression and also 
	 * evaluate it.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter infix expression: ");
		String input = scan.nextLine();
		input = input.replaceAll("\\s+","");
		errorCheck(input);
		System.out.println("Converted expression: "+infixToPostFix(input));
		while(true){
			if(input.equals("q")){
				System.exit(-1);
			}
			System.out.println("Enter value of x: ");
			input = scan.next().trim();
			System.out.println("Answer to expression: "+evaluatePostfix(infixToPostFix(input), Integer.parseInt(input)));
		}
	}
	/**
	 * 
	 * @param exp
	 * This parameter accepts the string prefix expression entered by the user and 
	 * converts it into a post fix expression by using a stack data structure.
	 * @return
	 * This method returns a string which is the final postfix expression that 
	 * was obtained from the prefix expression.
	 */
	public static String infixToPostFix(String exp){
		Stack<String> s = new Stack<String>();
		String result = "";
		for(int i =0;i<exp.length();i++){
			if (isOperand(exp.charAt(i)+"")){
				result += exp.charAt(i);
			}else if(isOperator(exp.charAt(i)+"")){
				while(!s.empty() && !isOpeningParantheses(s.peek()) && hasHigherPrec(s.peek(),exp.charAt(i)+"")){
					result += s.peek();
					s.pop();
				}
				s.push(exp.charAt(i)+"");
			}
			else if(isOpeningParantheses(exp.charAt(i)+"")){
				s.push(exp.charAt(i)+"");
			}else if(isClosingParantheses(exp.charAt(i)+"")){
				while(!s.isEmpty() && !isOpeningParantheses(s.peek())){
					result +=s.peek();
					s.pop();
				}
				s.pop();
			}
		}
		while(!s.empty()){
			result +=s.peek();
			s.pop();
		}
		return result;
	}
	/**
	 * 
	 * @param postfix
	 * This parameter accepts the string postfix expression generated from 
	 * the infixToPostFix method, and it needs it because it inputs the characters
	 * of the postfix expression into a stack until it reaches an operand in which
	 * it uses a series of if statements to evaluate it.
	 * 
	 * @param userInput
	 * This parameter also accepts an integer which is from the user input obtained
	 * in the main method to supply the value for x. An if statement is in this method
	 * that checks whether the postfix contains an 'x' and if so then it pushes the 
	 * userInput into the stack.
	 * 
	 * @return
	 * This method returns an integer which is basically the last object in the stack which
	 * indeed is the answer for the postfix expression.
	 */
	public static int evaluatePostfix(String postfix, int userInput) {

        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < postfix.length(); ++i) {

            if (postfix.charAt(i) == 'x') {
                s.push(userInput);
            }else if (Character.isDigit(postfix.charAt(i))){
                s.push(Character.getNumericValue(postfix.charAt(i)));
            }else{
                int right = s.pop();
                int left = s.pop();
                
               if(postfix.charAt(i) == '+'){
                	s.push(left + right);
               }else if(postfix.charAt(i) == '-'){
                	s.push(left - right);
               }else if(postfix.charAt(i) == '%'){
                	s.push(left % right);
               }else if(postfix.charAt(i) == '*'){
               	 s.push(left * right);
               }else if(postfix.charAt(i) == '/'){
               	s.push(left / right);
               }
            }
        }
        return s.pop();
    }
	
	/**
	 * 
	 * @param s
	 * This method accepts a string parameter s which is used to determine if the
	 * string is a closing parentheses or not using an if statement.
	 * 
	 * @return
	 * It returns a boolean true or false on whether the passed string is a closing 
	 * parentheses or not.
	 */
	public static boolean isClosingParantheses(String s){
		if(s.equals(")")){
			return true;
		} else{
			return false;
		}
	}
	/**
	 * 
	 * @param s
	 * This method accepts a string parameter s which is used to determine if the
	 * string is an opening parentheses or not using an if statement.
	 * 
	 * @return
	 * It returns a boolean true or false on whether the passed string is an open 
	 * parentheses or not.
	 */
	public static boolean isOpeningParantheses(String s){
		if(s.equals("(")){
			return true;
		} else{
			return false;
		}
	}
	/**
	 * 
	 * @param s
	 * This parameter accepts a String s which is meant to be for the object at the 
	 * top of a stack, to check whether it has higher precedence than another object.
	 * 
	 * @param str
	 * This parameter also accepts a String variable str in which it compares with the 
	 * other string variable to check whether the first parameter has higher precedence 
	 * or not. 
	 * 
	 * @return
	 * This parameter returns a boolean true or false based on the comparison of the weight 
	 * of the first and second parameter.
	 */
	public static boolean hasHigherPrec(String s, String str){
		int weight = 0;
		int weight2 = 0;
			if(s.equals("+") || s.equals("-")){
				weight = 1;
			}else if(s.equals("*") || s.equals("/") || s.equals("%")){
				weight = 2;
			}

			if(str.equals("+") || str.equals("-")){
				weight2 = 1;
			}else if(str.equals("*") || str.equals("/") || s.equals("%")){
				weight2 = 2;
			}
		
		if(weight == weight2){
			return true;
		}else if(weight > weight2){
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param str
	 * This parameter accepts a String Object in where it checks if it is
	 * an operand by using an if-statement.
	 * @return
	 * This parameter returns a boolean true or false based on whether the 
	 * string is an operator or not using the if statement performed.
	 */
	public static boolean isOperand(String str){
		if(str.equals("x") || str.matches(".*\\d+.*")){ 
			return true;
		}else
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * This parameter accepts a String Object in where it checks if it is
	 * an operator by using an if-statement.
	 * @return
	 * This parameter returns a boolean true or false based on whether the 
	 * string is an operator or not using the if statement performed.
	 */
	public static boolean isOperator(String str){
		if(str.equals("*") || str.equals("/") || str.equals("%") || str.equals("-") || str.equals("+")){
			return true;
		}else
		return false;
	}
	
	/**
	 * 
	 * @param input
	 * This parameter accepts a String Object which is for the input of the prefix expression
	 * supplied by the user. It checks for errors using a series of if-statements in a for loop 
	 * and prints the error to the screen.
	 */
	public static void errorCheck(String input){
		int countOpen =0;
		int countClosed =0;
		
		for(int i=0;i<input.length();i++){
			if(input.charAt(i) == '('){
				countOpen++;
			}
			if(input.charAt(i) == ')'){
				countClosed++;
			}
			if(input.charAt(i) == '.'){
				System.out.println("Error in expression!! Cannot accept floating point numbers.");
				System.exit(-1);
			}else if(i>0 && input.charAt(i-1) == '*' && input.charAt(i) == '*'){
				System.out.println("Error in expression!! The * operator cannot be preceded by a * operator.");
				System.exit(-1);
			}else if(i>0 && isOperand(input.charAt(i-1)+"") && isOperand(input.charAt(i)+"")){
				System.out.println("Error in expression!! No operator between operands. Also last token must be an operand.");
				System.exit(-1);
			}else if(i>0 && input.charAt(i-1) == '(' && !isOperand(input.charAt(i)+"")){
				System.out.println("Error in expression!! No operator between operand and left parentheses.");
				System.exit(-1);
			}else if(i>0 && input.charAt(i) == ')' && !isOperand(input.charAt(i-1)+"")){
				System.out.println("Error in expression!! No operator between operand and right parentheses.");
				System.exit(-1);
			}else if(i == input.length()-1 && countOpen>countClosed){
				System.out.println("Error in expression!! No matching right parentheses for a right parentheses.");
				System.exit(-1);
			}else if(i == input.length()-1 && countClosed>countOpen){
				System.out.println("Error in expression!! No matching left parentheses for a right parentheses.");
				System.exit(-1);
			}
		}
	}
}
