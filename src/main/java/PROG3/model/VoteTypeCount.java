package PROG3.model;

public class VoteTypeCount {
    private VoteTypeEnum voteType;
    private Integer count;

    public VoteTypeCount() {}

    public VoteTypeEnum voteType() {
        return voteType;
    }

    public void setVoteType(VoteTypeEnum voteType) {
        this.voteType = voteType;
    }

    public Integer count() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "VoteTypeCount{" +
                "voteType=" + voteType +
                ", count=" + count +
                '}';
    }
}
