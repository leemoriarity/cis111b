//    ██████╗ ██╗   ██╗ █████╗ ██████╗ ██████╗  █████╗ ████████╗██╗ ██████╗
//   ██╔═══██╗██║   ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝
//   ██║   ██║██║   ██║███████║██║  ██║██████╔╝███████║   ██║   ██║██║
//   ██║▄▄ ██║██║   ██║██╔══██║██║  ██║██╔══██╗██╔══██║   ██║   ██║██║
//   ╚██████╔╝╚██████╔╝██║  ██║██████╔╝██║  ██║██║  ██║   ██║   ██║╚██████╗
//    ╚══▀▀═╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝
//         Author: Lee Moriarity // Course: CIS111-B //  Date: 2/22/22
import org.apache.commons.math3.complex.Complex;
import java.lang.Math;
import java.text.DecimalFormat;


public class Quadratic implements Comparable<Quadratic> { // implement Comparable interface
    private double a, b, c, d, x1, x2; // declare global variables
    public DecimalFormat df = new DecimalFormat("#.######"); // format to 6 decimal places

    /**
     * Default constructor
     */
    public Quadratic() {
        setA(2); //set value of global variable a to 2
        setB(3); //set value of global variable b to 3
        setC(-2); //set value of global variable c to -2
    }

    /**
     * @param a value of quadratic coefficient
     * @param b value of linear coefficient
     * @param c value of constant coefficient
     */
    public Quadratic(double a, double b, double c) {
       setA(a); // set value of global variable a
       setB(b); // set value of global variable b
       setC(c); // set value of global variable c
    }

    /**
     * @return quadratic or linear equation
     */
    public String[] equation() {
        df.setDecimalSeparatorAlwaysShown(false); // if not decimal display as int
        String eq = "";
        if (a != 0 && a != 1 && a != -1) // if a is not 0, 1, or -1
            eq += df.format(a) + "x²"; // (a)x²
        if (a == 1) // if a is 1
            eq += "x²"; // remove the 1 from 1x²
        if (a == -1) // if a is -1
            eq += "-x²"; // remove the 1 from -1x²
        if (b > 0) { // if b is greater than 0
            if (a == 0 && b != 1) //if a is 0 and b is 1
                eq += df.format(b) + "x"; // start equation with (b)x
            if (a == 0 && b == 1) // if a is 0 and b is 1
                eq += "x"; // remove the 1 from 1x
            if (a != 0 && b == 1) // if a is not 0 and b is 1
                eq += " + x"; // remove 1 from 1x
            if (a != 0 && b != 1) // if a is not 0 and b does not equal 1
                eq += " + " + df.format(b) + "x"; // plus (b)x
        }
        if (b < 0) { // if b is less than 0
            if (a == 0 && b != -1) // if a is 0 and b is not -1
                eq += df.format(b) + "x"; // (-b)x
            if (a == 0 && b == -1) // if a is 0 and b is -1
                eq += "-x"; // remove the 1 from -1x
            if (a != 0 && b != -1) // if a is not 0 and b is not -1
                eq += " - " + df.format(b * -1) + "x"; // minus positive value of (b)x
            if (a != 0 && b == -1) // if a is not 0 and b is -1
                eq += " - x"; // remove 1 from - 1x
        }
        if (c > 0) { // if c is greater than 0
            if (a == 0 && b == 0) // if a is 0 and b is 0
                eq = df.format(c); // start equation with c
            else
                eq += " + " + df.format(c); // add c
        }
        if (c < 0) { // if c is less than 0
            if (a == 0 && b == 0) // if a is 0 and b is 0
                eq = df.format(c); // start equation with -c
            else
                eq += " - " + df.format(c * -1); // minus positive value of c
        }
        eq+= " = 0"; // add equals 0 to equation
        if (a == 0 && b != 0 && c != 0 || a == 0 && b != 0 && c == 0 ) //if a is 0
            return new String[]{"Linear equation:", eq}; // equation is linear not quadratic
        if (a == 0 && b == 0 && c == 0)
            return new String[]{"Quadratic equation:", "0x² + 0x + 0"}; // equation is linear not quadratic
        else
            return new String[]{"Quadratic equation:",eq}; // equation is quadratic equation
    }

    /**
     * @return quadratic formula
     */
    public String formula() {
        String frm = "";
        double discriminant = b * b - 4 * a * c; // find discriminant
        if (a != 0 && c != 0) {
            // output steps to solving quadratic formula
            frm += "<html><head><style type=\"text/css\">body { font-family:consolas; font-size:10px; }</style></head><body>";
            frm += "<span align=\"left\">Step 1:</span><br><div align =\"center\"><u>-(" + df.format(b) + ") ± √(" + df.format(b) + ")² - 4(" + df.format(a) + ")"
                    + "(" + df.format(c) + ")</u><br>2(" + df.format(a) + ")</div>";
            if ((4 * a * c) > 0)
                frm += "<span align=\"left\">Step 2:</span><br><div align =\"center\"><u>" + df.format(-1 * b) + " ± √" + df.format(b * b) +
                        "-" + df.format(4 * a * c) + "</u><br>" + 2 + "(" + df.format(a) + ")</div>";
            else
                frm += "<span align=\"left\">Step 2:</span><br><div align =\"center\"><u>" + df.format(-1 * b) + " ± √" + df.format(b * b) + "+" +
                        df.format((4 * a * c) * -1) + "</u><br>" + 2 + "(" + df.format(a) + ")</div>";
            frm += "<span align=\"left\">Step 3:</span><br><div align =\"center\"><u>" + df.format(-1 * b) + " ± √" + df.format(discriminant) +
                    "</u><br>" + df.format(2 * a) + "</div>";
            frm += "<span align=\"left\">Step 4:</span><br><div align =\"center\">" + df.format((-1 * b) / (2 * a)) + " ± √" + df.format(discriminant) +
                    " / " + df.format(2 * a) + "</div>";
            return frm + "</body></html>";
        } else {
            return "";
        }
    }

    /**
     * @return solution
     */
    public Complex[] solution() {
        double discriminant = b * b - 4 * a * c; // find discriminant
        x1 = (-b - Math.sqrt(discriminant)) / (2 * a); // value of root 1
        x2 = (-b + Math.sqrt(discriminant)) / (2 * a); // value of root 2
        d = x2 - x1;
        if (a == 0 & b != 0 && c != 0) { // if a is 0 and b and c are not 0
            return new Complex[] {new Complex(-c/b)}; // find value of x
        }
        if (discriminant > 0 && a != 0) { // 2 real solutions (real roots)
            return new Complex[] {new Complex(x1),new Complex(x2)};
        } else if (discriminant == 0) { // 1 real solution
            x1 = x2 = -b / (2 * a);
            d = 0;
            return new Complex[] {new Complex(x1),new Complex(x2)};
        } else { // 2 imaginary solutions (complex roots)
            if (a != 0 && b != 0) {
                double real = -b / (2 * a);
                double imaginary = Math.sqrt(-discriminant) / (2 * a);
                d = Math.sqrt(Math.pow(real - imaginary,2) + Math.pow(real + imaginary,2));
                return new Complex[] {new Complex(real,-imaginary), new Complex(real,imaginary)};
            }
            if (a != 0 && b == 0) {
                double imaginary = Math.sqrt(-discriminant) / (2 * a);
                d = Math.sqrt(Math.pow(0 - imaginary,2) + Math.pow( 0 + imaginary, 2));
                return new Complex[] {new Complex(0, -imaginary), new Complex(0, imaginary)};
            }
        }
        return new Complex[] {new Complex(0)};
    }
    public double sumOfRoots() {
        return -b/a;
    }
    public double prodOfRoots() {
        return c/a;
    }
    //Setters
    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setC(double c) {
        this.c = c;
    }
    //Getters
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getDist() {
        return d;
    }

    /**
     * @param q
     * @return compare result
     */
    @Override
    public int compareTo(Quadratic q) {
        if (this.d > q.getDist()) // If note is greater than compared note
            return 1; // return 1
        else if (this.d < q.getDist()) // if note is less than compared note
            return -1; // return -1
        else return 0; // if note is equal return 0
    }
}