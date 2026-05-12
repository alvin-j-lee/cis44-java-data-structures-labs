/**
 * Represents the loan approval Decision Tree.
 *
 * This class builds and manages the decision logic used to classify applicants
 * as either "Approved" or "Rejected".
 */
public class DecisionTree {
    private DecisionNode root;

    /**
     * Creates a DecisionTree with a default loan approval rule structure.
     */
    public DecisionTree() {
        buildDefaultTree();
    }

    /**
     * Builds the default decision tree used by the loan approval engine.
     *
     * The logic is:
     *
     * 1. Check if credit score >= 650.
     *    - If false: Rejected
     *    - If true: check income
     *
     * 2. Check if income >= 50000.
     *    - If false: Rejected
     *    - If true: check debt-to-income ratio
     *
     * 3. Check if debt-to-income ratio <= 0.40.
     *    - If false: Rejected
     *    - If true: check employment years
     *
     * 4. Check if employment years >= 2.
     *    - If false: Rejected
     *    - If true: Approved
     */
    private void buildDefaultTree() {
        root = new DecisionNode("creditScore", 650);

        DecisionNode incomeCheck = new DecisionNode("income", 50000);
        DecisionNode debtCheck = new DecisionNode("debtToIncomeRatio", 0.40);
        DecisionNode employmentCheck = new DecisionNode("employmentYears", 2);

        DecisionNode approved = new DecisionNode("Approved");
        DecisionNode rejected = new DecisionNode("Rejected");

        root.setTrueBranch(incomeCheck);
        root.setFalseBranch(rejected);

        incomeCheck.setTrueBranch(debtCheck);
        incomeCheck.setFalseBranch(rejected);

        debtCheck.setTrueBranch(employmentCheck);
        debtCheck.setFalseBranch(rejected);

        employmentCheck.setTrueBranch(approved);
        employmentCheck.setFalseBranch(rejected);
    }

    /**
     * Classifies an applicant using the Decision Tree.
     *
     * This is the main decision-making method.
     *
     * @param applicant the applicant being evaluated
     * @return "Approved", "Rejected", or "No Decision"
     */
    public String classify(Applicant applicant) {
        return classifyRecursive(root, applicant);
    }

    /**
     * Recursively follows the decision tree until a leaf node is reached.
     *
     * At each decision node:
     * - If the applicant passes the condition, move to the true branch.
     * - If the applicant fails the condition, move to the false branch.
     *
     * Once a leaf node is reached, return its final result.
     *
     * @param current the current decision node being evaluated
     * @param applicant the applicant being classified
     * @return the final decision result
     */
    private String classifyRecursive(DecisionNode current, Applicant applicant) {
        if (current == null) {
            return "No Decision";
        }

        if (current.isLeaf()) {
            return current.getResult();
        }

        if (current.evaluate(applicant)) {
            return classifyRecursive(current.getTrueBranch(), applicant);
        } else {
            return classifyRecursive(current.getFalseBranch(), applicant);
        }
    }
}