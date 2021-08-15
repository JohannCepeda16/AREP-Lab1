package edu.escuelaing.arep.sparkherokulive.helpers;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonFormatter implements ResponseTransformer {

    private Gson gson = null;

    public JsonFormatter(){
        gson = new Gson();
    }

    @Override
    public String render(Object object) throws Exception {
        return gson.toJson(object);
    }

}
