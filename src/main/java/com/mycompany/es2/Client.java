/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.es2;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Client {

    private Socket socket;

    private PrintWriter out;

    private BufferedReader in;

  //initializes the client to the ip and port specified and opens the comunication streams
    Client(String address, int port) {

        try {
            socket = new Socket(address, port);

            out = new PrintWriter(socket.getOutputStream());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //sends data to the stream and flushes it
    public void write(String text) {

        out.write(text + "\n");
        out.flush();

    }

    //reads the data recieved 
    public String read() {
        try {
            return in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    //closes the socket
    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
