// student_course_pairs_1 = [
//   ["58", "Software Design"],
//   ["58", "Linear Algebra"],
//   ["94", "Art History"],
//   ["94", "Operating Systems"],
//   ["17", "Software Design"],
//   ["58", "Mechanics"],
//   ["58", "Economics"],
//   ["17", "Linear Algebra"],
//   ["17", "Political Science"],
//   ["94", "Economics"],
//   ["25", "Economics"],
// ]


// {
//   [58, 17]: ["Software Design", "Linear Algebra"]
//   [58, 94]: ["Economics"]
//   [58, 25]: ["Economics"]
//   [94, 25]: ["Economics"]
//   [17, 94]: []
//   [17, 25]: []
// }
import java.util.*;
public class MyClass {
    public static void findPairs(String[][] studentCourse){
  Map<String, Set<String> > studentMap = new HashMap<>();

  for(String[] student : studentCourse){
    Set<String> courses = studentMap.getOrDefault(student[0], new HashSet<>());
    courses.add(student[1]);
    studentMap.put(student[0], courses);
  }

  String[] keys = studentMap.keySet().toArray(new String[studentMap.size()]);
  for(int i = 0; i < studentMap.size()-1; i++){
    
    for( int j = i+1; j < studentMap.size(); j++){
      Set<String> course1 = new HashSet<>(studentMap.get(keys[i]));
      Set<String> course2= new HashSet<>(studentMap.get(keys[j]));
      course1.retainAll(course2);
      System.out.println("["+keys[i]+", "+ keys[j]+"]: ["+course1+"]");
    }
  }
}
        
    public static void main(String args[]) {
      String[][] studentCourse = {
 {"58", "Software Design"},
  {"58", "Linear Algebra"},
  {"94", "Art History"},
  {"94", "Operating Systems"},
  {"17", "Software Design"},
  {"58", "Mechanics"},
  {"58", "Economics"},
  {"17", "Linear Algebra"},
  {"17", "Political Science"},
  {"94", "Economics"},
  {"25", "Economics"}
};
    
    findPairs(studentCourse);
     
    }
}
