package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Meeting {
	public int start;
	public int end;
	public Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class p1931 {
	/**
	 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다. 
	 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 
	 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
	 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
	 * */
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		
		int num = keyboard.nextInt();
		
		Meeting [] meetings = new Meeting[num];
		for(int i= 0 ; i<num ; i++){
			meetings[i] = new Meeting(keyboard.nextInt(), keyboard.nextInt());
		}
		
		Arrays.sort(meetings, new Comparator<Meeting>(){
			@Override
			public int compare(Meeting o1, Meeting o2) {
				int ret = o1.end-o2.end;
				if(o1.end == o2.end){
					ret = o1.start - o2.start;
				}
				return ret;
			}
		
		});
		
		int endTime = 0;
		int count = 0 ; 
		
		for(int i = 0 ; i< meetings.length ; i++){
			if(endTime<=meetings[i].start){
				count++;
				endTime = meetings[i].end;
			}
		}
		System.out.println(count);
	}
}
