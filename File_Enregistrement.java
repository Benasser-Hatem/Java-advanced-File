package TD_File;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class File_Enregistrement extends JFrame implements ActionListener {

	private JTextField nom, prenom, adresse, telephone;
	private JButton save;
	private JButton affiche;
	private File file;
	public  File_Enregistrement() {
		JPanel p1 = new JPanel();
		
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		nom = new JTextField(10);
		p1.add(new JLabel("Nom :"));
		p1.add(nom);
		
		prenom = new JTextField(10);
		p1.add(new JLabel("Prenom :"));
		p1.add(prenom);
		
		adresse = new JTextField(10);
		p1.add(new JLabel("Adresse :"));
		p1.add(adresse);
		
		telephone = new JTextField(10);
		p1.add(new JLabel("Telephone :"));
		p1.add(telephone);
		
		save = new JButton("Sauvegarder");
		p1.add(save);
		affiche = new JButton("Afficher");
		p1.add(affiche);
		
		save.addActionListener(this);
		affiche.addActionListener(this);
		setLayout(new GridLayout(1,4));
		add(p1);		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		String name =nom.getText();
		String pre =prenom.getText();
		String adr =adresse.getText();
		String tel =telephone.getText();
	
		 
			 if (e.getSource() == save){
		try {
			FileWriter Writer = new FileWriter("Contact1.txt",true);
			Writer.write("Nom : "+name+"  Prénom : "+pre+"  Adresse : "+adr+"  Téléphone : "+tel);
			Writer.write(System.getProperty("line.separator"));
			Writer.close();
			JOptionPane.showMessageDialog(null,"Succes");
		
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,"Error");
			e1.printStackTrace();
		}
	}
			 if (e.getSource() == affiche){
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
	
	public static void main(String[] args) throws IOException {
		
		File_Enregistrement formulaire = new File_Enregistrement();		
		formulaire.pack();
		formulaire.setVisible(true);
		
	    }	
    }