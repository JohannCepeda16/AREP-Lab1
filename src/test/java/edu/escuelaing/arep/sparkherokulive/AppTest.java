package edu.escuelaing.arep.sparkherokulive;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.escuelaing.arep.sparkherokulive.controllers.DataServices;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String USER_AGENT = "Mozilla/5.0";

    @Before
    public void init() throws IOException {
        DataServices.main(new String[] {});
    }

    @Test
    public void deberiaBuscarUnaAccionDadoSuIdentificador() {
        String res = null;
        try {
            URL obj = new URL("/findDataByIdentifier?identifier=fb");
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
                res = "";
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

        assertNotNull(res);
    }
}
