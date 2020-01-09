var app = getApp();
var util = require('../../utils/util.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nullTip:true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var url = options.url
      this.setData({
        url:url
      })
  },
  onShow: function (options) {
   
  },
  go_login() {
    user.loginByWeixin().then(res => {
      this.setData({
        userInfo: res.data.userInfo
      });
      app.globalData.userInfo = res.data.userInfo;
      app.globalData.token = res.data.token;
    }).catch((err) => {
      console.log(err)
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  get_user: function () {
    var that = this;
    wx.login({
      success: function (r) {
        var code = r.code;//登录凭证
        if (code) {
          //2、调用获取用户信息接口
          wx.showNavigationBarLoading(); //在标题栏中显示加载
          wx.getUserInfo({
            success: function (res) {
              console.log('...res='+res);
              //3.请求自己的服务器，解密用户信息 获取unionId等加密信息
              var session_id = wx.getStorageSync('session_id');//本地取存储的sessionID  
              wx.request({
                url: app.data.httpserver + 'app/weixinlogin',//自己的服务接口地址
                data: { encryptedData: res.encryptedData, iv: res.iv, code: code },
                success: function (request) {
                  //4.解密成功后 获取自己服务器返回的结果
                  if (request.data.result == 1) {
                    var userInfo = request.data.shopUser
                    var session_id = request.data.session_id
                    var header = { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': 'session_id=' + session_id }
                    var header_upload = { 'content-type': 'multipart/form-data', 'Cookie': 'session_id=' + session_id }
                    wx.setStorageSync('header', header)
                    wx.setStorageSync('header_upload', header_upload)
                    wx.setStorageSync('session_id', session_id)
                    wx.setStorageSync("userInfo", userInfo);
                    if (that.data.url == null){
                        console.log('重定向为首页')
                        that.data.url = "pages/index/index";
                    }
                    wx.redirectTo({
                      url: '/'+that.data.url
                    })
                  } else {
                    console.log('解密失败')
                  }
                },
                fail: function () {
                  console.log('系统错误')
                }
              })
            },
            fail: function () {
              wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权，将无法正常使用商城功能。请10分钟后再次点击授权，或者删除小程序重新进入。',
                showCancel: false,
                success: function (res) {
                  if (res.confirm) {
                    console.log('用户点击确定')
                    that.setData({
                      nullTip:false
                    });
                  }
                  return;
                }
              })
            }
          })

        } else {
          console.log('获取用户登录态失败！' + r.errMsg)
          return;
        }
      },
      fail: function () {
        console.log('登陆失败')
        return;
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})