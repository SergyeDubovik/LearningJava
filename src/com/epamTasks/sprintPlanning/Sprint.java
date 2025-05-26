package com.epamTasks.sprintPlanning;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private Ticket[] tickets;
    private int countTickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
        this.countTickets = 0;

    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null) {
            return false;
        }
        if (userStory.isCompleted()) {
            return false;
        }
        if (countTickets >= ticketsLimit) {
            return false;
        }
        if (getTotalEstimate() + userStory.getEstimate() > capacity) {
            return false;
        }
        for (UserStory dependency : userStory.getDependencies()) {
            boolean found = false;
            for (Ticket ticket : tickets) {
                if (ticket == dependency) {
                    found = true;
                    break;
                }
            }
            if (!found && !dependency.isCompleted()) {
                return false;
            }
        }
        tickets[countTickets++] = userStory;
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null) {
            return false;
        }
        if (bugReport.isCompleted()) {
            return false;
        }
        if (countTickets >= ticketsLimit) {
            return false;
        }
        if (getTotalEstimate() + bugReport.getEstimate() > capacity) {
            return false;
        }
        tickets[countTickets] = bugReport;
        countTickets++;
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] copied = new Ticket[countTickets];
        System.arraycopy(tickets, 0, copied, 0, countTickets);
        return copied;
    }

    public int getTotalEstimate() {
        int totalEst = 0;
        for (int i = 0; i < countTickets; i++) {
            totalEst += tickets[i].getEstimate();
        }
        return totalEst;
    }
}
