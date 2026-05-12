/**
 * Represents one node in the Binary Search Tree.
 *
 * Each ApplicantNode stores one Applicant object and references to a left
 * and right child node. The BST uses applicantId as the sorting key.
 */
public class ApplicantNode {
    private Applicant applicant;
    private ApplicantNode left;
    private ApplicantNode right;

    /**
     * Creates a new tree node that stores an applicant.
     *
     * @param applicant the applicant stored inside this node
     */
    public ApplicantNode(Applicant applicant) {
        this.applicant = applicant;
        this.left = null;
        this.right = null;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public ApplicantNode getLeft() {
        return left;
    }

    public ApplicantNode getRight() {
        return right;
    }

    public void setLeft(ApplicantNode left) {
        this.left = left;
    }

    public void setRight(ApplicantNode right) {
        this.right = right;
    }
}