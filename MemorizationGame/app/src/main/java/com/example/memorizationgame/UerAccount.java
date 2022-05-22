package com.example.memorizationgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UerAccount implements Serializable {

    private String userName;
    private String passWord;
    //HashMap name_password = new HashMap<>();
    ArrayList points = new ArrayList();
    public static final long serialVersionUID = 329063264L;



    public UerAccount() {
    }

    public UerAccount(String userName, String passWord) {
        //could not be empty string
        this.userName = userName;
        this.passWord = passWord;
    }

    public int gettotalPoints() {

        int total = 0;
        Iterator iterator = points.iterator();
        while (iterator.hasNext()) {
            total += (int) iterator.next();
        }
        return total;
    }
    public String getRankHistory(){
        String history = "";
        if(points.size() == 0){
            return history + "No Score History!";
        }
        int i = 0;
        Iterator iterator = points.iterator();
        while (iterator.hasNext()) {
            i++;
            history += i + " Round: " + iterator.next() + "\n";
        }
        return history;
    }

    public int getCompleteRounds(){
        int totalRound = 0;
        for (int i = 0; i < points.size(); i++) {
            totalRound ++;
        }
        return totalRound;
    }

    public void updatePoints(int n){
        points.add(n);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return this.userName;
    }
}