package cn.edu.jxnu.rj.lrf.entity;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Province {
    /**
     * 
     * pid
     */
    private Integer pid;

    /**
     * 
     * province
     */
    private String province;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}