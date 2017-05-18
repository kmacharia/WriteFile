/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writefile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmacharia <https://github.com/kmacharia>
 */
public class WriteFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            //.txt works in similar fashion, you just change extension as in comment below
//            output = new FileOutputStream("config.txt");
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "root");
            prop.setProperty("dbpassword", "password");

            //save properties to project root folder
            prop.store(output, null);
            System.out.println("File saved successfully!");
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
