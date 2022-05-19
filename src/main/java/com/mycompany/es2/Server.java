/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.es2;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author david
 */
public class Server {

    //variable declaration

    private Socket socket;

    private ServerSocket serversocket;

    private PrintWriter out;

    private BufferedReader in;

    Server(int port) {
        try {

          //start a new serversocket to the port indicated by the constructor
          
            serversocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //opens the connection to one client at a time and opens stream for inputting and outputting data
    public void start() {
        try {   
            socket = serversocket.accept();
            
            out = new PrintWriter(socket.getOutputStream());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println("In attesa...");
          
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

  //closes the socket
    public void close() {

        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
