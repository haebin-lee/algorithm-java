package programmers.hash;

import java.util.HashMap;

public class Players {

	public static void main(String[] args) {
		String[] participant = new String[] { "mislav", "stanko", "mislav", "ana" };
		String[] completion = new String[] { "stanko", "ana", "mislav" };

		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> members = new HashMap<>();
		for (String member : completion) {
			members.put(member, members.containsKey(member) ? members.get(member) + 1 : 1);
		}
		for (String member : participant) {
			if (members.containsKey(member)) {
				if (members.get(member) == 1)
					members.remove(member);
				else
					members.put(member, members.get(member) - 1);
			} else {
				return member;
			}
		}
		return answer;
	}

	// 다른 사람 풀이
	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
}
