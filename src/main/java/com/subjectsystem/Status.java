package com.subjectsystem;

/*
   ## Description
    Simple static library to generate a status which can be used within the insurance agreement.
 */

public class Status {
    public static String accepted() {
        return "ACCEPTED";
    }
    public static String declined() {
        return "DECLINED";
    }
    public static String processing() {
        return "PROCESSING";
    }
}
