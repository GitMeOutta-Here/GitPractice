public class Student {

    private String major;
    private String first;
    private String last;
    private double GPA;

    public Student(String f, String l, String m, double grade) { //student constructor
        major = m;
        first = f;
        last = l;
        GPA = grade;
    }

    public double getGpa(Student s) { //GPA Getter
        return s.GPA;
    }
    
    public String getFirstAndLast(Student s) { //First and Last Name Getter
        String fullName = s.first + " " + s.last;
        return fullName;
    }

    public String getMajor(Student s) { //Major Getter
        return s.major;
    }

    public void setMajor(Student s, String m) { //Major Setter
        s.major = m;
    }
    public void setFirstandLast(Student s, String f, String l) { //First and Last Name Setter
        s.first = f;
        s.last = l;
    }

    public void setFirst(Student s, String f) { //First Name Setter
        s.first = f;
    }

    public void setLast(Student s, String l) { //Last Name Setter
        s.last = l;
    }

    public void setGpa(Student s, double grade) { //GPA Setter
        s.GPA = grade;
    }   
}
