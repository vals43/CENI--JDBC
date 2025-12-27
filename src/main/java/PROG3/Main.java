package PROG3;

import PROG3.DB.DBConnection;
import PROG3.model.Team;
import PROG3.service.DataRetriever;

public class Main {
    public static void main(String[] args) {
        DataRetriever data = new DataRetriever();
        DBConnection db = new DBConnection();

        try {
            db.getDBConnection();
            Team team = data.findTeamById(1);
            System.out.println(team);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
