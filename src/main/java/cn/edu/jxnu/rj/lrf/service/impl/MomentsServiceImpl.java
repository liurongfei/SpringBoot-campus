package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.CommentMapper;
import cn.edu.jxnu.rj.lrf.dao.ImageMapper;
import cn.edu.jxnu.rj.lrf.dao.MomentsMapper;
import cn.edu.jxnu.rj.lrf.entity.Moments;
import cn.edu.jxnu.rj.lrf.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service("dynamicService")
public class MomentsServiceImpl implements MomentsService {
//    @Autowired
//    MomentsMapper dynamicDao;
//    @Autowired
//    CommentMapper commentDao;
//    @Autowired
//    ImageMapper imageDao;
//
//    @Autowired
//    StringRedisTemplate template;
//
//    @Override
//    public void post(Dynamic dynamic,List<String> imagePath) {
//        dynamicDao.insert(dynamic);//用户发表动态
//
////        template.opsForList().leftPush("campus:dynamic:latest",dynamic.getDynamicId()+"");
////        template.opsForList().trim("campus:dynamic:latest",0,4999);
//
//        int dynamicId = dynamic.getDynamicId();
//
//        if(imagePath.size()>0){
//           imageDao.insertToList(dynamicId,imagePath);
//        }
//    }
//
//    @Override
//    public List<Dynamic> getAllByUserId(int userId,int localUserId) {
//        return dynamicDao.findByUserId(userId,localUserId);
//    }
//
//    @Override
//    public List<Dynamic> getLatest(int start, int nums, int userId) {
//        //从缓存中获取最近的动态列表id
//        List<String> list = template.opsForList().range("campus:dynamic:latest", start, (start + nums - 1));
//        System.out.println(start+","+nums+","+userId);
//        List<Dynamic> dynamics = null;
//        //如果已经超过了redis存储的动态数量，则向mysql查询
//        if(list.size()<nums){
//            list = dynamicDao.getLatest(start, nums);
//        }
//        if(list.size()!=0){
//            dynamics = dynamicDao.getByIdSet(list, userId);
//        }
//        System.out.println("dynamic is :》"+dynamics);
//        return dynamics;
//    }
//
//    @Override
//    public void delete(int dynamicId, String path) {
//        //分别删除MySQL中的动态记录，动态内的评论、点赞记录
//        dynamicDao.deleteDynamic(dynamicId);
//        commentDao.deleteAllByWork(0,dynamicId);
//        giveLikeDao.deleteAllByWork(0,dynamicId);
//
//        //删除redis缓存中的记录
////        jedis.lrem("campus:dynamic:latest",1,dynamicId+"");
//        template.opsForList().remove("campus:dynamic:latest",1,dynamicId+"");
//
//        //获取图片集合并删除数据库记录
//        List<String> imagePaths = imageDao.getAll(dynamicId);
//        if(imagePaths.size()>0){
//            //删除保存在服务器的动态图片
//            for (int i = 0; i < imagePaths.size() ; i++) {
//                if(imagePaths.get(i)!=null){
//                    System.out.println(imagePaths.get(i));
//                    File file = new File(path+"\\"+imagePaths.get(i).substring(6));
//                    System.out.println("要删除的文件是:"+path+"\\"+imagePaths);
//                    if(file.exists()){
//                        file.delete();
//                    }else {
//                        System.out.println("文件不存在！");
//                    }
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public Dynamic findById(int dynamicId,int userId) {
//        Dynamic dynamic = dynamicDao.findById(dynamicId,userId);
//        System.out.println(dynamic);
//        return dynamic;
//    }
}
