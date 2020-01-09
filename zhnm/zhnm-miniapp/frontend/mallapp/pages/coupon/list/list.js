// list.js
var app = getApp();
var util = require('../../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    page: [{
      totalPage: 0,
      currentPage: 1
      }],
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var currentPage = that.data.page.currentPage;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: that.data.httpserver +'coupon/list',
    //   header: wx.getStorageSync('header'),
    //   success:function(request){
    util.request(app.data.httpserver + 'coupon/list').then(function (request) { 
        that.setData({
          list: request.list,
          page: request.page,
        })
    })
  },
/**
 * 领取优惠券
 */
  get_coupon(e){
    var that = this
    var coupon_id = e.currentTarget.dataset.coupon_id;;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: that.data.httpserver + 'usercoupon/save',
    //   data: { coupon_id: coupon_id },
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    var data = { coupon_id: coupon_id }
    util.request(app.data.httpserver + 'usercoupon/save', data = data).then(function (request) {
      console.log("11111111111111111111111")
      wx.showToast({
          title: request.message,
          icon: 'success',
          duration: 2000
        })
        if (request.result != 0){
            wx.navigateBack();
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
    var totalPage = this.data.totalPage;
    var currentPage = this.data.currentPage;
    if (totalPage > currentPage) {
      currentPage++;
      this.setData({
        currentPage: currentPage,
      })
 
      this.onLoad()
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})