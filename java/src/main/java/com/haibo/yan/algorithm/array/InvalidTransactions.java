package com.haibo.yan.algorithm.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/invalid-transactions/
 */
public class InvalidTransactions {
    static class Transaction{
        int time = 0;

        int amount = 0;

        String name;

        Transaction(int time, int amount, String name) {
            this.time = time;
            this.amount = amount;
            this.name = name;
        }

        private boolean valid(List<Transaction> transactions) {
            if (amount > 1000) {
                return false;
            }
            for (Transaction transaction : transactions) {
                if (!transaction.name.equals(name) && Math.abs(transaction.time - time) <= 60) {
                    return false;
                }
            }
            return true;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String>> byNames =
                Arrays.stream(transactions).collect(Collectors.groupingBy(s -> s.split("[,]")[0]));
        List<String> invalids = new ArrayList<>();
        for (List<String> x : byNames.values()) {
            Map<String, Transaction> transactionMap = x.stream().collect(Collectors.toMap(Function.identity(),
                    s -> {
                        String[] splitted = s.split("[,]");
                        return new Transaction(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]), splitted[3]);
                    }));
            List<Transaction> transactionsPerName = new ArrayList<>(transactionMap.values());
            for (String k : transactionMap.keySet()) {
                Transaction transaction = transactionMap.get(k);
                if(!transaction.valid(transactionsPerName)) {
                    invalids.add(k);
                }
            }
        }

        return invalids;
    }
}
