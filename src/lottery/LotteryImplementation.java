package lottery;

import java.util.Random;

public class LotteryImplementation implements Lottery {
    private final Random random = new Random();
    private static int nextId = 1;

    @Override
    public Ticket sellTicket(String buyer) {
        Ticket ticket = new Ticket(nextId, buyer);
        nextId++;
        return ticket;
    }

    @Override
    public int winner() {
        return random.nextInt(1, nextId);
    }

}
