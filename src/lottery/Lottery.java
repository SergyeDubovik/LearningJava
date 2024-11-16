package lottery;

public interface Lottery {

    Ticket sellTicket(String buyer);

    int winner();
}
