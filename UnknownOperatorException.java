public class UnknownOperatorException extends Exception
{
    public UnknownOperatorException(char theChar)
    {
        super("\n" + theChar + " is an unknown operation.\nRe-enter, your last line:");
    }//End constructor.
    
}//End class.
