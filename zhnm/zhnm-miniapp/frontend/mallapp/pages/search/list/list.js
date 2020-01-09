var app = getApp()
var util = require('../../../utils/util.js');
Page({
    /**
     * 页面的初始数据
     */
    data: {
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        inputShowed: false,
        inputVal: "",
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log("onLoad-------------")
    },
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    // onShow: function () {
    //     this.onLoad();
    // },

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
    search_list: function () {
        var goods_name = this.data.inputVal;
        wx.navigateTo({
            url: '../../goods/list/list?goods_name=' + goods_name,
        })
    },
})