public class Jet implements Comparable<Jet> {
    // The manufacturer of a Jet such as ”Boeing”, ”Lockheed”, ”McDonnell-Douglas”,
    // etc.
    private String manufacturer;

    // model such as ”747”, ”DC-10”, ”F-18”, etc.
    private String model;

    // year such as 2019, 2007, etc.
    private int year;

    // owner (e.g., “Asiana”, “US Air Force”, “Rockwell Collins”, etc)
    private String owner;

    // grossWeightEmpty which is the weight of the aircraft in lbs
    private double grossWeightEmpty;

    // lastOverhaul which is the number of flight hours since the last engine
    // overhaul (assume all
    // enginers
    // are overhauled at the same time for multi engine aircraft.
    private int lastOverhaul;

    // numOverhauls: This is the number of overhauls that have been performed on the
    // engine
    private int numOverhauls;

    // maxRecommendedFlightHours which is the maximum recommended flight hours
    // before performing
    // an overhaul.
    private int maxRecommendedFlightHours;

    // Also include at least one constructor that makes sense.
    public Jet() {
        this.manufacturer = "";
        this.model = "";
        this.year = 1900;
        this.owner = "";
        this.grossWeightEmpty = 0;
        this.lastOverhaul = 0;
        this.numOverhauls = 0;
        this.maxRecommendedFlightHours = 0;
    }

    public Jet(String manufacturer, String model, int year, String owner, double grossWeightEmpty, int lastOverhaul,
            int numOverhauls, int maxRecommendedFlightHours) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.grossWeightEmpty = grossWeightEmpty;
        this.lastOverhaul = lastOverhaul;
        this.numOverhauls = numOverhauls;
        this.maxRecommendedFlightHours = maxRecommendedFlightHours;
    }

    // sellTo that consumes one argument, namely the name of the new owner of the
    // jet. This is how
    // you sell
    // a jet.
    public void sellTo(String newOwner) {
        this.owner = newOwner;
    }

    // overhaul that resets the hours since last overhaul when called.
    public void overhaul() {
        this.lastOverhaul = 0;
    }

    // timeTillOverhaul: This returns the number of flight hours left before
    // reaching the maximum
    // hours
    // before overhauling the engines.
    public int timeTillOverhaul() {
        return this.maxRecommendedFlightHours - this.lastOverhaul;
    }

    // fly: This takes 1 parameter, an integer number of hours that the plane has
    // flown for a
    // particular day. It
    // increments lastOverhaul by that many hours.
    public void fly(int flown) {
        this.lastOverhaul += flown;
    }

    // needsOverhaul: This returns a Boolean to indicate if the amount of flight
    // hours is within 100
    // hours of
    // the maximum recommended flight hours between overhauls.
    public boolean needsOverhaul() {
        return (this.lastOverhaul - this.maxRecommendedFlightHours > 100);
    }

    // isAging: This returns a Boolean. True if the Jet is more than 15 years old
    // and has had 20
    // overhauls or
    // more. Otherwise, it returns false. Assume the current year is 2019.
    public boolean isAging() {
        return (2019 - this.year > 15 && this.numOverhauls >= 20);
    }

    // Your class should also inherit (i.e., use the implements keyword) the
    // Comparable interface
    @Override
    public int compareTo(Jet jet) {
        return jet.getModel().compareTo(jet.getModel());
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("manufacturer: ").append("\"").append(this.manufacturer).append("\"").append(newLine);
        sb.append("model: ").append("\"").append(this.model).append("\"").append(newLine);
        sb.append("year: ").append(this.year).append(newLine);
        sb.append("owner: ").append("\"").append(this.owner).append("\"").append(newLine);
        sb.append("grossWeightEmpty: ").append(this.grossWeightEmpty).append(newLine);
        sb.append("lastOverhaul: ").append(this.lastOverhaul).append(newLine);
        sb.append("numOverhauls: ").append(this.numOverhauls).append(newLine);
        sb.append("maxRecommendedFlightHours: ").append(this.maxRecommendedFlightHours).append(newLine);
        return sb.toString();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getGrossWeightEmpty() {
        return grossWeightEmpty;
    }

    public void setGrossWeightEmpty(double grossWeightEmpty) {
        this.grossWeightEmpty = grossWeightEmpty;
    }

    public float getLastOverhaul() {
        return lastOverhaul;
    }

    public void setLastOverhaul(int lastOverhaul) {
        this.lastOverhaul = lastOverhaul;
    }

    public int getNumOverhauls() {
        return numOverhauls;
    }

    public void setNumOverhauls(int numOverhauls) {
        this.numOverhauls = numOverhauls;
    }

    public float getMaxRecommendedFlightHours() {
        return maxRecommendedFlightHours;
    }

    public void setMaxRecommendedFlightHours(int maxRecommendedFlightHours) {
        this.maxRecommendedFlightHours = maxRecommendedFlightHours;
    }
}
