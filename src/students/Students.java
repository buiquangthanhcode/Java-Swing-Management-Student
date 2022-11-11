package students;
import java.util.*;

import java.util.regex.Pattern;
import java.io.*;

public class Students {
    private ArrayList<Student> students;
    private final String[] targetUpDate = { "id", "gpa", "address", "notes", "iamge", "fullname" };

    public Students() {
        students = new ArrayList<>();
    }

    public void add(Student student) {
        students.add(student);
    }

    public static boolean isNumeric(String string) {
        // Checks if the provided string
        // is a numeric by applying a regular
        // expression on it.
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

    public int getSize() {
        return this.students.size();
    }

    public void output() {
        if (students.size() != 0) {
            System.out.println("\n\n--------------------------------------------------");
            for (Student student : students) {

                student.information();
                System.out.println("--------------------------------------------------");
            }
            System.out.println("\n");
        } else {
            System.out.println("Empty list of Student");
        }

    }

    public int findID(String ID) {
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(ID, students.get(i).getID())) {
                return i;
            }
        }
        return -1;
    }

    public boolean update(String id, String target, String newInfor) {
        int index = findID(id);
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(targetUpDate));
        boolean check = nameList.contains(target);
        if (index == -1 || !check) {
            return false;
        } else {
            students.get(index).update(target, newInfor);
            return true;
        }
    }

    public boolean delete(String ID) {
        int index = findID(ID);
        if (index != -1) {
            students.remove(index);
            return true;
        }
        return false;
    }

    public boolean sortIDAscending(ArrayList<Student> listTemp) {
        int size = listTemp.size();
        if (size != 0) {
            Student temp = listTemp.get(0);
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (listTemp.get(i).getID().compareTo(listTemp.get(j).getID()) > 0) {
                        temp = listTemp.get(j);
                        listTemp.set(j, listTemp.get(i));
                        listTemp.set(i, temp);
                    }
                }
            }

        } else {
            return false;
        }
        return true;
    }

    public void viewOrderID() {
        ArrayList<Student> listTemp = (ArrayList<Student>) students.clone();
        boolean state = sortIDAscending(listTemp);
        if (state) {
            for (Student s : listTemp) {
                System.out.println("\n\n--------------------------------------------------");
                s.information();
            }
        } else {
            System.out.println("Empty List. Please add student to view this function");
        }

    }

    public boolean sortGPAAscending(ArrayList<Student> listTemp) {
        int size = listTemp.size();
        if (size != 0) {
            Student temp = listTemp.get(0);
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (listTemp.get(i).getGPA() > listTemp.get(j).getGPA()) {
                        temp = listTemp.get(j);
                        listTemp.set(j, listTemp.get(i));
                        listTemp.set(i, temp);
                    }
                }
            }

        } else {
            return false;
        }
        return true;
    }

    public void viewOrderGPA() {
        ArrayList<Student> listTemp = (ArrayList<Student>) students.clone();
        boolean state = sortGPAAscending(listTemp);
        if (state) {
            for (Student s : listTemp) {
                System.out.println("\n\n--------------------------------------------------");
                s.information();
            }
        } else {
            System.out.println("Empty List . Please add student to view this function");
        }

    }

    public boolean saveFile(String namfile) throws IOException {
        FileWriter fw;

        try {
            fw = new FileWriter(namfile);
        } catch (IOException exc) {
            System.out.println("Error opening file");
            return false;
        }

        fw.write("ID, Fullname, GPA, Image, Address, Notes\n");
        for (Student student : students) {
            fw.write(student.getID() + ",");
            fw.write(student.getFullname() + ",");
            fw.write(student.getGPA() + ",");
            fw.write(student.getImage() + ",");
            fw.write(student.getAddress() + ",");
            fw.write(student.getNotes() + "\n");
        }
        fw.close();
        return true;
    }

    public boolean exportFile(String namefile) throws IOException {
        FileWriter fw;
        readFile(namefile);
        try {
            fw = new FileWriter(namefile.replace("txt", "csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fw.write("ID,Fullname,GPA,Image,Address,Notes\n");
        for (Student student : students) {
            fw.write(student.getID() + ",");
            fw.write(student.getFullname() + ",");
            fw.write(student.getGPA() + ",");
            fw.write(student.getImage() + ",");
            fw.write(student.getAddress() + ",");
            fw.write(student.getNotes() + "\n");
        }
        fw.close();
        return true;
    }

    public boolean checkExistFile(String nameFile) {
        File f = new File(nameFile);
        if (f.isFile()) {
            return true;
        }
        return false;
    }

    public ArrayList<Student> readFile(String namefile) throws IOException {
        BufferedReader fr;
        ArrayList<Student> newList = new ArrayList<>();
        try {
            fr = new BufferedReader(new FileReader(namefile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String _id = "";
        String _name = "";
        double score = 0;
        String _image = "";
        String _address = "";
        String _notes = "";

        String line = fr.readLine();
        while (line != null) {
            line = fr.readLine();
            if (line != null) {
                String[] arrayValue = line.split(",");
                if (arrayValue.length == 6 && isNumeric(arrayValue[2])) {
                    _id = arrayValue[0];
                    _name = arrayValue[1];
                    score = Double.parseDouble(arrayValue[2]);
                    _image = arrayValue[3];
                    _address = arrayValue[4];
                    _notes = arrayValue[5];
                    newList.add(new Student(_id, _name, score, _image, _address, _notes));
                }
            }

        }
        fr.close();
        return newList;
    }

    public boolean importFile(String namefile) throws IOException {
        students = readFile(namefile);
        if (readFile(namefile).size() == 0)
            return false;
        return true;
    }


    public ArrayList<ArrayList<String>> convertToStringDimesion() {


        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (Student e : this.students)
        {
            ArrayList<String> data = new ArrayList<>();
            data.add(e.getID());
            data.add(e.getFullname());
            data.add(Double.toString((e.getGPA())));
            data.add(e.getAddress());
            data.add(e.getImage());
            data.add(e.getNotes());
            res.add(data);

        }
        return res;
    }

    public ArrayList<String> getListID() {
        ArrayList<String> res = new ArrayList<>();
        for (Student e : students) {
            if (!res.contains(e.getID()))
                res.add(e.getID());
        }
        return res;

    }
}