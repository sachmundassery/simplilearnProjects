package virtualkey;


import java.util.ArrayList;


import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.File;

import java.util.Collections;

public class Directory {


	public static final String fileLocation = "D:\\JavaProjects\\virtualKeyProject\\LockedMe\\files\\";

    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(fileLocation).toAbsolutePath();
    
    File Dfiles = path.toFile();
       
    public String getName() {
        return fileLocation;
    }
    
    public void print() {
    	System.out.println("Existing Files: ");
    	files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles() {
    	
        File[] directoryFiles = Dfiles.listFiles();
        
        
        
    	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }

    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
	    
}
