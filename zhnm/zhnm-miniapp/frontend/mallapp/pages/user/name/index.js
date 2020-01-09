var app = getApp();
var util = require('../../../utils/util.js');

Page({
  /**
   * 页面的初始数据
   */
  data: {
    httphost: app.data.httphost,
    httpserver: app.data.httpserver
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // wx.request({
    //   url: that.data.httpserver + 'user/info',
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    util.request(app.data.httpserver + 'user/info').then(function (request) { 
        that.setData({
          username: request.username,
        })
    })
  },
  change(e){
    var that = this;
    var username = e.detail.value
    that.setData({
      username: username,
    })
  },
update(){
  var that = this;
  var username = that.data.username;
  if (!username){
    wx.showModal({
      title: '提示',
      content:'请输入昵称',
      showCancel: false,
    })
    return
  }
  wx.showToast({
    icon: 'loading',
  })
  var data = { username: username }
  util.request(app.data.httpserver + 'user/update', data = { username: username}).then(function (request) { 
    if (request.result === 1){
      wx.showToast({
        title: request.message,
        icon: 'success',
      })

      that.setData({
        username: request.username,
      })
      wx.navigateBack({
        delta: 1
      })
    }else{
      wx.showToast({
        title: request.message,
        icon: 'fail',
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