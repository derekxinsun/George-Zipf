/*
 * Program introduction: driver for cellphone linked list.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {
		/**
		 * import txt file to list
		 */
		Scanner sc =null;
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
		}catch(FileNotFoundException e) {
			System.out.println("Problems found when opening the file.");
			System.exit(0);
		}
		
		CellList cl1 = new CellList();
		while(sc.hasNextLine()) {
			long sn = sc.nextLong();
			String br = sc.next();
			double pr = sc.nextDouble();
			int yr = sc.nextInt();
			sc.nextLine();
			CellPhone c = new CellPhone(sn,br,yr,pr);
			if(cl1.find(c.getSerialNum())==null){
				cl1.addToStart(c);
			}
		}
		sc.close();
		/**
		 * display the list
		 */
		System.out.println("\nThe current size of the list is "+cl1.getSize()+". Here are the contents of the list.");
		System.out.println("======================================================================");
		cl1.showContents();
		/**
		 * search serial number in the list
		 */
		System.out.println("\n======================================================================");
		System.out.print("Please enter a serial number to search: ");
		Scanner kb = new Scanner (System.in);
		boolean invalid = false;
		long number=0;
		do{
			try{
				number = kb.nextLong();
			}catch(InputMismatchException e) {
				System.out.print("Invalid input. Please enter a serial number to search: ");
				invalid = true;
			}	
		}while(invalid);
		CellList.CellNode c = cl1.find(number);
		if(c==null) {
			System.out.println("Serial number is not found.");
		}else {
			System.out.println("Serial number is found.");
			System.out.println("The CellPhone is: "+c.getC());
		}
		System.out.println("\n======================================================================");
		
		/**
		 * other tests
		 */
		CellList cl2 = new CellList();
		CellList cl3 = new CellList();		
		CellPhone c1 = new CellPhone(1000,"huawei",2017,649.33);
		CellPhone c2 = new CellPhone(1001,"SONY",2017,549.99);
		CellPhone c3 = new CellPhone(1002,"OPPO",2017,335.77);
		
		/**
		 * tests on empty list cl3.
		 */
		System.out.println("\nTry deleteFromStart method on empty list cl3.");
		try {
			cl3.deleteFromStart();
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		System.out.println("\nTry deleteFromIndex method on empty list cl3.");
		try {
			cl3.deleteFromIndex(3);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		System.out.println("\nTry replaceAtIndex method on empty list cl3.");
		try {
			cl3.replaceAtIndex(c1,3);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		System.out.println("\nTry find method on empty list cl3.");
		if(cl3.find(3621) == null) {
			System.out.println("Nothing is found");
		}
		System.out.println("\nTry contains method on empty list cl3.");
		try {
			boolean containsCl3 = cl3.contains(1119000);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element.");
		}
		cl3.showContents();
		System.out.println("\nTry insertAtIndex method on empty list cl3.");
		try{
			cl3.insertAtIndex(c1, 0);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Index. Can't insert.");
		}
		
//		CellPhone c1 = new CellPhone(1000,"huawei",2017,649.33);
//		CellPhone c2 = new CellPhone(1001,"SONY",2017,549.99);
//		CellPhone c3 = new CellPhone(1002,"OPPO",2017,335.77);
		CellPhone c4 = new CellPhone(1003,"Huawei",2017,649.33);
		CellPhone c5 = new CellPhone(1004,"SonY",2017,549.99);
		CellPhone c6 = new CellPhone(1005,"OPPO",2017,335.77);
		

		
		System.out.println("\n======================================================================");
		
		System.out.println("\nTry insertAtIndex method on non-empty list cl2.");
		cl2.addToStart(c1);
		cl2.addToStart(c2);
		cl2.showContents();
		try {
			System.out.println("\nInsert at valid index on non-empty list cl2.");
			cl2.insertAtIndex(c3,1);
		}catch(NoSuchElementException e) {
			System.out.println("Out of bound. Can't insert.");
		}
		cl2.showContents();
		try {
			System.out.println("\nInsert at invalid index on non-empty list cl2.");
			cl2.insertAtIndex(c4,3);
		}catch(NoSuchElementException e) {
			System.out.println("Out of bound. Can't insert.");
		}
		cl2.showContents();
		System.out.println("\nTry deleteFromIndex method on non-empty list cl2.");
		try {
			System.out.println("\nDelete invalid index on non-empty list cl2.");
			cl2.deleteFromIndex(3);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		
		cl2.showContents();
		System.out.println("\nTry deleteFromIndex method on non-empty list cl2.");
		try {
			System.out.println("\nDelete index 0 on non-empty list cl2.");
			cl2.deleteFromIndex(0);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		cl2.showContents();
		
		cl2.addToStart(c2);
		System.out.println("\nAdd c2 back to list cl2.");
		cl2.showContents();
		System.out.println("\nTry deleteFromIndex method on non-empty list cl2.");
		try {
			System.out.println("\nDelete last index on non-empty list cl2.");
			cl2.deleteFromIndex(2);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		cl2.showContents();
		
		System.out.println("\nTry deleteFromStart method on non-empty list cl2.");
		try {
			cl2.deleteFromStart();
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't delete.");
		}
		cl2.showContents();
		
		
		System.out.println("\nAdd a few cellphones back to list cl2.");
		cl2.addToStart(c1);
		cl2.addToStart(c2);
		cl2.showContents();
	
		System.out.println("\nTry contains method on non-empty list cl2.");
		try {
			boolean containsCl2 = cl2.contains(1009);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element.");
		}
		System.out.println("\nTry contains method on non-empty list cl2.");
		try {
			boolean containsCl2 = cl2.contains(1000);
			if(containsCl2)
				System.out.println("cl2 contains a cellphone with serial number 1000");
			else
				System.out.println("cl2 doesn't contains a cellphone with serial number 1000");
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element.");
		}
		
		System.out.println("\nTry replaceAtIndex method on non-empty list cl2.");
		try {
			System.out.println("\nReplace at index 0 on non-empty list cl2.");
			cl2.replaceAtIndex(c6, 0);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't replace");
		}
		cl2.showContents();
		try {
			System.out.println("\nReplace at last index on non-empty list cl2.");
			cl2.replaceAtIndex(c6, 2);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't replace");
		}
		cl2.showContents();
		try {
			System.out.println("\nReplace at the other index on non-empty list cl2.");
			cl2.replaceAtIndex(c6, 1);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't replace");
		}
		cl2.showContents();
		try {
			System.out.println("\nReplace at invalid index on non-empty list cl2.");
			cl2.replaceAtIndex(c6, 3);
		}catch(NoSuchElementException e) {
			System.out.println("No Such Element. Can't replace");
		}
		System.out.println("\n======================================================================");
		System.out.println("Creating 4 lists");
		CellList cl7=new CellList();
		CellList cl8=new CellList();
		CellList clEmpty=new CellList();
		cl7.addToStart(c1);
		cl7.addToStart(c2);
		cl7.addToStart(c3);
		cl7.addToStart(c4);
		System.out.println("List:cl7");
		cl7.showContents();
		cl8.addToStart(c5);
		cl8.addToStart(c6);
		cl8.addToStart(c3);
		cl8.addToStart(c2);
		System.out.println("List:cl8");
		cl8.showContents();
		CellList cl7Copy = new CellList(cl7);
		System.out.println("List: Copy of cl7");
		cl7Copy.showContents();
		System.out.println("List:clEmpty");
		clEmpty.showContents();
		System.out.println("Comparing clEmpty with cl8.");
		if(clEmpty.equals(cl8)) {
			System.out.println("Two CellLists are equal.\n");
		}else {
			System.out.println("Two CellLists are NOT equal.\n");
		}
		System.out.println("Comparing cl8 with clEmpty.");
		if(cl8.equals(clEmpty)) {
			System.out.println("Two CellLists are equal.\n");
		}else {
			System.out.println("Two CellLists are NOT equal.\n");
		}
		System.out.println("Comparing cl7 with cl8.");
		if(cl7.equals(cl8)) {
			System.out.println("Two CellLists are equal.\n");
		}else {
			System.out.println("Two CellLists are NOT equal.\n");
		}
		System.out.println("Comparing cl7 with cl7Copy.");
		if(cl7.equals(cl7Copy)) {
			System.out.println("Two CellLists are equal.\n");
		}else {
			System.out.println("Two CellLists are NOT equal.\n");
		}
		
		kb.close();
	}

}
