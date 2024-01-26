package com.example.NBAapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;
@Entity
@Table(name = "couch")
public class Couch {
    @Nullable
    @Null(groups = CreateValidationGroup.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @NotNull
    @Size(max=20)
    @Column (name = "name")
    private String Name;
    @NonNull
    @NotNull
    @Size(max=20)
    @Column (name = "surname")
    private String Surname;
    @NonNull
    @NotNull
    @Column (name = "teamid")
    private Integer TeamId;

    public Couch() {}

    public Couch(@NonNull String name, @NonNull String surname, @NonNull Integer TeamId) {
        this.Name = name;
        this.Surname = surname;
        this.TeamId = TeamId;
    }

    @NonNull
    public String getSurname() {
        return Surname;
    }

    public void setSurname(@NonNull String surname) {
        Surname = surname;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }
    @NonNull
    public Integer getTeamId() {
        return TeamId;
    }

    public void setTeamId(@NonNull Integer  teamId) {
        TeamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couch couch = (Couch) o;
        return Name.equals(couch.Name) && Surname.equals(couch.Surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname);
    }
}
