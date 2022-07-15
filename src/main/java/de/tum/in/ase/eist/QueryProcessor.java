package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return query.split(":")[0];
        }
        else if(query.contains("plus")){
            String[] sArr = query.replaceAll(",","").split(" ");
            int sum = 0;
            for(int i=0; i<sArr.length; i++){

                try {
                    int number = Integer.parseInt(sArr[i]);
                    sum += number;
                } catch (Exception e) {

                }
            }
            return String.valueOf(sum);
        }
        else if(query.contains("largest")){
            String[] sArr = query.replaceAll(",","").split(" ");
            int max = -999999999;
            ArrayList<Integer> numbersList = new ArrayList<>();
            for(int i=0; i<sArr.length; i++){
                try {
                    int number = Integer.parseInt(sArr[i]);
                    numbersList.add(number);
                } catch (Exception e) {

                }
            }

            return String.valueOf( Collections.max(numbersList));
        }
        else {
            return "";
        }
    }
}
