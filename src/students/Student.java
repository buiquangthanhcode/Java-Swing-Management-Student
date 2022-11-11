package students;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    private String id;
    private String fullname;
    private double gpa;
    private String image;
    private String address;
    private String notes;
    public static final String ID = "id";
    public static final String FULLNAME = "fullname";
    public static final String IMAGE = "image";
    public static final String GPA = "gpa";
    public static final String ADDRESS = "address";
    public static final String NOTES = "notes";

    // method
    public Student() {
        this.id = "";
        this.fullname = "";
        this.gpa = 0;
        this.image = "";
        this.address = "";
        this.notes = "";
    }

    public Student(String id, String fullname, double gpa, String image, String address, String notes) {
        this.id = id;
        this.fullname = fullname;
        this.gpa = gpa;
        this.image = image;
        this.address = address;
        this.notes = notes;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGPA(Double gpa) {
        this.gpa = gpa;
    }

    public void setIamge(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getID() {
        return this.id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getImage() {
        return this.image;
    }

    public String getAddress() {
        return this.address;
    }

    public String getNotes() {
        return this.notes;
    }

    public double getGPA() {
        return this.gpa;
    }

    public static boolean isNumeric(String string) {
        // Checks if the provided string
        // is a numeric by applying a regular
        // expression on it.
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

    public void input() {
        Scanner input = new Scanner(System.in);
        String number;
        System.out.print("Please enter student's ID: ");
        id = input.nextLine();
        System.out.print("Please enter student's fullame: ");
        fullname = input.nextLine();
        do {
            System.out.print("Please enter student's GPA: ");

            number = input.nextLine();
            if (isNumeric(number)) {
                gpa = Double.parseDouble(number);
            } else {
                System.out.println("Please enter number");
            }
        } while ((gpa < 0.0 || gpa > 10) || !isNumeric(number));
        System.out.print("Please enter student's image(link): ");
        image = input.nextLine();
        System.out.print("Please enter student's address: ");
        address = input.nextLine();
        System.out.print("Please enter student's notes(separated by;) : ");
        notes = input.nextLine();

    }

    public void information() {
        System.out.println("ID :" + this.id);
        System.out.println("Fullname :" + this.fullname);
        System.out.println("GPA :" + this.gpa);
        System.out.println("Link image :" + this.image);
        System.out.println("Address :" + this.address);
        System.out.println("Notes :" + this.notes);

    }

    public boolean update(String target, String newInfor) {
        if (target != null && newInfor != null) {
            if (target.compareTo(ID) == 0) {

                setID(newInfor);
                return true;
            } else if (target.compareTo(FULLNAME) == 0) {
                setFullname(newInfor);
                return true;
            } else if (target.compareTo(GPA) == 0) {

                setGPA(Double.parseDouble(newInfor));
                return true;
            } else if (target.compareTo(IMAGE) == 0) {

                setIamge(newInfor);
                return true;
            } else if (target.compareTo(ADDRESS) == 0) {
                setAddress(newInfor);
                return true;
            } else if (target.compareTo(NOTES) == 0) {
                setNotes(newInfor);
                return true;
            }

        }
        return false;
    }

    public ArrayList<String> getItem() {

        ArrayList<String> res = new ArrayList<>();

        res.add(this.id);
        res.add(this.fullname);
        res.add(String.valueOf(gpa));
        res.add(this.image);
        res.add(this.address);
        res.add(this.notes);
        return res;
    }

}
