// list.js
var app = getApp();
var util = require('../../utils/util.js');
Page({

    /**
     * 页面的初始数据
     */
    data: {
        inputShowed: false,
        inputVal: "",
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        activeIndex: 0,
        sliderOffset: 0,
        sliderLeft: 0,
        showCartCount: false
    },
    onLoad: function () {
        var that = this;
        wx.getSystemInfo({
            success: function (res) {
                that.setData({
                    sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 4,
                    sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
                });
            }
        });
    },
    tabClick: function (e) {
        this.setData({
            sliderOffset: e.currentTarget.offsetLeft,
            activeIndex: e.currentTarget.id
        });
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function () {
        var that = this;
        var data = {
            marketId: wx.getStorageSync('market_id'),
            location:  wx.getStorageSync('location')
        }
        util.request(app.data.httpserver + 'app/category/list', data = data).then(function (request) {
          if (request.cart_count>0){
            that.showCartCount = true;
          }else{
            that.showCartCount = false;
          }
            that.setData({
                category: request.category_list,
                cart_count: request.cart_count,
                showCartCount: that.showCartCount
            })

        })
    },
    search_list: function () {
        var goods_name = this.data.inputVal;
        wx.navigateTo({
            url: '../goods/list/list?goods_name=' + goods_name,
        })
    },
    goods_list: function (e) {
        var category_id = e.currentTarget.dataset.category_id;
        wx.navigateTo({
            url: '../goods/list/list?category_id=' + category_id,
        })
    },
    showInput: function () {
        console.log('showInput');
        this.setData({
            inputShowed: true
        });
    },
    hideInput: function () {
        this.setData({
            inputVal: "",
            inputShowed: false
        });
    },
    clearInput: function () {
        this.setData({
            inputVal: ""
        });
    },
    inputTyping: function (e) {
        this.setData({
            inputVal: e.detail.value
        });
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