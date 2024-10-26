package com;

import java.util.Scanner;

public class App {

    public int add(String input) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try {
            App obj = new App();

            String input = sc.nextLine();
            obj.add(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
