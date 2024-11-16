package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HoldingLottery implements Lottery {
    protected List<String> ticket = new ArrayList<>();
    protected Random random = new Random();

    @Override
    public void sellTicket(String buyer) {
        ticket.add(buyer);
        System.out.println(buyer);
    }

    @Override
    public String winner() {
        int winnersIndex = random.nextInt(ticket.size());
        return ticket.get(winnersIndex);
    }

}
