package junit.com.cBioportal.DaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecuteShellComand {
	public static void main(String[] args) throws Exception {
        // Run command and wait till it's done
        Process p = Runtime.getRuntime().exec("mallet.bat train-topics  --input tutorial.mallet --num-topics 20 --output-state topic-state.gz --output-topic-keys tutorial_keys.txt --output-doc-topics tutorial_compostion.txt ");
        p.waitFor();

        // Grab output and print to display
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}