import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//create a class that is responsible for encoding the input
class encoder {

    public String[] getOneHot() {
        //create the oneHot array
        String[] Onehot = new String[10000];

        //create the variable that store the file name
        String OneHotFile = "./google-10000-english-usa.txt";

        try (BufferedReader oneHotFileReader = new BufferedReader(new FileReader(OneHotFile))) {
            //create a single one hot that stores a single one hot at a time
            String singleOneHot;


            for (int i = 0; (singleOneHot = oneHotFileReader.readLine()) != null; i++) {
                Onehot[i] = singleOneHot;
            }

        }
        catch (IOException error) {
            error.printStackTrace();
        }
        return Onehot;
    }

    public int[] SearchOneHot(String text, String[] oneHotStr) {
        //split the text into words
        String[] words = text.toLowerCase().split(" ");

        //create a variable that stores the oneHot of words
        int[] wordsOneHot = new int[words.length];

        //try search each word  in the oneHot array
        try {
            for (int i = 0; i <= words.length - 1; i++) {
                for (int k = 0; k <= oneHotStr.length - 1; k++) {
                    if (oneHotStr[k].equals(words[i])) {
                        wordsOneHot[i] = k;
                        break;
                    }
                }
            }
        } catch (Throwable e) {
            System.out.println("error" + e.getMessage());
        }

        //return wordsOneHot
        return wordsOneHot;




    }

}
