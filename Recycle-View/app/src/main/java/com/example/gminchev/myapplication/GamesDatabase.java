package com.example.gminchev.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class GamesDatabase {
     private static  List<Games> database;

    public static List<Games> getDatabase() {
        if (database==null) {
            database = generateDatabase();

        }
        return database;
    }

    private static List<Games> generateDatabase () {
        return Arrays.asList(
                new Games("butterfield", "https://static.gamespot.com/uploads/square_medium/1197/11970954/2369156-e3_mp_02.jpg"),
                new Games("Total War : Rome ||", "https://www.instant-gaming.com/images/products/200/screenshot/200-3.jpg"),
                new Games("Phoenix Point", "https://scontent.fsof3-1.fna.fbcdn.net/v/t31.0-8/27797701_565998913780353_8962408062466919539_o.jpg?oh=0f0d7a502e6b562df4527ffd08ea91be&oe=5B0AA6FA"),
                new Games("Call of Duty", "https://static.gamespot.com/uploads/screen_petite/1576/15769789/3248384-callofduty_wwii_screen1.jpg")
         );
    }


}
