// info.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httphost: app.data.httphost,
    httpserver: app.data.httpserver,
    order_id:''

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.order_id = options.order_id;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    wx.request({
      url: app.data.httpserver + 'order',
      data: { order_id: that.order_id },
      method: 'post',
      header: wx.getStorageSync('header'),
      success: function (request) {
        console.log(request.data.order);
        that.setData({
          order: request.data.order,
          orderdetail: request.data.orderdetail,
        })
      },
      complete: function () {
        wx.hideNavigationBarLoading() //完成停止加载
      }
    })
  },
  order_refund: function (event) {
    var order_id = event.currentTarget.dataset.order_id;
    var order_detail_id = event.currentTarget.dataset.order_detail_id;
    wx.navigateTo({
      url: '../refund/index?order_id=' + order_id + '&order_detail_id=' + order_detail_id,
    })
  },
  /**
   * 物流查询
   */
  express_info() {
    var express_num = this.data.order.express_num;
    var express_name = this.data.order.express_name;
    var express_title = this.data.order.express_title;
    wx.navigateTo({
      url: '../express/index?express_num=' + express_num + '&express_name=' + express_name + '&express_title=' + express_title,
    })
  },
  /**
   * 付款
   */
  get_order() {
    var pay_way = 2;
    var order_id = this.data.order.order_id;
    wx.showNavigationBarLoading();
    wx.request({
      url: this.data.httpserver + 'getorder',
      type: 'post',
      data: { order_id: order_id, pay_way: pay_way },
      header: wx.getStorageSync('header'),
      success: function (request) {
        if (request.data.result == 1) {
          if (pay_way == 2) {
            wx.requestPayment(
              {
                'timeStamp': request.data.return_pay.timeStamp,
                'nonceStr': request.data.return_pay.nonceStr,
                'package': request.data.return_pay.package,
                'signType': 'MD5',
                'paySign': request.data.return_pay.paySign,
                'success': function (res) {
                  wx.navigateBack({
                    delta: 1
                  })
                },
                'fail': function (res) { },
                'complete': function (res) { }
              })

          }
        } else {
          wx.showModal({
            title: '提示',
            showCancel: false,
            content: request.data.message,
            
          })
        }
      },
      complete: function () {
        wx.hideNavigationBarLoading() //完成停止加载
      }
    })
  },
  /**
   * 确认收货
   */
  order_sure() {
    var that = this
    var status = 5;
    var order_id = this.data.order.order_id
    wx.showModal({
      title: '确认收货?',
      content: '您确定要确认收货吗?',
      showCancel: true,
      success: function (res) {
        if (res.confirm) {

          wx.request({

            url: app.data.httpserver + 'order/status',
            data: { order_id: order_id, status: status },
            header: wx.getStorageSync('header'),
            success: function (request) {
              if (request.data.result == 1) {
                wx.showToast({
                  icon: 'succes',
                  duration: 1000,
                })
                var options = { order_id }
                setTimeout(function () {
                  that.onLoad(options)
                }, 1000)
              }
            }
          })
        }
      }
    })
  },
  /**
   * 删除订单
   */
  delete_order() {
    var that = this
    const order_id = this.data.order.order_id;
    wx.showModal({
      title: '确认删除？',
      content: '您确定要删除此订单吗?',
      showCancel: true,
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: that.data.httpserver + 'order/delete',
            data: { order_id: order_id },
            header: wx.getStorageSync('header'),
            success: function (request) {
              console.log(request.data);
              if (request.data.result == 1005) {
                wx.showModal({
                  title: '提示',
                  content: request.data.message,
                  showCancel: false,
                  success: function (res) {
                    if (res.confirm) {
                    }
                  }
                })
              } else {
                wx.showToast({
                  title: '商品已删除!',
                  icon: 'succes',
                  duration: 1000,
                })
                setTimeout(function () {
                  wx.navigateBack({
                    delta: 1
                  })
                }, 1000)
              }
            },
            fail: function () {
              console.log(1);
            }
          })
        }
      }
    })
  },
  /**
   * 去评价
   */
  comment(){
    wx.navigateTo({
      url: '../../comment/info?order_id='+this.order_id,
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
      console.log("onPullDownRefresh--------------")
      var options = {
          order_id:this.order_id
      }
      this.onLoad(options)
    wx.stopPullDownRefresh();
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