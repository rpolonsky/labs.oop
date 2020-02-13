import java.lang.Math;

/**
 * A three-dimensional point class.
 **/
public class Point3d extends Point2d {
    /** Z coordinate of the point **/
    private double zCoord;

    /** Constructor to initialize point to (x, y, z) value. **/
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    /** No-argument constructor: defaults to a point at the origin. **/
    public Point3d() {
        // Call three-argument constructor and specify the origin.
        this(0, 0, 0);
    }

    /** Return the Z coordinate of the point. **/
    public double getZ() {
        return zCoord;
    }

    /** Set the Z coordinate of the point. **/
    public void setZ(double val) {
        zCoord = val;
    }

    /** Compare values of two 3d points */
    public boolean equals(Point3d point) {
        return point.getX() == xCoord && point.getY() == yCoord && point.getZ() == zCoord;
    }

    /** Measure distance between two 3d points */
    public double distanceTo(Point3d point) {
        double xArg = Math.pow(point.getX() - this.getX(), 2);
        double yArg = Math.pow(point.getY() - this.getY(), 2);
        double zArg = Math.pow(point.getZ() - this.getZ(), 2);

        return Math.sqrt(xArg + yArg + zArg);
    }
}
