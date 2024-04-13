package org.example;

import java.util.Scanner;

public class View {

    private static Scanner scanner;

    private View(){
        View.scanner = new Scanner(System.in);
    }

    public static Scanner getScanner(){
        if(View.scanner == null){
            new View();
        }
        return View.scanner;
    }

}
