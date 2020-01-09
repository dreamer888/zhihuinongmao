// list.js
var app = getApp();
var util = require('../../../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    page: [{
      totalPage: 0,
      currentPage: 1
    }],
    list: new Array(),
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },
  coupon_list(){
    wx.navigateTo({
      url:'../../list/list'
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
    var that = this
    var currentPage = that.data.page.currentPage;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: that.data.httpserver + 'usercoupon/list',
    //   method: 'post',
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    util.request(app.data.httpserver + 'usercoupon/list').then(function (request) {   
        var list = request.list;
        // list = list.concat(request.list);
        // console.log(list)
        that.setData({
          list: list,
          page: request.page,
        })
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
    var totalPage = this.data.totalPage;
    var currentPage = this.data.currentPage;
    if (totalPage > currentPage) {
      currentPage++;
      this.setData({
        currentPage: currentPage,
      })

      this.onShow()
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})