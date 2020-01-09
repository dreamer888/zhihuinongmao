// pages/comment/info.js
var app = getApp();
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
    nullTip: true,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var order_id = options.order_id;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: app.data.httpserver + 'orderDetail/list',
    //   data: { order_id: order_id },
    //   method: 'post',
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    var data = { order_id: order_id }
    util.request(app.data.httpserver + 'orderDetail/list', data = data).then(function (request) { 
        var order_list = request.list
        var img = [];
        var comment_pic = '';
        for (var i = 0; i < order_list.length; i++) {
          order_list[i].comment_title = '5'; 
          order_list[i].img = img;
          order_list[i].comment_pic = comment_pic;
        }
        that.setData({
          order_id: order_id,
          order_list: order_list,
        })
        console.log(order_list);
    })
  },
  /**
   * 星级
   */
  clickstar(e) {
    var index = e.currentTarget.dataset.index
    var comment_title = e.currentTarget.dataset.comment_title
    var order_list = this.data.order_list
    order_list[index].comment_title = comment_title
    this.setData({
      order_list: order_list
    })
  },
  /**
   * 内容
   */
  comment_content(e) {
    var index = e.currentTarget.dataset.index
    var comment_content = e.detail.value
    var order_list = this.data.order_list
    order_list[index].comment_content = comment_content
    this.setData({
      order_list: order_list
    })
  },
  /**
   * 上传
   */
  imgupload(e) {
    var that = this
    var order_list = that.data.order_list
    
    var index = e.currentTarget.dataset.index
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        console.log(res);
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        wx.uploadFile({
          url: app.data.httpserver + 'upload',
          filePath: tempFilePaths[0],
          name: 'file',
          method: 'post',
          header: wx.getStorageSync('header'),
          success: function (request) {
            var data = JSON.parse(request.data);
           
            if (data.result==1){
              var comment_pic = order_list[index].comment_pic
              if (comment_pic == '') {
                comment_pic = data.url
              } else {
                comment_pic = comment_pic + ',' + data.url
              }
              order_list[index].comment_pic = comment_pic;
              order_list[index].img = comment_pic.split(',');
              console.log(order_list);
              that.setData({
                order_list: order_list
              })
            }else{
              that.showTip(data.message);
            }
          }
        })
      }
    })
  },
  /**
   * 提交评价
   */
  comment_add(){
    var that = this;
    var order_id = that.data.order_id;
    var order_list =that.data.order_list
    
    var order = JSON.stringify(order_list)
    // console.log(order);
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    // wx.request({
    //   url: app.data.httpserver + 'comment/add',
    //   data: { order_id: order_id, order: order },
    //   method: 'post',
    //   header: wx.getStorageSync('header'),
    //   success: function (request) {
    var data = { order_id: order_id, order: order }
    util.request(app.data.httpserver + 'comment/add', data = data).then(function (request) { 
        wx.showToast({
          title: request.message,
          icon: 'succes',
          duration: 2000,
        })
        setTimeout(function () {
          wx.navigateBack({
            delta:1
          })
        }, 2000)
    })
  },
  /**
   * 提示
   */
  showTip(tipTxt) {
    var that = this
    that.setData({
      nullTip: false, //弹窗显示
      tipTxt: tipTxt
    })
    setTimeout(function () {
      that.setData({
        nullTip: true,
        tipTxt: tipTxt
      }) //1.5秒之后弹窗隐藏
    }, 1500)
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