/*
 * Represents a single document to be printed.
 * A PrintJob stores the document name and
 * the number of pages in the document.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    /*
     * Constructs a new PrintJob with the given document name
     * and number of pages.
     *
     * @param documentName the name of the document
     * @param pageCount the number of pages in the document
     */

    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    /*
     * Returns a descriptive string representation of the print job.
     *
     * @return a formatted string describing the print job
     */
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}