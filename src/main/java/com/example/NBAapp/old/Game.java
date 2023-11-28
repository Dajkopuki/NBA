package com.example.NBAapp.old;

import java.io.IOException;
import java.util.Random;
import java.util.*;

//public class Game {
//
//    TeamList list = new TeamList();
//
//    public void Playgame() throws IOException {
//        list.Create_Team("zoznam.CSV");
//        Tournament();
//        Arrays.sort(list.teams);
//        System.out.println(Arrays.toString(list.teams));
////        System.out.println(list.teams[0].players[0].getName()+" : "+list.teams[0].players[0].getScore());
////        System.out.println(list.teams[0].getScore());
////        System.out.println(list.teams[1].getScore());
////        System.out.println(list.teams[2].getScore());
////        System.out.println(list.teams[3].getScore());
////        System.out.println(list.teams[4].getScore());
//    }
//
//    public void Tournament() {
//        int z = 5;
//        for (int j = 0; j < 4; j++) {
//            for (int i = 1; i < z; i++) {
//                match(list.teams[j], list.teams[j + i]);
//            }
//            z--;
//        }
//    }
//
//    private void match(Team team1, Team team2) {
//        int i, j, scoret1 = 0, scoret2 = 0, genval1, genval2;
//        for (j = 0; j < 17; j++) {
//            for (i = 0; i < 5; i++) {
//                genval1 = scoregen();
//                genval2 = scoregen();
//                team1.players[i].setScore(genval1);
//                team2.players[i].setScore(genval2);
//                scoret1 = scoret1 + genval1;
//                scoret2 = scoret2 + genval2;
//            }
//        }
//
//        if (scoret1 > scoret2) {
//            team1.setScore(2);
//        } else if (scoret1 < scoret2) {
//            team2.setScore(2);
//        } else {
//            team1.setScore(1);
//            team2.setScore(1);
//        }
//    }
//
//    private int scoregen() {
//        Random rand = new Random();
//        int i = rand.nextInt(6);
//        if (i == 2) {
//            i = 2;
//        } else if (i == 3) {
//            i = 3;
//        } else {
//            i = 0;
//        }
//        return i;
//    }
//}
