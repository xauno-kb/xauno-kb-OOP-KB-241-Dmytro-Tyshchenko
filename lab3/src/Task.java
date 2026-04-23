import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        UserStory login = new UserStory(1, "Registration", 10, null);
        login.complete();

        Bug bug = Bug.createBug(2, "Fix Button", 5, login);

        Sprint sprint = new Sprint(30, 5);
        sprint.addUserStory(login);
        sprint.addBug(bug);

        for (Ticket t : sprint.getTickets()) {
            System.out.println(t.toString());
        }
        System.out.println("Total Estimate: " + sprint.getTotalEstimate());
    }
}

class Ticket {
    private int id;
    private String name;
    private int estimate;
    private boolean completed;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }
}

class UserStory extends Ticket {
    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory[] dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies;
    }

    @Override
    public void complete() {
        boolean canComplete = true;
        if (dependencies != null) {
            for (UserStory dep : dependencies) {
                if (!dep.isCompleted()) {
                    canComplete = false;
                    break;
                }
            }
        }
        if (canComplete) {
            super.complete();
        }
    }

    public UserStory[] getDependencies() {
        if (dependencies == null) {
            return new UserStory[0];
        }
        return Arrays.copyOf(dependencies, dependencies.length);
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}

class Bug extends Ticket {
    private UserStory userStory;

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }
}

class Sprint {
    private int capacity;
    private int limit;
    private Ticket[] tickets;
    private int ticketCount;

    public Sprint(int capacity, int limit) {
        this.capacity = capacity;
        this.limit = limit;
        this.tickets = new Ticket[limit];
        this.ticketCount = 0;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted()) {
            return false;
        }
        return addTicket(userStory);
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()) {
            return false;
        }
        return addTicket(bugReport);
    }

    private boolean addTicket(Ticket ticket) {
        if (ticketCount >= limit) {
            return false;
        }
        if (getTotalEstimate() + ticket.getEstimate() > capacity) {
            return false;
        }
        tickets[ticketCount] = ticket;
        ticketCount++;
        return true;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, ticketCount);
    }

    public int getTotalEstimate() {
        int total = 0;
        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getEstimate();
        }
        return total;
    }
}