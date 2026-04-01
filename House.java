/* This is a stub for the House class */
import java.util.ArrayList;
/**
 * This is a House, similar to Smith Housing system, that not only have student residents but also sometimes have a dining room.
 */
public class House extends Building implements HouseRequirements {

    /** 
    This is a list of students that live in the house. 
    */
    private ArrayList<Student> residents;

    /** 
     * This tells us whether this house has a dining room. 
     */
    private boolean hasDiningRoom;

  
    /**
     * Constructs a new House object.
     * @param name  the name of the house
     * @param address  the address of the house
     * @param nFloors  the total number of floors in the house
     * @param hasDiningRoom  whether the house has a dining room
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<Student>();
        this.hasDiningRoom = hasDiningRoom;
    }

    /**
     * Return true if the house has a dining room, false otherwise
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Return the total number of residents in the house
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Moves a student in the house, aka add them to the residents list.
     * @param s the student who is moving in the house
     */  
    public void moveIn(Student s) {
        this.residents.add(s);
    }

    /**
     * Moves a student out the house, aka delete them from the residents list.
     * @param s the student who is moving out of the house
     */
    public Student moveOut(Student s) {
        this.residents.remove(s);
        return s;
    }

    /**
     * Return true if the student is indeed the resident of the house, false otherwise
     */
    public boolean isResident(Student s) {
        return this.residents.contains(s);
    }

    /**
     * Tests the House class that wrote above.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        House myHouse = new House("Lawrence House", "99 Green Street", 4, false);

        Student s1 = new Student("Yuli", "20050220qhy", 2027);
        Student s2 = new Student("Kathy", "20050619lqh", 2027);

        System.out.println(myHouse);
        System.out.println("Has dining room? " + myHouse.hasDiningRoom());
        System.out.println("Number of residents: " + myHouse.nResidents());

        myHouse.moveIn(s1);
        myHouse.moveIn(s2);

        System.out.println("After move in:");
        System.out.println("Number of residents: " + myHouse.nResidents());
        System.out.println("Is Yuli a resident? " + myHouse.isResident(s1));

        myHouse.moveOut(s1);

        System.out.println("After move out:");
        System.out.println("Number of residents: " + myHouse.nResidents());
        System.out.println("Is Yuli a resident? " + myHouse.isResident(s1));
    }
}


