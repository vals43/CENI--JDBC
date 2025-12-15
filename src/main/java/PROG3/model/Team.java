package PROG3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team {
    int id;
    String name;
    Continent Continent;
    List<Player> Players;

    public Team(int id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        Continent = continent;
        Players = new ArrayList<>();
    }

    public int getPlayerCount() {
        return Players.size();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return Continent;
    }

    public void setContinent(Continent continent) {
        Continent = continent;
    }

    public List<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Player> players) {
        Players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && Objects.equals(name, team.name) && Continent == team.Continent && Objects.equals(Players, team.Players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Continent, Players);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Continent=" + Continent +
                ", Players=" + Players +
                '}';
    }
}
