package app.dto;

import java.util.Date;

/**
 * Created by 52400 on 2017/6/30.
 */
public class CaseDTO {

    private Long id;

    private String caseName;

    private String caseCategory;

    private Date createTime;



    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
