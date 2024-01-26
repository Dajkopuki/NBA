package com.example.NBAapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;
@Entity
@Table (name = "player")
public class Player {
    @Nullable
    @Id
    @Null(groups = CreateValidationGroup.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @NonNull
    @NotNull
    @Size(max=20)
    @Column (name = "name")
    private String name;
    @NonNull
    @NotNull
    @Column (name = "surname")
    private String surname;
    @NonNull
    @NotNull
    @Column (name = "teamid")
    private Integer teamId;
    @Nullable
    @Null(groups = CreateValidationGroup.class)
    @Column (name = "score")
    private Integer score;

    public Player () {}

    public Player( @NonNull String name, @NonNull String surname, @NonNull Integer teamId) {
        this.name = name;
        this.surname = surname;
        this.teamId = teamId;
    }
    @Nullable
    public Integer getScore() {
        return score;
    }

    public void setScore(@Nullable Integer score) {
        this.score = score;
    }


    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }



    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name) && Objects.equals(surname, player.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name, surname);
    }
}
