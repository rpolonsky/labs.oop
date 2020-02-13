import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point3d myPoint = new Point3d();
        Point3d myOtherPoint = new Point3d(5, 3, 1);
        Point3d aThirdPoint = new Point3d();

        /* test equality */
        System.out.println(aThirdPoint.equals(myPoint) ? "Points are equal" : "Points are not equal");

        /* measure distance to another 3d-point */
        System.out.println("Distance between two points: " + myPoint.distanceTo(myOtherPoint));

        /* input three ordered triples from the user */
        Scanner input = new Scanner(System.in);
        String[] coordNames = new String[] { "x", "y", "z" };
        Point3d[] points = new Point3d[3];

        for (int i = 0; i < 3; i++) {
            double[] coords = new double[coordNames.length];

            for (int j = 0; j < coordNames.length; j++) {
                String msg = String.format("Input value for %1$s coordinate of point #%2$s: ", coordNames[j], i + 1);
                System.out.print(msg);
                coords[j] = input.nextDouble();
            }
            points[i] = new Point3d(coords[0], coords[1], coords[2]);
        }
        input.close();

        /* check equal points */
        if (points[0].equals(points[1]) || points[1].equals(points[2]) || points[2].equals(points[0])) {
            System.out.println("Impossible to calculate an area: There are some points equal to each other");
            return;
        }

        /* compute area of triangle between three points */
        computeArea(points);
    }

    public static void computeArea(Point3d[] points) {
        double distAB = points[0].distanceTo(points[1]);
        double distBC = points[1].distanceTo(points[2]);
        double distCA = points[2].distanceTo(points[0]);

        /* perimeter */
        double p = (distAB + distBC + distCA) / 2;
        double area = Math.sqrt((p * (p - distAB) * (p - distBC) * (p - distCA)));

        System.out.println("Area of triangle: " + area);
    }
}
