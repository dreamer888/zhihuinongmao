var app = getApp();
Page({
    /**
     * 页面的初始数据
     */
    data: {
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        actionSheetHidden: true,
        menu: '',
        load_time: 0,
        multiIndex: [0, 0],
        multiArray: [[''], ['']],
        deliveryDate: [],
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this
        var goods_id = options.goods_id;
        var goods_count = options.goods_count;
        var cart_id = options.cart_id;
        var attribute_detail_id = options.attribute_detail_id;
        var address_id = options.address_id;
        if (typeof (address_id) == 'undefined' || address_id == '') {
            address_id = wx.getStorageSync("address_id");
        }
        console.log("address_id----------------------", address_id)
        wx.request({
            url: that.data.httpserver + 'toorder',
            data: {
                goods_id: goods_id,
                goods_count: goods_count,
                cart_id: cart_id,
                attribute_detail_id: attribute_detail_id,
                address_id: address_id,
                marketId: wx.getStorageSync("market_id")
            },
            header: wx.getStorageSync('header'),
            success: function (request) {
                console.log('获取预支付订单信息' + JSON.stringify(request));
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
                    var list = request.data.list;
                    for (var i = 0; i < list.length; i++) {
                        var goods_price = list[i].goods_price;
                        list[i].goods_price = goods_price.toFixed(2)
                    }
                    var couponlist = request.data.couponlist;
                    for (var i = 0; i < couponlist.length; i++) {
                        var coupon_price = couponlist[i].coupon_price;
                        couponlist[i].coupon_price = coupon_price.toFixed(2)
                    }
                    var coupon = request.data.coupon;
                    if (Object.keys(coupon).length != 0) {
                        if (coupon.coupon_id != 0) {
                            coupon.coupon_price = coupon.coupon_price.toFixed(2);
                        }
                    }

                    that.setData({
                        pd: request.data.pd,
                        list: list,
                        address: request.data.address,
                        freight_price: request.data.freight_price,
                        couponlist: couponlist,
                        coupon: request.data.coupon,
                        coupon_count: request.data.coupon_count,
                        order_total: request.data.order_total.toFixed(2),
                    })
                }
            },
            fail: function () {
                console.log(1);
            }
        })
        var load_time = that.data.load_time;
        ++load_time
        that.setData({
            load_time: load_time
        })
        console.log(".load_time= " + load_time);
    },
    actionSheetTap: function () {
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden
        })
    },
    actionSheetbindchange: function () {
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden
        })
    },
    /**
     * 更改优惠券
     */
    chose_coupon(e) {
        var that = this
        var goods_id = e.currentTarget.dataset.goods_id;
        var goods_count = e.currentTarget.dataset.goods_count;
        var attribute_detail_id = e.currentTarget.dataset.attribute_detail_id;
        var coupon_id = e.currentTarget.dataset.coupon_id;
        var coupon_name = e.currentTarget.dataset.coupon_name;
        wx.showLoading();
        wx.request({
            url: that.data.httpserver + 'order_total',
            type: 'post',
            header: wx.getStorageSync('header'),
            data: {
                coupon_id: coupon_id,
                goods_id: goods_id,
                goods_count: goods_count,
                attribute_detail_id: attribute_detail_id
            },
            success: function (request) {
                console.log(request.data);
                wx.hideLoading();
                var coupon = request.data.coupon
                if (coupon.coupon_id != 0) {
                    coupon.coupon_price = coupon.coupon_price.toFixed(2)
                }
                that.setData({
                    coupon: coupon,
                    order_total: request.data.order_total.toFixed(2),
                    actionSheetHidden: true,
                })
            }
        })

    },
    /**
     * 提交订单
     */
    add_order(e) {
        var that = this;
        var attribute_detail_id = that.data.pd.attribute_detail_id;
        if (typeof (that.data.address) == 'undefined' || that.data.address == null || that.data.address.address_id == '' || that.data.address.address_id == null) {
            wx.showModal({
                title: '提示',
                content: '请添加收货地址'
            })
            return;
        }
        var address_id = that.data.address.address_id;
        var cart_id = that.data.pd.cart_id;
        var goods_id = that.data.pd.goods_id;
        var goods_count = that.data.pd.goods_count;
        var coupon_id = that.data.coupon.coupon_id;
        var remark = that.data.remark;
        var delivery_time_slice = that.data.time;
        if (coupon_id == '' || coupon_id == null) {
            coupon_id = 0;
        }
        if (typeof (remark) == 'undefined') {
            remark = '';
        }
        if (typeof (delivery_time_slice) == 'undefined') {
            delivery_time_slice = '';
        }
        var pay_way = 2;
        wx.showLoading();
        wx.request({
            url: that.data.httpserver + 'addorder',
            type: 'post',
            data: {
                coupon_id: coupon_id,
                goods_id: goods_id,
                goods_count: goods_count,
                cart_id: cart_id,
                address_id: address_id,
                pay_way: pay_way,
                attribute_detail_id: attribute_detail_id,
                remark: remark,
                delivery_time_slice: delivery_time_slice,
                marketId: wx.getStorageSync("market_id")
            },
            header: wx.getStorageSync('header'),
            success: function (request) {
                wx.hideLoading();
                if (request.data.result == 1) {
                    if (pay_way == 3) {
                        wx.navigateTo({
                            url: order / result,
                        })
                    }
                    else if (pay_way == 2) {
                        wx.requestPayment(
                            {
                                'timeStamp': request.data.return_pay.timeStamp,
                                'nonceStr': request.data.return_pay.nonceStr,
                                'package': request.data.return_pay.package,
                                'signType': 'MD5',
                                'paySign': request.data.return_pay.paySign,
                                'success': function (res) {
                                    console.log("支付成功", res)
                                    wx.redirectTo({
                                        url: '../list/list',
                                    })
                                },
                                'fail': function (res) {
                                    console.log("支付失败", res)
                                    wx.redirectTo({
                                        url: '../list/list',
                                    })
                                },
                                'complete': function (res) {
                                }
                            })
                    }
                } else if (request.data.result == 0 || request.data.result == 2 || request.data.result == 3) {
                    wx.showModal({
                        title: '提示',
                        content: request.data.message,
                        success: function (res) {
                            if (res.confirm) {
                                console.log('用户点击确定')
                            } else if (res.cancel) {
                                console.log('用户点击取消')
                            }
                        }
                    })
                }
            }
        })
    },
    remark(e) {
        var that = this;
        var remark = e.detail.value
        console.log(remark);
        that.setData({
            remark: remark,
        })
    },
    /**
     * 地址列表
     */
    address_list() {
        // var goods_id = this.data.pd.goods_id;
        // var goods_count = this.data.pd.goods_count;
        // var cart_id = this.data.pd.cart_id;
        // var attribute_detail_id = this.data.pd.attribute_detail_id
        wx.navigateTo({
            url: '../address/list/list',
        })
    },
    getDeliveryDate() {
        var that = this;
        console.log("getDeliveryDate---------------")
        wx.showNavigationBarLoading(); //在标题栏中显示加载
        // wx.showLoading({
        //     title: '加载中',
        // })
        wx.request({
            url: app.data.httpserver + 'deliveryDate',
            method: 'get',
            header: wx.getStorageSync('header'),
            success: function (request) {
                console.log('时间获取成功', JSON.stringify(request))
                if (request != undefined && request.data.data != undefined) {
                    if (request.data.result == 1) {
                        console.log('request.data.result == 1')
                        that.deliveryDate = request.data.data;
                        var list = []
                        for (var i = 0; i < that.deliveryDate.length; i++) {
                            console.log('request--', that.deliveryDate[i].day)
                            list.push(that.deliveryDate[i].day)
                        }
                        console.log('that.deliveryDate[0].times', that.deliveryDate[0].times)
                        that.setData({
                            multiArray: [list, that.deliveryDate[0].times]
                        })
                    } else if (request.data.result == 1005) {
                        console.log('request.data.result == 1005')
                        //尚未登录，跳转到登录界面
                        wx.redirectTo({
                            url: '/pages/welcome/index'
                        })
                    } else {
                        console.log('request.data.result == 其他')
                        wx.showModal({
                            title: '提示',
                            content: request.data.message,
                            success: function (res) {
                                if (res.confirm) {
                                    console.log('用户点击确定')
                                } else if (res.cancel) {
                                    console.log('用户点击取消')
                                }
                            }
                        })
                    }
                }
            },
            fail: function () {
                console.log('时间获取失败')
            },
            complete: function () {
                wx.hideNavigationBarLoading() //完成停止加载
                // wx.hideLoading();
            }
        })
    },
    bindMultiPickerChange: function (e) {
        var that = this;
        that.setData({
            "multiIndex[0]": e.detail.value[0],
            "multiIndex[1]": e.detail.value[1],
            time: that.deliveryDate[e.detail.value[0]].time + " " + that.deliveryDate[e.detail.value[0]].times[e.detail.value[1]]
        })
    },
    bindMultiPickerColumnChange: function (e) {
        console.log("bindMultiPickerColumnChange----------")
        var that = this;
        console.log("e----------", e.detail.value);
        switch (e.detail.column) {
            case 0:
                var list = [];
                if (that.deliveryDate != undefined) {
                    for (var i = 0; i < that.deliveryDate.length; i++) {
                        if (i == e.detail.value) {
                            list = that.deliveryDate[i].times
                        }
                    }
                }
                that.setData({
                    "multiArray[1]": list,
                    "multiIndex[0]": e.detail.value,
                    "multiIndex[1]": 0
                })
                break;

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
        console.log("info onshow-----")
        var load_time = this.data.load_time;
        console.log("load_time", load_time);
        if (this.data.load_time != 1) {
            var pages = getCurrentPages();
            var currPage = pages[pages.length - 1]; //当前页面
            console.log("currPage_address_id", currPage.data.address_id);
            var options = {
                goods_id: this.data.pd.goods_id,
                goods_count: this.data.pd.goods_count,
                attribute_detail_id: this.data.pd.attribute_detail_id,
                cart_id: this.data.pd.cart_id,
                address_id: currPage.data.address_id,
            }
            this.onLoad(options);
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