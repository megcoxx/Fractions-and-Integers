// class Fraction
// Author:  Bob Myers
//
// For COP3252, Java Programming

public class Fraction {
    private int numerator = 0; // numerator (and keeps sign)
    private int denominator = 1; // always stores positive value

    public Fraction() {
    }

    public Fraction(int n, int d) {
        if (set(n, d) == false)
            set(0, 1);
    }

    public boolean set(int n, int d) {
        if (d > 0) {
            numerator = n;
            denominator = d;
            return true;
        } else
            return false;
    }

    public String toString() {
        return (numerator + "/" + denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public Fraction simplify() {
        Fraction simplifiedFraction = new Fraction(this.numerator, this.denominator);
        for (int i = 2; i <= this.denominator; i++) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                simplifiedFraction = new Fraction(numerator / i, denominator / i);
            }
        }

        return simplifiedFraction;
    }

    public Fraction add(Fraction f) {
        Fraction firstOper = new Fraction(this.numerator * f.denominator, this.denominator * f.denominator);
        Fraction secondOper = new Fraction(f.numerator * this.denominator, this.denominator * f.denominator);
        int newNum = firstOper.numerator + secondOper.numerator;
        Fraction addedFraction = new Fraction(newNum, firstOper.denominator);
        return addedFraction.simplify();
    }

    public Fraction subtract(Fraction f) {
        Fraction firstOper = new Fraction(this.numerator * f.denominator, this.denominator * f.denominator);
        Fraction secondOper = new Fraction(f.numerator * this.denominator, this.denominator * f.denominator);
        int newNum = firstOper.numerator - secondOper.numerator;
        Fraction subbedFraction = new Fraction(newNum, firstOper.denominator);
        return subbedFraction.simplify();
    }

    public Fraction multiply(Fraction f) {
        Fraction sumFrac = new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
        return sumFrac.simplify();
    }

    public Fraction divide(Fraction f) {
        Fraction secondFrac;
        if (f.numerator < 0) {
            secondFrac = new Fraction((f.denominator * -1), (f.numerator * -1));
        } else {
            secondFrac = new Fraction(f.denominator, f.numerator);
        }
        return this.multiply(secondFrac);
    }

}