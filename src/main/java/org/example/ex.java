package org.example;
import java.util.*;

public class ex {
    public static class NumericalBlockIterator implements Iterator<List<Integer>> {
        Iterator<Integer> inputIterator;
        Integer blockLimit;
        List<Integer> temp;
        List<Integer> block;
        int sum;
        public NumericalBlockIterator(Iterator<Integer> inputIterator, Integer blockLimit) {
            this.inputIterator = inputIterator;
            this.blockLimit = blockLimit;
            temp = new ArrayList<>();
            block = new ArrayList<>();
            temp = new ArrayList<>();
            sum =0;
        }

        /**
         * If this iterator has more elements in it, return true without advancing
         * the internal iterator pointer.
         * Otherwise return false.
         */
        @Override
        public boolean hasNext() {
            int current = 0 ;
            if(block.size() > 0)
            {
                System.out.println("Duplciate hasnext");
                for(Integer x: block)
                    System.out.print(x+",");
                System.out.println("");
                return true;
            }

            System.out.println("In the hasnext block");
            if(inputIterator.hasNext() == false)
                return false;

            while(inputIterator.hasNext())
            {
                current = inputIterator.next();
                if(current<=blockLimit)
                {
                    temp.add(current);
                    block.add(current);
                    sum+= current;
                    break;
                }
            }

            if(inputIterator.hasNext() == false)
                return false;

            System.out.println("\n\n");
            while(sum <= blockLimit && inputIterator.hasNext())
            {

                int val = inputIterator.next();

                System.out.println("val is "+ val);
                System.out.println("sum is "+ sum);

                if(sum+val<=blockLimit)
                {
                    temp.add(val);
                    block.add(val);
                    sum += val;
                }
                else
                {
                    block.clear();
                    block = new ArrayList<>(temp);

                    for(Integer x: block)
                        System.out.print(x+",");
                    System.out.println("");


                    temp.clear();
                    sum=0;
                    if(val <= blockLimit)
                    {
                        temp.add(val);
                        block.add(val);
                        sum = val;
                    }
                    break;
                }
            }

            if(inputIterator.hasNext() == false)
                return false;

            return true;
        }

        /**
         * Return the next block. If no more block exists, throw
         * {@link java.util.NoSuchElementException}.
         */
        @Override
        public List<Integer> next() {

            System.out.println("Start");
            if(hasNext()){
                System.out.println("End\n\n");

                List<Integer> ans = new ArrayList<>(block);
                block.clear();
                return ans;
            }

            return null;
            // throw NoSuchElementException;
        }
    }



















    // Template code - DO NOT EDIT

    private static final Boolean HAS_NEXT = false;
    private static final Boolean NEXT = true;
    private static final String NO_SUCH_ELEMENT_EXCEPTION = "NoSuchElementException";
    private static final String TRUE = Boolean.TRUE.toString();
    private static final String FALSE = Boolean.FALSE.toString();

    public static class TestIterator implements Iterator<Integer> {
        private final List<Integer> loopArray;
        private Iterator<Integer> iterator;

        public TestIterator(List<Integer> fixedArray, List<Integer> loopArray) {
            iterator = fixedArray.isEmpty() ? loopArray.iterator() : fixedArray.iterator();
            this.loopArray = loopArray;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Integer next() {
            int ret = iterator.next();
            if (!iterator.hasNext())
                iterator = loopArray.iterator();
            return ret;
        }
    }

    private static class TestCase {
        public final List<Integer> fixedArray;
        public final List<Integer> loopingArray;
        public final int blockLimit;
        public final List<Boolean> commands;
        public final List<String> output;

        public TestCase(List<Integer> fixedArray, List<Integer> loopingArray, Integer blockLimit, List<Boolean> commands, List<String> output) {
            this.fixedArray = fixedArray;
            this.loopingArray = loopingArray;
            this.blockLimit = blockLimit;
            this.commands = commands;
            this.output = output;
        }

        public void printInput() {
            String inputArray = "";
            if (!fixedArray.isEmpty()) {
                inputArray += printIntArray(fixedArray);
            }
            if (!loopingArray.isEmpty()) {
                if (!inputArray.isEmpty()) {
                    inputArray += ", ";
                }
                inputArray += "(";
                inputArray += printIntArray(loopingArray);
                inputArray += ")*";
            }
            System.out.println(
                    "\nInput: " +
                            inputArray +
                            "\nblockLimit: " +
                            blockLimit +
                            "\nCommands applied: " +
                            String.join(", ", commands.stream().map(r -> r ? "next" : "hasNext").toList()));
        }

        public void printOutput(List<String> outputs) {
            for(String output : outputs) {
                System.out.println(output);
            }
        }
    }

    private static String printIntArray(List<Integer> array) {
        return String.join(", ", array.stream().map(Object::toString).toList());
    }

    private static boolean runCase(TestCase testCase) {

        NumericalBlockIterator numericalBlockIterator = new NumericalBlockIterator(
                new TestIterator(testCase.fixedArray, testCase.loopingArray), testCase.blockLimit);
        List<String> expectedOutputs = testCase.output;
        List<String> actualOutputs = new ArrayList<>();

        List<Boolean> commands = testCase.commands;
        for (Boolean command : commands) {
            String output;
            try {
                if (command) {
                    output = "[" + printIntArray(numericalBlockIterator.next()) + "]";
                } else {
                    output = Boolean.valueOf(numericalBlockIterator.hasNext()).toString();
                }
            } catch (NoSuchElementException nsee) {
                output = NO_SUCH_ELEMENT_EXCEPTION;
            }
            actualOutputs.add(output);
        }

        if (actualOutputs.equals(expectedOutputs)) {
            return true;
        }

        System.out.println("___________________");
        System.out.print("FAILED TEST CASE: ");
        testCase.printInput();
        System.out.println("\nExpected: ");
        testCase.printOutput(expectedOutputs);
        System.out.println("\nFound: ");
        testCase.printOutput(actualOutputs);
        System.out.println("___________________");
        return false;
    }

    public static void main(String[] args) {
        List<TestCase> testCases = getTestCases();
        List<TestCase> passed = new ArrayList<>();

        testCases.forEach(testCase -> {
            if (runCase(testCase)) {
                passed.add(testCase);
            }
        });
        System.out.printf("\n\n%d/%d test cases passed\n\n\n", passed.size(), testCases.size());
    }

    private static List<TestCase> getTestCases() {
        return List.of(
                new TestCase(
                        List.of(5, 1, 2, 1, -1, 0, 1, 10, 4, 1, 2),
                        List.of(),
                        4,
                        List.of(HAS_NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, HAS_NEXT),
                        List.of(TRUE, TRUE, "[1, 2, 1, -1, 0, 1]", "[4]", TRUE, "[1, 2]", NO_SUCH_ELEMENT_EXCEPTION, FALSE, FALSE)),
                new TestCase(
                        List.of(1),
                        List.of(),
                        0,
                        List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                        List.of(FALSE, NO_SUCH_ELEMENT_EXCEPTION, NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
                new TestCase(
                        List.of(0),
                        List.of(),
                        0,
                        List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                        List.of(TRUE, "[0]", NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
                new TestCase(
                        List.of(100, 100, 100, 100, 100, 1),
                        List.of(),
                        1,
                        List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                        List.of(TRUE, "[1]", NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
                new TestCase(
                        List.of(1, 2, 4),
                        List.of(3, 5),
                        12,
                        List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, HAS_NEXT, HAS_NEXT, HAS_NEXT),
                        List.of(TRUE, "[1, 2, 4, 3]", "[5, 3]", TRUE, "[5, 3]", "[5, 3]", TRUE, TRUE, TRUE, TRUE)),
                new TestCase(
                        List.of(),
                        List.of(1),
                        11,
                        List.of(HAS_NEXT,
                                NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                                HAS_NEXT,
                                NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                                NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                                NEXT, NEXT,
                                HAS_NEXT),
                        List.of(TRUE,
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                TRUE,
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                                TRUE))
        );
    }
}