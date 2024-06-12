

class Station {
    String state;
    int time;

    Station(String state, int time) {
        this.state = state;
        this.time = time;
    }
}

class UndergroundSystem {
    HashMap<String, Integer> sum;
    HashMap<String, Integer> count;
    HashMap<Integer, Station> hstart;
    HashMap<Integer, Station> hend;

    public UndergroundSystem() {
        sum = new HashMap<>();
        count = new HashMap<>();
        hstart = new HashMap<>();
        hend = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Station etr = new Station(stationName, t);
        hstart.put(id, etr);
    }

    public void checkOut(int id, String stationName, int t) {
        Station etr = new Station(stationName, t);
        hend.put(id, etr);
        Station etr1 = hstart.get(id);
        Station etr2 = hend.get(id);
        String ele = etr1.state+","+etr2.state;
        sum.put(ele, sum.getOrDefault(ele, 0) + etr2.time - etr1.time);
        count.put(ele, count.getOrDefault(ele, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String ele = startStation+","+endStation;
        System.out.println(ele);
        int totalTime = sum.getOrDefault(ele, 0);
        int totalCount = count.getOrDefault(ele, 0);
        return (double) totalTime / totalCount;
    }
}
