package Exams.E22Feb2020.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }


    public void addPlayer(Player player){
        if (capacity > roster.size()){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : roster){
            if (player.getName().equals(name)){
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : roster){
            if (player.getName().equals(name)){
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster){
            if (player.getName().equals(name)){
                if (!player.getRank().equals("Trial")){
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> removedPlayers = new ArrayList<>();
        for (Player player : roster){
            if (player.getClazz().equals(clazz)){
               removedPlayers.add(player);
               //roster.remove(player);
            }
        }

        roster = roster.stream().filter(p ->!p.getClazz().equals(clazz)).collect(Collectors.toList());
        Player[] removedP = new Player[removedPlayers.size()];
        for (int i = 0; i < removedPlayers.size(); i++) {
                removedP[i] = removedPlayers.get(i);
        }

        return removedP;
    }

    public int count(){
        return roster.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:", name)).append(System.lineSeparator());
        roster.forEach(p -> builder.append(p).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
