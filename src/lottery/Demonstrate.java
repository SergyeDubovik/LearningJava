package lottery;

public class Demonstrate {
    public static void main(String[] args) {
        Lottery lottery = new LotteryImplementation();
        lottery.sellTicket("joe");
        lottery.sellTicket("kate");
        lottery.sellTicket("peter");
        System.out.println("winner is - " + lottery.winner());
    }
}
