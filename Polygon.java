/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

public class Polygon extends PlanarShape
{
    private Point[] points;

    /** Class constructor. */
    public Polygon (Point[] points)
    {
        //Set points array size.
        this.points = new Point[points.length + 1];

        //Transfer points to polygon.
        for (int i = 0; i < points.length; i++)
        {
            this.points[i] = points[i];
        }

        //Set last array point to first point.
        this.points[this.points.length - 1] = this.points[0];
    }

    /** Returns the area of the polygon. */
    public double area()
    {
        double sum = 0;

        //Loop through all points.
        for (int i = 0; i <= points.length - 2; i++)
        {
            //Add area to sum.
            sum += (points[i + 1].getX() + points[i].getX()) * (points[i+1].getY() - points[i].getY());
        }

        return Math.abs(sum / 2);
    }

    /** Returns the distance from the closest polygon point and the origin. */
    public double originDistance()
    {
        double min = points[0].originDistance();

        //Loop through all points.
        for (int i = 0; i < points.length - 1; i++)
        {
            //Check if point originDistance is new minimum.
            if (points[i].originDistance() < min)
            {
                min = points[i].originDistance();
            }
        }

        return min;
    }

    /** Returns the polygon as a string in the format '[(x, y) ... (x,y)]: area'. */
    public String toString()
    {
        //Formatting.
        String string = "POLY=[";

        //Loop over all points in polygon.
        for (int i = 0; i < points.length - 1; i++)
        {
            //Add point to string.
            string += points[i].toString();

            //Formatting.
            if (i != (points.length - 2))
            {
                string += " ";
            }
        }

        //Formatting.
        string += "]: ";

        //Add area of polygon to string.
        string += String.format("%5.2f", area());

        return string;
    }
}
