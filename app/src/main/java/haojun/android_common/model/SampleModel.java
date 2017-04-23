package haojun.android_common.model;

/**
 * Created by haojun on 4/23/17.
 */

public class SampleModel {
    private int SampleId;
    private String SampleText;
    private int SampleInteger;

    public SampleModel(){

    }

    public SampleModel(int sampleId, String sampleText, int sampleInteger) {
        SampleId = sampleId;
        SampleText = sampleText;
        SampleInteger = sampleInteger;
    }

    public int getSampleId() {
        return SampleId;
    }

    public void setSampleId(int sampleId) {
        SampleId = sampleId;
    }

    public String getSampleText() {
        return SampleText;
    }

    public void setSampleText(String sampleText) {
        SampleText = sampleText;
    }

    public int getSampleInteger() {
        return SampleInteger;
    }

    public void setSampleInteger(int sampleInteger) {
        SampleInteger = sampleInteger;
    }
}
