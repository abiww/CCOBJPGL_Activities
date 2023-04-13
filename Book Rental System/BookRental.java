import java.util.Scanner;

public class BookRental {
	String bookTitle;
	String authorName;
	int numberOfCopies;
	
	public BookRental (String bookTitle, String authorName, int numberOfCopies) {
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.numberOfCopies = numberOfCopies;
	}
	
	public String getBookTitle() {
        return bookTitle;
    }
	
	public String getAuthorName() {
        return authorName;
    }
	
	public int getNumberOfCopies() {
        return numberOfCopies;
    }
	
	public void rentedBook() {
		numberOfCopies--;
	}
	
	public static void main(String[] args) {
		
		System.out.println("ELECTRONIC BOOK RENTAL SYSTEM");
		System.out.println("*****************************");
		
		BookRental bookRental[] = new BookRental[3];
		//Setting rental books information
		bookRental[0] = new BookRental("System Analysis and Design", "Gary B. Shelly", 2);
		bookRental[1] = new BookRental("Android Application", "Corinne Hoisington", 3);	
		bookRental[2] = new BookRental("Programming Concepts and Logic Formulation", "Rasauro E. Manuel", 4);
		
		for (int i = 0; i < bookRental.length; i++) {
			//Display books available for rent
			System.out.println((i) + " " + bookRental[i].getBookTitle() + ", " + bookRental[i].getAuthorName());
		}
		
		System.out.println("*****************************");
		
		Scanner scan = new Scanner(System.in);
		boolean continueRenting = true;
		
		while (continueRenting) {
			System.out.print("CHOOSE A NUMBER TO RENT YOUR FAVORITE BOOK: ");
			int choice = scan.nextInt();
			
			try {
				BookRental selectedBook = bookRental[choice];
				
				if (selectedBook.getNumberOfCopies() == 0) {
					System.out.println("No copies available");
				} 
				
				else {
					selectedBook.rentedBook();
					System.out.println("You Rented " + bookRental[choice].getBookTitle());
					System.out.println("Available Copies: " + bookRental[choice].getNumberOfCopies());
				}
				
				//To continue or end the program
				System.out.print("Rent Again? Y/N: ");
				String input = scan.next();
				
				if (!input.equalsIgnoreCase("Y")) {
                    continueRenting = false;
                    System.out.print("Program End");
				}
				
			} catch (IndexOutOfBoundsException e) {
				 System.out.println("INDEX DOES NOT EXIST, Try Again!");
			}
		}	
	}
}
