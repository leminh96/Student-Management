
import java.util.*;
import java.io.*;

public class Process 
{
    public static void addAStudent(Student temp) throws IOException
    {
        String str_temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf8"));
        do
        {
            System.out.print("Insert student's code\n");
            str_temp = br.readLine();
        }
        while (!(Checking.checkExistID(str_temp)) || !(Checking.checkTrueID(str_temp)));
        temp.setCode(str_temp);   
        
        System.out.print("Insert student's name\n");
        str_temp = br.readLine();
        temp.setName(str_temp);
        
        do
        {
            System.out.print("Insert student's mark\n");
            str_temp = br.readLine();
        }
        while (!Checking.checkMark(str_temp));
        temp.setMark(str_temp);
        
        System.out.print("Insert student's avatar link\n");
        str_temp = br.readLine();
        temp.setAvatar(str_temp);
        
        System.out.print("Insert student's address\n");
        str_temp = br.readLine();
        temp.setAddress(str_temp);
        
        System.out.print("Insert student's note\n");
        str_temp = br.readLine();
        temp.setNotes(str_temp);
    }
    public static void addStudents() throws IOException
    {
        Student student_temp = new Student();
        Scanner input = new Scanner(System.in);                  
        System.out.print("Insert number of students you want to add\n");
        int num;
        num = input.nextInt();
        for (int i = 0; i < num; i++)
        {
            int j = i + 1;
            System.out.print("Student " + j + ":\n");
            addAStudent(student_temp);
            Bai1.myList.add(student_temp);
            System.out.print("-------------------------------------------\n");
        }
    }
    
    public static void showStudentList()
    {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Select one:");
        System.out.println("1. Student's code ascending order");
        System.out.println("2. Student's code decending order");
        System.out.println("3. Student's mark ascending order");
        System.out.println("4. Student's mark decending order");
        System.out.println("5. No sort");
        choice = scan.nextInt();
        switch (choice)
        {
            case 1:
            {
                sortCodeAscending();
                break;
            }
            
            case 2:
            {
                sortCodeDecending();
                break;
            }
            
            case 3:
            {
                sortMarkAscending();
                break;
            }
            
            case 4:
            {
                sortMarkDecending();
                break;
            }
            
            case 5:
            {
                break;
            }
            
            default:
            {
                System.out.println("System don't have this option");
                break;
            }
        }
        for (int i = 0; i < Bai1.myList.size(); i++)
        {
            System.out.print("Code: " + Bai1.myList.get(i).getCode() + "\n");
            System.out.print("Name: " + Bai1.myList.get(i).getName() + "\n");
            System.out.print("Mark: " + Bai1.myList.get(i).getMark()+ "\n");
            System.out.print("Avatar: " + Bai1.myList.get(i).getAvatar() + "\n");
            System.out.print("Address: " + Bai1.myList.get(i).getAddress() + "\n");
            System.out.print("Note: " + Bai1.myList.get(i).getNotes() + "\n");
            System.out.print("-------------------------------------------\n");
        }
    }
    
    public static void writeToFile() throws IOException
    {
        FileWriter fout;
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf8"));
        System.out.print("Insert csv file name to export (without .csv): ");
        filename = br.readLine();
        filename = filename + ".csv";
        fout = new FileWriter(filename);
        try
        {
            for (int i = 0; i < Bai1.myList.size(); i++)
            {
                fout.write("\"");
                fout.write(Bai1.myList.get(i).getCode() + "\",\"");
                fout.write(Bai1.myList.get(i).getName() + "\",\"");
                fout.write(String.valueOf(Bai1.myList.get(i).getMark())+ "\",\"");
                fout.write(Bai1.myList.get(i).getAvatar()+ "\",\"");
                fout.write(Bai1.myList.get(i).getAddress()+ "\",\"");
                fout.write(Bai1.myList.get(i).getNotes()+ "\"");
                fout.write("\r\n");
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        fout.close();        
    }
    
    public static void readFromFile() throws IOException
    {
        Bai1.myList.clear();
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in, "utf8"));
        System.out.print("Insert csv file name to import (without .csv): ");
        String csvFile = br1.readLine();
        csvFile = csvFile + ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {
                String[] info = line.split(cvsSplitBy);
                System.out.println("Code: " + info[0]);
                System.out.println("Name: " + info[1]);
                System.out.println("Mark: " + info[2]);
                System.out.println("Avatar: " + info[3]);
                System.out.println("Address: " + info[4]);
                System.out.println("Note: " + info[5]);
                System.out.println("------------------------------------------");
                Student temp = new Student();
                temp.setCode(info[0]);
                temp.setName(info[1]);
                temp.setMark(info[2]);
                temp.setAvatar(info[3]);
                temp.setAddress(info[4]);
                temp.setNotes(info[5]);
                Bai1.myList.add(temp);
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found");
        }
        catch (IOException e) 
        {
        }
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                }
            }
        }
    }
    
    public static void deleteStudent()
    {
        System.out.print("Insert student's code that you want to delete: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < Bai1.myList.size(); i++)
        {
            if (str.matches("(.*)" + Bai1.myList.get(i).getCode() + "(.*)"))
            {
                Bai1.myList.remove(i);
                System.out.println("Deleted student " + str);
                flag = true;
            }
        }
        if (flag == false)
        {
            System.out.println("This student doesn't exist in database");
        }
    }
    
    public static void updateStudentInfo() throws IOException
    {
        System.out.print("Insert student's code that you want to update: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        for (int i = 0; i < Bai1.myList.size(); i++)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf8"));
            Student temp;
            temp = new Student();
            temp = (Student) Bai1.myList.get(i);
            if (str.equals(temp.getCode()))
            {
                Bai1.myList.remove(i);
                System.out.println("1. Name");
                System.out.println("2. Mark");
                System.out.println("3. Avatar");
                System.out.println("4. Address");
                System.out.println("5. Note");
                System.out.print("Select field to update: ");
                int num;
                num = scan.nextInt();
                switch (num)
                {
                    case 1:
                    {
                        System.out.print("Insert student's name: ");
                        str = br.readLine();
                        temp.setName(str);
                        break;
                    }
                    
                    case 2:
                    {
                        System.out.print("Insert student's mark: ");
                        str = br.readLine();
                        temp.setMark(str);
                        break;
                    }
                    
                    case 3:
                    {
                        System.out.print("Insert student's avatar: ");
                        str = br.readLine();
                        temp.setAvatar(str);
                        break;
                    }
                    
                    case 4:
                    {
                        System.out.print("Insert student's address: ");
                        str = br.readLine();
                        temp.setAddress(str);
                        break;
                    }
                    
                    case 5:
                    {
                        System.out.print("Insert student's note: ");
                        str = br.readLine();
                        temp.setNotes(str);
                        break;
                    }
                    
                    default:
                    {
                        System.out.println("System don't have this option");
                        break;
                    }
                }
                Bai1.myList.add(temp);
            }
            else
            {
                System.out.println("This student doesn't exist in database");
            }
        }
    }
    
    public static void readBinaryFile() throws IOException
    {
        try
        {
            DataInputStream binFile = new DataInputStream(new FileInputStream("Student.bin"));
            while(binFile.available() > 0)
            {
                Student s_temp = new Student();
                String temp = binFile.readUTF();
                s_temp.setCode(temp);
                temp = binFile.readUTF();
                s_temp.setName(temp);
                temp = binFile.readUTF();
                s_temp.setMark(temp);
                temp = binFile.readUTF();
                s_temp.setAvatar(temp);
                temp = binFile.readUTF();
                s_temp.setAddress(temp);
                temp = binFile.readUTF();
                s_temp.setNotes(temp);
                Bai1.myList.add(s_temp);
            }
        }
        catch (IOException ex)
        {
            System.out.println("File input not found");
        }
    }
    
    public static void writeBinFile() throws IOException
    {
        DataOutputStream fout = new DataOutputStream(new FileOutputStream("Student.bin"));
        try
        {
            for (int i = 0; i < Bai1.myList.size(); i++)
            {
                fout.writeUTF(Bai1.myList.get(i).getCode());
                fout.writeUTF(Bai1.myList.get(i).getName());
                fout.writeUTF(String.valueOf(Bai1.myList.get(i).getMark()));
                fout.writeUTF(Bai1.myList.get(i).getAvatar());
                fout.writeUTF(Bai1.myList.get(i).getAddress());
                fout.writeUTF(Bai1.myList.get(i).getNotes());
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void sortCodeAscending()
    {
        for (int i = 0; i < Bai1.myList.size() - 1; i++)
        {
            for (int j = i + 1; j < Bai1.myList.size(); j++)
            {
                if (Integer.parseInt(Bai1.myList.get(i).getCode()) > Integer.parseInt(Bai1.myList.get(j).getCode()))
                {
                    Student t = new Student();
                    t = Bai1.myList.get(i);
                    Bai1.myList.set(i, Bai1.myList.get(j));
                    Bai1.myList.set(j, t);
                }
            }
        }
    }
    
    public static void sortCodeDecending()
    {
        for (int i = 0; i < Bai1.myList.size() - 1; i++)
        {
            for (int j = i + 1; j < Bai1.myList.size(); j++)
            {
                if (Integer.parseInt(Bai1.myList.get(i).getCode()) < Integer.parseInt(Bai1.myList.get(j).getCode()))
                {
                    Student t = new Student();
                    t = Bai1.myList.get(i);
                    Bai1.myList.set(i, Bai1.myList.get(j));
                    Bai1.myList.set(j, t);
                }
            }
        }
    }
    
    public static void sortMarkAscending()
    {
        for (int i = 0; i < Bai1.myList.size() - 1; i++)
        {
            for (int j = i + 1; j < Bai1.myList.size(); j++)
            {
                if (Float.parseFloat(Bai1.myList.get(i).getMark()) > Float.parseFloat(Bai1.myList.get(j).getMark()))
                {
                    Student t = new Student();
                    t = Bai1.myList.get(i);
                    Bai1.myList.set(i, Bai1.myList.get(j));
                    Bai1.myList.set(j, t);
                }
            }
        }
    }
    
    public static void sortMarkDecending()
    {
        for (int i = 0; i < Bai1.myList.size() - 1; i++)
        {
            for (int j = i + 1; j < Bai1.myList.size(); j++)
            {
                if (Float.parseFloat(Bai1.myList.get(i).getMark()) < Float.parseFloat(Bai1.myList.get(j).getMark()))
                {
                    Student t = new Student();
                    t = Bai1.myList.get(i);
                    Bai1.myList.set(i, Bai1.myList.get(j));
                    Bai1.myList.set(j, t);
                }
            }
        }
    }
}
