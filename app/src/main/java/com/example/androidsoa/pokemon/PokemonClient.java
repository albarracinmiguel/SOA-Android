package com.example.androidsoa.pokemon;

import com.example.androidsoa.util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PokemonClient implements IPokemonClient {
    private static final String GET_METHOD = "GET";
    private static final String USER_AGENT = "Mozilla/5.0";

    public void getPokemon(String name) {
        System.out.println("GET POKEMON IN CLIENT");
        try {
            this.sendRequest(name);
        } catch (Exception ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void sendRequest(String identifier) throws Exception {
        System.out.println("SEND REQUEST");
        /*URL obj = new URL(Constants.POKEMON_API + identifier);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(GET_METHOD);
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            System.out.println(response);
        } else {
            System.out.println("GET request not worked");
        }*/
    }
}
