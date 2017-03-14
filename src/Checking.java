import java.util.regex.*;  

public class Checking 
{
    public static boolean checkExistID(String id)
    {
        for (int i = 0; i < Bai1.myList.size(); i++)
        {
            Student temp;
            temp = new Student();
            temp = (Student)Bai1.myList.get(i);
            if (temp.getCode().equals(id))
            {
                System.out.println("ID exists already, try again");
                return false;
            }
        }
        return true;
    }    
    
    public static boolean checkTrueID(String id)
    {
        if (Pattern.matches("[0-9]{1,10}", id))
        {
            return true;
        }
        System.out.println("ID must be number from 1 to 10 characters");
        return false;
    }
    
    public static boolean checkMark(String mark)
    {
        if (Pattern.matches("[0-9]*\\.?[0-9]+", mark))
        {
            float temp;
            temp = Float.parseFloat(mark);
            if ((temp < 0) || (temp > 10))
            {
                System.out.println("Mark must > 0 and < 10");
                return false;
            }
            else 
                return true;
        }
        
            System.out.println("Mark must be float number");
            return false;
        
    }
}
