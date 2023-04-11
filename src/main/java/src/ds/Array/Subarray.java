package src.ds.Array;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.*;

public class Subarray {
    // Represent subarray by starting and ending indices, inclusive.
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
        this.start=start;
        this.end=end;
    }

    public static Subarray findSmallestSequentiallyCoveringSubset(
            List<String> paragraph, List<String> keywords) {
// Maps each keyword to its index in the keywords array.
        Map<String, Integer> keywordToIdx=new HashMap<>();
// Since keywords are uniquely identified by their indices in keywords
// array, we can use those indices as keys to lookup in a vector.
        List<Integer> latestOccurrence=new ArrayList<>(keywords.size());
// For each keyword (identified by its index in keywords array), stores the
// length of the shortest subarray ending at the most recent occurrence of
// that keyword that sequentially cover all keywords up to that keyword.
        List<Integer> shortestSubarrayLength=new ArrayList<>(keywords.size());
// Initializes latestOccurrence , shortestSubarrayLength , and keywordToIdx.
        for (int i=0; i<keywords.size(); ++i) {
            latestOccurrence.add(-1);
            shortestSubarrayLength.add(Integer.MAX_VALUE);
            keywordToIdx.put(keywords.get(i), i);
        }
        int shortestDistance=Integer.MAX_VALUE;
        Subarray result=new Subarray(-1, -1);
        for (int i=0; i<paragraph.size(); ++i) {
            Integer keywordldx=keywordToIdx.get(paragraph.get(i));
            if (keywordldx!=null) {
                if (keywordldx==0) { // First keyword.
                    shortestSubarrayLength.set(0, 1);
                } else if (shortestSubarrayLength.get(keywordldx-1)!=Integer.MAX_VALUE) {
                    int distanceToPreviousKeyword=i-latestOccurrence.get(keywordldx-1);
                    int shortestDistanceToPreviousKeyword=
                            shortestSubarrayLength.get(keywordldx-1);
                    shortestSubarrayLength.set(keywordldx, distanceToPreviousKeyword+
                            shortestDistanceToPreviousKeyword);
                }
                latestOccurrence.set(keywordldx, i);
// Last keyword, look for improving subarray.
                if (keywordldx==keywords.size()-1&&
                        shortestSubarrayLength.get(shortestSubarrayLength.size()-1)<
                                shortestDistance) {
                    shortestDistance=shortestSubarrayLength.get(shortestSubarrayLength.size()-1);
                    result.start=i-shortestDistance+1;
                    result.end=i;
                }
            }
        }
        return result;
    }

    public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
// Records the most recent occurrences of each entry.
        Map<Integer, Integer> mostRecentOccurrence=new HashMap<>();
        int longestDupFreeSubarrayStartldx=0, result=0;
        for (int i=0; i<A.size(); ++i) {
            Integer dupldx=mostRecentOccurrence.put(A.get(i), i);
// A.get(i) appeared before. Did it appear in the longest current
// subarray?
            if (dupldx!=null) {
                if (dupldx>=longestDupFreeSubarrayStartldx) {
                    result=Math.max(result, i-longestDupFreeSubarrayStartldx);
                    longestDupFreeSubarrayStartldx=dupldx+1;
                }
            }
        }
        result=Math.max(result, A.size()-longestDupFreeSubarrayStartldx);
        return result;
    }

    public Subarray longestContainedRange(List<Integer> A) {
        Map<Integer, Boolean> isPresent=new HashMap<>();
        for (Integer a : A) {
            isPresent.put(a, false);
        }
        int longestRangeStart=0, longestRangeLength=0;
        for (Integer a : A) {
            if (isPresent.get(a)) {
                continue;
            }
            isPresent.put(a, true);
            int leftldx=a-1, rightldx=a+1;
            while (isPresent.containsKey(leftldx)) {
                isPresent.put(leftldx, true);
                --leftldx;
            }
            while (isPresent.containsKey(rightldx)) {
                isPresent.put(rightldx, true);
                ++rightldx;
            }
            if (longestRangeLength<rightldx-leftldx-1) {
                longestRangeLength=rightldx-leftldx-1;
                longestRangeStart=leftldx+1;
            }
        }
        return new Subarray(longestRangeStart, longestRangeStart+longestRangeLength-1);
    }

    public String findStudentWithHighestBestOfThreeScores(Iterator<Object> nameScoreData) {
        Map<String, PriorityQueue<Integer>> studentScores=new HashMap<>();
        while (nameScoreData.hasNext()) {
            String name=(String) nameScoreData.next();
            int score=(Integer) nameScoreData.next();
            if (!studentScores.containsKey(name)) {
                studentScores.put(name, new PriorityQueue<>(3));
            }
            PriorityQueue<Integer> scores=studentScores.get(name);
            scores.add(score);
            if (scores.size()>3) {
                scores.poll();
            }
        }
        String topStudent="";
        double topAverage=0.0;
        for (Map.Entry<String, PriorityQueue<Integer>> studentScore : studentScores.entrySet()) {
            String student=studentScore.getKey();
            PriorityQueue<Integer> scores=studentScore.getValue();
            double average=(scores.poll()+scores.poll()+scores.poll())/3.0;
            if (average>topAverage) {
                topAverage=average;
                topStudent=student;
            }
        }
        return topStudent;
    }

    public List<Integer> findAllSubstrings(String s, List<String> words) {
        List<Integer> result=new ArrayList<>();
        if (words.isEmpty()) {
            return result;
        }
        Map<String, Integer> wordCount=new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        int numWords=words.size();
        int wordLen=words.get(0).length();
        for (int i=0; i+numWords*wordLen<=s.length(); i++) {
            Map<String, Integer> currCount=new HashMap<>();
            int j;
            for (j=0; j<numWords; j++) {
                String word=s.substring(i+j*wordLen, i+j*wordLen+wordLen);
                if (!wordCount.containsKey(word)) {
                    break;
                }
                currCount.put(word, currCount.getOrDefault(word, 0)+1);
                if (currCount.get(word)>wordCount.get(word)) {
                    break;
                }
            }
            if (j==numWords) {
                result.add(i);
            }
        }
        return result;
    }
}
