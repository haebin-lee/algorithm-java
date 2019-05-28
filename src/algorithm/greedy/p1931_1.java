package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1931
 * */
class MeetingRoom{
	public int start; 
	public int end; 
	public MeetingRoom(int start, int end){
		this.start = start; 
		this.end = end;
	}
}
public class p1931_1 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<MeetingRoom> meeting = new ArrayList<>();
		for(int i=0; i<n ; i++){
			meeting.add(new MeetingRoom(sc.nextInt(), sc.nextInt()));
		}
		
		meeting.sort(new Comparator<MeetingRoom>(){
			@Override
			public int compare(MeetingRoom o1, MeetingRoom o2) {
				int ret = -(o2.end - o1.end);
				if(ret == 0){
					ret = -(o2.start - o1.start);
				}
				return ret;
			}
		});
		
		int now = 0; 
		int ans = 0;
		for(int i=0; i<meeting.size() ; i++){
			MeetingRoom v = meeting.get(i);
			if(v.start>=now){
				now = v.end;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
