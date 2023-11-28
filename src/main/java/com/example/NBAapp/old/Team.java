//package com.example.NBAapp.old;
//
//
//public class Team implements Comparable<Team>  {
//    public Couch couch;
//    private final String TeamName;
//    public Player[] players= new Player[5];
//    private int i =0;
//    public int score=0;
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = this.score + score;
//    }
//
//    public Team (String Name) {
//        this.TeamName =Name;
//    }
//
//    public String getTeamName() {
//        return TeamName;
//    }
//
//    public void createcouch (String Name) {
//        couch =new Couch(Name);
//
//    }
//
//    public void createplayer (String Name) {
//        players[i] = new Player(Name);
//        i++;
//    }
//
//
//    @Override
//    public int compareTo(Team o) {
//        if (this.score != o.getScore()) {
//            return o.getScore()- this.score;
//        }
//        return this.TeamName.compareTo(o.getTeamName());
//    }
//
//    @Override
//    public String toString()
//    {
//        return  "name=" + TeamName +
//                ", score=" + score ;
//    }
//}
