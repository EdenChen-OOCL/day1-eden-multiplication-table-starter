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
        StringBuilder tableString = new StringBuilder();
        for(int rowNumber = 1; rowNumber <= rowSum; rowNumber++) {
            Integer columnSum = columnSumEachRow.get(rowNumber - 1);
            tableString.append(generateLineString(start, rowNumber + start - 1, columnSum));
            if (rowNumber < end) {
                tableString.append(System.lineSeparator());
            }
        }
        return tableString.toString();
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

    private String generateLineString(int startColumn, int rowNumber, int columnSum) {
        StringBuilder lineString = new StringBuilder();
        int currentColumn = startColumn;
        for(int expressionCount = 0; expressionCount < (columnSum); expressionCount++, currentColumn++) {
            lineString.append(generateExpression(currentColumn, rowNumber));
            if (expressionCount < columnSum -1) {
                lineString.append(" ");
            }
        }
        return lineString.toString();
    }

    private String generateExpression(int start, int end) {
        return String.format("%d*%d=%d", start, end, start * end);
    }
}
