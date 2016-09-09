package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("","","",30);
    }

    public Course(String n, String cid) {
        course_id="000000";
        course_name="TBA";
        lecturer="TBA";
        no_students=0;
        max_students=30;
    }

    public Course(String n, String cid, String l) {
        course_id=n;
        course_name=n;
        lecturer=l;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = isValidCourse_id(cid)?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase(" ")?l:"TBA";
        this.max_students=(max >= 10)?max:30;
        this.no_students = 0;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        return "lecturer";
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase(" ")?lecturer:this.lecturer;
    }

    public int getMax_students(){
        return this.max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = (max_students >= 10)?max_students:60;
    }

    public int getNo_students() {
        return 0;
    }

    public void setNo_students(int no_students) {
        this.no_students = no_students;
    }

    @Override
    public String toString() {
        if (no_students == 0) {
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has "
                    + "NO student, "
                    + "[maximum: 60]";
            return o;
        } else if (no_students == 1) {
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has "
                    + "ONE student, "
                    + "[maximum: 60]";
            return o;
        } else {
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has "
                    + this.no_students + " students, "
                    + "[maximum: 60]";
            return o;
        }

    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        return m.matches();
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
