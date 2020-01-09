var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var express_num = options.express_num;
    var express_name = options.express_name;
    var express_title = options.express_title;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    wx.request({
      url: that.data.httpserver + 'express/info',
      data: { express_num: express_num, express_title: express_title },
      header: wx.getStorageSync('header'),
      success: function (request) {
        if (request.data.result==1){
          var express = request.data.express;
          var express_status = 1;
          if (express.Success == true) {
            if (express.State == 0) {
              express_status = 0 ;
            }
          }
          else {
            express_status = -1;
          }
          that.setData({
            express: express,
            express_status: express_status,
          })
        }
        
      },
      complete: function () {
        wx.hideNavigationBarLoading() //完成停止加载
        that.setData({
          express_num :express_num,
          express_name : express_name,
          express_title : express_title
        })
      }
    }) 
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