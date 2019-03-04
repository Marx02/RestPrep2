/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import Person.Person;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author caspe
 */
public class Generator {

    Gson gson = new Gson();

    String[] firstNames = new String[]{"Jens", "Mads", "Lars", "Andreas", "Achmed", "Muhammed", "Ali", "ChingChong"};
    String[] lastNames = new String[]{"Jensen", "Madsen", "Larsen", "Andreasen", "Achmed", "Muhammed", "Ali", "ChingChong"};

//    public static void main(String[] args) {
//        Generator gen = new Generator();
//        System.out.println(gen.generate(100,1000));
//    }
    public String generate(int amount, int startID) {
        String json;
        ArrayList<Person> pList = new ArrayList();
        for (int i = 0; i < amount; i++) {
            Person p = new Person(startID + i, getRandomName(firstNames), getRandomName(lastNames), getRandomNumberInRange(17, 70));
            pList.add(p);
        }
        json = gson.toJson(pList);

        return json;
    }

    String getRandomName(String[] names) {
        int rnd = new Random().nextInt(names.length);
        return names[rnd];
    }

    int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}

