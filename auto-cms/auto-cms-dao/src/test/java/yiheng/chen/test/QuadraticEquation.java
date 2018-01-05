package yiheng.chen.test;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 23:45 2018/1/2
 * @Modified by:
 */
public class QuadraticEquation {
    private static double result1;
    private static double result2;

    public static Roots findRoots(double a, double b, double c) {
        result1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);

        result2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);

        Roots roots = new Roots(result1, result2);

        return roots;
        //throw new UnsupportedOperationException("Waiting to be implemented.");



    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }

}
class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
