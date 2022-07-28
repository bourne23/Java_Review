package ObjectExamples;

import java.util.ArrayList;

public class Team<T extends Player> {  //type checking for Player child classes only
    private String name;
    ArrayList<T> memberList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getTeamSize() {
        return this.memberList.size();
    }

    public void addPlayer(T player) {
        if (memberList.contains(player)) {
            System.out.println("Player " + player.getName() + " is already on a team");
        } else {
            memberList.add(player);
            System.out.println("Player " + (player).getName() + " was added to team " + this.name);
        }


    }


}
