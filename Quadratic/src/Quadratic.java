//    ██████╗ ██╗   ██╗ █████╗ ██████╗ ██████╗  █████╗ ████████╗██╗ ██████╗
//   ██╔═══██╗██║   ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝
//   ██║   ██║██║   ██║███████║██║  ██║██████╔╝███████║   ██║   ██║██║
//   ██║▄▄ ██║██║   ██║██╔══██║██║  ██║██╔══██╗██╔══██║   ██║   ██║██║
//   ╚██████╔╝╚██████╔╝██║  ██║██████╔╝██║  ██║██║  ██║   ██║   ██║╚██████╗
//    ╚══▀▀═╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝
//         Author: Lee Moriarity // Course: CIS111-B //  Date: 2/22/22

import java.lang.Math;
import java.text.DecimalFormat;

public class Quadratic {
    double a, b, c, x1, x2, discriminant; // declare global variables
    DecimalFormat df = new DecimalFormat("#.######"); // format to 6 decimal places

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
        if (a == 0 && b != 0 && c != 0) //if a is 0
            return new String[]{"Linear equation:", eq}; // equation is linear not quadratic
        if (a == 0 && b == 0 && c == 0)
            return new String[]{"Quadratic equation:", "0x² + 0x + 0"}; // equation is linear not quadratic
        else
            return new String[]{"Quadratic equation:",eq}; // equation is quadratic equation
    }

    /**
     * @return qquadratic formula
     */
    public String formula() {
        String frm = "";
        discriminant = b * b - 4 * a * c; // find discriminant
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
    public String solution() {
        df.setDecimalSeparatorAlwaysShown(false); // if not decimal display as int
        discriminant = b * b - 4 * a * c; // find discriminant
        x1 = (-b - Math.sqrt(discriminant)) / (2 * a); // value of root 1
        x2 = (-b + Math.sqrt(discriminant)) / (2 * a); // value of root 2
        if (a == 0 & b != 0 && c != 0) { // if a is 0 and b and c are not 0
            return "x = " + df.format(-c/b); // find value of x
        }
        if (a == 0 & b != 0 && c == 0) { // if a and c are 0
            return "x = 0"; // x equals 0
        }
        if (a==0 && b == 0 && c == 0) // if a, b, and c are all 0
            return "All numbers are roots"; // all values of x are solutions
        if (a == 0 && b == 0 && c != 0) // if a and b are 0
            return "Unsolvable equation"; // c cannot equal 0
        if (discriminant > 0 && a != 0) { // 2 real solutions (real roots)
            return "Real roots\nx₁ = " + df.format(x1) + "\nx₂ = " + df.format(x2) +
                    "\n\nSum of roots: " + df.format(x1 + x2) +
                    "\nProduct of roots: " + df.format(x1 * x2);
        } else if (discriminant == 0) { // 1 real solution
            x1 = x2 = -b / (2 * a);
            return "Real Solution\nx₁,x₂ = " + df.format(x1) +
                    "\n\nSum of roots: " + df.format(x1 + x2) +
                    "\nProduct of roots: " + df.format(x1 * x2);
        } else { // 2 imaginary solutions (complex roots)
            if (a != 0 && b != 0) {
                double real = -b / (2 * a);
                double imaginary = Math.sqrt(-discriminant) / (2 * a);
                if (imaginary > 0) {
                    return "Complex roots\nx₁ = " + df.format(real) + " + " + df.format(imaginary) + "i" +
                            "\nx₂ = " + df.format(real) + " - " + df.format(imaginary) + "i" +
                            "\n\nSum of roots: " + df.format(-b/a) +
                            "\nProduct of roots: " + df.format(c/a);
                }
                if (imaginary < 0) {
                    return "Complex roots\nx₁ = " + df.format(real) + " - " + df.format(imaginary * -1) + "i" +
                            "\nx₂ = " + df.format(real) + " + " + df.format(imaginary * -1) + "i" +
                            "\n\nSum of roots: " + df.format(-b/a) +
                            "\nProduct of roots: " + df.format(c/a);
                }
            }
            if (a != 0 && b == 0) {
                double imaginary = Math.sqrt(-discriminant) / (2 * a);
                return  "Complex roots\nx₁ = "+ df.format(imaginary) + "i" +
                        "\nx₂ = -" + df.format(imaginary) + "i" +
                        "\n\nSum of roots: " + df.format(-b/a) +
                        "\nProduct of roots: " + df.format(c/a);
            }
        }
        return "no solution";
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
    //toString
    @Override
    public String toString() {
        return "Quadratic{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}