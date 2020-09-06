/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

import java.io.*;

public class PA2b extends PA2a
{
    public static void main(String[] args)
    {
        //File to read.
        File file;

        if (args.length != 0)
        {
            //Read file from argument.
            file = new File(args[0]);
        }

        else
        {
            //No file argument provided.
            System.out.println("Please specify a file to read with commands: java className filename.txt");

            return;
        }

        //Run program.
        PA2b program = new PA2b();
        program.run(file);
    }

    protected PlanarShape shapeFactory(String[] symbols)
    {
        switch (symbols[0])
        {
            case "P":
                //Point array.
                Point[] points = new Point[Integer.valueOf(symbols[1])];

                //Loop over all symbols in text line.
                for (int i = 2; i < symbols.length; i++)
                {
                    //Assign point from file to array.
                    points[i / 2 - 1] = new Point(Double.valueOf(symbols[i]), Double.valueOf(symbols[i + 1]));
                    i++;
                }

                //Return new polygon shape.
                return new Polygon(points);

            case "C":

                //Return new circle shape.
                return new Circle(new Point(Double.valueOf(symbols[1]), Double.valueOf(symbols[2])), Double.valueOf(symbols[3]));

            case "S":

                //Return new semi-circle shape.
                return new SemiCircle(new Point(Double.valueOf(symbols[1]), Double.valueOf(symbols[2])), new Point(Double.valueOf(symbols[3]), Double.valueOf(symbols[4])));

            default:

                //Generate exception.
                String exception = "Shape format not implemented: ";

                for (int i = 0; i < symbols.length; i++)
                {
                    exception += symbols[i] + " ";
                }

                //Throw runtime exception.
                throw new RuntimeException(exception);
        }
    }
}