package uz.edu.currencyconvertor.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: CurrencyConvertor
 * @Date: 30.09.2022
 * @author: H_Urunov
 **/
public class Bank {
    //

    public static void main(String[] args) {

        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            System.out.println(gson.fromJson(reader, ));
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
