package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VersionComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        String[] v1 = s1.split("\\.");
        String[] v2 = s2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int cmp = Integer.compare(Integer.parseInt(v1[i]), Integer.parseInt(v2[i]));
            if (cmp != 0) {
                return cmp;
            }
            i++;
        }
        return Integer.compare(v1.length, v2.length);
    }
    public static void main(String[] args) {
        List<String> versionList = new ArrayList<>();
        versionList.add("6.1.0.1066");
        versionList.add("6.0");
        versionList.add("6.0.1");
        versionList.add("6.2");
        versionList.add("6.2.3");
        versionList.add("6.2.3.2");
        versionList.add("6.2.3.1");
        versionList.add("5.1.3");
        versionList.add("7.0.874");
        versionList.add("7");
        versionList.add("5.1.3.36");

        Collections.sort(versionList, new VersionComparator());
        System.out.println(versionList);
    }
}
