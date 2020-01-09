package com.wqwy.zhnm.base.component.constant;

import com.wqwy.zhnm.base.component.utils.PropertyUtil;

public class AliyunApiConstants {

	// oss
	public static final String PICTUREPREFIX = PropertyUtil.getProperty("ali_picture.picture_prefix");
	public static final String BUCKETNAME = PropertyUtil.getProperty("bucketName");
	public static final String REGION = PropertyUtil.getProperty("region");
	public static final String ALI_OSS_RAM_KEY = PropertyUtil.getProperty("ali_oss_ram_key");
	public static final String ALI_OSS_RAM_SECRET = PropertyUtil.getProperty("ali_oss_ram_secret");
	public static final String ALI_OSS_ROLE_ARN = PropertyUtil.getProperty("ali_oss_role_arn");
	public static final Integer ALI_OSS_TOKEN_EXPIRE = Integer.valueOf(PropertyUtil.getProperty("ali_oss_token_expire"));
	public static final String POLICY_FILE_PATH = "policy/all_policy.txt";
	
	// sms
	public static final String SMS_KEY = PropertyUtil.getProperty("ali_sms.key");
	public static final String SMS_SECRET = PropertyUtil.getProperty("ali_sms.secret");
	public static final String SMS_SIGN_NAME = PropertyUtil.getProperty("ali_sms.sign_name");
	
}
