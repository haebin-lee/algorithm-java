package kakao.q2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {
	
	
	public static void main(String[] args){
		
		String [] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		solution(input);
		
	}
	
	public static String[] solution(String[] record) {
		HashMap<String, String> users = new HashMap<>(); 
		for(String item: record){
			String [] command = item.split(" ");
			String order = command[0];
			if("Enter".equals(order) || "Change".equals(order)){
				String id = command[1];
				String nickname = command[2];
				
				users.put(id, nickname);
			}
		}

		List<String> list = new ArrayList<>();
		for(String item: record){
			String [] command = item.split(" ");
			String order= command[0];
			String id = command[1];
			
			String nickname = users.get(id);
			
			switch (order){
			case "Enter":
				list.add(nickname+"님이 들어왔습니다.");
				break;
			case "Leave":
				list.add(nickname+"님이 나갔습니다.");
				break;
			}
		}
				
		String [] answer = list.stream().toArray(String[]::new);
        return answer;
    }
}
