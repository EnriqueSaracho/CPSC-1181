
/**
 * GraduateStudent class: extends Student class and represents a graduate student with their personal and academic information:
 * - researchTopic
 * - supervisor
 *
 * Methods:
 * - constructor
 * - toString
 * - equals
 */
public class GraduateStudent extends Student {

    private String researchTopic;
    private String supervisor;

    /**
     * GraduateStudent class constructor
     *
     * @param a - student's address
     * @param n - student's name
     * @param r - student's research topic
     * @param s - student's supervisor name
     */
    public GraduateStudent(String a, String n, String r, String s) {
        super(a, n);
        researchTopic = r;
        supervisor = s;
    }

    /**
     * Displays the student's information in the console
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nResearch Topic: " + researchTopic
                + "\nSupervisor: " + supervisor;
    }

    /**
     * Compares the student object to another student object
     */
    @Override
    public boolean equals(Object obj) {
        GraduateStudent other = (GraduateStudent) obj;
        return super.equals(obj) && this.researchTopic.equals(other.researchTopic) && this.supervisor.equals(other.supervisor);
    }
}
