package cn.edu.jxnu.rj.lrf.entity;

/**
 * 
 *
 * @author Michael Chow
 * @date 2021/04/18
 */
public class Image {
    /**
     * 图片id
     * image_id
     */
    private Integer imageId;

    /**
     * 帖子id
     * moment_id
     */
    private Integer momentId;

    /**
     * 图片路径
     * image_path
     */
    private String imagePath;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }
}