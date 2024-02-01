package com.example.NBAapp;

import com.example.NBAapp.db.repository.PlayerRepository;
import com.example.NBAapp.db.repository.PlayerStatisticsRepository;
import com.example.NBAapp.db.service.api.PlayerService;
import com.example.NBAapp.db.service.imp.PlayerServiceImpl;
import com.example.NBAapp.domain.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.NBAapp.NbAappApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTests {

    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerServiceImpl playerService;



    @Test
    public void addPlayer(){
        Player player = new Player("Milan","Vasko", 555);

        Mockito.when(playerRepository.save(any(Player.class))).thenReturn(player);

        Player addedPlayer = playerService.add(player);

        assertEquals(player.getId(), addedPlayer.getId());
    }

    @Test
    public void getPlayer(){
        Player player = new Player("Milan","Vasko", 555);

        Mockito.when(playerRepository.findById(any(Integer.class))).thenReturn(Optional.of(player));

        Player playerFromDb = playerService.get(5).get();

        assertEquals(player.getId(), playerFromDb.getId());

    }

    @Test
    public void getPlayers(){
        Player player = new Player("Milan","Vasko", 555);
        List<Player> players = new ArrayList<>();
        players.add(player);

        Mockito.when(playerRepository.findAll()).thenReturn(players);

        List<Player> playersfromdb = playerService.getPlayers();
        assertEquals(1,playersfromdb.size());
    }




}
