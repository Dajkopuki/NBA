package com.example.NBAapp.domain;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;
@Entity
@Table(name = "player_statistics")
public class PlayerStatisticsPerMatch {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @Column(name = "player_id")
    private Integer playerId;
    @NonNull
    @Column(name = "match_id")
    private Integer matchIdl;
    @NonNull
    @Column(name = "score_from_match")
    private Integer scoreFromMatch;

    public PlayerStatisticsPerMatch() {
    }

    public PlayerStatisticsPerMatch(@NonNull Integer playerId, @NonNull Integer matchIdl,@NonNull Integer scoreFromMatch) {
        this.playerId = playerId;
        this.matchIdl = matchIdl;
        this.scoreFromMatch = scoreFromMatch;
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

    @NonNull
    public Integer getScoreFromMatch() {
        return scoreFromMatch;
    }

    public void setScoreFromMatch(@NonNull Integer scoreFromMatch) {
        this.scoreFromMatch = scoreFromMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatisticsPerMatch that = (PlayerStatisticsPerMatch) o;
        return Objects.equals(id, that.id) && playerId.equals(that.playerId) && matchIdl.equals(that.matchIdl) && scoreFromMatch.equals(that.scoreFromMatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, matchIdl, scoreFromMatch);
    }
}
