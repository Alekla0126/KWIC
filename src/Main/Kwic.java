//
//
//                                  ██ ▄█▀ █     █░ ██▓ ▄████▄
//                                  ██▄█▒ ▓█░ █ ░█░▓██▒▒██▀ ▀█
//                                  ▓███▄░ ▒█░ █ ░█ ▒██▒▒▓█    ▄
//                                  ▓██ █▄ ░█░ █ ░█ ░██░▒▓▓▄ ▄██▒
//                                  ▒██▒ █▄░░██▒██▓ ░██░▒ ▓███▀ ░
//                                  ▒ ▒▒ ▓▒░ ▓░▒ ▒  ░▓  ░ ░▒ ▒  ░
//                                  ░ ░▒ ▒░  ▒ ░ ░   ▒ ░  ░  ▒
//                                  ░ ░░ ░   ░   ░   ▒ ░░
//                                  ░  ░       ░     ░  ░ ░
//                                  ░

package Main;

import Filters.*;
import Pipes.Pipe;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alejandro Lagunes
 */
// Index of stop words: https://www.degruyter.com/document/doi/10.1515/9783110882810-030/html
public class Kwic
{
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    // -----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        // -------------------------------------------------------------------------------------------------------------
        Scanner keys = new Scanner(System.in);
        System.out.print(ANSI_YELLOW + "Enter the file name of the text file without its extension: " + ANSI_RESET);
        String textPath = keys.nextLine() + ".txt";
        // -------------------------------------------------------------------------------------------------------------
        System.out.print(ANSI_PURPLE + "Enter the file name of the stop words file without its extension: "
                + ANSI_RESET);
        String pathStopWords = keys.nextLine() + ".txt";
        // -------------------------------------------------------------------------------------------------------------
        // Pipe to get the words from the text
        Pipe textPipe = new Pipe();
        textPipe.register(new LineFilter());
        textPipe.register(new WordFilter());
        textPipe.register(new LowerCaseFilter());
        // -------------------------------------------------------------------------------------------------------------
        // Pipe to get the stop words
        Pipe stopWordsPipe = new Pipe();
        stopWordsPipe.register(new LineFilter());
        stopWordsPipe.register(new WordFilter());
        stopWordsPipe.register(new LowerCaseFilter());
        // -------------------------------------------------------------------------------------------------------------
        // Pipeline to obtain the KIWIC result
        Pipe KIWIC = new Pipe();
        KIWIC.register(new Deleter());
        KIWIC.register(new Shifter());
        // -------------------------------------------------------------------------------------------------------------
        Object words = textPipe.execute(textPath);
        Object emptyWords = stopWordsPipe.execute(pathStopWords);
        // -------------------------------------------------------------------------------------------------------------
        System.out.println("\n");
        ArrayList<String> results = (ArrayList) KIWIC.execute(words, emptyWords);
        int i = 0;
        while(i < results.size())
        {
            System.out.println(results.get(i));
            i++;
        }
        // -------------------------------------------------------------------------------------------------------------
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
}
