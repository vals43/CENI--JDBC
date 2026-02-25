package PROG3.model;

public class VoteSummary {
    private Integer validCount ;
    private Integer blankCount ;
    private Integer nullCount ;

    public VoteSummary() {}

    public Integer validCount() {
        return validCount;
    }

    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }

    public Integer blankCount() {
        return blankCount;
    }

    public void setBlankCount(Integer blankCount) {
        this.blankCount = blankCount;
    }

    public Integer nullCount() {
        return nullCount;
    }

    public void setNullCount(Integer nullCount) {
        this.nullCount = nullCount;
    }

    @Override
    public String toString() {
        return "VoteSummary{" +
                "validCount=" + validCount +
                ", blankCount=" + blankCount +
                ", nullCount=" + nullCount +
                '}';
    }
}
