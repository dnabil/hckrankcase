package net.dnabil;

import java.io.File;
import java.io.IOException;

/**
 * @author dnabil
 */
public class HckrankCase {
    String location = "./";
    public CaseFile input;
    public CaseFile output;
    /**
     * numberFormat: implies qty of number exists in the file's format name (1-3)
     * -eg: 1 means <input/output>0.txt, 2 means <input/output>00.txt
     */
    private byte numberFormat = 3;

    /**
     * location: directory of testcases file that'll be created
     */
    public HckrankCase(String location) {
        this.location = location;
        input = new CaseFile("input", (byte) 3);
        output = new CaseFile("output", (byte) 3);
        createDirectory();
    }

    /**
     * location: directory of testcases file that'll be created
     * numberFormat: implies qty of number exists in the file's format name (1-3)
     * -eg: 1 means <input/output>0.txt, 2 means <input/output>00.txt
     */
    public HckrankCase(String location, byte numberFormat) {
        if (numberFormat < 1 || numberFormat > 3)
            throw new IllegalArgumentException("numberFormat value must be 1/2/3");

        this.location = location;
        input = new CaseFile("input", numberFormat);
        output = new CaseFile("output", numberFormat);
        createDirectory();
    }

    private boolean createDirectory() {
        return new File(location).mkdirs();
    }

    /**
     * After creating the test case file,
     * input & output will be renewed
     * 
     * @throws IOException
     */
    public void createFile() throws IOException {
        input.createFile(this.location);
        output.createFile(this.location);

        input.clear();
        output.clear();
    }

    // setter and getter
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(byte numberFormat) {
        this.numberFormat = numberFormat;
    }

}
