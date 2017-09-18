import java.io.*;
public class Calculator
{
    public static void main(String[] args)
    {
    	double result = 0.0;
    	double number = 0.0;
        char determine;
        char r;
        String originalNumber;
        boolean redo = true;
        
        do
        {
            try
            {
            	//Creating a new instance of the BufferedReader class.
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                
                //Prompting the user. Taking user input.
                	System.out.println("Enter a number. ");
                	String userInput = reader.readLine();
                	determine = userInput.charAt(0);
                
                		/**
                		 * While loop to enforce that 'R' is entered.
                		 * Prints error message if an inappropriate character is entered.
                		 * @param The user input. 
                		 */
                		while (userInput.length() < 2)
                		{
                			if (determine != 'r' && determine != 'R')
                			{
                				System.out.println("Invalid expression");
                				System.out.println("Re-enter your last line:");
                        		userInput = reader.readLine();
                        		determine = userInput.charAt(0);
                			}
                			else
                			{
                				break;
                			}//End if-else statement.
                }//End while loop.
                
                originalNumber = userInput.substring(1).trim();
                	if (userInput.trim().length() > 1)
                	{
                		number = Double.parseDouble(originalNumber);
                	}
               
                /**
                 * Implementing a switch statement for various cases for all possible operators. 
                 * @param The operator.
                 */
                switch (determine)
                {
                	//Addition
                    case '+':
                        result += number;
                        System.out.println("\nresult + " + number + " = " + result);
                        System.out.println("new result = " + result);
                        break;
                    			//Subtraction
                    			case '-':
                    			result -= number;
                    			System.out.println("\nresult - " + number + " = " + result);
                    			System.out.println("new result = " + result);
                    			break;
                    				//Multiplication
                    				case '*':
                    				result *= number;
                    				System.out.println("\nresult * " + number + " = " + result);
                    				System.out.println("updated result = " + result);
                    				break;
                    					//Division
                    					case '/':
                    						if (number == 0)
                    						{
                    							System.out.println("You may not divide by zero.");
                    							System.out.println("Re-enter your last line:");
                    						}
                    						else
                    						{
                    							result /= number;
                    							System.out.println("\nresult / " + number + " = " + result);
                    							System.out.println("updated result = " + result);
                    						}//End if-else statement.
                    						break;
                    case 'r':
                    case 'R':
                        System.out.println("\nFinal result = " + result);
                        System.out.println("Again? (Y/N)");
                        
                        	/**
                        	 * Allowing the user to decide Y or N to restart the program.
                        	 * Y refreshes the calculator back to 0.
                        	 * N terminates the program.
                        	 */
                        	userInput = reader.readLine();
                        	r = userInput.charAt(0);
                        		if (r == 'y' || r == 'Y' || userInput.compareToIgnoreCase("yes") == 0)
                        		{
                        			result = 0.0;
                        			System.out.println("result = " + result);
                        			break;
                        		}
                        			else if (r == 'n' || r == 'N' || userInput.compareToIgnoreCase("no") == 0)
                        			{
                        				redo = false;
                        				break;
                        			}//End if statement.
                        			break;
                    				default:
                    						throw new UnknownOperatorException(determine);
               	}//End switch statement.

            }//End try block.  
            catch (UnknownOperatorException e)
            {
                System.out.println(e.getMessage());
            }//End catch block.
            catch (Exception e)
            {
                System.out.println(e.getMessage() + " is not an acceptable number.\nRe-enter your last line:");
            }//End catch block.

        } 
        while (redo);
        System.out.println("\nEnd of Program");
    }//End main.
}//End class.


