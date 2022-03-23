import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class comparableDriver {
    public static void main(String[] args) {
        Random rand = new Random(); // generate random number
        Quadratic quad1 = new Quadratic(rand.nextInt(100)-50,rand.nextInt(100)-50,rand.nextInt(100)-50); // create quadratic 1
        Quadratic quad2 = new Quadratic(rand.nextInt(100)-50, rand.nextInt(100)-50, rand.nextInt(100)-50); // create quadratic 2
        Quadratic quad3 = new Quadratic(rand.nextInt(100)-50, rand.nextInt(100)-50, rand.nextInt(100)-50); // create quadratic 3
        quad1.solution(); // get solution of quadratic 1
        quad2.solution(); // get solution of quadratic 2
        quad3.solution(); // get solution of quadratic 3

        System.out.println("quad1 (" + quad1.equation()[1] + ") equals quad2 (" + quad2.equation()[1] + "): " + quad1.compareTo(quad2)); // compare quad1 to quad2
        System.out.println("quad2 (" + quad2.equation()[1] + ") equals quad3 (" + quad3.equation()[1] + "): " + quad2.compareTo(quad3)); // compare quad2 to quad3
        System.out.println("quad3 (" + quad3.equation()[1] + ") equals quad1 (" + quad1.equation()[1] + "): " + quad3.compareTo(quad1) + "\n"); // compare quad3 to quad1

        List<Quadratic> quadList = new ArrayList<>(); // create new quadratic list
        quadList.add(quad1); // add quadratic 1 to quadratic list
        quadList.add(quad2); // add quadratic 2 to quadratic list
        quadList.add(quad3); // add quadratic 3 to quadratic list

        Collections.sort(quadList); // sort list by distance between roots using Collections class and compareTo method
        for (Quadratic quad : quadList) { // for each quadratic in quadratic list
            Complex[] sol = quad.solution(); // get solution in complex format
            NumberFormat nf = NumberFormat.getInstance();  // create new number format
            ComplexFormat cf = new ComplexFormat(nf); // create new complex format from number format
            System.out.println(quad.equation()[1] + "\n" + // print out equation
                    "roots: x₁ = " + cf.format(sol[0]) + ", x₂ = " + cf.format(sol[1]) + "\n" + // print roots
                    "distance between roots: " + cf.format(quad.getDist()) +"\n"); // print distance between roots
        }
    }
}