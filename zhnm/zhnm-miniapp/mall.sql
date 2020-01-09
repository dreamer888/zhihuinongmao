/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-12-14 14:29:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shop_address`
-- ----------------------------
DROP TABLE IF EXISTS `shop_address`;
CREATE TABLE `shop_address` (
  `ADDRESS_ID` varchar(100) NOT NULL,
  `ADDR_REALNAME` varchar(255) DEFAULT NULL COMMENT '联系人',
  `ADDR_PHONE` varchar(255) DEFAULT NULL COMMENT '手机号',
  `ADDR_CITY` varchar(255) DEFAULT NULL COMMENT '省市区',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '地址',
  `ADDTIME` varchar(255) DEFAULT NULL COMMENT '时间',
  `IS_DEFAULT` varchar(255) DEFAULT NULL COMMENT '默认',
  `USER_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_address
-- ----------------------------
INSERT INTO `shop_address` VALUES ('00ca222125c2497290b5d4aae603ca16', '3333', '13584869541', '江苏省 南京市 玄武区', '10号', '2017-06-12 09:58:18', '1', '08f6e4dd62d843bbaf63eae75903fdc1');
INSERT INTO `shop_address` VALUES ('082b9d384a8b49509a5dcfd3d31f98d3', '啊啊啊', '13666666666', '江苏省 南京市 玄武区', '啊啊啊', '2017-08-21 10:37:01', '1', '3c8b3a6655314690a5953920c58ae66e');
INSERT INTO `shop_address` VALUES ('0bdd617dddad49f4829afeeefcd82de2', '收货人1', '13111111111', '江苏省 南京市 玄武区', '会稽花园 10 幢 312', '2017-11-07 09:04:24', '', 'd0ff81700959420a85cf30234f4f44bb');
INSERT INTO `shop_address` VALUES ('0e1d845a61d44e4484b323571bc2399d', '吧', '18521529110', '江苏省 南京市 玄武区', '4888', '2017-10-08 10:17:32', '1', '2bfc523f23d3497fb3c42c15c33b1031');
INSERT INTO `shop_address` VALUES ('0ff6ac37c8a845b093fe106f5d74339c    ', '啊习', '18888888888', '江苏省 南京市 玄武区', '哈哈哈哈哈哈哈哈哈哈哈哈还吃过啊啊啊', '2017-08-28 17:31:04', '1', '98ca6a4d667f4e9689f33f3006b0322f');
INSERT INTO `shop_address` VALUES ('13b8a58a1df249c68f18aef55a3fff49 ', '张三', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道玄武大道299号汇景佳园1栋1101室', '2017-05-06 21:36:52', '1', '16');
INSERT INTO `shop_address` VALUES ('20cfd5e11029441f9e60332fab9fa1cb', 'a', '18681727333', '江苏省 南京市 玄武区', '测试', '2017-11-24 14:19:37', '1', 'fc2d41d465f440ec82ffafd9e271bf28');
INSERT INTO `shop_address` VALUES ('2613b9f0c28a453cab25a2a5508190ce', 'ghj', '18072194067', '江苏省 南京市 玄武区', '对比就不计较。', '2017-08-18 14:51:20', '1', 'b4c3e8730dfa46f88780fe9aaff244f4');
INSERT INTO `shop_address` VALUES ('29481cb4ac714597b33f1d5d6c911323', '港股', '15822222222', '江苏省 南京市 玄武区', '中山路', '2017-11-14 15:37:15', '1', '6a8c8b3f73e8482d82f486e93feb54b8');
INSERT INTO `shop_address` VALUES ('29a7dbbe8de44b2cb72b0cb250fd2e64', '哦哦哦', '13522556554', '江苏省 南京市 玄武区', '来咯哦了急用', '2017-11-17 11:33:14', '0', 'd2ec5978ed154401864ec2fa14589676');
INSERT INTO `shop_address` VALUES ('2a359715c15641938f7ee1b184f39931', '厕测试', '188888888888', '江苏省 南京市 玄武区', '测试地址', '2017-07-29 11:59:29', '1', 'adfdb3a5f09040768a2f952437792fe1');
INSERT INTO `shop_address` VALUES ('2ce10342fd994e9a9aad7d97eebab39b', '呃呃呃', '332', '江苏省 南京市 玄武区', 'lodging', '2017-06-07 22:59:42', '1', 'f434ed76968745e8872a009eb95bf7b7');
INSERT INTO `shop_address` VALUES ('31ba296fc47548a8805503273846a0bc', 'uuuuu', '15277777', '北京市,北京市', 'uuuu', '2017-03-16 18:03:25', '0', '7');
INSERT INTO `shop_address` VALUES ('31e2b0c28911495eac1d8e786972e046', '小莉', '13585884553', '江苏省 南京市 玄武区', '11号', '2017-11-06 20:15:15', '1', '6c8d3c22a2724d46be22198ed6896bc1');
INSERT INTO `shop_address` VALUES ('32a6b795888a4b14a26cca5f61176e07', 'wangxiaona', '13800138000', 'jiangsunanjing', 'beijing******', '2017-03-16 17:50:45', '0', '7');
INSERT INTO `shop_address` VALUES ('3c9e78b0109b48e69b7ff9367b84dca1', 'zhangsan', '13800138000', 'beijing', 'shuianmingzhu', '2017-02-21 16:00:11', '0', '1');
INSERT INTO `shop_address` VALUES ('41dcc7e5f62c44b1a98bf8520164519b', 'tutu', '1144', '江苏省 南京市 玄武区', 'j l l', '2017-11-12 16:51:42', '1', '914548c8208f459abaab6a1edfbdcb66');
INSERT INTO `shop_address` VALUES ('432a1e351a2f462388e37e98e8df1d9d', 'zhangsan', '13800138000', 'jiangsunanjing', 'shuianmingzhu', '2017-02-21 15:58:14', '0', '1');
INSERT INTO `shop_address` VALUES ('43d3dbcbffe948c49f37374b0da5bbe9 ', '刘先生', '18191069854', '陕西省 西安市 莲湖区', '汉城北路', '2017-12-02 15:40:34', '1', '0c40d1a9047e49ed82f93d115997774f');
INSERT INTO `shop_address` VALUES ('475269e5530948bfb0bdc0f33a1da3f5', '喝喝喝', '114', '江苏省 南京市 玄武区', '哈哈哈哈', '2017-09-19 16:37:58', '1', '9266bb3662694dee959ba8232e3f5b12');
INSERT INTO `shop_address` VALUES ('483815e565ee4b52ab1953f7c5b3089a', '哦哦哦', '13522556554', '江苏省 南京市 玄武区', '来咯哦了急用', '2017-11-17 11:33:05', '0', 'd2ec5978ed154401864ec2fa14589676');
INSERT INTO `shop_address` VALUES ('49001d207e1043e1b2159d3ef95b4970', '哦哦哦', '13522556554', '江苏省 南京市 玄武区', '来咯哦了急用', '2017-11-17 11:33:16', '1', 'd2ec5978ed154401864ec2fa14589676');
INSERT INTO `shop_address` VALUES ('4f82d0149fc04589b1784f4ec9a77968', '秦淮', '18201632858', '北京 北京市 丰台区', '翠海', '2017-11-17 18:11:46', '1', 'c5de0f47ccab4f7da32b9c173f62edfc');
INSERT INTO `shop_address` VALUES ('5022f2ec6dab4c14ac1205f94d4993d0', '1', '188888888', '江苏省 南京市 玄武区', '123', '2017-10-23 17:08:41', '1', '2dd371f206644d24979a270ab0449544');
INSERT INTO `shop_address` VALUES ('524b738034224445b4a569d58648ce91', 'jw', '15191585858', '江苏省 南京市 玄武区', '撒娇', '2017-05-27 15:27:16', '1', '657eb8252e3c4861a898b757dc7117b5');
INSERT INTO `shop_address` VALUES ('578a5f117fcb4daf942af175e6d060f1', 'nananana', '15555555', 'jiangsunanjing', 'beijing******', '2017-03-16 17:50:44', '0', '7');
INSERT INTO `shop_address` VALUES ('583802ad427a40769e80f027c4f7f773', 'test', '138888888888', '江苏省 南京市 玄武区', 'test 不要发货', '2017-11-30 23:55:15', '1', 'd98fa1f741814d52930f0016905e81c6');
INSERT INTO `shop_address` VALUES ('5cab67a217164cf193a380ea59230b91', '班', '13013013013', '江苏省 南京市 玄武区', '了哦哦哦', '2017-10-18 19:44:13', '1', 'a1d4b699269d45b8aa66d9687395a186');
INSERT INTO `shop_address` VALUES ('6835794bfd7d4f38a77539623e7b0c88', '习主席', '13800138000', '江西省 南昌市 市辖区            ', '哈哈', '2017-11-17 19:43:13', '0', 'dc4c0243eb694bbf9ece88b715460998');
INSERT INTO `shop_address` VALUES ('6c0099ca2bf340508ce1fa523de205e7', '啦啦', '15248521485', '江苏省 南京市 玄武区', '出了', '2017-10-18 15:16:50', '1', '573935adc1f34aa2be3b06c8e0fce9a0');
INSERT INTO `shop_address` VALUES ('6f0d6855f41c4291b763d2c442ee7969', '哈哈', '1888888888', '江苏省 南京市 玄武区', '555', '2017-09-01 16:33:56', '', '98ca6a4d667f4e9689f33f3006b0322f');
INSERT INTO `shop_address` VALUES ('6f45d5f402c045368ce986cf1ca73be2', '1', '13812831526', '江苏省 南京市 玄武区', '111', '2017-06-09 22:07:13', '1', '9b2b6c0f6ba1403688a312de0b9194eb');
INSERT INTO `shop_address` VALUES ('70b49c623d1b4a8eaead87b5060f461d', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '2017-05-26 14:46:15', '1', 'e60c3b041ecf43a691fc7639f9817898');
INSERT INTO `shop_address` VALUES ('7b5edc3bcae0456194705dceea50ed72 ', 'hi', '13715063658', '安徽省 合肥市 蜀山区', '442542', '2017-09-11 08:50:59', '1', '30a4338cb04a46899bb78b5a34c6e561');
INSERT INTO `shop_address` VALUES ('80540d091ee849fe945fb87a9cad63d8', '李佐洋', '17752846201', '江苏省 南京市 玄武区', '我家', '2017-09-22 20:48:25', '1', 'bed5bb5f6ea0441d826ff10c8ff6159b');
INSERT INTO `shop_address` VALUES ('91c5d922954a4f75a03067ec7c30010b', '侯先生', '13617418488', '江苏省 南京市 玄武区', '街道', '2017-08-22 12:45:32', '1', '6ae7654206e645e7974cda1c7f84cfce');
INSERT INTO `shop_address` VALUES ('91f38776c7ed4ce4adc0ff956b71fa19', '1', '1', '北京 北京市 东城区', '1', '2017-12-04 20:37:24', '1', 'db9450f0e5eb482badc31721fcbdbf61');
INSERT INTO `shop_address` VALUES ('9661d6fc80894523a6d60be5c2092cb4', '吃', '158424516', '江苏省 南京市 玄武区', '就回你', '2017-11-01 16:07:25', '1', 'fff46e48c6224b70bce05da586e832ae');
INSERT INTO `shop_address` VALUES ('97de642a56574b6a8f97d4d2cc9f9619 ', '李俊奕', '18605259288', '江苏省 镇江市 扬中市', '三茅街道长江花城四期25幢702室', '2017-08-03 08:38:30', '1', 'b0d8d29bb74a46deb667d09ec13f37d3');
INSERT INTO `shop_address` VALUES ('9abacff0efea4ebb8b9ba2a8e35f6b58 ', '石峰', '13579020022', '新疆维吾尔自治区 巴音郭楞蒙古自治州 库尔勒市', '了', '2017-10-18 22:05:12', '1', 'f31eab0144f24784b3dfb64e924ddc1c');
INSERT INTO `shop_address` VALUES ('aaf45d86a803459d95e134909da4c51c', '哈哈', '13800138000', '江苏省 南京市 玄武区', 'huijingjiayuan3301', '2017-07-21 22:28:36', '', 'e60c3b041ecf43a691fc7639f9817898');
INSERT INTO `shop_address` VALUES ('abd0923531b946c3a1f10d798f02e06e', '还', '138888888888888', '山西省 太原市 市辖区      ', '刚回来吉利哼哼唧唧吉里吉里吉里吉里吉里吉里吉里吉里丽丽', '2017-11-17 19:43:31', '0', 'dc4c0243eb694bbf9ece88b715460998');
INSERT INTO `shop_address` VALUES ('ac2c02521c4a4c02af0d54176672c5a1', '千派', '13800138000', '江苏省 南京市 玄武区', '郊区书好工作10栋1068室', '2017-05-26 22:15:41', '1', 'bcffb188c37d43f3a220e9983ae52a9e');
INSERT INTO `shop_address` VALUES ('b10956b2e55744a0bc9fb6cbc8e8426a', '11', '13824372371', '江苏省 南京市 玄武区', '了了了了扣扣图兔兔', '2017-10-14 17:56:56', '1', '10f1e52f4b864159a6fa432b7f11b2d7');
INSERT INTO `shop_address` VALUES ('b174f595fc344b7c925020cd2076fa2c', '单独的', '885', '江苏省 南京市 玄武区', '吃吃吃v', '2017-11-24 16:22:50', '1', '46f482f96fbd40adb3aabdd3b8b8d7f8');
INSERT INTO `shop_address` VALUES ('b584d37d47104ee3ac8d61031c902e20', '我们', '152199999999', '北京市,北京市', '我的心是最大限度的', '2017-03-20 16:51:29', '1', '7');
INSERT INTO `shop_address` VALUES ('bb3022fb878c4034a6f159e317e72466', '罢了', '12365478963', '江苏省 南京市 玄武区', '酷兔兔', '2017-10-20 13:31:32', '1', 'd561106cf91940899f3cf8e9e3bad284');
INSERT INTO `shop_address` VALUES ('be81235bb703452d88652d30841c2af8', '不良记录', '150424242424', '江苏省 南京市 玄武区', '255585', '2017-11-10 15:00:55', '1', '93b7cb4ea77a4ea683d0f30bf55fa00f');
INSERT INTO `shop_address` VALUES ('beb5909ef11441e7b6841514e279baf4', 'mysun', '13172788888', '江苏省 南京市 玄武区', '中山大学', '2017-10-10 17:26:55', '1', 'cae2178052264db1a6f475ac89347a93');
INSERT INTO `shop_address` VALUES ('c06c24661ba248e0885bb49ccc74fbec', '景', '15191585815', '陕西省 西安市 未央区', '谢谢', '2017-05-27 15:03:39', '1', '5e2c3aa1d87e4cd399a5315224592430');
INSERT INTO `shop_address` VALUES ('c138d2bbcfeb428d9b96ecec562610d2', 'zhangsan', '13800138000', 'jiangsunanjing', 'shuianmingzhu', '2017-02-21 16:01:01', '1', '1');
INSERT INTO `shop_address` VALUES ('c20078d209234c7ba4c7f6d182a97f03', '12', '12', '江苏省 南京市 玄武区', '12', '2017-09-29 13:30:52', '1', '8ef911a19d434537931659008a08477d');
INSERT INTO `shop_address` VALUES ('c33583ede0a546798e250da13c3b1e1d', '闫繁宇', '18017912555', '江苏省 南京市 玄武区', '你好', '2017-10-24 19:46:33', '1', '81cfab13adb04aec953bcdd68defa863');
INSERT INTO `shop_address` VALUES ('c72309150d054a53be2868bc0cc6eef3 ', '啊啊啊', '18957710188', '江苏省 南京市 玄武区', '2255525', '2017-07-21 21:33:15', '1', '24618ce046b74d58b34d8a3cc594db25');
INSERT INTO `shop_address` VALUES ('c7bd6f17d8a6402bb93110e8534cc2b1', '哈哈', '123456789', '江苏省 南京市 玄武区', '哈哈', '2017-10-20 00:30:01', '1', '6339c3f3957a44bbad923c21e4b0a70c');
INSERT INTO `shop_address` VALUES ('cffec5a08e2a419d82cb71e19bad62a0', '噢噢噢', '15161527802', '江苏省 南京市 玄武区', '可垃圾咯看累了', '2017-08-08 06:35:50', '1', '7a45a941cb8446aaaff8bc98c862296b');
INSERT INTO `shop_address` VALUES ('d826ebca01f84324ab393162b181722c', '吃', '158424516', '江苏省 南京市 玄武区', '就回你', '2017-11-01 16:07:24', '0', 'fff46e48c6224b70bce05da586e832ae');
INSERT INTO `shop_address` VALUES ('ea3fa58af26f4e49af2236f79252c68c', 'ABC', '13579020022', '江苏省 南京市 玄武区', 'abc', '2017-10-10 23:34:34', '0', 'f31eab0144f24784b3dfb64e924ddc1c');
INSERT INTO `shop_address` VALUES ('ee19c6e10ac54a06b46ebba79c0643b9  ', '张敏', '13184235048', '江苏省 南京市 玄武区', '玄武湖街道玄武大道299号汇景佳园1栋1101室', '2017-05-05 19:44:52', '0', '16');
INSERT INTO `shop_address` VALUES ('ef2cbafc03844da1aac8a2b3a696b262', '杨安斌', '15281169672', '江苏省 南京市 玄武区', '呵呵', '2017-08-18 11:44:15', '1', 'af84d8ed7d33482fbde06da1418fcfad');
INSERT INTO `shop_address` VALUES ('efc378564a614d45b25d2088e3b631fe', '张大', '18650124560', '福建省 厦门市 湖里区', '垃圾', '2017-11-07 00:23:56', '1', 'acf343229dfd41428279445fd6c734d2');
INSERT INTO `shop_address` VALUES ('f45686d7911846d6918d5d0569044aa9', 'zhangsan', '13800138000', 'jiangsunanjing', 'shuianmingzhu', '2017-02-21 15:56:42', '0', '1');
INSERT INTO `shop_address` VALUES ('f4b880f200864ad79b58ed7c3c7a0afb', '1', '1', '北京市,北京市', '哈德门', '2017-03-19 10:07:10', '1', '11');
INSERT INTO `shop_address` VALUES ('fc67a56b2f6040cba7665d4ae07417ba', '包晋升', '13721103139', '江苏省 南京市 玄武区', '天山路60号', '2017-09-01 18:08:11', '1', '07573ce2135a41abbcefdcbc7a4b6fd2');
INSERT INTO `shop_address` VALUES ('fd32ae7a0b5d445b86fd057af2f13afe', '1', '188888888', '江苏省 南京市 玄武区', '123', '2017-10-23 17:08:31', '0', '2dd371f206644d24979a270ab0449544');

-- ----------------------------
-- Table structure for `shop_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `shop_attribute`;
CREATE TABLE `shop_attribute` (
  `attribute_id` varchar(100) NOT NULL,
  `attribute_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品id',
  `super_id` varchar(32) DEFAULT NULL COMMENT '0一级名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_attribute
-- ----------------------------
INSERT INTO `shop_attribute` VALUES ('0fdba7882d864b1ca48ea1821839ad01', '4.0', 'adfd9081d38347a783d9f08625228d4e', '1ce73cf45392488cb2000f5fce4cc7ca', '2');
INSERT INTO `shop_attribute` VALUES ('105fed71663b4b449689b97af5df8801', '黑色', '640554e89f144d61916f4c7660cad5e7', '34b10576804e439d96c1e53c3fa9573d', '1');
INSERT INTO `shop_attribute` VALUES ('13b944829f4842dca7275f61affe311b', '存储', '210d59848d2a4f848c5c3c6556732cfb', '0', '2');
INSERT INTO `shop_attribute` VALUES ('159d1d0d5fa04dad8cbc35e9ab43956d', '300ml', 'b8f5fcc6e4e24b6a807905037e23911e', 'f3a187fb822d49ef992b5b46157e4d63', '1');
INSERT INTO `shop_attribute` VALUES ('1a5ccb8f88cd48549cfa7838ca1dd07d', '4G全网通', '210d59848d2a4f848c5c3c6556732cfb', 'a5b4c370636a4d69a866972024c99de9', '0');
INSERT INTO `shop_attribute` VALUES ('1ab7cc51e2ab40899e0174275ef3aa49', 'SI/小瑕', '627f21ccf893421ead0be760f9f8c01d', '5bf6f42af83b4db499b76d7c0ecd707d', '0');
INSERT INTO `shop_attribute` VALUES ('1adf8b4e3c21423f97397651d83844bc', '4.0', 'bb021b7d26ce4015a0117bbc46ca6d0d', '6cabaeb57fd0493d93473d45e05622b1', '1');
INSERT INTO `shop_attribute` VALUES ('1c56c183391f44bab211615517f96096', '64G', '47560d41556c4c96b14f7d1d98936f16', '924286240bbd4bf8860544453c4413c3', '0');
INSERT INTO `shop_attribute` VALUES ('1cca056d6a994dca8d1c7619426f4fe2', '银色', '640554e89f144d61916f4c7660cad5e7', '34b10576804e439d96c1e53c3fa9573d', '3');
INSERT INTO `shop_attribute` VALUES ('1ce73cf45392488cb2000f5fce4cc7ca', '尺寸', 'adfd9081d38347a783d9f08625228d4e', '0', '1');
INSERT INTO `shop_attribute` VALUES ('268b542f3a6e4c5794c3dc569774e305', '4.5', 'adfd9081d38347a783d9f08625228d4e', '1ce73cf45392488cb2000f5fce4cc7ca', '1');
INSERT INTO `shop_attribute` VALUES ('26f5f5f7595c4f57ada8c399bc73fb4d', '黑色', '05b87c4206da4c8e81ae774317248725', '88b6ccc1b28a45dfbaceef6a8c715f34', '2');
INSERT INTO `shop_attribute` VALUES ('2878a674d38248a7af34aab441911b77', '颜色', '588a36ece2c14028a09b99f0287e4be9', '0', '0');
INSERT INTO `shop_attribute` VALUES ('29879ff32b9d470faf3962ae20c593c5', '红色', 'adfd9081d38347a783d9f08625228d4e', '6fcde77169734f768f6fca9fda1240b6', '1');
INSERT INTO `shop_attribute` VALUES ('29e55103aa9b4834a2aa716659a9b63d', '红色', '588a36ece2c14028a09b99f0287e4be9', '2878a674d38248a7af34aab441911b77', '1');
INSERT INTO `shop_attribute` VALUES ('2cd8d0204a534be7ae1fd3e2e16cd3d3', '64G', '210d59848d2a4f848c5c3c6556732cfb', '13b944829f4842dca7275f61affe311b', '0');
INSERT INTO `shop_attribute` VALUES ('30c0f07840784389b8ebdfe52bc632c4', '128G', '640554e89f144d61916f4c7660cad5e7', 'faf2c5b458d244b2bd073e977123d291', '2');
INSERT INTO `shop_attribute` VALUES ('3105f4867745455eab2021cef9f1e499', '红酒透亮睡眠', 'b8f5fcc6e4e24b6a807905037e23911e', '3671e2ea88be44709b556ff0d968bc09', '2');
INSERT INTO `shop_attribute` VALUES ('34b10576804e439d96c1e53c3fa9573d', '颜色', '640554e89f144d61916f4c7660cad5e7', '0', '0');
INSERT INTO `shop_attribute` VALUES ('3671e2ea88be44709b556ff0d968bc09', '系列', 'b8f5fcc6e4e24b6a807905037e23911e', '0', '0');
INSERT INTO `shop_attribute` VALUES ('3b0dca635a464141baa435c25e801965', '金色', '640554e89f144d61916f4c7660cad5e7', '34b10576804e439d96c1e53c3fa9573d', '0');
INSERT INTO `shop_attribute` VALUES ('4b970b08055a4b80966ee4f5b42188ce', '香槟金', '210d59848d2a4f848c5c3c6556732cfb', 'fa9be047396f4d078674b5a1e60ead11', '1');
INSERT INTO `shop_attribute` VALUES ('57f9276155304a0ca981134174c60870', '5.0', '588a36ece2c14028a09b99f0287e4be9', '7500ccd032d64db197fb79fa30e6e545', '0');
INSERT INTO `shop_attribute` VALUES ('5bf6f42af83b4db499b76d7c0ecd707d', '净度', '627f21ccf893421ead0be760f9f8c01d', '0', '0');
INSERT INTO `shop_attribute` VALUES ('5ef1197e557940a5bf638ca3f70f5088', '1克拉', '627f21ccf893421ead0be760f9f8c01d', '8ce17dffd4774a03873b86d575bbaae4', '1');
INSERT INTO `shop_attribute` VALUES ('630776db59dd4546a7790784b7a63e8d', '颜色', '47560d41556c4c96b14f7d1d98936f16', '0', '0');
INSERT INTO `shop_attribute` VALUES ('6699fb3cf6fc46aeb22efca7a8d56f87', '5.0', 'bb021b7d26ce4015a0117bbc46ca6d0d', '6cabaeb57fd0493d93473d45e05622b1', '0');
INSERT INTO `shop_attribute` VALUES ('685aa88713f24325aa0ed1718158d82d', '颜色', '627f21ccf893421ead0be760f9f8c01d', '0', '1');
INSERT INTO `shop_attribute` VALUES ('6c722c0344a94bab817ddefc1dd363db', '白色', 'adfd9081d38347a783d9f08625228d4e', '6fcde77169734f768f6fca9fda1240b6', '2');
INSERT INTO `shop_attribute` VALUES ('6cabaeb57fd0493d93473d45e05622b1', '尺寸', 'bb021b7d26ce4015a0117bbc46ca6d0d', '0', '1');
INSERT INTO `shop_attribute` VALUES ('6e120a8a79a2424ca6f5cdfbab500c1a', '月光银', '05b87c4206da4c8e81ae774317248725', '88b6ccc1b28a45dfbaceef6a8c715f34', '0');
INSERT INTO `shop_attribute` VALUES ('6fcde77169734f768f6fca9fda1240b6', '颜色', 'adfd9081d38347a783d9f08625228d4e', '0', '0');
INSERT INTO `shop_attribute` VALUES ('70ba524bc059464fa8586ba39d212f93', '月光银', '210d59848d2a4f848c5c3c6556732cfb', 'fa9be047396f4d078674b5a1e60ead11', '0');
INSERT INTO `shop_attribute` VALUES ('71f3104364a44a62aed29337687aa535', '内存', '05b87c4206da4c8e81ae774317248725', '0', '1');
INSERT INTO `shop_attribute` VALUES ('71f3b7a17e2149aea00862f7e362f24b', '150ml', 'b8f5fcc6e4e24b6a807905037e23911e', 'f3a187fb822d49ef992b5b46157e4d63', '0');
INSERT INTO `shop_attribute` VALUES ('7216cd77ac524e5990b695fc1e3f749e', '颜色', 'bb021b7d26ce4015a0117bbc46ca6d0d', '0', '0');
INSERT INTO `shop_attribute` VALUES ('7500ccd032d64db197fb79fa30e6e545', '尺寸', '588a36ece2c14028a09b99f0287e4be9', '0', '1');
INSERT INTO `shop_attribute` VALUES ('75fc04183dc1415cadd981e85ca0d701', '150ml', '77ee5f0a8b57485c9f1b69d2c7b40de8', '8f305568215345c8842bdf387e4ff2ec', '0');
INSERT INTO `shop_attribute` VALUES ('7b30061e6d6248138507cfde2deb2b88', '5.2', 'adfd9081d38347a783d9f08625228d4e', '1ce73cf45392488cb2000f5fce4cc7ca', '0');
INSERT INTO `shop_attribute` VALUES ('84142c37511f4d87bc388dc9bc4a8d7f', '500ml', '77ee5f0a8b57485c9f1b69d2c7b40de8', '8f305568215345c8842bdf387e4ff2ec', '2');
INSERT INTO `shop_attribute` VALUES ('88b6ccc1b28a45dfbaceef6a8c715f34', '颜色', '05b87c4206da4c8e81ae774317248725', '0', '0');
INSERT INTO `shop_attribute` VALUES ('8974dcab6f6f442686e65999afa65d12', '玫瑰金', '640554e89f144d61916f4c7660cad5e7', '34b10576804e439d96c1e53c3fa9573d', '2');
INSERT INTO `shop_attribute` VALUES ('89df1bf087fb45e4a7c8bb8abd95a0d7', 'VS/微瑕', '627f21ccf893421ead0be760f9f8c01d', '5bf6f42af83b4db499b76d7c0ecd707d', '1');
INSERT INTO `shop_attribute` VALUES ('8a8cbe0381a949b98a894594f0c4a131', '深空灰', '92eaf578edd44d8095807f8366c4371a', 'ab1a1212f5094050aafbd650b4118358', '0');
INSERT INTO `shop_attribute` VALUES ('8b813c27c5314ba89b800c9d4c7c30d9', '苍穹灰', '05b87c4206da4c8e81ae774317248725', '88b6ccc1b28a45dfbaceef6a8c715f34', '1');
INSERT INTO `shop_attribute` VALUES ('8ce17dffd4774a03873b86d575bbaae4', '重量', '627f21ccf893421ead0be760f9f8c01d', '0', '2');
INSERT INTO `shop_attribute` VALUES ('8f305568215345c8842bdf387e4ff2ec', '容量', '77ee5f0a8b57485c9f1b69d2c7b40de8', '0', '0');
INSERT INTO `shop_attribute` VALUES ('924286240bbd4bf8860544453c4413c3', '内存', '47560d41556c4c96b14f7d1d98936f16', '0', '1');
INSERT INTO `shop_attribute` VALUES ('9400ea3ba16b42d2bedca9bed5471f4e', '16g', 'adfd9081d38347a783d9f08625228d4e', 'd2e89cf14f9d40f68429e51ebaa0b529', '2');
INSERT INTO `shop_attribute` VALUES ('a2f0e73740084e45a71268074859cdfd', '64G', '640554e89f144d61916f4c7660cad5e7', 'faf2c5b458d244b2bd073e977123d291', '1');
INSERT INTO `shop_attribute` VALUES ('a5b4c370636a4d69a866972024c99de9', '网络', '210d59848d2a4f848c5c3c6556732cfb', '0', '0');
INSERT INTO `shop_attribute` VALUES ('a66a331b090f41308dc7a497f0f8185d', '5.0', 'bb021b7d26ce4015a0117bbc46ca6d0d', '7216cd77ac524e5990b695fc1e3f749e', '0');
INSERT INTO `shop_attribute` VALUES ('a707425df84640a0a8f6b9cf9723dd8a', '128G', '210d59848d2a4f848c5c3c6556732cfb', '13b944829f4842dca7275f61affe311b', '1');
INSERT INTO `shop_attribute` VALUES ('ab1a1212f5094050aafbd650b4118358', '颜色', '92eaf578edd44d8095807f8366c4371a', '0', '0');
INSERT INTO `shop_attribute` VALUES ('ac393403108749c2aec1bc33809b8a43', 'D-E/极白', '627f21ccf893421ead0be760f9f8c01d', '685aa88713f24325aa0ed1718158d82d', '0');
INSERT INTO `shop_attribute` VALUES ('ae493baaa5a94db7817ff221f0a0d4f5', '300ml', '77ee5f0a8b57485c9f1b69d2c7b40de8', '8f305568215345c8842bdf387e4ff2ec', '1');
INSERT INTO `shop_attribute` VALUES ('b1742179a78d458fac940c6b0cf6fe42', '玫瑰补水睡眠', 'b8f5fcc6e4e24b6a807905037e23911e', '3671e2ea88be44709b556ff0d968bc09', '1');
INSERT INTO `shop_attribute` VALUES ('bafeb85c388b425ea4e7c033f6a3cb25', '32G', '640554e89f144d61916f4c7660cad5e7', 'faf2c5b458d244b2bd073e977123d291', '0');
INSERT INTO `shop_attribute` VALUES ('bbf85031e64e4970a44c3b0593cbead7', '4.0', 'bb021b7d26ce4015a0117bbc46ca6d0d', '7216cd77ac524e5990b695fc1e3f749e', '1');
INSERT INTO `shop_attribute` VALUES ('beba9fb100274249a5b94d84dc292e03', '金色', '92eaf578edd44d8095807f8366c4371a', 'ab1a1212f5094050aafbd650b4118358', '1');
INSERT INTO `shop_attribute` VALUES ('c5effe25aeff4645b553b0c6b79ef7c8', '64g', 'adfd9081d38347a783d9f08625228d4e', 'd2e89cf14f9d40f68429e51ebaa0b529', '0');
INSERT INTO `shop_attribute` VALUES ('c860bcbe9ba845e7ab883a97507db525', '黑色', '588a36ece2c14028a09b99f0287e4be9', '2878a674d38248a7af34aab441911b77', '0');
INSERT INTO `shop_attribute` VALUES ('cb36d95a893842819cb08375dd968c88', '64G', '05b87c4206da4c8e81ae774317248725', '71f3104364a44a62aed29337687aa535', '0');
INSERT INTO `shop_attribute` VALUES ('cb791aadef53424e8924051d6fdb9cc1', '美白嫩肤睡眠', 'b8f5fcc6e4e24b6a807905037e23911e', '3671e2ea88be44709b556ff0d968bc09', '0');
INSERT INTO `shop_attribute` VALUES ('d2e89cf14f9d40f68429e51ebaa0b529', '内存', 'adfd9081d38347a783d9f08625228d4e', '0', '2');
INSERT INTO `shop_attribute` VALUES ('d3f7c453f7e44146876ef592d5425736', '谜夜黑', '47560d41556c4c96b14f7d1d98936f16', '630776db59dd4546a7790784b7a63e8d', '1');
INSERT INTO `shop_attribute` VALUES ('e24c1430a179456b94e3531da9698dbd', '绮梦金', '47560d41556c4c96b14f7d1d98936f16', '630776db59dd4546a7790784b7a63e8d', '0');
INSERT INTO `shop_attribute` VALUES ('e77fe08a3f9a4b47a4fa976877b9dc03', '4.5', '588a36ece2c14028a09b99f0287e4be9', '7500ccd032d64db197fb79fa30e6e545', '1');
INSERT INTO `shop_attribute` VALUES ('e8492353fb644ee08f45de487f3114bd', '黑色', 'adfd9081d38347a783d9f08625228d4e', '6fcde77169734f768f6fca9fda1240b6', '0');
INSERT INTO `shop_attribute` VALUES ('edaa21088d304bbd80d0af153ea1f4be', '128G', '05b87c4206da4c8e81ae774317248725', '71f3104364a44a62aed29337687aa535', '1');
INSERT INTO `shop_attribute` VALUES ('f3293f5ca6fc4c0e8112902632b32f82', '128g', 'adfd9081d38347a783d9f08625228d4e', 'd2e89cf14f9d40f68429e51ebaa0b529', '1');
INSERT INTO `shop_attribute` VALUES ('f3a187fb822d49ef992b5b46157e4d63', '容量', 'b8f5fcc6e4e24b6a807905037e23911e', '0', '1');
INSERT INTO `shop_attribute` VALUES ('fa9be047396f4d078674b5a1e60ead11', '颜色', '210d59848d2a4f848c5c3c6556732cfb', '0', '1');
INSERT INTO `shop_attribute` VALUES ('faf2c5b458d244b2bd073e977123d291', '内存', '640554e89f144d61916f4c7660cad5e7', '0', '1');
INSERT INTO `shop_attribute` VALUES ('fc1e15081a144858b02385490ffec010', 'F-G/优白', '627f21ccf893421ead0be760f9f8c01d', '685aa88713f24325aa0ed1718158d82d', '1');
INSERT INTO `shop_attribute` VALUES ('fee32d200fc34646b2e662e89f37c5be', '30分', '627f21ccf893421ead0be760f9f8c01d', '8ce17dffd4774a03873b86d575bbaae4', '0');

-- ----------------------------
-- Table structure for `shop_attribute_detail`
-- ----------------------------
DROP TABLE IF EXISTS `shop_attribute_detail`;
CREATE TABLE `shop_attribute_detail` (
  `attribute_detail_id` varchar(100) NOT NULL,
  `goods_id` varchar(255) DEFAULT NULL COMMENT 'id',
  `attribute_detail_name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `attribute_detail_price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `attribute_detail_num` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`attribute_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_attribute_detail
-- ----------------------------
INSERT INTO `shop_attribute_detail` VALUES ('015da55e6a0a424da4840d69779887d1', '47560d41556c4c96b14f7d1d98936f16', '绮梦金,64G', '5688.00', '111', '0');
INSERT INTO `shop_attribute_detail` VALUES ('01f79766290d4be2b2e1c7f123672bf7', '588a36ece2c14028a09b99f0287e4be9', '黑色,4.5', '0.01', '0', '1');
INSERT INTO `shop_attribute_detail` VALUES ('038b6d538e534f6e91187ea88efaf693', 'adfd9081d38347a783d9f08625228d4e', '白色,4.5,128g', '0.01', '1124', '22');
INSERT INTO `shop_attribute_detail` VALUES ('044913fda9c3400dabcabba4d0036099', '627f21ccf893421ead0be760f9f8c01d', 'SI/小瑕,D-E/极白,30分', '0.01', '10', '0');
INSERT INTO `shop_attribute_detail` VALUES ('05a4995b2d444a01be7ef0a6645c406d', 'bb021b7d26ce4015a0117bbc46ca6d0d', '红色,4.0', '4.00', '44', '3');
INSERT INTO `shop_attribute_detail` VALUES ('07106d5998f546cab76d207b072e1aa2', 'adfd9081d38347a783d9f08625228d4e', '白色,4.5,16g', '0.01', '1125', '23');
INSERT INTO `shop_attribute_detail` VALUES ('09d1809a76484e7d95ac184620483ff1', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.0,64g', '7.00', '666', '6');
INSERT INTO `shop_attribute_detail` VALUES ('0b12d07054974443b7aa1646339c4c94', 'adfd9081d38347a783d9f08625228d4e', '红色,4.5,128g', '0.01', '1113', '13');
INSERT INTO `shop_attribute_detail` VALUES ('0bfdce72f7ae4f3895787dc06a1fc65f', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.0,16g', '9.00', '0', '8');
INSERT INTO `shop_attribute_detail` VALUES ('0c78657de5d44f73ba56914b8576a76f', '640554e89f144d61916f4c7660cad5e7', '玫瑰金,64G', '5880.00', '8888', '7');
INSERT INTO `shop_attribute_detail` VALUES ('1172c36e5b8c4aae9fb15b0b69ecbf19', '627f21ccf893421ead0be760f9f8c01d', 'VS/微瑕,D-E/极白,1克拉', '0.30', '300', '5');
INSERT INTO `shop_attribute_detail` VALUES ('1442e3a1e21942828627b08bc415a916', '588a36ece2c14028a09b99f0287e4be9', '红色,5.0', '0.01', '1', '2');
INSERT INTO `shop_attribute_detail` VALUES ('17e71934140c4025b83d1aa63657c6b7', '640554e89f144d61916f4c7660cad5e7', '银色,64G', '5880.00', '1234', '10');
INSERT INTO `shop_attribute_detail` VALUES ('1f9320c0e64545acab60143a4e7d9eec', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.0,128g', '8.00', '777', '7');
INSERT INTO `shop_attribute_detail` VALUES ('2108ac4d01b64f7f84022046ba2f2196', '210d59848d2a4f848c5c3c6556732cfb', '4G全网通,香槟金,64G', '1088.00', '1000', '2');
INSERT INTO `shop_attribute_detail` VALUES ('21f57bb6d9a34efb8357d00931bf6278', 'b8f5fcc6e4e24b6a807905037e23911e', '美白嫩肤睡眠,300ml', '0.03', '3000', '1');
INSERT INTO `shop_attribute_detail` VALUES ('227b679dcf2e4ad48b7f98fa9bf9417b', 'adfd9081d38347a783d9f08625228d4e', '红色,5.2,128g', '11.00', '999', '10');
INSERT INTO `shop_attribute_detail` VALUES ('2325a4826a6248c3bb7a9471c80871fb', '77ee5f0a8b57485c9f1b69d2c7b40de8', '500ml', '0.05', '1000', '2');
INSERT INTO `shop_attribute_detail` VALUES ('2621632a3edf41b49659fbded068a48e', '640554e89f144d61916f4c7660cad5e7', '银色,128G', '6288.00', '2345', '11');
INSERT INTO `shop_attribute_detail` VALUES ('293e048fb69b40f88e236b53bdf63421', '588a36ece2c14028a09b99f0287e4be9', '黑色,5.0', '0.01', '1', '0');
INSERT INTO `shop_attribute_detail` VALUES ('297a08de24c14e789cce28bc65d746fa', '640554e89f144d61916f4c7660cad5e7', '黑色,32G', '5680.00', '4444', '3');
INSERT INTO `shop_attribute_detail` VALUES ('2ff264adb6f74f6d988ef3d1ca299d63', '77ee5f0a8b57485c9f1b69d2c7b40de8', '150ml', '0.01', '1000', '0');
INSERT INTO `shop_attribute_detail` VALUES ('3a2a0baad8e742289086e99058b99cbd', 'adfd9081d38347a783d9f08625228d4e', '红色,4.0,16g', '0.01', '1117', '17');
INSERT INTO `shop_attribute_detail` VALUES ('4022bccefd4c4540ae407c4997817658', '627f21ccf893421ead0be760f9f8c01d', 'VS/微瑕,F-G/优白,1克拉', '0.40', '400', '7');
INSERT INTO `shop_attribute_detail` VALUES ('45a711c88dd74928b1ff8c8f9e898583', 'adfd9081d38347a783d9f08625228d4e', '白色,4.0,16g', '0.01', '1128', '26');
INSERT INTO `shop_attribute_detail` VALUES ('4a97720544544de1bdb64fada3b621a2', '210d59848d2a4f848c5c3c6556732cfb', '4G全网通,月光银,64G', '1088.00', '1000', '0');
INSERT INTO `shop_attribute_detail` VALUES ('511736328da24d84b6c840d9a046aa35', 'adfd9081d38347a783d9f08625228d4e', '红色,4.5,16g', '0.01', '1114', '14');
INSERT INTO `shop_attribute_detail` VALUES ('5723de5cc88544d29b42b449e0f733e8', 'b8f5fcc6e4e24b6a807905037e23911e', '红酒透亮睡眠,300ml', '0.03', '3000', '5');
INSERT INTO `shop_attribute_detail` VALUES ('59214ecb01554c8f8ff7fa3083cc0b97', 'adfd9081d38347a783d9f08625228d4e', '白色,5.2,16g', '0.01', '1122', '20');
INSERT INTO `shop_attribute_detail` VALUES ('5eda162290f542ff98ef420b6e3fd90c', 'adfd9081d38347a783d9f08625228d4e', '白色,4.0,64g', '0.01', '1126', '24');
INSERT INTO `shop_attribute_detail` VALUES ('619df80dd50142c6b5c32344fc3b438e', '588a36ece2c14028a09b99f0287e4be9', '红色,4.5', '0.01', '1', '3');
INSERT INTO `shop_attribute_detail` VALUES ('66a12dfeef81466fbccc454e1df98e33', '627f21ccf893421ead0be760f9f8c01d', 'SI/小瑕,F-G/优白,30分', '0.02', '20', '2');
INSERT INTO `shop_attribute_detail` VALUES ('67df2cf8016e4cdca76c54e4edd2cf0d', 'adfd9081d38347a783d9f08625228d4e', '白色,4.5,64g', '0.01', '1123', '21');
INSERT INTO `shop_attribute_detail` VALUES ('6948b2359415459cb09c71086c648d1b', 'adfd9081d38347a783d9f08625228d4e', '白色,5.2,128g', '0.01', '1119', '19');
INSERT INTO `shop_attribute_detail` VALUES ('6b5cb811cac245d7a479b3fde63eccf4', '05b87c4206da4c8e81ae774317248725', '苍穹灰,64G', '3099.00', '333', '2');
INSERT INTO `shop_attribute_detail` VALUES ('6ddcd94d613a48cfb35c34e9e52d2be7', '627f21ccf893421ead0be760f9f8c01d', 'SI/小瑕,F-G/优白,1克拉', '0.20', '200', '3');
INSERT INTO `shop_attribute_detail` VALUES ('6fbc732a51804024a712176780bf507a', '05b87c4206da4c8e81ae774317248725', '月光银,128G', '3499.00', '222', '1');
INSERT INTO `shop_attribute_detail` VALUES ('7419e07c556740fe9eb01fac45d3f1d0', '92eaf578edd44d8095807f8366c4371a', '金色', '2578.00', '1000', '1');
INSERT INTO `shop_attribute_detail` VALUES ('76041bbee6b14cd5a9cb48ef56a2a11f', '77ee5f0a8b57485c9f1b69d2c7b40de8', '300ml', '0.03', '1000', '1');
INSERT INTO `shop_attribute_detail` VALUES ('7a00c2ccb6a74f4f8878fb2a2cb96d6d', '640554e89f144d61916f4c7660cad5e7', '黑色,64G', '5880.00', '5555', '4');
INSERT INTO `shop_attribute_detail` VALUES ('7de521d565004fddb5287b103aaa6cfc', '210d59848d2a4f848c5c3c6556732cfb', '4G全网通,香槟金,128G', '1388.00', '1000', '3');
INSERT INTO `shop_attribute_detail` VALUES ('851bf5cca84741edb080d2023a22f3e4', 'bb021b7d26ce4015a0117bbc46ca6d0d', '黑色,5.0', '1.00', '11', '0');
INSERT INTO `shop_attribute_detail` VALUES ('85a78691785c4832876987e444deb653', '640554e89f144d61916f4c7660cad5e7', '金色,128G', '6288.00', '3333', '2');
INSERT INTO `shop_attribute_detail` VALUES ('85c847e9f80646cb908328dd20ed1845', '05b87c4206da4c8e81ae774317248725', '苍穹灰,128G', '3499.00', '444', '3');
INSERT INTO `shop_attribute_detail` VALUES ('8944b4b09efa4944bcd81dc42d55cc5d', 'b8f5fcc6e4e24b6a807905037e23911e', '玫瑰补水睡眠,300ml', '0.03', '3000', '3');
INSERT INTO `shop_attribute_detail` VALUES ('8b89e85861b14dd0a887564f37f1edcf', '640554e89f144d61916f4c7660cad5e7', '金色,32G', '5680.00', '1111', '0');
INSERT INTO `shop_attribute_detail` VALUES ('8d8baf51cd1b4814b7deadd38340aba1', '47560d41556c4c96b14f7d1d98936f16', '谜夜黑,64G', '5688.00', '222', '1');
INSERT INTO `shop_attribute_detail` VALUES ('93c22e912c4c433eb819cbcfe50bdaad', 'b8f5fcc6e4e24b6a807905037e23911e', '美白嫩肤睡眠,150ml', '0.01', '1000', '0');
INSERT INTO `shop_attribute_detail` VALUES ('940d98e46ac34a87aa867c2c7be795f4', 'adfd9081d38347a783d9f08625228d4e', '红色,4.5,64g', '13.00', '1112', '12');
INSERT INTO `shop_attribute_detail` VALUES ('96ad42df10bb4f0aac72c000487c2c74', '640554e89f144d61916f4c7660cad5e7', '玫瑰金,32G', '5680.00', '7777', '6');
INSERT INTO `shop_attribute_detail` VALUES ('97ae990c28a0467ba9958e0320add31a', 'adfd9081d38347a783d9f08625228d4e', '红色,5.2,16g', '12.00', '1111', '11');
INSERT INTO `shop_attribute_detail` VALUES ('9831bfe8761c4738bc35c69423e51ab6', 'adfd9081d38347a783d9f08625228d4e', '红色,5.2,64g', '10.00', '888', '9');
INSERT INTO `shop_attribute_detail` VALUES ('988dbe6a0aeb414bab60fcd97efbab8a', '640554e89f144d61916f4c7660cad5e7', '玫瑰金,128G', '6288.00', '9999', '8');
INSERT INTO `shop_attribute_detail` VALUES ('9a5ee567267248339e1f56240e682fe6', '05b87c4206da4c8e81ae774317248725', '黑色,128G', '3499.00', '666', '5');
INSERT INTO `shop_attribute_detail` VALUES ('9c970b9413ff43128b7dff6d4eb247cb', 'bb021b7d26ce4015a0117bbc46ca6d0d', '黑色,4.0', '2.00', '22', '1');
INSERT INTO `shop_attribute_detail` VALUES ('aca278803be740179aacc1aa833fc6bc', '627f21ccf893421ead0be760f9f8c01d', 'SI/小瑕,D-E/极白,1克拉', '0.10', '100', '1');
INSERT INTO `shop_attribute_detail` VALUES ('b505055474c143bbb66d318d550f5cbb', 'b8f5fcc6e4e24b6a807905037e23911e', '红酒透亮睡眠,150ml', '0.01', '1000', '4');
INSERT INTO `shop_attribute_detail` VALUES ('bcd16275640640c8a31fb069c2d9444f', '627f21ccf893421ead0be760f9f8c01d', 'VS/微瑕,F-G/优白,30分', '0.04', '40', '6');
INSERT INTO `shop_attribute_detail` VALUES ('bd85ce03f91a424d8a77e963f37a5906', 'adfd9081d38347a783d9f08625228d4e', '黑色,5.2,16g', '3.00', '333', '2');
INSERT INTO `shop_attribute_detail` VALUES ('be0bfa016f974ab0a424e17d609fadfe', 'b8f5fcc6e4e24b6a807905037e23911e', '玫瑰补水睡眠,150ml', '0.01', '1000', '2');
INSERT INTO `shop_attribute_detail` VALUES ('c7809cf05aa14009b6adcb1f021f5b23', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.5,64g', '4.00', '444', '3');
INSERT INTO `shop_attribute_detail` VALUES ('cc77f70854e84889945205038d8c512f', '05b87c4206da4c8e81ae774317248725', '月光银,64G', '3099.00', '111', '0');
INSERT INTO `shop_attribute_detail` VALUES ('ceb08ccb585849948d719303ce6726e8', '640554e89f144d61916f4c7660cad5e7', '金色,64G', '5880.00', '2222', '1');
INSERT INTO `shop_attribute_detail` VALUES ('d0c6fb38864d46d68712e180133a1ba7', '627f21ccf893421ead0be760f9f8c01d', 'VS/微瑕,D-E/极白,30分', '0.03', '30', '4');
INSERT INTO `shop_attribute_detail` VALUES ('d20433768fb441f4a54252053250b086', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.5,128g', '5.00', '555', '4');
INSERT INTO `shop_attribute_detail` VALUES ('d5843a86d7bd4163880e5ca1c7f77c0c', 'bb021b7d26ce4015a0117bbc46ca6d0d', '红色,5.0', '3.00', '33', '2');
INSERT INTO `shop_attribute_detail` VALUES ('dcd42fcb0393481b85b50824143ede72', '05b87c4206da4c8e81ae774317248725', '黑色,64G', '3099.00', '555', '4');
INSERT INTO `shop_attribute_detail` VALUES ('e026de36ca3547cc855cf0e381ac5755', 'adfd9081d38347a783d9f08625228d4e', '红色,4.0,64g', '0.01', '1115', '15');
INSERT INTO `shop_attribute_detail` VALUES ('e3146275605b421d8b304d60332cffd0', 'adfd9081d38347a783d9f08625228d4e', '黑色,5.2,128g', '2.00', '222', '1');
INSERT INTO `shop_attribute_detail` VALUES ('e90aa8ffdd174686b7ad374500d7fb7a', '92eaf578edd44d8095807f8366c4371a', '深空灰', '2678.00', '1000', '0');
INSERT INTO `shop_attribute_detail` VALUES ('ea291cf301d84c7ea796c206ef07f39e', '640554e89f144d61916f4c7660cad5e7', '黑色,128G', '6288.00', '6666', '5');
INSERT INTO `shop_attribute_detail` VALUES ('f80590792e484f868f963f06a8ff1420', 'adfd9081d38347a783d9f08625228d4e', '白色,5.2,64g', '0.01', '1118', '18');
INSERT INTO `shop_attribute_detail` VALUES ('fadc66e594f648c99b118459403f79d7', 'adfd9081d38347a783d9f08625228d4e', '白色,4.0,128g', '0.01', '1127', '25');
INSERT INTO `shop_attribute_detail` VALUES ('fc1166f731e7453baad2e365d2d6bd26', 'adfd9081d38347a783d9f08625228d4e', '黑色,4.5,16g', '6.00', '0', '5');
INSERT INTO `shop_attribute_detail` VALUES ('fd328f591e6a4b49a15be4b038f4e8f7', 'adfd9081d38347a783d9f08625228d4e', '红色,4.0,128g', '0.01', '1116', '16');
INSERT INTO `shop_attribute_detail` VALUES ('fe28c7bffe90417cbbc25692add2336e', '210d59848d2a4f848c5c3c6556732cfb', '4G全网通,月光银,128G', '1388.00', '1000', '1');
INSERT INTO `shop_attribute_detail` VALUES ('ff12fe0303294fd3b3da113f67ac89e9', '640554e89f144d61916f4c7660cad5e7', '银色,32G', '5680.00', '1234', '9');
INSERT INTO `shop_attribute_detail` VALUES ('ff92c0e660b94c6ab61ef6d49eea86e1', 'adfd9081d38347a783d9f08625228d4e', '黑色,5.2,64g', '1.00', '111', '0');

-- ----------------------------
-- Table structure for `shop_banner`
-- ----------------------------
DROP TABLE IF EXISTS `shop_banner`;
CREATE TABLE `shop_banner` (
  `banner_id` varchar(255) NOT NULL,
  `ban_img` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `app_url` varchar(255) DEFAULT NULL COMMENT '小程序的url',
  `sort` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_banner
-- ----------------------------
INSERT INTO `shop_banner` VALUES ('0cb0c9761b664d83a22a8f2a326b3fd8', '/mallupload/1513000336545.png', 'coupon/tolist', 'coupon_list', '1', null, null);
INSERT INTO `shop_banner` VALUES ('f18fb2acdda34c73b5e3cb4aae4fec30', '/mallupload/1513000343037.png', 'goods/info/640554e89f144d61916f4c7660cad5e7', 'goods_info/0d32bc229af84724bd3a94f337975abd', '2', null, null);

-- ----------------------------
-- Table structure for `shop_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart` (
  `cart_id` varchar(100) NOT NULL,
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_pic` varchar(255) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL COMMENT '加入购物车时间',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `goods_count` varchar(255) NOT NULL COMMENT '商品数量',
  `attribute_detail_id` varchar(255) DEFAULT NULL COMMENT '属性id',
  `attribute_detail_name` varchar(255) DEFAULT '' COMMENT '属性名称',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES ('0074d40a0abe4dfcbde4a092c6dd067b', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-11-10 15:43:28', '93b7cb4ea77a4ea683d0f30bf55fa00f', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('022b7fb247e84181a4536ee7a41b0f6a', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.40', '2017-11-06 20:16:59', '6c8d3c22a2724d46be22198ed6896bc1', '1', '4022bccefd4c4540ae407c4997817658', 'VS/微瑕,F-G/优白,1克拉');
INSERT INTO `shop_cart` VALUES ('03195a9a54b84d97b987bc1d4aa905a3', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-07-21 16:26:47', '9674b4b2f2e84af8a74d81a2a72cdfc7', '1', '015da55e6a0a424da4840d69779887d1', '绮梦金,64G');
INSERT INTO `shop_cart` VALUES ('112dc909b7424b3eae75274c03644985', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-09-05 01:22:05', 'd29b4ee5b9224b44bc9ec4dd54b7141a', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('11ef1ef4872e4b069bccdfc93de053f0', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-11-15 12:15:48', 'dc4c0243eb694bbf9ece88b715460998', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('15dc4d5c6eb54f8380e55ea40e5f5137', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3499.00', '2017-11-15 20:43:20', '426e55f9cdab436cb7e397de07a9b29d', '2', '85c847e9f80646cb908328dd20ed1845', '苍穹灰,128G');
INSERT INTO `shop_cart` VALUES ('1832eafcb7674137b25ff239429461f2', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-11-03 16:24:34', 'fb3ae8a2cd39463d9fd6d8e6494e42c4', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('1af0c7b0f47845baafba6c0c8becebaa', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-09-14 23:53:41', '23547de21b1e4b6eb755d2213814be5f', '1', '8d8baf51cd1b4814b7deadd38340aba1', '谜夜黑,64G');
INSERT INTO `shop_cart` VALUES ('1c93694f1a1f471aad9341351093afa7', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-08-14 21:09:22', '3a993d9090cb4277b470181aa415cb6f', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('1d971ba8fce54a3082840d22f949d20f', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-10-15 21:57:40', 'e60c3b041ecf43a691fc7639f9817898', '1', 'cc77f70854e84889945205038d8c512f', '月光银,64G');
INSERT INTO `shop_cart` VALUES ('23190a2336234d19b9f51756b4cb032b', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-09-16 23:57:01', '6c2418ed1acb4823a918d8fab9f2c2cf', '1', 'cc77f70854e84889945205038d8c512f', '月光银,64G');
INSERT INTO `shop_cart` VALUES ('256130b3a2cd43d089592e5acb47cf02', '0c78d9da52d84fc88968dad05087ad2f', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '/mallupload/1500609388127.png,', '729.00', '2017-09-29 13:29:32', '8ef911a19d434537931659008a08477d', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('2576fb90d20e46d3a15494b72df3645d', '66a9d4ee6fc049ef94ec958afc4cc3c2', '金橡树泰国天然乳胶床垫5cm10cm双人席梦思床垫1.8m', '/mallupload/1500609468996.png,', '1500.00', '2017-07-21 14:25:54', 'e60c3b041ecf43a691fc7639f9817898', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('25af21ce69904aa0b3a385eec6d077f8', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-10-15 11:07:59', '9cbf15e7abff449186599a84889a3c9d', '1', '6b5cb811cac245d7a479b3fde63eccf4', '苍穹灰,64G');
INSERT INTO `shop_cart` VALUES ('3aaaae5cf3244c5b9ef8a5dca73d99cf', '210d59848d2a4f848c5c3c6556732cfb', 'Meizu/魅族 魅蓝Note5全网通4G快充大电池智能手机', '/mallupload/1500609651183.png,', '1388.00', '2017-09-11 14:38:44', '40f425283fbf4895b493a5e196577213', '1', 'fe28c7bffe90417cbbc25692add2336e', '4G全网通,月光银,128G');
INSERT INTO `shop_cart` VALUES ('3fc602f66eb54ea893d7877c99e0be6d', 'b8e71a42aec649bda125f7d5420c3354', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '/mallupload/1500609326237.png,', '4199.00', '2017-09-04 12:28:26', '8813fc7794d94900ba685b47757bafbc', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('462bc9560c2c4d748f9ef41d8fc7b985', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-10-12 16:49:05', '0f18dc90bf0c443aa3634464c0e1c774', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('46930a1bfc504c7cb8a081c01ccf4f8f', '640554e89f144d61916f4c7660cad5e7', 'Apple/苹果 iPhone 7 Plus 移动联通4G智能手机', '/mallupload/1500608236033.png', '5880.00', '2017-10-20 13:02:43', '587996520c2843b083a38e41a68e4c49', '1', 'ceb08ccb585849948d719303ce6726e8', '金色,64G');
INSERT INTO `shop_cart` VALUES ('529eb5b126a947f3b174e6a31777ccfb', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-11-07 22:49:22', '38890e0390494aa8980fe7bd2f67d624', '1', 'cc77f70854e84889945205038d8c512f', '月光银,64G');
INSERT INTO `shop_cart` VALUES ('6438383f1c5d4f738a2792c821984791', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-07-27 15:27:05', '9ddfee99c2e142d0be80b8ee3ef19563', '1', '015da55e6a0a424da4840d69779887d1', '绮梦金,64G');
INSERT INTO `shop_cart` VALUES ('77df0dc1eb0143daa668f0d9cc05bf67', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-09-14 17:39:54', '4ab4144bb80047e5a9ff7a5f45baa6c0', '1', '015da55e6a0a424da4840d69779887d1', '绮梦金,64G');
INSERT INTO `shop_cart` VALUES ('7842264d5886487ab394cf4fa810a99e', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.01', '2017-11-15 12:54:55', 'dc4c0243eb694bbf9ece88b715460998', '1', '044913fda9c3400dabcabba4d0036099', 'SI/小瑕,D-E/极白,30分');
INSERT INTO `shop_cart` VALUES ('7927f5ffe1d44f1794ddafd666a1901b', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2578.00', '2017-07-21 14:25:48', 'e60c3b041ecf43a691fc7639f9817898', '2', '7419e07c556740fe9eb01fac45d3f1d0', '金色');
INSERT INTO `shop_cart` VALUES ('7adf6bf4621c430d9de8aed18555c33c', 'b8e71a42aec649bda125f7d5420c3354', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '/mallupload/1500609326237.png,', '4199.00', '2017-11-10 15:46:58', '93b7cb4ea77a4ea683d0f30bf55fa00f', '4', '1', '');
INSERT INTO `shop_cart` VALUES ('8341c8aaee944539b200bcdb411b3c40', 'e1262011793c46038a072daf9d54d8c3', 'Asus/华硕 R RX310UA7100超薄13手提游戏轻薄便携学生笔记本电脑', '/mallupload/1500608841627.png,', '0.01', '2017-09-05 22:33:39', 'faf1aec992474e9ca667a959e0ce83ef', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('8d2dcbf0ed5f433f9b598e37946c9a5b', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-12-04 20:27:37', 'db9450f0e5eb482badc31721fcbdbf61', '1', 'cc77f70854e84889945205038d8c512f', '月光银,64G');
INSERT INTO `shop_cart` VALUES ('9238f670152f46288f24974098562c1f', '588a36ece2c14028a09b99f0287e4be9', '苹果手机多规格测试', '/mallupload/1499490812463.png,', '0.01', '2017-07-20 16:58:20', '16', '2', '1442e3a1e21942828627b08bc415a916', '红色,5.0');
INSERT INTO `shop_cart` VALUES ('937cc36532b34390ae25812f3c569dfe', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-08-28 10:09:52', '1ad41e5c660442a2818ca200f3391930', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('965ec33b4ded4674b27580cb4e38c6f3', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-09-06 00:04:55', 'fedfcc07c35a479eaa187ab9590c47f7', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('9e25368003ff4ba289adb56ceb5777c3', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-11-16 08:57:48', 'f0a80301386c4733825204f33f8a6bc9', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('a05e1aa8bb594cc3aed328d70530e5cf', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-08-07 13:12:52', '7a45a941cb8446aaaff8bc98c862296b', '1', '6b5cb811cac245d7a479b3fde63eccf4', '苍穹灰,64G');
INSERT INTO `shop_cart` VALUES ('a53bec3cf37c49698c9a8c44a307870f', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-12-03 11:53:19', '42a51640aafd41ef963331c27a9b7fe5', '1', '015da55e6a0a424da4840d69779887d1', '绮梦金,64G');
INSERT INTO `shop_cart` VALUES ('a6750bf5745742e3b0a06e8466c76fd2', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.40', '2017-08-14 21:10:08', '3a993d9090cb4277b470181aa415cb6f', '1', '4022bccefd4c4540ae407c4997817658', 'VS/微瑕,F-G/优白,1克拉');
INSERT INTO `shop_cart` VALUES ('a857ddca55814273bea65315909ce4ae', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3499.00', '2017-11-13 14:26:25', '4b56a6b3f0c94949ad2bda39e54ba90a', '1', '9a5ee567267248339e1f56240e682fe6', '黑色,128G');
INSERT INTO `shop_cart` VALUES ('aa05d672b1124ed28b9c4a0465565646', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.40', '2017-10-26 10:09:13', 'e60c3b041ecf43a691fc7639f9817898', '1', '4022bccefd4c4540ae407c4997817658', 'VS/微瑕,F-G/优白,1克拉');
INSERT INTO `shop_cart` VALUES ('b1383247dfd2416289e565a8d26d7257', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-10-20 13:32:43', 'd561106cf91940899f3cf8e9e3bad284', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('bc2c85f99f73438391286e723d16f2df', '210d59848d2a4f848c5c3c6556732cfb', 'Meizu/魅族 魅蓝Note5全网通4G快充大电池智能手机', '/mallupload/1500609651183.png,', '1088.00', '2017-08-19 11:20:18', '71b00a30e3504075b3ae1e7f9ad05cd9', '1', '2108ac4d01b64f7f84022046ba2f2196', '4G全网通,香槟金,64G');
INSERT INTO `shop_cart` VALUES ('c452cf796a1749dc8d44b60ad9143178', '0c78d9da52d84fc88968dad05087ad2f', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '/mallupload/1500609388127.png,', '729.00', '2017-11-15 12:18:01', 'dc4c0243eb694bbf9ece88b715460998', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('c522a0d84b364d08a06b0457466a574a', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.01', '2017-10-18 18:03:38', 'f31eab0144f24784b3dfb64e924ddc1c', '1', '044913fda9c3400dabcabba4d0036099', 'SI/小瑕,D-E/极白,30分');
INSERT INTO `shop_cart` VALUES ('d46780e5ce8d490aa744a56e9b8dadeb', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099.00', '2017-11-15 23:41:28', '9bcc72a2673c4f48a3bf02ca66539091', '1', 'cc77f70854e84889945205038d8c512f', '月光银,64G');
INSERT INTO `shop_cart` VALUES ('d8f843b833224a3ea930be9192714c3d', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-10-24 17:07:04', '3b9b4dc4609b4893976888871358251b', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('edd4bff7e5484805aedd2a847d3a152f', 'b8e71a42aec649bda125f7d5420c3354', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '/mallupload/1500609326237.png,', '4199.00', '2017-11-06 09:32:47', '4b56a6b3f0c94949ad2bda39e54ba90a', '1', '1', '');
INSERT INTO `shop_cart` VALUES ('f2a3d249d013479b98bd490519c50784', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png,', '0.03', '2017-10-18 22:00:43', 'f31eab0144f24784b3dfb64e924ddc1c', '1', 'd0c6fb38864d46d68712e180133a1ba7', 'VS/微瑕,D-E/极白,30分');
INSERT INTO `shop_cart` VALUES ('f48ccfb8ac1e4d59b27135d9d07795e3', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png,', '5688.00', '2017-08-18 13:53:19', 'bfdd0da0d44c48a19960d90dc85b1f39', '1', '8d8baf51cd1b4814b7deadd38340aba1', '谜夜黑,64G');
INSERT INTO `shop_cart` VALUES ('f5b695703f0d419cbaa02a7c75877acc', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png,', '2678.00', '2017-07-21 14:25:48', 'e60c3b041ecf43a691fc7639f9817898', '1', 'e90aa8ffdd174686b7ad374500d7fb7a', '深空灰');
INSERT INTO `shop_cart` VALUES ('f8c808d662d84904a5994dec5bdca35c', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png,', '36.80', '2017-11-17 18:12:19', 'c5de0f47ccab4f7da32b9c173f62edfc', '1', '1', '');

-- ----------------------------
-- Table structure for `shop_category`
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category` (
  `category_id` varchar(255) NOT NULL,
  `category_name` varchar(255) DEFAULT '',
  `category_en_name` varchar(255) DEFAULT NULL,
  `category_img` varchar(255) DEFAULT '',
  `super_id` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO `shop_category` VALUES ('1a97347bc2754ce4a6358232f1818955', '洗发护发', null, '/mallupload/1512995982478.png', '736c371501ec40199f1ddc1096a0e809', '5');
INSERT INTO `shop_category` VALUES ('1e42d036c3f447fdbf97643901b74ae8', '其它', 'Other', '/duobaoweb/../shopupload/1489650442157.png', null, '9');
INSERT INTO `shop_category` VALUES ('39e4401b36d8459eae9c423290fb358d', '厨卫大电', null, '/mallupload/1512996702779.png', '89ced6468142429c87f93f82354d56f7', '2');
INSERT INTO `shop_category` VALUES ('43763591b7af439aaa962a014d0241de', '面部护肤', null, '/mallupload/1512984172537.png', '736c371501ec40199f1ddc1096a0e809', '1');
INSERT INTO `shop_category` VALUES ('4ae42d06a243487db398cf3fdddfd308', '服饰', 'Clothing', '/duobaoweb/../shopupload/1489650415704.png', null, '6');
INSERT INTO `shop_category` VALUES ('56d19cc8e40f4543aa3443fb6a12bca1', '珠宝', 'Jewellery', '/duobaoweb/../shopupload/1489650407188.png', null, '5');
INSERT INTO `shop_category` VALUES ('6a220b59fbf54d13a597091a6b7487a6', '身体护理', null, '/mallupload/1512984309190.png', '736c371501ec40199f1ddc1096a0e809', '3');
INSERT INTO `shop_category` VALUES ('736c371501ec40199f1ddc1096a0e809', '护肤美妆', null, '/mallupload/1512996228752.png', '0', '1');
INSERT INTO `shop_category` VALUES ('7fbf8ab7629e419ca86c45a0a800b335', '一次性用品', null, '/mallupload/1512996447420.png', 'a6c0902d4c9e4ddf9b936c82d9068abc', '3');
INSERT INTO `shop_category` VALUES ('89ced6468142429c87f93f82354d56f7', '居家生活', null, '/mallupload/1512996588891.png', '0', '3');
INSERT INTO `shop_category` VALUES ('8c69430551b14ecc9f57183b3e49bebb', '奢侈品', 'luxuries', '/duobaoweb/../shopupload/1489652943921.png', null, '2');
INSERT INTO `shop_category` VALUES ('9f28fbea3ccf4b659112cc399b4bb59c', '清洁用品', null, '/mallupload/1512984263655.png', '736c371501ec40199f1ddc1096a0e809', '2');
INSERT INTO `shop_category` VALUES ('a2b03106bde7453a985967fbd9cf5a65', '纸品湿巾', null, '/mallupload/1512996305007.png', 'a6c0902d4c9e4ddf9b936c82d9068abc', '1');
INSERT INTO `shop_category` VALUES ('a306eb7628fe4313a8f01908673a5f56', '香水彩妆', null, '/mallupload/1512996015171.png', '736c371501ec40199f1ddc1096a0e809', '6');
INSERT INTO `shop_category` VALUES ('a6c0902d4c9e4ddf9b936c82d9068abc', '家居清洁', null, '/mallupload/1512996163399.png', '0', '2');
INSERT INTO `shop_category` VALUES ('a86ab063ae604477a4114a1152617493', '汽车', 'automobile', '/duobaoweb/../shopupload/1489650433735.png', null, '8');
INSERT INTO `shop_category` VALUES ('ae034ef99d4e4049ad36ef8c29bb984b', '口腔护理', null, '/mallupload/1512995904611.png', '736c371501ec40199f1ddc1096a0e809', '4');
INSERT INTO `shop_category` VALUES ('b536f3402109483ebaab287dbfe47489', '电器', 'Electric Appliances', '/duobaoweb/../shopupload/1489650392984.png', null, '4');
INSERT INTO `shop_category` VALUES ('bcaf1e20a5ef4a1c8e0c0710ffd9b41b', '生活日用', null, '/mallupload/1512996625548.png', '89ced6468142429c87f93f82354d56f7', '1');
INSERT INTO `shop_category` VALUES ('c307426f05714a02854854295351a903', '衣物清洁', null, '/mallupload/1512996358643.png', 'a6c0902d4c9e4ddf9b936c82d9068abc', '2');
INSERT INTO `shop_category` VALUES ('dcbf6d03f56143b4818eee44dbaff25f', '海购', 'Buy overseas', '/duobaoweb/../shopupload/1489650424438.png', null, '7');
INSERT INTO `shop_category` VALUES ('f2a1161c82eb43f4a6682994dad896f6', '数码', 'Electronics', '/duobaoweb/../shopupload/1489650320311.png', null, '3');

-- ----------------------------
-- Table structure for `shop_collection`
-- ----------------------------
DROP TABLE IF EXISTS `shop_collection`;
CREATE TABLE `shop_collection` (
  `collection_id` varchar(100) NOT NULL,
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `goods_price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `addtime` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_collection
-- ----------------------------
INSERT INTO `shop_collection` VALUES ('02d4f6ba5bfb4b67876b372396ed4217', '205ad4353b4c4e32bc905a54cf649b2b', '俞兆林卫衣 男2017春新款运动休闲印花大码潮人卫衣卫裤加厚外套套装男', '/mallupload/1494510597008.png', '0', '70e0ab2d4e0f4805a77bd2fb959c3049', '2017-06-04 14:49:07');
INSERT INTO `shop_collection` VALUES ('09b14bd06ea9423695e8bda3c4de85f1', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png', '2578', 'b20cbcc997004934b18d30c93b8557a1', '2017-07-21 16:05:08');
INSERT INTO `shop_collection` VALUES ('0f4fab4105394e1aaaccc47b9c5aaf97', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', 'af84d8ed7d33482fbde06da1418fcfad', '2017-08-18 11:55:28');
INSERT INTO `shop_collection` VALUES ('13cd7c4e7f93465f81e2450fc4e07cf7', '0c78d9da52d84fc88968dad05087ad2f', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '/mallupload/1500609388127.png', '729', '096421ccfdda495ba9db4c0899beb3af', '2017-11-05 16:43:30');
INSERT INTO `shop_collection` VALUES ('195e96a406d84558a066fd8ba5b9a15f', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png', '0', '9ca74a224db249a5b3e32454b4ec423c', '2017-12-03 13:16:42');
INSERT INTO `shop_collection` VALUES ('1ee4a83d10674663b56734c5f7f9e7a0', '1765ea585d654478b4c92b9fe3984009', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493995086094.png', '1888', '16', '2017-05-12 16:21:52');
INSERT INTO `shop_collection` VALUES ('24e1c536010c49abb5b83efbfb92335f', '47560d41556c4c96b14f7d1d98936f16', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '/mallupload/1500608735171.png', '5688', '4ab4144bb80047e5a9ff7a5f45baa6c0', '2017-09-14 17:39:36');
INSERT INTO `shop_collection` VALUES ('3977958aa80c4802ac8219e56b9baef8', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png', '0', 'fa2c5b648c9946e59813a567d24dd1dc', '2017-09-11 14:39:51');
INSERT INTO `shop_collection` VALUES ('3d49f253e4734bdea301db84c8dd7e48', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', '4b56a6b3f0c94949ad2bda39e54ba90a', '2017-11-05 15:30:25');
INSERT INTO `shop_collection` VALUES ('3f29a5c6763a463eaa731cc68b42cec2', '205ad4353b4c4e32bc905a54cf649b2b', '俞兆林卫衣 男2017春新款运动休闲印花大码潮人卫衣卫裤加厚外套套装男', '/mallupload/1494510597008.png', '0', '5e2c3aa1d87e4cd399a5315224592430', '2017-05-31 09:36:03');
INSERT INTO `shop_collection` VALUES ('46df8ed7da804f95964990b193c5615e', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', '0c40d1a9047e49ed82f93d115997774f', '2017-12-02 19:42:58');
INSERT INTO `shop_collection` VALUES ('4f27659461164ce790a29dae4c9c5d2f', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', 'f31eab0144f24784b3dfb64e924ddc1c', '2017-10-10 23:47:15');
INSERT INTO `shop_collection` VALUES ('68f93377036d44fa93d7b59d4e9b6589', '61633342d49e455087d0a27bcb35a166', '原瓶进口红酒 黄尾袋鼠西拉/梅洛领衔3国葡萄酒组合三支整箱750ml*3', '/mallupload/1494511174242.png', '500', '16', '2017-05-12 10:32:14');
INSERT INTO `shop_collection` VALUES ('6c876843c0164b13a1edeb000a97307f', 'b8e71a42aec649bda125f7d5420c3354', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '/mallupload/1500609326237.png', '4199', 'd561106cf91940899f3cf8e9e3bad284', '2017-10-20 13:32:20');
INSERT INTO `shop_collection` VALUES ('6ddcf748b1c34e58a81db006de70949d', '3a31ea72f7254ae0ba0b0e3c0ea3f5af', 'Apple iPhone 7 Plus (A1661) 128G 黑色 移动联通电信4G手机', '/mallupload/1494510524153.png', '6599', '5e2c3aa1d87e4cd399a5315224592430', '2017-06-01 08:18:23');
INSERT INTO `shop_collection` VALUES ('6fd0c482af6e4048a2edd0a7a02154bb', '640554e89f144d61916f4c7660cad5e7', 'Apple/苹果 iPhone 7 Plus 移动联通4G智能手机', '/mallupload/1500608236033.png', '5680', 'af84d8ed7d33482fbde06da1418fcfad', '2017-08-18 11:58:59');
INSERT INTO `shop_collection` VALUES ('7759afad7c13435794aa5694cee71d40', '0d712d1414ca4abaa2edc8680796f5b6', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1494511216940.png', '201', '657eb8252e3c4861a898b757dc7117b5', '2017-06-01 12:17:09');
INSERT INTO `shop_collection` VALUES ('77c0fef68f6345d9810ce63c94def88d', '210d59848d2a4f848c5c3c6556732cfb', 'Meizu/魅族 魅蓝Note5全网通4G快充大电池智能手机', '/mallupload/1500609651183.png', '1088', 'af84d8ed7d33482fbde06da1418fcfad', '2017-08-18 11:43:49');
INSERT INTO `shop_collection` VALUES ('847af2bf9c844bb391a8657031e26891', '236f33a6266d49bfb273c16f6c9de857', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493996071462.png', '5189', '16', '2017-05-11 21:08:10');
INSERT INTO `shop_collection` VALUES ('89b1d7cdb667432d873d4b514b0825d3', '0d712d1414ca4abaa2edc8680796f5b6', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493996086744.png', '201', '16', '2017-05-11 21:09:03');
INSERT INTO `shop_collection` VALUES ('8f5e9ef095824046a6869185019daadb', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', '426e55f9cdab436cb7e397de07a9b29d', '2017-11-11 23:17:29');
INSERT INTO `shop_collection` VALUES ('a69a7c82497a470d89d66eeb424c482e', '0c78d9da52d84fc88968dad05087ad2f', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '/mallupload/1500609388127.png', '729', '07573ce2135a41abbcefdcbc7a4b6fd2', '2017-09-01 18:33:03');
INSERT INTO `shop_collection` VALUES ('af5da022314e4268b58f0c12b4f7ca57', '4769bf5a00df4159957c5462115f84bd', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493996008046.png', '1', '16', '2017-05-11 21:12:19');
INSERT INTO `shop_collection` VALUES ('b2765753c8f94f9d8befd21b7345f98b', '818f4598cc154f8db56956cd02189c8f', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G', '/mallupload/1493993769201.png', '5888', '16', '2017-05-11 21:08:27');
INSERT INTO `shop_collection` VALUES ('b934901e7d5b4e5fb529e01cc8a7044e', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', '34a7a6af59e44a72bbb33064e0b9808c', '2017-10-25 11:02:36');
INSERT INTO `shop_collection` VALUES ('bc78a40c77154da39c5b5ec1d3ef716b', '6f1ef9d26811407b8a9aa03532976603', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '/mallupload/1500609537479.png', '37', 'fedfcc07c35a479eaa187ab9590c47f7', '2017-09-06 00:05:00');
INSERT INTO `shop_collection` VALUES ('c159c8c8bb834a1cbf7867166024cf3a', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png', '0', '0c40d1a9047e49ed82f93d115997774f', '2017-12-04 18:09:43');
INSERT INTO `shop_collection` VALUES ('cb18eda2a18b4b00961544e676c33f43', '627f21ccf893421ead0be760f9f8c01d', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '/mallupload/1500609225036.png', '0', 'dc4c0243eb694bbf9ece88b715460998', '2017-11-15 12:19:28');
INSERT INTO `shop_collection` VALUES ('d585e107fbe34c978d0079a1b6aba69f', 'de87458339444899907fd4512bed36dc', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G', '/mallupload/1493993769201.png', '5888', '16', '2017-05-11 21:08:38');
INSERT INTO `shop_collection` VALUES ('d70091e532c8419dac58832561b5ceb0', '236f33a6266d49bfb273c16f6c9de857', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493996071462.png', '5189', '657eb8252e3c4861a898b757dc7117b5', '2017-06-01 12:17:16');
INSERT INTO `shop_collection` VALUES ('ddc0f5402c7e4900a1d6d47527eabcbd', '0329bc2713e34cdd81f134c0edfc36cd', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493995102575.png', '888', '16', '2017-05-25 14:00:01');
INSERT INTO `shop_collection` VALUES ('ddf7fda11b2e453f9d859c66da31c2bb', '245525c398dc4f2fba592adc6dfc82b8', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493995003483.png', '5288', '16', '2017-05-11 21:08:52');
INSERT INTO `shop_collection` VALUES ('dedf3c15c0c1443d8614387e947f1f6b', '210d59848d2a4f848c5c3c6556732cfb', 'Meizu/魅族 魅蓝Note5全网通4G快充大电池智能手机', '/mallupload/1500609651183.png', '1088', 'adfdb3a5f09040768a2f952437792fe1', '2017-07-29 12:01:23');
INSERT INTO `shop_collection` VALUES ('e1b8b7581b374d09b59ea95a81c03b58', '3a31ea72f7254ae0ba0b0e3c0ea3f5af', 'Apple iPhone 7 Plus (A1661) 128G 黑色 移动联通电信4G手机', '/mallupload/1493185163044.png', '6599', '16', '2017-05-11 21:08:49');
INSERT INTO `shop_collection` VALUES ('e2ef3e6cb3524d339c5eea2589326de7', 'b8e71a42aec649bda125f7d5420c3354', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '/mallupload/1500609326237.png', '4199', '06b3e017618e428c9790a589bfce7a41', '2017-10-25 14:57:11');
INSERT INTO `shop_collection` VALUES ('e954062346aa427daf4392968ee95138', '6f782050476644ccb93c27c3d285fb4e', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493994602559.png', '5000', '16', '2017-05-11 21:08:19');
INSERT INTO `shop_collection` VALUES ('f659bca29e194ce9ad4644832a0b78ac', 'bf1ca717e8474ea6a89de372345b6ac4', '华为 HUAWEI P10 Plus 5.5英寸全网通 双卡双待 后置双镜头 曜石黑 6GB+256G	', '/mallupload/1493995072915.png', '3888', '16', '2017-05-13 23:04:17');
INSERT INTO `shop_collection` VALUES ('f7fcdb870325424d9215cbfe7d091dc2', '05b87c4206da4c8e81ae774317248725', 'Huawei/华为 Mate 9商务手机正品mate9', '/mallupload/1500608478653.png', '3099', '6a35f365d2de472b8e6437562b7d2e7b', '2017-11-16 13:41:23');
INSERT INTO `shop_collection` VALUES ('fadfb65957e847d5ab8f435126d5132d', '92eaf578edd44d8095807f8366c4371a', 'Apple iPhone 6 32GB 移动联通电信4G手机', '/mallupload/1500607322411.png', '2578', 'f0a80301386c4733825204f33f8a6bc9', '2017-11-16 08:57:23');

-- ----------------------------
-- Table structure for `shop_comment`
-- ----------------------------
DROP TABLE IF EXISTS `shop_comment`;
CREATE TABLE `shop_comment` (
  `COMMENT_ID` varchar(100) NOT NULL,
  `ORDER_ID` varchar(255) DEFAULT NULL COMMENT '订单id',
  `GOODS_ID` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户id',
  `COMMENT_TITLE` int(11) DEFAULT '0' COMMENT '评分',
  `COMMENT_CONTENT` varchar(255) DEFAULT NULL COMMENT '评论留言',
  `COMMENT_PIC` varchar(255) DEFAULT NULL COMMENT '晒图',
  `ADDTIME` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_comment
-- ----------------------------
INSERT INTO `shop_comment` VALUES ('1c5b799ad4794637b434a55d9d4d9fad', '1500104275717', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '此用户没写评语', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('2ab44abb99214be382c3b3e0dc40877d', '20170509163924837906305', '245525c398dc4f2fba592adc6dfc82b8', '16', '1', '', '../mallupload/1495011575901.png', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('300259d04b7c40d5a81df131f85c8295', '1497251033618', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('39741f31d9d14cd9ac67d462177a1e0b', '1500104289201', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', ' ', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('4234068e2934464181f8ddf93f0aa72e', '1496317774959', '205ad4353b4c4e32bc905a54cf649b2b', '657eb8252e3c4861a898b757dc7117b5', '5', '不错的', '../mallupload/1496634639614.png,../mallupload/1496634664737.png', '2017-06-05');
INSERT INTO `shop_comment` VALUES ('4ab732547e2544ab95829e827d8ea82a', '1499839618022', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '哈', '', '2017-07-12');
INSERT INTO `shop_comment` VALUES ('4bac2550607e47c2a80d85c899e8132d', '1497175620379', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('4c7fb17d979b4909a3e24e33ec3ccd0e', '1500104266029', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '此用户没写评语', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('50933ae9366b4cb898248ab94fb8f949', '1499839600756', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '这样还可以', '', '2017-07-12');
INSERT INTO `shop_comment` VALUES ('5173e0f829b546f6b8cdab7ac5bfd3a1', '1500104311858', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '好评', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('517a8927f1eb4b42a74d8a8fdeea6b09', '1500103615028', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('53ba3d5105e545a19339b8002c6c96af', '20170509163924837906305', '245525c398dc4f2fba592adc6dfc82b8', '16', '1', '性能十足', '../mallupload/1495011565085.png', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('694e00c9e81c4829993bb0dd8adf2527', '1496652094149', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '1', '此用户没写评语', '', '2017-06-05');
INSERT INTO `shop_comment` VALUES ('6c42ebf0eb484b7f8d285ca8e9ff1d66', '1500103675576', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '很好', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('7125fec8deae4c8099cccbf4ec87e70d', '20170509163924837906305', '245525c398dc4f2fba592adc6dfc82b8', '16', '1', '', '', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('77d84f7f3ef14150a2683bba29948883', '1500104301873', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '此用户没写评语', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('8040bc8a66414aef98049ec824a5e529', '20170512162740545457062', '245525c398dc4f2fba592adc6dfc82b8', '16', '1', '11111', '../mallupload/1495097643060.png', '2017-05-18');
INSERT INTO `shop_comment` VALUES ('83173e09cb674ebfa251c2b6afed33bd', '1500103625856', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('83c86e004ef24c16a3a7420cbf9b22a3', '20170509163924837906305', '245525c398dc4f2fba592adc6dfc82b8', '16', '1', '', '', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('858e87cceac740eb83d5568687a416b8', '1508984350445', '627f21ccf893421ead0be760f9f8c01d', 'e60c3b041ecf43a691fc7639f9817898', '5', '此用户没写评语', '../mallupload/1510918822913.png,../mallupload/1510918836648.png', '2017-11-17');
INSERT INTO `shop_comment` VALUES ('88b3e87774b74632a434688f5d8407ea', '1500022570666', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('88c50fde0e884a83a425a83170925e0a', '1512393942926', '6f1ef9d26811407b8a9aa03532976603', 'db9450f0e5eb482badc31721fcbdbf61', '2', '1', '../mallupload/1512807323650.png', '2017-12-09');
INSERT INTO `shop_comment` VALUES ('9211e070d69e4a8d8e1d01a8f38d98e0', '1497251033618', '0d712d1414ca4abaa2edc8680796f5b6', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('92698fba7b2f424d8feae2553894f27a', '1496650280401', '205ad4353b4c4e32bc905a54cf649b2b', '657eb8252e3c4861a898b757dc7117b5', '5', '嗯嗯', '', '2017-06-05');
INSERT INTO `shop_comment` VALUES ('959427e732e54e26ae159875155b158c', '1500103598324', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('a5aae71808f242dd982d3ece58520a9c', '1496304878255', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '此用户没写评语', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('a8b1f12ee5c34656bbb2a79af407de35', '20170509163924837906305', '778bf17a288f448fadfa7f8f032ea299', '16', '1', '', '', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('ac92e28a343f45c9b9320fbf015c7e0e', '1500103634528', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '！！！！', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('afd93596c7344bccad7e1b86d03b5d77', '1497006531689', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '？？', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('b2ac8966c32349e6aa45d2df83e3c202', '1500103659044', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '....', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('bf46094d562544778b4f84cf5de75379', '1496560101801', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '4', '还不错的商品', '../mallupload/1496561158335.png', '2017-06-04');
INSERT INTO `shop_comment` VALUES ('c155905b3bfb42578e80426b1411dcce', '1512393942926', '627f21ccf893421ead0be760f9f8c01d', 'db9450f0e5eb482badc31721fcbdbf61', '4', '2', '../mallupload/1512807325947.png,../mallupload/1512807327873.png', '2017-12-09');
INSERT INTO `shop_comment` VALUES ('c2266e493b7943818cdea1c0cfd713cf', '1496652296106', '205ad4353b4c4e32bc905a54cf649b2b', '657eb8252e3c4861a898b757dc7117b5', '5', 'ww', '', '2017-06-05');
INSERT INTO `shop_comment` VALUES ('d8db9785a0534a3a8cc8a90cfc20e473', '20170509163924837906305', '3a31ea72f7254ae0ba0b0e3c0ea3f5af', '16', '1', '', '../mallupload/1495011572104.png', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('e19834375beb4aa3b7e5d59fb29cd6f7', '1500103644513', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '...', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('e4c9c69f6d1644c48e24a1236db79d51', '1499839608834', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '很好', '', '2017-07-12');
INSERT INTO `shop_comment` VALUES ('ea55797a4da746a9adb78c6621c60634', '20170509163924837906305', '61633342d49e455087d0a27bcb35a166', '16', '1', '', '../mallupload/1495011582132.png', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('eee3b7fd052e4fb7aa54e418587a61be', '1499839584912', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '5', '高品质源码，专注java开发', '', '2017-07-12');
INSERT INTO `shop_comment` VALUES ('ef395267a4214fefa2fa9a4dd102de78', '20170509163924837906305', '1765ea585d654478b4c92b9fe3984009', '16', '1', '', '../mallupload/1495011567350.png', '2017-05-17');
INSERT INTO `shop_comment` VALUES ('f0356933ab514afd9b35f88436fddde8', '1497251033618', '0329bc2713e34cdd81f134c0edfc36cd', 'e60c3b041ecf43a691fc7639f9817898', '5', '1231313', '', '2017-07-15');
INSERT INTO `shop_comment` VALUES ('f8af1cf085014de99cec704b2e3c068c', '1512215190009', '627f21ccf893421ead0be760f9f8c01d', '0c40d1a9047e49ed82f93d115997774f', '5', '测试差评', '../mallupload/1512382074561.png', '2017-12-04');
INSERT INTO `shop_comment` VALUES ('f90ec00e09bc445d8a6f20c633360821', '20170518214547514306040', '1765ea585d654478b4c92b9fe3984009', '16', '1', '此用户没写评语', '', '2017-05-18');
INSERT INTO `shop_comment` VALUES ('fd2e5e668d094358a1b1d8ccadf598dc', '1499839633897', '205ad4353b4c4e32bc905a54cf649b2b', 'e60c3b041ecf43a691fc7639f9817898', '3', '还行', '', '2017-07-12');

-- ----------------------------
-- Table structure for `shop_contact`
-- ----------------------------
DROP TABLE IF EXISTS `shop_contact`;
CREATE TABLE `shop_contact` (
  `CONTACT_ID` varchar(100) NOT NULL,
  `USER_ID` varchar(255) DEFAULT NULL COMMENT '用户',
  `CONTENT` text COMMENT '内容',
  `ADDTIME` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`CONTACT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_contact
-- ----------------------------
INSERT INTO `shop_contact` VALUES ('1a8d21cc0d1c454badfbb2ab3ce5a0f9', '16', '', '2017-04-10 12:17:59');
INSERT INTO `shop_contact` VALUES ('4e0a6ad0014941b4b10e61ae16eafc11', '25', '还', '2017-04-20 13:23:57');
INSERT INTO `shop_contact` VALUES ('866470c688ee4ef4af6066be20036a18', '16', '阿萨德发的撒发生地方', '2017-04-10 13:04:16');
INSERT INTO `shop_contact` VALUES ('879670550d954c018348649f3ef1637e', '16', '微信', '2017-04-21 16:44:06');
INSERT INTO `shop_contact` VALUES ('8e8369c6c099424290d5cad651e26cee', '8', 'The fact ', '2017-03-07 10:38:51');
INSERT INTO `shop_contact` VALUES ('9e515681237a4ed59eb0e343db8b2d6f', '14', '哈哈哈', '2017-03-20 15:20:34');
INSERT INTO `shop_contact` VALUES ('a59b003294614f6587ab1c289f1cc4fa', '12', '', '2017-03-19 00:51:25');
INSERT INTO `shop_contact` VALUES ('ae307e9cb33343168b3f5ba8beb72ecb', null, null, '2017-03-01 14:31:25');
INSERT INTO `shop_contact` VALUES ('b9596e02afb443a99b57b55e6757984a', '16', '不认识', '2017-04-21 16:44:51');
INSERT INTO `shop_contact` VALUES ('c368188807414818a83ad11d1b78a4f8', '8', 'The ', '2017-03-07 10:37:01');
INSERT INTO `shop_contact` VALUES ('ccc4af3574a241bb85368c832cc13b38', '12', '  ', '2017-03-19 00:51:36');
INSERT INTO `shop_contact` VALUES ('ff222addff054e1c8e5624ee3959e48b', '1', 'ASDFASDFDASDFA', '2017-03-01 14:32:06');

-- ----------------------------
-- Table structure for `shop_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `shop_coupon`;
CREATE TABLE `shop_coupon` (
  `coupon_id` varchar(100) NOT NULL,
  `addtime` varchar(255) DEFAULT NULL COMMENT '添加时间',
  `starttime` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `endtime` varchar(255) DEFAULT NULL COMMENT '结束时间',
  `coupon_name` varchar(255) DEFAULT NULL,
  `use_price` decimal(10,2) DEFAULT NULL,
  `coupon_price` decimal(10,2) DEFAULT NULL COMMENT '优惠券价格',
  `coupon_num` varchar(255) DEFAULT NULL COMMENT '兑换码',
  `coupon_count` int(11) NOT NULL COMMENT '优惠券数量',
  `type` int(11) NOT NULL COMMENT '类型',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_coupon
-- ----------------------------
INSERT INTO `shop_coupon` VALUES ('06ba076a46df402fa39d3d2b789bc5e3', '2017-05-13', '2017-10-01', '2017-10-31', '中秋节礼券', '50.00', '50.00', '', '100', '1');
INSERT INTO `shop_coupon` VALUES ('2e50346804814efeb784d7d3db4f63bd', '2017-05-13', '2017-12-25', '2017-12-31', '圣诞节特惠', '10.00', '10.00', '', '100', '1');
INSERT INTO `shop_coupon` VALUES ('73e76c5240ab4cffaf55494105a66f0e', '2017-05-13', '2017-06-01', '2017-06-30', '六一儿童节特惠', '10.00', '10.00', '', '100', '1');
INSERT INTO `shop_coupon` VALUES ('a1eaa2b41db9435ead78850422baf0ae', '2017-05-13', '2018-01-25', '2018-01-31', '除夕礼券', '10.00', '10.00', '', '100', '1');
INSERT INTO `shop_coupon` VALUES ('f0e196303f12472fa74e2e7d77ac9d30', '2017-05-13', '2017-10-01', '2017-10-07', '国庆特惠', '100.00', '100.00', '123453', '100', '2');

-- ----------------------------
-- Table structure for `shop_express`
-- ----------------------------
DROP TABLE IF EXISTS `shop_express`;
CREATE TABLE `shop_express` (
  `express_id` varchar(100) NOT NULL,
  `express_title` varchar(255) DEFAULT NULL COMMENT '编码',
  `express_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`express_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_express
-- ----------------------------
INSERT INTO `shop_express` VALUES ('18c9dd6a5ff04b0dac45f326377581f3', 'YTO', '圆通', '5');
INSERT INTO `shop_express` VALUES ('44cf69da9a934fc38446ec9b68847b76', 'STO', '申通', '4');
INSERT INTO `shop_express` VALUES ('5e1c0fdfa3cc4b6db6daf7ebe2a9367e', 'ZTO', '中通', '3');
INSERT INTO `shop_express` VALUES ('6e8a663ffe3a45deb942656e20568eef', 'GTO', '国通', '11');
INSERT INTO `shop_express` VALUES ('6ee8c0b2d53c412c87d0b6bdc351bc61', 'HHTT', '天天', '9');
INSERT INTO `shop_express` VALUES ('8c938d0bf1da480d9a3f2c9463ff9e5d', 'QFKD', '全峰', '10');
INSERT INTO `shop_express` VALUES ('90038583276c46bbbcb68f01538e9da2', 'UC', '优速', '12');
INSERT INTO `shop_express` VALUES ('c8094d8630ef48429ab76f1be87b716e', 'YD', '韵达', '6');
INSERT INTO `shop_express` VALUES ('cacc529ff7b840df9e444834db9e6d9a', 'HTKY', '百世快递', '2');
INSERT INTO `shop_express` VALUES ('e79a298b3aca406fab0a0ae0b56b1d8a', 'EMS', 'EMS', '8');
INSERT INTO `shop_express` VALUES ('ec03c893ea0f40c5a92b14dec6c5dbc1', 'YZPY', '邮政平邮', '7');
INSERT INTO `shop_express` VALUES ('f1d80b55d8a949a0a9048eea80b1eea1', 'SF', '顺丰', '1');
INSERT INTO `shop_express` VALUES ('fef7ea1013e1462ba0e729ddf1001a04', 'DBL', '德邦', '13');

-- ----------------------------
-- Table structure for `shop_expressconfig`
-- ----------------------------
DROP TABLE IF EXISTS `shop_expressconfig`;
CREATE TABLE `shop_expressconfig` (
  `expressconfig_id` varchar(100) NOT NULL,
  `partner_id` varchar(255) DEFAULT NULL COMMENT '商户id',
  `partner_key` varchar(255) DEFAULT NULL COMMENT '私钥',
  PRIMARY KEY (`expressconfig_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_expressconfig
-- ----------------------------
INSERT INTO `shop_expressconfig` VALUES ('1', '1289307', '4c6eb73b-2428-49ed-a388-389def377d1b');

-- ----------------------------
-- Table structure for `shop_freight`
-- ----------------------------
DROP TABLE IF EXISTS `shop_freight`;
CREATE TABLE `shop_freight` (
  `freight_id` varchar(100) NOT NULL,
  `freight_price` decimal(10,2) DEFAULT NULL COMMENT '运费价格',
  `freight_free_price` decimal(10,2) DEFAULT NULL COMMENT '免邮价格',
  PRIMARY KEY (`freight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_freight
-- ----------------------------
INSERT INTO `shop_freight` VALUES ('1', '0.00', '301.00');

-- ----------------------------
-- Table structure for `shop_goods`
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods` (
  `goods_id` varchar(255) NOT NULL,
  `goods_pic` text,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_title` varchar(255) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `goods_num` int(11) DEFAULT '0' COMMENT '总量',
  `spec_name` varchar(255) DEFAULT NULL COMMENT '属性/规格 名称',
  `spec_title` varchar(255) DEFAULT NULL COMMENT '具体内容',
  `spec_price` varchar(255) DEFAULT NULL COMMENT '规格对应的价格',
  `goods_detail` text,
  `goods_sales` int(11) DEFAULT '0' COMMENT '销量',
  `sort` int(255) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `tuijian` varchar(255) DEFAULT NULL,
  `reason_return` int(11) DEFAULT '1' COMMENT '是否七天无理由',
  `sell_count` int(11) DEFAULT '0',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES ('0d32bc229af84724bd3a94f337975abd', '/mallupload/1512998798465.png,/mallupload/1512998801661.png,/mallupload/1512998804377.png', '吉列维纳斯女士专用优惠装（1刀架+2刀头）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallupload/image/20171211/20171211212739_936.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('2114ee0f055845d799799693a9a183d4', '/mallupload/1513000050406.png', '妮维雅(NIVEA)女士防晒隔离保湿套装(爽肤水200ml+日霜50ml+隔离50ml 女士化妆品套装)', ' ', '0.02', '1000', null, null, null, '<img src=\"/mallupload/image/20171211/20171211214843_284.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('2e75f0ca114f489f9fbe7fef66d82c8d', '/mallupload/1512999492283.png', '美宝莲（MAYBELLINE） 净澈多效卸妆水 400ml（卸妆 清洁 补水 舒缓）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallupload/image/20171211/20171211213850_384.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('56e4ba94deaa436bb901fd9c86c00bee', '/mallupload/1512999570455.png', '御泥坊 水润柔嫩面贴21片（男女士面膜贴 深层清洁 黑面膜套装 平衡水油）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211214017_550.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('61bdd99a3b184bcc964ea3ce9d61baa7', '/mallupload/1512999353702.png', '森田 玻尿酸复合原液面膜10片（台湾原产，森田药妆 补水保湿 长效锁水）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211213715_679.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211213715_866.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('77ee5f0a8b57485c9f1b69d2c7b40de8', '/mallupload/1512998243061.png,/mallupload/1512998246562.png', '欧莱雅（LOREAL）男士矿漠泥长效控油保湿露 50ml（护肤品 男士爽肤水 补水）', '寒冷冬季，巴黎欧莱雅带你告别肌肤干燥缺水，美丽优雅先人一步。优惠不容错过，低至每满199减100，爆品低至四折，快戳。你值得拥有。', '0.01', '3000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211211936_49.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211211937_823.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211211937_639.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', '1', null, '0');
INSERT INTO `shop_goods` VALUES ('8e1473d1350b4894bbffe1cdffac055c', '/mallupload/1512999796593.png,/mallupload/1512999799213.png', '自然堂（CHANDO）纯粹滋润冰肌水（凝润型）160ml（爽肤水 化妆水，新老包装随机）', '自然堂邀你美美燥起来！', '0.01', '1000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211214426_393.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('ab7107925a6647cfae4b1de208386a16', '/mallupload/1512997685558.png,/mallupload/1512997688211.png', '玉兰油Olay护肤套装多效修护经典礼盒装（多效修护霜50g+醒肤水150ml）化妆品补水保湿套装', 'Olay玉兰油护肤爆款部分每满199减100！美力全开，好礼不容错过！', '0.01', '100000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211211313_249.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211211313_902.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211211313_828.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, '1', '0');
INSERT INTO `shop_goods` VALUES ('af2512255d3a4dd283b1f67e23019171', '/mallupload/1512999735704.png', '欧莱雅 （LOREAL） 三合一卸妆洁颜水 倍润型 400ml（欧莱雅女士 魔术水 卸妆水 洁面 保湿）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallupload/image/20171211/20171211214208_470.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', null, null, '0');
INSERT INTO `shop_goods` VALUES ('b8f5fcc6e4e24b6a807905037e23911e', '/mallupload/1512999015132.png', ' 御泥坊 红石榴鲜活矿物睡眠面膜180g（补水 改善暗沉 提亮肤色 夜间修护免洗 男女护肤）', ' ', '0.01', '12000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211213329_858.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211213329_747.jpg\" alt=\"\" /><img src=\"/mallweb/../mallupload/image/20171211/20171211213329_148.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', '1', '1', '0');
INSERT INTO `shop_goods` VALUES ('f6cb87b276214eb9a9899092db1b82d0', '/mallupload/1513000006455.png', '欧诗漫OSM化妆品套装营养美肤晶彩无暇补水保湿护肤品套装女（洗面奶+爽肤水+眼霜+乳+霜）', ' ', '0.01', '1000', null, null, null, '<img src=\"/mallweb/../mallupload/image/20171211/20171211214639_831.jpg\" alt=\"\" />', null, null, '43763591b7af439aaa962a014d0241de', '1', '1', '0');

-- ----------------------------
-- Table structure for `shop_grade`
-- ----------------------------
DROP TABLE IF EXISTS `shop_grade`;
CREATE TABLE `shop_grade` (
  `GRADE_ID` varchar(100) NOT NULL,
  `INTEGRAL_COUNT` int(11) DEFAULT NULL COMMENT '积分',
  `CALL_NAME` varchar(255) DEFAULT NULL COMMENT '称呼',
  `ADDTIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GRADE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_grade
-- ----------------------------
INSERT INTO `shop_grade` VALUES ('0cafb388111e4f189c2a6cfd75b574cd', '500', '夺宝小将', '2');
INSERT INTO `shop_grade` VALUES ('10c6f2a67e7348689e49f90c9a6434c9', '2000', '夺宝上将', '2017-03-14 17:37:00');
INSERT INTO `shop_grade` VALUES ('3037a1704c3f46d08aaceafa70d184dc', '10000', '夺宝元帅', '2017-03-14 17:38:02');
INSERT INTO `shop_grade` VALUES ('45680853400341289bd2a26aa70385c8', '5000', '夺宝大将', '2017-03-14 17:37:13');
INSERT INTO `shop_grade` VALUES ('565a1ee7ac94469dbfec941452c06aea', '100', '夺宝新手', '1');
INSERT INTO `shop_grade` VALUES ('d31e53bad28540f38aa0fce085ba9b91', '1000', '夺宝中将', '2017-03-14 17:36:48');

-- ----------------------------
-- Table structure for `shop_information`
-- ----------------------------
DROP TABLE IF EXISTS `shop_information`;
CREATE TABLE `shop_information` (
  `information_ID` varchar(100) NOT NULL,
  `information_img` varchar(255) DEFAULT NULL COMMENT '图片',
  `information_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `type` int(11) NOT NULL COMMENT '类别',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`information_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_information
-- ----------------------------

-- ----------------------------
-- Table structure for `shop_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `shop_navigation`;
CREATE TABLE `shop_navigation` (
  `NAVIGATION_ID` varchar(100) NOT NULL,
  `NAVIGATION_IMG` varchar(255) DEFAULT NULL COMMENT '图标',
  `NAVIGATION_NAME` varchar(255) DEFAULT NULL COMMENT '名称',
  `NAVIGATION_URL` varchar(255) DEFAULT NULL COMMENT '链接',
  `navigation_app_url` varchar(255) DEFAULT NULL COMMENT '小程序的url',
  `SORT` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`NAVIGATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_navigation
-- ----------------------------
INSERT INTO `shop_navigation` VALUES ('03c508122efc4121866d722b25cf93fa', '/mallupload/1513000684688.png', '领券', 'http://qanpai.com/mall/coupon/tolist', '', '4');
INSERT INTO `shop_navigation` VALUES ('1', '/mallupload/1513057781550.png', '进口产品', 'goods/info/77ee5f0a8b57485c9f1b69d2c7b40de8', 'goods_info/77ee5f0a8b57485c9f1b69d2c7b40de8', '2');
INSERT INTO `shop_navigation` VALUES ('2', '/mallupload/1513000772764.png', '超市', 'goods/info/0d32bc229af84724bd3a94f337975abd', 'goods_info/0d32bc229af84724bd3a94f337975abd', '1');
INSERT INTO `shop_navigation` VALUES ('3', '/mallupload/1513000715490.png', '全球购', 'goods/info/f6cb87b276214eb9a9899092db1b82d0', 'goods_info/f6cb87b276214eb9a9899092db1b82d0', '3');

-- ----------------------------
-- Table structure for `shop_news`
-- ----------------------------
DROP TABLE IF EXISTS `shop_news`;
CREATE TABLE `shop_news` (
  `news_id` varchar(100) NOT NULL,
  `news_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `news_content` text COMMENT '内容',
  `addtime` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL COMMENT '排序',
  `type` int(11) NOT NULL COMMENT '类别',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_news
-- ----------------------------
INSERT INTO `shop_news` VALUES ('80ffd90157b54ed0923d70bd8e533d8e', '这份源码怎么这么贵？', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所谓一分钱一分货，我们三位开发工程师2个月完成初版，后续持续更新，我们保证源码一直维护下去，所以请放心购买！另外小程序一个月后开始出售，现在购买公众号，附赠小程序源码！您还在等什么！', '2017-08-11', '1', '1');
INSERT INTO `shop_news` VALUES ('94ae3593360f42b39a47a111006f1d25', '源码使用什么技术，有哪些功能？', '源码使用高性能的JAVA语言，架构为springmvc+mybatis+spring+maven+mysql ，前台前端使用h5+css3 ，后台前端使用boostrap-ace技术，大致功能如下：<br />\r\n二级分类：采用二级分类，适用于商品繁多或者大型电商使用；<br />\r\n商品发布：含库存及多属性规格等功能；<br />\r\n物流管理：商家发货可以填写物流单，用户及商家可以在线查看物流动态（也可无需物流发货）；<br />\r\n评价系统：用户完成购买流程后，可以评价本次交易；<br />\r\n优惠券：商家设置优惠券，用户领券购买，优惠券可设置使用门槛；<br />\r\n运费系统：可以设置运费标的（满多少免邮、全场免邮等）；<br />\r\n在线客服：使用网易七鱼客服系统，强大的让人无法想象；<br />\r\n在线支付：使用微信支付（由于阿里和腾讯的竞争关系，微信里无法使用支付宝）；<br />\r\n在线退款：订单如含有多种商品可以单种商品退款，后台点击退款后直接操作成功，无需到微信商户后台点击退款，真正智能<br />\r\n微信管理：菜单、回复等管理（接入网易七鱼后，可以接入人工服务）', '2017-08-11', '2', '1');

-- ----------------------------
-- Table structure for `shop_notice`
-- ----------------------------
DROP TABLE IF EXISTS `shop_notice`;
CREATE TABLE `shop_notice` (
  `NOTICE_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `CONTENT` text COMMENT '内容',
  `ADDTIME` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`NOTICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `shop_order`
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order` (
  `order_id` varchar(100) NOT NULL,
  `addtime` varchar(255) DEFAULT NULL COMMENT '下单时间',
  `total_price` decimal(10,0) DEFAULT NULL,
  `order_total` decimal(10,2) NOT NULL COMMENT '总价',
  `coupon_price` decimal(10,2) DEFAULT NULL,
  `coupon_id` varchar(255) DEFAULT NULL,
  `freight_price` decimal(10,2) DEFAULT NULL,
  `pay_way` varchar(255) DEFAULT NULL COMMENT '支付方式1支付宝2微信3商城币',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `addr_realname` varchar(255) DEFAULT NULL,
  `addr_phone` varchar(255) DEFAULT NULL,
  `addr_city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `user_ip` varchar(255) DEFAULT NULL COMMENT '用户ip',
  `status` int(11) DEFAULT NULL COMMENT '状态,0未支付，1 已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成',
  `express_title` varchar(255) DEFAULT NULL COMMENT '快递编号',
  `express_name` varchar(255) DEFAULT NULL COMMENT '快递名称',
  `express_num` varchar(255) DEFAULT NULL COMMENT '快递号码',
  `transaction_id` varchar(255) DEFAULT NULL COMMENT '微信支付id',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES ('1500647363008', '2017-07-21 22:29:23', '3499', '3499.00', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '哈哈', '13800138000', '江苏省 南京市 玄武区', 'huijingjiayuan3301', ' ', '127.0.0.1', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1500647393337', '2017-07-21 22:29:53', '3499', '3499.00', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '哈哈', '13800138000', '江苏省 南京市 玄武区', 'huijingjiayuan3301', ' ', '127.0.0.1', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1500647836067', '2017-07-21 22:37:16', '3499', '3449.00', '50.00', '06ba076a46df402fa39d3d2b789bc5e3', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', ' ', '127.0.0.1', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1500895551046', '2017-07-24 19:25:51', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', ' ', '127.0.0.1', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1500897553542', '2017-07-24 19:59:13', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', ' ', '127.0.0.1', '2', 'SF', '顺丰', 'fsdf123123', null);
INSERT INTO `shop_order` VALUES ('1500899034861', '2017-07-24 20:23:54', '0', '0.04', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', ' ', '127.0.0.1', '2', 'STO', '申通', '367239317491', null);
INSERT INTO `shop_order` VALUES ('1500900245397', '2017-07-24 20:44:05', '0', '0.10', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', ' ', '127.0.0.1', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1501300775960', '2017-07-29 11:59:35', '3499', '3499.00', '0.00', '0', '0.00', '2', 'adfdb3a5f09040768a2f952437792fe1', '厕测试', '188888888888', '江苏省 南京市 玄武区', '测试地址', '北京市 北京市', '106.121.74.193', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1501412455511', '2017-07-30 19:00:55', '0', '0.01', '0.00', '0', '0.00', '2', '16', '张三', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道玄武大道299号汇景佳园1栋1101室', '0', '180.102.23.206', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1501720714593', '2017-08-03 08:38:34', '729', '729.00', '0.00', '0', '0.00', '2', 'b0d8d29bb74a46deb667d09ec13f37d3', '李俊奕', '18605259288', '江苏省 镇江市 扬中市', '三茅街道长江花城四期25幢702室', ' ', '127.0.0.1', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503039092848', '2017-08-18 14:51:32', '37', '36.80', '0.00', '0', '0.00', '2', 'b4c3e8730dfa46f88780fe9aaff244f4', 'ghj', '18072194067', '江苏省 南京市 玄武区', '对比就不计较。', '湖南省 长沙市', '218.77.53.26', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503039593458', '2017-08-18 14:59:53', '37', '36.80', '0.00', '0', '0.00', '2', 'b4c3e8730dfa46f88780fe9aaff244f4', 'ghj', '18072194067', '江苏省 南京市 玄武区', '对比就不计较。', '湖南省 长沙市', '218.77.53.26', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503104521026', '2017-08-19 09:02:01', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '江苏省 南京市', '180.102.21.154', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503104902167', '2017-08-19 09:08:22', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '江苏省 南京市', '180.102.21.154', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503284840853', '2017-08-21 11:07:20', '3099', '3099.00', '0.00', '0', '0.00', '2', '3c8b3a6655314690a5953920c58ae66e', '啊啊啊', '13666666666', '江苏省 南京市 玄武区', '啊啊啊', '陕西省 宝鸡市', '124.115.135.55', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503288107621', '2017-08-21 12:01:47', '3499', '3499.00', '0.00', '0', '0.00', '2', '3c8b3a6655314690a5953920c58ae66e', '啊啊啊', '13666666666', '江苏省 南京市 玄武区', '啊啊啊', '陕西省 宝鸡市', '124.115.135.55', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1503377150908', '2017-08-22 12:45:50', '1088', '1088.00', '0.00', '0', '0.00', '2', '6ae7654206e645e7974cda1c7f84cfce', '侯先生', '13617418488', '江苏省 南京市 玄武区', '街道', '湖南省 株洲市', '111.22.72.80', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1504180222893', '2017-08-31 19:50:22', '3499', '3499.00', '0.00', '0', '0.00', '2', '98ca6a4d667f4e9689f33f3006b0322f', '啊习', '18888888888', '江苏省 南京市 玄武区', '哈哈哈哈哈哈哈哈哈哈哈哈还吃过啊啊啊', '北京市 北京市', '61.148.244.5', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1504260515881', '2017-09-01 18:08:35', '37', '36.90', '0.00', '0', '0.00', '2', '07573ce2135a41abbcefdcbc7a4b6fd2', '包晋升', '13721103139', '江苏省 南京市 玄武区', '天山路60号', '安徽省 合肥市', '218.22.27.159', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1504679354066', '2017-09-06 14:29:14', '3099', '3099.00', '0.00', '0', '0.00', '2', '98ca6a4d667f4e9689f33f3006b0322f', '啊习', '18888888888', '江苏省 南京市 玄武区', '哈哈哈哈哈哈哈哈哈哈哈哈还吃过啊啊啊', '湖北省 武汉市', '220.249.92.154', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1505054810689', '2017-09-10 22:46:50', '0', '0.30', '0.00', '0', '0.00', '2', '30a4338cb04a46899bb78b5a34c6e561', 'hi', '13715063658', '江苏省 南京市 玄武区', '442542', '广东省 广州市', '14.25.46.194', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1505810289815', '2017-09-19 16:38:09', '3099', '3099.00', '0.00', '0', '0.00', '2', '9266bb3662694dee959ba8232e3f5b12', '喝喝喝', '114', '江苏省 南京市 玄武区', '哈哈哈哈', '重庆市 重庆市', '125.84.84.156', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1506663060476', '2017-09-29 13:31:00', '0', '0.01', '0.00', '0', '0.00', '2', '8ef911a19d434537931659008a08477d', '12', '12', '江苏省 南京市 玄武区', '12', '辽宁省 沈阳市', '175.167.146.252', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1507429059694', '2017-10-08 10:17:39', '5688', '5688.00', '0.00', '0', '0.00', '2', '2bfc523f23d3497fb3c42c15c33b1031', '吧', '18521529110', '江苏省 南京市 玄武区', '4888', '江苏省 苏州市', '112.86.17.206', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1507627626882', '2017-10-10 17:27:06', '0', '0.01', '0.00', '0', '0.00', '2', 'cae2178052264db1a6f475ac89347a93', 'mysun', '13172788888', '江苏省 南京市 玄武区', '中山大学', '广东省 广州市', '113.67.72.43', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1507648999100', '2017-10-10 23:23:19', '0', '0.03', '0.00', '0', '0.00', '2', 'f31eab0144f24784b3dfb64e924ddc1c', '石峰', '13579020022', '新疆维吾尔自治区 巴音郭楞蒙古自治州 库尔勒市', '了', '新疆维吾尔自治区 巴音郭楞蒙古自治州', '218.84.181.39', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1507788370319', '2017-10-12 14:06:10', '0', '0.04', '0.00', '0', '0.00', '2', 'f31eab0144f24784b3dfb64e924ddc1c', 'ABC', '13579020022', '江苏省 南京市 玄武区', 'abc', '新疆维吾尔自治区 巴音郭楞蒙古自治州', '110.155.209.104', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1507975047429', '2017-10-14 17:57:27', '3499', '3499.00', '0.00', '0', '0.00', '2', '10f1e52f4b864159a6fa432b7f11b2d7', '11', '13824372371', '江苏省 南京市 玄武区', '了了了了扣扣图兔兔', '浙江省 台州市', '122.226.185.96', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508327102335', '2017-10-18 19:45:02', '3099', '3099.00', '0.00', '0', '0.00', '2', 'a1d4b699269d45b8aa66d9687395a186', '班', '13013013013', '江苏省 南京市 玄武区', '了哦哦哦', '广东省 ', '117.136.40.20', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508403233210', '2017-10-19 16:53:53', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '安徽省 宿州市', '36.4.58.92', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508430608272', '2017-10-20 00:30:08', '0', '0.01', '0.00', '0', '0.00', '2', '6339c3f3957a44bbad923c21e4b0a70c', '哈哈', '123456789', '江苏省 南京市 玄武区', '哈哈', '广东省 惠州市', '120.229.165.167', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508477511882', '2017-10-20 13:31:51', '14686', '14686.00', '0.00', '0', '0.00', '2', 'd561106cf91940899f3cf8e9e3bad284', '罢了', '12365478963', '江苏省 南京市 玄武区', '酷兔兔', '陕西省 汉中市', '123.139.169.140', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508749737944', '2017-10-23 17:08:57', '3499', '3499.00', '0.00', '0', '0.00', '2', '2dd371f206644d24979a270ab0449544', '1', '188888888', '江苏省 南京市 玄武区', '123', '河北省 邢台市', '120.14.111.53', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508845617264', '2017-10-24 19:46:57', '5688', '5688.00', '0.00', '0', '0.00', '2', '81cfab13adb04aec953bcdd68defa863', '闫繁宇', '18017912555', '江苏省 南京市 玄武区', '你好', '上海市 上海市', '101.90.254.58', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1508983763179', '2017-10-26 10:09:23', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '安徽省 宿州市', '36.4.58.250', '2', 'YTO', '圆通', '810946298582', null);
INSERT INTO `shop_order` VALUES ('1508984350445', '2017-10-26 10:19:10', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '安徽省 宿州市', '36.4.58.250', '6', 'SF', '顺丰', '657657', null);
INSERT INTO `shop_order` VALUES ('1509523654351', '2017-11-01 16:07:34', '0', '0.01', '0.00', '0', '0.00', '2', 'fff46e48c6224b70bce05da586e832ae', '吃', '158424516', '江苏省 南京市 玄武区', '就回你', '江苏省 徐州市', '180.104.108.118', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1509970523601', '2017-11-06 20:15:23', '0', '0.01', '0.00', '0', '0.00', '2', '6c8d3c22a2724d46be22198ed6896bc1', '小莉', '13585884553', '江苏省 南京市 玄武区', '11号', '上海市 上海市', '223.104.212.189', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510076974007', '2017-11-08 01:49:34', '3536', '3535.92', '0.00', '0', '0.00', '2', 'acf343229dfd41428279445fd6c734d2', '张大', '18650124560', '福建省 厦门市 湖里区', '垃圾', '福建省 厦门市', '106.122.182.7', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510297307585', '2017-11-10 15:01:47', '13996', '13996.00', '0.00', '0', '0.00', '2', '93b7cb4ea77a4ea683d0f30bf55fa00f', '不良记录', '150424242424', '江苏省 南京市 玄武区', '255585', '辽宁省 大连市', '124.93.57.187', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510304546851', '2017-11-10 17:02:26', '0', '0.01', '0.00', '0', '0.00', '2', 'acf343229dfd41428279445fd6c734d2', '张大', '18650124560', '福建省 厦门市 湖里区', '垃圾', '福建省 ', '211.97.131.156', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510307768788', '2017-11-10 17:56:08', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '安徽省 阜阳市', '183.162.41.109', '1', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510309504554', '2017-11-10 18:25:04', '0', '0.01', '0.00', '0', '0.00', '2', 'acf343229dfd41428279445fd6c734d2', '张大', '18650124560', '福建省 厦门市 湖里区', '垃圾', '福建省 ', '211.97.131.156', '1', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510539138351', '2017-11-13 10:12:18', '5688', '5678.00', '10.00', '2e50346804814efeb784d7d3db4f63bd', '0.00', '2', 'dc4c0243eb694bbf9ece88b715460998', '习近平', '13800138000', '江西省 南昌市 市辖区  ', '哈哈', '安徽省 宿州市', '36.4.58.92', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510579289476', '2017-11-13 21:21:29', '3099', '3099.00', '0.00', '0', '0.00', '2', 'dc4c0243eb694bbf9ece88b715460998', '习近平', '13800138000', '江西省 南昌市 市辖区  ', '哈哈', '安徽省 宿州市', '36.4.58.92', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510579313445', '2017-11-13 21:21:53', '3099', '3099.00', '0.00', '0', '0.00', '2', 'dc4c0243eb694bbf9ece88b715460998', '还', '138888888888888', '山西省 太原市 市辖区', '刚回来吉利哼哼唧唧吉里吉里吉里吉里吉里吉里吉里吉里丽丽', '安徽省 宿州市', '36.4.58.92', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510645043210', '2017-11-14 15:37:23', '5725', '5724.80', '0.00', '0', '0.00', '2', '6a8c8b3f73e8482d82f486e93feb54b8', '港股', '15822222222', '江苏省 南京市 玄武区', '中山路', '浙江省 杭州市', '115.236.37.238', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510719490241', '2017-11-15 12:18:10', '729', '729.00', '0.00', '0', '0.00', '2', 'dc4c0243eb694bbf9ece88b715460998', '习近平', '13800138000', '江西省 南昌市 市辖区  ', '哈哈', '安徽省 合肥市', '36.60.49.228', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510719523351', '2017-11-15 12:18:43', '0', '0.01', '0.00', '0', '0.00', '2', 'dc4c0243eb694bbf9ece88b715460998', '习近平', '13800138000', '江西省 南昌市 市辖区  ', '哈哈', '安徽省 合肥市', '36.60.49.228', '1', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510889617476', '2017-11-17 11:33:37', '5880', '5880.00', '0.00', '0', '0.00', '2', 'd2ec5978ed154401864ec2fa14589676', '哦哦哦', '13522556554', '江苏省 南京市 玄武区', '来咯哦了急用', '山东省 威海市', '60.212.221.172', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1510913549976', '2017-11-17 18:12:30', '37', '36.80', '0.00', '0', '0.00', '2', 'c5de0f47ccab4f7da32b9c173f62edfc', '秦淮', '18201632858', '北京 北京市 丰台区', '翠海', '北京市 北京市', '103.3.120.2', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1511504451764', '2017-11-24 14:20:51', '0', '0.10', '0.00', '0', '0.00', '2', 'fc2d41d465f440ec82ffafd9e271bf28', 'a', '18681727333', '江苏省 南京市 玄武区', '测试', '四川省 成都市', '119.4.252.28', '1', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1511928859734', '2017-11-29 12:14:19', '3099', '3099.00', '0.00', '0', '0.00', '2', '16', '张三', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道玄武大道299号汇景佳园1栋1101室', '安徽省 宿州市', '36.4.59.14', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1511929081346', '2017-11-29 12:18:01', '0', '0.01', '0.00', '0', '0.00', '2', 'e60c3b041ecf43a691fc7639f9817898', '王明', '13800138000', '江苏省 南京市 玄武区', '玄武湖街道板仓街世界之窗产业园太阳宫1052号', '安徽省 宿州市', '36.4.59.14', '1', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1512057357437', '2017-11-30 23:55:57', '0', '0.01', '0.00', '0', '0.00', '2', 'd98fa1f741814d52930f0016905e81c6', 'test', '138888888888', '江苏省 南京市 玄武区', 'test 不要发货', '江苏省 无锡市', '117.136.46.67', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1512204972319', '2017-12-02 16:56:12', '0', '0.01', '0.00', '0', '0.00', '2', '0c40d1a9047e49ed82f93d115997774f', '刘先生', '18191069854', '陕西省 西安市 莲湖区', '汉城北路', '陕西省 西安市', '111.18.36.224', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1512215190009', '2017-12-02 19:46:30', '0', '0.01', '0.00', '0', '0.00', '2', '0c40d1a9047e49ed82f93d115997774f', '刘先生', '18191069854', '陕西省 西安市 莲湖区', '汉城北路', '陕西省 西安市', '111.18.36.224', '6', 'YTO', '圆通', '600486384177', null);
INSERT INTO `shop_order` VALUES ('1512380598151', '2017-12-04 17:43:18', '0', '0.01', '0.00', '0', '0.00', '2', '1a5c91f5800f42948249086f7c84f99f', 'undefined', 'undefined', '北京 北京市 东城区', 'undefined', '陕西省 西安市', '111.18.36.247', '4', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1512390448983', '2017-12-04 20:27:28', '4199', '4199.00', '0.00', '0', '0.00', '2', 'db9450f0e5eb482badc31721fcbdbf61', 'HHHH', '13088888', '北京 北京市 东城区', 'SDAFSADFSDSS', '安徽省 宿州市', '36.4.59.220', '0', null, null, null, null);
INSERT INTO `shop_order` VALUES ('1512393942926', '2017-12-04 21:25:42', '0', '0.01', '0.00', '0', '0.00', '2', 'db9450f0e5eb482badc31721fcbdbf61', '1', '1', '北京 北京市 东城区', '1', '安徽省 宿州市', '36.4.59.220', '5', 'YD', '韵达', '3831316173082', null);

-- ----------------------------
-- Table structure for `shop_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_detail`;
CREATE TABLE `shop_order_detail` (
  `order_detail_id` varchar(255) NOT NULL,
  `goods_id` varchar(255) DEFAULT NULL,
  `goods_pic` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `goods_count` int(11) DEFAULT NULL,
  `goods_total` decimal(10,2) DEFAULT NULL,
  `attribute_detail_id` varchar(255) DEFAULT NULL,
  `attribute_detail_name` varchar(255) DEFAULT '',
  `pay_total` decimal(10,2) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态,0未支付，1 已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成',
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_order_detail
-- ----------------------------
INSERT INTO `shop_order_detail` VALUES ('012ea57a38d44c89a187afd66ab9aa06', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1510579289476', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('0d53ff5e99944131be1834b6d29961d8', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3499.00', '1500647363008', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('0faa6f6e4e654581ab1b1656e5cc2258', 'e1262011793c46038a072daf9d54d8c3', '/mallupload/1500608841627.png', 'Asus/华硕 R RX310UA7100超薄13手提游戏轻薄便携学生笔记本电脑', '0.01', '1', '0.01', null, '', '0.01', '1509523654351', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('194e27111e884e6a9cefc83785436094', '640554e89f144d61916f4c7660cad5e7', '/mallupload/1500608236033.png', 'Apple/苹果 iPhone 7 Plus 移动联通4G智能手机', '5880.00', '1', '5880.00', null, '黑色,64G', '5880.00', '1510889617476', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('1d647a6f122b445b9c1c9687f929f01b', '0c78d9da52d84fc88968dad05087ad2f', '/mallupload/1500609388127.png', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '729.00', '1', '729.00', null, '', '729.00', '1510719490241', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('21456faf66ba4c308cb708ad34fb201c', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1512393942926', '0', '5');
INSERT INTO `shop_order_detail` VALUES ('27fe69fb2d3844149b3e9f674bd5104d', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1512393942926', '0', '5');
INSERT INTO `shop_order_detail` VALUES ('2f2dd01f094a4141abdc5cd32eba390b', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1503104902167', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('31ed454f4e8c44db903c8c007fa4bc59', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1505810289815', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('3a3ad048783a479cb217b5c745c820e0', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3499.00', '1500647393337', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('3a61ed614c4a41e491aebe3e350da3c5', 'e1262011793c46038a072daf9d54d8c3', '/mallupload/1500608841627.png', 'Asus/华硕 R RX310UA7100超薄13手提游戏轻薄便携学生笔记本电脑', '0.01', '1', '0.01', null, '', '0.01', '1508430608272', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('43e328450e4643a5959423ed314bc0f7', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '月光银,128G', '3499.00', '1507975047429', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('46488617156b434aa228cfb2edfa4441', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.10', '1', '0.10', null, 'SI/小瑕,D-E/极白,1克拉', '0.10', '1500900245397', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('4f422a36f8f346789fa822bc1d458397', '640554e89f144d61916f4c7660cad5e7', '/mallupload/1500608236033.png', 'Apple/苹果 iPhone 7 Plus 移动联通4G智能手机', '6288.00', '1', '6288.00', null, '黑色,128G', '6288.00', '1508477511882', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('51b3fc4f19404464ae1beaf16eb08b89', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1503104521026', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('572820d7bbcd4bdda124fd6fc8a4d401', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.10', '1', '0.10', null, 'SI/小瑕,D-E/极白,1克拉', '0.10', '1511504451764', '0', '1');
INSERT INTO `shop_order_detail` VALUES ('5998944b17294778a7d12f6f512a4068', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '苍穹灰,128G', '3499.00', '1504180222893', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('5bb67a8458d7400fb5f9076bfca2c5f3', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1510645043210', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('6311b177d68347768802ef17807d1be4', '210d59848d2a4f848c5c3c6556732cfb', '/mallupload/1500609651183.png', 'Meizu/魅族 魅蓝Note5全网通4G快充大电池智能手机', '1088.00', '1', '1088.00', null, '4G全网通,月光银,64G', '1088.00', '1503377150908', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('65b39f45836f4918b512686eea983dde', '47560d41556c4c96b14f7d1d98936f16', '/mallupload/1500608735171.png', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '5688.00', '1', '5688.00', null, '谜夜黑,64G', '5688.00', '1508845617264', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('66c9fafec0e34edf9aeacb232451c2fe', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1512215190009', '0', '5');
INSERT INTO `shop_order_detail` VALUES ('67d22f8f6a38455a8201139b044824aa', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3499.00', '1510076974007', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('67dc86920eed41ebbcb017576dc51733', '47560d41556c4c96b14f7d1d98936f16', '/mallupload/1500608735171.png', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '5688.00', '1', '5688.00', null, '绮梦金,64G', '5688.00', '1507429059694', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('6cff09a0579a44daaee602b15213fb11', '47560d41556c4c96b14f7d1d98936f16', '/mallupload/1500608735171.png', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '5688.00', '1', '5688.00', null, '谜夜黑,64G', '5688.00', '1510645043210', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('74c0998363d8424a938520cad3e402f6', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1512057357437', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('7b642b9529404ca18dc4b0e2e57beb94', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1508403233210', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('7bb21b1a627c442ebcc5267fb54cafcf', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1503284840853', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('7ce7babf11dc48008bdb858eef871713', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1508983763179', '0', '2');
INSERT INTO `shop_order_detail` VALUES ('7d47ff7d85d34cdbae8880ff1335c30f', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1501412455511', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('7fa1533de6504639a6efb86c74a620c8', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3499.00', '1508749737944', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('844ffbcc80724a248bf07be778af593e', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1509970523601', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('8989e0788dcb4e65adf7d3cec014661a', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3449.00', '1500647836067', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('8e6002d05ae449eca26fa86ee03377da', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1510719523351', '0', '1');
INSERT INTO `shop_order_detail` VALUES ('904bcfb559af4b03adeb78c4fc97927f', 'b8e71a42aec649bda125f7d5420c3354', '/mallupload/1500609326237.png', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '4199.00', '2', '8398.00', null, '', '8398.00', '1508477511882', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('90c7032828d94e7684b01987c23f5cc5', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '月光银,128G', '3499.00', '1503288107621', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('92b9e60e630842418daf3153a4c0b4a2', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '4', '13996.00', null, '黑色,128G', '13996.00', '1510297307585', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('9cbe9794221c4c15a77ca5244fb45f67', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1510579313445', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('9da60bfea3c5483da59a7f52a44eb89d', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1500895551046', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('a32825796c154027a286a3d1395c9868', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '苍穹灰,64G', '3099.00', '1508327102335', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('a704f04082e74804a4351fc50bf68b52', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1503039092848', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('b09704f970c94a269197c21ff3252b3e', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.03', '1', '0.03', null, 'VS/微瑕,D-E/极白,30分', '0.03', '1507788370319', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('b599341328a54cf1834bea417a67061f', 'e1262011793c46038a072daf9d54d8c3', '/mallupload/1500608841627.png', 'Asus/华硕 R RX310UA7100超薄13手提游戏轻薄便携学生笔记本电脑', '0.01', '1', '0.01', null, '', '0.01', '1507627626882', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('b6a4bbaa24164ca0b2e1c2dc2bd05252', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1510076974007', '2', '0');
INSERT INTO `shop_order_detail` VALUES ('b6e090bfd4ba4d9e9f3f68a65c478882', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1510309504554', '0', '1');
INSERT INTO `shop_order_detail` VALUES ('b930233199fc43c487ef1e24d7169bb0', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1510307768788', '0', '1');
INSERT INTO `shop_order_detail` VALUES ('ba0db255e4d2440aa5ac6a84a524d6e9', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.04', '1', '0.04', null, 'VS/微瑕,F-G/优白,30分', '0.04', '1500899034861', '0', '2');
INSERT INTO `shop_order_detail` VALUES ('c782645136ad4d3bb18669f75ddba044', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1504260515881', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('cc0e37a3cc7c4ec6bef02e199f15f61b', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1507788370319', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('d0af448c4c224863b3e11a619e88914c', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1511929081346', '0', '1');
INSERT INTO `shop_order_detail` VALUES ('d43455a903a64de48102dbfb8fd6bcd3', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1512380598151', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('da3a0396dbd84ff4942553777fd56557', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3499.00', '1', '3499.00', null, '黑色,128G', '3499.00', '1501300775960', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('da9b6f39b5d048f2a37bf7223a62bf38', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1507648999100', '1', '0');
INSERT INTO `shop_order_detail` VALUES ('df51b5f7a70e4154a012c29a8a4996cb', '47560d41556c4c96b14f7d1d98936f16', '/mallupload/1500608735171.png', 'Samsung/三星 Galaxy S8 SM-G9500 全网通 4G手机', '5688.00', '1', '5688.00', null, '绮梦金,64G', '5678.00', '1510539138351', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('df68195927814c1292cc84f2ed3e559f', '0c78d9da52d84fc88968dad05087ad2f', '/mallupload/1500609388127.png', '1919酒类直供 52度五粮液 普五 425mL 四川高度浓香型白酒', '729.00', '1', '729.00', null, '', '729.00', '1501720714593', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('e0d75d6f7aac4cf6a641d68b93bfad15', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1508984350445', '0', '5');
INSERT INTO `shop_order_detail` VALUES ('e1b2eeb621694f369ab6f87331785592', 'b8e71a42aec649bda125f7d5420c3354', '/mallupload/1500609326237.png', 'Hisense/海信 LED55EC720US 55吋4K高清智能网络平板液晶电视机50', '4199.00', '1', '4199.00', null, '', '4199.00', '1512390448983', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('e20e275964b44b0486e196a7d44ac8c3', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1504679354066', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('e6205db8f59a4e1fb52f7f0931db1d3e', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1512204972319', '0', '4');
INSERT INTO `shop_order_detail` VALUES ('e756b35a5b804a25a2f53c3667d842d4', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.30', '1', '0.30', null, 'VS/微瑕,D-E/极白,1克拉', '0.30', '1505054810689', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('edaa5595f93c470c91d70e1a1f2d0af4', '05b87c4206da4c8e81ae774317248725', '/mallupload/1500608478653.png', 'Huawei/华为 Mate 9商务手机正品mate9', '3099.00', '1', '3099.00', null, '月光银,64G', '3099.00', '1511928859734', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('f0c0030fc9e84db7bb6aadac28560596', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1510304546851', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('f3332b1fb55c475b86742bdd2fa843d2', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.10', '1', '0.10', null, 'SI/小瑕,D-E/极白,1克拉', '0.10', '1504260515881', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('f460e6f446684a0a8f5021dfd4bffb1c', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1506663060476', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('f541253f08094dfabae95eac30754647', '6f1ef9d26811407b8a9aa03532976603', '/mallupload/1500609537479.png', '广西百香果热带水果新鲜西番莲鸡蛋果现摘5斤精装大红果酸爽香甜', '36.80', '1', '36.80', null, '', '36.80', '1503039593458', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('f9199fe173f34d03853df9afefca5f87', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.01', '1', '0.01', null, 'SI/小瑕,D-E/极白,30分', '0.01', '1500897553542', '0', '2');
INSERT INTO `shop_order_detail` VALUES ('fa01178f88ce49e992d4116c0f92325f', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.02', '1', '0.02', null, 'SI/小瑕,F-G/优白,30分', '0.02', '1507648999100', '0', '0');
INSERT INTO `shop_order_detail` VALUES ('fdd4d63713b4433eb189946d7798c6db', '627f21ccf893421ead0be760f9f8c01d', '/mallupload/1500609225036.png', '臻选CTF订购 周大福珠宝首饰倾心订制臻美钻石 裸钻50分 60分GS', '0.04', '3', '0.12', null, 'VS/微瑕,F-G/优白,30分', '0.12', '1510076974007', '0', '0');

-- ----------------------------
-- Table structure for `shop_qiyu`
-- ----------------------------
DROP TABLE IF EXISTS `shop_qiyu`;
CREATE TABLE `shop_qiyu` (
  `qiyu_id` varchar(255) NOT NULL,
  `qiyu_url` varchar(255) DEFAULT NULL COMMENT '七鱼客服链接',
  PRIMARY KEY (`qiyu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_qiyu
-- ----------------------------

-- ----------------------------
-- Table structure for `shop_record`
-- ----------------------------
DROP TABLE IF EXISTS `shop_record`;
CREATE TABLE `shop_record` (
  `record_id` varchar(100) NOT NULL,
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单id',
  `record_note` varchar(255) DEFAULT NULL COMMENT '备注',
  `addtime` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_record
-- ----------------------------
INSERT INTO `shop_record` VALUES ('0228e2939ce744928f5282a2ccf7da01', '1510719490241', '下单时间', '2017-11-15 12:18:10');
INSERT INTO `shop_record` VALUES ('08a9257eeeea4736b023a6dd64f36d54', '1508311016757', '下单时间', '2017-10-18 15:16:56');
INSERT INTO `shop_record` VALUES ('09d3dee9cd4543d89b6a1777351809cb', '1512393942926', '确认收货', '2017-12-12 17:05:16');
INSERT INTO `shop_record` VALUES ('0a01eeb854ab46cf816fff86ea684a44', '1508983763179', '下单时间', '2017-10-26 10:09:23');
INSERT INTO `shop_record` VALUES ('0d350863c0c049ccb976d0c079480e3b', '1509543370304', '下单时间', '2017-11-01 21:36:10');
INSERT INTO `shop_record` VALUES ('0e32fdea75cb40108889ef4ec51f2c94', '1500895551046', '下单时间', '2017-07-24 19:25:51');
INSERT INTO `shop_record` VALUES ('1211d43be66442d2b42ce0509404126c', '1512393942926', '确认收货', '2017-12-05 14:44:13');
INSERT INTO `shop_record` VALUES ('13f35003d9464317a87a5bbfb9f17405', '1500900245397', '付款时间', '2017-07-24 20:44:10');
INSERT INTO `shop_record` VALUES ('149f4494530b4ab5ac91dd9a3a1d84f0', '1510309504554', '付款时间', '2017-11-10 18:26:15');
INSERT INTO `shop_record` VALUES ('168ee46bfddc46b3814e3acce007b3c8', '1500647836067', '下单时间', '2017-07-21 22:37:16');
INSERT INTO `shop_record` VALUES ('19b1f07ea44e423291b3c0c8a78cb9d7', '1512393942926', '确认收货', '2017-12-12 18:27:16');
INSERT INTO `shop_record` VALUES ('1d43d201e750495e896021a8b60a9e35', '1503284840853', '下单时间', '2017-08-21 11:07:20');
INSERT INTO `shop_record` VALUES ('1edc090993ae41d9b8a41aa99d68df50', '1511929081346', '下单时间', '2017-11-29 12:18:01');
INSERT INTO `shop_record` VALUES ('2ad08c3fc8d54b8f9d19a5c872f4b72e', '1508311057491', '下单时间', '2017-10-18 15:17:37');
INSERT INTO `shop_record` VALUES ('2c1735fa17fe427c9f2ebf6b868042ac', '1508430608272', '下单时间', '2017-10-20 00:30:08');
INSERT INTO `shop_record` VALUES ('3356418afbdf4a97844dae3fa5ad60d1', '1510645043210', '下单时间', '2017-11-14 15:37:23');
INSERT INTO `shop_record` VALUES ('344ca23fe6364b00924a63b697ce99b3', '1512380598151', '付款时间', '2017-12-04 17:43:27');
INSERT INTO `shop_record` VALUES ('363083e3cfa24651bb8a10182fd6e351', '1509523654351', '下单时间', '2017-11-01 16:07:34');
INSERT INTO `shop_record` VALUES ('39f16bf9d072486ea76fe80141a10044', '1503104521026', '下单时间', '2017-08-19 09:02:01');
INSERT INTO `shop_record` VALUES ('3b83efa79bd3434591fe77a29a6ca877', '1503039092848', '下单时间', '2017-08-18 14:51:32');
INSERT INTO `shop_record` VALUES ('3ef5e59369d440119172d49c579f7648', '1500618295286', '下单时间', '2017-07-21 14:24:55');
INSERT INTO `shop_record` VALUES ('405af19f174f4c7d8d48a09fc5cde456', '1508845617264', '下单时间', '2017-10-24 19:46:57');
INSERT INTO `shop_record` VALUES ('44831ce1a68b4151bd0c81969a5f524d', '1501412455511', '下单时间', '2017-07-30 19:00:55');
INSERT INTO `shop_record` VALUES ('478440193595438b8a27c66e6958edb0', '1509970523601', '付款时间', '2017-11-06 20:15:28');
INSERT INTO `shop_record` VALUES ('487d749ad5b745e2a92fbcfd865bcec3', '1501300775960', '下单时间', '2017-07-29 11:59:35');
INSERT INTO `shop_record` VALUES ('49728f13aec9453d88fbe37e6e6c0041', '1510297307585', '下单时间', '2017-11-10 15:01:47');
INSERT INTO `shop_record` VALUES ('4d14a079917141329731f0728db7a479', '1510304546851', '下单时间', '2017-11-10 17:02:26');
INSERT INTO `shop_record` VALUES ('4e099c392fcc4c0ab2cc8572b9cba59d', '1510719523351', '付款时间', '2017-11-15 12:18:49');
INSERT INTO `shop_record` VALUES ('4ff813c6571140e787870316a2c7ccd2', '1508886648898', '下单时间', '2017-10-25 07:10:48');
INSERT INTO `shop_record` VALUES ('51297d713b7244e59872b35a7db0dd12', '1507975047429', '下单时间', '2017-10-14 17:57:27');
INSERT INTO `shop_record` VALUES ('51a3b8ae775e4fbd8cdd02992dee0481', '1508984350445', '下单时间', '2017-10-26 10:19:10');
INSERT INTO `shop_record` VALUES ('5394839a52b24c3d99b4891b660740ca', '1508983763179', '付款时间', '2017-10-26 10:43:35');
INSERT INTO `shop_record` VALUES ('54f0686435854ef0bf37c89d4e0107b1', '1512204972319', '下单时间', '2017-12-02 16:56:12');
INSERT INTO `shop_record` VALUES ('58ec0e8c87aa45dc8e612e8a87bd867d', '1512057357437', '下单时间', '2017-11-30 23:55:57');
INSERT INTO `shop_record` VALUES ('5c810f8c972d4c46aab68c1ad351cb2a', '1512215190009', '下单时间', '2017-12-02 19:46:30');
INSERT INTO `shop_record` VALUES ('5de2ea3f8ef54502b7bed73dc5d69037', '1500647393337', '下单时间', '2017-07-21 22:29:53');
INSERT INTO `shop_record` VALUES ('630681326fb642c4b163f4b67359965f', '1512057357437', '付款时间', '2017-11-30 23:56:03');
INSERT INTO `shop_record` VALUES ('635445a89fc346a9b35ac887e557fd67', '1504180222893', '下单时间', '2017-08-31 19:50:22');
INSERT INTO `shop_record` VALUES ('646656a31b9748e6a7120bad910311f6', '1512393942926', '确认收货', '2017-12-05 14:33:10');
INSERT INTO `shop_record` VALUES ('64c6c4f79fcb4c4dac5afcc39a149172', '1508327102335', '下单时间', '2017-10-18 19:45:02');
INSERT INTO `shop_record` VALUES ('65360c5dffd4423ab4e52f6a6a256fe8', '1505054810689', '下单时间', '2017-09-10 22:46:50');
INSERT INTO `shop_record` VALUES ('66bc4329750b4d8f89a8449ddd5fd546', '1501720714593', '下单时间', '2017-08-03 08:38:34');
INSERT INTO `shop_record` VALUES ('6730cfb9ce5f43ddb49fa5548967e5b9', '1512380598151', '下单时间', '2017-12-04 17:43:18');
INSERT INTO `shop_record` VALUES ('6ae6347baaf140f1b250e4d3d16443b1', '1508984350445', '付款时间', '2017-10-26 10:19:15');
INSERT INTO `shop_record` VALUES ('6d030917bce44ae18333c87cf9b47255', '1500899034861', '下单时间', '2017-07-24 20:23:54');
INSERT INTO `shop_record` VALUES ('71da049923db4aee8205c2b3ef7d1454', '1500897553542', '下单时间', '2017-07-24 19:59:13');
INSERT INTO `shop_record` VALUES ('73aec261480d412e8df5baa2fef889b9', '1506084514887', '下单时间', '2017-09-22 20:48:34');
INSERT INTO `shop_record` VALUES ('7543727af6864d2ca27477d9b76f1b3a', '1512204972319', '付款时间', '2017-12-02 16:56:19');
INSERT INTO `shop_record` VALUES ('75a4074d8a8a4569a516d89da9ab8612', '1512393942926', '确认收货', '2017-12-05 14:47:34');
INSERT INTO `shop_record` VALUES ('7af03f711af84d3aa5ab4e1cc18aaf16', '1503377150908', '下单时间', '2017-08-22 12:45:50');
INSERT INTO `shop_record` VALUES ('7af5cdfe781a45e391c9cc1cf9d0e3ae', '1510307768788', '下单时间', '2017-11-10 17:56:08');
INSERT INTO `shop_record` VALUES ('7b32ed7fd21b4875baf650c35ad885c1', '1505810289815', '下单时间', '2017-09-19 16:38:09');
INSERT INTO `shop_record` VALUES ('7dc95ad9af9749c7b21ab887b899cf72', '1507553595272', '下单时间', '2017-10-09 20:53:15');
INSERT INTO `shop_record` VALUES ('7ee40a945bad4da6b072b5031ed82c65', '1507649858679', '下单时间', '2017-10-10 23:37:38');
INSERT INTO `shop_record` VALUES ('7faaf7d165944ee6a040301c90ad5b6e', '1511504451764', '下单时间', '2017-11-24 14:20:51');
INSERT INTO `shop_record` VALUES ('8423e01483974c0e88e1ea11cb66dba0', '1512200480882', '下单时间', '2017-12-02 15:41:20');
INSERT INTO `shop_record` VALUES ('86b428e78bf54dc3a34334bf10d8fcbf', '1507557329382', '下单时间', '2017-10-09 21:55:29');
INSERT INTO `shop_record` VALUES ('90b16d6ca9fa484bb696f30a028e1b5c', '1508403233210', '下单时间', '2017-10-19 16:53:53');
INSERT INTO `shop_record` VALUES ('910084b5a40b4aba9e023913245d2f89', '1507788370319', '下单时间', '2017-10-12 14:06:10');
INSERT INTO `shop_record` VALUES ('9fae0cbf155049f78d47d1f307252f03', '1500785154572', '下单时间', '2017-07-23 12:45:54');
INSERT INTO `shop_record` VALUES ('a05ec95d00d344e19c3fbfdc06ef40e3', '1503039593458', '下单时间', '2017-08-18 14:59:53');
INSERT INTO `shop_record` VALUES ('a4fe59e938124fe5bb09ec29741d2261', '1510307768788', '付款时间', '2017-11-10 18:06:00');
INSERT INTO `shop_record` VALUES ('a54a6bde9e2f497bb6acfde6ea540986', '1508984350445', '确认收货', '2017-11-17 19:39:52');
INSERT INTO `shop_record` VALUES ('a5f07769c07e4b0595d425177dcd430c', '1500897553542', '付款时间', '2017-07-24 21:04:53');
INSERT INTO `shop_record` VALUES ('a611baae18cd4edfa4747040350bfce9', '1503104902167', '下单时间', '2017-08-19 09:08:22');
INSERT INTO `shop_record` VALUES ('a9af902c01eb4ba3aa9d578593409076', '1510076974007', '下单时间', '2017-11-08 01:49:34');
INSERT INTO `shop_record` VALUES ('a9b2391dbdd74856ad22c83062c06017', '1512215190009', '付款时间', '2017-12-02 19:46:36');
INSERT INTO `shop_record` VALUES ('abae18ec34bc4a80af6f2e3afff22c1a', '1510889617476', '下单时间', '2017-11-17 11:33:37');
INSERT INTO `shop_record` VALUES ('acc8fdfdbc774d6dba94f975d3e680c7', '1500899034861', '付款时间', '2017-07-24 20:58:25');
INSERT INTO `shop_record` VALUES ('acfdc037faa54063b2aae9daf41f0fc1', '1512393942926', '确认收货', '2017-12-05 14:46:42');
INSERT INTO `shop_record` VALUES ('adb9b4dd00bf4d98aa42c238994ca09c', '1512215190009', '确认收货', '2017-12-04 18:06:46');
INSERT INTO `shop_record` VALUES ('b0b7292aa7da4e86829f0c713b95044c', '1512393942926', '确认收货', '2017-12-05 14:44:50');
INSERT INTO `shop_record` VALUES ('b131b4e1f8d7455895ae2bad6d58384b', '1512393942926', '付款时间', '2017-12-04 21:25:48');
INSERT INTO `shop_record` VALUES ('b3a904cfd43542b8875fdad00b094df5', '1507648999100', '下单时间', '2017-10-10 23:23:19');
INSERT INTO `shop_record` VALUES ('b48a95ee30dd4a3c8fb38a3ca6de0e86', '1510579289476', '下单时间', '2017-11-13 21:21:29');
INSERT INTO `shop_record` VALUES ('b4a48b9606b0497fab548ed16498a68c', '1508477511882', '下单时间', '2017-10-20 13:31:51');
INSERT INTO `shop_record` VALUES ('b62c0e3e5e39408b895061a7fe735e09', '1512393942926', '确认收货', '2017-12-12 17:48:12');
INSERT INTO `shop_record` VALUES ('b6e4ec24990342e69c63da623b0af17b', '1508749737944', '下单时间', '2017-10-23 17:08:57');
INSERT INTO `shop_record` VALUES ('b859805ec8ae40629624b7b044e4a933', '1504260515881', '下单时间', '2017-09-01 18:08:35');
INSERT INTO `shop_record` VALUES ('b8ec1ae1456b4ec89cd80d45ec36fd98', '1507429059694', '下单时间', '2017-10-08 10:17:39');
INSERT INTO `shop_record` VALUES ('b918a8e1b9e74b77885be59bdf996ae9', '1511929081346', '付款时间', '2017-11-29 12:18:10');
INSERT INTO `shop_record` VALUES ('bb43d3de16b142d2849a8bbbc9eb3985', '1511504451764', '付款时间', '2017-11-24 14:20:57');
INSERT INTO `shop_record` VALUES ('bdc5489efbac4d75abda441d82672b92', '1512393942926', '确认收货', '2017-12-12 17:13:30');
INSERT INTO `shop_record` VALUES ('bf7ba4c6648a4fc2891ac4b7f2b430df', '1500647363008', '下单时间', '2017-07-21 22:29:23');
INSERT INTO `shop_record` VALUES ('c0848116d67d40379ce8d6f8b602cc03', '1511928859734', '下单时间', '2017-11-29 12:14:19');
INSERT INTO `shop_record` VALUES ('cedd7be636e1429283ba787f78f82852', '1507627626882', '下单时间', '2017-10-10 17:27:06');
INSERT INTO `shop_record` VALUES ('cef6cc47a9ec46c695a81b13d6f5dc4e', '1503288107621', '下单时间', '2017-08-21 12:01:47');
INSERT INTO `shop_record` VALUES ('d1e159b99f474350a3e702c37b642709', '1510539138351', '下单时间', '2017-11-13 10:12:18');
INSERT INTO `shop_record` VALUES ('d26b7ab8310f400bb5303feda85b95be', '1510913549976', '下单时间', '2017-11-17 18:12:30');
INSERT INTO `shop_record` VALUES ('d7915abf9eff4aac9710ab1ca6a8f369', '1503372105684', '下单时间', '2017-08-22 11:21:45');
INSERT INTO `shop_record` VALUES ('d801c821d73e4614a8e4d891dce1e92e', '1510476718085', '下单时间', '2017-11-12 16:51:58');
INSERT INTO `shop_record` VALUES ('d92472c89ce549859791f0b482d47097', '1512393942926', '确认收货', '2017-12-05 14:45:04');
INSERT INTO `shop_record` VALUES ('db52aca176424badb7c59fa97011bf52', '1510719523351', '下单时间', '2017-11-15 12:18:43');
INSERT INTO `shop_record` VALUES ('dca55aaddbd04441927a5c2193ba7169', '1510309504554', '下单时间', '2017-11-10 18:25:04');
INSERT INTO `shop_record` VALUES ('dcd263d37f2645e1bda58398319da8b3', '1509985460038', '下单时间', '2017-11-07 00:24:20');
INSERT INTO `shop_record` VALUES ('e0f819f4c1784110b27b8759ecb8bb16', '1510304435116', '下单时间', '2017-11-10 17:00:35');
INSERT INTO `shop_record` VALUES ('e4d49b7824594aba9230f1af582a4bf2', '1506663060476', '下单时间', '2017-09-29 13:31:00');
INSERT INTO `shop_record` VALUES ('e7655925649747b8ae61a0d329ce6970', '1503027874517', '下单时间', '2017-08-18 11:44:34');
INSERT INTO `shop_record` VALUES ('ef38dfa345044e77b1fec49021f88762', '1509970523601', '下单时间', '2017-11-06 20:15:23');
INSERT INTO `shop_record` VALUES ('ef91527dc7d54c77896e22eb62c876be', '1500900245397', '下单时间', '2017-07-24 20:44:05');
INSERT INTO `shop_record` VALUES ('f223906ccc5f4830b52459786bb086cb', '1512390448983', '下单时间', '2017-12-04 20:27:28');
INSERT INTO `shop_record` VALUES ('f5cf01d92e784a57bba02b451e640e23', '1510579313445', '下单时间', '2017-11-13 21:21:53');
INSERT INTO `shop_record` VALUES ('f92741aeae4842f0bb70d9ecab213651', '1512393942926', '确认收货', '2017-12-05 14:28:11');
INSERT INTO `shop_record` VALUES ('fccd7b0beca0468181be35846fc763a1', '1504679354066', '下单时间', '2017-09-06 14:29:14');
INSERT INTO `shop_record` VALUES ('fd8f325c2c9941988291c127aea6c7fc', '1500895551046', '付款时间', '2017-07-24 21:00:03');
INSERT INTO `shop_record` VALUES ('fffe7d617a224f798f2b542bed51f5fe', '1512393942926', '下单时间', '2017-12-04 21:25:42');

-- ----------------------------
-- Table structure for `shop_refund`
-- ----------------------------
DROP TABLE IF EXISTS `shop_refund`;
CREATE TABLE `shop_refund` (
  `refund_id` varchar(100) NOT NULL,
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单id',
  `order_detail_id` varchar(255) DEFAULT NULL COMMENT '订单详情id',
  `refund_price` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `refund_explain` varchar(255) DEFAULT NULL COMMENT '退款说明',
  `addtime` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`refund_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_refund
-- ----------------------------
INSERT INTO `shop_refund` VALUES ('061e8fa29e3140e094fea8b7d0dd10da', '1512057357437', '74c0998363d8424a938520cad3e402f6', '0.01', 'test', '2017-11-30 23:56:36');
INSERT INTO `shop_refund` VALUES ('50f95048a8dc4111adbd8c3c2ec855a4', '1512204972319', 'e6205db8f59a4e1fb52f7f0931db1d3e', '0.01', '', '2017-12-02 16:57:55');
INSERT INTO `shop_refund` VALUES ('914b75d78b19482080357da40166cf5e', '1500895551046', '9da60bfea3c5483da59a7f52a44eb89d', '0.01', '', '2017-08-31 16:01:26');
INSERT INTO `shop_refund` VALUES ('a5b35476f5ac467fbd33968bb06a870d', '1509970523601', '844ffbcc80724a248bf07be778af593e', '0.01', '测试', '2017-11-06 20:16:03');
INSERT INTO `shop_refund` VALUES ('a7f1800a8a3147daabfe30c72a3c2d53', '1500900245397', '46488617156b434aa228cfb2edfa4441', '0.10', '', '2017-07-24 21:24:41');
INSERT INTO `shop_refund` VALUES ('c2fe92fff3224488b75e95b5ac8ed904', '1512380598151', 'd43455a903a64de48102dbfb8fd6bcd3', '0.01', '缴了', '2017-12-04 17:53:05');

-- ----------------------------
-- Table structure for `shop_search`
-- ----------------------------
DROP TABLE IF EXISTS `shop_search`;
CREATE TABLE `shop_search` (
  `SEARCH_ID` varchar(100) NOT NULL,
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '搜索词',
  `SORT` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`SEARCH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_search
-- ----------------------------
INSERT INTO `shop_search` VALUES ('32f9188b3bb947a78f1b10b2e0f7ed75', '卡西欧', '4');
INSERT INTO `shop_search` VALUES ('441ee6b5201340c4b828ed734613777f', 'Apple', '2');
INSERT INTO `shop_search` VALUES ('97b2ebbf4a2a4ccfbca79fb2c9be9f4e', '话费', '3');
INSERT INTO `shop_search` VALUES ('e4f2bdd510a34f2289c53d2ff902a050', 'ipone', '1');

-- ----------------------------
-- Table structure for `shop_user`
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `USER_ID` varchar(32) NOT NULL,
  `PHONE` varchar(255) DEFAULT '' COMMENT '手机号',
  `PASSWORD` varchar(255) DEFAULT '' COMMENT '密码',
  `USERNAME` varchar(255) DEFAULT '' COMMENT '昵称',
  `LEVEL` varchar(255) DEFAULT '' COMMENT '等级',
  `HEAD_IMG` varchar(255) DEFAULT '' COMMENT '头像',
  `ADDTIME` varchar(255) DEFAULT '' COMMENT '注册时间',
  `OPENID` varchar(255) DEFAULT '',
  `INTEGRAL_COUNT` varchar(255) DEFAULT '0' COMMENT '积分',
  `RECOMMEND` varchar(255) DEFAULT '' COMMENT '推荐人',
  `ALIPAY_ACCOUNT` varchar(255) DEFAULT NULL,
  `ALIPAY_NAME` varchar(255) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL COMMENT '全平台唯一id',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('0340d49a98ea4017b5523433d8627212', null, null, '魏志林 APP 区块链 游戏 网络推广', null, 'http://wx.qlogo.cn/mmopen/vi_32/PNmB3mOQ4jSNyU598OaJ6PCwY51aCnsWUN8gUrwUcm7cHezIzaATPlfmBsFyw5cWJibXDYEsb7HDaibSAPnnMOUg/0', '2017-11-12 09:07:43', 'oi4Fwv2YmAUJpTdX_3zsrQWMvOwE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('06b3e017618e428c9790a589bfce7a41', null, null, '孜柏', null, 'http://wx.qlogo.cn/mmhead/UmibQfsXXQZxgUaGFHic5P9gnd2QfzGMZ4PKRc2wX6wkc/0', '2017-10-25 14:47:33', 'oi4Fwv0zVpiEqaJHEuGMkoIAJQ0g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('06d15a085bc744828482a0a0fb80f15a', null, null, '他信', null, 'http://wx.qlogo.cn/mmopen/vi_32/LW3frjuWW7nG0e6t052l4Mn5DtricgCoYubSiaUianrzZ3CCwl2nFx0JD5jEu2wgyLcPaSB50qiaHhmianahK49ib4zw/0', '2017-11-07 17:11:23', 'oi4Fwv12arChg6d1BIgyZCvS4L2c', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0722b17750aa4966ba5db4fda7f1d584', null, null, '重庆    周昌', null, 'http://wx.qlogo.cn/mmopen/vi_32/3966N3kAtqYia7Dia1j97y8DjjHIIHbibmCyT7gc7btYWsf6qFzTcGx7vv2LcmqpeBLVV5hF69v65licQHElc2nwFg/0', '2017-10-23 20:37:25', 'oi4Fwv75i5LoOkWS6Iitu1e0ZGck', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('07573ce2135a41abbcefdcbc7a4b6fd2', null, null, '包晋升', null, 'http://wx.qlogo.cn/mmopen/vi_32/qxWEIjy9XYc6jmmdYw8rsQx8N5y7bctYfhElKucGBRYG3QIzfniahvZ8bGGQqYpKyNaVE5uP9C2YUM35jSaQIkA/0', '2017-08-29 17:26:27', 'oi4Fwv4gNFqAHxUU5AMBTZPcntpw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('07c40b8de0ac4fb183dcdac5a4b302ab', null, null, '无线', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIyhu7VDDE390BzBOjGxCh0siaR77OpfBaI2g8cOYykIEb1fibLUyvYeZBSw94S5QfU6WDS43yh3mQg/0', '2017-09-13 00:35:33', 'oi4Fwv8RjIV3C24INyMKvoMaB3-E', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('08f6e4dd62d843bbaf63eae75903fdc1', null, null, '朋友', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaEIgSdh6rHlTcmUAfZIpg4zhiaUV6x9sWs1dMb1kZYenQ8f31s0KHgbVexW5D5YyZTIHxjRXat4nblQ/0', '2017-06-12 09:57:54', 'oi4FwvzufXvmKtFIYs1UA4auQGBg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('096421ccfdda495ba9db4c0899beb3af', null, null, '小南', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKAt57ta3VUu2zHcP9OHGxNtmkXQGMnyHgQOpyAlzdiaURaXcXxGBCb1f3g9uOZ8EnXgQvxp556uWw/0', '2017-11-05 16:43:03', 'oi4Fwv2k8sKjTFF8bp8LJEngBBA8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0af56e0745374f8b8f18a3e50436f5be', null, null, '林涧微风', null, 'http://wx.qlogo.cn/mmopen/vi_32/4DMwVBZ0w0x2wsGVSZSsdIic6wWhLWKtZvHtLgEPj1mdysmnRqzG6KkXtSK2YDpMz5WCeSJdoS0ezwdV4JLNRMQ/0', '2017-09-18 09:21:24', 'oi4Fwv4X6E1eBHOMpsorZYpWJzlY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0b4356362a7c4add8d2c4380cc6e8f23', null, null, '张朋远', null, 'http://wx.qlogo.cn/mmopen/vi_32/aIRCGibEXLpvhjpw6VYH7talEQUXCsh1qRMm1XfV0ATNnYEOvt6LJLxrpib6mEiacOKbZ7dXibQPIIc8G4toUbrQog/0', '2017-12-04 13:40:30', 'oi4Fwv_OQjP0M1GSAtA2Jut3316w', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0b68a75904d04de6bf9c984fc846e023', null, null, 'loyal', null, 'http://wx.qlogo.cn/mmopen/vi_32/kHoDdV15McUdiaJRjJpwWlrflUtGxrWJibdoFf6zpmJpfniaQ9jGaaY3oDszXH4CyVATgEYhUXlwKibXaZgXmttr9A/0', '2017-10-22 18:58:00', 'oi4Fwv2JLa5Bnoawnxi1VIEq5CI4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0b69a214ee8c4d7293bc8703b23ffb69', null, null, '倚天', null, 'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKUbBv3yTFRwGhmb2hTmSaZEGB5L5IbiayunhHpaB6uSIBwZ03CevjVAicOVa0Mf3paD9N6tWchLQyA/0', '2017-09-19 19:44:30', 'oi4Fwv3exkm-6MHSPPkBgjROREi4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0c40d1a9047e49ed82f93d115997774f', null, null, '小林子', null, 'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELice4NqLPic3ug0Hbic9TviaxRbYz3zWiacGUgxD3S8oXNwe5Q6iaYRCGKCiaSLsDZhRf27LsdlcYibbp0Ww/0', '2017-12-02 12:56:25', 'oi4Fwv5_iiYlctmO29MJGRUszckk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0c8bb9a06f3c4ce89364709b676e95cf', null, null, '江', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJia1YpXIXEAkEdT11JURzrWHuB1ddDlqqDmZ1bELyYXD6iaZ27K2ibwJIpgRVkiaml7eXiaDOB2kCDWgw/0', '2017-10-11 14:51:30', 'oi4FwvzDhmGu1loxstXvEsO3yKT0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0e752b548a5d400993f0954a16aabd77', null, null, 'S.K.均', null, 'http://wx.qlogo.cn/mmopen/vi_32/rdpX04rcx6Fdkj4TwA4pXd10C2eZu4kPLX20ia3NibAZqbQskJasOYvB40xh03J1sjyH08lHpaxVXwuh9x6n9skA/0', '2017-11-17 14:52:56', 'oi4FwvyeffSuPO5Z3hUn3Ko32b-Y', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('0f18dc90bf0c443aa3634464c0e1c774', null, null, 'A罗力', null, 'http://wx.qlogo.cn/mmopen/vi_32/P4PsDCsSjFVNib71ichfnJvdzpMFZPpwGkHvc4NqS6PbuX6IdSw1p5uDoeEgleic3v4LbnGLuibHum3FsI8E4qqMDw/0', '2017-10-12 16:47:07', 'oi4Fwv03VE3ZFeXmptqNNmWEzeJU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('101a15851def4a12b2de069576f3bdda', null, null, 'added', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJL365CsJiatj9Svsldn5fE2NXr9VG3vKrqU1mk7stAYkKggtJQBBibZgaj7TWX2cnra2kPwdH8L3Dg/0', '2017-09-23 10:26:30', 'oi4Fwv7WrJqHtZkzSf6R61VKXtcE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1056aa23780744beb33d58cc20b92abf', null, null, '新', null, 'http://wx.qlogo.cn/mmopen/vi_32/TribTUzpGq31GMvBmOKnuTqYhuKsAm3CopTRmPvibSlQagCnFbFJm0XaFiaagZYBXoID6WuVZwcRVE9NSTVANiauqA/0', '2017-11-03 11:07:13', 'oi4Fwv-AidfazHdVtlEtGwEtr-rQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('10f1e52f4b864159a6fa432b7f11b2d7', null, null, '董卫东', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIdsbpIiaryKsia3HKYLyrLO0icMapIDibYDicPvY10b1ibZ8kx8V6hNE7UkrbZ8miajBZPWtRY7AWbUIXMg/0', '2017-10-13 17:09:59', 'oi4Fwv4Q6inhF7ggC80_FoK4r-Qk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('112ecc53c239402ca87a9ac9e7ce948c', null, null, '汪景林', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60bKtvTCpb7uOWiaKmfLiaxq4WHT6Wm8cJpVicye7uVlopbN68rLvibia5HRXW5iaRGzv4sibQ/0', '2017-12-03 18:48:24', 'oi4Fwv_Ou0wCwwbTpjPwoO3QeIuM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1241d5ef5b5f4ccc95063cc9b7d0b3f4', null, null, '耐思科技', null, 'http://wx.qlogo.cn/mmopen/vi_32/OYFfUAcaJCHAyp7ia6mwicgFjOz910yLUniawd7fIMTKk4IRIu3Kaz6KBVqNUbblHWDa3Jc2CzlffwZ6rtq7sTfDg/0', '2017-09-04 20:50:52', 'oi4Fwv8qPayVVPaHRLjAJr8_Gme4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('13709bf471b04f9185d90b169d169e09', null, null, '郝Gy', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK93QsA0tFoic9gXjDia2U2QgXtBgpDAiagyQodcSBenIO41WgaXu40O3PhZrzrFPaW94JzxZZjIUo7w/0', '2017-11-01 15:27:37', 'oi4FwvyI0cJ6V67nMkpTUsRp0hm8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('14825205687e47fdadb3bc637063b2d3', null, null, 'zzz', null, 'http://wx.qlogo.cn/mmopen/vi_32/0G2KQrJ41074FBdY6RjezD7oYCAAMlqAbBhnsm3caC6zJq2ezmIvYb8ibchaaoJ8uymZ8GMfcwJIgbkUukPQcUw/0', '2017-10-17 12:54:50', 'oi4Fwv1w92DG1BfG3zIbPqKD4gyA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('16', '17714344343', 'e3ceb5881a0a1fdaad01296d7554868d', '哈哈', null, '/mallupload/1495792436429.png', '2017-04-20 16:22:46', '', '30', null, null, null, 'ow_X0wzmrypAeX2Uwi_AqpLo3UHA');
INSERT INTO `shop_user` VALUES ('1646282c1e69427faa86ad45fa3f0a2b', null, null, '多米多', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e1GYNQyh2ygSOMibLzz1Bk9eicpxeyqTydeAXgkOLj0uR8aw0v2KnqdfLyLxRrvhb0zibx89qyfbrnH6PSLNTrVlVJ/0', '2017-05-29 10:23:18', 'oi4Fwv3TjUMU-HZ_tJEb7nFlj7eM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1817bb465a2148a195aea40060441774', null, null, '张瑞', null, 'http://wx.qlogo.cn/mmhead/HPql0icgWk8RxxZvDYNicAfy6JVK1s2Ha3iabULNxYjzD4/0', '2017-10-27 22:37:55', 'oi4Fwv_htnlEIlKwFH9jJnH4X0TY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('19594efdc84b4ad2a95325d6b2e86870', null, null, '安若锦年丶', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJBFy63BiajN0KDWbSDKthfaA2xpfXMuWt8OR0f04O2e4CdVmNP7Mu6QyhECUmdUf4SrGPR4Pq4AVA/0', '2017-10-08 10:20:43', 'oi4Fwv0dOvIn7nrKDjiCtmtwIoy8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('19db6dc6eda540abb06762edfafb2f86', null, null, 'Mr.Fu', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKav1ib8qG43xicUfvkwjQibk52h7KlakibFZ9AQ5CEmPn7vVRUiaFVSrbrlkPGv36g6DgX9upkoKNCDAg/0', '2017-11-09 15:00:35', 'oi4Fwv84Q7oWhH0QCCVC1hib-byk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1a375fb1ab7846e4ae9cba828810d96e', null, null, '囧囧有神', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN5Xcz6YH8ia48FWce2HL9h4iapNcz97ViccE3z1B67lDnqR0bHH7uSsliaLp8mWykWKDXY8haKCyOBFX/0', '2017-07-31 15:24:31', 'oi4Fwv-1T27-Kn8pqUdSEIhwFPks', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1a5c91f5800f42948249086f7c84f99f', null, null, '小林子', null, 'https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEIWXxMAKtQnS4qicJeHDQU8f5QyQufBVdEf1AtdCdElADH5CSK7Zx9uia2NYCjXPFy5qoWwb60K9B3w/0', '2017-12-04 17:42:09', 'oa-8a0ZPzHKz5r1MNB9J1FHfNenw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1ad41e5c660442a2818ca200f3391930', null, null, 'Mr_龙先森', null, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLDfsgiaLYHr5bF5XVqMILfpYVPGk7uHVyMte43xEzT8gk7g6UOicKxarDsFjHdk7sCrMiaydlcv7GcsQ/0', '2017-08-28 10:09:19', 'oi4Fwv4NcEEv7G1E2kvZXSxE-Lhk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1dabde4ae8b6476086767e7393d0a1d0', null, null, 'Am丫', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL7evlOSOoC77ufCiaicMeYznu1AgQVlNJicajv657xE0ReVwcrrnPiadjxic0JG0COyWlMKtZMMXISqyw/0', '2017-11-11 23:10:40', 'oi4Fwv_AH0wrf_0S7L88pqhDpOKQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('1f06229c07f64970967a78d8a6d9d1e3', null, null, '宁少波Nimitz', null, 'http://wx.qlogo.cn/mmopen/vi_32/9CXkelFhq7x3rvSAMS3KkVgLJ6VeFEUHWeQfj1xUbYlMlLN3xgJdDzMgxogwjdWRPfMHlusxh4clXJqicq0QRsA/0', '2017-09-24 20:53:40', 'oi4FwvwYHw2I7g6HtXarNWBfxE88', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2', '13800138000', '96e79218965eb72c92a549dd5a330112', '千派网络科技', null, '/duobao/../shopupload/1490237977021.png', null, null, '0', null, null, null, null);
INSERT INTO `shop_user` VALUES ('20bc0d09a179457999367e11a093cac7', null, null, '星创科技', null, 'http://wx.qlogo.cn/mmopen/vi_32/KdJPreGRx6E9Mo44kTbBjQza1FNVCbnN8p62U2fnZCdkzeSSCtO3jXLXZ8coUIlFg9ia6orpibBicvmz4b3Nr0Libg/0', '2017-09-27 12:59:18', 'oi4FwvxTsnKDwknhcehKQSolNwO8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('20ceedc5911a4f309d351b20a72b210c', null, null, '铭尚沙发', null, 'https://wx.qlogo.cn/mmopen/vi_32/djAZwFHFWrgQw6ye6REwRPr93KjgXv1VIEOL9AoYE28fy9bkxUpDJ1H4iaBxsJqEDq1N7Lj0M8bSjz2jib3QicOAA/0', '2017-12-03 12:21:41', 'oa-8a0W2NsaHMFk0gPVtTxIrQa08', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('22cd46db1aa441b79247380f5101c8be', null, null, '阿莫', null, 'http://wx.qlogo.cn/mmhead/OibRNdtlJdkFzna9Qfz5WNmc9icSEcBTG4mVADX6ibA6G34q9ZV7QbpjA/0', '2017-10-30 12:19:18', 'oi4Fwv-AFP5q4uVYLJfwk8HHofQU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('23547de21b1e4b6eb755d2213814be5f', null, null, 'skycc', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo436DX7vSs0icxlpJwTbCbd480NqeVSlJxjVSz48Vrb57hG3RicMwpU2jXEts5HhN7Jt4XYBVWMSfA/0', '2017-09-14 23:53:10', 'oi4Fwv57l3fFJBxDEp9mzBocHXRE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2430d396a20c457bb9ffdcefc4d6a96d', null, null, '小天', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIqdt5qNkY2ekxt0FLm5ymOBRwLTfuoxdf5agaxpcRZKibgqmCtAUSbJBwvyic11I4ldnpGlaEaiarRQ/0', '2017-11-15 13:26:52', 'oi4Fwv4_JpyvaRxqwSxLwujpIPrU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('24618ce046b74d58b34d8a3cc594db25', null, null, '♂ 啊鑫～', null, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLAcqb93FheFicB0j0AkUFb9zzeqV8oST9Zypn1KtbibkmbgtEywphLibf1ibxmCx7xXQrF9TORPYVYkYg/0', '2017-06-04 14:49:20', 'oi4FwvxHkzHO1d_QJ6d6lIeNKXKE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('24e65b9a0ca744c88d39f26b574562a8', null, null, '小楠', null, 'http://wx.qlogo.cn/mmhead/Q3auHgzwzM53iaHvb2lEF3icvNPKsOPuIcg4RnqicyEHzGvaKI8PQOBGw/0', '2017-10-30 14:04:07', 'oi4Fwv83RK8kSbsymDC8Aew32RKY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('274052d883334a6384577d0826bef31b', null, null, ' 田晓会', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoibQLsjsrjiasOs4x2yGdk9GGRx4YzsojG2ZvpEWo63a13gVzoUmXXafpnMEG3XYZPzQYQhzgGSahA/0', '2017-09-07 21:05:37', 'oi4Fwvy9S5fH-1YZlQNnfijKcDvY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('28451f2fdcb14073bac536f671647e6c', null, null, '旖晟', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e0reKCuXrq7qaSTIZoL4skwV0cZ7WhIWDoeiaFysKPJwx7dhzoKN11rFhr4ibjHxw8MqO31bms86NCnuXkOpKbZTP/0', '2017-08-11 11:46:25', 'oi4FwvzsB5vvyixW2S7BKV07iPkY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('28e4b811676b48328ce19c6dadc54159', null, null, 'OldSweetheart', null, 'http://wx.qlogo.cn/mmopen/vi_32/zGSPn0d1CAnRiaJCAMs2ibsWiaq6gCEJgcYY7HRl62PE0UwNyTypqTfqpyR9YJ7IVFBjkTr9tjEB9OMkzZSiaxUsHQ/0', '2017-09-10 18:38:42', 'oi4Fwv75IaJ458UsoUmcsbEdm03o', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2a1c4785eef94537ab8f959323ea3278', null, null, '褚卫国', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKw5TuXaZd5KTUm8UTNIibpQPb3yyicENZRzW0jMLvBkmqjETOgMz9JMGcJT5G7pOhiaIEK2Hdsbicgeg/0', '2017-10-10 10:00:30', 'oi4Fwv2WMxXiH07jYFL1dcpo5IeU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2ab931eb77e34f7ea09dcd8778c9bd77', null, null, '\'Na.〢、娜', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJyNJCibCAUoZOCJzw0k6wibImDks5mSZo6eGMIdZfC9bXs1v9kFicUXXfGhntTBcBmicUesgUmfr44Pg/0', '2017-08-30 16:46:42', 'oi4Fwv-Uh55EYIs6eyAoh6OEAJvA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2b1f893905e64772964a6f288a281031', null, null, null, null, null, '2017-08-03 14:56:22', 'oi4Fwv4-Otgj9lClIRPXiNUtWadk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2bfc523f23d3497fb3c42c15c33b1031', null, null, '李奇峰「摩礼积分」', null, 'http://wx.qlogo.cn/mmopen/vi_32/b9iajRDUufeVrgTCnGicNGBwicw2V3e5kddibxsgdnJueNShtD022OgkhbzxWLYEuSpzpkH2qOBh4MNNf8ladaXpCw/0', '2017-10-08 10:16:19', 'oi4Fwv8ZltOiWKW8flga_9mf7844', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2d4a571d72214988b014ecb597f8ef65', null, null, 'AA小角色', null, 'http://wx.qlogo.cn/mmopen/vi_32/Iia9qGJP5dmicUWak5Otnr3LjvjOWU8x0wN0AfKVbPtoHIswmicld3ia4EHMeMSeEbSMH77VU7ANz9dDbicnwgbV1Vg/0', '2017-11-18 23:54:19', 'oi4Fwv_RDletVgil7_kGhJwpag18', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2dd371f206644d24979a270ab0449544', null, null, '冬达运营中心', null, 'http://wx.qlogo.cn/mmopen/vi_32/jkq4mXrH2XqwOaEJlEtIPQERmdCBX4jiag7ZXmZ7WbmPzLHBNHWaknh4GXQTsfIaFPoRm2qkmlexv5PMVG5rfTg/0', '2017-10-23 17:06:27', 'oi4Fwv5e5kKmwi8amMhvhL6goLrk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('2ee4d726ab9649cbb2d54a66edd038a6', null, null, '我叫张得帅i', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep6FicutU9G8SicsqiaV9KoC4xgkBeCfOibbEburZRgEphFT0be1thvc7CYoDGfrt1XKV7g3T2dYsic6yw/0', '2017-10-19 09:28:16', 'oi4Fwv5t7nphieOx0dt8GWcYdGRU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('304c533381ac493dae05ae300b6d3f15', null, null, '(^_^)', null, 'http://wx.qlogo.cn/mmopen/vi_32/f7wZYyMpQ59osGACncUiaBLO5Z3CjrYCBzJPz4zzXS25wDL0VKkZick092RfmMibv49JxoZA1QCNHyPgQUrAiaoticg/0', '2017-11-28 18:07:46', 'oi4Fwv2hFJMepkN8WHH09cul-saA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('30a4338cb04a46899bb78b5a34c6e561', null, null, '云淡', null, 'http://wx.qlogo.cn/mmopen/vi_32/Yq0WzSaibxSX56RiaACxe2uy2aGNeztptIesEEibmebo4MwsF0edPpcEiaGIvPohH99t7lPBcLicyfb1OEAdias9B6bA/0', '2017-09-10 22:44:43', 'oi4Fwv-rEGG5rt6enwCnab0tfjbk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('341a797fa2964876861431ec5c4e71c0', null, null, '欧文', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJia1YpXIXEAkMIHSNB3MuaprJcCB1DLol1Ndex2LTQkXJv9JOD5HthKagzyKVnd6V9icV6UryswTYQ/0', '2017-11-05 19:52:07', 'oi4FwvzLokFV-QnoxifQOPe7aOHM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('34206f7d82ab468d825d565fa491001a', null, null, '永恒GSHFJTKG', null, 'http://wx.qlogo.cn/mmopen/vi_32/HmSIauTjoKicPCYmQ8trAUbUn7paNAhkz1SiaOERjFn9icvcTpsHK3BDFMYtmY8rhtKB3WQiacjickANUE4UicCnPznA/0', '2017-11-18 10:51:59', 'oi4Fwv41lOg_pzqD7pJer36aGro4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('34a7a6af59e44a72bbb33064e0b9808c', null, null, '顺其自然', null, 'http://wx.qlogo.cn/mmhead/PiajxSqBRaEK4e7YeIbCfa1d2W5FGco8sicSYVV4yn8fgBqQEd0WamVg/0', '2017-10-25 10:52:07', 'oi4FwvznAl5yKKBWn3FI0P70erLg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3618981f1c1a444581e96b4772c9100c', null, null, '黄向锋', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLajLoBBBPgMGWpjbJq18QGK4NF3tU1Eg8Xu8p7aDM7VkONYGYLkYZWiaZuG1JbgdyUWR9QkYqH4Rw/0', '2017-09-10 17:07:18', 'oi4Fwv-FWeLNDfBah-YfeNls54f4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('37be45e8e9d8451299f3858452c2e75d', null, null, null, null, null, '2017-08-21 12:09:59', 'oi4Fwvw38J-gZijjNVDhIE2AO48s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3848165157d147b48af22720c1e76337', null, null, 'Metro', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMYOudnjuoNIta9ku1JNjC0lXGS9aerAt1U6xNFBqVMjeA1KRDTsJyFzmdDpuQ7JkvKJqMt8K8Hjr9KtfcEAY4f/0', '2017-06-04 16:33:47', 'oi4Fwv9CW8rqo_eQ38ohc-4IYPLU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3885fe8c6d714ca4909f4ad2241c25c0', null, null, null, null, null, '2017-07-27 21:15:23', 'oi4Fwv1tqJ7prqUiV-k-S2PZGoSM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('38890e0390494aa8980fe7bd2f67d624', null, null, '1000', null, 'http://wx.qlogo.cn/mmopen/vi_32/Aicia76LribU1pmKzTC4yClicYJRlPCPdicibcyEuUDiapPJtWBRIysLGAJjRgz0eIRho3iaHZkn8xuvnqZhLpI5EzO8BQ/0', '2017-11-07 09:30:25', 'oi4Fwv7z_wDeOJyhhKxJM1IMT0C4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('39ed4e7c23724fb7acdf8b1c05564cb8', null, null, 'kitty叔叔', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJBSOjJ8bn8R062JYrHTfgoIib85q4dOyVyZtntUeMG9V02YwwCP3lfhKT602bfSoTgwLOWUk9eesw/0', '2017-11-11 22:50:29', 'oi4Fwv_RLfc7P2ezdp009npqOM_4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3a993d9090cb4277b470181aa415cb6f', null, null, '大魏', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWpjeztK5Fx9vYQDdiaZXSgJIEouictguyoFibuuETnIlom8xdlSbBfD7ZtwgVVZfZA5KPc43jIDVkr3/0', '2017-08-14 21:03:15', 'oi4Fwv1C0LRRmt20TNRWJWyJOJZI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3b8a7d4538404bdab36c44bba2e713ba', null, null, '张振冬', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6ONNxuWn3aLXQR8WicCKzJAxvsksAHCOepnf0aXq03PbPNib4IXN57wiaa82yZRqEmR8piaS8icaKlfYWGOGEreCeru3K/0', '2017-06-02 20:17:24', 'oi4Fwv3nMl_Yx0OSz8GGojk33Ugg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3b9b4dc4609b4893976888871358251b', null, null, '王杰', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIo8FJ700ibiaicKm9kcz2Q3uTgPt1GciaNIMibuLpZ51RNOiaMOP21pqGvlUyaZOKH1o4wFOnhRicJyT4YA/0', '2017-10-20 18:47:01', 'oi4Fwv-_VCmaKPsWmWICvIAhA6s4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3c13e3fd9fe7476aaf37b65e4848a143', null, null, '张磊', null, 'http://wx.qlogo.cn/mmopen/vi_32/XboqrzByF4XVSQD3ZPXwUREMlUcrgQS5SoHBAZX35DFb9jdS2VL5zaMAwuKcoiaOL588b4libwibGiaHTC6p7fkDdQ/0', '2017-11-17 14:43:49', 'oi4Fwv9K7hasYBzKZ1NjfQSzSYmY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3c63a4534e304545bceb604328fde2ad', null, null, null, null, null, '2017-08-06 11:06:07', 'oi4Fwvxl8fQmLvoiRPM9WxqrdFRM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3c8b3a6655314690a5953920c58ae66e', null, null, null, null, null, '2017-08-18 10:43:35', 'oi4FwvyztgDWZUhY2PXpEdtkr-ks', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3d4b4c8327e448569c18196bd1b73cb8', null, null, 'cxl', null, 'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJta94n1zjqHvBZZrvVicNIzJLDvFbDjJOfQyRRgF8H57Z3iaweYf6mibAhQiabBIrFKIIXkQxBH8ec2g/0', '2017-11-02 22:30:28', 'oi4Fwv5kej0s_Mu1TWtP5hwEp9vE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3d898555b60f4a70b6270f638c25b036', null, null, '冒个泡', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWiaIg2MTYblRdC3amVW0cngsYAhL01PicO3u9pm3NtOkt1Cl5W4ribnsx7D20qpW4lwibIFkYcSwibMj1/0', '2017-06-05 10:57:59', 'oi4Fwv-9vTm_SnjoP5PWEkRtxnYs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3d9ab8bfc01c4713b86ef153db2b88a9', null, null, '9527', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqLzZg9ocJHwmWMhr0j1RwNLCkFF4R4N3jCAHkcE1icX3icG5mgicR4ic89dHJaNcHPm0ibsjL5edVoyNg/0', '2017-11-23 22:56:51', 'oi4Fwv406SCETWjaHqqEfOezPtBA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3df1e41296b54550b0f5a3478cd85d3d', null, null, '猛力飞起一脚', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLa4jvf3VvkCwicwpKj4BsgVNM9eO5cedvq2c2CFQneicmicHs0DZ6g076fJ2HrJvz1DplVibfzGVoHTg/0', '2017-11-04 17:36:06', 'oi4Fwv3iOVKIUew2iKEuruAz8skg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3e275e1feb394098b411d69446e37b11', null, null, '惠(xi)斌', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkx1a4Lx9GOlhuHTviaic8RJhzKIup2rYN4vAXgV59kq8OM7y4bAsHnjjfnwRJMCGLjVVkGoM1TiaSw/0', '2017-11-05 21:49:52', 'oi4Fwv5D0VFEdZ7lL6njuizizSsY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3edd97911a9847ee98dc5ca39c26a709', null, null, '李平旺', null, 'http://wx.qlogo.cn/mmopen/vi_32/P4ezv3KMVRgFtBsynIIbNRcSLQyu2gBPbInicrT3t5KWEXWibRO5ZES0iaJ30mbRhx9bDW5dTpibaZhTuDZJJ2qdaA/0', '2017-11-12 06:22:22', 'oi4Fwv1OoRL-uj7a8jqNymJQT21Y', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('3f9beeec0cec4b8491372db1b8034099', null, null, 'biubiubiu', null, 'http://wx.qlogo.cn/mmhead/g9RQicMD01M0ecEdGqfic9WZdoTFMkx1XsRicWuaLOngwOejDc5fLOXTA/0', '2017-10-26 00:02:03', 'oi4Fwv5dog1YXFfi5ZkCzzvwEb-M', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('40971ee691ea444cabee2e1864e31bf1', null, null, null, null, null, '2017-08-03 11:06:26', 'oi4Fwv6cSecDBkMERCmivFF9P-NU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('40f425283fbf4895b493a5e196577213', null, null, 'oyytoy', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erFZUJdhoSMqx6d8Qte8eag6vvmicv6oKibhRjprkSX2UoBhMcJ9h4pibNRGrMH69LxxgDqrjUDWml4w/0', '2017-09-11 14:37:52', 'oi4Fwv3vG1mPTRges8Ddl94W_lOU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('411fc37500214e259d1d82efbdf24795', null, null, '风起云涌', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM4gibfPLxSNutVEHu6SiaiaOLeyHdM2Kmlht1hwkRicYWicvXNlCDicj4ibsqDLGy8Hk8s6vPlIKY9EVO7WA/0', '2017-09-08 11:30:17', 'oi4Fwv-LPnsskaPqHnB4u38uYvx0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('413adbe74ddd4ec6b0092e711c102e04', null, null, 'bobstack', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI5QDU194vRT4mtUD4MCHTiacIP8tqRic2PxrKDlbEyibA4YcghxM8sZWVSOq7S7V3XwmAzwoiczGtvGg/0', '2017-11-13 22:04:56', 'oi4Fwv6IaM7uziRW264jH3ArKb6g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('414c54deb013411c84c2b65c0463ea48', null, null, '沈黄琛', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqqaFQ8op8WxD1eShDV8ricQ0v0Qza3bQ2QudusoD6J3FGjDx5s6ibewOehWQzicrExXbefPAopNMiacw/0', '2017-11-29 18:54:02', 'oi4Fwv5KLI_VDdrXWbh8No09smdw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('41848cf525434dcd8d2e9872014080d9', null, null, '周道军', null, 'http://wx.qlogo.cn/mmopen/vi_32/yy4cUibeUfPHPkXXZQnQwjaQfLoljYdicSFaNn8tkVszrwMsON7janmYSWMQIVn73tSPg5u6G2ELkdpcIJzILdRA/0', '2017-09-11 08:55:15', 'oi4Fwv9Ep2aCK_h85gsHhcaGxMo4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('41dab96bdabc44faa64b503797f56664', null, null, 'E星', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoDou6qKu4vm3G02p2gtE7gptWnyapZobosaL8CCWzJDUtCj1OZeiaf0wAzsJSpOAwDAwH1PXdG1Wg/0', '2017-10-20 23:36:24', 'oi4Fwv9IMOEUJRbFhAD6yNgQwunE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('426e55f9cdab436cb7e397de07a9b29d', null, null, 'changzhenwei', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlN0AUA3CiaZzk7LcQnqyACblBmNHBNLzhurTwte60icID5uwp9bQ8aT2drPm09bDibia75PsDCcUPYw/0', '2017-10-23 19:55:14', 'oi4Fwv0USSPXZBkwprYlwettQ18c', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4272f2da5e034888832d4c0abc5c274f', null, null, '405471113', null, '/0', '2017-10-22 23:22:11', 'oi4Fwv_K2BjPyFDRk-vKFASJ9ETo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('42a51640aafd41ef963331c27a9b7fe5', null, null, '1000', null, 'https://wx.qlogo.cn/mmopen/vi_32/pkaCf8I4HicxicWWf6w5wb3mZ00rWS1o5qWVoROicqHNficJ5cRiaGR1zNI5C3dP04mibmB1KBecItiaQ2LIkyZWF1wlg/0', '2017-12-03 11:52:39', 'oa-8a0WSGNCAC2DbjJF2LGaO6SS4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('42f890a252384d40b0f538825253c42d', null, null, '枼', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erg7j8xU5tHwVkX2ia4n0gmicHwYAD6XibCk20b5nOqyPhzro6GRS9poWvhty8yLJAMRXyiacuvIjwrTw/0', '2017-10-10 11:13:54', 'oi4Fwv2jVCu-R8P5z6V1F0kAWc7k', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('437006764fc34ff6819dee851479bb3d', null, null, '若有所思', null, 'http://wx.qlogo.cn/mmopen/vi_32/eluFhH8AtZDMUgow40vqNibBiaVKqMAJ92rTdFR8WNYIKiboYqzfWXpcgic89IK7MEJq966OYc6wDDLLXZvxv1FlSg/0', '2017-11-06 20:57:00', 'oi4Fwv-ZvWK6HTylKW9XYqHeETMU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('43ad169b8de54b9d8e11feb16b23f56a', null, null, 'A  L  X', null, 'http://wx.qlogo.cn/mmopen/vi_32/iboOtGDibcEAgebWEhOJd8vVxN1GMk2TRViceecvKDVBibywZmRnkWNnUu5TAqQ8xSUuenweicVMIbMr1WPycpPiaaoA/0', '2017-10-02 13:54:53', 'oi4Fwv5vc5QPvPLuyT72EYgRGR4E', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4593ecef59524615bb593081d68bf383', null, null, '艾', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWupo9Nkhx9NRHXbpVTHicGaMMB58Vw1ZRtROno2ApJtWMPavYqU90gmvLC6AmPePJpjicAbDyRB6rm/0', '2017-08-13 09:40:39', 'oi4Fwv5L8yooQBDQmOOb2yzowd2s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4688eeaa58e944458ae3e810059d3041', null, null, 'mulazim／阿克苏市', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKrzZT06vXeP0jlosiajrJCBS3BPo71gYc9c1lGGiaMDcandeALiaZtTnnQvyMxOicTibbibto8IxKfXQibg/0', '2017-10-04 09:53:13', 'oi4Fwv4cwVUd8pS0PkOQl6-AugC0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('46f482f96fbd40adb3aabdd3b8b8d7f8', null, null, '时代工匠', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooK1aND75ez9kb0x3aBZ5KSpKTz6yDtKN0RkVURDh7t01ia8cuQwOuC9W3QENBX7VukatFE4ewEDA/0', '2017-11-24 16:17:38', 'oi4Fwv7ox8Cgy99yg2IRvi2v11uk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4793beb925774edf9d74f95b919b3874', null, null, '空指针', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLsuPxIWODMCeibKVZib9rQ1CmXSiavwJBSmOZ6wNaapxc7siaRxAfKiaSfLkkJbrr6iahSu4C6UvnOtFbQ/0', '2017-09-02 21:25:27', 'oi4Fwv9jLjBVZne1-XmgovWZJ_oU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('47e90362b7494f2ea3e3202a31e9c302', null, null, 'A007甄大仙～享装修服务平台', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI34ZlT6HSOtKVbgjlu4W40cQkEqUD9cPNvA83G1N0vEFEPtWavs0hzA5nyL6iacwXq5aMBpgUZrvg/0', '2017-10-20 18:38:44', 'oi4Fwv5RrtdCuHgBOdDZmyZCqEU4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('48f8a398e3864362b3c5c685e3e3ab57', null, null, 'vitas', null, 'http://wx.qlogo.cn/mmopen/vi_32/PrybKkNquPCfv16aCImBhy6NUj8oxQJSVUty2ogeUOxIAsC6YYQrJckFfMkSKPhB67oYGBv1aeic1zlXFTibFhAw/0', '2017-09-25 01:45:41', 'oi4Fwv7f-48DLyhFd2Ipo7lu9RP8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('49909aa68a634f42b862f2e28682d40a', null, null, null, null, null, '2017-08-02 21:52:01', 'oi4Fwv3FZkR1S8Oh_Y27CLnpAleA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4a3291fc69d941a3978de691aff19893', null, null, '星空', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eolXiaTCNicFWdFM3LxE0uwKZCIUIhJ2CKl0dXC4BIBPMHW0d8RHfMkyhblAAcibF1BVYaPhOzEejSnA/0', '2017-11-30 17:10:51', 'oi4Fwv7-c6Xne8mJuXZ_D7_qzz5Q', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4ab4144bb80047e5a9ff7a5f45baa6c0', null, null, '陈鸿彬', null, 'http://wx.qlogo.cn/mmopen/vi_32/A94RKUfWfwzVTON5RGrAZbH3tLRwicdddVG1ibicJtJUDnJj9drEjZhib3xjeia0iakbk8fSj8ibyQxULbX6xxicwJHuOw/0', '2017-09-14 17:31:12', 'oi4Fwv8a_PfX29EIq4XdS53xD7lw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4b56a6b3f0c94949ad2bda39e54ba90a', null, null, '天晶', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLwsCeOicGtiaWHCmibpiauloXPVWgrMmkO5ggSEs48775s7Tb2FysOOjOpOfzPKocQicLKTQB4J7NRKHQ/0', '2017-11-01 15:24:44', 'oi4Fwv9IYGU8SRxUojurKe6UJWXQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4bab0e868c4b40e381469f66bec92c9c', null, null, '风吹老了好少年', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqrjtEZ1CQe5h0wRHIHT9wBRiaNMj6n0ne4WCYAdrplTOb5EOpUIPBUf4S2KPqc0C9zy3n80dRBWqw/0', '2017-10-21 12:00:44', 'oi4Fwv95UVTlbZEOVawxocxcxhcg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4cb3c5ff2ac84e958eb5bda85d8b3792', null, null, null, null, null, '2017-07-28 17:28:51', 'oi4Fwv8N0YWk1rTxnRXRc-TG0ir0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4daec79bfc66477dae41f22c2a9156c4', null, null, '你我同行-田冬冬', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKIAr0568ibR2ibfrFddstiaficsCIIfnDHw1Z1PcgptzMFibJlE9pgNua6vumoAuwnRxxbPqjeNwOm3ng/0', '2017-11-02 13:37:33', 'oi4Fwv0y65Al28eWOHzdZxFN4WYU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4dcf60cea17949bb9837f1dec94f8bdc', null, null, '。', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ45FTjX8enVu2DrlPXCvGJlurmo4dxucBPMWFicIuph8jfYT34uV3rFY93CHtcSxwMoQysjcGknkw/0', '2017-09-27 09:58:36', 'oi4Fwv5gbE-dv25dX9H75tca5COQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4de093cd97594878ba291e1431770a19', null, null, 'Zhong', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKwiaXhBKRe0rJSaMQhYZ3LS2DD1MYz6CQQbfHWFibQwNhMJYO6Xe1B96hpM0p2BDqJuVzGyrpAUQpg/0', '2017-09-11 17:59:19', 'oi4Fwv4hQxhM9BmYtDnKmDpLYXxM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4f4d197746914fea8304a0144cb57ca1', null, null, null, null, null, '2017-07-21 16:05:59', 'oi4Fwv3rgCsAgtZnBFuykrlVKCsk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('4ff6b61b4c1a4f67b6a3db83551478c9', null, null, 'Rick', null, 'http://wx.qlogo.cn/mmopen/vi_32/nHTeBrP98wy0DDrOibbsGUfK8qpneDPg31P6ebQe7sUjzEtRGkIiaXSow4hre6E3WkssjgWzDLX95RibIhN328KYg/0', '2017-09-07 09:41:32', 'oi4Fwv1uPl5w2ACh18-DpqrUGbY0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('50019d9f0c40495180653ffcb2e029cf', null, null, '渔樵天涯 梧桐', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJICAyKYnxLR3ygg8Y0b5IFhpnzJXeZmYYyI5uibIGH6sicYI4jZpXoajwnF04PLjg1yK1B8QbAU6YA/0', '2017-09-29 23:26:02', 'oi4FwvzrZl5MZTP0pDKQxRdxn7mQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('50893e3c70ae40adb9afeb85e19a269d', null, null, '会飞的猪', null, 'http://wx.qlogo.cn/mmopen/vi_32/KdJPreGRx6E9Mo44kTbBjXJUbb5vowLGVtY58bzf7eN0vYKLgLyKv1w3YwT5d4ZfElHD9X0Uias9qBNB2o4TASQ/0', '2017-11-09 07:48:10', 'oi4FwvzcXc4VE-9N0qg0yodwszms', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('50e61d47d04c437cb5bb5fc251c1b56a', null, null, '叶坤', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epsRcQM1w3rNmZNVibwVf1tqFYdV7OD8xWnHj7CrOgmlvbTCZQtCkyGm7Jic0kojiaRhqwHM73Whic3sQ/0', '2017-11-21 11:42:39', 'oi4Fwv28neY_-b6NRaX1yPfiCib0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5186619610974dfc8d4605bc1990b017', null, null, '佰迅通网络', null, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLBdqjHY4icGqvic8iaoj6Sdg1L79tETxhroMHOPv0hjvrBJiclgTf5MBuO9xyI22LIIHsmibn5LiaMHEt0ia67icuicOPKQUd9jmsWffpSo/0', '2017-06-09 12:30:01', 'oi4Fwv46A4CkmyiVxThQGZ4yzF2s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5360b4cb63684b06b8200fea91f2e367', null, null, '俞忠鑫', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erGUomlj3Z5paKQsFUAtcjlhb71OHEX7ZDFhXRV4auO6IysYTNic4XmI4iaeD2QExOQxTiapvOiczvGcQ/0', '2017-10-17 09:52:58', 'oi4Fwv2mC6H4E7MM9_2n4eyirGpY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('53e51074fe7e45c680837abc87811afa', null, null, 'Krismile', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCgTS68kCJYFZDBwS26ibxuoPf4Mn91rO3YoFpB36A4UWjVzfpoMqBw6ibUOp3wqSaY2GqibSDJt19ibO/0', '2017-08-27 06:58:20', 'oi4Fwv3juL0Bpky61qg6o8MQP8tc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('542ce87042e148aa874ea2d06433679d', null, null, '融化的冰咖啡', null, 'http://wx.qlogo.cn/mmopen/vi_32/wcsPzm0vX55lLRs97SXgYxHDtoFoTkpGkVqViaOKxYdfzpjK9h3mVtKPoovTthzlpt6xxg5Ge2jlV8KeIvIPFjg/0', '2017-11-11 18:21:20', 'oi4Fwv5DtlNbTEyMlc7Xp6IPmy9A', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('54cb8dd1a074411ea8281fd0ef484a1b', null, null, null, null, null, '2017-09-07 22:14:34', 'oi4FwvzS9ZRBscMhcmWZ-wAs69b4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('565c7b7dd6df45f291eb6bcb43da580a', null, null, '乐爷kyle', null, 'http://wx.qlogo.cn/mmopen/vi_32/vx7BK9qZIt98lZh8FDzHo2ZSO3lKqUvjZw9VibibT285GmATjWasrqibvCMJORn0wvH8xz5dibdpiaxdSSrlspgLndw/0', '2017-11-17 21:56:25', 'oi4Fwv8Ma1-Va-hsDgA7B43kVMVI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('573935adc1f34aa2be3b06c8e0fce9a0', null, null, 'kyle', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erAkBffOSyso5dJicic2YCLQBAIIx7TycicUmiaoj7FcuuetAPC7N717F3E8XZPy1GUUzvJGTypib4n0mQ/0', '2017-10-16 10:38:02', 'oi4Fwv3e3dTWDX1ORyK6IUhOVUL8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('584e1e685aaa444784d7f0aa3aa07104', null, null, '雪盼', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqY8Xfp7kpT5nP2PPLvZqpQUuCRb1rnRicsY1icOiaXCqrSeOyoIZ5K2WzZqkbBgo7Y9ia6WBVv09JSkg/0', '2017-11-20 17:46:51', 'oi4FwvwtcySoA03KJh5fdegGGtGE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5866da303ece4581b3a3e01a39b8096f', null, null, '华江', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvOiamibTX2EbCdIE5lVUWVw6XZOgMpyUo3EeRQFTKF1l2bIkm6HlfgO3GE0KspUWn3BfCsDMGqGdQ/0', '2017-09-08 22:10:51', 'oi4Fwv1I2ev97HP2nUoEuv7svPAE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('587996520c2843b083a38e41a68e4c49', null, null, '棠俊', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCt2e6Lluzf4lRXsib5ujzndAC3Mb6ToNib9tKQgeXuCS9rUliaIIlrXk2TefLkhykYeT2T4tUcJyQRR/0', '2017-08-12 12:59:30', 'oi4FwvzoEw1UZThZl-IsuadiJdos', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5a3ea4ad56234ebeb4758e38a65663a5', null, null, '金龙', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epczN2YEVPqaSFicFelAtvrSahxWNKQVxvgyKOWak6YHOIViaufiaCFdhqNy9fhRiadJS0orLc5CF3aEA/0', '2017-10-13 17:32:13', 'oi4Fwv0XnEXesbRJ1wH8vdak5-_g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5afceced2bf14ec5b50e0d0142e89299', null, null, 'Alan Liu', null, 'http://wx.qlogo.cn/mmhead/PiajxSqBRaELUVQc2ctMuwNtHEhDFeX3tFnhuC3QbuQMfdNSIMR2dMA/0', '2017-10-30 12:19:30', 'oi4Fwv6rQOieXsmDui-pxHY5yTUg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5cbea34ed7554c4080f0c2aa322efad6', null, null, '我是看小黄人的', null, 'http://wx.qlogo.cn/mmopen/vi_32/jxevVWOU9PeZgK9Zvqx2xsibIHcUBODpm6sRxl8E7EpVum1rKPkxiaOCIciatLdRx4jxu3VBAlGVicpLfh6PsLRCnA/0', '2017-08-31 16:06:31', 'oi4Fwv0-PbKMYlzsGySmTdyDIwno', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5cc797fcc87d4d31a1088ac89e080733', null, null, '颖', null, 'http://wx.qlogo.cn/mmhead/ajNVdqHZLLC6NCdffzryYevh1bTcxAHjaNS4b8gVXicvDZwR8NuswOQ/0', '2017-07-14 20:22:36', 'oi4FwvyzW_lkMfgQqApjq7vLHXAA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5d06a3b9a9374933bd14e39e94e5b49d', null, null, 'yealem', null, 'http://wx.qlogo.cn/mmopen/vi_32/HmSIauTjoKicPCYmQ8trAUT5NTnMUpdqYGWh6v1JCoiaxjibOwImOk3W0cPOFdS0IkzLhkelDGXWKU0zMSgA4zdHw/0', '2017-11-28 18:07:57', 'oi4Fwvw7fT6dOhmjyxIEn_en7G4Q', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5d39df649d9046a5aad4e0141a3d603d', null, null, '冷冷羊子', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmADVLZgLqk5kcZLTBgjpQibuO1dfHWV4ibTq9Oa6xrE7mPBILVib6wRqoib9icqb7OkHXh4D0XVkPTy16u1oltH0RkTKo/0', '2017-08-07 16:32:29', 'oi4Fwvx2MIv2dH0zQso8ENath6i4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5e2c3aa1d87e4cd399a5315224592430', null, null, '景', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaEKInHHY8VdvF2H2ibbbC5TREsVRGk4HIG72WSaIIWuXBN6lib4MnVtREAkVKiasKibFibHibNggxibutiaTqw/0', '2017-05-27 15:01:04', 'oi4FwvzPMuTa3sqfE325qfUp1CRg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5e8755cbcc0f4248bd762e1fd18f7bfe', null, null, null, null, null, '2017-12-01 21:02:31', 'oi4Fwv3LPMciprJ8HoHJlZ2zqjlo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5f2f47a431624a75bc9df34d1542489a', null, null, '于涛☕️', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erzA3r2l50SRjgcI70sapoFeUSu8sqV1FQibRA1icEDZ83SZwqWrIHnVdGtkIJ8biaD5l8uuCtTYOamQ/0', '2017-09-26 14:17:41', 'oi4Fwv1D5cugL4LDH4TcFg6Zzmg8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('5f91eaf027ff4950be0d60b8c14647db', null, null, '发号网', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoHBgM8jgq7xd0q7X31t6ctdHW1qwhC3ckiaBaahIsJNs7SMxlORAuH0dBCqVslUm6oa8ZMu8FMTbw/0', '2017-10-24 14:59:30', 'oi4Fwv1XN42V5A_a-J3nb9hg6MHY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('62b9d14cb34348348ccb95c546f5986a', null, null, '听海', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICGLtkeUz1lZvb4JYfXrBHzlA7bOa1KAhH1ibswgpxHYJLlguRpfMDgOph5BWBp1gkYQ0J8SKWQYg/0', '2017-11-10 11:58:35', 'oi4FwvxizTdhZs2noehfiy5qfGd8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('62c37e17b35f4707adfe7206e9b504aa', null, null, 'Tz', null, 'http://wx.qlogo.cn/mmopen/vi_32/STSbkibq9ibTEyzOrtRibJvxVbZaaMe3YFge4d3zqTpOcmZNcVPCcCCZicRktfIGU4P8ia2qFOWP0H1XRQiacxpKch6A/0', '2017-11-29 12:58:02', 'oi4FwvxCDkXW9IUFrJXoWXOqKPGs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6339c3f3957a44bbad923c21e4b0a70c', null, null, 'lin', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIqPFBX8oeeGfSRMd1JCAsm1eAup48PnXntlYUriajicGic3h0IJaGI388ibSDrgssynAcJNGbCfy7kUg/0', '2017-10-20 00:29:04', 'oi4Fwv33MDiIo-GhljtvdXiC89O0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6340012fb321492f942db56fe6e7b1b4', null, null, '千寻鲜花', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLJv7sDRP4SApq4xicXFGumVHZ9ExTl6eXoElRU5I4SEfqvHWcpNRbr5ZJXgmo4C6KaUcankv775vA/0', '2017-11-17 19:01:38', 'oi4Fwv69QCp_yAPRrrQRiEOasQSE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6392df4c1fa94c4aac06a16b40f79957', null, null, '影子哥', null, 'http://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBLLbUooaHXGEoOKWOVf11f8VNFIJqVrnEjZ2dTpTqlfanIdiaerpXcXnCqZSDaGh1lVyIuMFYnicCA/0', '2017-09-09 11:39:42', 'oi4Fwv8MMhvFw3VCuEeEyZEf0F5g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('649aa85fae4f4bb0a684d5dda8d1a658', null, null, '苏生、', null, 'http://wx.qlogo.cn/mmopen/vi_32/Xr2n12rEBAN3Du4j4qib3ppicnPqtK1Jx6kRaric6gWQuSvACDVibVVuPkN9jhbpSl0Iczxjo2JKxlwkwazIkpnBRQ/0', '2017-10-16 01:02:19', 'oi4Fwv4dycN6i5vljMj2T0aJjPDY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('65113532ad8f4f06a75a9774ec8bf881', null, null, '此心光明', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq7pdTvibngu87nHFIuxLgG6nyVbqmEiaRfYZxZcvusy4PdxHPpWDo0MXJ6Nm89pyYFkJgOs3fFwJ9Q/0', '2017-08-31 15:28:51', 'oi4Fwv2UFofMRfkckxYhK1PJH06A', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('657eb8252e3c4861a898b757dc7117b5', '15191585815', 'e10adc3949ba59abbe56e057f20f883e', 'jwei', null, '/mallupload/1495869991823.png', '2017-05-27 15:25:50', null, null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('66376c8724634e9f9ec911c039acac3b', null, null, null, null, null, '2017-08-05 22:34:47', 'oi4Fwv-_r3K8-8LRf4t3dPdKDoRQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('682aadafc192414b9639c98e01e3ca74', null, null, 'Sol', null, 'http://wx.qlogo.cn/mmhead/EVtuLqmrNAr1BVRIv438VwlkkGSSf7of7SLicYicHFO2k/0', '2017-10-30 14:46:00', 'oi4Fwv-x-k4ryfGL9N4auYNejP9o', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('689ba5b42d3742498012d81d0a359df5', null, null, null, null, null, '2017-08-06 01:07:49', 'oi4Fwv6ip_D1ezDGuE0IbB2DJaRo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6a35f365d2de472b8e6437562b7d2e7b', null, null, '酷玩', null, 'http://wx.qlogo.cn/mmopen/vi_32/WaoJzYaQHicsxp6uar1ic36zDLiaxerbPWmDLiccfy3VLNDofxwzr35qzdJ7dFrl5diaLDJPueZmsyFAENQ38tJLUfA/0', '2017-11-15 18:30:50', 'oi4Fwv29bIzsUN_4E-tYUgyJYRu8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6a8c8b3f73e8482d82f486e93feb54b8', null, null, ' 胡老师是不运动会胖星人', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJNxMqDoNODfFNub1PAhbgyQK0X6sKC2YAt65ibzBusUwKhBGjXKU5KCL9VMATvvdk3jdscooMj0Hg/0', '2017-11-14 13:43:20', 'oi4Fwv-zH7bpjmAfqtgm_-jvgkT0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6ae7654206e645e7974cda1c7f84cfce', null, null, '天涯飞雪', null, 'http://wx.qlogo.cn/mmopen/Q3auHgzwzM5ykQGQJAbFcCU04Fm7EBo8sYknJiboM0sNzok3iabKPSexDxbkicEozicw0hYKu87qricfZEnMZ3dLibhKiat7xufM84u7MIjwcVTbF0/0', '2017-08-22 12:43:46', 'oi4Fwv2axuP5-EYlBeINzhljwvlg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6c13444090fe402ba6fb04d5837ab2ce', null, null, '大俊', null, 'http://wx.qlogo.cn/mmhead/PZI7pLaVibDNMZ7GLNQW977Sppb81Ta6qmfpiassevZFKMbvrcOIO8SQ/0', '2017-10-25 22:11:23', 'oi4FwvyDMkGhfXczGKXA-COQ2HLk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6c2418ed1acb4823a918d8fab9f2c2cf', null, null, 'Wei', null, 'http://wx.qlogo.cn/mmopen/vi_32/uqDxoZSnIAXlehDicRmP0e1qcMCfdyIfByIWicEiaMqUoy3rEj2kricqCxP38suNjqCnNEIBOqav63Z6qlGe2XTfOg/0', '2017-09-16 23:56:32', 'oi4Fwvzto3mKVM_BaIs6f-TFVMBA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6c8d3c22a2724d46be22198ed6896bc1', null, null, '日明金诸', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLxUF11CeweprUaRm8RLDibrkiaNqjciawhk24ic5CFcpLNdsmxolh8Iac9Uicvw6OiaGbicShSDKzBkpOMw/0', '2017-11-06 20:12:41', 'oi4Fwv7jzzajn59AfHW1eCxYRZL0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6f0beb1b17914d2e8812ce227ebeda70', null, null, '小老虎', null, 'http://wx.qlogo.cn/mmopen/vi_32/7Ar5ndX7dvEZRlH1A6Kh0pZHxptS8fXjH6cjt6J4ic94u1Pr4Yax24U6clVocx2jf5Y2IB1EuXdl0vUXXeicNs4A/0', '2017-09-03 15:45:24', 'oi4FwvxsUTIRne8pzPLEz-mw-2A4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6f26530d39c343b6ada0e1d6e3c9a6ec', null, null, '合肥生活点点通', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJBru6Qa44qiba5RmS1WnefJ4bdFKWZD701z1sIhGCMMICiadwXick1UEjaPOhPYvBDMxahXlsJo2Djw/0', '2017-10-14 18:24:11', 'oi4Fwv4iEjmxzgx_tTFFvLDIluf0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('6f34073301f24b6d931b7438bddd58e6', null, null, '上善若水', null, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLvrkYKHlgmfV6C1edMplxicHictqcvIIVicnmXKBzZ6Ukq7E1ibpxpw9gQ3D6y94BOsibtTl5BhKTscBA/0', '2017-12-04 17:37:02', 'oa-8a0R1k054KjMurgM8eq2N8ZrM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('707f03b7d9dd47ed8bfbe9b3a314dfba', null, null, 'vincent', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erND96otTr4MNUU4wSfAibSV8jS26XCl66G4YKD85TfyW7wGJ8BWovjEpgVTUCibjXk94ciacLUZ9k8A/0', '2017-09-14 10:09:32', 'oi4Fwv9vxv9wytoe6qtrOG3P33zA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('70c2859696c74be4a9c6ce82f199ab26', null, null, '张永恒', null, 'http://wx.qlogo.cn/mmopen/vi_32/9oU11do4Kdib11dg25ia8G9Fy5yA1NLZWjeIzZRK7vfiaCOticlseethx1f1bOv853jv5PdlFIPM7LHsUN8eckzGsw/0', '2017-10-19 04:13:31', 'oi4Fwv13cKFAiflCJQQYBV0lnCdY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('70ca82ed6a9a47f58c31dc603574e7b9', null, null, 'JaneTao', null, 'http://wx.qlogo.cn/mmopen/vi_32/6JhLj61TibZxYIsTF2yYuEnic1l7XJfGcoibicHIIR0KvRF0kH3GqjDBUwpvtMjPMciaGCkgqAJvjBRXg4KuxhC7h0g/0', '2017-12-03 01:56:12', 'oi4Fwv8dqgsfqudkRI9CZObr6ntA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('70e0ab2d4e0f4805a77bd2fb959c3049', null, null, 'Since-A(苏州非常青网络科技)', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCrmLar8u0FZY2vjspR7rI8mOhOSYqCcIDJnN1vpIvtuqCKbpN8tpph8ehKFibVXkpOP13E4FSNvm1/0', '2017-06-04 14:48:33', 'oi4Fwv96W9lUybUIT3EW1PxRY-Zs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('71b00a30e3504075b3ae1e7f9ad05cd9', null, null, '嗯', null, 'http://wx.qlogo.cn/mmopen/nqFT1KuDpBSazBcU5eD4UUEPubBTHiaApfQgxz5jqOwicC01nKuDicV2LbA79icYficcOAAkogTADSu7n1niaSBC2sO3ECxsWztzUU/0', '2017-08-19 10:59:55', 'oi4Fwv7dbDUa-WJoMrNCXglrsScc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('75b6b81ea4af49cf859461f4eb663f5e', null, null, '原麦烘焙', null, 'http://wx.qlogo.cn/mmhead/Q3auHgzwzM7tcd66lMsIXmqLDyjGYzicoHXbQtYFw2PicOYCNlVxc7BQ/0', '2017-10-26 09:50:51', 'oi4Fwv9IHubEtQlmu6Mb-Yk97VtA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('760ebb11d01943569b46893a4591852c', null, null, '靳光阳', null, 'http://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLARu5maSnn6kaMn7BmeKSHYGF75yvbVWCr8KZLliaQ5sBALNT788gbmrXCZiaoiaHG3ts8KWDibJQWScw/0', '2017-11-03 12:32:04', 'oi4Fwv01bErq7nU13FHVfmkjpcRU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('76dada5864094b96a2102050eb9c2e6c', null, null, '唐昌华', null, 'http://wx.qlogo.cn/mmopen/vi_32/YAckHdz8hZWhgqojx2wvTJgZv1O3n6ZFwAoMSSiafdw6CAXjHlVib0SibBt1JkF2n0UUtXzGD04VngCpsVMBMOJDA/0', '2017-11-16 05:28:16', 'oi4Fwv39xuX2Gzz5oK-vmCbBXZbs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('76dcc416b670498f88c6bfbbbafb226e', null, null, 'hul.จุ๊บ', null, 'http://wx.qlogo.cn/mmopen/vi_32/L7nib1TClF1OwvPNtQqiaw0dPPFtUFg4e3F2WGFvce4GjjJf21nhzmdt6ibtKMc5fz3FDt7znmf054651wyDJCzvQ/0', '2017-10-14 23:30:59', 'oi4Fwv6l_WQaMYno_Ba7_Aj52Nt4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('772d60dc0c3744aa85b398f16d659a48', null, null, 'Mr杨羊羊', null, 'http://wx.qlogo.cn/mmopen/vi_32/iaFd63wtL3jSS51Wqlzeibph0nvwRdXW6sic4jcKfhCGhrIibEOZS3UfLicicyxwkRL4gZhWCAiau8593Gg4KocyFlY3A/0', '2017-11-30 12:40:15', 'oi4Fwv52VpTH8d3_YjvGImQFaA6w', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('78271c06cf1543a0a2b48dec95d324ef', null, null, '流星飞月', null, 'http://wx.qlogo.cn/mmopen/vi_32/j6A8tJUP6ZLyEmqspOvEzmbKBF1WZnQSia4lSudUWoeghr7sjcNfFANIic6OfX4WofWsw9TdqfcHDfLPV4iahpVyQ/0', '2017-11-14 14:41:12', 'oi4Fwv78FyzCmeru6l3FHeZrTdgI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('7a45a941cb8446aaaff8bc98c862296b', null, null, null, null, null, '2017-08-07 13:11:25', 'oi4Fwv1b12GUu7wcllsVHrkwvQQY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('7c02025e118e44aeafc42964be131367', null, null, null, null, null, '2017-07-22 17:58:17', 'oi4FwvxwdCKBFCEcTT53J2mM01To', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('7d9f923678bc45a69d701ad9813ef04c', null, null, '何奋远丶', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkArlpiaIrFcGfhnhT5qlBthNITdMtZgW1iao7GuaAXlHjnMLnrnS5iaTRbFxGIEePfKiavDYia892EBg/0', '2017-10-16 13:18:05', 'oi4Fwvy0ozrJ6naRDD6aygvhRiLg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('7dfa744ae8164311bed972852d2498f4', null, null, null, null, null, '2017-08-18 11:04:23', 'oi4FwvxqIoUoyu8lz-C8esQdFQzM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('809ecfb6d792435a9635eb0bbb2a663b', null, null, '㐅', null, 'http://wx.qlogo.cn/mmopen/vi_32/94RcfbZgzvuGfPaVzYiba6I2EILnlMbngelngya5ZNlfDfFu9lDnwuyiaRibmkcVHVZhfB1j4xic571icgJ07oV5vDw/0', '2017-09-22 18:54:21', 'oi4Fwvz1upFgkoKuIdyP7UzEDA8E', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('80d20f2bde7e447fb3469eb8115d4749', null, null, 'BGM', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er6W8SVcpc4jBHWicD3FKdIxJYrDA3Yz9LqnZKibBHZmWGS0HLKUKuO5a3ZH3A5SaEjYyS0zpkRJd3A/0', '2017-10-10 12:41:49', 'oi4Fwv9IwEoY9cbqujLOdIMGEKyA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('80fd6762b7ca43a2a608b641229b4e44', null, null, '　　　　　　　　　　　　', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTITf7nsbx2HRIzWJhaz99nCgvB4YIKbVKBqbjS8ZvogQcvrFNTJMPOrkJugPsz0yzyHt0eratYwdw/0', '2017-09-14 11:31:40', 'oi4Fwv2mWvJPyUBdw8CbeooppUaM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('81cfab13adb04aec953bcdd68defa863', null, null, '闫繁宇', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJHblHJ5ln3cdnfuLkrZX8cs7uaS9aCQQr546e1p1Z6sCYFOUicSqlAcpxcJMu8netynphk5SSoOYw/0', '2017-09-19 11:47:21', 'oi4Fwvysuhg4CiXcAzBsph3CNhsw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('82d8134879bb4e92992327535b859bdb', null, null, 'soul water', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKyzrAhZ9FCVHtzQPBzlIUwM03j3n6Oz2ZCLOoMv5q7DM2prgggriazEu1sVsgInke1JAVZLQJHPoA/0', '2017-09-02 15:21:46', 'oi4Fwv9R4LkxdxpwMoVraQwl2pM4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('83da11baa7484bc1b01707e375829a16', null, null, '南山流水', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLqeookuohFax45B2IaW2Dh6ItCN9LOANibeJASwP2Gictz8oTuicOAcSZfLMZeC9nLZHZiaJdJZRyowA/0', '2017-09-21 19:46:24', 'oi4Fwv0ao8WkPmoCWRkJkFG_pvpw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('84c11cc373e24ea0a4aea2f95fefacb9', null, null, '曹强', null, 'http://wx.qlogo.cn/mmopen/vi_32/vuRlHicBBnF8vytFQtkMiajyEekHFQoOKmpeEHSVv2Wib5v3SfIuBnRmQMByiaWFTRCwpfr3KeJLsico1c5BF9U9g1Q/0', '2017-08-31 19:53:58', 'oi4Fwv0iWhjldIhm-CuEQwCdqyAI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('84cc9c3c3d0e46f09ca15d3a17f77e06', null, null, 'Mr.小麦', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaELpEzYRY3icmDzXJpEmVBpibQIz2z0AibWgBMibYS0dcTEpfG1rGgHfJicSCyb5X6K7lhq9B7N6wupvrUQ/0', '2017-08-07 18:14:23', 'oi4Fwv1mFdRY0aTNMx1hBe6HRK84', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('84d42b75be5f431db5cb04e8f3e5d0e1', null, null, 'a001点师傅', null, 'http://wx.qlogo.cn/mmhead/CJ35Z2cnZA0vicPIBwwMcW12ZF1iaPE8cKhkzFsHGWCYCPMAeiak5znQg/0', '2017-10-28 10:23:06', 'oi4Fwv-WfEPSup0DnPSljctYY78I', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('85e3348c618544f2a443c623f965a83e', null, null, '海鹏', null, '/0', '2017-08-31 15:33:20', 'oi4Fwv00OrhFOicLn5jzcG55FL-k', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8813fc7794d94900ba685b47757bafbc', null, null, 'soso', null, 'http://wx.qlogo.cn/mmopen/vi_32/k0ibN3iaGvLR7gTSP9yoXCZm6ldxt6tSJQwkWoHRXfl3MNmtUP9GVic6SDiaxOJxxGW3S04ibSV2zUP8dibwsIk7Cj1w/0', '2017-09-04 12:27:56', 'oi4Fwv6aiUL7TNmQrDXRKUEelBFc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('89968bea1649488aa4d8959929eab2af', null, null, '陈锴', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmABPYYbYouRwSpxcadCzCiayDCevu9ag7IhFagOOQ6cjRTicGNLia9qFxDeiabm68zhkF35KcADItYfK1SoXgAuamGlT/0', '2017-08-29 23:03:39', 'oi4Fwv56epMCD7_VnzLPHqerRk50', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8a9e5a8e79654ab29d76f4c6b24a78a6', null, null, 'ʕ沉淀', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN9JiaWibTyXca3GjMFiatfY5HG9RHhibn5x5icYzOk5ibz2fnJLiczkpHtgTytibzpu0jQmozT8v8On7anj1/0', '2017-08-21 11:14:55', 'oi4Fwv-PzXuP3zpN63vcbs3JQEMU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8adf7611030e4e42b70eb396f39f4b81', null, null, '杜谦', null, 'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmkaIq2eS3fG6mRicWiasWIKJYmNTO4bZvyialK6iaqK1jEhltyLcQVDnkUwyfFnRQuTtJjq9LgzHesA/0', '2017-11-13 20:09:28', 'oi4Fwv4M7wgWzWXiB5OGtheQMz4o', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8c8955e792aa484cb8cac1c2738ab97e', null, null, 'J2', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIP8OxBCbopONC4GkCnWTCM9aolVPiaXm8nOibcXibxmW4wXVFrHnIy3VK69lZGy0SEMjxot9EYeRFng/0', '2017-09-09 11:37:49', 'oi4Fwv3cADUiJtS-wKYDe7JHibL8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8d13dc19a6e845c5a91ddeeda8aea315', null, null, '水朱', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN8THBtr3H4We2YjKrCvxXmW7Uk4ZdJkZBIAY9mzfM7qKyBmByVuicL4PccUe15yeAMibJWKU9EGbTR/0', '2017-07-27 12:49:56', 'oi4Fwv-k8ikfP9KF6SBqnVI9b-nI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8d816636268141feb74113765d547770', null, null, '飞越', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJNBSpoCN6FKTEXNzHib6icr5HblA3J2xhB9JU29ibTIUjsLvYmxL1CBmBZzLuBmI7Xu0JFAMthl0ptA/0', '2017-09-23 21:52:22', 'oi4Fwv8Pa4xOHdJJYKIu1s0FZvMU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8e66dea8a0ba4e24b4f1d546a003ab2b', null, null, '冰点', null, 'http://wx.qlogo.cn/mmhead/Q3auHgzwzM6Y1UbDZtALFRk6aTtpuGNk3U04FkYaxmRHss1Kjgdlhg/0', '2017-11-01 10:00:02', 'oi4Fwv_45wKpr6tGw_4rElcVGS1M', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8eef4775933140178c1fd7c02e18992e', null, null, 'zebra！', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo263laxfSk940NSzVTmAnCQ4LHUYslX87Yr13lDicveZ2Pl1hPDBVVy3HuOr800304F5aKO9hOWfA/0', '2017-10-23 17:21:24', 'oi4Fwv2rKbKRo3ycMXcoH4zccJz8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('8ef911a19d434537931659008a08477d', null, null, '看潮', null, 'http://wx.qlogo.cn/mmopen/vi_32/j6A8tJUP6ZLyEmqspOvEzpD6OFdUUfctnMk0HaTRupchyVFp7BfDiacYZIGk04Lg8F4qRUzS5Atlmt0ZaiaBYEjw/0', '2017-09-29 11:30:03', 'oi4Fwv4YW_z_zoa6FH7krZ1Nv0q8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('90e9eb892be34fc59e8e49e285282f3c', null, null, '蒙牛赵金恒', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er0gpDoqDibrXA4BXr8xL9OVeHMkOEic2VHeVjGRopdtN20ic34I5hauWpyKzsM8xCiarVrt2icRPHuoLg/0', '2017-11-03 12:39:00', 'oi4Fwv1c-9MIOyNDvdYIXWQJQs2c', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('914548c8208f459abaab6a1edfbdcb66', null, null, '何喆', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLKjgxd2EW6b5LXxC2ALZ65ibOCoVAEgNU1CFwKJ9pJiaW5FnY0cSibQThaEC1atib0WyVyo8ZCAL3zmA/0', '2017-11-10 17:40:20', 'oi4Fwv0PW4b0b_kqyzxLjP_o5DJ8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('91944a5bfdca42909f008ba2646e9bdd', null, null, '小傑', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN6sN9JrI5el3zWJW737AOKrgezichBydE3atEPd77UlEPE4FPjqMwpPRbrq8zsubhqJHTe1D61chW/0', '2017-06-10 16:46:56', 'oi4FwvwiGwHNMSgvUCdWImR2dI1w', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('920a6edac0b14807976507d44f7fd35f', null, null, '云众科技', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ4QCWqGgMN4nC4XhDelUxwtehNGO80Tia2JvQwUmJaDFRPNU66599f3yJhcSYxhVe2auPvAeyXdeg/0', '2017-10-05 17:05:25', 'oi4Fwv7bh9w1oT9N1Bk7IWs29ZmA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9266bb3662694dee959ba8232e3f5b12', null, null, '张翼', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaEIlofIroA7eib4iciaPoliasmTXJT1Hz20xic1p0vVAu3XQtZLXRXHQkbHqhYuW8vnpNzBulEjxVsqGSjA/0', '2017-08-21 11:12:20', 'oi4FwvyfSJYt_bjC1yxj8atm0c20', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('929c741b86bc473ba0e6e2f8c2d4f1fd', '13184235048', '96e79218965eb72c92a549dd5a330112', '商城用户', null, 'static/upload/headimg.jpg', '2017-05-26 14:22:31', null, null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('93b7cb4ea77a4ea683d0f30bf55fa00f', null, null, '@_@', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKgicHcQo3k7TJx6YbYw13x2ibAg7o1RRXqopntqj9SFuSiadlj8ztPFTBGEcEKVoGsZO1VBKfOt7CAg/0', '2017-11-10 14:50:30', 'oi4Fwvz_vQgDnrmI3tUS4S1Ibr_Y', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('93c7cc7d94be484ab9e9c626e3a33778', null, null, null, null, null, '2017-07-26 18:06:05', 'oi4Fwv0ReQ-MpOODPmNRK8I9K1IE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('94f043b2e5a34f539c05350091e10a67', null, null, 'ini', null, 'http://wx.qlogo.cn/mmhead/zsUXYY6y4cKn0KY16SZnVGf5M49icA1kaRtdibtibqhaXRnt02iaoAdLrg/0', '2017-10-30 00:17:35', 'oi4Fwv5aw0ye8rpOXwORHmbPzKKE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('95a96967ac7948d6a8b267914bcab66d', null, null, '第六空白', null, 'http://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBAvicf1iarysQj6PBZHM94GczHZsI4wmXs9XaAdscUia4awWhTYpUWqalib1bpxApxEHibK92GkTt7Sew/0', '2017-09-21 09:39:19', 'oi4Fwvwv9rVcyKP__qca_U3_LJpk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9674b4b2f2e84af8a74d81a2a72cdfc7', null, null, null, null, null, '2017-07-21 16:21:29', 'oi4Fwv2cDJXphlmaNZ2OHOsxBot4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('981d0b99bf9b4c4b890a68716d519a4c', null, null, '一铭', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLZpzZqvib4bztVrU39woqd6u8JiboibsUSQxZ9BjyicmaSBxxj4OQXnVbgTUeJD4QVZMzRqDv8uFvliag/0', '2017-11-12 00:11:38', 'oi4Fwv4N0ZbnDGeKV4a25g5AeuAM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('98ca6a4d667f4e9689f33f3006b0322f', null, null, '人海相遇', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWg3Vm2HoVxMXUIH5eTMN5rnY7pibJ9GDWEj6E7A2HvSL0KeKOX9aE9Cl9CTVkpzpQAVBAathhb3fr/0', '2017-08-18 10:46:30', 'oi4Fwv9ypY2mhJZDOaHVhRp4o0Pc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9b2b6c0f6ba1403688a312de0b9194eb', null, null, 'hjr', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCiaBtLX5NNxTXuEhqMWj2Wib1pvuN4FCRbyBHJic3Hs1gojduf8ZLg63m3RgWt24hFYDQPyxcHFz9au/0', '2017-06-09 22:06:34', 'oi4Fwv3rFyaC2ocZWTrSI87noYDk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9b647dbb7bad40299829d506c30d8d2f', null, null, 'Z。', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCstVHfayxatLUNN7lgTSc2hSG9zJskxSRQYXDpkwngiaRIBJpYwdkpMER96YP0EicmC2fXErv9aQicp/0', '2017-08-18 13:53:58', 'oi4Fwv9U9GSRz1h4glBfEJDPigBA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9b98aae91db04b459fdb114ec8759daa', null, null, '落拓不羁的慕容月初', null, 'http://wx.qlogo.cn/mmopen/vi_32/j6A8tJUP6ZLyEmqspOvEzvfgEf2P5S5Aq17XvXyhAIwicfXMicnj2p2PUpExcuibQMaoFK5urj41ukByXSOgnOyWg/0', '2017-11-28 17:49:50', 'oi4Fwv2z-mjgURybyiWWUJLm_FKg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9bcc72a2673c4f48a3bf02ca66539091', null, null, '任强', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK4AmMYFOBCmibH1AxrkXicBZ4BDNnZsXUXWlDmt78D9WAxCFp97rmP0VcIA5X3NaamPGB7CFCxM2Cg/0', '2017-10-07 17:43:21', 'oi4FwvxrGA3aDt2HCR7LbhLCHYfI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9be424bdd45941ed930b16dc6e37b3da', null, null, '孟先生。', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eobMd1ZV2bFFZ1LoTkViauvAOxXic49YYoUs8BrXvZJ5NyfFYYdPQRaoSJfKwUMc7ETEe7tobmibAKmw/0', '2017-10-07 15:18:27', 'oi4FwvwbGMsSPnPbYnnR7xAWihBU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9c150a52f9d04b2d985d97d1e1d53c4b', null, null, '苏三', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eom62wTPZKfeXKG0fP6ufMoGeP3Mu0518JjGI1e20UsbWehsc9ibmiagfxHNa6wLqtdmGkRPjEaDbAQ/0', '2017-11-29 19:24:58', 'oi4Fwv2wSrg2JwZ88Dn9-GNKNCuY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9ca74a224db249a5b3e32454b4ec423c', null, null, 'changzhenwei', null, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLX0lufg4z1LDzpfOpNVEIicUKIibicpIkqjf3KibMep8deDGbALNqFEcaVG0tDXHT586TnSTQ8JJvvFw/0', '2017-12-03 10:23:55', 'oa-8a0TLEymCLf5LsynYRgg149ko', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9cbf15e7abff449186599a84889a3c9d', null, null, 'mike', null, 'http://wx.qlogo.cn/mmopen/vi_32/1uQhUgz5gMfduTyFsIGee7K3Qer5UsV7Nj1GU0UBg37H6KibpOWYHNzF8VicC6Ln79LMmiboiaZmedaHJkycaMX75Q/0', '2017-10-15 11:07:09', 'oi4Fwv_SwD8Y23K8XLX-KVzHPRjw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9cc281f81aa441808ffa524dddc13492', null, null, '雪狐', null, 'http://wx.qlogo.cn/mmopen/vi_32/juje3RI8enaRGExcBficaea8tbdmtFsPGvmHsgibWkAibP3vLhNomAaK40Zibp0micyUJtLkU8IjUgD36kIxbjdnWXQ/0', '2017-11-28 08:12:18', 'oi4Fwv2vKwqAlq5nRbgUl7bjZVhU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9d0176551c33464d94ab1ae4b98fbae6', null, null, '维坪.颜', null, 'http://wx.qlogo.cn/mmhead/YxFpmpHicxVzI6MDF396YkHjcGGGYgkkK8aHgUlsrsgo/0', '2017-10-28 21:21:45', 'oi4Fwv3xaR0A6iihhYU0Ccqs_oZY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9dcdc8daeb2e4afca66899e1d0140d70', null, null, '开心鬼@肖继先@倍佳通讯@中国电信', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eprSlYvz64kj5CbhVjROkkQctVc28XNXa49NGHk1wyXYIMkiakQFQgYng1bbLIYLaWfibpXibsHK74iaA/0', '2017-12-02 12:47:05', 'oi4Fwv8BgJDU1EAaqy9FCowamMGc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9dd6eb3110fe430198df5ae9d874b574', null, null, '木易', null, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLCAYzvNwPfFyc9Keq03Bxgtz7icsl5dgibSbzrPTO5CaSDaoCatXwNzJuX2dQXtAicJvmjs65ofa827w/0', '2017-07-27 08:06:01', 'oi4Fwv2MhrHC8WsSLntKmpXdAxxk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9dd8e3a34f364650b15acc6485f3a0a3', null, null, 'IT&DT', null, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLAic1QW8FBSgZRpKEC0PmfK95W2azMEyR82xzqvnZrRyU6Pl5c8yROgPLHXC41Yhib1z3y8B7FLy23Q/0', '2017-08-09 11:49:03', 'oi4Fwv2E6ppG1zPmpIZ0Gf-UCPYA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9ddfee99c2e142d0be80b8ee3ef19563', null, null, 'TAIDONG`', null, 'http://wx.qlogo.cn/mmopen/dlnn7dkIvD3pV83XSvwYXNcDz1rfTYcbNXkiax9Qr3a25GRS63vj07hYVuFQd1UWscvYaoQxtMJrBbvQAVaUYzxktrw7z0xPq/0', '2017-07-27 15:26:52', 'oi4Fwv73WzsOPjtj_ou46HbgFzmE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9eeda7739c534ed28d60029084c2cc6a', null, null, '谋亮', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN0ySibaqfX6ef2rIxw68JiaJ6iaf9kSBqoxia4TCY3yJdiaHebRVGmIAHT467lTtTlaib7seR2AJZt5dHn/0', '2017-08-26 11:50:21', 'oi4Fwv8O8Y14db0w-xEwo6Fq9yhM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9f317eecfd7a4c1ebd175271173467e7', null, null, '速购网络科技', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMYOudnjuoNIlfWfiakKPDG9at8lTRTXc8eub4JfgT9QQ55WYRIgSgWCNXicHjERe0NTuxEovPMg8ObTsxLndjzyW/0', '2017-08-24 14:17:21', 'oi4Fwv1GbfTanD1gOIrbc8wO54hI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('9f959075f65049309a5892f12483ed1d', null, null, 'yang', null, 'http://wx.qlogo.cn/mmopen/vi_32/E2vLTfmGCCh4QYpXIxks1M2w75N13fHJNWic9jEKXRhKKZQiaHsJRj0vaXibE8XibPvpIschloWgVjsl1c7tJicibibRw/0', '2017-11-11 23:42:48', 'oi4Fwv9iTF1a3CaY2bf04zur9X4o', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a0281929f9f849afbb0c6ded42c0c616', null, null, 'Cajh0ng', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OO6VmRbKQV7OrUao8YavHEqMeLwACuBEic5ZuBEnwz1pXy1IBrCNXPNIoV5Ufv6uyCgYLWBvOJKKovHPibzmmMwOic/0', '2017-08-22 13:04:50', 'oi4Fwvz6jvHRF8aU2rnySmO3VXEg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a077bd35ebe247cb89e0a99866832dee', null, null, '橙子井', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2ciaq8nJILTS9kDbKdcNhibyl2wL7epztWsNt9wlssT9Qg9tLthemmBBtsBjSUHzjfoETUCLHdxkIe5iarVqFK9zB/0', '2017-07-29 12:25:36', 'oi4Fwv5R3D6ARhZz2RyEL11yPqVk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a1253bbe5a364706aedd7da80ccc8013', null, null, '张津瑞', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKY0ibA4DWA9BTJWGNbOkPxMc1Xesz79Kyx9KVkJJCkWQhHytKvoNxR7ZYMJm10PEH3GZLsdKr3icjg/0', '2017-09-27 09:31:44', 'oi4Fwv4hB9V6X4dxwGalvB_CYZDo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a13e526e758541b0805690e2f4547dda', null, null, '风花雪月', null, 'http://wx.qlogo.cn/mmopen/vi_32/6ywqRamh9fW7KfBzeyhYu4odJA7zooVb0mmg5QDZacP9YJetf9lCANIZMuZD8xx7zpA759tLdSMicH29PNGWmkg/0', '2017-10-21 16:30:24', 'oi4FwvwSz9aVhZCJRfSfBOX1rVK0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a1d4b699269d45b8aa66d9687395a186', null, null, '哎呦咪', null, 'http://wx.qlogo.cn/mmopen/vi_32/IEiawcHX9Y3GiayTC8icCe07xS8hqmYabSRk6qvNT2KJFmAEvLy0NwutE4t0aWRrH9ZAvKAqgAM4EOUTYDFUodY5Q/0', '2017-10-18 19:35:15', 'oi4Fwv0RGa8fiX7FrO-fj-KbyOzo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a4f41d4295984d3fb7be751932949094', null, null, '邱诗伟', null, 'http://wx.qlogo.cn/mmopen/vi_32/XA9Dx0Gv5dSvMBMBR5Cz8nNcrlGzmJDahat8iaicCUNB1dC2GbZr5d05Ve5lv9anxJur4mK3FjDzg8jicuQIrr4Rg/0', '2017-11-28 18:16:55', 'oi4Fwv8YEw2UigdBzRydj3kH9aD0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a5b5be7da1ea4524a2ffed43115b9de4', null, null, '贲欢跃', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK4akMQia3icmkdp869MpQ7zb0k1pHk8T3Z1cic7XRcAPoJwSUUhMeIXyqLnib2rp8AwiaP2uGUIt78iaRw/0', '2017-09-24 15:55:09', 'oi4Fwv8VMIf6I0mEbpKkXW_j1Rqw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a6e4ecf98bf24d42a11c880e9af2df1e', null, null, 'out man', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKw8ictgYcqf6lZic4y6lM2bEysrM1iaDLpbhxMibC9icLGwYjuMrCwK70N58KeDNtibJEGUIjkHaA4Nuwg/0', '2017-11-29 11:51:34', 'oi4Fwv1rS0zTk8o1VJqnc6SBuJks', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a75aa574c08242cea1b0c58db51bad0f', null, null, '杨旭', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er0420894ZJYc2R4VHmLp762N0XdCYh7faOpdaKcV7YjA0xF1GL4Ccv4ks5agHIibat3TiaNsagwJMw/0', '2017-08-29 14:07:41', 'oi4Fwv2rHlhPKUjs7FjBM7pO8QIw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('a9cd8d12b4b84196a53b4950d21cf3c7', null, null, 'Ivan', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIpUUHWFlC6hquv2K2XhCxm3QdC9WhsRrP4Ooibf2jgEnNEQyXlcs6FTlXUibMEXWjV7u9T9ALfW2Lw/0', '2017-11-23 21:50:36', 'oi4Fwv-0S52JO0zD_8ugD9KSdhl4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ab3e9c85fc93412db3e402ace25d9735', null, null, 'DWalk', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eocObVibsibwdxMbfw8sjauYacztmT0R3WqRicvr7rAtA0ZQDnKjQunKT5KrhZmwXKictkicIRJjkEwhQw/0', '2017-09-22 16:09:56', 'oi4Fwv5xELtvqfsMAiKMiuOUoFAg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ab96a0f8f8484324b9943d74fcb9ea32', null, null, 'rdgztest_PHKBBT', null, '', '2017-11-12 13:58:05', 'oa-8a0UECGKcgMdv0yZS4WULsiOE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('abfc39b0556545c6b05b0fe5b270ae2b', null, null, 'ZhuHao', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKlicKgCNuhqMulMsatJarfFznCcyIQ5hjjLVEKYFBSicuXET6y5rueViaFrricq2WliadN2nTHTkGt9Cw/0', '2017-11-25 09:31:45', 'oi4Fwv9leMH9EZL9dz8CJqhfUyYo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('acf343229dfd41428279445fd6c734d2', null, null, '超', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9oIRvWZARRhuZJEW0IgUjpfOTQox8npfVOjMgibq7mdGq49CztARydMYRs0kYCWkZlSM9WjPeQLA/0', '2017-11-06 23:52:59', 'oi4FwvyMGnD4QlTjWounkRb0Q2Mw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('adb16849ad75469db0c557e4a3829630', null, null, '我就是事情', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN2GIicKEqrS1CEUGAOH3wibBunF4Tf1SGgT32KEeYq93ibUuUqNe0ehSRX4oibsREia0C3FmCysZ5vFCL/0', '2017-07-24 23:17:20', 'oi4Fwv1S0PyHEzZocm1u_Wpldnqo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('adee16b3f4724ae9bb963b7cd024fde1', null, null, '陈浩', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWg8O02y6iaticwCK8A7NaIia1cPmc9G8s8eDr9VrPUs2ibdqRmzzUgC3r8MMicyrAPqSZChB0xKx1p7K8/0', '2017-08-08 17:46:37', 'oi4Fwv936cozd6ue0UBR2ChJmzWs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('adfdb3a5f09040768a2f952437792fe1', null, null, '天天向上', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCniba9sgfkZULyWd60kJrGCrgiccto2Jl5VgKyic3mAcZnTictXuMPqwXz7NnVndLCQT6UVZsFuMPq9ic/0', '2017-07-29 11:58:03', 'oi4Fwv6Q1LXp4mYbaWEf0tp1mTDE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('af28e816d45c455780566e80394b0a61', null, null, '峰', null, 'http://wx.qlogo.cn/mmopen/vi_32/k5r6L01rTcPXLQxOtOaNWD4clBNQu4ibVPm0CYo6nMCHGatXib01yMObIoIJ7Fg4wrGf8qBJibsCd7cyOutLAjceA/0', '2017-09-25 21:31:34', 'oi4Fwv36Q_2Mdkj2MUva19INMmfk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('af84d8ed7d33482fbde06da1418fcfad', null, null, '禁止入内', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6ONe5ZmAMXutibb8ctqqQxa5DJIjPpcI1SfQmqC7hd23zLoVsiaJrmU9j2RMGCxuic3hsYVF0GOiaBtV5gbB9EwG9LnU/0', '2017-08-18 11:30:43', 'oi4Fwv18J0k1t1cHZPD-O27XKQYM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b0d8d29bb74a46deb667d09ec13f37d3', null, null, '。', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1XDI8UGfZ8dYdRzkRt4y1uxsh3Vmgiak83J9hUubWxDslvuCQSfyEOic4ibZk5FHMuCGptHzRT5MRtQ/0', '2017-08-03 08:36:42', 'oi4Fwv2yzsMWzrKoaV8hENokxf5o', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b13020a8f69b45a3b8010576edad7fb9', null, null, '傻凯          .', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKIBs2YhD1QD5FvXvkJYQyafpTXibxwUr7w3pLic3rYVG3oGN1fLeXodfcM6G6tJXMBVhINBPJIaDmg/0', '2017-09-27 09:31:41', 'oi4Fwv0NRDzYCUYrgDZYpJ-gLRzk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b151b4fb6e8f4788b0abe4c37fd00615', null, null, '洪英俊', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI4x5uDKCchibTNJAvCfFTWTl0VOHqI8No5fJeqVSTLIwK3bg3PxHTbWAJLL4UjX0tH7upS0tlkMsA/0', '2017-10-24 10:36:15', 'oi4Fwv0K-GXOUQMsAO6Zh-_ju0NI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b20cbcc997004934b18d30c93b8557a1', null, null, null, null, null, '2017-07-21 16:03:43', 'oi4Fwv2eULXkmueYRd0rigDu_L_k', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b44178b48b054a7290f570fa48c3af6a', null, null, 'Cain', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLxUF11Cewepial4MlTmg6ASG0EvvJWaJaVm9LmAiaDHGS35S91z5em9D27IzOVe2revMBh1vyzr6sA/0', '2017-11-07 22:18:30', 'oi4Fwv2sPPlKG23eWXUbifZhMOzE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b467b8981b9b44a79d57634b8c082857', null, null, '呼噜猫', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1gAEOev3YEiaevC3JarVeibnbickdjgEpEulh8r2CWbEclFTKk7aOicvy7N621c87E7qHibD0o8NI2icog/0', '2017-06-04 16:36:16', 'oi4FwvwUsQtWonbdRbt_9XZ-It_s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b4c3e8730dfa46f88780fe9aaff244f4', null, null, 'HuaJ', null, 'http://wx.qlogo.cn/mmopen/Q3auHgzwzM4YFDeL8ysQtzV4hf8fueNnmz0v9nwLS0PoLbdrFRdmVuRuqRdxrcXHMSs7CvfLk5cAic4PibTzIJRQ/0', '2017-08-18 14:49:41', 'oi4FwvzNHGwlu2-rOEG4hDa2z2qE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b5676bbfbd05452583e61d2e2bcf224f', null, null, '四眼摸摸活狗', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epzyvicVqHsRU97eCaargibN6yYjs1EuSC6Vrdy0vcDMuBONmShUgdhcIQkkGbDoX9Rxj4fyGjyo51w/0', '2017-10-12 16:46:07', 'oi4Fwv2xAuvKn1x7gHn1k70YxQfk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b61cb2c28b99409baa0cd82f310d166f', null, null, '桩白墨 plough', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoLpP7Ss341J0ooa0Y8CIVZrv6d2GZEBiaA6STtUwuyiciadTMpVJX7JTVl9f1dZeia0yKhc7zmymRW2Q/0', '2017-09-14 00:09:52', 'oi4Fwv96QijHOvAB1Eh0PVyEFYws', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b6ed9ed2b7894a958c3f210e08587108', null, null, '李大勇', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCqAhYlWKibjJV5oVnscWgKibxrDKxkN0Ia0otvgvOLy8sYYlpdWyvNCB8a3qibK711HzJK8TpS4AlWA/0', '2017-06-02 19:47:12', 'oi4Fwv0LlAw9s-a3__-6LV2pfE7U', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b72459c650514af49e153696d66f55a8', null, null, 'Daniel', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epc3c8hB9Lg0IVMNzGar7Zf8B1T4wwYKtueMtMUkaWeeB9JWUGCnpiaMya6khatibaFpyq0xc5ZibRMQ/0', '2017-09-17 17:26:43', 'oi4Fwv_ewWtoTbt50mOU-BCJJ7z0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b783427faa7f4177914ae604f3ea9689', null, null, 'Jason', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLAvtsZsukLwntfOCDicXkCXXiaWoJx7sUSqTkvj7vJxWYr1QRxu0pr0O6FRA78MicuKkxyicO9jAtvTQ/0', '2017-09-09 15:11:25', 'oi4Fwv_Rfrw_D4xk0uX_hcD3GZUQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b942f4b6350a4a32bd924e36d93c7d16', null, null, '關於二道橋', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqE4WniaVOWVGe5xSOPz4k3uz183F0ZcZmHlKDXJyoGBleX3KDZgiaErXNpia5pcvMqL9icJjtibICCOrA/0', '2017-11-03 14:27:49', 'oi4Fwvwqx5zM5s5_OGPveGAHZSAc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b994c9ccb9294659956e11dc08685827', null, null, 'Hugo', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep2ON2UrahOibOpH0HXnMpDp4qwibIQ6mRmI9Y18ay0ohOB5dlqNjBye4WQ5ibc6YV7Rk2ibH9VGCPOHw/0', '2017-11-18 23:35:24', 'oi4Fwvx3raOiVx9qs_fVtYqcM8yI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('b9e6b9b9d9f249f3846d25941a75b055', null, null, '杨凯', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMUesHwumqYxKENCoKQMPKGWTGibXO6N9LhbaudvN8rKk9LhpQaJiazgF6ic00x9ibKnqv3tib2E1TQBg/0', '2017-11-11 23:06:46', 'oi4Fwv5bCQBxdRtSu--QnwN6TDaU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ba8394c1b59b47248ef1898e4f530efa', null, null, '勇敢的心', null, 'http://wx.qlogo.cn/mmopen/vi_32/39icCtfMV3wptLoaSQjNs7dwziaxiaObJmc6C0fcNqqsEUjyS7nt0wbuVKicfEibibp2GfXA91bC5HMVbia7GYIe6cVfA/0', '2017-09-01 10:37:32', 'oi4FwvzWxUIQay7fXw3DIP17s38U', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('baf7dcd3cde044e7b48f4aa153a229c6', null, null, '熊猫潘德', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMAydhdvnqZ3RHFHrHJFbKDeQsvLerZ1TcyxGfXR1tygI3VT8wrZ905xurryOlRvbJ6EVo4G7IB4A/0', '2017-05-27 14:14:37', 'oi4Fwvx0xtREL2A34IhUAXl2a0mE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('bb4f4bc2ad904316b63888588d456c22', null, null, '朱.com', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLAb5mLgVxMSDjMwwdNfq9Y3deok9AicJFDPyYic6iaEmyz3b4rHHXtLG0Kr7fsGTnZLXkAkLa2EHtpw/0', '2017-11-01 17:07:35', 'oi4FwvzLX5mK8Cj3ZVyAQGn26Ogk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('bcd97990a90946118b33b64f2f95ea83', null, null, '王老师学习培优中心', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLVkCdrMz5YXDV2McdHLoFSjJZMQzkv27EDVJH9sIeXvPqoJZI2gneul079V2pVrSGtarR1CniaibmA/0', '2017-12-04 13:38:29', 'oi4Fwv-rBnA5zIqKHjVJ8ZYMIXQQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('bd684fc683b342c7ac67ac46b6625048', null, null, '萌萌君', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOJanziaCIePWYQ9a3LvHUF4jaj2A6ibGP5VCJAgDHMZlzwDr0QW35LwqFicZ0AXFOib3yRc4jwGAW0Q/0', '2017-09-09 08:15:57', 'oi4Fwv8IaJVXCy7Mgpw7Yi6tv4S0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('be58d7f92b5e45958442d2da69f0d22d', null, null, 'ZhengYC', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eprb59Bg9HBTVRdKIjGoZIMgnXRnjAMchTFEPkeSVv1gh5T4VJzkzIAUMcojCtIxNBLefwkUXk8pA/0', '2017-10-23 10:47:49', 'oi4Fwv4SRlHLmmKwRTDaa2qHLids', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('bed5bb5f6ea0441d826ff10c8ff6159b', null, null, '一生一世一双人', null, 'http://wx.qlogo.cn/mmopen/vi_32/ibufxEb8cKcibksDykz5RMYQ741VWUw7mLUv7zICzvYJOVdTArfJXmsW4UFgHEe0k3BJ81IPeIOJxBbcg56WEgGA/0', '2017-09-22 20:42:43', 'oi4Fwv54kVBSR5Byq5RL1lUHhHpw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('bfdd0da0d44c48a19960d90dc85b1f39', null, null, '领衔主演', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMYOudnjuoNIvD06ib7e69Cohyd4xicXk3Y5ubqZFa81HB1INMq3bml6VyeQcUddZwDBTGwdiacLKia7Rp8HRPkkq9l/0', '2017-08-06 06:16:01', 'oi4Fwv5oMovIekHgUZ_eX6WhQs9A', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c04f359b63ea4ef4acfcaeb3feadd72d', null, null, 'lee', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLw9fVyja3eQFibiaUySpqPJ2xviavboiaO1W9EFduCQPDAGRm7OO3Z2rLPVXoD3T9n6TyNjibhLqbe6KA/0', '2017-10-21 20:15:14', 'oi4Fwv72YsGl5koIciFnHC4AeOEo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c274ab25775a496b993b4956c0a864ff', null, null, '      ', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAo1pW5GUWqicTubOKFZlUguIjaN1LicQicYyQice7LrXSAZeJicO2dxkdrCnJBCwx0OOJckgpL40L3rFzOicePW16mmD/0', '2017-08-01 15:52:07', 'oi4Fwv1y_TpDa_ORoX-HQJ3dHIBg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c285ef8e57474d30a057d069fe7d9d47', null, null, '王国帆『  运城  』', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWvea8jmxMlpLF6cMicj4NSRC9BsAw5L2hWWPL6qk7qAwAYibryPmggYUk3f1EnnagYzbxlFmx30l9j/0', '2017-07-28 01:01:21', 'oi4Fwv7ebirDHlwQyi_ti-91WoKw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c5258b8ea75149d8ab877c5c7e6c5068', null, null, 'rdgztest_THKOWG', null, '', '2017-11-11 22:01:35', 'oa-8a0VrMpGZq3kCgAFdZ4OvyqHo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c55b47d5a6b246eabc95944753c27f74', null, null, 'Gear', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epXUe7Aj6M6ADYfaGJA8AiaWfEwHSeqo1pqbPGbH1uwg5seug04vowEYLZbMjVAvVjosia95f18R0AA/0', '2017-11-01 16:03:32', 'oi4FwvwLeSO8S7HGt--bxfm4ju8I', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c5de0f47ccab4f7da32b9c173f62edfc', null, null, '-秦丽娟', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKd3713qX7Ge7psaDHvkJ6Q1uugXTwQzEhcdTj2OVyxgXLJpLzquqdgnNibsh5vIbCTfEw37JGFXiaA/0', '2017-11-17 14:54:26', 'oi4Fwvzor1ZnVHR9Od9CCthWbAXM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c7028c0ea6354e1fa7db1e0224ffbde7', null, null, '贱，也是一种态度', null, 'http://wx.qlogo.cn/mmopen/vi_32/wz9EicibF68MtrRHmEMBpzgy7QMOsibv1CFVjIH5elXicDI4vcmDpdh9ND7gnGDzBGeH2ic1DvFx8Oibtgdp13NzdJRQ/0', '2017-09-23 20:26:46', 'oi4Fwv4REVvChbepBMiHakQkVOk0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c84882b543bc4e3d8b483328bda4e87e', null, null, '天道酬勤', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaEJtr0icrcEkBclpw8eTzc4QCdoXKrbqQfTBD2OhQD8wROick8y4TxIEnWne9gNGJXWfeYRFaRrU0zzPCsIIFXVcRYLQPHGoLWvQM/0', '2017-08-14 09:18:47', 'oi4Fwv6kxYlhqSR5y5ym_Uv_UXKs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('c897e44bd49c4fb39f29a45cc41df164', null, null, '小腊肉', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep768XBicUVRy83g4HnN5z4Ctkx2IQibgPh7AsqThHNkKqROgLna94YDV7kX398tIjmwWUy3T5zKPnA/0', '2017-11-03 09:15:23', 'oi4Fwv3tr2kFUQC99B6vwfGSdtxg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cae2178052264db1a6f475ac89347a93', null, null, '十三', null, 'http://wx.qlogo.cn/mmopen/vi_32/Y5U2ADUvruXqicB4qf5OuW6Licc9FJNiac4kibZOktHXE1D32j9GfNS9lIgsdm570kMz7FhW2GK4N4TAiazFKr8Mc9g/0', '2017-10-10 17:25:27', 'oi4Fwv19YErIADaK__khdpTtbMxQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cb0e7df5b5a44260a0547a5df7d6bb61', null, null, '光辉岁月', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6ONJpnTgPEyVsjyk1Eia1aicEfQooz129GUB6AVm2RGqhyhXry7tH2FqqJ22Q1o8eQu9ibmqic9o1T1VVw/0', '2017-07-29 17:25:43', 'oi4Fwv1ltGcTB-H3yZ89aiVyxNIQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cc067310272c450682f55d9d751f5cdf', null, null, '天涯比邻', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPHQ0mFEJ8nRiaL44sHcEicbQbFXsxbSMfoOnh1NVRSicQFVasq4icCx9QzFFHglsluFTcCOY2gWib7w/0', '2017-11-17 14:55:46', 'oi4Fwvx6hpjQu2c9GQYphWPxZADM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cc2ca9c6162d40dd84024345cffa906b', null, null, '德容天下', null, 'http://wx.qlogo.cn/mmopen/vi_32/CdDvSk7siahIauDYuvAEVqefdmS8WDcCH7L1yvicC8zyd7VX4HujQ21KY75hVvSzlML5VEsWCUZDpylJsBqqmJ5g/0', '2017-10-19 12:24:12', 'oi4Fwv-Wa4-Qx8IO7STUasF1pJT4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cda5929620c74d1b8b26f18f9063d122', null, null, '_', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJPgYYw1f5jJqwrrZd6oy1tC74NjmRjRU2bJ1LoywaQ6hHaegGdib7qBhrABt8O0IiaBLbc4D2vRWJQ/0', '2017-09-23 17:54:51', 'oi4Fwv1A1wJLdQ3i8-VKAspL3J5Q', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ceab66c834fe4091a87aeadc1822be32', null, null, '硒米哥', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OOjDIgn4aDjEGN3aK8ibgLDibqMwsRxS3OWurv5cnulM5lniavGXd7tq2J0gX8icdqu6q8qiadbicqQM31g/0', '2017-08-18 12:42:41', 'oi4Fwv2eugxiiMnZPj0-rAXyFhlY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('cf3fd948e1254644b384cf6e503e79ac', null, null, '贵哥', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIogjMh1icQLvZQP4Yvpdk2roMowKMSXicQmdicje5a0Licooic6hPBdHh45D45OmEP1jN7286xtvAruGw/0', '2017-11-21 20:54:53', 'oi4Fwvz69Lp_yTKRKLBtowNPGPJI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d0717fa0087c4f97a5592e02a238e0b4', null, null, '恒发', null, 'http://wx.qlogo.cn/mmopen/vi_32/B5iaSvk1Je4PYxBKWhRuPI5iawMLiaC3ymRELS7p9P4g1nhHypqXicbVKtOdIbLUdfzZSXicwB6cv3gIJTDv5icaeW3Q/0', '2017-09-18 16:16:43', 'oi4Fwv8cwvf4wU2PW8ANIz2UHNmo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d0ff81700959420a85cf30234f4f44bb', null, null, '孙铸筹', null, 'http://wx.qlogo.cn/mmopen/vi_32/gtudnKSrCyx8RCnEpOqxFeCYvqlAhodbtMrmD2UvChDlxExwiceZjVDjaDDRUr6vjnE4PeO7XWFQBjRt7lEzGSw/0', '2017-11-01 14:25:13', 'oi4Fwv2eoQQRxU0_llLVxAFlAmSc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d1f2d40fb2bd4b36b5a5c607039835fb', null, null, 'Mr.J', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCksg2JUo3NkTkujicFKvlduSMelK2nNPjiax0xTwrQe6Ro2fwKYhaHeNibqUE4CviaI3Hic04hf0xj0iaI/0', '2017-08-26 22:41:46', 'oi4Fwv-NXRnsWmtvQVvmiAQAHUBY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d207d03c832748e1b13fe98a40a7f7e9', null, null, '粥了个粥', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaELpd5SNbDTTwkWaiaYLUc1nN8aRW2TW8ia7RUnmAMtIic0QribDr2VF0oXKZpGMOrKpYofEI3FZ0l1wPw/0', '2017-08-27 22:23:28', 'oi4Fwv0yO4ay-bv3O3E1Ak6wCe9g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d29b4ee5b9224b44bc9ec4dd54b7141a', null, null, 'Steven', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIxHTSJyX12eAqoYBLWqpwppZ7W92G9SW3mqSLXJYTtiau9WI50ibE28sLGXbGYQSnRxufqL8OeLnzA/0', '2017-09-05 01:21:40', 'oi4Fwv2k_1ihLaC8eppLOJWdy5i4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d2ec5978ed154401864ec2fa14589676', null, null, '奋斗中的战斗机', null, 'http://wx.qlogo.cn/mmopen/vi_32/BtgsMc6CpC1SzPaS2OFIsF885By5qhV7gNOruibehOoSPUnDG6Fs2iacfC5wXgp65icaTCkeJhmYUFm4iaBQap5qBw/0', '2017-11-17 11:29:55', 'oi4Fwv8kHkAfWp_0yDzY1_HA5os0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d403256957dd4916b1c58d46bb7e9f90', null, null, '麦潮生', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmABPYYbYouRwSqDia41X8WWGt7Eazyra15DozJ2N2JxWMaf1ALZRTiaiaL4dhiaoInpEEFpAl579bHcibd6g1oqjTNeNia/0', '2017-08-05 22:21:48', 'oi4Fwv84mZ-g6yOfUT5kVKUxagsI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d47327f7aa3941d381ec8a1e100d95f4', null, null, '世仑', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlJAgxLa4we1dbTIsHOW6icqrJBWy1v9PHHjlFQwI84iclmibV5ibLoia8HkSx42YfNsRxOPHUU33NJww/0', '2017-10-20 11:50:47', 'oi4Fwv_blyXz0P2CiXzsvVcULM3U', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d4ba51a07304451b82a41675fd0d69d5', null, null, '那年花落', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMYOudnjuoNIrPcBiaQhL9HwL0KBY9NkaIuETzXmGr4jFMtnUQ1ghEB0128vKou6BBYbYYWxbtYFwPibp67GoR9oO/0', '2017-08-07 09:43:44', 'oi4Fwv5OuCYhcYoY4xvlu492V3hE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d4c4c9c6fbfa4b12b1e02312343e8e90', null, null, 'yang', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ernVqbmtlWsbEGMwTe9xdoIs5fGgNxauaLicc1e77PK4KxJvFhTejrhgruib9PBbVrMc5tmDjpVMCZA/0', '2017-11-24 11:34:38', 'oi4Fwv1sftQawE8L6eSjImKERL9s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d505a4a2ce9847b9909dae0903d7fca1', null, null, '馮美娟^_^皮尔玛跨境购', null, 'http://wx.qlogo.cn/mmopen/vi_32/9AKDbLxAOuTTpmA0ErLXAQysvtDcxJ336HVJ7P7CiaFxLQHxxVcZLf2FrAT0dU71JvuMicz2hoCVYK23866WkQPg/0', '2017-10-17 13:02:05', 'oi4Fwv5T7KxA0Ggy1U-OuVgCwZQE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d561106cf91940899f3cf8e9e3bad284', null, null, '大圣', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIV32WkuYzqGWwfOKbIIs7HKRK3NHM2yRPkHR79oCEIsDQ6utFCQibQOtlrS6GhzqyDSbndNEneMUA/0', '2017-10-20 13:27:04', 'oi4FwvxVs5ovuP231nBR0kICAHJM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d6d4bf300a1548cda3449a5a975d33bf', null, null, '_里岸', null, 'http://wx.qlogo.cn/mmopen/dXZZiantSmAAJqrUrSWUCWmfmEmBPWtzQ7hX3NtOR7zBm9QpASQ3RiarAxKUJDHj9pqic6H3mt3q4lO3xLYwwVSGdTqPiabMeXQ7/0', '2017-08-29 14:42:53', 'oi4Fwvy6bwtNDCuCJOk4c0XRAbSo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d8ab5357b7904a5eb84487e8d06e2852', null, null, 'jj', null, 'http://wx.qlogo.cn/mmopen/vi_32/S9T3cEcOSWotdpNTODqL7q1n4Lfp175HNpK2uCmibr1Ht5sw4ibCMXFeHEVXtJvuppJkML5sRYLzD4OABrzfdGJQ/0', '2017-09-23 10:55:51', 'oi4Fwv5x5Itoga4lqWIuSyFSh-PU', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d8d4cfd55fe0484fb25bb9769126cd53', null, null, '张永强', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI4B7zFhhZe05OSOVtsbTEtBZxDS5pwWOzerhyaCR0SglbIufnbkR7puXdKSGCAzr6BodhGuKK8rQ/0', '2017-11-27 15:03:25', 'oi4Fwv2hBu3JbxdlZS3s1IYjmoNQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d94cb9817a804f1c909c0f5d28ee0614', null, null, '冰心无痕', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIia6JywZv309vKcqamcKibibTdOoicTMgZ1yoLNq0IEViajnDmQwR4sFloiaIqpCg5rM3xvyk2zBpcXibeA/0', '2017-09-25 18:25:23', 'oi4FwvxOGfoGV8Mr3RXo9eu3rVBc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('d98fa1f741814d52930f0016905e81c6', null, null, 'lucky', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJohBXj0kWSSdrgFojXXLppeIvBndT6dPv5eUgRyUIXjOLGyHunEVmG22kGOcGGe0QTM5iccicJqkjw/0', '2017-11-30 23:45:47', 'oi4Fwv-0jfklnWAPaMh9OJUTPJ6g', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('da0801d4ca7442b0bbe21115ea210243', null, null, '简翔', null, 'http://wx.qlogo.cn/mmhead/P6kBKRTw8ay6z9c8TlSTrZ7d28bABEm2QVnTaqPm6cQ/0', '2017-10-30 15:41:18', 'oi4FwvxhC_FSlTT1XQY79riDGp9s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('da95a964c8dd44a8ac8ccccd03190de2', null, null, '渲诺', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2pe3Iy39WsCrE65P2tvWcZNzHCOibYRiasmq9oThibZlSl04N0M3HVyrHiasmwbdvU4t131yZr11YZ9SZEhhUuMic2G/0', '2017-08-09 09:51:21', 'oi4Fwv26UL4nzswqdtJrn0nD69BM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('dafeb3219c2246d1a422e46ee017f42c', null, null, '汪景林', null, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjsXq0kW8K268NKdNcDdV5Lrl6UtaBQNSmq3mNoDUGbTibMBWt4B656Qubj1FnjuJANCIBzS2RhiaA/0', '2017-12-03 19:02:57', 'oa-8a0UmKAiObyJkYYlHPGSD0TyE', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('db9450f0e5eb482badc31721fcbdbf61', null, null, 'wum', null, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIcHOOqDpy7gpa3MicHmHDk8G43mLJoDlT67Ex9GRqwKpibF3YHModh9OiakmR5ZOorCvS4kHyrl94Jg/0', '2017-11-12 14:07:53', 'oa-8a0cdWhvD_SFJLp16EM75hzHs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('dbdd746b628f4c6190031c8dd77b2420', null, null, '赵志根', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eph0dEuZ3EJtkQsUibicfrhEJhILibx4q0fr1iaMeVqQrKMqq5vkegdIKpdKTXX0iaFM1UHYTUI3Ok7agA/0', '2017-10-15 00:33:16', 'oi4FwvwNTyGQ1zGVDeuCjPv3PRmo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('dd5d8da9a81e429ca5fabba89dad81fd', null, null, null, null, null, '2017-08-11 15:56:45', 'oi4Fwv_cqbswtSCYPlqGVU1NeUvg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('dd9d70e2643544e2bd8a9b98d85692a6', null, null, '小天', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK2Az5uTh9ZGYwqExWKiaYrzQnFrzG2BwnqUclwibkbHPTr3OJ6iaobIV7fIbib08Zic5Bc3XcNjlzj8Sw/0', '2017-09-29 12:11:11', 'oi4FwvzRT3uAAYA5KUm1OvU2_aF0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e0046026b4fc49ab84603e2206a00882', null, null, '无限数字印刷一应云斌', null, 'http://wx.qlogo.cn/mmopen/vi_32/zRswI9sicmTyaBVoofEIgHKvouCBlSY0ONHicjQGc9JE185njNdTY1EDepZRXBVnYsu4CaKjY1k6bbwYvzfnSeSw/0', '2017-09-11 20:49:08', 'oi4Fwv63wTu8trO-sSx8NE__7MJo', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e15032afad5643678a844ce7fda424a1', null, null, '龙归大海', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erwv9tGxiaVTZIZczK5CTK4RaoSMQ1DLKibO87nGr4RfvLR4coAwkF8a1K8M5yRcrhdjtLkpD8ABVYQ/0', '2017-09-04 08:38:26', 'oi4Fwv2kzWZAKOwyqh-iC1ZarIJg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e1ac194c44b5435096447671e70459e9', null, null, '经历', null, 'http://wx.qlogo.cn/mmhead/Mjzdia7evAzxkczHzPDpqCOLjiar9HQU3PSwBnm19LibUIXr067M6h9ng/0', '2017-10-30 13:50:31', 'oi4Fwv7iTUA8BCwAzJSCIbimqAxs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e263453cf63f41a4b7dc8e305c76f793', null, null, '刘牧', null, 'http://wx.qlogo.cn/mmhead/qd3u5IHSYTibfl1PY2heaia385TNEU1QW4L6kQZgvnbs5j5RgO4S8Ulw/0', '2017-10-31 22:04:38', 'oi4Fwv_ueNyqv4Iin1kow3EjEP-s', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e2cadd66cb6c4da89679bf6553d8b25e', null, null, '航', null, 'http://wx.qlogo.cn/mmopen/vi_32/HZxD2T7sbTw3WGKxqF44eULVBhmRDfDs4WMWgT0p5VrSwiahGZkD1AcOFGWc7GH0pYN7ibZn02zfQlz83aibmWJBg/0', '2017-09-21 11:41:07', 'oi4Fwv6ym0P2hkH4Jk0yWE-I3Ja0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e49c02f15d4b4b9980e65a9fafd5a5e9', null, null, '平常心cz', null, 'http://wx.qlogo.cn/mmopen/PiajxSqBRaEIXEvCKhmtmRAY4ZtBLgAxsTOMwkoq9Fe1Vt7iaEbJfRBfZUms331P0nSUQ7PtQmX0cT8COaWU2xd5nB420E5BEWYrsb9UXXqao/0', '2017-07-30 15:15:00', 'oi4Fwv7IX6w1ujtyMMqMDQbp7oE4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e60c3b041ecf43a691fc7639f9817898', null, null, 'wum', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN4HS7c6ueZ0ZzUl3uzzQ9HAeibxmKSTiczKreh5SNPjpEMfMOSVbeXm61V0LzTf9SudnDI2pyGuMNd/0', '2017-08-16 22:57:29', 'oi4Fwv37Gq9ExoryAfguJptKoqOI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e62f16e803ad47678eb21e5491f2f97f', null, null, '译宝-肖文彬13268007409', null, 'http://wx.qlogo.cn/mmhead/GqIlejFTbNgltJd1uR3zZoJPoIf4R98R8CzVKsrMF6B7slhy6vv2rA/0', '2017-10-30 17:38:09', 'oi4Fwv2zjh7SE7tzlxn_YP7JRSx4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('e86a3792b18c40c38adaf626c3319dce', null, null, '洪达建材（洪嘉雄15880507999）', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epzpW4n9XIbBqS5PMhfxjhNc9Hw5ics0zISeMj8dZqd1sFdERXcv8WL7SHdUJKaRSUufuMnncpCxZA/0', '2017-10-19 23:03:37', 'oi4Fwv6znVU0xCcRsq1fJgyb4_J0', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ea09cb6a9cde4e849369ea6d42af70ef', null, null, 'Cloud.Z', null, 'http://wx.qlogo.cn/mmhead/FGoWuePK1SONZcpGZfS0vSpzvdIzZDibOfPzzJQnibyzg/0', '2017-10-26 10:33:17', 'oi4Fwv1UDSJaOTYkZ86b0cDeOtgg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ea1a5c02770847b195774ad30fb1dda7', null, null, '不眠', null, 'http://wx.qlogo.cn/mmopen/Q3auHgzwzM4Z4URLHp0QdareQGia559M5bGoy2GmbGlLd5DmBvE94zeU5nkpBCtf68v3NdP0cVH9Whmq3AemeWXq10u5eBAKwuuCucPBXcibo/0', '2017-08-18 10:36:39', 'oi4Fwv93A6FAbcInS3qOxQHRcuss', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ea8d161c5d5849528c5004b9d41f2bfc', null, null, '百花丛中过', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIbyCnnVkLhOnYCT3arVduKXWXgyFfSN602ibJjUSfoLEQfPsh7nQLQoGlcTIBo5nQyR1OAyfl0wxA/0', '2017-09-01 11:07:50', 'oi4Fwv2Bpel6FBjKT8TYiDfnzpsQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('eb06b457692748d289d823b293cdb708', null, null, '吕昆', null, 'http://wx.qlogo.cn/mmopen/vi_32/jxevVWOU9PeZgK9Zvqx2xrCBfS1NuQ6XWFCRAKsSk3BLs1l16LoenpicU9UfIrqoDeugaOoE4X1AiaxkTTGbQsqw/0', '2017-09-06 15:29:47', 'oi4Fwvx7tqzOL7soSD_JKoc6-1PA', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('eba85d1d15e847a9b7d494b843107de4', null, null, '纸花辞树', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6OMYOudnjuoNIpGnmvnHich9icSrQUNN1vmoPh2zuuTWUmPOnASibPmfgiaZeDxMI4miaW7Gh3WmCfKe392OLrib9bUo0c/0', '2017-08-21 15:34:56', 'oi4Fwv7n_mRRnJHgRssNZ5eot3M4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('edc39c3e6ca6481c8aee25a6d3d89036', null, null, 'A00000AA双赢', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI34ZlT6HSOtDOQge72334ftMh8UyRk8uckp9QYBU3uGXcTs1iamIelkvuib7NVkeSuFyYrjMiaKTo4w/0', '2017-12-01 20:34:39', 'oi4Fwv7cBOSl8Xf99y3S57wgYgjk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ee1fb4ee6b9545beafc8f3f61b4acc61', null, null, '小峰', null, 'http://wx.qlogo.cn/mmopen/vi_32/6ejYgEC8IZIkoVjajHVmHnoGScErmEl0DXtsaoia25MWVBibYno2WsrR32C0zmWsCt6iasFzibOQgibcLic836EQGRKw/0', '2017-09-01 11:20:28', 'oi4FwvyT59UXCvaLeeViMvIIwaI8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('eeb69ea5788a465b8afc908e3ebe4267', null, null, '武汉！爷是干什么的？', null, 'http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajNxeYpGQqaXUxZP74ztDsrksJH4HuibYTPvXctq5LrpH0GEUuiaUYXsGI5ug4PTDJtl1babmCKhicLHh/0', '2017-08-28 21:17:48', 'oi4Fwv6hlJihQOrUn25kSge75SIQ', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f0a80301386c4733825204f33f8a6bc9', null, null, '墨鱼', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJiaZlM5Jfa8nbbnWpX5jWyH8JhNYo7Rs3vpYvZpkiaBhBdDrxuicE0eaqnrV6a3h8lSWRNLibOqFQL3g/0', '2017-11-16 08:56:18', 'oi4Fwv3ItoyS4aCMtMHe0AVedISY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f214ae307c784e2584fbf10d9b62d29a', null, null, '陈啸', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjGFHmunbyziaweI0ClApC9ib9qZKRczMV0XygcS63lA0XjbiaYT2hCT5MwwQYfwDz1LaEhoiaZXHbLg/0', '2017-11-09 15:44:33', 'oi4Fwv-XGNxDAKvB7VGNZAzkyjzk', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f289d9c9b1cb49d89497c4d79ebd3b14', null, null, '解少轩', null, 'http://wx.qlogo.cn/mmopen/vi_32/o1UTXECe5TPGdGeVYhLYc3BhnG223ku23e9y9GyH9clN9iaibdiaaaorvcMmdJicaXibYJy0WK8kkTj1FKNkIHRHdKA/0', '2017-09-22 01:24:06', 'oi4Fwv18DR0TiIFBZ4zq_Sph0rog', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f31eab0144f24784b3dfb64e924ddc1c', null, null, '千年骚客', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erAuyLVZlO456l1OkibteM3brUbIAGfWjjZ7uUIneIna58UoL52IVrvvlkkoiacGl25dz1axfKibRMWw/0', '2017-09-26 19:07:23', 'oi4Fwv0oNy0lXZpzoSkDbXHwgEj8', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f434ed76968745e8872a009eb95bf7b7', null, null, '忆呃呃呃', null, 'http://wx.qlogo.cn/mmopen/7U1jvNOU4e2ciaq8nJILTSibo3SULXRygXaCKewXphiaI3RianRUx3a4pW337U1sLWsRNdOicn2sUHQeu8bLoZcuMjCRoTP992rEW/0', '2017-06-07 15:57:07', 'oi4Fwv_4OAgEM9Hr0yHuu6oxoAPM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f518ad211e994cb98b49d24f3efc2e9c', null, null, null, null, null, '2017-07-21 17:45:11', 'oi4Fwv5tCr3KkwDHwGymik723rjY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f77e1ddb656a4f938e62dce1d9b4efcc', null, null, '帅兵', null, 'http://wx.qlogo.cn/mmopen/vi_32/u4OemUpkKSvaGrtiac5F5YZ1pKKmcwKzx6omiaxpFSgNNme4DA1CFjxKAox4WSic0Y6KnPJhKKWx0HicosPNOszWUA/0', '2017-11-04 11:34:02', 'oi4Fwv8_QiZI1tH4jHsWITsMKCm4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f88083377f734a6f870532a7b7f2ecfd', null, null, '梵夫子', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epzyvicVqHsRU25JEtO49ib5tZM27ibibEc5zHP4an9fotghs5aJcAP2jtdEYxYzmXAb3SgmmHvefEJ4Q/0', '2017-09-14 03:19:44', 'oi4Fwv11ZDXi0-eY1ejJZrwyL3BM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('f8a64fa326af470ead5188960da81b27', null, null, '王龙', null, 'http://wx.qlogo.cn/mmopen/vi_32/fjScUMh41Q8o5W1z3ZHHuq1KJTBq9bRicmau2FEKMum9K9HHUZzGsJ6f0ZXHJpg9KRQYODSyWJ5TZYlyz9gZOfQ/0', '2017-10-20 15:24:56', 'oi4Fwv0PRzTrxICV1uuJlM9n6DDY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fa2c5b648c9946e59813a567d24dd1dc', null, null, '智明', null, 'http://wx.qlogo.cn/mmopen/vi_32/B9l77j6nrNp2pp6kpJHiaS5LrAJLCewle4QJNUgLZbCViaUICsvfbq2XCdLEUq7ryPDIO0niaVk1FjeOJctEB9Tgg/0', '2017-09-11 14:39:42', 'oi4Fwv6nj-pSKzEpfPVtV1meeKLs', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('faf1aec992474e9ca667a959e0ce83ef', null, null, '一舟', null, 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI9Nicr0ahll9Cubv9iaBU30WEVx8LrwFHZInfkbRNbr3GhJnnCt5RJn96WTiajHp5BlGpj08qotNhfg/0', '2017-09-05 22:33:12', 'oi4FwvzDU7OS5Blej29o25cl8g5A', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fb3ae8a2cd39463d9fd6d8e6494e42c4', null, null, 'mojo混混', null, 'http://wx.qlogo.cn/mmopen/vi_32/KJUOWgZ6tc7vzGgg53FT2pZicK0zUD9oWes5bibaG5TdpgsglCHk0pMNEeje0CzhicfzxUu2kvT42lByfIPUWEib1g/0', '2017-11-03 16:20:49', 'oi4Fwv4KPB1M-uN5rcJB0QPXm918', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fc2d41d465f440ec82ffafd9e271bf28', null, null, 'william', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ereIjPs0RJom0HP2r50OexYKFzSicbg6bo7UicEceoicvJx6OjNKVhVx15Ajic3TRDLeBSeciaia5slcGJw/0', '2017-11-24 14:18:07', 'oi4Fwvz0GPxcBy-_Utjs1zorCTCg', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fd82b52f49cd4432adc8c1062cef2bf7', null, null, '黄磊', null, 'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqRw5qR4vFhlnNmxM0FokjkldBaUQANXSHEm8rYAJP8hHOIIZGWS6Ta7Xwf0lCWHTPYupKlAXehzg/0', '2017-08-29 17:25:40', 'oi4Fwv8VSkS_vgo6aB_628rOn6Mc', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fe5a50cd75dc4340a0837f1b6b88a073', null, null, '阿德', null, 'http://wx.qlogo.cn/mmopen/wXJ5kSJT6ON8icibDCk7Y1Z0KtD9Cl2zYmZ7aWBhsHn0RfNMynmVeaFAADt3yEa7iaqUoicqqYFf8rg2UsFeEobqlMUVTpo2Kjqn/0', '2017-06-04 15:19:28', 'oi4Fwv8fJX79eTKInQviBZH4k5SY', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fec86c95fc2648fa8de30a698303db8b', null, null, 'Pe', null, 'http://wx.qlogo.cn/mmopen/vi_32/fxR3picsLF295ib5LzEFS00ql7bicg2qXBtNnu5WNYqicIDXA6r1libc5leicMSwQ6MftBZXLBXsVgTiaDOQWa8jYWkeA/0', '2017-11-01 19:21:31', 'oi4Fwv9DV0FjDNZMkAbx6YHMlhDI', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fedfcc07c35a479eaa187ab9590c47f7', null, null, 'smallblack', null, 'http://wx.qlogo.cn/mmopen/vi_32/J3Sd30Y0uPby62bHObicl2Gp3fCGdorUc9C1ph5tBD5NPGcND74XETl8SBYFibicJGpic23vTuqlibT8ZKRZTVqpafg/0', '2017-09-06 00:04:13', 'oi4Fwv0Sjxvusg0hFKp4sYnd9OoM', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ff031260b2c0490eaf751126659000f4', null, null, null, null, null, '2017-08-14 19:09:32', 'oi4FwvxfQbFnomoIZup9e4zqIuqw', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('ff77c21ebdb642efb581efc28078e345', null, null, '只求一份安定', null, 'http://wx.qlogo.cn/mmopen/vi_32/WXTcCMevfMZ2KNDZxBCDfcN3Kc3N9EGADxYvD0ZFsKezm1VbgAruHeS3Wg1ZDJHv2cyXaXiaDV6dQAwRFt2nMAg/0', '2017-09-22 09:46:59', 'oi4Fwv8KM1sKp2QrRkKGcKbgz1K4', null, null, null, null, null);
INSERT INTO `shop_user` VALUES ('fff46e48c6224b70bce05da586e832ae', null, null, '龙', null, 'http://wx.qlogo.cn/mmhead/U3so09tgto5Ut2MV106UqyzvOl7B7pqMyniawv0oo91Y/0', '2017-10-31 15:26:50', 'oi4Fwv_h9RkQUyZBqWjFSs9vPXZQ', null, null, null, null, null);

-- ----------------------------
-- Table structure for `shop_usercoupon`
-- ----------------------------
DROP TABLE IF EXISTS `shop_usercoupon`;
CREATE TABLE `shop_usercoupon` (
  `usercoupon_id` varchar(100) NOT NULL,
  `coupon_id` varchar(255) DEFAULT NULL COMMENT '优惠券id',
  `status` int(11) NOT NULL COMMENT '状态',
  `addtime` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usercoupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_usercoupon
-- ----------------------------
INSERT INTO `shop_usercoupon` VALUES ('1c02f32544804874be221bd9149eb494', 'a1eaa2b41db9435ead78850422baf0ae', '1', '2017-12-11', 'db9450f0e5eb482badc31721fcbdbf61');
INSERT INTO `shop_usercoupon` VALUES ('dfed5a7f34074a868f4ca32c87b6c2bc', '2e50346804814efeb784d7d3db4f63bd', '1', '2017-12-11', 'db9450f0e5eb482badc31721fcbdbf61');

-- ----------------------------
-- Table structure for `sys_app_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `SFID` varchar(100) DEFAULT NULL,
  `START_TIME` varchar(100) DEFAULT NULL,
  `END_TIME` varchar(100) DEFAULT NULL,
  `YEARS` int(10) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
INSERT INTO `sys_app_user` VALUES ('1e89e6504be349a68c025976b3ecc1d1', 'a1', '698d51a19d8a121ce581499d7b701668', '会员甲', '', '115b386ff04f4352b060dffcd2b5d1da', '', '', '1', '121', '1212', '1212', '2015-12-02', '2015-12-25', '2', '111', '313596790@qq.com');
INSERT INTO `sys_app_user` VALUES ('ead1f56708e4409c8d071e0a699e5633', 'a2', 'bcbe3365e6ac95ea2c0343a2395834dd', '会员乙', '', '1b67fc82ce89457a8347ae53e43a347e', '', '', '0', '', '', '', '2015-12-01', '2015-12-24', '1', '121', '978336446@qq.com');

-- ----------------------------
-- Table structure for `sys_dictionaries`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionaries`;
CREATE TABLE `sys_dictionaries` (
  `DICTIONARIES_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `NAME_EN` varchar(50) DEFAULT NULL COMMENT '英文',
  `BIANMA` varchar(50) DEFAULT NULL COMMENT '编码',
  `ORDER_BY` int(11) NOT NULL COMMENT '排序',
  `PARENT_ID` varchar(100) DEFAULT NULL COMMENT '上级ID',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TBSNAME` varchar(100) DEFAULT NULL COMMENT '排查表',
  PRIMARY KEY (`DICTIONARIES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionaries
-- ----------------------------
INSERT INTO `sys_dictionaries` VALUES ('096e4ec8986149d994b09e604504e38d', '黄浦区', 'huangpu', '0030201', '1', 'f1ea30ddef1340609c35c88fb2919bee', '黄埔', '');
INSERT INTO `sys_dictionaries` VALUES ('12a62a3e5bed44bba0412b7e6b733c93', '北京', 'beijing', '00301', '1', 'be4a8c5182c744d28282a5345783a77f', '北京', '');
INSERT INTO `sys_dictionaries` VALUES ('507fa87a49104c7c8cdb52fdb297da12', '宣武区', 'xuanwuqu', '0030101', '1', '12a62a3e5bed44bba0412b7e6b733c93', '宣武区', '');
INSERT INTO `sys_dictionaries` VALUES ('8994f5995f474e2dba6cfbcdfe5ea07a', '语文', 'yuwen', '00201', '1', 'fce20eb06d7b4b4d8f200eda623f725c', '语文', '');
INSERT INTO `sys_dictionaries` VALUES ('8ea7c44af25f48b993a14f791c8d689f', '分类', 'fenlei', '001', '1', '0', '分类', '');
INSERT INTO `sys_dictionaries` VALUES ('be4a8c5182c744d28282a5345783a77f', '地区', 'diqu', '003', '3', '0', '地区', '');
INSERT INTO `sys_dictionaries` VALUES ('d428594b0494476aa7338d9061e23ae3', '红色', 'red', '00101', '1', '8ea7c44af25f48b993a14f791c8d689f', '红色', '');
INSERT INTO `sys_dictionaries` VALUES ('de9afadfbed0428fa343704d6acce2c4', '绿色', 'green', '00102', '2', '8ea7c44af25f48b993a14f791c8d689f', '绿色', '');
INSERT INTO `sys_dictionaries` VALUES ('f1ea30ddef1340609c35c88fb2919bee', '上海', 'shanghai', '00302', '2', 'be4a8c5182c744d28282a5345783a77f', '上海', '');
INSERT INTO `sys_dictionaries` VALUES ('fce20eb06d7b4b4d8f200eda623f725c', '课程', 'kecheng', '002', '2', '0', '课程', '');

-- ----------------------------
-- Table structure for `sys_fhbutton`
-- ----------------------------
DROP TABLE IF EXISTS `sys_fhbutton`;
CREATE TABLE `sys_fhbutton` (
  `FHBUTTON_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `QX_NAME` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`FHBUTTON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fhbutton
-- ----------------------------
INSERT INTO `sys_fhbutton` VALUES ('3542adfbda73410c976e185ffe50ad06', '导出EXCEL', 'toExcel', '导出EXCEL');
INSERT INTO `sys_fhbutton` VALUES ('4efa162fce8340f0bd2dcd3b11d327ec', '导入EXCEL', 'FromExcel', '导入EXCEL到系统用户');

-- ----------------------------
-- Table structure for `sys_fhsms`
-- ----------------------------
DROP TABLE IF EXISTS `sys_fhsms`;
CREATE TABLE `sys_fhsms` (
  `FHSMS_ID` varchar(100) NOT NULL,
  `CONTENT` varchar(1000) DEFAULT NULL COMMENT '内容',
  `TYPE` varchar(5) DEFAULT NULL COMMENT '类型',
  `TO_USERNAME` varchar(255) DEFAULT NULL COMMENT '收信人',
  `FROM_USERNAME` varchar(255) DEFAULT NULL COMMENT '发信人',
  `SEND_TIME` varchar(100) DEFAULT NULL COMMENT '发信时间',
  `STATUS` varchar(5) DEFAULT NULL COMMENT '状态',
  `SANME_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FHSMS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fhsms
-- ----------------------------
INSERT INTO `sys_fhsms` VALUES ('05879f5868824f35932ee9f2062adc03', '你好', '2', 'admin', 'san', '2016-01-25 14:05:31', '1', 'b311e893228f42d5a05dbe16917fd16f');
INSERT INTO `sys_fhsms` VALUES ('2635dd035c6f4bb5a091abdd784bd899', '你好', '2', 'san', 'admin', '2016-01-25 14:05:02', '2', '1b7637306683460f89174c2b025862b5');
INSERT INTO `sys_fhsms` VALUES ('52378ccd4e2d4fe08994d1652af87c68', '你好', '1', 'admin', 'san', '2016-01-25 16:26:44', '1', '920b20dafdfb4c09b560884eb277c51d');
INSERT INTO `sys_fhsms` VALUES ('77ed13f9c49a4c4bb460c41b8580dd36', 'gggg', '2', 'admin', 'san', '2016-01-24 21:22:43', '2', 'dd9ee339576e48c5b046b94fa1901d00');
INSERT INTO `sys_fhsms` VALUES ('98a6869f942042a1a037d9d9f01cb50f', '你好', '1', 'admin', 'san', '2016-01-25 14:05:02', '2', '1b7637306683460f89174c2b025862b5');
INSERT INTO `sys_fhsms` VALUES ('9e00295529014b6e8a27019cbccb3da1', '柔柔弱弱', '1', 'admin', 'san', '2016-01-24 21:22:57', '1', 'a29603d613ea4e54b5678033c1bf70a6');
INSERT INTO `sys_fhsms` VALUES ('d3aedeb430f640359bff86cd657a8f59', '你好', '1', 'admin', 'san', '2016-01-24 21:22:12', '1', 'f022fbdce3d845aba927edb698beb90b');
INSERT INTO `sys_fhsms` VALUES ('e5376b1bd54b489cb7f2203632bd74ec', '管理员好', '2', 'admin', 'san', '2016-01-25 14:06:13', '2', 'b347b2034faf43c79b54be4627f3bd2b');
INSERT INTO `sys_fhsms` VALUES ('e613ac0fcc454f32895a70b747bf4fb5', '你也好', '2', 'admin', 'san', '2016-01-25 16:27:54', '2', 'ce8dc3b15afb40f28090f8b8e13f078d');
INSERT INTO `sys_fhsms` VALUES ('f25e00cfafe741a3a05e3839b66dc7aa', '你好', '2', 'san', 'admin', '2016-01-25 16:26:44', '1', '920b20dafdfb4c09b560884eb277c51d');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(60) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  `MENU_STATE` int(1) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '#', '0', '11', 'menu-icon fa fa-desktop blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('2', '权限管理', '#', '1', '1', 'menu-icon fa fa-lock black', '1', '1');
INSERT INTO `sys_menu` VALUES ('15', '微信管理', '#', '0', '10', 'menu-icon fa fa-comments blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('16', '文本回复', 'textmsg/list.do', '15', '2', 'menu-icon fa fa-comment green', '2', '1');
INSERT INTO `sys_menu` VALUES ('17', '应用命令', 'command/list.do', '15', '4', 'menu-icon fa fa-comment grey', '2', '0');
INSERT INTO `sys_menu` VALUES ('18', '图文回复', 'imgmsg/list.do', '15', '3', 'menu-icon fa fa-comment pink', '2', '1');
INSERT INTO `sys_menu` VALUES ('19', '关注回复', 'textmsg/goSubscribe.do', '15', '1', 'menu-icon fa fa-comment orange', '2', '1');
INSERT INTO `sys_menu` VALUES ('20', '在线管理', 'onlinemanager/list.do', '1', '5', 'menu-icon fa fa-laptop green', '1', '0');
INSERT INTO `sys_menu` VALUES ('36', '角色(基础权限)', 'role.do', '2', '1', 'menu-icon fa fa-key orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('37', '按钮权限', 'buttonrights/list.do', '2', '2', 'menu-icon fa fa-key green', '1', '1');
INSERT INTO `sys_menu` VALUES ('38', '菜单管理', 'menu/listAllMenu.do', '1', '3', 'menu-icon fa fa-folder-open-o brown', '1', '1');
INSERT INTO `sys_menu` VALUES ('39', '按钮管理', 'fhbutton/list.do', '1', '2', 'menu-icon fa fa-download orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('40', '用户管理', '#', '0', '9', 'menu-icon fa fa-users blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('41', '系统用户', 'user/listUsers.do', '40', '1', 'menu-icon fa fa-users green', '1', '1');
INSERT INTO `sys_menu` VALUES ('45', '七级菜单1', '#', '33', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('46', '七级菜单2', '#', '33', '2', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('47', '八级菜单', 'login_default.do', '45', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('59', '轮播图片', '#', '0', '1', 'menu-icon fa fa-camera blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('60', '轮播图片', 'banner/list.do', '59', '1', 'menu-icon fa fa-gift red', '1', '1');
INSERT INTO `sys_menu` VALUES ('61', '商品管理', '#', '0', '5', 'menu-icon fa fa-gift blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('62', '分类管理', 'category/list.do?super_id=0', '61', '1', 'menu-icon fa fa-gift black', '1', '1');
INSERT INTO `sys_menu` VALUES ('63', '商品管理', 'goods/list.do', '61', '2', 'menu-icon fa fa-gift black', '1', '1');
INSERT INTO `sys_menu` VALUES ('64', '会员用户', 'shopUser/list.do', '40', '2', 'menu-icon fa fa-users black', '1', '1');
INSERT INTO `sys_menu` VALUES ('65', '快速导航', '#', '0', '2', 'menu-icon fa fa-barcode blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('66', '首页导航', 'navigation/list', '65', '1', 'menu-icon fa fa-barcode black', '1', '1');
INSERT INTO `sys_menu` VALUES ('67', '新闻信息', '#', '0', '4', 'menu-icon fa fa-bullhorn blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('68', '新闻信息', 'news/list.do', '67', '1', 'menu-icon fa fa-bullhorn black', '1', '1');
INSERT INTO `sys_menu` VALUES ('70', '订单管理', '#', '0', '7', 'menu-icon fa fa-cutlery blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('71', '订单查看', 'order/list', '70', '1', 'menu-icon fa fa-cutlery black', '1', '1');
INSERT INTO `sys_menu` VALUES ('75', '搜索管理', '#', '0', '3', 'menu-icon fa fa-circle-o blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('76', '热搜设置', 'search/list', '75', '1', 'menu-icon fa fa-circle-o black', '1', '1');
INSERT INTO `sys_menu` VALUES ('78', '优惠设置', '#', '0', '8', 'menu-icon fa fa-exchange blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('79', '优惠券管理', 'coupon/list', '78', '1', 'menu-icon fa fa-exchange black', '1', '1');
INSERT INTO `sys_menu` VALUES ('82', '微信菜单', 'button/list', '15', '4', 'menu-icon fa fa-comment orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('83', '公众号参数', 'config/goEdit?config_id=1', '15', '1', 'menu-icon fa fa-comment orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('84', '运费设置', '#', '0', '9', 'menu-icon fa fa-fighter-jet blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('85', '运费设置', 'freight/goEdit', '84', '1', 'menu-icon fa fa-fighter-jet black', '1', '1');
INSERT INTO `sys_menu` VALUES ('86', '快递录入', 'express/list', '84', '2', 'menu-icon fa fa-fighter-jet black', '1', '1');
INSERT INTO `sys_menu` VALUES ('87', '快递参数', 'expressconfig/goEdit', '84', '3', 'menu-icon fa fa-fighter-jet black', '1', '1');
INSERT INTO `sys_menu` VALUES ('88', '小程序参数', 'config/goEdit?config_id=2', '15', '2', 'menu-icon fa fa-comment green', '1', '1');
INSERT INTO `sys_menu` VALUES ('89', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('90', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('91', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('92', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('93', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('94', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('95', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('96', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('97', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('98', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('99', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('100', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('101', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('102', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('103', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('104', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('105', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('106', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('107', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);
INSERT INTO `sys_menu` VALUES ('108', null, null, null, null, 'menu-icon fa fa-leaf black', null, null);

-- ----------------------------
-- Table structure for `sys_menu_copy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_copy`;
CREATE TABLE `sys_menu_copy` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(60) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  `MENU_STATE` int(1) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_copy
-- ----------------------------
INSERT INTO `sys_menu_copy` VALUES ('1', '系统管理', '#', '0', '7', 'menu-icon fa fa-desktop blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('2', '权限管理', '#', '1', '1', 'menu-icon fa fa-lock black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('6', '信息管理', '#', '0', '5', 'menu-icon fa fa-credit-card green', '2', '0');
INSERT INTO `sys_menu_copy` VALUES ('7', '图片管理', '#', '6', '1', 'menu-icon fa fa-folder-o pink', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('9', '系统工具', '#', '0', '3', 'menu-icon fa fa-cog blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('10', '接口测试', 'tool/interfaceTest.do', '9', '2', 'menu-icon fa fa-exchange green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('15', '微信管理', '#', '0', '4', 'menu-icon fa fa-comments blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('16', '文本回复', 'textmsg/list.do', '15', '2', 'menu-icon fa fa-comment green', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('17', '应用命令', 'command/list.do', '15', '4', 'menu-icon fa fa-comment grey', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('18', '图文回复', 'imgmsg/list.do', '15', '3', 'menu-icon fa fa-comment pink', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('19', '关注回复', 'textmsg/goSubscribe.do', '15', '1', 'menu-icon fa fa-comment orange', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('20', '在线管理', 'onlinemanager/list.do', '1', '5', 'menu-icon fa fa-laptop green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('36', '角色(基础权限)', 'role.do', '2', '1', 'menu-icon fa fa-key orange', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('37', '按钮权限', 'buttonrights/list.do', '2', '2', 'menu-icon fa fa-key green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('38', '菜单管理', 'menu/listAllMenu.do', '1', '3', 'menu-icon fa fa-folder-open-o brown', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('39', '按钮管理', 'fhbutton/list.do', '1', '2', 'menu-icon fa fa-download orange', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('40', '用户管理', '#', '0', '6', 'menu-icon fa fa-users blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('41', '系统用户', 'user/listUsers.do', '40', '1', 'menu-icon fa fa-users green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('42', '会员管理', 'happuser/listUsers.do', '40', '2', 'menu-icon fa fa-users orange', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('43', '数据字典', 'dictionaries/listAllDict.do?DICTIONARIES_ID=0', '1', '4', 'menu-icon fa fa-book purple', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('44', '代码生成器', 'createCode/list.do', '9', '0', 'menu-icon fa fa-cogs brown', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('45', '七级菜单1', '#', '33', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('46', '七级菜单2', '#', '33', '2', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('47', '八级菜单', 'login_default.do', '45', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('51', '图片列表', 'pictures/list.do', '7', '1', 'menu-icon fa fa-folder-open-o green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('52', '图片爬虫', 'pictures/goImageCrawler.do', '7', '2', 'menu-icon fa fa-cloud-download green', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('53', '表单构建器', 'tool/goFormbuilder.do', '9', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('54', '数据库管理', '#', '0', '9', 'menu-icon fa fa-hdd-o blue', '2', '0');
INSERT INTO `sys_menu_copy` VALUES ('55', '数据库备份', 'brdb/listAllTable.do', '54', '1', 'menu-icon fa fa-cloud-upload blue', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('56', '数据库还原', 'brdb/list.do', '54', '3', 'menu-icon fa fa-cloud-download blue', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('57', '备份定时器', 'timingbackup/list.do', '54', '2', 'menu-icon fa fa-tachometer blue', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('58', 'SQL编辑器', 'sqledit/view.do', '54', '4', 'menu-icon fa fa-pencil-square-o blue', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('59', '轮播图片', '#', '0', '1', 'menu-icon fa fa-camera blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('60', '轮播图片', 'banner/list.do', '59', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('61', '商品管理', '#', '0', '2', 'menu-icon fa fa-gift blue', '2', '1');
INSERT INTO `sys_menu_copy` VALUES ('62', '分类管理', 'category/list.do', '61', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu_copy` VALUES ('63', '商品管理', 'goods/list.do', '61', '2', 'menu-icon fa fa-leaf black', '1', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理组', '615158479018747552082132998', '0', '1', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('115b386ff04f4352b060dffcd2b5d1da', '中级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('1b67fc82ce89457a8347ae53e43a347e', '初级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('2', '会员组', '498', '0', '0', '0', '0', '1');
INSERT INTO `sys_role` VALUES ('3264c8e83d0248bb9e3ea6195b4c0216', '一级管理员', '615158479018747552082132998', '1', '19309755972015148490524166', '19309755971997556304478214', '16891904332784859347912192', '19309755971997556304478214');
INSERT INTO `sys_role` VALUES ('46294b31a71c4600801724a6eb06bb26', '职位组', '', '0', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('5466347ac07044cb8d82990ec7f3a90e', '主管', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('68f8e4a39efe47c7bb869e9d15ab925d', '二级管理员', '615158479018747552082132998', '1', '0', '0', '2251798773489606', '0');
INSERT INTO `sys_role` VALUES ('856849f422774ad390a4e564054d8cc8', '经理', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('8b70a7e67f2841e7aaba8a4d92e5ff6f', '高级会员', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('c21cecf84048434b93383182b1d98cba', '组长', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('d449195cd8e7491080688c58e11452eb', '总监', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('de9de2f006e145a29d52dfadda295353', '三级管理员', '615158479018747552082132998', '1', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `sys_role_fhbutton`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_fhbutton`;
CREATE TABLE `sys_role_fhbutton` (
  `RB_ID` varchar(100) NOT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `BUTTON_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RB_ID`),
  KEY `角色表外键` (`ROLE_ID`) USING BTREE,
  KEY `fbutton` (`BUTTON_ID`) USING BTREE,
  CONSTRAINT `sys_role_fhbutton_ibfk_1` FOREIGN KEY (`BUTTON_ID`) REFERENCES `sys_fhbutton` (`FHBUTTON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_fhbutton_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_fhbutton
-- ----------------------------
INSERT INTO `sys_role_fhbutton` VALUES ('0c6ab872abca43e09cbff1c23d7931f2', '3264c8e83d0248bb9e3ea6195b4c0216', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_fhbutton` VALUES ('1743733f366240c693c4295b527d1b0e', 'de9de2f006e145a29d52dfadda295353', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('689f47b2c57041c589feeb170a83e48f', '68f8e4a39efe47c7bb869e9d15ab925d', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_fhbutton` VALUES ('8231c216fb514b4188e4162e629c6237', '3264c8e83d0248bb9e3ea6195b4c0216', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('a1478f27c852459fa9cad04b642f4fb7', 'de9de2f006e145a29d52dfadda295353', '3542adfbda73410c976e185ffe50ad06');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '223ce7b851123353479d85757fbbf4e320d1e251', '千派网络', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2017-12-12 13:48:35', '0:0:0:0:0:0:0:1', '0', 'admin', 'default', '357788906@qq.com', '001', '13184235048');
INSERT INTO `sys_user` VALUES ('4097b39aaafb4792a8ddb88d846d4682', 'qanpai1', '86b5e37481387f1c66e77e22d1d3ede6ab642100', 'qian pai', '', '3264c8e83d0248bb9e3ea6195b4c0216', '2017-12-04 19:36:24', '112.116.206.52', '0', '', 'default', '1@163.com', '1', '13800138000');
INSERT INTO `sys_user` VALUES ('bcc989dd0cf24a46bddd97856e8b87c6', 'qanpai2', '519ccff2ef6755b6887d77c6641e5b9be0dd308d', '1', '', '3264c8e83d0248bb9e3ea6195b4c0216', '2017-06-06 16:02:33', '127.0.0.1', '0', '1', 'default', '1@main.com', '2', '13184235048');

-- ----------------------------
-- Table structure for `weixin_accesstoken`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_accesstoken`;
CREATE TABLE `weixin_accesstoken` (
  `accesstoken_id` varchar(100) NOT NULL,
  `access_token` varchar(255) DEFAULT NULL COMMENT 'access_token',
  `add_time` varchar(255) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`accesstoken_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_accesstoken
-- ----------------------------
INSERT INTO `weixin_accesstoken` VALUES ('1', 'f6zyaXtDQ-KVhwEXw-3xdobHiXsM2hnEO6N3LjJJonfmaG7BE1b5ZLEsU7YOWvGCymeQ-jfyF2zQcUQb1OxPlxMoQ-UcFxgWQpM5AkJr8EIHJNeAFABDH', '1492412819');

-- ----------------------------
-- Table structure for `weixin_button`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_button`;
CREATE TABLE `weixin_button` (
  `button_id` varchar(100) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `value` varchar(255) DEFAULT NULL COMMENT '值/链接',
  `super_id` varchar(255) DEFAULT NULL COMMENT '所属父级',
  `sort` int(11) NOT NULL COMMENT '排序',
  `level` int(11) NOT NULL COMMENT '菜单等级',
  PRIMARY KEY (`button_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_button
-- ----------------------------
INSERT INTO `weixin_button` VALUES ('1', '微信商城', 'view', 'http://www.7haodian.cc/chihaodian/main/index.html', '1', '1', '1');

-- ----------------------------
-- Table structure for `weixin_command`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_command`;
CREATE TABLE `weixin_command` (
  `COMMAND_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `COMMANDCODE` varchar(255) DEFAULT NULL COMMENT '应用路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(1) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`COMMAND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_command
-- ----------------------------
INSERT INTO `weixin_command` VALUES ('2636750f6978451b8330874c9be042c2', '锁定服务器', 'rundll32.exe user32.dll,LockWorkStation', '2015-05-10 21:25:06', '1', '锁定计算机');
INSERT INTO `weixin_command` VALUES ('46217c6d44354010823241ef484f7214', '打开浏览器', 'C:/Program Files/Internet Explorer/iexplore.exe', '2015-05-09 02:43:02', '1', '打开浏览器操作');
INSERT INTO `weixin_command` VALUES ('576adcecce504bf3bb34c6b4da79a177', '关闭浏览器', 'taskkill /f /im iexplore.exe', '2015-05-09 02:36:48', '2', '关闭浏览器操作');
INSERT INTO `weixin_command` VALUES ('854a157c6d99499493f4cc303674c01f', '关闭QQ', 'taskkill /f /im qq.exe', '2015-05-10 21:25:46', '1', '关闭QQ');
INSERT INTO `weixin_command` VALUES ('ab3a8c6310ca4dc8b803ecc547e55ae7', '打开QQ', 'E:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe', '2015-05-10 21:25:25', '1', '打开QQ');

-- ----------------------------
-- Table structure for `weixin_config`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_config`;
CREATE TABLE `weixin_config` (
  `config_id` varchar(100) NOT NULL,
  `appid` varchar(255) DEFAULT NULL COMMENT '公众号appid',
  `appsecret` varchar(255) DEFAULT NULL COMMENT '公众号秘钥',
  `partner` varchar(255) DEFAULT NULL COMMENT '商户id',
  `partnerkey` varchar(255) DEFAULT NULL COMMENT '商户秘钥',
  `link` varchar(255) DEFAULT NULL COMMENT '域名',
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_config
-- ----------------------------
INSERT INTO `weixin_config` VALUES ('1', 'wx59c485a863c260bf', 'b3d22117238749c8d51b64f13cfbd805', '1462599002', 'qianpai1qianpai1qianpai1qianpai1', 'http://wx.qanpai.com/mall', 'd:\\\\apiclient_cert.p12');
INSERT INTO `weixin_config` VALUES ('2', 'wx59c485a863c260bf', 'b3d22117238749c8d51b64f13cfbd805', '1462599002', 'qianpai1qianpai1qianpai1qianpai1', 'http://wx.qanpai.com/mall', 'd:\\\\apiclient_cert.p12');

-- ----------------------------
-- Table structure for `weixin_imgmsg`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_imgmsg`;
CREATE TABLE `weixin_imgmsg` (
  `IMGMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CREATETIME` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TITLE1` varchar(255) DEFAULT NULL COMMENT '标题1',
  `DESCRIPTION1` varchar(255) DEFAULT NULL COMMENT '描述1',
  `IMGURL1` varchar(255) DEFAULT NULL COMMENT '图片地址1',
  `TOURL1` varchar(255) DEFAULT NULL COMMENT '超链接1',
  `TITLE2` varchar(255) DEFAULT NULL COMMENT '标题2',
  `DESCRIPTION2` varchar(255) DEFAULT NULL COMMENT '描述2',
  `IMGURL2` varchar(255) DEFAULT NULL COMMENT '图片地址2',
  `TOURL2` varchar(255) DEFAULT NULL COMMENT '超链接2',
  `TITLE3` varchar(255) DEFAULT NULL COMMENT '标题3',
  `DESCRIPTION3` varchar(255) DEFAULT NULL COMMENT '描述3',
  `IMGURL3` varchar(255) DEFAULT NULL COMMENT '图片地址3',
  `TOURL3` varchar(255) DEFAULT NULL COMMENT '超链接3',
  `TITLE4` varchar(255) DEFAULT NULL COMMENT '标题4',
  `DESCRIPTION4` varchar(255) DEFAULT NULL COMMENT '描述4',
  `IMGURL4` varchar(255) DEFAULT NULL COMMENT '图片地址4',
  `TOURL4` varchar(255) DEFAULT NULL COMMENT '超链接4',
  `TITLE5` varchar(255) DEFAULT NULL COMMENT '标题5',
  `DESCRIPTION5` varchar(255) DEFAULT NULL COMMENT '描述5',
  `IMGURL5` varchar(255) DEFAULT NULL COMMENT '图片地址5',
  `TOURL5` varchar(255) DEFAULT NULL COMMENT '超链接5',
  `TITLE6` varchar(255) DEFAULT NULL COMMENT '标题6',
  `DESCRIPTION6` varchar(255) DEFAULT NULL COMMENT '描述6',
  `IMGURL6` varchar(255) DEFAULT NULL COMMENT '图片地址6',
  `TOURL6` varchar(255) DEFAULT NULL COMMENT '超链接6',
  `TITLE7` varchar(255) DEFAULT NULL COMMENT '标题7',
  `DESCRIPTION7` varchar(255) DEFAULT NULL COMMENT '描述7',
  `IMGURL7` varchar(255) DEFAULT NULL COMMENT '图片地址7',
  `TOURL7` varchar(255) DEFAULT NULL COMMENT '超链接7',
  `TITLE8` varchar(255) DEFAULT NULL COMMENT '标题8',
  `DESCRIPTION8` varchar(255) DEFAULT NULL COMMENT '描述8',
  `IMGURL8` varchar(255) DEFAULT NULL COMMENT '图片地址8',
  `TOURL8` varchar(255) DEFAULT NULL COMMENT '超链接8',
  PRIMARY KEY (`IMGMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_imgmsg
-- ----------------------------
INSERT INTO `weixin_imgmsg` VALUES ('380b2cb1f4954315b0e20618f7b5bd8f', '首页', '2015-05-10 20:51:09', '1', '图文回复', '图文回复标题', '图文回复描述', 'http://a.hiphotos.baidu.com/image/h%3D360/sign=c6c7e73ebc389b5027ffe654b535e5f1/a686c9177f3e6709392bb8df3ec79f3df8dc55e3.jpg', 'www.baidu.com', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for `weixin_reply`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_reply`;
CREATE TABLE `weixin_reply` (
  `reply_id` varchar(100) NOT NULL,
  `key` varchar(255) DEFAULT NULL COMMENT '关键词',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `content` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `intro` varchar(255) DEFAULT NULL COMMENT '简介',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `url` varchar(255) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `weixin_textmsg`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_textmsg`;
CREATE TABLE `weixin_textmsg` (
  `TEXTMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '内容',
  `CREATETIME` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(2) DEFAULT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TEXTMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_textmsg
-- ----------------------------
INSERT INTO `weixin_textmsg` VALUES ('695cd74779734231928a253107ab0eeb', '吃饭', '吃了噢噢噢噢', '2015-05-10 22:52:27', '1', '文本回复');
INSERT INTO `weixin_textmsg` VALUES ('d4738af7aea74a6ca1a5fb25a98f9acb', '关注', '这里是关注后回复的内容', '2015-05-11 02:12:36', '1', '关注回复');
