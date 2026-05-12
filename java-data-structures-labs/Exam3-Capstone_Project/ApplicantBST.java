/**
 * Binary Search Tree for storing and retrieving Applicant records.
 *
 * The BST is organized by applicantId:
 * - Smaller applicant IDs go to the left subtree.
 * - Larger applicant IDs go to the right subtree.
 *
 * This allows efficient searching when the tree is reasonably balanced.
 */
public class ApplicantBST {
    private ApplicantNode root;

    /**
     * Creates an empty ApplicantBST.
     */
    public ApplicantBST() {
        this.root = null;
    }

    /**
     * Public insert method.
     *
     * This method starts the recursive insertion process from the root.
     *
     * @param applicant the applicant to add to the BST
     */
    public void insert(Applicant applicant) {
        root = insertRecursive(root, applicant);
    }

    /**
     * Recursively inserts an applicant into the correct location in the BST.
     *
     * If the current node is null, a new ApplicantNode is created.
     * If the new applicant's ID is smaller, the method moves left.
     * If the new applicant's ID is larger, the method moves right.
     * Duplicate IDs are not inserted.
     *
     * @param current the current node being checked
     * @param applicant the applicant being inserted
     * @return the updated subtree root
     */
    private ApplicantNode insertRecursive(ApplicantNode current, Applicant applicant) {
        if (current == null) {
            return new ApplicantNode(applicant);
        }

        if (applicant.getApplicantId() < current.getApplicant().getApplicantId()) {
            current.setLeft(insertRecursive(current.getLeft(), applicant));
        } else if (applicant.getApplicantId() > current.getApplicant().getApplicantId()) {
            current.setRight(insertRecursive(current.getRight(), applicant));
        } else {
            System.out.println("Applicant ID already exists: " + applicant.getApplicantId());
        }

        return current;
    }

    /**
     * Searches for an applicant by applicantId.
     *
     * This is the main BST lookup method.
     *
     * @param applicantId the ID to search for
     * @return the matching Applicant object, or null if not found
     */
    public Applicant search(int applicantId) {
        return searchRecursive(root, applicantId);
    }

    /**
     * Recursive helper method for searching the BST.
     *
     * At each node:
     * - If the current node is null, the applicant does not exist.
     * - If the ID matches, return the applicant.
     * - If the search ID is smaller, search the left subtree.
     * - If the search ID is larger, search the right subtree.
     *
     * @param current the current node being checked
     * @param applicantId the ID being searched for
     * @return the matching Applicant object, or null if not found
     */
    private Applicant searchRecursive(ApplicantNode current, int applicantId) {
        if (current == null) {
            return null;
        }

        if (applicantId == current.getApplicant().getApplicantId()) {
            return current.getApplicant();
        }

        if (applicantId < current.getApplicant().getApplicantId()) {
            return searchRecursive(current.getLeft(), applicantId);
        } else {
            return searchRecursive(current.getRight(), applicantId);
        }
    }

    /**
     * Checks whether an applicant exists in the BST.
     *
     * @param applicantId the ID to check
     * @return true if the applicant exists, false otherwise
     */
    public boolean contains(int applicantId) {
        return search(applicantId) != null;
    }

    /**
     * Prints all applicants in sorted order by applicantId.
     *
     * In-order traversal visits:
     * left subtree, current node, right subtree.
     */
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    /**
     * Recursive helper method for in-order traversal.
     *
     * @param current the current node being visited
     */
    private void inOrderRecursive(ApplicantNode current) {
        if (current != null) {
            inOrderRecursive(current.getLeft());
            System.out.println(current.getApplicant());
            inOrderRecursive(current.getRight());
        }
    }
}