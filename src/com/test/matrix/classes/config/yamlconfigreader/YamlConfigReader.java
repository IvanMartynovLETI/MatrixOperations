package com.test.matrix.classes.config.yamlconfigreader;

import java.util.List;

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
        return "Gen info: %s\n" + genInfo +"\n" +
                "file gen settings: %s\n" + fileGenSettings + "\n" +
                "rand gen settings: %s\n" + randGenSettings + "\n" +
                "calc ops list: %s\n" + calcOpsList;
    }
}
