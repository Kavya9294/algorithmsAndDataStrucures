/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        
        for(List<Interval> interval: schedule){
            intervals.addAll(interval);
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval v1, Interval v2){
                if(v1.start == v2.start && v1.end == v2.end) return 0;
                return Integer.compare(v1.start, v2.start);
            }
        });
        
        List<Interval> nonOverlap = new ArrayList<>();
        int left = -1;
        int right = -1;
        for(Interval interval: intervals){
            if(left == -1){
                left = interval.start;
                right = interval.end;
            }else if(right >= interval.start){
                right = Math.max(right, interval.end);
            }else{
                Interval inter = new Interval(left, right);
                nonOverlap.add(inter);
                left = interval.start;
                right = interval.end;
            }
        }
        nonOverlap.add(new Interval(left,right));
        
        if(nonOverlap.size() == 0) return null;
        
        List<Interval> result = new ArrayList<>();
        for( int i=0;i<nonOverlap.size()-1;i++){
            result.add(new Interval(nonOverlap.get(i).end, nonOverlap.get(i+1).start));
        }
        
        
        return result;
        
    }
}