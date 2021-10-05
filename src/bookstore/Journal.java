//Matthew Kleimeyer
//mkleim2
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class Journal extends Publication implements Citable {
    
    private int volume;
    private int number;
   
    //Parameterized constructor for Journal
    public Journal(ArrayList<Author> auth, String inTitle, String inVenue, Publisher inPublisher, int volume, int number, int startingPage, int endPage, int year)
    {
        super(auth, inTitle, inVenue, inPublisher, startingPage, endPage);
        this.volume = volume;
        this.number = number;
        this.startingPage = startingPage;
        this.endPage = endPage;
        this.year = year;
    }
    

    @Override //Adds journal-specific items to citation
    public String Cite() {
        return super.Cite() + String.format("%d(%d): %d - %d, %d", volume, number, startingPage, endPage, year);
    }
    
}
