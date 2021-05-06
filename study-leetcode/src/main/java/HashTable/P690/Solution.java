package HashTable.P690;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for Employee.
@Data
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;


};


class Solution {
    private Integer sum=0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>(12);
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(),employee);
        }
        Employee employee=employeeMap.get(id);
        dfs(employee,employeeMap);
        return sum;
    }
    private void dfs(Employee employee,Map<Integer,Employee> employeeMap){
        if(employee.getSubordinates()==null){
            return;
        }
        sum+=employee.getImportance();
        for (Integer subordinate : employee.getSubordinates()) {
            Employee subEmployee = employeeMap.get(subordinate);
            dfs(subEmployee,employeeMap);
        }
    }

    public static void main(String[] args) {
        //new Solution().getImportance()
    }
}