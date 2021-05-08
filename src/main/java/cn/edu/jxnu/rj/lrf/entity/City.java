package cn.edu.jxnu.rj.lrf.entity;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class City {
    /**
     * 城市名
     * city
     */
    private String city;

    /**
     * 
     * cid
     */
    private Integer cid;

    /**
     * 所在省份
     * pid
     */
    private Integer pid;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}