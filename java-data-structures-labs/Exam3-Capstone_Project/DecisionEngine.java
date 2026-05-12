/**
 * Main engine class that connects the ApplicantBST and DecisionTree.
 *
 * The ApplicantBST stores applicant records.
 * The DecisionTree evaluates applicants and returns approval decisions.
 */
public class DecisionEngine {
    private ApplicantBST applicantTree;
    private DecisionTree decisionTree;

    /**
     * Creates a new DecisionEngine with an empty applicant BST
     * and a default decision tree.
     */
    public DecisionEngine() {
        this.applicantTree = new ApplicantBST();
        this.decisionTree = new DecisionTree();
    }

    /**
     * Adds an applicant to the BST.
     *
     * @param applicant the applicant to store
     */
    public void addApplicant(Applicant applicant) {
        applicantTree.insert(applicant);
    }

    /**
     * Finds an applicant by ID.
     *
     * This method uses the BST search logic.
     *
     * @param applicantId the applicant ID to search for
     * @return the matching Applicant object, or null if not found
     */
    public Applicant findApplicant(int applicantId) {
        return applicantTree.search(applicantId);
    }

    /**
     * Core logic method.
     *
     * This method makes the data structures work together:
     * 1. Search for the applicant in the BST.
     * 2. If the applicant exists, pass the applicant into the Decision Tree.
     * 3. Return the final loan decision.
     *
     * @param applicantId the ID of the applicant to classify
     * @return the decision result, or "Applicant not found"
     */
    public String classifyApplicant(int applicantId) {
        Applicant applicant = applicantTree.search(applicantId);

        if (applicant == null) {
            return "Applicant not found";
        }

        return decisionTree.classify(applicant);
    }

    /**
     * Prints all applicants in sorted order by applicant ID.
     */
    public void printApplicants() {
        applicantTree.inOrderTraversal();
    }
}