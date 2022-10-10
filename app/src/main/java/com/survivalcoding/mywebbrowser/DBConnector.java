package com.survivalcoding.mywebbrowser;

import android.util.Log;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


public class DBConnector {
    String hostName;
    String id;
    String passWord;
    MongoClient client;

    public DBConnector(String hostName, String id, String passWord) {
        this.hostName = hostName;
        this.id = id;
        this.passWord = passWord;

    }

    public boolean connect(){
        try {
            MongoClient mongoClient = MongoClients.create(
                    "mongodb://" + this.id + ":" + this.passWord + "@" + this.hostName);

            this.client = mongoClient;
            String dbList = mongoClient.listDatabaseNames().toString();
            Log.d("DBConnector", "Success " + dbList);
        } catch (Exception e) {
            Log.d("DBConnector", "Connection Fail" + e.toString());
            return false;
        }
        return true;
    }

    public String hello() {
        return "hello";
    }
}
