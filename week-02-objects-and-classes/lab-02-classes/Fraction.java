public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
    }

    public Fraction add(Fraction fraction) {
        int numerator2 = fraction.numerator,
                denominator2 = fraction.denominator;

        int den = denominator * denominator2;
        int num = numerator * denominator2 + denominator * numerator2;

        return new Fraction(num, den);
    }

    public Fraction mulitply(Fraction fraction) {
        int numerator2 = fraction.numerator,
                denominator2 = fraction.denominator;

        int num = numerator * numerator2;
        int den = denominator * denominator2;

        return new Fraction(num, den);
    }

    public Fraction subraction(Fraction fraction) {
        int numerator1 = numerator,
                denominator1 = denominator;
        int numerator2 = fraction.numerator,
                denominator2 = fraction.denominator;

        if (denominator != denominator2) {
            numerator1 *= denominator2;
            denominator1 *= denominator2;

            numerator2 *= denominator1;
            denominator2 *= denominator1;
        }

        int num = numerator1 - numerator2;
        int den = denominator1;

        return new Fraction(num, den);
    }

    public String toString() {
        String result = "";
        result += numerator;
        result += "/";
        result += denominator;
        return result;
    }
}