public class Condo extends Property {
    private double monthlyCondoFee;
    private boolean hasGym;
    private boolean hasSecurity;

    public Condo(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                 boolean available, double monthlyCondoFee, boolean hasGym, boolean hasSecurity) {
        super(address, monthlyRent, bedrooms, distanceToCampus, available);
        this.monthlyCondoFee = monthlyCondoFee;
        this.hasGym = hasGym;
        this.hasSecurity = hasSecurity;
    }

    // Overloaded constructor that assumes the condo is available.
    public Condo(String address, double monthlyRent, int bedrooms, double distanceToCampus,
                 double monthlyCondoFee, boolean hasGym, boolean hasSecurity) {
        this(address, monthlyRent, bedrooms, distanceToCampus, true, monthlyCondoFee, hasGym, hasSecurity);
    }

    public double getMonthlyCondoFee() {
        return monthlyCondoFee;
    }

    public void setMonthlyCondoFee(double monthlyCondoFee) {
        this.monthlyCondoFee = monthlyCondoFee;
    }

    public boolean hasGym() {
        return hasGym;
    }

    public void setHasGym(boolean hasGym) {
        this.hasGym = hasGym;
    }

    public boolean hasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    // Calculates the full monthly housing cost including condo fees.
    public double calculateTotalMonthlyCost() {
        return getMonthlyRent() + monthlyCondoFee;
    }

    // Calculates a match score that rewards amenities but penalizes extra condo fees.
    @Override
    public double calculateMatchScore() {
        double score = super.calculateMatchScore();
        score -= monthlyCondoFee / 25.0;

        if (hasGym) {
            score += 8.0;
        }

        if (hasSecurity) {
            score += 6.0;
        }

        return score;
    }

    @Override
    public String toString() {
        return "Condo[address = " + getAddress()
                + ", rent = $" + getMonthlyRent()
                + ", bedrooms = " + getBedrooms()
                + ", distance = " + getDistanceToCampus() + " km"
                + ", available = " + isAvailable()
                + ", condoFee = $" + monthlyCondoFee
                + ", gym = " + hasGym
                + ", security = " + hasSecurity + "]";
    }
}
