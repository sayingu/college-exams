public class UseJet {
    public static void main(String[] args) {
        Jet jet = new Jet("Boeing", "747", 1998, "Asiana", 400000, 2, 21, 44);
        System.out.println(jet.toString());
        System.out.println("jet.needsOverhaul() = " + jet.needsOverhaul());
        System.out.println("jet.isAging() = " + jet.isAging());
        System.out.println("");

        PassengerJet passengerJet = new PassengerJet("Lockheed", "DC-10", 2019, "US Air Force", 650000, 220, 53, 100,
                288, 6, false);
        System.out.println(passengerJet.toString());
        System.out.println("passengerJet.timeTillOverhaul() = " + passengerJet.timeTillOverhaul());
        System.out.println("passengerJet.needsOverhaul() = " + passengerJet.needsOverhaul());
        System.out.println("passengerJet.isHardToFly() = " + passengerJet.isHardToFly());
        System.out.println("passengerJet.needsLongRunway() = " + passengerJet.needsLongRunway());
        System.out.println("");

        BizJet bizJet = new BizJet("McDonnell-Douglas", "F-18", 2007, "Rockwell Collins", 450000, 70, 17, 100, 120,
                true);
        System.out.println(bizJet.toString());
        System.out.println("bizJet.timeTillOverhaul() = " + bizJet.timeTillOverhaul());
        bizJet.fly(140);
        System.out.println("bizJet.needsOverhaul() = " + bizJet.needsOverhaul());
        System.out.println("bizJet.isAging() = " + bizJet.isAging());
        System.out.println("bizJet.theJetRocks() = " + bizJet.theJetRocks());
        System.out.println("");
    }
}
