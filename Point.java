/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

public class Point
{
    private double x;
    private double y;

    /** Class constructor. */
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /** Returns the distance between this point and the origin. */
    public double originDistance()
    {
        //Distance formula.
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /** Returns the point as a string in the format '(x, y)'. */
    public String toString()
    {
        return ("(" + String.format("%4.2f", x) + ", " + String.format("%4.2f", y) + ")");
    }

    /** Sets x coordinate. */
    public void setX(double x)
    {
        this.x = x;
    }

    /** Returns x coordinate. */
    public double getX()
    {
        return x;
    }

    /** Sets y coordinate. */
    public void setY(double y)
    {
        this.y = y;
    }

    /** Returns y coordinate. */
    public double getY()
    {
        return y;
    }
}
