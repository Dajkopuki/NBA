package com.example.NBAapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class Match {
    @Nullable
    private Integer id;
    @NonNull
    private Integer team1Id;
    @NonNull
    private Integer team1Score;
    @NonNull
    private Integer team2Id;
    @NonNull
    private Integer team2Score;

    public Match( @NonNull Integer team1Id, @NonNull Integer team1Score, @NonNull Integer team2Id, @NonNull Integer team2Score) {
        this.team1Id = team1Id;
        this.team1Score = team1Score;
        this.team2Id = team2Id;
        this.team2Score = team2Score;
    }

    public Match() {
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(@NonNull Integer team1Id) {
        this.team1Id = team1Id;
    }

    @NonNull
    public Integer getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(@NonNull Integer team1Score) {
        this.team1Score = team1Score;
    }

    @NonNull
    public Integer getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(@NonNull Integer team2Id) {
        this.team2Id = team2Id;
    }

    @NonNull
    public Integer getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(@NonNull Integer team2Score) {
        this.team2Score = team2Score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) && team1Id.equals(match.team1Id) && team1Score.equals(match.team1Score) && team2Id.equals(match.team2Id) && team2Score.equals(match.team2Score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team1Id, team1Score, team2Id, team2Score);
    }
}
