import java.util.ArrayList;
import java.util.Collections;

public class ApartmentTracker {
    private String trackerName;
    private ArrayList<Property> listings;

    // Creates a tracker with a default name.
    public ApartmentTracker() {
        this("My Apartment Tracker");
    }

    // Creates a tracker with a custom name.
    public ApartmentTracker(String trackerName) {
        this.trackerName = trackerName;
        this.listings = new ArrayList<Property>();
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public void addListing(Property property) {
        listings.add(property);
    }

    public boolean removeListing(Property property) {
        return listings.remove(property);
    }

    public void printAllListings() {
        System.out.println("---- " + trackerName + " ----");
        for (Property property : listings) {
            System.out.println(property);
        }
    }

    public void showAvailableListings() {
        System.out.println("---- Available Listings ----");
        for (Property property : listings) {
            if (property.isAvailable()) {
                System.out.println(property);
            }
        }
    }

    public Property findCheapestListing() {
        if (listings.isEmpty()) {
            return null;
        }

        Property cheapest = listings.getFirst();

        for (Property property : listings) {
            if (property.getMonthlyRent() < cheapest.getMonthlyRent()) {
                cheapest = property;
            }
        }

        return cheapest;
    }

    // Returns a list of properties that fit within a given maximum rent.
    public ArrayList<Property> searchByMaxRent(double maxRent) {
        ArrayList<Property> matches = new ArrayList<Property>();

        for (Property property : listings) {
            if (property.isAffordable(maxRent)) {
                matches.add(property);
            }
        }

        return matches;
    }

    // Finds and returns the property with the highest match score.
    public Property getBestMatch() {
        if (listings.isEmpty()) {
            return null;
        }

        Property best = listings.getFirst();

        for (Property property : listings) {
            if (property.calculateMatchScore() > best.calculateMatchScore()) {
                best = property;
            }
        }

        return best;
    }

    // Sorts all listings using the compareTo method defined in Property.
    public void sortListings() {
        Collections.sort(listings);
    }
}
