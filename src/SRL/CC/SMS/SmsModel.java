/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.CC.SMS;

/**
 *
 * @author M.Faisal1521
 */
public class SmsModel {

    private Integer Sequence;
    private String RowStatus;
    private String TemplateName;
    private String TemplateMessage;
    private String Attribute1;
    private String Attribute2;
    private String Attribute3;

    SmsModel(int size) {
        this.Sequence = size;
        this.RowStatus = "I";
    }

    @Override
    public String toString() {
        return "SmsModel{" + "TemplateName=" + getTemplateName() + ", TemplateMessage=" + getTemplateMessage() + ", Attribute1=" + getAttribute1() + ", Attribute2=" + getAttribute2() + ", Attribute3=" + getAttribute3() + '}';
    }

    public SmsModel(Integer Sequence, String TemplateName, String TemplateMessage, String Attribute1, String Attribute2, String Attribute3) {
        this.Sequence = Sequence;
        this.TemplateName = TemplateName;
        this.TemplateMessage = TemplateMessage;
        this.Attribute1 = Attribute1;
        this.Attribute2 = Attribute2;
        this.Attribute3 = Attribute3;
    }

    /**
     * @return the Sequence
     */
    public Integer getSequence() {
        return Sequence;
    }

    /**
     * @param Sequence the Sequence to set
     */
    public void setSequence(Integer Sequence) {
        this.Sequence = Sequence;
    }

    /**
     * @return the TemplateName
     */
    public String getTemplateName() {
        return TemplateName;
    }

    /**
     * @param TemplateName the TemplateName to set
     */
    public void setTemplateName(String TemplateName) {
        this.TemplateName = TemplateName;
    }

    /**
     * @return the TemplateMessage
     */
    public String getTemplateMessage() {
        return TemplateMessage;
    }

    /**
     * @param TemplateMessage the TemplateMessage to set
     */
    public void setTemplateMessage(String TemplateMessage) {
        this.TemplateMessage = TemplateMessage;
    }

    /**
     * @return the Attribute1
     */
    public String getAttribute1() {
        return Attribute1;
    }

    /**
     * @param Attribute1 the Attribute1 to set
     */
    public void setAttribute1(String Attribute1) {
        this.Attribute1 = Attribute1;
    }

    /**
     * @return the Attribute2
     */
    public String getAttribute2() {
        return Attribute2;
    }

    /**
     * @param Attribute2 the Attribute2 to set
     */
    public void setAttribute2(String Attribute2) {
        this.Attribute2 = Attribute2;
    }

    /**
     * @return the Attribute3
     */
    public String getAttribute3() {
        return Attribute3;
    }

    /**
     * @param Attribute3 the Attribute3 to set
     */
    public void setAttribute3(String Attribute3) {
        this.Attribute3 = Attribute3;
    }


}
