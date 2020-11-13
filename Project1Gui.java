/* @Author: Kwame Duodu
 *  Project: CMSC 350 Project 1
 *  Date: 11/2/2020
 *  Description:  program that converts prefix expressions to postfix and postfix
 *  expressions to prefix. 
*/

package Project1;

	import java.awt.event.ActionEvent;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.WindowConstants;


	public class Project1Gui  extends JFrame {

		//Variables
		JPanel panel, expressionPanel, preandpostfixPanel, resultPanel;
		JLabel enterExpressionLabel, resultLabel;
		JTextField enterExpressionField, resultField;
		JButton prefixToPostFixButton, postfixToPreFixButton;
		
		
	    //Contructor
	    public Project1Gui() {
	   
	   super("Expresson Evaluator");
	        
		// Panel setup
	     panel = new JPanel();
		expressionPanel = new JPanel();
		preandpostfixPanel = new JPanel();
		resultPanel = new JPanel();		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    // Declaring variables
		enterExpressionLabel = new JLabel("Enter Expression");
		enterExpressionField = new JTextField(null, 20);
		prefixToPostFixButton = new JButton("Prefix to Postfix");
	    postfixToPreFixButton = new JButton("Postfix to Prefix");
	    resultLabel = new JLabel("Result");
	    resultField = new JTextField(null, 20);
	    resultField.setEditable(false);   // non editable text field
		
	        // Adding to panels
	        expressionPanel.add(enterExpressionLabel);
	        expressionPanel.add(enterExpressionField);
	        preandpostfixPanel.add(prefixToPostFixButton);
	        preandpostfixPanel.add(postfixToPreFixButton);
	        resultPanel.add(resultLabel);
	        resultPanel.add(resultField);
	        panel.add(expressionPanel);
	        panel.add(preandpostfixPanel);
	        panel.add(resultPanel);
	        add(panel);//add to frame

	        // Frame setup
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setSize(400, 200);
	        setLocation(300, 400);
	        setResizable(false);
	        setVisible(true);
	        
	       
	         //prefix to postfix action perform
	        prefixToPostFixButton.addActionListener((ActionEvent e) -> {
	            try {
	               
	                String preExpr = enterExpressionField.getText();
	                resultField.setText(PreToPostFix.prefixToPostfix(preExpr));
	                
	            } catch(Exception exception) {
	                    JOptionPane.showMessageDialog(null,exception.getMessage(),"Message",1);
	            }
	        });
	        

	        // postfix to prefix action perform
	        postfixToPreFixButton.addActionListener((ActionEvent e) -> {
	            try {
	            	 
	                String postExpr = enterExpressionField.getText();
	                resultField.setText(PostToPreFix.postfixToPrefix(postExpr));
	                
	            } catch (Exception  em) {
	                JOptionPane.showMessageDialog(null,em.getMessage(),"Message",1);
	            }
	        });
	        
	    }
	    
	   
	    public static void main(String[] args) {
	        new Project1Gui();
	    }
	}
