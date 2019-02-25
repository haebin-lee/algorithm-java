package programmers.hash;

import java.util.Arrays;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * */
public class PrefixPhoneNumber {
	
	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		for (String number : phone_book) {
			for (String iter : phone_book) {
				if (!iter.equals(number) && iter.length() >= number.length() && iter.substring(0, number.length()).equals(number)) {
					return false;
					
				}
			}
		}
		return true;
	}

	// 다른사람 풀이
	public boolean solution2(String[] phoneBook) {
		for (int i = 0; i < phoneBook.length - 1; i++) {
			for (int j = i + 1; j < phoneBook.length; j++) {
				if (phoneBook[i].startsWith(phoneBook[j])) {
					return false;
				}
				if (phoneBook[j].startsWith(phoneBook[i])) {
					return false;
				}
			}
		}
		return true;
	}

	// 다른사람 풀이
	public boolean solution3(String[] phoneBook) {
		Arrays.sort(phoneBook);
		boolean result = true;
		for (int i = 0; i < phoneBook.length - 1; i++) {
			if (phoneBook[i + 1].contains(phoneBook[i])) {
				result = false;
				break;
			}
		}
		return result;
	}
}
