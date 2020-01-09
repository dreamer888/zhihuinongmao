var app = getApp();
var util = require('../../../utils/util.js');
Page({

    /**
     * 页面的初始数据
     */
    data: {
        inputShowed: false,
        inputVal: "",
        totalPage: 0,
        currentPage: 0,
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        category_id: '',
        super_id: 0,
        gtui: 0,
        gsales: 0,
        gprice: 0,
        goods_name: '',
        goods_name_aga: '',
        goods: {}
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;
        var category_id = options.category_id;
        var super_id = options.super_id;
        var gtui = this.data.gtui;
        var gsales = this.data.gsales;
        var gprice = this.data.gprice;
        var goods_name = options.goods_name;
        if (typeof (category_id) == 'undefined') {
            category_id = this.data.category_id;
        }
        if (typeof (super_id) == 'undefined') {
            super_id = this.data.super_id;
        }
        if (typeof (goods_name) == 'undefined') {
            goods_name = this.data.goods_name;
        }
        var currentPage = this.data.currentPage;
        var goods = this.data.goods;
        wx.showNavigationBarLoading(); //在标题栏中显示加载

        var data = {
            category_id: category_id,
            super_id: super_id,
            gtui: gtui,
            gsales: gsales,
            gprice: gprice,
            goods_name: goods_name,
            currentPage: currentPage,
            location: wx.getStorageSync('location'),
            marketId:wx.getStorageSync('market_id')
        }
        util.request(app.data.httpserver + 'app/goodslist', data = data).then(function (request) {
            if (currentPage <= 1) {
                goods = request.goodslist;
            } else {
                goods = goods.concat(request.goodslist);
            }
            that.setData({
                goods: goods,
                category_id: category_id,
                super_id: super_id,
                goods_name: goods_name,
                inputVal: goods_name,
                page: request.page,
                totalPage: request.page.totalPage,
                currentPage: request.page.currentPage,
                cart_count: request.cart_count,
            })
        })
    },
    goods_info: function (e) {
        var goods_id = e.currentTarget.dataset.goods_id;
        wx.navigateTo({
            url: '../info/info?goods_id=' + goods_id,
        })
    },

    sort_list: function (event) {
        var that = this;
        var gsales = event.currentTarget.dataset.gsales;
        var gprice = event.currentTarget.dataset.gprice;
        var category_id = event.currentTarget.dataset.category_id;
        var super_id = event.currentTarget.dataset.super_id;
        var goods_name = event.currentTarget.dataset.goods_name;
        if (typeof (gsales) == 'undefined') {
            gsales = 0;
        }
        if (typeof (gprice) == 'undefined') {
            gprice = 0;
        }
        if (typeof (goods_name) == 'undefined') {
            goods_name = '';
        }
        that.setData({
            gsales: gsales,
            gprice: gprice,
            category_id: category_id,
            super_id: super_id,
            goods_name: goods_name,
            currentPage: 1,
            inputShowed: false,
        })
        var options = {
            currentPage: 1,
        }
        this.onLoad(options)
    },

    showInput: function () {
        console.log('showInput');
        this.setData({
            inputShowed: true
        });
    },
    hideInput: function () {
        var goods_name_aga = this.data.goods_name_aga;
        console.log('goods_name_aga = ' + goods_name_aga);
        this.setData({
            inputVal: "",
            goods_name: goods_name_aga,
            inputShowed: false
        });
    },
    clearInput: function () {
        console.log("clearInput-------------")
        this.setData({
            inputVal: "",
            goods_name:''
        });
    },
    inputTyping: function (e) {
        var inputVal = e.detail.value;
        var goods_name = this.data.goods_name;
        var goods_name_aga = goods_name;
        console.log('goods_name_aga = ' + goods_name_aga);
        if (inputVal == '') {
            // inputVal = goods_name;
            goods_name='';
        } else {
            goods_name = inputVal;
        }
        this.setData({
            inputVal: inputVal,
            goods_name: goods_name,
            goods_name_aga: goods_name_aga,
        });
    },

    imageLoad: function (e) {
        var imageSize = util.imageUtil(e)
        this.setData({
            imagewidth: imageSize.imageWidth,
            imageheight: imageSize.imageHeight
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
        console.log("onPullDownRefresh--------------")
        wx.stopPullDownRefresh();
        var totalPage = this.data.totalPage;
        var currentPage = this.data.currentPage;
        if (currentPage > 1) {
            currentPage--;
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
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
        var totalPage = this.data.totalPage;
        var currentPage = this.data.currentPage;
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

    }
})