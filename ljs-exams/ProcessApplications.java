// You will have to complete this file by replacing FILL_IT_IN with
// appropriate Java code (most likely multiple lines) and by adding
// additional code where needed.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessApplications {

    public static String readALine(BufferedReader input) {
        String line = "";
        try {
            line = input.readLine();
        } catch (IOException e) {
            System.out.println("Oops");
            line = null;
        }
        return line;
    }

    // Rather than catching IOException's in main, main can pass it on
    // by 'throw'ing it, which is what I chose to do here.
    //
    public static void main(String[] args) throws IOException {
        // String inputFile = "./a0.txt";
        String inputFile = "./a1(100 application records).txt";

        // Pattern to be used to "open an input file"
        BufferedReader input = new BufferedReader(new FileReader(inputFile));

        // I am assuming that there is at least one line in the input file.
        int numApplications = Integer.parseInt(readALine(input));
        Application[] applications = new Application[numApplications];

        int i = 0;
        String name = readALine(input); // Read the name of first application
        while (name != null) { // Reached the end of the input file?
            // Next line is the street address in one line, city name in the next line, state in
            // another line, and finally
            // zip code in a separate line.
            String street = readALine(input);
            String city = readALine(input);
            String state = readALine(input);
            String zipCode = readALine(input);

            // The next line is a phone number consisting of the area code, prefix, and last four
            // digits all separated
            // by a blank space.
            String phone = readALine(input);

            // The next line is the id number of the application.
            String id = readALine(input);

            // The next line is the intended major, e.g., Computer Science, Economics, etc. A
            // multi-word name
            // should be allowed.
            String major = readALine(input);

            // The next line is the applicant’s high school GPA, e.g., 3.96.
            String highGpa = readALine(input);

            // The next line is an indication of whether the applicant is applying for a scholarship
            // or not.
            String isScholar = readALine(input);

            applications[i++] =
                    new Application(name, street, city, state, zipCode, phone, Integer.parseInt(id),
                            major, Double.parseDouble(highGpa), Boolean.parseBoolean(isScholar));

            // If there is another application record in the file, it will follow next in the same
            // format.
            name = readALine(input);
        }

        input.close(); // Close it when done reading from it.

        // Now that we have all the application objects in an array, we can
        // use those objects to do whatever we want to do.

        // Find scholarship recipients. An applicant is considered a scholarship
        // recipient if:
        // (1) his or her high school GPA is higher than 3.8,
        // (2) his or her intented major is one of the following: Philosophy,
        // History, or Sociology,
        // (3) s/he is from Montana or Idaho, and
        // (4) s/he is applying for scholarship.
        // Find and print all the scholarship recipients.
        for (Application application : applications) {
            if (application.getHighGpa() > 3.8
                    && (application.getMajor().equals("Philosophy")
                            || application.getMajor().equals("History")
                            || application.getMajor().equals("Sociology"))
                    && (application.getState().equals("Montana")
                            || application.getState().equals("Idaho"))
                    && application.isScholar()) {
                System.out.println(application.toString());
            }
        }
        System.out.println("");

        // Print the average GPA of all the applicants from California:
        double totalHighGpa = 0;
        int totalCount = 0;
        for (Application application : applications) {
            if (application.getState().equals("California")) {
                totalHighGpa += application.getHighGpa();
                totalCount++;
            }
        }
        System.out.println("Print the average GPA of all the applicants from California: "
                + ((totalHighGpa == 0) ? "0" : totalHighGpa / totalCount));
        System.out.println("");

        // Find the applicant whose GPA is the highest among the applicants
        // from the state of Washington and print the name and the GPA of
        // that applicant.
        double highestGpa = 0;
        String highestGpaName = "";
        for (Application application : applications) {
            if (application.getState().equals("Washington")
                    && application.getHighGpa() > highestGpa) {
                highestGpa = application.getHighGpa();
                highestGpaName = application.getName();
            }
        }
        System.out.println("highest among the applicants from the state of Washington: "
                + highestGpaName + ", " + highestGpa);
        System.out.println("");

        // Find and print the number of applications from each state
        // in this format (alphabetical order):
        //
        // State, No of Applications
        // Arizona, 5
        // California, 20
        // Oregon, 6
        // Washington, 7
        //
        // You may assume that the only valid state names are the 50
        // states in the USA. That is, you will only see at most
        // those names in your input file. In your output, do NOT
        // include the state names from which there is no application.
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Application application : applications) {
            boolean exists = false;
            for (Map<String, Object> map : list) {
                if (((String) map.get("state")).equals(application.getState())) {
                    map.put("num", ((int) map.get("num")) + 1);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", application.getState());
                map.put("num", 1);
                list.add(map);
            }
        }
        list.sort(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> m1, Map<String, Object> m2) {
                return ((String) m1.get("state")).compareTo((String) m2.get("state"));
            }
        });
        System.out.println("State, No of Applications");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("state") + ", " + map.get("num"));
        }
        System.out.println("");
    }
}
