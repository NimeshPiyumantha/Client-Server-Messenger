package com.Nimesh.sokectProgramming.model;

import com.Nimesh.sokectProgramming.controller.SeverManagemantController;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) {
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating server.");
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMassageClient(String messageToClient) {
        try {
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending message to the client");
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void receiveMassageFromClient(VBox vBox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {


                        String massageFromClient = bufferedReader.readLine();
                        SeverManagemantController.addLabel(massageFromClient, vBox);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error receiving message from the client");
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }

            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
