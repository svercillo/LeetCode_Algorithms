/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int sum =0; 
    public Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) map.put(e.id, e);
        if (map.get(id) == null)return 0;
        
        sum = map.get(id).importance;
        traverse(map.get(id).subordinates);
        return sum;
    }
    public void traverse (List<Integer> list){
        for (int n : list){
            sum += map.get(n).importance;
            traverse(map.get(n).subordinates);
        }
    }
}
