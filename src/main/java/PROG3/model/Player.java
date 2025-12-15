package PROG3.model;

import java.util.Objects;

public class Player {
    int id;
    String name;
    int age;
    Position Position;
    Team team;

    public Player(int id, String name, int age, Position position, Team team) {
        this.id = id;
        this.name = name;
        this.age = age;
        Position = position;
        this.team = team;
    }
    public String getTeamName() {
        return team.name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return Position;
    }

    public void setPosition(Position position) {
        Position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && age == player.age && Objects.equals(name, player.name) && Position == player.Position && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, Position, team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Position=" + Position +
                ", team=" + team +
                '}';
    }
}
