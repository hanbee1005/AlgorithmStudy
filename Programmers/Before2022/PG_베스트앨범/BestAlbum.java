import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        int[] answer = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for (int a : answer) {
            System.out.println(a);
        }
    }

    private static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> playCountPerGenres = new LinkedHashMap<>();  // 장르별 재생 횟수 합
        Map<String, LinkedList<Song>> songsByGenres = new LinkedHashMap<>();  // 장르별 노래 리스트

        // 주어진 배열을 차례로 확인하면서
        for (int i = 0; i < genres.length; i++) {
            // 장르를 key로 하고 해당 장르의 노래 재생 횟수의 합을 값으로 하여 저장
            playCountPerGenres.put(genres[i], playCountPerGenres.getOrDefault(genres[i], 0) + plays[i]);

            // 장르를 key로 하고 해당 장르의 노래를 리스트로 저장
            Song song = new Song(i, plays[i]);
            LinkedList<Song> tmp = songsByGenres.getOrDefault(genres[i], new LinkedList<>());
            tmp.add(song);
            songsByGenres.put(genres[i], tmp);
        }

        // 재생 횟수를 기준으로 장르를 내림차순 정렬
        Map<String, Integer> sortedPlayCountPerGenres = sortByPlayCount(playCountPerGenres);

        // 가장 많이 재생된 장르별로 차례대로 확인하면서
        for (String key : sortedPlayCountPerGenres.keySet()) {
            // 해당 장르에 속한 노래 리스트를 재생 횟수가 많은 순으로 정렬하여 찾은 뒤
            List<Song> songs = sortByPlays(songsByGenres.get(key));
            // 장르별 최대 2개 노래의 고유 번호를 정답 리스트에 저장
            for (int i = 0; i < songs.size() && i < 2; i++) {
                answer.add(songs.get(i).num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    // 가장 많이 재생된 장르 순으로 정렬
    private static Map<String, Integer> sortByPlayCount(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    // 한 장르에서 가장 많이 재생된 노래 순으로 정렬
    private static List<Song> sortByPlays(List<Song> list) {
        list.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o2.plays - o1.plays;
            }
        });

        return list;
    }

    // 노래 객체
    private static class Song {
        private final int num;  // 고유 번호 (인덱스)
        private final int plays;  // 재생 횟수

        public Song(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }
    }
}
