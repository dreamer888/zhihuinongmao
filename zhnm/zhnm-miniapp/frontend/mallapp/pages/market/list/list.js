var app = getApp()
var util = require('../../../utils/util.js');
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
        console.log("onLoad-------------")
        var that = this;
        wx.showNavigationBarLoading(); //在标题栏中显示加载
        let location = wx.getStorageSync('location');
        var data = {location: location}
        util.request(app.data.httpserver + 'markets', data = data).then(function (request) {
            that.setData({
                marketlist: request.marketList
            })
        })
    },
    /**
     * 返回首页
     * @param e
     */
    index_info: function (e) {
        var market_id = e.currentTarget.dataset.market_id;
        var market_name = e.currentTarget.dataset.market_name;
        let pages = getCurrentPages();//当前页面
        let prevPage = pages[pages.length - 2];//上一页面
        prevPage.setData({//直接给上移页面赋值
            market_id: market_id,
            market_name: market_name,
            backFrom: 'fromMarket'
        });
        wx.navigateBack({
            delta: 1
        })
    },
    formatting_time: function (time) {
        console.log("formatting_time",time)
        var date = new Date(time);
        console.log("时:分",date.getHours() + ":" + (date.getMinutes()))
        return date.getHours() + ":" + (date.getMinutes());
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
    marketOpendTime:function (time) {
        console.log("formatting_time",time)
        var date = new Date(time);
        console.log("时:分",date.getHours() + ":" + (date.getMinutes()))
        return date.getHours() + ":" + (date.getMinutes());
    }
})