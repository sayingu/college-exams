public class Application {
    private String name;

    // Next line is the street address in one line, city name in the next line,
    // state in another
    // line, and finally
    // zip code in a separate line.
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // The next line is a phone number consisting of the area code, prefix, and last
    // four digits all
    // separated
    // by a blank space.
    private String phone;

    // The next line is the id number of the application.
    private int id;

    // The next line is the intended major, e.g., Computer Science, Economics, etc.
    // A multi-word
    // name
    // should be allowed.
    private String major;

    // The next line is the applicant’s high school GPA, e.g., 3.96.
    private double highGpa;

    // The next line is an indication of whether the applicant is applying for a
    // scholarship or not.
    private boolean isScholar;

    public Application() {
        this.name = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.phone = "";
        this.id = -1;
        this.major = "";
        this.highGpa = 0;
        this.isScholar = false;
    }

    public Application(String name, String street, String city, String state, String zipCode, String phone, int id,
            String major, double highGpa, boolean isScholar) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.id = id;
        this.major = major;
        this.highGpa = highGpa;
        this.isScholar = isScholar;
    }

    public String toString() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append("\"").append(this.name).append("\"").append(newLine);
        sb.append("street: ").append("\"").append(this.street).append("\"").append(newLine);
        sb.append("city: ").append("\"").append(this.city).append("\"").append(newLine);
        sb.append("state: ").append("\"").append(this.state).append("\"").append(newLine);
        sb.append("zipCode: ").append("\"").append(this.zipCode).append("\"").append(newLine);
        sb.append("phone: ").append("\"").append(this.phone).append("\"").append(newLine);
        sb.append("id: ").append(this.id).append(newLine);
        sb.append("major: ").append("\"").append(this.major).append("\"").append(newLine);
        sb.append("highGpa: ").append(this.highGpa).append(newLine);
        sb.append("isScholar: ").append(this.isScholar).append(newLine);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getHighGpa() {
        return highGpa;
    }

    public void setHighGpa(double highGpa) {
        this.highGpa = highGpa;
    }

    public boolean isScholar() {
        return isScholar;
    }

    public void setScholar(boolean isScholar) {
        this.isScholar = isScholar;
    }
}
