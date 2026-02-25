package PROG3.service;

import PROG3.DB.DBConnection;
import PROG3.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private final DBConnection dbConnection = new DBConnection();

    public String countAllVotes()  {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                select count('id') as total_votes
                from vote;
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            long total_votes = 0;
            if (rs.next()) {
                total_votes =  rs.getLong("total_votes");
                return "totalVote = "+total_votes;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "totalVote = 0";
    }

    //bug du cast sur le enum
    public List<VoteTypeCount> countVotesByType(){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                SELECT vote_type, COUNT(*) as count
                FROM vote
                GROUP BY vote_type
                ORDER BY count DESC;
                """;

        List<VoteTypeCount> ls= new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VoteTypeCount data = new VoteTypeCount();
                data.setCount(rs.getInt("count"));
                data.setVoteType(VoteTypeEnum.valueOf( rs.getString("vote_type")));
                ls.add(data);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ls;

    }

    public List<CandidateVoteCount> countValidVotesByCandidate(){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                SELECT c.name , count(
                        CASE
                            WHEN v.vote_type = 'VALID' then v.vote_type
                            END
                                ) as valid_vote
                from candidate c
                INNER JOIN public.vote v on c.id = v.candidate_id
                group by c.name ;
                """;

        List<CandidateVoteCount> ls= new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CandidateVoteCount data = new CandidateVoteCount();
                data.setCandidateName(rs.getString("name"));
                data.setValidVoteCount( rs.getInt("valid_vote"));
                ls.add(data);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ls;

    };

    public VoteSummary computeVoteSummary(){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                    SELECT count(
                                   CASE
                                       WHEN v.vote_type = 'VALID' then v.vote_type
                                       END
                           ) as valid_count ,
                           count(
                                   CASE
                                       WHEN v.vote_type = 'BLANK' then v.vote_type
                                       END
                           ) as blank_count ,
                           count(
                                   CASE
                                       WHEN v.vote_type = 'NULL' then v.vote_type
                                       END
                           ) as null_count
                    FROM vote v ;
                """;

        VoteSummary vs = new VoteSummary();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                vs.setBlankCount(rs.getInt("blank_count"));
                vs.setNullCount(rs.getInt("null_count"));
                vs.setValidCount(rs.getInt("valid_count"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vs;
    };

    public double computeTurnoutRate(){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                    SELECT ((count(v.id) / count(vt.id) ) *100) as percent
                    from vote v
                    INNER JOIN public.voter vt on vt.id = v.voter_id;
                """;
        double percent = 0.0;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                percent =  rs.getDouble("percent");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return percent;
    };

    public ElectionResult findWinner(){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getDBConnection();

        String sql = """
                    SELECT c.name as candidate_name , count(
                            CASE
                                WHEN v.vote_type = 'VALID' then v.vote_type
                                END
                                    ) as valid_vote_count
                    from candidate c
                             INNER JOIN public.vote v on c.id = v.candidate_id
                    group by c.name limit 1;
                """;
        ElectionResult winner = new ElectionResult();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                winner.setCandidateName(rs.getString("candidate_name"));
                winner.setValidVoteCount(rs.getInt("valid_vote_count"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return winner;
    };

}
