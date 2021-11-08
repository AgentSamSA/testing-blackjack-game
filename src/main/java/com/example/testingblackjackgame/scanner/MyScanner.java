package com.example.testingblackjackgame.scanner;

import java.util.Scanner;

public class MyScanner implements IMyScanner{
    @Override
    public String getResult(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you want another card? Y/N");
        String wantMore =  scanner.nextLine();
        scanner.close();
        return wantMore;
        
    }
}
