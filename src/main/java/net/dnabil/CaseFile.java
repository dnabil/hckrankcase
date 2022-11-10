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

    // Printing methods
    public void println(Object x) {
        lines.add(x.toString());
    }

    public void printf(String format, Object... args) {
        int lastIndex = lines.size() - 1;
        if (lastIndex == -1) { // if lines is empty
            lines.add("");
            lastIndex++;
        }
        String temp = lines.get(lastIndex) + String.format(format, args);
        lines.set(lastIndex, temp);
    }

    protected String getFileName() {
        return fileName;
    }

    public String getFormattedFileName() {
        return String.valueOf(fileName + String.format(numberFormatStr, counter) + ".txt");
    }

    private void addCounter() {
        counter++;
    }

    void createFile(String location) throws IOException {
        File file = new File(location + '/' + getFormattedFileName());
        file.createNewFile();

        if (lines.size() != 0) {
            PrintWriter w = new PrintWriter(file);
            for (int i = 0; i < lines.size(); i++)
                if (i == lines.size() - 1)
                    w.print(lines.get(i));
                else
                    w.println(lines.get(i));
            w.close();
        } // else -> there's no line to print
        addCounter(); // to make file name unique
    }

    public void clear() {
        lines.clear();
    }
}
