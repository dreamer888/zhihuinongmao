//index.js
//获取应用实例
var tcity = require("../../../../utils/citys.js");

var app = getApp()
Page({
    data: {
        provinces: [],
        province: "",
        citys: [],
        city: "",
        countys: [],
        county: '',
        value: [0, 0, 0],
        values: [0, 0, 0],
        condition: false,
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        address_id: '',
        animationAddressMenu: {},
        // show_user_city:false
    },

    onLoad: function (options) {
        var that = this;
        // 初始化动画变量
        var animation = wx.createAnimation({
            duration: 500,
            transformOrigin: "50% 50%",
            timingFunction: 'ease',
        })
        that.animation = animation;

        var msg = options.msg;
        var goods_id = options.goods_id;
        var goods_count = options.goods_count;
        var cart_id = options.cart_id;
        var attribute_detail_id = options.attribute_detail_id
        if (msg == 'edit') {
            var address_id = options.address_id
            wx.showNavigationBarLoading();
            wx.request({
                url: that.data.httpserver + 'center/address/info',
                data: {msg: msg, address_id: address_id},
                header: wx.getStorageSync('header'),
                success: function (request) {
                    var info = request.data.info;
                    console.log(info.is_default);
                    if (request.data.result == 1) {
                        that.setData({
                            address_id: address_id,
                            is_default: info.is_default,
                            addr_realname: info.addr_realname,
                            addr_phone: info.addr_phone,
                            addr_city: info.addr_city,
                            address: info.address,
                            province: info.addr_city,
                            city: '',
                            county: '',
                            // show_user_city:true
                        })
                    }
                },
                complete: function () {
                    wx.hideNavigationBarLoading() //完成停止加载
                }
            })
        }
        that.setData({
            msg: msg,
            is_default: 1,
            goods_id: goods_id,
            goods_count: goods_count,
            cart_id: cart_id,
            attribute_detail_id: attribute_detail_id
        })
    },
    change_default() {
        var that = this;
        var is_default = that.data.is_default;
        if (is_default == 1) {
            is_default = 0;
        } else {
            is_default = 1;
        }
        that.setData({
            is_default: is_default
        })
    },

    addr_add: function (e) {
        var that = this;
        var msg = that.data.msg;
        var address_id = that.data.address_id;
        var addr_realname = that.data.addr_realname;
        var goods_id = that.data.goods_id;
        var goods_count = that.data.goods_count;
        var cart_id = that.data.cart_id;
        var attribute_detail_id = that.data.attribute_detail_id
        if (addr_realname == '' || typeof (addr_realname) == "undefined") {
            wx.showToast({
                title: '请填写收货人',
                duration: 2000
            })
            return;
        }
        var addr_phone = that.data.addr_phone;
        if (addr_phone == '' || typeof (addr_phone) == "undefined") {
            wx.showToast({
                title: '请填写手机号',
                duration: 2000
            })
            return;
        }
        var addr_city = that.data.province + ' ' + that.data.city + ' ' + that.data.county;

        if (addr_city == '' || typeof (addr_city) == "undefined") {
            wx.showToast({
                title: '请选择所在地区',
                duration: 2000
            })
            return;
        }
        var address = that.data.address;
        if (address == '' || typeof (address) == "undefined") {
            wx.showToast({
                title: '请输入地址',
                duration: 2000
            })
            return;
        }
        var is_default = that.data.is_default;
        wx.request({
            url: that.data.httpserver + 'address/' + msg,
            data: {
                addr_realname: addr_realname,
                addr_phone: addr_phone,
                addr_city: addr_city,
                is_default: is_default,
                address_id: address_id,
                address: address
            },
            header: wx.getStorageSync('header'),
            success: function (request) {
                if (request.data.result == 1) {
                    wx.showToast({
                        title: request.data.message,
                        icon: 'success',
                        duration: 2500
                    })
                    var pages = getCurrentPages();
                    var prevPage = pages[pages.length - 2];  //上一个页面
                    prevPage.setData({
                        last_data: {
                            goods_id: goods_id,
                            goods_count: goods_count,
                            cart_id: cart_id,
                            attribute_detail_id: attribute_detail_id
                        }
                    })
                    wx.navigateBack({
                        delta: 1
                    })
                } else if (request.data.result == 0) {
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
    addr_realname(e) {
        var that = this;
        var addr_realname = e.detail.value
        console.log(addr_realname);
        that.setData({
            addr_realname: addr_realname,
        })
    },
    addr_phone(e) {
        var that = this;
        var addr_phone = e.detail.value
        if (addr_phone.length == 11) {
            var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
            if (!myreg.test(addr_phone)) {
                console.log('手机号不合法');
                return;
            }
        } else if (addr_phone.length > 11) {
            console.log('手机号不合法');
        }
        console.log(addr_phone);
        that.setData({
            addr_phone: addr_phone,
        })
    },
    /**
     * 删除
     */
    address_delete() {
        var that = this;
        var address_id = that.data.address_id;
        wx.showModal({
            title: '确认删除?',
            content: '您确定要删除此收货地址吗?',
            success: function (res) {
                if (res.confirm) {
                    wx.request({
                        url: that.data.httpserver + 'address/delete',
                        type: 'post',
                        data: {address_id: address_id},
                        header: wx.getStorageSync('header'),
                        success: function (request) {
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
                        }
                    })
                } else {
                    console.log('用户点击取消')
                }
            }
        })
    },
    address(e) {
        var that = this;
        var address = e.detail.value
        console.log(address);
        that.setData({
            address: address,
        })
    },
    onShow: function () {
        var that = this;
        tcity.init(that);
        var cityData = that.data.cityData;
        const provinces = [];
        const citys = [];
        const countys = [];
        for (let i = 0; i < cityData.length; i++) {
            provinces.push(cityData[i].name);
        }
        console.log('省份完成');
        for (let i = 0; i < cityData[0].sub.length; i++) {
            citys.push(cityData[0].sub[i].name)
        }
        console.log('city完成');
        for (let i = 0; i < cityData[0].sub[0].sub.length; i++) {
            countys.push(cityData[0].sub[0].sub[i].name)
        }

        that.setData({
            'provinces': provinces,
            'citys': citys,
            'countys': countys,
            'province': cityData[0].name,
            'city': cityData[0].sub[0].name,
            'county': cityData[0].sub[0].sub[0].name
        })
        console.log('初始化完成');
    },
    bindChange: function (e) {
        //console.log(e);
        var val = e.detail.value
        var t = this.data.values;
        var cityData = this.data.cityData;
        // this.setData({
        //   show_user_city:false
        // })
        if (val[0] != t[0]) {
            console.log('province no ');
            const citys = [];
            const countys = [];

            for (let i = 0; i < cityData[val[0]].sub.length; i++) {
                citys.push(cityData[val[0]].sub[i].name)
            }
            for (let i = 0; i < cityData[val[0]].sub[0].sub.length; i++) {
                countys.push(cityData[val[0]].sub[0].sub[i].name)
            }

            this.setData({
                province: this.data.provinces[val[0]],
                city: cityData[val[0]].sub[0].name,
                citys: citys,
                county: cityData[val[0]].sub[0].sub[0].name,
                countys: countys,
                values: val,
                value: [val[0], 0, 0]
            })

            return;
        }
        if (val[1] != t[1]) {
            console.log('city no');
            const countys = [];

            for (let i = 0; i < cityData[val[0]].sub[val[1]].sub.length; i++) {
                countys.push(cityData[val[0]].sub[val[1]].sub[i].name)
            }

            this.setData({
                city: this.data.citys[val[1]],
                county: cityData[val[0]].sub[val[1]].sub[0].name,
                countys: countys,
                values: val,
                value: [val[0], val[1], 0]
            })
            return;
        }

        if (val[2] != t[2]) {
            console.log('county no');
            this.setData({
                county: this.data.countys[val[2]],
                values: val
            })
            return;
        }


    },
    open: function () {
        // this.startAddressAnimation(true)
        this.setData({
            condition: true//!this.data.condition
        })
    },
    close: function () {
        // this.startAddressAnimation(false)
        this.setData({
            condition: false
        })
    },

    // 执行动画
    startAddressAnimation: function (isShow) {
        console.log(isShow)
        var that = this
        if (isShow) {
            // vh是用来表示尺寸的单位，高度全屏是100vh
            that.animation.translateY(0 + 'px').step()
        } else {
            that.animation.translateY(300 + 'px').step()
        }
        that.setData({
            animationAddressMenu: that.animation.export(),
            condition: isShow,
        })
    },
})
