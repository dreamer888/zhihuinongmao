package com.yq.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.ListBucketsRequest;
import com.aliyun.oss.model.PutObjectRequest;

/**
 * @author zangmaoyuan
 *2018-5-26
 * 
 */
public class ALiYunOss{
	
	private static String endpoint ="";
    private static String accessKeyId = "";
    private static String accessKeySecret ="";
    private static String bucketName_CategorySort = "";
    private static String bucketName_GoodsSort = "";//
    private static String bucketName_Banner = "";
    private static String urls = "";
    
	/**
	 * 读取配置文件
	 */
	public static void getProperties(){
		
		try {
	    	  Properties prop = null;
	    	  prop = PropertiesLoaderUtils.loadAllProperties("oss.properties");
	    	  endpoint = prop.getProperty("endpoint");
	    	  accessKeyId = prop.getProperty("accessKeyId");
	    	  accessKeySecret = prop.getProperty("accessKeySecret");
	    	  bucketName_CategorySort = prop.getProperty("bucketName_CategorySort");
	    	  bucketName_GoodsSort = prop.getProperty("bucketName_GoodsSort");//
	    	  bucketName_Banner = prop.getProperty("bucketName_Banner");
	          } catch (IOException e) {
	              e.printStackTrace();     
	         }
	}
	
	/**
	 * 蔬菜分类存入阿里存储器
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String CategorySortupLoadImg(File file) throws IOException{
		
		/**
		 * read properties 
		 */
		getProperties();
		UUID key = UUID.randomUUID();
		urls =  key.toString();
		
        /**
         * Constructs a client instance with your account for accessing OSS
         */
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {

            /**
             * Determine whether the bucket exists
             */
            if (!ossClient.doesBucketExist(bucketName_CategorySort)) {
               
            	/**
                 * Create a new OSS bucket
                 */
                ossClient.createBucket(bucketName_CategorySort);
                CreateBucketRequest createBucketRequest= new CreateBucketRequest(bucketName_CategorySort);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            
            /**
             * 
             */
            ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
            listBucketsRequest.setMaxKeys(500);
            ossClient.putObject(new PutObjectRequest(bucketName_CategorySort, key.toString(), file));
            file.delete();
        } catch (OSSException oe) {
            oe.getErrorCode();
            oe.getErrorCode();
            oe.getRequestId();
            oe.getHostId();
        } catch (ClientException ce) {
           ce.getMessage();
        } finally {
            ossClient.shutdown();
        }	
        return urls;
	}
	
	/**
	 * 具体商品上传
	 */
	public static String goodsSortupLoadImg(File file) throws IOException{

		getProperties();
		UUID key = UUID.randomUUID();
		urls =  key.toString();
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            if (!ossClient.doesBucketExist(bucketName_GoodsSort)) {
                ossClient.createBucket(bucketName_GoodsSort);
                CreateBucketRequest createBucketRequest= new CreateBucketRequest(bucketName_GoodsSort);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
            listBucketsRequest.setMaxKeys(500);
            ossClient.putObject(new PutObjectRequest(bucketName_GoodsSort, key.toString(), file));
            file.delete();
        } catch (OSSException oe) {
            oe.getErrorCode();
            oe.getErrorCode();
            oe.getRequestId();
            oe.getHostId();
        } catch (ClientException ce) {
           System.out.println("Error Message: " + ce.getMessage());
        } finally {
            ossClient.shutdown();
        }	
        return urls;
	}
	
	
}
