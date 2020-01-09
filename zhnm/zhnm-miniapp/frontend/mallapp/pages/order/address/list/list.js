var app = getApp()
Page({
    /**
     * 页面的初始数据
     */
    data: {
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        last_data: '',
        first_time: 1
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onShow: function (options) {
        var that = this;
        // var goods_id = options.goods_id;
        // var goods_count = options.goods_count;
        // var cart_id = options.cart_id;
        // var attribute_detail_id = options.attribute_detail_id
        wx.showNavigationBarLoading();
        wx.request({
            url: that.data.httpserver + 'address/list',
            method: 'post',
            header: wx.getStorageSync('header'),
            success: function (request) {
                if (request.data.result == 1) {
                    that.setData({
                        list: request.data.addrlist,
                    })
                }
            },
            complete: function () {
                wx.hideNavigationBarLoading() //完成停止加载
                // that.setData({
                //   first_time: 0
                // })
            }
        })
    },
    address_info: function (e) {
        var msg = e.currentTarget.dataset.msg;
        var address_id = e.currentTarget.dataset.address_id;
        // var goods_id = this.data.goods_id;
        // var goods_count = this.data.goods_count;
        // var cart_id = this.data.cart_id;
        // var attribute_detail_id = this.data.attribute_detail_id
        wx.navigateTo({
            url: '../info/info?msg=' + msg + '&address_id=' + address_id,
            // + '&goods_count=' + goods_count + '&cart_id=' + cart_id + '&attribute_detail_id=' + attribute_detail_id + '&goods_id=' + goods_id,
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
    // onShow: function () {
    // var pages = getCurrentPages();
    // var currPage = pages[pages.length - 1]; //当前页面
    // var options={
    //   goods_id: this.data.last_data.goods_id,
    //   goods_count: this.data.last_data.goods_count,
    //   attribute_detail_id: this.data.last_data.attribute_detail_id,
    //   cart_id: this.data.last_data.cart_id
    // }
    // this.setData({
    //   options: options
    // })
    // if(this.data.first_time!=1){
    //   this.onLoad(options);
    // }
    // },
    /**
     * 返回预支付界面
     */
    payment_info(e) {
        // var address_id = e.currentTarget.dataset.address_id;
        // var pages = getCurrentPages();
        // var prevPage = pages[pages.length - 2];  //上一个页面
        // prevPage.setData({
        //     last_data: {
        //         address_id: address_id,
        //     }
        // })
        // wx.navigateBack({
        //     delta: 1
        // })
        var that = this;
        var address_location = e.currentTarget.dataset.address_location;
        var s = that.distance(address_location);
        if (s > 3) {
            wx.showModal({
                title: '提示',
                content: '您选择的收货地址超出配送范围，请重新选择',
                success: function (res) {
                    if (res.confirm) {
                        console.log('用户点击确定')
                    } else if (res.cancel) {
                        console.log('用户点击取消')
                    }
                }
            })
        } else {
            var address_id = e.currentTarget.dataset.address_id;
            console.log("选择的地址id", address_id);
            var pages = getCurrentPages();
            var prevPage = pages[pages.length - 2];  //上一个页面
            prevPage.setData({
                address_id: address_id,
            })
            wx.navigateBack({
                delta: 1
            })
        }
    },

    distance: function (address_location) {
        let location = wx.getStorageSync('location');
        if (typeof (address_location) == 'undefined' || typeof (location) == 'undefined') return 0;
        let la1 = location.split(",")[1];
        let lo1 = location.split(",")[0];
        let la2 = address_location.split(",")[1];
        let lo2 = address_location.split(",")[0];
        var La1 = la1 * Math.PI / 180.0;
        var La2 = la2 * Math.PI / 180.0;
        var La3 = La1 - La2;
        var Lb3 = lo1 * Math.PI / 180.0 - lo2 * Math.PI / 180.0;
        var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(La3 / 2), 2) + Math.cos(La1) * Math.cos(La2) * Math.pow(Math.sin(Lb3 / 2), 2)));
        s = s * 6378.137;//地球半径
        s = Math.round(s * 10000) / 10000;
        return s
    },
    getRad: function (d) {
        return d * PI / 180.0;
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