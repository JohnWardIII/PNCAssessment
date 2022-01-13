package com.restcountries.program;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class capitalCity {
    URL url;
    HttpURLConnection connection;
    int responseCode;
    static Scanner scanner = new Scanner(System.in);

    {
        try {
            url = new URL("https://restcountries.com/v3.1/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (responseCode != 200){
            System.out.println("Error with response code");
        }
    }

    public static void main(String[] args) {
        System.out.println("Please enter the name or number of a country to receive the name of the capital city.");
        String country = scanner.nextLine();
        capitalCity result = new capitalCity();
        new StringBuilder().append(result.url).append("/capital").append(country).toString();
        System.out.println(result);

        if (result == null){
            System.out.println("Please enter a valid country.");
        }
    }
    //TODO
    //Research more on connecting Scanner and API path
}
