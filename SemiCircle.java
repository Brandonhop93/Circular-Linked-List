/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

public class SemiCircle extends PlanarShape
{
    private Point baseCenter;
    private Point radiusCenter;

    /** Class constructor. */
    public SemiCircle(Point baseCenter, Point radiusCenter)
    {
        this.baseCenter = baseCenter;
        this.radiusCenter = radiusCenter;
    }

    /** Returns the area of the semi-circle. */
    public double area()
    {
        //Radius of the semi-circle.
        double radius = Math.sqrt(Math.pow(baseCenter.getX() - radiusCenter.getX(), 2) + Math.pow(baseCenter.getY() - radiusCenter.getY(), 2));

        //Area of semi-circle.
        return Math.PI * Math.pow(radius, 2) / 2;
    }

    /** Returns the distance from the closest point of the semi-circle and the origin. */
    public double originDistance()
    {
        //Rotate 90 degree anti-clockwise around baseCenter from radiusCenter.
        double x = -radiusCenter.getY() + baseCenter.getY() + baseCenter.getX();
        double y =  radiusCenter.getX() - baseCenter.getX() + baseCenter.getY();
        Point baseExtremityA = new Point(x, y);

        //Rotate 90 degree clockwise around baseCenter from radiusCenter.
        x =  radiusCenter.getY() - baseCenter.getY() + baseCenter.getX();
        y = -radiusCenter.getX() + baseCenter.getX() + baseCenter.getY();
        Point baseExtremityB = new Point(x, y);

        //Return the minimum origin distance from the semi-circles center of its base, center of radius/perimeter and extremities of its base.
        return Math.min(Math.min(baseExtremityA.originDistance(), baseExtremityB.originDistance()), Math.min(radiusCenter.originDistance(), baseCenter.originDistance()));
    }

    /** Returns the semicircle as a string in the format '[(x, y) (x, y)]: area'. */
    public String toString()
    {
        //Formatting.
        String string = "SEMI=[";

        //Add base center to string.
        string += baseCenter.toString();

        //Formatting.
        string += " ";

        //Add radius center to string.
        string += radiusCenter.toString();

        //Formatting.
        string += "]: ";

        //Add area of semi-circle to string.
        string += String.format("%5.2f", area());

        return string;
    }
}
