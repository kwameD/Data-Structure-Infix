/* @Author: Kwame Duodu
 *  Project: CMSC 350 Project 1
 *  Date: 11/2/2020
 *  Description:  program that converts prefix expressions to postfix and postfix
 *  expressions to prefix. 
*/

package Project1;

import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class PreToPostFix {
   
    public static String prefixToPostfix(String prefixExpression)  {
    	
        // Declare variables
        Stack <String> reverseStack=new Stack<String>();
        Stack <String> operandStack=new Stack<String>();
        StringTokenizer prefixTokenizer = new StringTokenizer(prefixExpression, "+-*/() ", true);
        String token, firstOperand="", secondOperand="", postfixExpression="", temp="";
        
        // While loop if more tokens exist
        while (prefixTokenizer.hasMoreTokens())
        {
          
            token = prefixTokenizer.nextToken();
            if (!token.equals(" "))
            	
            {
               
                reverseStack.push(token);
            }
        }
        
        //  While loop if the Reverse Stack is empty
        while(!(reverseStack.empty()))
        {
            token=reverseStack.pop();
            if(!("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)))
            {
                operandStack.push(token + " ");            
            }
          
            else
            {
                
                try
                {
                    
                    firstOperand=operandStack.peek(); // see
                    operandStack.pop(); // remove
                    secondOperand=operandStack.peek(); 
                    operandStack.pop(); 
                    
                }catch(Exception e) {
                   
                	JOptionPane.showMessageDialog(null, "Error: Stack is Empty");
                }
                
                temp= firstOperand+" "+secondOperand+ " " + token;
                operandStack.push(temp);
            }
        }
      
        try
        {
           
            postfixExpression=operandStack.peek();
            operandStack.pop();
            return postfixExpression;
            
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error: Stack is Empty");
        }
      
		return temp;
    }
   
}
