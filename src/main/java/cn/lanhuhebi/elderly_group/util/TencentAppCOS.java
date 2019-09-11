package cn.lanhuhebi.elderly_group.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName TencentAppCOS
 * @Author Oblivion
 * @Date 2019/9/9
 * @Version 1.0
 **/
public class TencentAppCOS {

    // 1 初始化用户身份信息（secretId, secretKey）。
    private static String secretId = "AKIDSyKYfhQz0LH61usNAh7JQSyMaaMxsRJ1";
    private static String secretKey = "wra6OYWEhx3vX3LYXHlz2ua1DLPEtKXs";
    private static COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
    private static Region region = new Region("ap-beijing");
    private static ClientConfig clientConfig = new ClientConfig(region);


    //存储桶名称，格式：BucketName-APPID
    private static String bucketName = "lxw-1258988357";


    // 上传文件
    public static String uploadImages(File localFile) {
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        String fileName =localFile.getName().substring(0, localFile.getName().lastIndexOf("."))  + UUID.randomUUID()  + System.currentTimeMillis() + localFile.getName().substring(localFile.getName().lastIndexOf("."));
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "/elderlyImages/" + fileName, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return fileName;
    }
}
