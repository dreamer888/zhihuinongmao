var util = require('../../utils/util.js');
var amapFile = require('../../static/lib/amap-wx.js');//如：..­/..­/libs/amap-wx.js
var Empty = require("../../empty/constant/EmptyConstant.js");
var app = getApp();

/*var swiper = require("../../static/js/swiper.js");*/

Page({
    /**
     * 页面的初始数据
     */
    data: {
        inputShowed: false,
        inputVal: "",
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        address: "",
        marketlist: [],
        market_id: "",
        market_name: "",
        noDataShowed: false,
        load_time: 1,
        address_back_name: '',
        address_back_id: '',
        backFrom: '',
        emptyType: Empty.content,
        footMenuHidden: false,
        showCartCount:false
    },


    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;
        if (typeof (options) != 'undefined' && typeof (options.market_id) != 'undefined') {
            console.log("首页--选择菜市场返回", options);
            //选择菜市场返回
            wx.setStorageSync("market_id", options.market_id);
            wx.setStorageSync("market_name", options.market_name);
            that.setData({
                market_name: options.market_name,
                address: wx.getStorageSync('address'),
                noDataShowed: true
            })
            that.getIndexData();
        } else if (typeof (options) != 'undefined' && typeof (options.address_id) != 'undefined') {
            //收货地址返回
            console.log("首页--收货地址返回", options);
            //保存地址信息
            wx.setStorageSync("address_id", options.address_id);
            wx.setStorageSync("address", options.address_name);
            wx.setStorageSync("market_id", "");
            wx.setStorageSync("market_name", "");
            wx.setStorageSync("location", options.location);

            if (typeof (options.location) != 'undefined') {
                that.getIndexData();
            } else if (typeof (options.address_name) != 'undefined') {
                that.getLocalInfo(options.address_name);
            }

        } else if (typeof (wx.getStorageSync("market_id")) != 'undefined' && wx.getStorageSync("market_id") != null && wx.getStorageSync("market_id") != '') {
            //从别的页面切换回来
            console.log("首页--market_id");
            that.setData({
                address: wx.getStorageSync("address"),
                market_name: wx.getStorageSync("market_name"),
                noDataShowed: true
            })
            that.getIndexData();
        } else {
            console.log("首页--首次进入");
            var myAmapFun = new amapFile.AMapWX({key: 'dc5739239aefb001a5e809f8f8fe5658'});
            myAmapFun.getRegeo({
                success: function (data) {
                    // 成功回调
                    console.log("成功回调", data)
                    wx.setStorageSync("address_id", "");
                    wx.setStorageSync("address", data[0].name);
                    wx.setStorageSync("location", data[0].longitude + "," + data[0].latitude);
                    that.setData({
                        address: data[0].name,
                    });
                    that.getIndexData(); //获取首页位置
                    that.setData({
                        emptyType: Empty.content,
                        footMenuHidden: false
                    })
                },
                fail: function (info) {
                    //失败回调
                    console.log(info)
                    that.setData({
                        emptyType: Empty.location_error,
                        footMenuHidden: true
                    })
                }
            })
        }
    },
    /**
     * 获取地理位置
     */
    getLocalInfo: function (address) {
        let that = this
        var localUrl = "https://restapi.amap.com/v3/geocode/geo?address=" + address + "&key=5ee2e267d8a2b36cf1c19cd7bd331a3e"
        console.log('localUrl==>' + localUrl)
        wx.request({
            url: localUrl,
            success: function (request) {
                wx.setStorageSync("address", request.data.geocodes[0].formatted_address);
                wx.setStorageSync("location", request.data.geocodes[0].location);
                that.setData({
                    address: request.data.geocodes[0].formatted_address
                })
                that.getIndexData();
            },
            fail: function (request) {
            }
        })
    },
    getIndexData: function () {
        var that = this;
        var data = {
            marketId: wx.getStorageSync("market_id"),
            location: wx.getStorageSync("location")
        }
        util.request(app.data.httpserver + 'index', data = data).then(function (request) {
            if (request.result === 1) {
                var banner = request.bannerlist
                var navigation = request.navigationlist
                //组合轮播图片
                for (var i = 0; i < banner.length; i++) {
                    var app_url = banner[i].app_url
                    var attr_value = '';
                    if (typeof (app_url) != 'undefined' && app_url.indexOf('/') != -1) {
                        banner[i].app_url = app_url.split('/')[0];
                        // var attr_name_value = app_url.split('?')[1].split('=');
                        var attr_value = app_url.split('/')[1];
                    }
                    banner[i].attr_value = attr_value;
                }
                //组合导航分类
                for (var i = 0; i < navigation.length; i++) {
                    var navigation_app_url = navigation[i].navigation_app_url
                    var navigation_attr_value = '';
                    if (typeof (navigation_app_url) != 'undefined' && navigation_app_url.indexOf('/') != -1) {
                        navigation[i].navigation_app_url = navigation_app_url.split('/')[0];
                        // var attr_name_value = navigation_app_url.split('?')[1].split('=');
                        navigation_attr_value = navigation_app_url.split('/')[1];
                    }
                    navigation[i].navigation_attr_value = navigation_attr_value;
                }
                that.marketlist = request.marketlist;
                if (request.cart_count > 0){
                  that.showCartCount = true;
                }else{
                  that.showCartCount = false;
                }
                that.setData({
                    banner: banner,
                    navigation: navigation,
                    news: request.newslist,
                    tuijian: request.tuijianlist,
                    goods: request.goodslist,
                    cart_count: request.cart_count,
                    marketlist: request.marketlist,
                    showCartCount: that.showCartCount

                })
                if (that.marketlist != null && that.marketlist.length) {
                    that.setData({
                        noDataShowed: true,
                        market_name: that.marketlist[0].marketName
                    })
                    wx.setStorageSync("market_id", that.marketlist[0].id);
                    wx.setStorageSync("market_name", that.marketlist[0].marketName);
                } else if (typeof (wx.getStorageSync("market_id")) == 'undefined' || wx.getStorageSync("market_id") == '' || that.marketlist == null || that.marketlist == 'null') {
                    that.setData({
                        noDataShowed: false,
                    })
                    wx.setStorageSync("market_id", "");
                    wx.setStorageSync("market_name", "");
                }
            } else if (request.result === 1005) {
                wx.redirectTo({
                    url: '/pages/welcome/index'
                })
            }
        })
    },
    bannerLoad: function (e) {
        var imageSize = util.imageUtil(e)
        this.setData({
            bannerwidth: imageSize.imageWidth,
            bannerheight: imageSize.imageHeight
        })
    },
    imageLoad: function (e) {
        var imageSize = util.util(e)
        this.setData({
            imagewidth: imageSize.imageWidth,
            imageheight: imageSize.imageHeight
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

    news_list: function () {
        wx.navigateTo({
            url: '../news/list/list'
        })
    },
    index: function () {
        wx.navigateTo({
            url: 'index'
        })
    },
    goods_list: function (e) {
        var category_id = e.currentTarget.dataset.category_id
        wx.navigateTo({
            url: '../goods/list/list?category_id=' + category_id,
        })
    },
    search_list: function () {
        var goods_name = this.data.inputVal;
        wx.navigateTo({
            url: '../goods/list/list?goods_name=' + goods_name,
        })
    },
    banner_info: function (e) {
        console.log("banner_info");
        var type = e.currentTarget.dataset.type;
        console.log('goods_id->' + goods_id);
        if (type == 1) {
            var goods_id = e.currentTarget.dataset.goods_id;
            wx.navigateTo({
                url: '../goods/info/info?goods_id=' + goods_id,
            })
        } else if (type == 2) {
            var url = e.currentTarget.dataset.url;
            wx.navigateTo({
                url: '../h5/info/info?url=' + url,
            })
        }
    },
    goods_info: function (e) {
        var goods_id = e.currentTarget.dataset.goods_id;
        console.log('goods_id->' + goods_id);
        wx.navigateTo({
            url: '../goods/info/info?goods_id=' + goods_id,
        })
    },
    coupon_list() {
        wx.navigateTo({
            url: '../coupon/list/list',
        })
    },
    entitycard_index() {
        wx.navigateTo({
            url: '../entitycard/index',
        })
    },
    giftcard_index() {
        wx.navigateTo({
            url: '../giftcard/index/index',
        })
    },
    addr_list() {
        wx.navigateTo({
            url: '../address/list/list?fromIndex=1',
        })
    },
    to_market_list() {
        wx.navigateTo({
            url: '../market/list/list'
        })
    },
    to_search() {
        wx.navigateTo({
            url: '../search/list/list',
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
        console.log("onShow-------------------")
        var load_time = this.data.load_time;
        console.log("load_time-------------------", load_time)
        if (this.data.load_time != 1) {
            var pages = getCurrentPages();
            var currPage = pages[pages.length - 1]; //当前页面
            var options = {};
            if (currPage.data.backFrom == "fromAddress") {
                console.log("backFrom---", "fromAddress")
                this.setData({
                    address: currPage.data.address_back_name
                })
                //从选择地址返回
                options = {
                    address_name: currPage.data.address_back_name,
                    address_id: currPage.data.address_back_id,
                    location: currPage.data.location
                };
            } else if (currPage.data.backFrom == "fromMarket") {
                //从选择菜市场返回
                console.log("backFrom---", "fromMarket")
                options = {
                    market_id: currPage.data.market_id,
                    market_name: currPage.data.market_name,
                }
            }
            this.onLoad(options);
        }
        ++load_time;
        this.setData({
            load_time: load_time
        })
        console.log(".load_time= " + load_time);
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

    },
    scanCode: function () {
        wx.navigateTo({
            url: '../coupon/list/list',
        })
    },
    emptyCallback: function (event) {
        var emptyType = event.detail.emptyType;
        if (emptyType == Empty.location_error) {
          this.reauthorization();
          // console.log("定位失败，重新定位");
          // var myAmapFun = new amapFile.AMapWX({ key: 'dc5739239aefb001a5e809f8f8fe5658' });
          // myAmapFun.getRegeo({
          //   success: function (data) {
          //     // 成功回调
          //     console.log("成功回调", data)
          //     wx.setStorageSync("address_id", "");
          //     wx.setStorageSync("address", data[0].name);
          //     wx.setStorageSync("location", data[0].longitude + "," + data[0].latitude);
          //     that.setData({
          //       address: data[0].name,
          //     });
          //     that.getIndexData(); //获取首页位置
          //     that.setData({
          //       emptyType: Empty.content,
          //       footMenuHidden: false
          //     })
          //   },
          //   fail: function (info) {
          //     //失败回调
          //     console.log(info)
          //     that.setData({
          //       emptyType: Empty.location_error,
          //       footMenuHidden: true
          //     })
          //   }
          // })
            // this.onLoad();
        } else if (emptyType == Empty.empty) {
            //重新加载
            this.onLoad();
            // wx.showToast({
            //     title: '数据为空中的按钮',
            //     icon: 'none',
            //     duration: 2000
            // })
        }
    },
    reauthorization(){
      var that = this;
      wx.getSetting({
        success: (res) => {
          console.log(res);
          console.log(res.authSetting['scope.userLocation']);
          if (res.authSetting['scope.userLocation'] != undefined && res.authSetting['scope.userLocation'] != true) {//非初始化进入该页面,且未授权
            wx.showModal({
              title: '是否授权当前位置',
              content: '需要获取您的地理位置，请确认授权，否则定位功能将无法使用',
              success: function (res) {
                if (res.cancel) {
                  console.info("1授权失败返回数据");

                } else if (res.confirm) {
                  //village_LBS(that);
                  wx.openSetting({
                    success: function (data) {
                      console.log(data);
                      if (data.authSetting["scope.userLocation"] == true) {
                        wx.showToast({
                          title: '授权成功',
                          icon: 'success',
                          duration: 5000
                        })
                        //再次授权，调用getLocationt的API
                        village_LBS(that);
                        this.onLoad();
                      } else {
                        wx.showToast({
                          title: '授权失败',
                          icon: 'success',
                          duration: 5000
                        })
                      }
                    }
                  })
                }
              }
            })
          } else if (res.authSetting['scope.userLocation'] == undefined) {//初始化进入
            village_LBS(that);
          }
        }
      })
    }
    /**
     * 调起扫码
     */
    // scanCode:function(){
    //   wx.scanCode({
    //     success: (res) => {
    //       console.log(res)
    //       wx.navigateTo({
    //         url: '../'+res.result,
    //       })
    //     }
    //   })
    // }
})