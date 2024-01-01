package com.example.NBAapp;

import com.example.NBAapp.domain.Couch;
import com.example.NBAapp.domain.Player;
import com.example.NBAapp.domain.Team;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
public class RestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Team team;

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


//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
    @Test
    public void player() throws Exception {
        Player player = new Player("Kamil", "Peteraj", team.getId());
        String id = mockMvc.perform(post("/player")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(player)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        player.setId(objectMapper.readValue(id,Integer.class));

        String playerJson = mockMvc.perform(get("/player/" + player.getId()))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Player returnedPlayer = objectMapper.readValue(playerJson,Player.class);
        Assert.assertEquals(player,returnedPlayer);

        String playersJson = mockMvc.perform(get("/player"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Player> players = objectMapper.readValue(playersJson,new TypeReference<List<Player>>(){});
        assert players.size()==1;
        Assert.assertEquals(player,players.get(0));

        mockMvc.perform(delete("/player/"+ player.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String playersJsonAfterDelete = mockMvc.perform(get("/player"))
                .andReturn().getResponse().getContentAsString();

        List<Player> playersAfterDelete = objectMapper.readValue(playersJsonAfterDelete, new TypeReference<List<Player>>(){});
        Assert.assertEquals(0,playersAfterDelete.size());
    }

    @Test
    public void team() throws Exception {
        //already created

        String teamJson = mockMvc.perform(get("/team/" + team.getId()))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Team returnedTeam = objectMapper.readValue(teamJson,Team.class);
        Assert.assertEquals(team,returnedTeam);

        String teamsJson = mockMvc.perform(get("/team"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Team> teams = objectMapper.readValue(teamsJson,new TypeReference<List<Team>>(){});
        assert teams.size()==1;
        Assert.assertEquals(team,teams.get(0));

        mockMvc.perform(delete("/team/"+ team.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String teamsJsonAfterDelete = mockMvc.perform(get("/team"))
                .andReturn().getResponse().getContentAsString();

        List<Team> teamsAfterDelete = objectMapper.readValue(teamsJsonAfterDelete, new TypeReference<List<Team>>(){});
        Assert.assertEquals(0,teamsAfterDelete.size());
    }

    @Test
    public void couch() throws Exception {
        Couch couch = new Couch("Kamil", "Peteraj", team.getId());
        String id = mockMvc.perform(post("/couch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(couch)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        couch.setId(objectMapper.readValue(id,Integer.class));

        String couchJson = mockMvc.perform(get("/couch/" + couch.getId()))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Couch returnedCouch = objectMapper.readValue(couchJson,Couch.class);
        Assert.assertEquals(couch,returnedCouch);

        String couchesJson = mockMvc.perform(get("/couch"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Couch> couches = objectMapper.readValue(couchesJson,new TypeReference<List<Couch>>(){});
        assert couches.size()==1;
        Assert.assertEquals(couch,couches.get(0));

        mockMvc.perform(delete("/couch/"+ couch.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String couchesJsonAfterDelete = mockMvc.perform(get("/couch"))
                .andReturn().getResponse().getContentAsString();

        List<Couch> couchesAfterDelete = objectMapper.readValue(couchesJsonAfterDelete, new TypeReference<List<Couch>>(){});
        Assert.assertEquals(0,couchesAfterDelete.size());
    }








}
