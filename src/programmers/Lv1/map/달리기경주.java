package programmers.Lv1.map;

import java.util.HashMap;
import java.util.Map;

// 달리기 경주, Programmers(Level 1)
public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String nowCallPlayer = callings[i];

            int prize = playersMap.get(nowCallPlayer);

            if (prize > 0) {
                String frontPlayer = players[prize - 1];

                players[prize - 1] = nowCallPlayer;
                players[prize] = frontPlayer;

                playersMap.put(nowCallPlayer, prize - 1);
                playersMap.put(frontPlayer, prize);
            }
        }
        return players;
    }
}
