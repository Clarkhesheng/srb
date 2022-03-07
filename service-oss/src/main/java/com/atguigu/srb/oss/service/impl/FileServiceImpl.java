package com.atguigu.srb.oss.service.impl;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.oss.service.FileService;
import com.atguigu.srb.oss.util.CertFileProperties;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file, String module, String fileName) {
        try {
            //// 创建OSSClient实例。
            //OSS ossClient = new OSSClientBuilder().build(
            //        OssProperties.ENDPOINT,
            //        OssProperties.KEY_ID,
            //        OssProperties.KEY_SECRET);
            //
            //// 判断BUCKET_NAME是否存在
            //if(!ossClient.doesBucketExist(OssProperties.BUCKET_NAME)){
            //    ossClient.createBucket(OssProperties.BUCKET_NAME);
            //    ossClient.setBucketAcl(OssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
            //}

            // 上传文件流。
            // 文件目录结构 "avatar/2021/02/27/uuid.jpg"
            //构建日期路径
            String timeFolder = new DateTime().toString("/yyyy/MM/dd/");
            //文件名生成
            fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
            String key = module + timeFolder + fileName;
            log.info("filename :"+CertFileProperties.BasePath + key);
            String fullFileName = CertFileProperties.BasePath + key;
            log.info("fullFileName :"+"D:/project/Cert/" + key);
            File newfile = new File("D:/project/Cert/" + key);
            if (!newfile.getParentFile().exists()) {
                newfile.getParentFile().mkdirs();
            }
            file.transferTo(newfile);

            //ossClient.putObject(OssProperties.BUCKET_NAME, key, inputStream);

            // 关闭OSSClient。
            //ossClient.shutdown();

            //文件的url地址
            //https:// bucketname   .  endpoint / + key
            return "/project/Cert/"+key;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR);
        }
    }

    @Override
    public void removeFile(String url) {

        //// 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(
        //        OssProperties.ENDPOINT,
        //        OssProperties.KEY_ID,
        //        OssProperties.KEY_SECRET);
        //
        //// https://srb-file-200921.oss-cn-beijing.aliyuncs.com/
        //// test/2021/02/27/f1673221-efb4-4356-98f4-9f0595caa927.jpg
        //String host = "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/";
        //String objectName = url.substring(host.length());
        //
        //// 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        //ossClient.deleteObject(OssProperties.BUCKET_NAME, objectName);
        //
        //// 关闭OSSClient。
        //ossClient.shutdown();
        File file = new File(url);
        if (file.exists()){
            file.delete();
        }
    }
}
