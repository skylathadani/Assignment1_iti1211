/**
* Test cases for the class <code>A1Q1</code>.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

public class A1Q1Test {

    /**
    * In Java, an application must have a <code>main</code> method. Its signature must
    * exactly as below. Otherwise, the virtual machinine will fail to find
    * the entry point to your program. On the command line, you can run
    * this program as follows:
    * <pre>
    * $ java A1Q1Test
    * </pre>
    * See <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">https://docs.oracle.com/javase/tutorial/getStarted/application/index.html</a>.
    *
    * @param args the parameters passed on the command line when executing the program
    */

    public static void main(String[] args) {

        double[] a;

        StudentInfo.display();

        System.out.println("Testing A1Q1.countPositive:");
        System.out.println();

        a = new double[] {2.0, 3.5, -1.0, -100.0};

        System.out.print("Test case: ");
        Utils.displayArray(a);

        Utils.assertEquals(A1Q1.countPositive(a), 2);

        System.out.println();

        a = new double[] {1.0, 0.0, 22.0, 0.0, 1.0};

        System.out.print("Test case: ");
        Utils.displayArray(a);

        Utils.assertEquals(A1Q1.countPositive(a), 3);

        System.out.println();

        a = new double[] {};

        System.out.print("Test case: ");
        Utils.displayArray(a);

        Utils.assertEquals(A1Q1.countPositive(a), 0);

        System.out.println();

        a = new double[] {1.0, 0.0, 22.2, 0.0, 1.0, -10.5};

        System.out.print("Test case: ");
        Utils.displayArray(a);

        Utils.assertEquals(A1Q1.countPositive(a), 3);

    }

}