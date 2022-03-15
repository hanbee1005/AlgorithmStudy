package Mar2022;

import java.util.*;

public class SortFileName {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}))
        );
    }

    private static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        Map<String, File> fileMap = new HashMap<>();

        for (int i = 0; i < files.length; i++) {
            int stage = 0;
            File newFile = new File(i);
            for (Character f : files[i].toCharArray()) {
                if (stage <= 1 && Character.isDigit(f)) {
                    newFile.add("number", f);
                    if (stage == 0) stage = 1;
                } else {
                    if (stage == 0) {
                        newFile.add("header", f);
                    } else if (stage == 1) {
                        stage = 2;
                    }
                }
            }

            fileMap.put(files[i], newFile);
        }

        // sort
        List<String> keySetList = new ArrayList<>(fileMap.keySet());
        keySetList.sort(Comparator.comparing(fileMap::get));

        int idx = 0;
        for (String key : keySetList) {
            answer[idx] = key;
            idx++;
        }

        return answer;
    }

    private static class File implements Comparable<File> {
        private StringBuilder header = new StringBuilder();
        private StringBuilder number = new StringBuilder();

        private int order;

        public File(int order) {
            this.order = order;
        }

        @Override
        public int compareTo(File o) {
            return compareHeader(o) == 0 ? (compareNumber(o) == 0 ? compareOrder(o) : compareNumber(o)) : compareHeader(o);
        }

        private int compareHeader(File file) {
            return header.toString().compareToIgnoreCase(file.header.toString());
        }

        private int compareNumber(File file) {
            return Integer.parseInt(number.toString()) - Integer.parseInt(file.number.toString());
        }

        private int compareOrder(File file) {
            return this.order - file.order;
        }

        public void add(String type, Character c) {
            switch (type) {
                case "header":
                    this.header.append(c);
                    break;
                case "number":
                    this.number.append(c);
                    break;
            }
        }
    }
}