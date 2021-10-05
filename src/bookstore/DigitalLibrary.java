//Matthew Kleimeyer
//mkleim2
package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

//Enumeration with all allowed publisher names
enum Publisher{ELSEVIER, SPRINGER, IEEE, TAYLORFRANCIS, WILEY, ACM}; 

public class DigitalLibrary {
    
   private ArrayList<Publication> publications = new ArrayList<>();
   
   //Loads publications from text file, seperates publications between proceedings and journals
   public void loadPublications() throws FileNotFoundException, IllegalArgumentException
    {
        
        File input = new  File("publications.txt"); 
        Scanner in = new Scanner(input);
        
        
        while(in.hasNext())
        {
            String[] fields = in.nextLine().split(";");

            if(fields.length == 9)
            {
                
                int volume = Integer.parseInt(fields[4]);
                int number = Integer.parseInt(fields[5]);
                int startPage = Integer.parseInt(fields[6]);
                int endPage = Integer.parseInt(fields[7]);
                int year = Integer.parseInt(fields[8]);
                
                
                String[] authorStr = fields[0].split(",");
                ArrayList<Author> authList = new ArrayList();
                
                for(String s : authorStr)
                {
                    String[] temp = s.split(" ");
                    authList.add(new Author(temp[0], temp[1]));
                }
                
                Journal j = new Journal(authList, fields[1], fields[2], Publisher.valueOf(fields[3].toUpperCase()), volume, number, startPage, endPage, year);
                publications.add(j);
            }
            else if(fields.length == 8)
            {   
                
                int startPage = Integer.parseInt(fields[5]);
                int endPage = Integer.parseInt(fields[6]);
                int year = Integer.parseInt(fields[7]);
                
                
                
                String[] authorStr = fields[0].split(",");
                ArrayList<Author> authList = new ArrayList();
                
                for(String s : authorStr)
                {
                    String[] temp = s.split(" ");
                    authList.add(new Author(temp[0], temp[1]));
                }
                
                Proceeding p = new Proceeding(authList, fields[1], fields[2], getPub(fields[3]), fields[4], startPage, endPage, year);
                publications.add(p);
            }
            //COMPLETE[:)]: read each line of the file, based on the number of fields, decide whether it is a journal or a proceeding. Extarct the fields and add the publication to the publications ArrayList
        }
    }
   
   //Makes sure publisher is valid
   private Publisher getPub(String inPub)
   {
        try{ return Publisher.valueOf(inPub.toUpperCase()); }
        catch(IllegalArgumentException e){ throw e; }
   }
   
   
   //Lists loaded publications in a citation format
   public void listPublications()
   {
       Collections.sort(publications);
       int i=1;
       for(Publication p : publications)
       {
           System.out.printf("[%d] %s%n", i, p.Cite());
           i++;
       }
       //COMPLETE[*]: sort publications and print them. Add the numbers [1], [2], etc. at the begining of each line 
	   
   }
   
   
   //Saves citations to a text file
   public void saveCitations(String fileName) throws FileNotFoundException
   {
       PrintWriter prw = new PrintWriter(fileName + ".txt");
       
       //COMPLETE: Save citations to the file "fileName"
       Collections.sort(publications);
       int i=1;
       for(Publication p : publications)
       {
           prw.printf("[%d] %s%n", i, p.Cite());
           i++;
       }
       System.out.println(i + " citations have been saved to the file " + fileName + ".txt");
       prw.close();
       
   }
   
   
   
   
}