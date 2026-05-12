import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the Decision Engine project.
 *
 * These tests verify that the BST lookup logic and Decision Tree
 * classification logic work correctly.
 */
public class DecisionEngineTest {

    /**
     * Boundary Test:
     * Searching an empty BST should return null.
     */
    @Test
    public void testEmptyTreeLookup() {
        ApplicantBST bst = new ApplicantBST();

        Applicant result = bst.search(1001);

        assertNull(result);
    }

    /**
     * Logic Validation:
     * The BST should correctly find an applicant that was inserted.
     */
    @Test
    public void testBSTSearchExistingApplicant() {
        ApplicantBST bst = new ApplicantBST();

        Applicant applicant = new Applicant(1001, "Alice", 75000, 720, 0.30, 4);
        bst.insert(applicant);

        Applicant result = bst.search(1001);

        assertEquals("Alice", result.getName());
        assertEquals(1001, result.getApplicantId());
    }

    /**
     * Logic Validation:
     * The BST should return null when searching for an ID that does not exist.
     */
    @Test
    public void testBSTSearchMissingApplicant() {
        ApplicantBST bst = new ApplicantBST();

        Applicant applicant = new Applicant(1001, "Alice", 75000, 720, 0.30, 4);
        bst.insert(applicant);

        Applicant result = bst.search(9999);

        assertNull(result);
    }

    /**
     * Logic Validation:
     * Applicant should be approved if all decision rules are passed.
     */
    @Test
    public void testApprovedApplicant() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1001, "Alice", 75000, 720, 0.30, 4);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1001);

        assertEquals("Approved", result);
    }

    /**
     * Logic Validation:
     * Applicant should be rejected if credit score is below the threshold.
     */
    @Test
    public void testRejectedByCreditScore() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1002, "Bob", 80000, 600, 0.20, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1002);

        assertEquals("Rejected", result);
    }

    /**
     * Logic Validation:
     * Applicant should be rejected if income is below the threshold.
     */
    @Test
    public void testRejectedByIncome() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1003, "Charlie", 40000, 700, 0.20, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1003);

        assertEquals("Rejected", result);
    }

    /**
     * Logic Validation:
     * Applicant should be rejected if debt-to-income ratio is too high.
     */
    @Test
    public void testRejectedByDebtToIncomeRatio() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1004, "Diana", 70000, 720, 0.50, 5);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1004);

        assertEquals("Rejected", result);
    }

    /**
     * Logic Validation:
     * Applicant should be rejected if employment history is too short.
     */
    @Test
    public void testRejectedByEmploymentYears() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1005, "Ethan", 70000, 720, 0.30, 1);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1005);

        assertEquals("Rejected", result);
    }

    /**
     * Edge Case:
     * Duplicate applicant IDs should not replace the original applicant.
     */
    @Test
    public void testDuplicateApplicantIdDoesNotReplaceOriginal() {
        ApplicantBST bst = new ApplicantBST();

        Applicant original = new Applicant(1006, "Original", 70000, 720, 0.30, 4);
        Applicant duplicate = new Applicant(1006, "Duplicate", 90000, 800, 0.10, 10);

        bst.insert(original);
        bst.insert(duplicate);

        Applicant result = bst.search(1006);

        assertEquals("Original", result.getName());
    }

    /**
     * Edge Case:
     * The engine should return a clear message when the applicant ID is invalid.
     */
    @Test
    public void testInvalidApplicantLookup() {
        DecisionEngine engine = new DecisionEngine();

        String result = engine.classifyApplicant(9999);

        assertEquals("Applicant not found", result);
    }

    /**
     * Edge Case:
     * Tests the exact threshold values.
     *
     * Applicant has:
     * - credit score exactly 650
     * - income exactly 50000
     * - debt-to-income ratio exactly 0.40
     * - employment years exactly 2
     *
     * Since the rules use >= for most values and <= for debt ratio,
     * this applicant should be approved.
     */
    @Test
    public void testExactThresholdValuesApproved() {
        DecisionEngine engine = new DecisionEngine();

        Applicant applicant = new Applicant(1007, "Threshold Applicant", 50000, 650, 0.40, 2);
        engine.addApplicant(applicant);

        String result = engine.classifyApplicant(1007);

        assertEquals("Approved", result);
    }

    /**
     * Edge Case:
     * Tests invalid input inside a DecisionNode.
     *
     * If an unknown attribute is used, evaluate() should throw
     * an IllegalArgumentException.
     */
    @Test
    public void testInvalidDecisionNodeAttribute() {
        DecisionNode invalidNode = new DecisionNode("invalidAttribute", 100);
        Applicant applicant = new Applicant(1008, "Invalid Test", 60000, 700, 0.30, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            invalidNode.evaluate(applicant);
        });
    }
}