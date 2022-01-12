package virtualkey;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;



public class WelcomeScreen implements Screen{
	private String intro = "Welcome to LockedMe.com!";
    private String developerName = "Developer: Sachin Davis Mundassery";

    private String[] options = new String[3];
    

    public WelcomeScreen() {

    	options[0] = "Display Files";
    	options[1] = "Show File Options Menu";
    	options[2] = "Quit";

    }

    public void introWelcomeScreen() {
    	JOptionPane.showMessageDialog(null, intro +"\n \n" + developerName, "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    public void GetUserInput() {
        int selectedOption  = 0;
        
        // iterate until the user quits.
        while ((selectedOption = this.getOption()) != 2) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 0: // Show Files in Directory
                this.ShowFiles();
                break;
                
            case 1: // Show File Options menu

            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
            	ScreenService.getCurrentScreen().GetUserInput();
                break;
                
            default:
            	JOptionPane.showMessageDialog(null, "Invalid Option", "", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Invalid Option");
                break;
        }
        
    }
    
    // to display all the files in the directory
    public void ShowFiles() {
    	DirectoryService.PrintFiles();
    }
    

    private int getOption() {
        int userChoiceFromMainOptions = 0;
        
        // exception to handle invalid input from the user
        try {
        	userChoiceFromMainOptions = JOptionPane.showOptionDialog(null, "What would you like to do?", "LockedMe", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
        }
        catch (InputMismatchException ex) {

        }
        return userChoiceFromMainOptions;

    }
}
