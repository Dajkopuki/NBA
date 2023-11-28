package com.example.NBAapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;

public class Team {
    @Nullable
    private Integer id;
    @NonNull
    private String TeamName;
    @Nullable
    private Integer Score;
    @Nullable
    private Couch couch;
    @Nullable
    List<Player> players;

    public Team () {}

    public Team(@NonNull String teamName) {
        TeamName = teamName;
    }

    @NonNull
    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(@NonNull String teamName) {
        TeamName = teamName;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @Nullable
    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    @Nullable
    public Couch getCouch() {
        return couch;
    }

    public void setCouch(@Nullable Couch couch) {
        this.couch = couch;
    }

    @Nullable
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(@Nullable List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Score == team.Score && TeamName.equals(team.TeamName) && Objects.equals(couch, team.couch) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TeamName, Score, couch, players);
    }
}
