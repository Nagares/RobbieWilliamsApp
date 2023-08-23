package com.example.robbiewilliamsapp.models;

public class ClientCredo {

    static ClientCredo clientCredo = null;
    public final String CLIENT_ID = "d67d94959d9e43dfa017c8aa58ff1979";
    public final String CLIENT_SECRET = "1ce4602e56bd4a8daf15cb464d539ea4";
    public final String REDIRECT_URI = "com.example.robbiewilliamsapp://callback";

    String ClientToken ;

    public static ClientCredo getInstance(){
        if(clientCredo==null){
            clientCredo = new ClientCredo();
        }
        return clientCredo;
    }

    public String getClientToken() {
        return ClientToken;
    }

    public void setClientToken(String clientToken) {
        ClientToken = clientToken;
    }
}
