public abstract class PlanarShape implements Comparable<PlanarShape>
{
    /** Returns the area of the planar shape. */
    public abstract double area();

    /** Returns the distance from the planar shape and the origin. */
    public abstract double originDistance();

    /** Returns the planar shape as a string in the format 'SHAPE=[(x, y), ... ]: area'. */
    public abstract String toString();

    /** Compares planar shapes by area. */
    public int compareTo(PlanarShape other)
    {
        //Check if both shapes have an area difference of less than or equal to 0.005 units.
        if (Math.abs(this.area() - other.area()) <= 0.005)
        {
            //Compare shapes by origin distance.
            if (this.originDistance() < other.originDistance())
            {
                //This planer shape has a lower origin distance.
                return -1;
            }

            else if (this.originDistance() > other.originDistance())
            {
                //Other planer shape has a lower origin distance.
                return 1;
            }

            else
            {
                //Both shapes have the same origin distance.
                return 0;
            }
        }

        //Compare shapes by area.
        else
        {
            if (this.area() < other.area())
            {
                //This planer shape has a smaller area.
                return -1;
            }

            else
            {
                //Other planer shape has a smaller area.
                return 1;
            }
        }
    }
}
