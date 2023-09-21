package algorithm.leetcode;

import javax.swing.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileSystem2 {

    public static void main(String[] args) {
        FileSystem2 s2 = new FileSystem2();
        System.out.println(s2.createPath("/leetcode", 1));
        System.out.println(s2.createPath("/leetcode/me", 2));
        System.out.println(s2.get("/leetcode/me"));

        System.exit(0);
    }
    private Map<String, Directory> directory;

    public FileSystem2() {
        directory = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        String[] paths = path.substring(1).split("/");
        Map<String, Directory> sub = directory;
        for (int i = 0 ; i < paths.length; i++) {
            Directory directory1 = sub.get(paths[i]);
            if (directory1 == null) {
                if(i == paths.length - 1) {
                    Directory created = new Directory(value, new HashMap<>());
                    sub.put(paths[i], created);
                    return true;
                }
                else return false;
            }
            sub = directory1.getSub();
        }
        return false;
    }
    public int get(String path){
        String[] paths = path.substring(1).split("/");
        Directory directory1 = null;
        Map<String, Directory> sub = directory;
        for (int i = 0 ; i < paths.length; i++) {
            directory1 = sub.get(paths[i]);
            if (directory1 == null) {
               return -1;
            }
            sub = directory1.getSub();
        }
        return directory1 != null ? directory1.getItem(): -1;
    }

    public static class Directory{
        private int item;
        private Map<String, Directory> sub;

        public Directory(int item, Map<String, Directory> sub) {
            this.item = item;
            this.sub = sub;
        }

        public int getItem() {
            return item;
        }

        public Map<String, Directory> getSub() {
            return sub;
        }
    }
}
