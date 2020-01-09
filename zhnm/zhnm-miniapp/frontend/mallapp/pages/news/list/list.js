var app = getApp();
var util = require('../../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    totalPage: 0,
    currentPage: 1,
  },


  news_info:function(e){
    var news_id = e.currentTarget.dataset.news_id;
    wx.navigateTo({
      url: '../info/info?news_id=' + news_id,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var currentPage = that.data.currentPage;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: app.data.httpserver + 'news/list',
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    util.request(app.data.httpserver + 'news/list').then(function (request) { 
        that.setData({
          list: request.list,
          page: request.page,
          totalPage: request.page.totalPage,
          currentPage: request.page.currentPage,
        })
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
      var options = {
        currentPage: currentPage,
      }
      this.onLoad(options)
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})