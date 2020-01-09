// list.js
var app = getApp();
Page({
    /**
     * 页面的初始数据
     */
    data: {
        totalPage: 0,
        currentPage: 1,
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        order: [],
        tabs: [
            {"tab_name": "全部", tab_index: 11},
            {"tab_name": "待付款", tab_index: 0},
            {"tab_name": "待发货", tab_index: 1},
            {"tab_name": "待收货", tab_index: 2},
            {"tab_name": "待评价", tab_index: 5},
        ],
        activeIndex: 11,
        sliderOffset: 0,
        sliderLeft: 0,
        load_time:1
    },

    tabClick: function (e) {
        console.log("tabClick--------------")
        this.setData({
            sliderOffset: e.currentTarget.offsetLeft,
            activeIndex: e.currentTarget.id,
            order: "",
        });
        this.order_list(e);

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
      console.log("onLoad------------------------------")
        var that = this;
        var currentPage = this.data.currentPage;
        var order = this.data.order;
        var status = options.status;
        console.log("onLoad-status", status)
        var activeIndex = status;
        if (status == 11) {
            status = '';
        }
        that.setData({
            activeIndex: activeIndex,
        })
        wx.showLoading({
            title: '加载中',
        })
        // wx.showNavigationBarLoading(); //在标题栏中显示加载
        wx.request({
            url: app.data.httpserver + 'orderlist',
            data: {currentPage: currentPage, status: status},
            method: 'post',
            header: wx.getStorageSync('header'),
            success: function (request) {
                if (currentPage <= 1) {
                    order = request.data.list;
                } else {
                    order = order.concat(request.data.list);
                }
                that.setData({
                    status: status,
                    order: order,
                    page: request.data.page,
                    totalPage: request.data.page.totalPage,
                    currentPage: request.data.page.currentPage,
                })
                wx.hideNavigationBarLoading() //完成停止加载
            },
            fail: function () {
                if (currentPage > 1) {
                    that.setData({
                        currentPage: currentPage - 1,
                    })
                }
            },
            complete: function () {
                setTimeout(function () {
                    wx.hideLoading();
                }, 500) //延迟时间 这里是1秒
            }
        })
    },
    order_info: function (event) {
        var order_id = event.currentTarget.dataset.order_id;
        wx.navigateTo({
            url: '../info/info?order_id=' + order_id,
        })
    },
    order_list: function (event) {
        console.log("order_list----------------------")
        var status = event.currentTarget.dataset.status;
        console.log("status--" + status);
        this.setData({
            currentPage: 1,
            status: status
        })
        var options = {
            currentPage: 1,
            status: status
        };
        this.onLoad(options);
    },
    /**
     * 物流查询
     */
    express_info(e) {
        var express_num = e.currentTarget.dataset.express_num;
        var express_name = e.currentTarget.dataset.express_name;
        var express_title = e.currentTarget.dataset.express_title;
        wx.navigateTo({
            url: '../express/index?express_num=' + express_num + '&express_name=' + express_name + '&express_title=' + express_title,
        })
    },
    /**
     * 确认收货
     */
    order_sure(e) {
        var that = this
        var order_id = e.currentTarget.dataset.order_id
        var status = that.data.status;
        if (status == '') {
            status = 11;
        }
        wx.showModal({
            title: '确认收货?',
            content: '您确定要确认收货吗?',
            showCancel: true,
            success: function (res) {
                if (res.confirm) {
                    wx.request({
                        url: app.data.httpserver + 'order/status',
                        data: {order_id: order_id, status: 5},
                        header: wx.getStorageSync('header'),
                        success: function (request) {
                            if (request.data.result == 1) {
                                wx.showToast({
                                    icon: 'succes',
                                    duration: 1000,
                                })
                                var options = {order_id, status}
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
     * 去评价
     */
    comment(e) {
        var order_id = e.currentTarget.dataset.order_id;
        wx.navigateTo({
            url: '../../comment/info?order_id=' + order_id,
        })

    },
    /**
     * 删除订单
     */
    delete_order(e) {
        var that = this
        const order_id = e.currentTarget.dataset.order_id;
        const index = e.currentTarget.dataset.index;
        let order = this.data.order;
        wx.showModal({
            title: '确认删除？',
            content: '您确定要删除此订单吗?',
            showCancel: true,
            success: function (res) {
                if (res.confirm) {
                    wx.request({
                        url: that.data.httpserver + 'order/delete',
                        data: {order_id: order_id},
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
                                order.splice(index, 1);
                                wx.showToast({
                                    title: '商品已删除!',
                                    icon: 'succes',
                                    duration: 1000,
                                })
                                that.setData({
                                    order: order
                                })
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
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
        console.log("onReady------------")
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        console.log("info onshow-----")
        var load_time = this.data.load_time;
        console.log("load_time", load_time);
        if (this.data.load_time != 1) {
            this.onPullDownRefresh()
        }
        ++load_time;
        this.setData({
            load_time: load_time
        })
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
        var status = this.data.status;
        if ((!status || status != 0) && (status != undefined && status.length == 0)) {
            status = 11;
        }
        this.setData({
            currentPage: 1,
        })
        var options = {
            currentPage: 1,
            status: status
        }
        this.onLoad(options)
        wx.stopPullDownRefresh();
    },


    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
        var totalPage = this.data.totalPage;
        var currentPage = this.data.currentPage;
        console.log("totalPage", totalPage);
        console.log("currentPage", currentPage);
        if (totalPage > currentPage) {
            currentPage++;
            this.setData({
                currentPage: currentPage,
            })
            var options = {
                currentPage: currentPage,
            }
            this.onLoad(options)
        }
    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    },
})