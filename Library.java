import java.util.Hashtable;
/**
 * Library is the Building that collects all kinds of books and contains their availability by title.
 */
public class Library extends Building implements LibraryRequirements {

    /** 
     * All books in the library. 
     * */
    private Hashtable<String, Boolean> collection;

    /**
     * Constructs a new Library object.
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the total number of floors in the library
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Adds a title to the collection and marks it as available.
     * @param title the title to add
     */
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    /**
     * Removes a title from the collection.
     * @param title the title to remove
     * @return the title that was removed
     */
    public String removeTitle(String title) {
        this.collection.remove(title);
        return title;
    }

    /**
     * Checks out a title by marking it unavailable.
     * @param title the title to check out
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.replace(title, false);
        }
    }

    /**
     * Returns a title by marking it available again.
     * @param title the title to return
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.replace(title, true);
        }
    }

    /**
     * Returns whether the collection contains the given title.
     * @param title the title to check
     * @return true if the title is in the collection, false otherwise
     */
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * Returns whether the given title is currently available.
     * @param title the title to check
     * @return true if available, false otherwise
     */
    public boolean isAvailable(String title) {
        if (this.collection.containsKey(title)) {
            return this.collection.get(title);
        }
        return false;
    }

    /**
     * Prints the entire collection and each title's availability.
     */
    public void printCollection() {
        for (String title : this.collection.keySet()) {
            System.out.println(title + " | Available: " + this.collection.get(title));
        }
    }
public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "Northampton, MA", 4);

    System.out.println(myLibrary);
    System.out.println("Welcome to the library.");

    myLibrary.addTitle("The Rise and Fall of Ancient Egypt by Toby Wilkinson");
    myLibrary.addTitle("The Oxford History of Ancient Egypt by Ian Shaw");
    myLibrary.addTitle("The Art of War by Sun Tzu");
    myLibrary.addTitle("The Governance of China by Xi Jinping");

    System.out.println("Ops, checking books...");
    System.out.println("Do we have Sapiens? " + myLibrary.containsTitle("Sapiens by Yuval Noah Harari"));

    System.out.println("Is Ancient Egypt available? " +
        myLibrary.isAvailable("The Rise and Fall of Ancient Egypt by Toby Wilkinson"));

    myLibrary.checkOut("The Rise and Fall of Ancient Egypt by Toby Wilkinson");

    System.out.println("After checkout:");
    System.out.println("Is Ancient Egypt still available? " +
        myLibrary.isAvailable("The Rise and Fall of Ancient Egypt by Toby Wilkinson"));

    myLibrary.returnBook("The Rise and Fall of Ancient Egypt by Toby Wilkinson");

    System.out.println("After return:");
    System.out.println("Is Ancient Egypt available again? " +
        myLibrary.isAvailable("The Rise and Fall of Ancient Egypt by Toby Wilkinson"));

    System.out.println("Current collection:");
    myLibrary.printCollection();

    myLibrary.removeTitle("The Art of War by Sun Tzu");

    System.out.println("After removing The Art of War:");
    myLibrary.printCollection();
} 
}
