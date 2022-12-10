import java.net.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //fetching and writing to file
        handleUrlContents("https://academic.udayton.edu/kissock/http/Weather/gsod95-current/AKANCHOR.txt");
        TemperatureNormalizer obj = new TemperatureNormalizer(readFile());
        System.out.println(obj.getAdjustedAverage());
    }

    private static void handleUrlContents(String theUrl) throws IOException {
        FileWriter myWriter = new FileWriter("AnchorageTemperature.txt");
        URL url = new URL(theUrl); // creating a url object
        URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

        // wrapping the urlconnection in a bufferedreader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;

        // reading from the urlconnection using the bufferedreader
        while ((line = bufferedReader.readLine()) != null)
            myWriter.write(line + "\n");

        //closing
        bufferedReader.close();
        myWriter.close();
    }

    public static double[] readFile() throws FileNotFoundException {
        List<Double> arrList = new ArrayList<>();        //        opening the file
        File myObj = new File("AnchorageTemperature.txt");
        Scanner myReader = new Scanner(myObj);

//        reading required months and string
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().trim().split("\\s+");
            if (Objects.equals(data[2], "1995"))
                if (Objects.equals(data[0], "1") || Objects.equals(data[0], "2"))
                    arrList.add((Double.parseDouble(data[3])));
        }
//            clsoing stream
        myReader.close();
        Double[] arr = arrList.toArray(new Double[arrList.size()]);
        double[] doubleArr = Stream.of(arr).mapToDouble(Double::doubleValue).toArray();
        return doubleArr;
    }
}