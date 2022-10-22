package net.dnabil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dnabil
 */
public class CaseFile {
    public List<String> lines;
    private String fileName;
    private byte numberFormat = 3;
    private String numberFormatStr = "%0" + numberFormat + "d";
    private int counter = 0;

    /**
     * fileName: input/output.
     * numberFormat: implies qty of number exists in the file's format name (1-3).
     * ex : 1 means <input/output>0.txt, 2 means <input/output>00.txt
     */
    CaseFile(String fileName, byte numberFormat) {
        switch (fileName) {
            case "input":
                this.fileName = fileName;
                break;
            case "output":
                this.fileName = fileName;
                break;
            default:
                throw new IllegalArgumentException("CaseFile name should be \"input\" or \"output\"");
        }
        lines = new ArrayList<String>();
    }

    /**
     * Add a new line into the list with string as it's parameter.
     * use String.valueOf or String.format inside the parameter for more flexibility
     */
    public void addLine(String x) {
        lines.add(x);
    }

    public String getFileName() {
        return String.valueOf(fileName + String.format(numberFormatStr, counter) + ".txt");
    }

    private void addCounter() {
        counter++;
    }

    void createFile(String location) throws IOException {
        File file = new File(location + '/' + getFileName());
        file.createNewFile();

        PrintWriter w = new PrintWriter(file);
        if (lines.size() == 0) {
            w.print("");
        } else {
            for (String line : lines)
                w.println(line);
        }
        w.close();

        addCounter(); // to make file name unique
    }

    public void clear() {
        lines.clear();
    }
}
