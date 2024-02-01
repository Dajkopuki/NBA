package com.example.NBAapp;

import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class PlayerRestIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Team team;
    private String id;

    private Player player;

    @Before
    public void createTeam () throws Exception {
        if(team==null) {
            team = new Team("Dragons");
            String id = mockMvc.perform(post("/team")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(team)))
                    .andExpect(status().isCreated())
                    .andReturn().getResponse().getContentAsString();
            team.setId(objectMapper.readValue(id,Integer.class));
        }
    }
    @Before
    public void addPlayer() throws Exception {
        player= new Player("Kamil", "Peteraj", team.getId());
        id = mockMvc.perform(post("/player")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(player)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        player.setId(objectMapper.readValue(id,Integer.class));
    }

    @Test
    public void getPlayer() throws Exception  {
        String playerJson = mockMvc.perform(get("/player/" + player.getId()))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Player returnedPlayer = objectMapper.readValue(playerJson,Player.class);
        Assert.assertEquals(player,returnedPlayer);
    }

    @Test
    public void getPlayers()throws  Exception {
        String playersJson = mockMvc.perform(get("/player"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Player> players = objectMapper.readValue(playersJson,new TypeReference<List<Player>>(){});
        assert players.size()==1;
        Assert.assertEquals(player,players.get(0));
    }

    @Test
    public void deletePayer() throws Exception {
        mockMvc.perform(delete("/player/"+ player.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String playersJsonAfterDelete = mockMvc.perform(get("/player"))
                .andReturn().getResponse().getContentAsString();

        List<Player> playersAfterDelete = objectMapper.readValue(playersJsonAfterDelete, new TypeReference<List<Player>>(){});
        Assert.assertEquals(0,playersAfterDelete.size());
    }
}
