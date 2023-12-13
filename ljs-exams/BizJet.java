public class BizJet extends Jet {
    // numPassengers: that represents how many passengers the Jet can carry.
    private int numPassengers;
    // transOceanCertified: This is a Boolean that indicates the aircraft is
    // certified to fly over oceans by the FAA
    private boolean transOceanCertified;

    public BizJet() {
        super();
        this.numPassengers = 0;
        this.transOceanCertified = false;
    }

    public BizJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty, int lastOverhaul,
            int numOverhauls, int maxRecommendedFlightHours, int numPassengers, boolean transOceanCertified) {
        super(manufacturer, model, year, owner, grossWeightEmpty, lastOverhaul, numOverhauls,
                maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.transOceanCertified = transOceanCertified;
    }

    // theJetRocks: This returns true if the Biz Jet ‘rocks’ (is awesome). The jet
    // rocks if it holds at least 8
    // passengers and is transOceanCertified.
    public boolean theJetRocks() {
        return this.numPassengers >= 8 && this.transOceanCertified;
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("numPassengers: ").append(this.numPassengers).append(newLine);
        sb.append("transOceanCertified: ").append(this.transOceanCertified).append(newLine);
        return sb.toString();
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public boolean isTransOceanCertified() {
        return transOceanCertified;
    }

    public void setTransOceanCertified(boolean transOceanCertified) {
        this.transOceanCertified = transOceanCertified;
    }
}