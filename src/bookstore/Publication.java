//Matthew Kleimeyer
//mkleim2
package bookstore;

import static java.lang.Character.isUpperCase;
import java.util.ArrayList;
import java.util.Collections;


public class Publication implements Citable, Comparable<Publication> {
    
    private ArrayList<Author> authors;
    
    private String title;
    private String venue;
    private Publisher publisher;
    
    protected int startingPage;
    protected int endPage;
    protected int year;
    
    //Parameterized constructor for Publication
    public Publication(ArrayList<Author> auth, String inTitle, String inVenue, Publisher inPublisher, int start, int ending)
    {
        authors = auth;
        title = inTitle;
        venue = inVenue;
        publisher = inPublisher;
        
        Collections.sort(auth);
        
    }
    
    //Useless piece of code that doesn't work for some reason even though by all logical intuition it should
//    public void addAuthor(Author author)
//    {
//        authors.add(author);
//    }
    
    //Displays data in citation format
    public String Cite() {
        String authorNames = "";
        String result = "";
        
        if(authors.size() == 1)
            authorNames += String.format("%s. %s,", authors.get(0).firstName.charAt(0), authors.get(0).lastName);
        else if(authors.size() == 2)
            authorNames += String.format("%s. %s and %s. %s, ", authors.get(0).firstName.charAt(0), authors.get(0).lastName, authors.get(1).firstName.charAt(0), authors.get(1).lastName);
        else if(authors.size() > 2)
        {
            for(int i=0; i<authors.size()-1; i++)
            {
                authorNames += String.format("%s. %s, ", authors.get(i).firstName.charAt(0), authors.get(i).lastName);
            }
            authorNames += String.format("and %s. %s, ", authors.get(authors.size()-1).firstName.charAt(0), authors.get(authors.size()-1).lastName);
        }
        
        result += authorNames;
        
        result += "\"" + title + "\"" + ", ";
        result += venue + " (";
        
        String acronym = "";
        String[] temp = venue.split(" ");
        for(int i=0; i < temp.length; i++)
        {
            if(isUpperCase(temp[i].charAt(0)))
                acronym += temp[i].charAt(0);
        }
        
        result += acronym + "), " + publisher + ", ";
        return result;
        
        
    }

    @Override //Allows for sorting based on author's names, then venue, then year
    public int compareTo(Publication other) {
        if(authors.get(0).compareTo(other.authors.get(0)) != 0)
            return authors.get(0).compareTo(other.authors.get(0));
        else if(venue.compareTo(other.venue) != 0)
            return venue.compareTo(other.venue);
        else
            return Integer.compare(year, other.year);
    }
    
}




