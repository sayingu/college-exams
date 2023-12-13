public class PassengerJet extends Jet {
    // numPassengers that represents the number of passengers the jet can carry.
    private int numPassengers;
    // numEngines: The number of engines the Jet has
    private int numEngines;
    // hasAutopilot: The aircraft has full autopilot capabilities.
    private boolean hasAutopilot;

    public PassengerJet() {
        super();
        this.numPassengers = 0;
        this.numEngines = 0;
        this.hasAutopilot = false;
    }

    public PassengerJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
            int lastOverhaul, int numOverhauls, int maxRecommendedFlightHours, int numPassengers, int numEngines,
            boolean hasAutopilot) {
        super(manufacturer, model, year, owner, grossWeightEmpty, lastOverhaul, numOverhauls,
                maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.numEngines = numEngines;
        this.hasAutopilot = hasAutopilot;
    }

    // isHardToFly: This returns a Boolean. The jet is hard to fly if there is no
    // autopilot.
    public boolean isHardToFly() {
        return !this.hasAutopilot;
    }

    // needsLongRunway: This returns true if the grossEmptyWeight is greater than
    // 500000 lbs.
    public boolean needsLongRunway() {
        return super.getGrossWeightEmpty() > 500000;
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("numPassengers: ").append(this.numPassengers).append(newLine);
        sb.append("numEngines: ").append(this.numEngines).append(newLine);
        sb.append("hasAutopilot: ").append(this.hasAutopilot).append(newLine);
        return sb.toString();
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    public boolean isHasAutopilot() {
        return hasAutopilot;
    }

    public void setHasAutopilot(boolean hasAutopilot) {
        this.hasAutopilot = hasAutopilot;
    }
}