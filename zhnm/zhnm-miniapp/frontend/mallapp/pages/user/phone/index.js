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
    util.request(app.data.httpserver + 'user/info').then(function (request) { 
        that.setData({
          phone: request.phone,
        })
    })
  },
  change(e) {
    var that = this;
    var phone = e.detail.value
    that.setData({
      phone: phone,
    })
  },
  update() {
    var that = this;
    var phone = that.data.phone;
    if (!phone) {
      wx.showModal({
        title: '提示',
        content: '请输入手机号码',
        showCancel: false,
      })
      return
    }
    if (phone.length > 11) {
      wx.showModal({
        title: '提示',
        content: '手机号码填写有误',
        showCancel: false,
      })
      return
    }
    wx.showToast({
      icon: 'loading',
    })
    var data = { phone: phone }
    util.request(app.data.httpserver + 'user/update_phone', data = data).then(function (request) { 
      if (request.result === 1) {
        wx.showToast({
          title: request.message,
          icon: 'success',
        })
        that.setData({
          phone: phone,
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