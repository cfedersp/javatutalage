package org.cjf.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import org.cjf.demo.exception.InvalidInputException;

public class ReplaceStdIn {
	public  String[] protectedWords = {"cjf", "demo", "moist"};
	public HashMap<String, String> replaceWords = new HashMap<String, String>();

	public static void main(String[] args) {
		ReplaceStdIn processor = new ReplaceStdIn();
		processor.replaceWords.put("Lorem", "hurdy");
		processor.replaceWords.put("ipsum", "gurdy");

		// Using 'try-with-resources' syntax we initialize an object that implements AutoCloseable, and java will automatically close it for us after this block is finished executing.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String input;
        	while ( (input = br.readLine()) != null) {
            	System.out.println(processor.processLine(input));
            }

    	} catch (IOException e) {
        	e.printStackTrace();
        } catch (InvalidInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
	/* // and that saves us from this awkward finally block
	finally {
            if (br != null) {
                  br.close();
		// if the code above throws an exception out of the function, AND closing this resource throws an exception, this exception gets suppressed. 
            }
        }
	*/
	}

	public String processLine(String input) throws InvalidInputException {
		for(int i = 0; i < protectedWords.length; i++) {
			String protectedWord = protectedWords[i];
			String regularExpression = ".*" + protectedWord + ".*";
			if(input.matches(regularExpression)) {
				throw new InvalidInputException(input, protectedWord);
			}
		}
		String fixed = input;
		Iterator<String> replaceIterator = replaceWords.keySet().iterator();
		while(replaceIterator.hasNext()) {
			String replaceThis = replaceIterator.next();
			String withThis = replaceWords.get(replaceThis);
			fixed = fixed.replace(replaceThis, withThis);
		}
		return fixed;
	}
}
