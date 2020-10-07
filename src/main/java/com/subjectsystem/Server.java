package com.subjectsystem;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
   ## Description
    The RMI server which acts as the interface for the Subject System.
    We simply invoke an interface and make it available on port 1888.
 */

public class Server {
    public static void main(String[] args) {
        try {
            Api api = new Api();

            Registry registry = LocateRegistry.createRegistry(1888);
            registry.bind("SubjectSystem", api);
            System.out.println("The Subject system is live...");
        } catch (Exception e) {
            System.out.println("Api failed due to: " + e);
        }
    }
}
