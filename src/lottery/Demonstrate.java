package lottery;

import java.util.ArrayList;
import java.util.List;

public class Demonstrate {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        Lottery lottery = new LotteryImplementation();
        tickets.add(lottery.sellTicket("joe"));
        tickets.add(lottery.sellTicket("ann"));
        tickets.add(lottery.sellTicket("peter"));
        int winner = lottery.winner();
        System.out.println("ticket with lucky number - " + winner);
        for (Ticket ticket : tickets) {
            if (winner == ticket.getId()) {
                System.out.println("congrats to " + ticket.getName());
            }
        }
    }
}
