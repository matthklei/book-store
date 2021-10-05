//Matthew Kleimeyer
//mkleim2
package bookstore;

public class Author implements Comparable<Author> {
    
    protected String firstName;
    protected String lastName;
    protected String institution;
    
    //Paremeterized constructor for Author, takes in first and last name
    public Author(String inFirst, String inLast)
    {
        firstName = inFirst;
        lastName = inLast;
    }
    
    //Sets institution of author
    public void setInstitution(String setInst)
    {
        institution = setInst;
    }

    @Override //allows for sorting in alphabetical order
    public int compareTo(Author other)
    {
        if(lastName.compareTo(other.lastName)!=0)
            return lastName.compareTo(other.lastName);
        else
            return firstName.compareTo(other.firstName);
    }

    
    
}
