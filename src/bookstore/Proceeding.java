//Matthew Kleimeyer
//mkleim2
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class Proceeding extends Publication implements Citable {
   
    private String city;
    
    protected int startingPage;
    protected int endPage;
    protected int year;
    
    //Parameterized constructor for proceedings
    public Proceeding(ArrayList<Author> auth, String inTitle, String inVenue, Publisher inPublisher, String city, int startingPage, int endPage, int year)
    {
        super(auth, inTitle, inVenue, inPublisher, startingPage, endPage);
        this.startingPage = startingPage;
        this.endPage = endPage;
        this.city = city;
        this.year = year;
                
    }   
    
    @Override //adds proceeding-specific items to Publication's cite method
    public String Cite() {
        return super.Cite() + String.format("%s, %d, pp: %d - %d", city, year, startingPage, endPage);
    }
    
}
