/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.es2;

/**
 *
 * @author david
 */
public class Es2 {

    public static void main(String[] args) {

        Server s1 = new Server(2000);
        Client c1 = new Client("127.0.0.1", 2000);
        s1.start();
        s1.write("ciao");
        System.out.println(c1.read());

        c1.close();
        s1.close();

    }
}
