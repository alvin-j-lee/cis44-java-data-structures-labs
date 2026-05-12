/**
 * Driver class for manually testing the Decision Engine.
 *
 * This file runs specific scenarios and prints PASS or FAIL to the console.
 * The output labels each test as a Normal Case, Empty Case, or Edge Case.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Capstone Project: Decision Engine Tests");
        System.out.println();

        testEmptyTreeLookup();

        testApprovedApplicant();
        testRejectedByCreditScore();
        testRejectedByIncome();
        testRejectedByDebtToIncomeRatio();
        testRejectedByEmploymentYears();

        testDuplicateApplicantId();
        testInvalidApplicantLookup();
        testExactThresholdValues();
    }

    /**
     * Helper method for printing test results.
     *
     * @param category type of test case: Normal Case, Empty Case, or Edge Case
     * @param testName name of the test being run
     * @param expected expected output
     * @param actual actual output
     * @param condition true if the test passed, false otherwise
     */
    private static void printResult(String category, String testName, String expected,
                                    String actual, boolean condition) {
        System.out.println("Case Type: " + category);
        System.out.println("Test: " + testName);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);

        if (condition) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println();
    }

    /**
     * EMPTY CASE:
     * Checks what happens when the BST has no applicants.
     */
    private static void testEmptyTreeLookup() {
        ApplicantBST bst = new ApplicantBST();

        Applicant result = bst.search(1001);

        printResult(
                "Empty Case",
                "Search in an empty ApplicantBST",
                "null",
                String.valueOf(result),
                result == null
        );
    }

    /**
     * NORMAL CASE:
     * Applicant passes all rules and should be approved.
     */
    private static void testApprovedApplicant() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1001, "Alice", 75000, 720, 0.30, 4);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1001);

        printResult(
                "Normal Case",
                "Applicant passes all loan approval rules",
                "Approved",
                result,
                result.equals("Approved")
        );
    }

    /**
     * NORMAL CASE:
     * Applicant is rejected because credit score is below the required threshold.
     */
    private static void testRejectedByCreditScore() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1002, "Bob", 80000, 600, 0.20, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1002);

        printResult(
                "Normal Case",
                "Applicant rejected due to low credit score",
                "Rejected",
                result,
                result.equals("Rejected")
        );
    }

    /**
     * NORMAL CASE:
     * Applicant is rejected because income is below the required threshold.
     */
    private static void testRejectedByIncome() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1003, "Charlie", 40000, 700, 0.20, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1003);

        printResult(
                "Normal Case",
                "Applicant rejected due to insufficient income",
                "Rejected",
                result,
                result.equals("Rejected")
        );
    }

    /**
     * NORMAL CASE:
     * Applicant is rejected because debt-to-income ratio is too high.
     */
    private static void testRejectedByDebtToIncomeRatio() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1004, "Diana", 70000, 720, 0.50, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1004);

        printResult(
                "Normal Case",
                "Applicant rejected due to high debt-to-income ratio",
                "Rejected",
                result,
                result.equals("Rejected")
        );
    }

    /**
     * NORMAL CASE:
     * Applicant is rejected because employment history is too short.
     */
    private static void testRejectedByEmploymentYears() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1005, "Ethan", 70000, 720, 0.30, 1);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1005);

        printResult(
                "Normal Case",
                "Applicant rejected due to short employment history",
                "Rejected",
                result,
                result.equals("Rejected")
        );
    }

    /**
     * EDGE CASE:
     * Checks how the BST handles duplicate applicant IDs.
     */
    private static void testDuplicateApplicantId() {
        ApplicantBST bst = new ApplicantBST();

        Applicant original = new Applicant(1006, "Original", 70000, 720, 0.30, 4);
        Applicant duplicate = new Applicant(1006, "Duplicate", 90000, 800, 0.10, 10);

        bst.insert(original);
        bst.insert(duplicate);

        Applicant result = bst.search(1006);

        printResult(
                "Edge Case",
                "Duplicate applicant ID does not replace original record",
                "Original",
                result.getName(),
                result.getName().equals("Original")
        );
    }

    /**
     * EDGE CASE:
     * Checks what happens when searching for an applicant ID that does not exist.
     */
    private static void testInvalidApplicantLookup() {
        DecisionEngine engine = new DecisionEngine();

        String result = engine.classifyApplicant(9999);

        printResult(
                "Edge Case",
                "Classify applicant ID that does not exist",
                "Applicant not found",
                result,
                result.equals("Applicant not found")
        );
    }

    /**
     * EDGE CASE:
     * Checks exact boundary values for the decision rules.
     */
    private static void testExactThresholdValues() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1007, "Threshold Applicant", 50000, 650, 0.40, 2);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1007);

        printResult(
                "Edge Case",
                "Applicant exactly meets all approval thresholds",
                "Approved",
                result,
                result.equals("Approved")
        );
    }
}