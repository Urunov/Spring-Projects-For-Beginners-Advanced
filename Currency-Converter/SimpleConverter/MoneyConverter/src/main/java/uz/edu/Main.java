package uz.edu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: ${PROJECT_NAME}
 * @Date: ${DATE}
 * @author: ${USER}
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            MoneyCurrency[] moneyCurrencies = gson.fromJson(reader, MoneyCurrency[].class);

//            if(moneyCurrency1.getId()==69){
//                System.out.println(moneyCorrency1.toString());
//            }

            System.out.println(gson.toJson(moneyCurrencies));


        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}