
/**
 * Student class: represents a student with their personal and academic
 * information:
 * - name
 * - address
 * - Grade Point Average (GPA)
 * - Student Number
 * - Login ID
 *
 * Methods:
 * - constructor
 * - generateLoginId
 * - getName
 * - getAddress
 * - addCourse
 * - calculateGPA
 * - getStudentNum
 * - getLoginId
 */
public class Student {

    private String name;
    private String address;
    private double gradePts;
    private int credits;
    private int studentNum;
    private String loginId;
    private static int nextStudentNumber = 10000001;

    /**
     * Student class constructor
     *
     * @param a - student's address
     * @param n - student's name
     */
    public Student(String a, String n) {
        address = a;
        name = n.trim();
        studentNum = nextStudentNumber++;
        loginId = generateLoginId();
    }

    /**
     * Generates student's login ID based on their name and student number
     *
     * @return
     */
    private String generateLoginId() {
        String result = "";

        String[] names = name.split(" ");
        result += names[0].charAt(0);
        result += names[1].substring(0, Math.min(3, names[1].length()));

        String num = String.valueOf(studentNum);
        result += num.substring(num.length() - 2);

        return result;
    }

    /**
     * Returns the student's name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the student's address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Adds a course to the student
     *
     * @param gradePt - the course's grade points
     * @param cred    - the course's credits
     */
    public void addCourse(double gradePt, int cred) {
        gradePts += gradePt;
        credits += cred;
    }

    /**
     * Calculates the average GPA based on the total grade points and credits
     *
     * @return
     */
    public double calculateGPA() {
        return (gradePts / credits);
    }

    /**
     * Returns the student number
     *
     * @return
     */
    public int getStudentNum() {
        return studentNum;
    }

    /**
     * Returns the student's login ID
     *
     * @return
     */
    public String getLoginId() {
        return loginId;
    }
}
