public class Property implements Comparable<Property> {
    private String address;
    private double monthlyRent;
    private int bedrooms;
    private double distanceToCampus;
    private boolean available;

    // Constructor to create a Property with all major details
    public Property(String address, double monthlyRent, int bedrooms, double distanceToCampus, boolean available) {
        this.address = address;
        this.monthlyRent = monthlyRent;
        this.bedrooms = bedrooms;
        this.distanceToCampus = distanceToCampus;
        this.available = available;
    }

    // Overloaded constructor with the "available" field as true.
    // If the user is adding a property it can be implied it is available.
    public Property(String address, double monthlyRent, int bedrooms, double distanceToCampus) {
        this(address, monthlyRent, bedrooms, distanceToCampus, true);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getDistanceToCampus() {
        return distanceToCampus;
    }

    public void setDistanceToCampus(double distanceToCampus) {
        this.distanceToCampus = distanceToCampus;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void markUnavailable() {
        available = false;
    }

    // Checks if the property is affordable for a given budget.
    public boolean isAffordable(double maxRent) {
        return monthlyRent <= maxRent;
    }


    // Calculates a match score based on rent, bedrooms, distance, and availability.
    // Higher scores represent better options for a student renter.
    public double calculateMatchScore() {
        double score = 100.0;
        score -= monthlyRent / 50.0;
        score += bedrooms * 12.0;
        score -= distanceToCampus * 5.0;

        if (!available) {
            score -= 40.0;
        }

        return score;
    }

     // Compares properties by match score so they can be sorted with Comparable.
     // Higher match scores come first.
    @Override
    public int compareTo(Property other) {
        return Double.compare(other.calculateMatchScore(), this.calculateMatchScore());
    }

    // Returns a readable string summary of the property.
    @Override
    public String toString() {
        return "Property[address = " + address
                + ", rent = $" + monthlyRent
                + ", bedrooms = " + bedrooms
                + ", distance = " + distanceToCampus + " km"
                + ", available = " + available + "]";
    }

    // Two properties are considered equal if they are the same type and have the same address.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Property other)) {
            return false;
        }

        return this.getClass() == other.getClass()
                && this.address.equalsIgnoreCase(other.address);
    }
}
