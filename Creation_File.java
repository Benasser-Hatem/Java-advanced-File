package TD_File;

import java.io.File;

public class Creation_File {
    public static void main(String args[])
    {
  
        try {
              
            File fw = new File("C:\\Contact.txt");
            
            if (fw.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}