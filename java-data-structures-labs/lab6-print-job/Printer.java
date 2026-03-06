/*
 * Simulates a printer that manages a queue of print jobs.
 * Jobs are processed in the order they are received
 * (First-In, First-Out).
 */
public class Printer {
    private Queue jobQueue;

    // Constructs a Printer and initializes the queue used to store print jobs.
    public Printer() {
        jobQueue = new LinkedQueue();
    }

    /*
     * Adds a new print job to the rear of the queue.
     *
     * @param job The print job to add
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.enqueue(job);
    }

    /*
     * Processes the job at the front of the queue.
     * If the queue is empty, a message is displayed.
     * Otherwise, the next job is removed and printed.
     */
    public void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("No print jobs in the queue.");
        } else {
            PrintJob job = (PrintJob) jobQueue.dequeue();
            System.out.println("Processing: " + job);
        }
    }

    /*
     * Main method used to test the printer queue simulation.
     */
    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}