package Mar2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ThatSongJustNow {
    public static void main(String[] args) {
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    private static String solution(String m, String[] musicinfos) {

        List<String> notes = makeNote(m);
        StringBuilder sb = new StringBuilder();
        notes.forEach(str -> sb.append(str).append(","));
        m = sb.toString();

        List<Music> thatMusic = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            Music music = new Music(i, musicinfos[i]);
            if (music.playedNote.contains(m)) {
                thatMusic.add(music);
            }
        }

        Collections.sort(thatMusic);

        return thatMusic.isEmpty() ? "(None)" : thatMusic.get(0).title;
    }

    public static List<String> makeNote(String note) {
        List<String> notes = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (Character n : note.toCharArray()) {
            if (n == '#') {
                notes.add(stack.pop() + "#");
            } else {
                if (!stack.isEmpty()) {
                    notes.add(String.valueOf(stack.pop()));
                }

                stack.push(n);
            }
        }

        if (!stack.isEmpty()) notes.add(String.valueOf(stack.pop()));

        return notes;
    }

    private static class Music implements Comparable<Music> {
        private int order;
        private int playTime;
        private String title;
        private String playedNote;

        public Music(int order, String info) {
            this.order = order;
            String[] infos = info.split(",");
            setPlayTime(infos[0], infos[1]);
            this.title = infos[2];
            setPlayedNote(infos[3]);
        }

        private void setPlayTime(String startTime, String endTime) {
            String[] startHM = startTime.split(":");
            String[] endHM = endTime.split(":");

            // 시간(분) 계산
            playTime = (Integer.parseInt(endHM[0]) * 60 + Integer.parseInt(endHM[1])) - (Integer.parseInt(startHM[0]) * 60 + Integer.parseInt(startHM[1]));
        }

        private void setPlayedNote(String note) {
            List<String> notes = makeNote(note);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                sb.append(notes.get(i % notes.size())).append(",");
            }

            playedNote = sb.toString();
        }

        @Override
        public int compareTo(Music o) {
            return this.playTime == o.playTime ? this.order - o.order: o.playTime - this.playTime;
        }
    }
}
