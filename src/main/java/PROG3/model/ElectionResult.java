package PROG3.model;

public class ElectionResult {
    private String candidateName;
    private Integer validVoteCount;

    public ElectionResult() {}

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
        return "ElectionResult{" +
                "candidateName='" + candidateName + '\'' +
                ", validVoteCount=" + validVoteCount +
                '}';
    }
}
