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

            MoneyCorrency[] moneyCorrencies = gson.fromJson(reader, MoneyCorrency[].class);
            MoneyCorrency moneyCorrency1 = new MoneyCorrency();

//            if(moneyCorrency1.getId()==69){
//                System.out.println(moneyCorrency1.toString());
//            }

            System.out.println(gson.toJson(moneyCorrencies));


        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}