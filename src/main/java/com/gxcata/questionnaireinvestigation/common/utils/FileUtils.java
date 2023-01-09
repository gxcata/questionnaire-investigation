package com.gxcata.questionnaireinvestigation.common.utils;

import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wanghailun
 * @date 2022年11月18日 9:40
 */
public class FileUtils {
    /**
     * 文件上传
     * @param file
     * @return
     */
    public static String uploadToLocal(MultipartFile file) throws IOException {
        // 获取文件原本的名字
        String originName = file.getOriginalFilename();
        // 判断文件是否是pdf文件
        Set<String> set = new HashSet<>();
        set.add(".jpg");
        set.add(".png");
        set.add(".gif");
        set.add(".jpeg");
        //png，JPEG，jpg，gif
        // 取出文件的后缀
        int count = 0;
        for(int i = 0; i < originName.length(); i++){
            if(originName.charAt(i) == '.'){
                count = i;
                break;
            }
        }
        //取出文件类型
        String endName = originName.substring(count);
        //文件类型
        String fileType = originName.substring(count + 1);
        if(!set.contains(endName)){
            throw new RRException("上传的文件类型错误,只能上传png,jpeg,jpg,gif类型的文件");
        }
        // 创建保存路径
        String savePath = "D:\\checkfile";
        // 保存文件的文件夹
        File folder = new File(savePath);
        // 判断路径是否存在,不存在则自动创建
        if(!folder.exists()){
            folder.mkdirs();
        }
        String saveName = originName + IdUtil.objectId();
        file.transferTo(new File(folder,saveName));
        String filePath = savePath + "\\" + saveName;
        return filePath;
    }
}
