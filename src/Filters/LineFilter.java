package Filters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Alejandro Lagunes
 */
public class LineFilter extends Filter
{
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected Object process(Object entry)
    {
        // -------------------------------------------------------------------------------------------------------------
        String path = (String) entry;
        ArrayList<String> lines = new ArrayList<>();
        File file;
        FileReader archiveReader = null;
        BufferedReader bufferReader;
        // -------------------------------------------------------------------------------------------------------------
        try
        {
            file = new File (path);
            if (!file.exists())
            {
                System.out.println("File does not exist");
            }
            String line;
            archiveReader = new FileReader (file);
            bufferReader = new BufferedReader(archiveReader);
            while((line=bufferReader.readLine())!=null)
            {
                lines.add(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            // File is closed.
            try
            {
                if( archiveReader != null)
                {
                    archiveReader.close();
                }
            }
            // If no read permissions or does not exist - null value.
            catch (IOException e){}
        }
        // -------------------------------------------------------------------------------------------------------------
        return lines;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected Object process(Object entry1, Object entry2)
    {
        return null;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
}
