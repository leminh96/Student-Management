import java.io.IOException;
import java.util.*;

public class Bai1 
{
    public static List <Student> myList = new Vector();
   
    public static void showMenu()
    {
        System.out.printf("-------------------------------------------------------------\n");
        System.out.printf("|%30s %30s", "Menu", "|\n");
        System.out.printf("|%-50s %10s", "1. Add new students", "|\n");
        System.out.printf("|%-50s %10s", "2. Update student's information", "|\n");
        System.out.printf("|%-50s %10s", "3. Delete a student", "|\n");
        System.out.printf("|%-50s %10s", "4. List of students", "|\n");
        System.out.printf("|%-50s %10s", "5. Import from a file", "|\n");
        System.out.printf("|%-50s %10s", "6. Export to a file", "|\n");
        System.out.printf("|%-50s %10s", "7. Exit", "|\n");
        System.out.printf("-------------------------------------------------------------\n");
    }
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int choice;
        Process.readBinaryFile();
        try
        {
            do
            {
                showMenu();
                System.out.print("Please select an option from menu\n");
                choice = input.nextInt();
                switch (choice)
                {
                    case 1:
                    {
                        Process.addStudents();
                        Process.writeBinFile();
                        break;
                    }
                
                    case 2:
                    {
                        Process.updateStudentInfo();
                        Process.writeBinFile();
                        break;
                    }
                
                    case 3:
                    {
                        Process.deleteStudent();
                        Process.writeBinFile();
                        break;
                    }
                
                    case 4:
                    {
                        Process.showStudentList();
                        break;
                    }
                
                    case 5:
                    {
                        Process.readFromFile();
                        break;
                    }
                
                    case 6:
                    {
                        Process.writeToFile();
                        break;
                    }
                
                    case 7:
                    {
                        System.out.print("Exit application...");
                        break;
                    }
                
                    default:
                    {
                        System.out.println("Application don't have this function");
                        break;
                    }
                }
            }
            while (choice != 7);
            
        }
        catch (Exception ex)
        {
            System.err.print("Error");
            System.exit(0);
        }
    }
}
