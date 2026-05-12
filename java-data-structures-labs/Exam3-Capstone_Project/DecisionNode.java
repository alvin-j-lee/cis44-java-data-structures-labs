/**
 * Represents one node in the Decision Tree.
 *
 * A DecisionNode can be either:
 * 1. A decision node, which checks an applicant attribute against a threshold.
 * 2. A leaf node, which stores a final result such as "Approved" or "Rejected".
 */
public class DecisionNode {
    private String attribute;
    private double threshold;
    private DecisionNode trueBranch;
    private DecisionNode falseBranch;
    private String result;

    /**
     * Creates a decision node.
     *
     * This type of node checks whether a certain applicant attribute passes
     * a threshold condition.
     *
     * @param attribute the applicant attribute to evaluate
     * @param threshold the value used for comparison
     */
    public DecisionNode(String attribute, double threshold) {
        this.attribute = attribute;
        this.threshold = threshold;
        this.trueBranch = null;
        this.falseBranch = null;
        this.result = null;
    }

    /**
     * Creates a leaf node.
     *
     * Leaf nodes do not evaluate another condition. Instead, they store the
     * final decision result.
     *
     * @param result the final classification, such as "Approved" or "Rejected"
     */
    public DecisionNode(String result) {
        this.attribute = null;
        this.threshold = 0;
        this.trueBranch = null;
        this.falseBranch = null;
        this.result = result;
    }

    /**
     * Determines whether this node is a leaf node.
     *
     * @return true if this node stores a final result, false otherwise
     */
    public boolean isLeaf() {
        return result != null;
    }

    /**
     * Evaluates this decision node against a given applicant.
     *
     * Different attributes use different comparison logic:
     * - income must be greater than or equal to the threshold
     * - creditScore must be greater than or equal to the threshold
     * - debtToIncomeRatio must be less than or equal to the threshold
     * - employmentYears must be greater than or equal to the threshold
     *
     * @param applicant the applicant being evaluated
     * @return true if the applicant passes this condition, false otherwise
     */
    public boolean evaluate(Applicant applicant) {
        if (attribute.equals("income")) {
            return applicant.getIncome() >= threshold;
        } else if (attribute.equals("creditScore")) {
            return applicant.getCreditScore() >= threshold;
        } else if (attribute.equals("debtToIncomeRatio")) {
            return applicant.getDebtToIncomeRatio() <= threshold;
        } else if (attribute.equals("employmentYears")) {
            return applicant.getEmploymentYears() >= threshold;
        } else {
            throw new IllegalArgumentException("Unknown attribute: " + attribute);
        }
    }

    public String getResult() {
        return result;
    }

    public DecisionNode getTrueBranch() {
        return trueBranch;
    }

    public DecisionNode getFalseBranch() {
        return falseBranch;
    }

    public void setTrueBranch(DecisionNode trueBranch) {
        this.trueBranch = trueBranch;
    }

    public void setFalseBranch(DecisionNode falseBranch) {
        this.falseBranch = falseBranch;
    }
}