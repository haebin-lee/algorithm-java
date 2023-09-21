package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSystem {

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        List<List<String>> fileSystems = findDuplicate(paths);
        System.out.println(fileSystems.toString());

        String[] paths2 = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};
        List<List<String>> fileSystems2 = findDuplicate(paths2);
        System.out.println(fileSystems2.toString());
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> duplicates = new HashMap<>(); // (content, directory/filename)
        for (String path: paths) {
            String[] temp = path.split(" ");
            for (int i = 1; i < temp.length; i++) {
                int idx = temp[i].indexOf("(");
                String content = temp[i].substring(idx + 1, temp[i].length() - 1);
                String filepath = temp[0] + "/" +temp[i].substring(0, idx);
                duplicates.putIfAbsent(content, new ArrayList<>());
                duplicates.get(content).add(filepath);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : duplicates.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }
        return result;
    }
}
