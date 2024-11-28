// COMP352 ASSIGMENT2
// AUTHOR: ARASH SHAFIEE (STUDENT ID: 40278142)
// PROGRAMMING ASSIGNMENT

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EqualParanthesis {
    private Stack openStack;
    private Stack closeStack;

    public EqualParanthesis() {
        openStack = new Stack();
        closeStack = new Stack();
    }

    public void validateFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineCounter = 1;

            while ((line = br.readLine()) != null) {
                boolean isValid = isValid(line);
                System.out.println("Line " + lineCounter + ": " + isValid);
                lineCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid(String s) {
        openStack = new Stack();
        closeStack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push('(');
            } else if (c == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!closeStack.isEmpty()) {
                    closeStack.pop();
                } else {
                    return false;
                }
            } else if (c == '*') {
                closeStack.push('*');
            } else if (c == '$') {
                break;
            }
        }

        while (!openStack.isEmpty() && !closeStack.isEmpty()) {
            openStack.pop();
            closeStack.pop();
        }

        return openStack.isEmpty();
    }

}
