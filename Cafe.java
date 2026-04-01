/**
 * Cafe is the place that sells coffee and manages inventory.
 * Its inventory includes coffee, sugar packets, cream servings, and cups.
 */
public class Cafe extends Building implements CafeRequirements {

    /** 
     * The number of ounces of coffee currently in stock. 
     */
    private int nCoffeeOunces;

    /** 
     * The number of sugar packets currently in stock. 
     */
    private int nSugarPackets;

    /** 
     * The number of cream servings currently in stock. 
     */
    private int nCreams;

    /** 
     * The number of cups currently in stock. 
     */
    private int nCups;

    /**
     * Constructs a new Cafe object with a starting inventory.
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the total number of floors in the cafe
     * @param coffee the  ounces of coffee in stock
     * @param sugar the sugar packets in stock
     * @param creams the cream servings in stock
     * @param cups the cups in stock
     */
    public Cafe(String name, String address, int nFloors,
                int coffee, int sugar, int creams, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = creams;
        this.nCups = cups;
    }

    /**
     * This sells each cup of coffee and updates, restock the inventory .
     * @param size the number of ounces of coffee requested
     * @param sugar the number of sugar packets requested
     * @param creams the number of cream servings requested
     */
    public void sellCoffee(int size, int sugar, int creams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < sugar
                || this.nCreams < creams || this.nCups < 1) {
            System.out.println("Ops, restocking...");
            this.restock(50, 20, 20, 10);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugar;
        this.nCreams -= creams;
        this.nCups -= 1;

        System.out.println("Sold a " + size + " oz coffee with "
                + sugar + " sugar packet(s) and "
                + creams + " cream serving(s).");
    }

    /**
     * This restocks the cafe's inventory by adding more coffee, sugar, cream, and cups.
     * @param coffee the number of ounces of coffee to add
     * @param sugar the number of sugar packets to add
     * @param creams the number of cream servings to add
     * @param cups the number of cups to add
     */
    private void restock(int coffee, int sugar, int creams, int cups) {
        this.nCoffeeOunces += coffee;
        this.nSugarPackets += sugar;
        this.nCreams += creams;
        this.nCups += cups;

        System.out.println("Bingo, inventory restocked.");
    }

    /**
     * Tests the Cafe class by creating a Cafe object and selling coffee.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "Near finals week", 1,
                10, 5, 5, 2);

        System.out.println(myCafe);

        myCafe.sellCoffee(12, 2, 1);
        myCafe.sellCoffee(20, 3, 2);
        myCafe.sellCoffee(8, 1, 1);
    }
}