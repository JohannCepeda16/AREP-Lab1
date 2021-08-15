package edu.escuelaing.arep.sparkherokulive.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.escuelaing.arep.sparkherokulive.helpers.CacheServices;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class DataServices {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&%s&apikey=Q1QZFVJQ21K7C6XM";

    public static void main(String[] args) throws IOException {
        staticFiles.location("/public");
        port(getPort());
        init();
        get("/fetchActionByIdentifier", "application/json", (req, res) -> fetchActionByIdentifier(req, res));
    }

    private static String fetchActionByIdentifier(Request request, Response response) throws Exception {

        String identifier = request.queryParams("identifier");
        System.out.println("Identifier: " + identifier);
        String res = CacheServices.getInstance().getDataByIndentifier(identifier);
        if (res == null) {
            res = findDataByIdentifier(identifier);
            CacheServices.getInstance().saveNewData(identifier, res);
            System.out.println("Found by search");
        }

        return res;
    }

    private static String findDataByIdentifier(String identifier) {
        String res = "";
        try {
            String finalURL = String.format(GET_URL, "symbol=" + identifier.toLowerCase());
            URL obj = new URL(finalURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            // The following invocation perform the connection implicitly before getting the
            // code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    res += inputLine + "\n";
                }
                in.close();

            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
