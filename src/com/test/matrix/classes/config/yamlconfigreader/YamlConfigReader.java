package com.test.matrix.classes.config.YamlConfigReader;

import java.util.List;
import static java.lang.String.format;

public class YamlConfigReader {
    private GenInfo genInfo;
    private FileGenSettings fileGenSettings;
    private RandGenSettings randGenSettings;
    private List<String> calcOpsList;

    public GenInfo getGenInfo() {
        return genInfo;
    }

    public void setGenInfo(GenInfo genInfo) {
        this.genInfo = genInfo;
    }

    public FileGenSettings getFileGenSettings() {
        return fileGenSettings;
    }

    public void setFileGenSettings(FileGenSettings fileGenSettings) {
        this.fileGenSettings = fileGenSettings;
    }

    public RandGenSettings getRandGenSettings() {
        return randGenSettings;
    }

    public void setRandGenSettings(RandGenSettings randGenSettings) {
        this.randGenSettings = randGenSettings;
    }

    public List<String> getCalcOpsList() {
        return calcOpsList;
    }

    public void setCalcOpsList(List<String> calcOpsList) {
        this.calcOpsList = calcOpsList;
    }

    @Override
    public String toString() {
        return format("Gen info: %s\n", genInfo) +
                format("file gen settings: %s\n", fileGenSettings) +
                format("rand gen settings: %s\n", randGenSettings) +
                format("calc ops list: %s\n", calcOpsList);
    }
}
