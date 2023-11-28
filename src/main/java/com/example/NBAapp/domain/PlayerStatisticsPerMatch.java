package com.example.NBAapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class PlayerStatisticsPerMatch {

    @Nullable
    private Integer id;
    @NonNull
    private Integer playerId;
    @NonNull
    private Integer matchIdl;

    public PlayerStatisticsPerMatch() {
    }

    public PlayerStatisticsPerMatch(@NonNull Integer playerId, @NonNull Integer matchIdl) {
        this.playerId = playerId;
        this.matchIdl = matchIdl;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(@NonNull Integer playerId) {
        this.playerId = playerId;
    }

    @NonNull
    public Integer getMatchIdl() {
        return matchIdl;
    }

    public void setMatchIdl(@NonNull Integer matchIdl) {
        this.matchIdl = matchIdl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatisticsPerMatch that = (PlayerStatisticsPerMatch) o;
        return Objects.equals(id, that.id) && playerId.equals(that.playerId) && matchIdl.equals(that.matchIdl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, matchIdl);
    }
}
