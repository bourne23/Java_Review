package ObjectExamples;

public class TeamDemo {

    public static void main(String[] args) {

        BasketballPlayer basketballPlayer = new BasketballPlayer("Lebron");
        BaseballPlayer baseballPlayer = new BaseballPlayer("Tiger");
        SoccerPlayer soccerPlayer = new SoccerPlayer("Messi");
//        Team team = new Team("MyTeam");

        Team <SoccerPlayer> team = new Team<>("SoccerTeam");

//        team.addPlayer(baseballPlayer);
//        team.addPlayer(basketballPlayer);
        team.addPlayer(soccerPlayer);

        System.out.println("Team " + team.getName() + " has " + team.getTeamSize() + " players");

    }
}
