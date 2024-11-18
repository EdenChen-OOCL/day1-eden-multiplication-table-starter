package com.tw;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTableBuilder {

    public static void main(String[] args) {
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 4;
        String multiplicationTable = builder.generateMultiplicationTable(start, end);

        System.out.println(multiplicationTable);
    }

    public String generateMultiplicationTable(int start, int end) {
        if (!validateStartAndEnd(start, end)) {
            return null;
        }
        int rowSum = calculateRowSum(start, end);
        List<Integer> columnSumEachRow = calculateColumnSumEachRow(rowSum);

        return "";
    }

    private Boolean validateStartAndEnd(int start, int end) {
        boolean isStartLessThanEnd = start <= end;
        boolean isInRange = start > 1 && start <= 1000 && end > 1 && end <= 1000;
        return isInRange && isStartLessThanEnd;
    }

    private int calculateRowSum(int start, int end) {
        return end - start + 1;
    }

    private List<Integer> calculateColumnSumEachRow(int rowSum) {
        List<Integer> columnSumEachRow = new ArrayList<>();
        for(int start = 1; start <= rowSum; start++) {
            columnSumEachRow.add(start);
        }
        return columnSumEachRow;
    }
}
