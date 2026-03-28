public class CompanyTreeDriver {
    public static void main(String[] args) {

        // Root
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Level 1
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // Level 2 (Sales)
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // Level 2 (Engineering)
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // Level 3 (Developers)
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}