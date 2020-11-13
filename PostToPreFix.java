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


public class PostToPreFix{
        
   public static String postfixToPrefix(String postExpression) {
	   
        // Declare variables
        Stack <String> operandStack=new Stack<String>();
        StringTokenizer postfixTokenizer = new StringTokenizer(postExpression, "+-*/() ", true);
        String token="", firstOperand="", secondOperand="", prefixExpression="", temp="";
        
        // While loop if more tokens exist
        while (postfixTokenizer.hasMoreTokens())
        {
            
            token = postfixTokenizer.nextToken();
            if(token.equals(" "))
            	
            {
               
                continue; //skip it
            }

            else if(!("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)))
            {
                // Pushing the token on the to stack with a space
                operandStack.push(token + " ");
            }
            

            else
            {
              

                try
                {
                    
                    firstOperand=operandStack.peek();
                    operandStack.pop();
                    secondOperand=operandStack.peek();
                    operandStack.pop();
                    
                } catch(Exception e) {
                   
                	JOptionPane.showMessageDialog(null, "Error: Stack is Empty");
                }
               
                temp = token + " " + secondOperand + " " + firstOperand;
                operandStack.push(temp + " ");
            }
            
        }

        try {
            
            prefixExpression=operandStack.peek();
            operandStack.pop();
            return prefixExpression;
            
        } catch(Exception e) {
           
        	JOptionPane.showMessageDialog(null, "Error: Stack is Empty");
        }
      
		return temp;
    }
}
