package virtualkey;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class DirectoryService {
	 
	private static Directory fileDirectory = new Directory();
	    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();
    	
    	ArrayList<String> fileArray = new ArrayList<String>();
    	int fileNumber = 1;
        for (File file : DirectoryService.getFileDirectory().getFiles())
        {
        	fileArray.add(fileNumber +" : "+file.getName()+"\n");
        	fileNumber+=1;
        	
//            System.out.println(file.getName()+"^^^");
        }
        Object[] result = fileArray.toArray();
        JOptionPane.showMessageDialog(null, result);
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryService.fileDirectory = fileDirectory;
    }
}
