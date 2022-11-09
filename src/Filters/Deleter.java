package Filters;

import java.util.ArrayList;


/**
 *
 * @author Alejandro Lagunes
 */
public class Deleter extends Filter
{
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected Object process(Object entry)
    {
        return null;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected Object process(Object entry1, Object entry2){
        ArrayList<String> words = (ArrayList) entry1;
        ArrayList<String> stopWords = (ArrayList) entry2;
        int indicator = 0;
        boolean removed = false;
        // -------------------------------------------------------------------------------------------------------------
        while(indicator < words.size())
        {
            int index = 0;
            while(index < stopWords.size())
            {
                if(words.get(indicator).equals(stopWords.get(index)))
                {
                    words.remove(indicator);
                    removed = true;
                    break;
                }
                index++;
            }
            if(!removed)
            {
                indicator++;
            }
            else
            {
                removed = false;
            }
        }
        // -------------------------------------------------------------------------------------------------------------
        return words;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
}
