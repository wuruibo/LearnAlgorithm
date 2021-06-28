package Heap.P692;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> wordsMap = Arrays.stream(words).collect(Collectors.groupingBy(String::toString,Collectors.counting()));
        PriorityQueue<String> priorityQueue= new PriorityQueue<>((word1,word2)->{
            Long count1=wordsMap.getOrDefault(word1,0L);
            Long count2=wordsMap.getOrDefault(word2,0L);
            return count1.equals(count2)?word2.compareTo(word1):count1.compareTo(count2);
        });

        wordsMap.forEach((word,count)->{
            priorityQueue.offer(word);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        });
        List<String> result = new ArrayList<>();
        while(priorityQueue.size() > 0){
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        String[] words={"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        new Solution().topKFrequent(words,5);

        Integer[] array={2,1,3};
        Arrays.sort(array, (a,b)->b-a);
    }
}