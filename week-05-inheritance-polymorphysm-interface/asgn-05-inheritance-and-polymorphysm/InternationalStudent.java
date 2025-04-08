
/**
 * InternationalStudent class: extends Student class and represents an international student with their personal and academic
 * information:
 * - country
 * - CREDIT_FEE
 *
 * Methods:
 * - constructor
 * - getTuitionFees
 * - toString
 * - equals
 */
public class InternationalStudent extends Student {

    private String country;
    private static final double CREDIT_FEE = 637.91;

    public InternationalStudent(String a, String n, String c) {
        super(a, n);
        country = c;
    }

    @Override
    public double getTuitionFees() {
        return getCredits() * CREDIT_FEE;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCountry: " + country;
    }

    @Override
    public boolean equals(Object obj) {
        InternationalStudent other = (InternationalStudent) obj;
        return super.equals(obj) && this.country.equals(other.country);
    }
}
