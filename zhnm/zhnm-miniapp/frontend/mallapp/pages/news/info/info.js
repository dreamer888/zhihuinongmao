var app = getApp();
var util = require('../../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var news_id = options.news_id;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: app.data.httpserver + 'news/info',
    //   data: { news_id: news_id},
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    var data = { news_id: news_id }
    util.request(app.data.httpserver + 'news/info', data = data).then(function (request) { 
      var news = request
      console.log(news.news_content)
      
      news.news_content = news.news_content.replace(/src="/g, 'src="' + app.data.httphost).replace('<img', '<img mode="widthFix" style="width:100%"');
      console.log(news.news_content)
        that.setData({
          news: request,
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
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})