import java.io.*;
import java.util.*;

public class PA2a
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
        PA2a program = new PA2a();
        program.run(file);
    }

    protected void run(File file)
    {
        //Create a planar shape list from file.
        LinkedList<PlanarShape> unsortedList = readShapesFromFile(file);

        //Create an empty sorted list.
        SortedList<PlanarShape> sortedList = new SortedList<>();

        //List iterator
        Iterator<PlanarShape> itUnsorted = unsortedList.iterator();

        System.out.println("Unsorted Planar Shape List:");

        //Iterate over unsorted list.
        while (itUnsorted.hasNext())
        {
            PlanarShape shape = itUnsorted.next();

            //Print out unsorted list.
            System.out.println(shape.toString());

            //Copy unsorted list to sorted list.
            sortedList.insertInOrder(shape);
        }

        System.out.println("\nSorted Planar Shape List:");

        //List iterator
        Iterator<PlanarShape> itSorted = sortedList.iterator();

        //Iterate over sorted list.
        while (itSorted.hasNext())
        {
            //Print out sorted list.
            System.out.println(itSorted.next().toString());
        }
    }

    /** Reads shapes from file and returns them as a new planar shape list. */
    protected LinkedList<PlanarShape> readShapesFromFile(File file)
    {
        //New Planar Shape list.
        LinkedList<PlanarShape> planarShapes = new LinkedList<>();

        try
        {
            //Create a file scanner and pass file.
            Scanner scanner = new Scanner(file);

            //Temp text line.
            String textLine = "";

            //Read file value by value.
            while (scanner.hasNext())
            {
                //Read value from file.
                String value = scanner.next();

                //Add value if not a letter.
                if (!value.chars().allMatch(Character::isLetter))
                {
                    textLine += value + " ";
                }

                //Create a planar shape if textLine is initialised.
                if (value.chars().allMatch(Character::isLetter) || !scanner.hasNext())
                {
                    if (!textLine.equals(""))
                    {
                        //Split file text line at blank spaces.
                        String[] symbols = textLine.split(" ");

                        try
                        {
                            //Create a new planar shape and add it to the list.
                            planarShapes.append(shapeFactory(symbols));
                        }

                        catch (RuntimeException e)
                        {
                            //Print out exception and continue.
                            System.out.println(e);
                        }
                    }

                    textLine = value + " ";
                }
            }

            //Close the scanner.
            scanner.close();
        }

        catch (IOException e)
        {
            System.out.println(e + "Error reading file, please run program with commands: java className filename.txt");
        }

        //Return the planar shape list.
        return planarShapes;
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