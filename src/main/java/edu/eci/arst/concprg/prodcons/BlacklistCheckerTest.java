package edu.eci.arst.concprg.prodcons;

import java.util.ArrayList;
import java.util.List;

public class BlacklistCheckerTest {

    public static void main(String[] args) {
        List<Integer> blackListServers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            blackListServers.add(i);
        }

        List<Integer> blackListOccurrences = List.of(2, 5, 8, 12, 20, 25, 30);

        BlacklistChecker checker = new BlacklistChecker(blackListOccurrences);

        String host = "malicious.host.com";
        boolean isReliable = checker.isHostReliable(host, blackListServers);

        if (!isReliable) {
            System.out.println("El host " + host + " es no confiable.");
        } else {
            System.out.println("El host " + host + " es confiable.");
        }

        blackListOccurrences = List.of(2, 5);
        checker = new BlacklistChecker(blackListOccurrences);
        isReliable = checker.isHostReliable(host, blackListServers);


        if (!isReliable) {
            System.out.println("El host " + host + " es no confiable.");
        } else {
            System.out.println("El host " + host + " es confiable.");
        }
    }
}