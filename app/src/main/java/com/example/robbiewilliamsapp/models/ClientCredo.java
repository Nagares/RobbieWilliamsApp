package com.example.robbiewilliamsapp.models;

public class ClientCredo {

    static ClientCredo clientCredo = null;
    public final String CLIENT_ID = "87e797b690b3421e8e7f0a0af0d5ab16";
    public final String CLIENT_SECRET = "11433a8cbed44d3eab80a70fd99685b1";
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
