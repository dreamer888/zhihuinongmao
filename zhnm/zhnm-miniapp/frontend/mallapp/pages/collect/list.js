var app = getApp();
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    totalPage: 0,
    currentPage: 1,
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var list = that.data.list;
    var currentPage = that.data.currentPage;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: that.data.httpserver + 'collection/list',
    //   data: { currentPage: currentPage },
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    var data = { currentPage: currentPage }
    util.request(app.data.httpserver + 'collection/list', data = data).then(function (request) { 
        list = list.concat(request.list);
        that.setData({
          list: list,
          page: request.page,
        })
    })
  },
  /**
   * 移除收藏
   */
  delete_: function (e) {
    var that = this;
    var goods_id = e.currentTarget.dataset.goods_id;
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 2000
    })
    // wx.request({
    //   url: that.data.httpserver + 'collection/delete',
    //   data: { goods_id: goods_id },
    //   method: 'post',
    //   header: { 'content-type': 'application/x-www-form-urlencoded' },
    //   success: function (request) {
    var data = { goods_id: goods_id }
    util.request(app.data.httpserver + 'collection/delete', data = data).then(function (request) { 
        wx.showToast({
          title: request.message,
          icon: 'success',
          duration: 2000
        })
        if (request.result == 1) {
          var list  = that.data.list ;
          var new_list = new Array();
          for (var i = 0; i < list.length;i++){
            if (list[i].goods_id != goods_id){
              new_list.push(list[i]);
              }
          }
          that.setData({
            list: new_list
          })
        } 
    })
  },
  goods_info: function (e) {
    var goods_id = e.currentTarget.dataset.goods_id;
    wx.navigateTo({
      url: '../goods/info/info?goods_id=' + goods_id,
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
    var totalPage = this.data.page.totalPage;
    var currentPage = this.data.currentPage;
    if (totalPage > currentPage) {
      currentPage++;
      this.setData({
        currentPage: currentPage,
      })
      // var options = {
      //   currentPage: currentPage,
      // }
      this.onLoad()
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})