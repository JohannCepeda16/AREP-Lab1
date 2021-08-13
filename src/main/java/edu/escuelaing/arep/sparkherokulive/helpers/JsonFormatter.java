package edu.escuelaing.arep.sparkherokulive.helpers;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonFormatter implements ResponseTransformer {

    private Gson gson = new Gson();

    public JsonFormatter(){}

    @Override
    public String render(Object object) throws Exception {
        return gson.toJson(object);
    }

}
