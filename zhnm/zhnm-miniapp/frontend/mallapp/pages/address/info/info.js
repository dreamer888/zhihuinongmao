//index.js
//获取应用实例
var tcity = require("../../../utils/citys.js");
var util = require('../../../utils/util.js');
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
        addr_realname: '',
        // show_user_city:false
        animationAddressMenu: {},
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
        if (msg == 'edit') {
            var address_id = options.address_id
            wx.showNavigationBarLoading();
            var data = {msg: msg, address_id: address_id}
            util.request(app.data.httpserver + 'center/address/info', data = data).then(function (request) {
                wx.hideNavigationBarLoading()
                var info = request.info;
                console.log(info.is_default);
                if (request.result == 1) {
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
                    })
                }
            })

        }
        that.setData({
            msg: msg,
            is_default: 1,

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
            console.log('选择所在地区');
            wx.showToast({
                title: '请选择所在地区',
                duration: 2000
            })
            return;
        }
        var address = that.data.address;
        if (address == '' || typeof (address) == "undefined") {
            wx.showToast({
                title: '请输入详细地址',
                duration: 2000
            })
            return;
        }
        var is_default = that.data.is_default;
        console.log('is_default' + is_default);
        var data = {
            addr_realname: addr_realname,
            addr_phone: addr_phone,
            addr_city: addr_city,
            is_default: is_default,
            address_id: address_id,
            address: address
        }
        util.request(app.data.httpserver + 'address/' + msg, data = data).then(function (request) {
            if (request.result == 1) {
                wx.showToast({
                    title: request.message,
                    icon: 'success',
                    duration: 2500
                })

                wx.navigateBack({
                    delta: 1
                })
            } else if (request.result == 0) {
                wx.showModal({
                    title: '提示',
                    content: request.message,
                    success: function (res) {
                        if (res.confirm) {
                            console.log('用户点击确定')
                        } else if (res.cancel) {
                            console.log('用户点击取消')
                        }
                    }
                })
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
                    // wx.request({
                    //   url: that.data.httpserver + 'address/delete',
                    //   data: { address_id: address_id },
                    //   header: wx.getStorageSync('header'),
                    //   success: function (request) {
                    var data = {address_id: address_id}
                    util.request(app.data.httpserver + 'address/delete', data = data).then(function (request) {
                        wx.showToast({
                            title: request.message,
                            icon: 'succes',
                            duration: 2000,
                            mask: true
                        })
                        setTimeout(function () {
                            wx.navigateBack({
                                delta: 1
                            })
                        }, 2000)
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
        wx.showLoading({
          title: '加载中',
        })
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
        wx.hideLoading();
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
