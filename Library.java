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
    Library myLibrary = new Library("Totally Not Procrastinating Library", "Somewhere near finals week", 5);

    System.out.println(myLibrary);
    System.out.println("Welcome. Please pretend you're here to study.");

  
    myLibrary.addTitle("How to Start Homework at 2AM by Me");
    myLibrary.addTitle("50 Ways to Avoid Doing Problem Sets");
    myLibrary.addTitle("I Swear I'll Go to Office Hours Tomorrow");
    myLibrary.addTitle("Emotional Damage: Midterm Edition");

  
    System.out.println("Checking books...");
    System.out.println("Do we have motivation? " +
        myLibrary.containsTitle("Motivation"));

    System.out.println("Is '2AM Homework' available? " +
        myLibrary.isAvailable("How to Start Homework at 2AM by Me"));


    myLibrary.checkOut("How to Start Homework at 2AM by Me");

    System.out.println("\nAfter panic checkout:");
    System.out.println("Is it still available? " +
        myLibrary.isAvailable("How to Start Homework at 2AM by Me"));


    myLibrary.returnBook("How to Start Homework at 2AM by Me");

    System.out.println("\nAfter pretending everything is fine:");
    System.out.println("Is it available again? " +
        myLibrary.isAvailable("How to Start Homework at 2AM by Me"));

   
    System.out.println("Current collection (aka coping mechanisms):");
    myLibrary.printCollection();

   
    myLibrary.removeTitle("50 Ways to Avoid Doing Problem Sets");

    System.out.println("Character development unlocked:");
    myLibrary.printCollection();
    }
}