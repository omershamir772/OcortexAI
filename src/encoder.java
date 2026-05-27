import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//create a class that is responsible for encoding the input
class encoder {

    public String[] getOneHot() {
        //create the oneHot array
        String[] Onehot = new String[9999];

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
}
