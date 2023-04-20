import java.util.*;

public class BookRentalSystem {

	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		
		Book book1 = new Book();
		book1.name = "System Analysis and Design";
		book1.author = "Gary B. Shelly";
		book1.copy = 2;
		
		Book book2 = new Book();
		book2.name = "Android Application";
		book2.author = "Corinne Hoisington";
		book2.copy = 3;
		
		Book book3 = new Book();
		book3.name = "Programming Concepts and Logic Formulation";
		book3.author = "Rasauro E. Manuel";
		book3.copy = 4;
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		System.out.println("ELECTRONIC BOOK RENTAL SYSTEM");
		System.out.println("*****************************");
		
		for (int x = 0; x < books.size(); x++) {
			System.out.print(x);
			System.out.print(" " + books.get(x).getName() + ", " + books.get(x).getAuthor());
			System.out.println();
		}
		
		boolean end = false;
		
		while (end==false) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("CHOOSE A NUMBER TO RENT A BOOK: ");
				int choice = sc.nextInt();
				
				Book book = books.get(choice);
				int copy = book.getCopy();
				
				if (book.copy > 0) {
					System.out.print("You rented : " + books.get(choice).getName());
					book.setCopy(copy -= 1);
				} else {
					System.out.print("NO COPIES AVAILABLE");
				}

				System.out.print("\nRent again? [Y/N]: ");
				String continueSystem = sc.next();
				if (continueSystem.equalsIgnoreCase("N")) {
					end = true;
					System.out.print("Program End");
				}
			}
			
			catch (IndexOutOfBoundsException e) {
				System.out.println("INDEX DOES NOT EXIST, Try Again!");
			}
			
			catch (InputMismatchException e) {
				System.out.println("INVALID INPUT");
			}
		}
	}
}
