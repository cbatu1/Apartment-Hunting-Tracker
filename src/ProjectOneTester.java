import java.util.ArrayList;

/**
 * Apartment Hunting Tracker
 *
 * This program helps a renter store and compare different kinds of potential rental properties. Property
 * is used as the superclass that represents general rental information, which is then used by 3 other
 * subclasses Apartment, Condo, and BasementUnit. Each subclass adds its own unique fields and behavior
 * such as laundry access, condo fees, security, furnishing, or a separate entrance.
 *
 * ApartmentTracker is used for adding and removing listings, printing available listings, searching by
 * budget, finding the cheapest listing, sorting them, and finding an overall best match for the renter.
 * The Property class implements Comparable, which helps to sort the listings by match score.
 *
 * The scoring system is based on what would typically matter the most to a renter searching for an
 * apartment. Price, distance, and bedrooms were used as the largest factors affecting the score in this
 * case. Extra features did not impact the score as much, since they are being treated as "nice to have"s
 * rather than necessities. If a property is unavailable, there is a large penalty to the score since it
 * is very useful to the renter.
 */

public class ProjectOneTester {
    public static void main(String[] args) {
        ApartmentTracker tracker = new ApartmentTracker("Student Rental Search");

        Apartment apt1 = new Apartment("100 College St", 1650, 1, 1.8, 2, true);
        Apartment apt2 = new Apartment("89 Jarvis St", 1850, 2, 3.2, false, 7, false);

        Condo condo1 = new Condo("88 Sedgeway St", 2100, 1, 2.5, 250, true, true);
        Condo condo2 = new Condo("13 Yonge St", 1950, 1, 4.0, true, 300, false, true);

        BasementUnit basement1 = new BasementUnit("22 Oak Ave", 1200, 1, 5.5, true, true);
        BasementUnit basement2 = new BasementUnit("10 Pine Rd", 1100, 1, 6.0, false, false);

        tracker.addListing(apt1);
        tracker.addListing(apt2);
        tracker.addListing(condo1);
        tracker.addListing(condo2);
        tracker.addListing(basement1);
        tracker.addListing(basement2);

        tracker.printAllListings();
        System.out.println();

        tracker.showAvailableListings();
        System.out.println();

        System.out.println("Cheapest listing:");
        System.out.println(tracker.findCheapestListing());
        System.out.println();

        System.out.println("Best overall match:");
        System.out.println(tracker.getBestMatch());
        System.out.println();

        System.out.println("Listings under $1700:");
        ArrayList<Property> budgetListings = tracker.searchByMaxRent(1700);
        for (Property property : budgetListings) {
            System.out.println(property);
        }

        System.out.println();

        System.out.println("Testing subclass methods:");
        System.out.println("apt1 has good convenience? " + apt1.hasGoodConvenience());
        System.out.println("condo1 total monthly cost: $" + condo1.calculateTotalMonthlyCost());
        System.out.println("basement1 good budget option? " + basement1.isGoodBudgetOption());
        System.out.println();

        // Checking functionality of equals()
        System.out.println("Testing equals():");
        Apartment anotherApt = new Apartment("100 College St", 1700, 1, 2.0, 3, true);
        System.out.println("apt1 equals anotherApt? " + apt1.equals(anotherApt));
        System.out.println();

        System.out.println("Sorted listings by match score:");
        tracker.sortListings();
        tracker.printAllListings();
        System.out.println();

        System.out.println("Marking one listing unavailable!");
        apt1.markUnavailable();
        tracker.showAvailableListings();
    }
}
