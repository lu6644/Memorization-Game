package com.example.memorizationgame;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    //private String filename = "all_users.txt";
    //File sd = Environment.getExternalStorageDirectory();
    //private String localDir = "D:\\NewProjects\\MemorizationGame\\MemorizationGame\\app"; //modify the path according to the file path on your computer
    //private String filePath;
    private InputStream is;
    private ArrayList<String> fileLines = new ArrayList<String>();
    private ArrayList<UerAccount> users = new ArrayList<UerAccount>();

    public FileIO(InputStream is){
        /*
        this.filename = filename;
        //this.filePath = String.format("%s\\%s",this.localDir,filename);
        this.file = new File(sd,filename);
        try{
            this.file.createNewFile();
        }
        catch (Exception e){
            System.err.println(e);
        }
        */
        this.is = is;
        createFileStr();
        createUsers();
    }
    /*
    public FileIO(){
        //this.filePath = String.format("%s\\%s",this.localDir,filename);
        this.file = new File(sd,this.filename);
        try{
            this.file.createNewFile();
        }
        catch (Exception e){
            System.err.println(e);
        }
        createFileStr();
        createUsers();
    }

     */

    public void createFileStr(){
        try{
            /*
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()){
                String userData = myReader.nextLine();
                this.fileLines.add(userData);
            }
            myReader.close();
            */
            /*
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);

             */
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
            String userData;
            while ((userData = br.readLine()) != null){
                this.fileLines.add(userData);
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createUsers(){
        for (int i = 0; i < this.fileLines.size(); i++){
             String[] strs = fileLines.get(i).split(" ");
             String username = strs[0];
             String password = strs[1];
             UerAccount user = new UerAccount(username,password);
             this.users.add(user);
             if ((strs.length > 2) && (strs[2]!="")){
                 for (int j = 2; j < strs.length; j++){
                     try {
                         user.updatePoints(Integer.parseInt(strs[j]));
                     }
                     catch (NumberFormatException ex){
                         ex.printStackTrace();
                     }
                 }
             }
        }
    }

    // If the given username is not found, return -1
    public int getUserIndex(String username){
        for (int i = 0; i < this.users.size(); i++){
            if (this.users.get(i).getUserName().equals(username)){
                return i;
            }
        }
        return -1;
    }

    public UerAccount getUser(String username){
        int index = this.getUserIndex(username);
        if (index != -1){
            return this.users.get(index);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean match(String username, String password){
        int userIndex = this.getUserIndex(username);
        if (userIndex!=-1){
            return this.users.get(userIndex).getPassWord().equals(password);
        }
        else {
            return false;
        }
    }

    public ArrayList<UerAccount> getUsers() {
        return this.users;
    }

    public void appendToFile(UerAccount user, OutputStream os){
        try {
            //FileWriter fw = new FileWriter(this.file, true);
            //BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            PrintWriter out = new PrintWriter(bw);
            String line = String.format("%s %s",user.getUserName(),user.getPassWord());
            out.println(line);
            bw.close();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public void addUser(UerAccount user, OutputStream os){
        if(this.getUserIndex(user.getUserName()) == -1){
            this.users.add(user);
            appendToFile(user,os);
        }
    }



}
