import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeqiaozhu.
 * @date 12/15/20
 */
public class Study {
    public static void main(String[] args) {
        Map<Extend,Integer> hash= new HashMap<>(16);
        Extend key=Extend.builder().barCode("aaaaa").customerId(0).build();
        hash.put(key,1);
        Extend key2=Extend.builder().barCode("aaaaa").customerId(0).build();
        System.out.println(hash.containsKey(key2));
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Extend{
        private int customerId;
        private String barCode;
    }
}
