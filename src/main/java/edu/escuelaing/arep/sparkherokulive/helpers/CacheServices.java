package edu.escuelaing.arep.sparkherokulive.helpers;

import java.util.concurrent.ConcurrentHashMap;

public class CacheServices {

    public static CacheServices instance;
    private ConcurrentHashMap<String, String> dataStock = new ConcurrentHashMap<String, String>();

    private CacheServices() {}

    public static CacheServices getInstance() {
        if (instance == null) {
            instance = new CacheServices();
        }
        return instance;
    }

    public String getDataByIndentifier(String identifier) {
        if (dataStock.get(identifier) != null) {
            System.out.println("Found by database");
            return dataStock.get(identifier);
        }
        return null;
    }

    public void saveNewData(String identifier, String data) {
        System.out.println("Saved new data");
        dataStock.put(identifier, data);
    }

    // GETTERS && SETTERS
    public CacheServices(ConcurrentHashMap<String, String> dataStock) {
        this.dataStock = dataStock;
    }

    public ConcurrentHashMap<String, String> getDataStock() {
        return this.dataStock;
    }

    public void setDataStock(ConcurrentHashMap<String, String> dataStock) {
        this.dataStock = dataStock;
    }

    @Override
    public String toString() {
        return "{" + " dataStock='" + getDataStock() + "'" + "}";
    }

}
