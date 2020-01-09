var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // nullTip:true
     motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    getUserInfoFail: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },

  /**
   * 生命周期函数--监听页面加载
   */
  // onLoad: function (options) {
   
  // },
  onLoad: function () {

    if (app.globalData.userInfo) {
      console.log(1)
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      console.log(2)
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        console.log(12)
        app.globalData.userInfo = res.userInfo
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      console.log(3)
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        },
        fail: res => {
          console.log(4);
          this.setData({
            getUserInfoFail: true
          })
        }
      })
    }
  },
  get_open(){
    wx.openSetting({
      success: (res) => {
        console.log("如果用户重新同意了授权登录");
        if (res.authSetting["scope.userInfo"]) {////如果用户重新同意了授权登录
          console.log("是的 没错");
        }
      }
    }
    
    ) 
  // wx.openSetting({
  //   success: function (res) {
  //     if (!res.authSetting["scope.userInfo"] || !res.authSetting["scope.userLocation"]) {
  //       //这里是授权成功之后 填写你重新获取数据的js
  //       //参考:
  //       that.getLogiCallback('', function () {
  //         callback('')
  //       })
  //     }
  //   }
  // })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.login();
    // var that = this;
    // wx.login({
    //   success: function (r) {
    //     var code = r.code;//登录凭证
    //     if (code) {
    //       //2、调用获取用户信息接口
    //       wx.getUserInfo({
    //         success: function (res) {
    //           //3.请求自己的服务器，解密用户信息 获取unionId等加密信息
    //           var session_id = wx.getStorageSync('session_id');//本地取存储的sessionID  
    //           wx.request({
    //             url: app.data.httpserver + 'app/weixinlogin',//自己的服务接口地址
    //             data: { encryptedData: res.encryptedData, iv: res.iv, code: code },
    //             success: function (request) {
    //               //4.解密成功后 获取自己服务器返回的结果
    //               if (request.data.result == 1) {
    //                 var userInfo = request.data.shopUser
    //                 var session_id = request.data.session_id
    //                 // var header = { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': 'session_id=' + session_id }
    //                 var header = {'content-type': 'application/x-www-form-urlencoded', 'Cookie': 'session_id=abc'}
    //                 var header_upload = { 'content-type': 'multipart/form-data', 'Cookie': 'session_id=' + session_id }
    //                 wx.setStorageSync('header', header)
    //                 wx.setStorageSync('header_upload', header_upload)
    //                 wx.setStorageSync('session_id', session_id)
    //                 wx.setStorageSync("userInfo", userInfo);
    //                 wx.redirectTo({
    //                   url: '../index/index'
    //                 })
    //               } else {
    //                 console.log('解密失败')
    //               }
    //             },
    //             fail: function () {
    //               console.log('系统错误')
    //             }
    //           })
    //         },
    //         fail: function () {
    //           wx.showModal({
    //             title: '警告',
    //             content: '您点击了拒绝授权，将无法正常使用商城功能。请10分钟后再次点击授权，或者删除小程序重新进入。',
    //             showCancel: false,
    //             success: function (res) {
    //               if (res.confirm) {
    //                 console.log('用户点击确定')
    //                 that.setData({
    //                   nullTip:false
    //                 });
    //               }
    //               return;
    //             }
    //           })
    //         }
    //       })

    //     } else {
    //       console.log('获取用户登录态失败！' + r.errMsg)
    //       return;
    //     }
    //   },
    //   fail: function () {
    //     console.log('登陆失败')
    //     return;
    //   }
    // })
  },
  getUserInfo: function (e) {
    console.log(5);
    console.log(e)
    if (e.detail.userInfo) {
      app.globalData.userInfo = e.detail.userInfo
      this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true
      })
      wx.redirectTo({
        url: '../index/index'
      })
    } else {
      this.openSetting();
    }

  },
  login: function () {
    console.log(111)
    var that = this
    // if (typeof success == "function") {
    //   console.log(6);
    //   console.log('success');
    //   this.data.getUserInfoSuccess = success
    // }
    wx.login({
      success: function (res) {
        var code = res.code;
        console.log(code);
        wx.getUserInfo({
          success: function (res) {
            console.log(7);
            app.globalData.userInfo = res.userInfo
            that.setData({
              getUserInfoFail: false,
              userInfo: res.userInfo,
              hasUserInfo: true
            })
            wx.redirectTo({
              url: '../index/index'
            })
            //平台登录
          },
          fail: function (res) {
            console.log(8);
            console.log(res);
            that.setData({
              getUserInfoFail: true
            })
          }
        })
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