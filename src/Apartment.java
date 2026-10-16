public class Apartment extends Property {
    private int floorNumber;
    private boolean hasLaundry;

    public Apartment(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                     boolean available, int floorNumber, boolean hasLaundry) {
        super(address, monthlyRent, bedrooms, distanceToCampus, available);
        this.floorNumber = floorNumber;
        this.hasLaundry = hasLaundry;
    }

    // Overloaded constructor that assumes apartment is available.
    public Apartment(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                     int floorNumber, boolean hasLaundry) {
        this(address, monthlyRent, bedrooms, distanceToCampus, true, floorNumber, hasLaundry);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean hasLaundry() {
        return hasLaundry;
    }

    public void setHasLaundry(boolean hasLaundry) {
        this.hasLaundry = hasLaundry;
    }

    // Checks whether the apartment is convenient based on laundry access and floor.
    public boolean hasGoodConvenience() {
        return hasLaundry && floorNumber <= 3;
    }

    // Calculates a match score that rewards laundry access and slightly penalizes very high floors.
    @Override
    public double calculateMatchScore() {
        double score = super.calculateMatchScore();

        if (hasLaundry) {
            score += 12.0;
        }

        if (floorNumber > 5) {
            score -= 5.0;
        }

        return score;
    }

    @Override
    public String toString() {
        return "Apartment[address = " + getAddress()
                + ", rent = $" + getMonthlyRent()
                + ", bedrooms = " + getBedrooms()
                + ", distance = " + getDistanceToCampus() + " km"
                + ", available = " + isAvailable()
                + ", floor = " + floorNumber
                + ", laundry = " + hasLaundry + "]";
    }

}
