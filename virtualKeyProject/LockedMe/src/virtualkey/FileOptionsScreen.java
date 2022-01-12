package virtualkey;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileOptionsScreen implements Screen {
	
	private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();
	
public FileOptionsScreen() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 0: // Add File
                this.AddFile();
                break;
            case 1: // Delete File
                this.DeleteFile();
                break;
            case 2: // Search File
                this.SearchFile();
                break;
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    

    public void AddFile() {
        

        String fileName = this.getInputString();

		try {
//			Path path = FileSystems.getDefault().getPath(Directory.fileLocation + fileName).toAbsolutePath(); // to get the path of the adding file
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {

		    	  JOptionPane.showMessageDialog(null,"You have added a file named: " + file.getName() , "Add File", JOptionPane.INFORMATION_MESSAGE);
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		    	  JOptionPane.showMessageDialog(null, file.getName() + " already exists" , "Add File", JOptionPane.INFORMATION_MESSAGE);
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();
        
		Path path = FileSystems.getDefault().getPath(Directory.fileLocation + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
//	    	  System.out.println("Deleted File: " + file.getName());
	    	  JOptionPane.showMessageDialog(null,"You have deleted the file : " + fileName , "Delete File", JOptionPane.INFORMATION_MESSAGE);

	    	  dir.getFiles().remove(file);
	      } else {
	    	  JOptionPane.showMessageDialog(null,"Failed to delete the file : " + fileName + " - NOT FOUND" , "Delete File", JOptionPane.INFORMATION_MESSAGE);

	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
//    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

//        System.out.println("You are searching for a file named: " + fileName);
        
        
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				JOptionPane.showMessageDialog(null,"You have searched for a file named: " + fileName + " and it is FOUND" , "Search File", JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("Found");
				found = true;
			}
        }
        if (found == false) {
        	JOptionPane.showMessageDialog(null,"You have searched for a file named: " + fileName + " and it is NOT FOUND" , "Search File", JOptionPane.INFORMATION_MESSAGE);
//        	System.out.println("Not Found");
        }
    }
    
    private String getInputString() {
    	String inputString = JOptionPane.showInputDialog(null, "Enter file name ","", JOptionPane.INFORMATION_MESSAGE);

        return(inputString);

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {

        	Object[] result = options.toArray();
        	returnOption = JOptionPane.showOptionDialog(null, "What would you like to do?", "LockedMe", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, result, result[0]);
        }
        catch (InputMismatchException ex) {
        	JOptionPane.showMessageDialog(null,"Invalid Input" , "", JOptionPane.INFORMATION_MESSAGE);
//        	System.out.println("Invalid input");
        }
        return returnOption;

    }

}
