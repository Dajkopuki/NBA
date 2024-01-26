package com.example.NBAapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "team")
public class Team implements Comparable<Team> {
    @Nullable
    @Null(groups = CreateValidationGroup.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;
    @NonNull
    @NotNull
    @Size(max=30)
    @Column(name = "teamname")
    private String teamName;
    @Nullable
    @Null(groups = CreateValidationGroup.class)
    @Column(name = "score")
    private Integer score;
    @Nullable
    @Transient
    private Couch couch;
    @Nullable
    @Transient
    List<Player> players;

    public Team () {}

    public Team(@NonNull String teamName) {
        this.teamName = teamName;
    }

    @NonNull
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(@NonNull String teamName) {
        this.teamName = teamName;
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
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
    public int compareTo(Team o) {
        if (this.score != o.getScore()) {
            return o.getScore()- this.score;
        }
        return this.teamName.compareTo(o.getTeamName());

        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && teamName.equals(team.teamName) && Objects.equals(score, team.score) && Objects.equals(couch, team.couch) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, score, couch, players);
    }


}
