import java.util.Scanner;
import java.util.Stack;

public class RPN {
	
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) 
		{
			String line = scanner.nextLine();
			System.out.println("Your answer = " + evaluate(line.split(" ")));
		}
		
		
		scanner.close();
	}



	public static int operation(String sign, Integer a, Integer b) 
	{
		if(sign.equals("+")) {
			return a + b;
		}
		
		else if(sign.equals("-")) {
			return b - a;
		}
		
		else if(sign.equals("*")) {
			return a * b;
		}
		
		else if(sign.equals("/")) {
			return b / a;
		} 
		
		else 
		{
			throw new IllegalArgumentException("Invalid Operator.");
		}
	}

	
	public static Integer evaluate(String[] tokens) 
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String token : tokens) 
		{
			if (token.equals("+")) 
			{
				stack.push(operation(token, stack.pop(), stack.pop()));
			}
			
			else if(token.equals("-"))
			{
				stack.push(-operation(token, stack.pop(), stack.pop()));
			}
			else if(token.equals("*"))
			 {
				
				stack.push(operation(token, stack.pop(), stack.pop()));
			}
			else if(token.equals("/"))
			 {
				stack.push(operation(token, stack.pop(), stack.pop()));
			}
			
			else {
				stack.push(Integer.parseInt(token));
			}
			
		}
		
		return stack.pop();
	}



	public Stack<Integer> evaluate(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}





