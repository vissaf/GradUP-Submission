import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student s) {
        if (this.cgpa < s.cgpa) {
            return -1;
        } else if (this.cgpa > s.cgpa) {
            return 1;
        }
        if (this.fname.compareTo(s.fname) > 0) {
            return -1;
        } else if (this.fname.compareTo(s.fname) < 0) {
            return 1;
        } else {
            if (this.token < s.token) {
                return -1;
            }
        }
        return 1;
    }

    public String toString() {
        return "" + this.token + " " + this.fname + " " + this.cgpa;
    }
}

public class VishnuSubmission {

    public static ArrayList<Student> studentQueue = new ArrayList<>();

    public static void insertStudent(Student s) {
        int insertPos = 0;
        for (int i = 0; i < studentQueue.size(); i++) {
            if (studentQueue.get(insertPos).compareTo(s) > 0) {
                insertPos = i + 1;
            } else {
                break;
            }
        }
        studentQueue.add(insertPos, s);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        while (totalEvents > 0) {
            String[] eventArr = in.nextLine().split(" ");
            if (eventArr.length == 1) {
                if (!studentQueue.isEmpty()) {
                    studentQueue.remove(0);
                }
            } else {
                Student s = new Student(Integer.parseInt(eventArr[3]), eventArr[1], Double.parseDouble(eventArr[2]));
                insertStudent(s);
            }
            totalEvents--;
        }
        if (studentQueue.size() > 0) {
            for (int i = 0; i < studentQueue.size(); i++) {
                System.out.println(studentQueue.get(i).getFname());
            }
        } else {
            System.out.println("EMPTY");
        }

    }
}
