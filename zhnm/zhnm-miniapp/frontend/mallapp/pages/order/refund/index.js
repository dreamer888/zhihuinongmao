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
    var order_id = options.order_id;
    var order_detail_id = options.order_detail_id;
    wx.showNavigationBarLoading(); //在标题栏中显示加载
    wx.request({
      url: app.data.httpserver + 'order_refund',
      data: { order_id: order_id, order_detail_id: order_detail_id },
      method: 'post',
      header: wx.getStorageSync('header'),
      success: function (request) {
        console.log(request.data);
        that.setData({
          order: request.data,
        })
      },
      complete: function () {
        wx.hideNavigationBarLoading() //完成停止加载
      }
    }) 
  },
  /**
   * 退款金额
   */
  refund_price(e){
    var refund_price = e.detail.value;
    var pay_total = this.data.order.pay_total;
    refund_price = refund_price.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符  
    refund_price = refund_price.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的  
    refund_price = refund_price.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    refund_price = refund_price.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');//只能输入两个小数  
    if (refund_price.indexOf(".") < 0 && refund_price != "") {//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
      refund_price = parseFloat(refund_price);
    }
    if (parseFloat(refund_price) > parseFloat(pay_total)) {
      refund_price = pay_total;
    }
    this.setData({
      refund_price : refund_price
    })
  },
  
  refund_explain(e){
    var refund_explain = e.detail.value;
    this.setData({
      refund_explain: refund_explain
    })
  },
/**
 * 申请退款
 */
  refund(){
    var refund_price = this.data.refund_price;
    if(refund_price=='') {
      console.log('请输入退款金额');
      return;
    }
    var order_id = this.data.order.order_id;
    var order_detail_id = this.data.order.order_detail_id;
    var refund_explain = this.data.refund_explain;
    wx.showNavigationBarLoading();
    wx.request({
      url: this.data.httpserver +'order/refund',
      type: 'post',
      data: { order_id: order_id, order_detail_id: order_detail_id, refund_price: refund_price, refund_explain: refund_explain },
      header: wx.getStorageSync('header'),
      success: function (request) {
        if (request.data.result == 1) {
          wx.showToast({
            title: request.data.message,
            icon: 'succes',
            duration: 2000,
            mask: true
          })
          setTimeout(function () {
            wx.navigateBack({
              delta: 1
            })
          }, 2000)
        } else {
          wx.showToast({
            title: request.data.message,
            duration: 2000,
            mask: true
          })
        }
      },
      complete: function () {
        wx.hideNavigationBarLoading() //完成停止加载
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