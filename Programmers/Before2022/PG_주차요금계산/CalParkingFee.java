package Jan2022;

import java.util.*;

public class CalParkingFee {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                        solution(
                                new int[]{180, 5000, 10, 600},
                                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
                        )));
    }

    private static int[] solution(int[] fees, String[] records) {
        Set<String> parkedCar = new HashSet<>();
        Map<String, Car> cars = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String record : records) {
            String[] r = record.split(" ");
            if (r[2].equals("IN")) {
                Car c = cars.getOrDefault(r[1], new Car());
                c.setInTime(r[0]);
                cars.put(r[1], c);
                parkedCar.add(r[1]);
            } else {
                cars.get(r[1]).calculateTime(r[0], fees);
                parkedCar.remove(r[1]);
            }
        }

        for (String car : parkedCar) {
            cars.get(car).calculateTime("23:59", fees);
        }

        int[] answer = new int[cars.size()];
        int i = 0;
        for (Car car : cars.values()) {
            answer[i] = calculateParkingFee(car.parkingTime, fees);
            i++;
        }

        return answer;
    }

    private static int calculateParkingFee(int parkingTime, int[] fees) {
        if (parkingTime <= fees[0]) {
            return fees[1];
        } else {
            if ((parkingTime - fees[0]) % fees[2] != 0) {
                return fees[1] + ((((parkingTime - fees[0]) / fees[2]) + 1) * fees[3]);
            } else {
                return fees[1] + (((parkingTime - fees[0]) / fees[2]) * fees[3]);
            }
        }
    }

    private static class Car {
        private String inTime = "";
        private int parkingTime = 0;

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public void calculateTime(String outTime, int[] fees) {
            String[] in = inTime.split(":");
            String[] out = outTime.split(":");

            int min = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
            int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
            if (min < 0) {
                min += 60;
                hour -= 1;
            }

            parkingTime += (hour * 60) + min;
        }
    }
}
