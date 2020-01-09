var app = getApp()
var util = require('../../../utils/util.js');
Page({
    /**
     * 页面的初始数据
     */
    data: {
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        fromIndex: 0
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;
        if (typeof (options) != "undefined") {
            that.fromIndex = options.fromIndex;
        }
        wx.showNavigationBarLoading();
        // wx.request({
        //   url: that.data.httpserver + 'address/list',
        //   header: wx.getStorageSync('header'),
        //   success: function (request) {
        util.request(app.data.httpserver + 'address/list').then(function (request) {
            if (request.result == 1) {
                that.setData({
                    list: request.addrlist,
                })
            }
        })
    },
    address_info: function (e) {
        console.log("address_info----")
        var msg = e.currentTarget.dataset.msg;
        var address_id = e.currentTarget.dataset.address_id;
        console.log("msg----",msg)
        console.log("address_id----",address_id)
        wx.navigateTo({
            url: '../info/info?msg=' + msg + '&address_id=' + address_id,
        })
    },
    address_back: function (e) {
        var that = this;
        if (that.fromIndex == 1) {
            var address_name = e.currentTarget.dataset.address_name;
            var address_id = e.currentTarget.dataset.address_id;
            var location =  e.currentTarget.dataset.address_location;
            let pages = getCurrentPages();//当前页面
            let prevPage = pages[pages.length - 2];//上一页面
            prevPage.setData({//直接给上移页面赋值
                address_back_name: address_name,
                address_back_id: address_id,
                backFrom:'fromAddress',
                location:location
            });
            wx.navigateBack({
                delta: 1
            })
            // wx.navigateTo({
            //     url: '../../index/index?address_name=' + address_name + '&address_id=' + address_id,
            // })
        }
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
        this.onLoad();
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