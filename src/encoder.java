import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//create a class that is responsible for encoding the input
class Encoder extends Data{

    public static HashMap<String, Integer> getOneHot() {        //create a hashmap
        HashMap<String, Integer> wordMap = new HashMap<>();

        //create the variable that store the file name
        String OneHotFile = "./google-10000-english-usa.txt";

        try (BufferedReader oneHotFileReader = new BufferedReader(new FileReader(OneHotFile))) {
            //create a single one hot that stores a single one hot at a time
            String singleOneHot;


            for (int i = 0; (singleOneHot = oneHotFileReader.readLine()) != null; i++) {
                wordMap.put(singleOneHot, i);
            }

        }
        catch (IOException error) {
            error.printStackTrace();
        }

        return wordMap;
    }

    public int[] SearchOneHot(String text, HashMap<String, Integer> oneHotStr) {
        //split the text into words
        String cleanedText = text.toLowerCase().replaceAll("[^a-z' ]", "");
        String[] words = cleanedText.split("\\s+");

        //create a variable that stores the oneHot of words
        List<Integer> wordsOneHot = new ArrayList<>();

        //try search each word  in the oneHot array
        for (String word : words) {
            if (oneHotStr.containsKey(word)) {
                wordsOneHot.add(oneHotStr.get(word));
            }
        }

        int[] result = new int[wordsOneHot.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = wordsOneHot.get(i);
        }

        //return wordsOneHot
        return result;




    }

}
