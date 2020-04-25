package com.remotesome.demo;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class QuoteHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {


        Map<String,Object> parameters = new HashMap<String,Object> ();
        URI requestUri = httpExchange.getRequestURI();
        String requestMethod = httpExchange.getRequestMethod();
        String query = requestUri.getRawQuery();
        BasicAuthenticator authenticator = new BasicAuthenticator("quotes") {
            public boolean checkCredentials(String username, String password) {
                if(username.equals("admin") && password.equals("password")){
                    return true;
                }
                return false;
            }

            @Override
            public Result authenticate(HttpExchange t) {
                return super.authenticate(t);

            }
        };

        Authenticator.Result result = authenticator.authenticate(httpExchange);

       if(result instanceof Authenticator.Success){

       }




    }
}
