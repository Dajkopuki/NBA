package com.example.NBAapp;

import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.db.service.imp.PlayerServiceImpl;
import com.example.NBAapp.domain.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTests {

    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerStatisticsRepository playerStatisticsRepository;

    @Before
    public void init() {
        playerService = new PlayerServiceImpl(playerRepository, playerStatisticsRepository, playerRepositoryTest);
    }

    @Test
    public void addPlayer(){
        Player player1 = new Player("Milan","Vasko", 555);

        int playerId = 123;
        Mockito.when(playerRepository.add(any(Player.class))).thenReturn(playerId);

        Integer addedPlayerId = playerService.add(player1);

        assertEquals(playerId, addedPlayerId);
    }

    @Test
    public void addPlayerFailed(){
        Player player1 = new Player("Milan","Vasko", 555);

        int playerId = 123;
        Mockito.when(playerRepository.add(any(Player.class))).thenThrow(new IllegalArgumentException("something went wrong"));

        Integer addedPlayerId = playerService.add(player1);

        assertEquals(playerId, addedPlayerId);
    }
}
