package PROG3;


import PROG3.service.DataRetriever;

public class Main {
    public static void main(String[] args) {
        DataRetriever dr = new DataRetriever();
        System.out.println(dr.countVotesByType());
    }
}
