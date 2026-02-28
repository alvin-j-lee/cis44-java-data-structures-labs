/*
 * Demonstrates usage of LinkedPositionalList to manage a travel itinerary.
 * Adds, inserts, and displays stops in the itinerary using positions.
 * Shows traversal of the list with a for-each loop.
 */

public static void main(String[] args) {
    LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

    // Add stops to the itinerary
    itinerary.addFirst("Start in New York");
    itinerary.addLast("Fly to Paris");
    itinerary.addLast("Visit Louvre");

    // Insert a stop in between
    Position<String> parisStop = itinerary.last();
    itinerary.addBefore(parisStop, "Stop in London");

    // Display the final itinerary
    System.out.println("Travel Itinerary:");
    for (String stop : itinerary) {
        System.out.println("- " + stop);
    }
}