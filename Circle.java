/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

public class Circle extends PlanarShape
{
    private Point center;
    private double radius;

    /** Class constructor. */
    public Circle(Point center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }

    /** Returns the area of the circle. */
    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    /** Returns the distance from the closest point of the circle and the origin. (Result can be negative) */
    public double originDistance()
    {
        return center.originDistance() - radius;
    }

    /** Returns the circle as a string in the format '[(x, y) radius]: area'. */
    public String toString()
    {
        //Formatting.
        String string = "CIRC=[";

        //Add center to string.
        string += center.toString();

        //Formatting.
        string += " ";

        //Add radius to string.
        string += radius;

        //Formatting.
        string += "]: ";

        //Add area of circle to string.
        string += String.format("%5.2f", area());

        return string;
    }
}
