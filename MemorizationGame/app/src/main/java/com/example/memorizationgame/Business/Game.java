package com.example.memorizationgame.Business;

import com.example.memorizationgame.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Game implements Serializable {
    public int[] shapes = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10,
            R.drawable.image11, R.drawable.image12,R.drawable.image13,R.drawable.image14,R.drawable.image15,
            R.drawable.image16,R.drawable.image17,R.drawable.image18,R.drawable.image19,R.drawable.image20,
            R.drawable.image21,R.drawable.image22,R.drawable.image23,R.drawable.image24,R.drawable.image25,
            R.drawable.image26,R.drawable.image27,R.drawable.image28,R.drawable.image29};
    public int[] answer = new int[3];
    public int[] answerLevel2 = new int[6];
    //int[] answerLevel3 = new int[9];
    public static final long serialVersionUID = 5328463264L;


    public int[] getAnswer() {
        Random rand = new Random();
        HashSet<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < 3){
            int n = rand.nextInt(29);
            answerSet.add(n);
        }
        Object[] an = answerSet.toArray();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) an[i];
        }
        return answer;
    }

    public int[] getAnswerLevel2() {
        Random rand = new Random();
        HashSet<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < 6){
            int n = rand.nextInt(29);
            answerSet.add(n);
        }
        Object[] an = answerSet.toArray();
        for (int i = 0; i < answerLevel2.length; i++) {
            answerLevel2[i] = (int) an[i];
        }
        return answerLevel2;
    }
    /*public int[] getAnswerLevel3() {
        Random rand = new Random();
        HashSet<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < 9){
            int n = rand.nextInt(29);
            answerSet.add(n);
        }
        Object[] an = answerSet.toArray();
        for (int i = 0; i < answerLevel3.length; i++) {
            answerLevel3[i] = (int) an[i];
        }
        return answerLevel3;
    }
*/

    public Object[] getOptions(){
        HashSet<Integer> optionSet = new HashSet<>();
        for (int i = 0; i < answer.length; i++) {
            optionSet.add(answer[i]);
        }
        Random rand = new Random();
        while (optionSet.size() < 6){
            int n = rand.nextInt(29);
            optionSet.add(n);
        }
        ArrayList<Integer> list = new ArrayList<>(optionSet);

        Collections.shuffle(list);

        Object[] optionArray = list.toArray();
        return optionArray;
    }

    public Object[] getOptionsLv2(){
        HashSet<Integer> optionSet = new HashSet<>();
        for (int i = 0; i < answerLevel2.length; i++) {
            optionSet.add(answerLevel2[i]);
        }
        Random rand = new Random();
        while (optionSet.size() < 12){
            int n = rand.nextInt(29);
            optionSet.add(n);
        }
        ArrayList<Integer> list = new ArrayList<>(optionSet);

        Collections.shuffle(list);

        Object[] optionArray = list.toArray();
        return optionArray;
    }
   /* public Object[] getOptionsLv3(){
        HashSet<Integer> optionSet = new HashSet<>();
        for (int i = 0; i < answerLevel3.length; i++) {
            optionSet.add(answerLevel3[i]);
        }
        Random rand = new Random();
        while (optionSet.size() < 18){
            int n = rand.nextInt(29);
            optionSet.add(n);
        }
        ArrayList<Integer> list = new ArrayList<>(optionSet);

        Collections.shuffle(list);

        Object[] optionArray = list.toArray();
        return optionArray;
    }*/


}