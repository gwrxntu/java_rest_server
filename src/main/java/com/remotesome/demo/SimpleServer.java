package com.remotesome.demo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {
    public SimpleServer() {
    }

    public void RunService() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(3005),0);
        httpServer.createContext("/",new RootHandler());
        httpServer.createContext("/createAllQuotes",new QuoteHandler());
        httpServer.createContext("/deleteQuote",new QuoteHandler());
        httpServer.createContext("/getAllQuotes",new QuoteHandler());
        httpServer.createContext("/getQuote",new QuoteHandler());
        httpServer.createContext("/updateQuote",new QuoteHandler());
        httpServer.createContext("/insertQuote",new QuoteHandler());



        httpServer.setExecutor(null);
        httpServer.start();
    }
}
