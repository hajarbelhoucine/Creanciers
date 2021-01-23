package Serveur;

import Service.CreanceService;

import javax.xml.ws.Endpoint;


public class Serveur {

    public static void main(String[] args){
        String url="http://localhost:8585/";
        Endpoint.publish(url,new CreanceService());
    }
}
