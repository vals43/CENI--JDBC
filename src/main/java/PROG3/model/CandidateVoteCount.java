package PROG3.model;

public class CandidateVoteCount {
    private String candidateName;
    private Integer validVoteCount;

    public CandidateVoteCount() {
    }

    public String candidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Integer validVoteCount() {
        return validVoteCount;
    }

    public void setValidVoteCount(Integer validVoteCount) {
        this.validVoteCount = validVoteCount;
    }

    @Override
    public String toString() {
        return  candidateName + " = " + validVoteCount ;
    }
}
