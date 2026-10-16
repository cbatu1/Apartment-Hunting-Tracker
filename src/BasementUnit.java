public class BasementUnit extends Property {
    private boolean furnished;
    private boolean separateEntrance;

    public BasementUnit(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                        boolean available, boolean furnished, boolean separateEntrance) {
        super(address, monthlyRent, bedrooms, distanceToCampus, available);
        this.furnished = furnished;
        this.separateEntrance = separateEntrance;
    }

    // Overloaded constructor that assumes the basement unit is available.
    public BasementUnit(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                        boolean furnished, boolean separateEntrance) {
        this(address, monthlyRent, bedrooms, distanceToCampus, true, furnished, separateEntrance);
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public boolean hasSeparateEntrance() {
        return separateEntrance;
    }

    public void setSeparateEntrance(boolean separateEntrance) {
        this.separateEntrance = separateEntrance;
    }

    // Checks whether the basement unit is a strong budget option.
    public boolean isGoodBudgetOption() {
        return getMonthlyRent() < 1300 && separateEntrance;
    }

    // Calculates a match score that rewards furnishing and a separate entrance.
    @Override
    public double calculateMatchScore() {
        double score = super.calculateMatchScore();

        if (furnished) {
            score += 7.0;
        }

        if (separateEntrance) {
            score += 10.0;
        }

        return score;
    }

    @Override
    public String toString() {
        return "BasementUnit[address = " + getAddress()
                + ", rent = $" + getMonthlyRent()
                + ", bedrooms = " + getBedrooms()
                + ", distance = " + getDistanceToCampus() + " km"
                + ", available = " + isAvailable()
                + ", furnished = " + furnished
                + ", separateEntrance = " + separateEntrance + "]";
    }
}
