import java.util.Random;
import javax.swing.JOptionPane;
public class NumberGuessing {
public static void main(String[] args) {
        
        int range = 100;
        int maxAttempts = 10;
        int score = 0;
        int rounds = 1;
        
        Random random = new Random();
        int numberToGuess = random.nextInt(range) + 1; 
        
        while (true) {
            String guessStr = JOptionPane.showInputDialog("Round " + rounds + ":\nGuess a number between 1 and " + range + ".\nYou have " + (maxAttempts) + " attempts left.");
            if (guessStr == null) {
                JOptionPane.showMessageDialog(null, "Thanks for playing :)! Your final score is " + score + ".");
                break;
            }
            int guess = Integer.parseInt(guessStr);
            
            if (guess == numberToGuess) {
                JOptionPane.showMessageDialog(null, "Congratulations, you guessed the number!\nYour score for this round is " + maxAttempts + ".");
                score += maxAttempts;
                numberToGuess = random.nextInt(range) + 1;
                maxAttempts = 10;
                rounds++;
            }  
            else if ((guess >= numberToGuess-5) && (guess <= numberToGuess-1)) {
                JOptionPane.showMessageDialog(null, "You are almost close.\nGuess a little higher.\nYou have " + (--maxAttempts) + " attempts left.");
            }
            else if ((guess <= numberToGuess+5) && (guess >= numberToGuess+1)) {
                JOptionPane.showMessageDialog(null, "You are almost close.\nGuess a little lower.\nYou have " + (--maxAttempts) + " attempts left.");
            }
            else if (guess < numberToGuess) {
                JOptionPane.showMessageDialog(null, "Your guess is too low.\nYou have " + (--maxAttempts) + " attempts left.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Your guess is too high.\nYou have " + (--maxAttempts) + " attempts left.");
            }
            
            if (maxAttempts == 0) {
                JOptionPane.showMessageDialog(null, "You have run out of attempts.\nThe number was " + numberToGuess + ".\nYour score for this round is 0.");
                numberToGuess = random.nextInt(range) + 1;
                maxAttempts = 10;
                rounds++;
            }
        }
    }
}
