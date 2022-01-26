package TD_File;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Afficher
{
public static void main(String[]args)
{
 try
 {

  FileReader readTextFile=new FileReader("Contact1.txt");
  Scanner fileReaderScan=new Scanner(readTextFile);

  String storeAllString="";
  while(fileReaderScan.hasNextLine())
  {
   String temp=fileReaderScan.nextLine()+"\n"; 
   storeAllString=storeAllString+temp;
  }

  JTextArea textArea=new JTextArea(storeAllString);
  textArea.setLineWrap(true);
  textArea.setWrapStyleWord(true);
  JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  JFrame frame=new JFrame("Open text file into JTextArea");
 
  frame.add(scrollBarForTextArea);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(500,500);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
 }
 catch(Exception exception)
 {

  System.out.println("Error in file processing");
 }
}
}
