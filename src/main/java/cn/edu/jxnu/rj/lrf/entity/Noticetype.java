package cn.edu.jxnu.rj.lrf.entity;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Noticetype {
    /**
     * 
     * type_id
     */
    private Integer typeId;

    /**
     * 
     * type_name
     */
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}