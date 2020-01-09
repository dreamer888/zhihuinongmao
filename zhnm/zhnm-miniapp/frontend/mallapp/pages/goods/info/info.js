var util = require('../../../utils/util.js');
//var showTip = require('/static/js/showTip.js');
var app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        httphost: app.data.httphost,
        httpserver: app.data.httpserver,
        tabs: ["商品", "详情", "评价"],
        actionSheetHidden: true,
        nullTip: true,
        goods: {},
        goods_pic: [],
        couponlist: {},
        freight: {},
        th_td_list: {},
        activeIndex: 0,
        sliderOffset: 0,
        sliderLeft: 0,
        firstIndex: -1,
        attr_key_value_list: [],
        goods_count: 1,
        currentPage: 1,
        scrollTop: 0,
        toView: 'page1',
    },
    /*
    头部
    */
    upper: function (e) {
    },
    lower: function (e) {
    },
    scroll: function (e) {
        var that = this;
        that.getPage1Height();
        that.getPage2Height();
        let scrollTop = e.detail.scrollTop;
        if (scrollTop < that.page1Height) {
            that.data.activeIndex = 0;
        } else if (scrollTop >= that.page1Height && scrollTop < that.page1Height + that.page2Height - 30) {
            that.data.activeIndex = 1;
        } else if (scrollTop >= (that.page1Height + that.page2Height - 30)) {
            that.data.activeIndex = 2;
        }
        this.setData({
            activeIndex: that.data.activeIndex
        })
    },
    tabClick: function (e) {
        var that = this;
        if (e.currentTarget.id == 0) {
            that.toView = 'page1';
        } else if (e.currentTarget.id == 1) {
            that.toView = 'page2';
        } else if (e.currentTarget.id == 2) {
            that.toView = 'page3';
        }
        console.log(that.toView);
        that.setData({
            toView: that.toView,
            sliderOffset: e.currentTarget.offsetLeft,
            activeIndex: e.currentTarget.id
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;
        var goods_id = options.goods_id;
        var data = {
            goods_id: goods_id,
            marketId: wx.getStorageSync('market_id')
        }
        util.request(app.data.httpserver + 'goods/info', data = data).then(function (request) {
            var screenHeight = 0;
            wx.getSystemInfo({
                success: function (res) {
                    screenHeight = res.windowHeight
                }
            })
            var goods = request.goods;
            var goods_pic_arry = goods.goods_pic.split(',');
            var goods_detail = request.goods.goods_detail.replace(/src="/g, 'src="').replace(/<img/g, '<img mode="widthFix" style="width:100%"');
            console.log("goods_detail", goods_detail)
            var attr_list = request.attr_list;
            var comment_list = request.commentlist;
            var commentlist = new Array();
            for (var i = 0; i < comment_list.length; i++) {

                var username = comment_list[i].username;
                var addtime = comment_list[i].addtime;
                var comment_title = comment_list[i].comment_title;
                var comment_content = comment_list[i].comment_content;
                var comment_pic = comment_list[i].comment_pic;
                var head_img = comment_list[i].head_img;

                if (comment_pic != '') {

                    var comment_pic_arry = [];
                    for (var j = 0; j < comment_pic.split(',').length; j++) {
                        comment_pic_arry.push(comment_pic.split(',')[j].replace('../', that.data.httphost + '../'));
                    }
                }
                commentlist.push({
                    "username": username,
                    "addtime": addtime,
                    "comment_title": comment_title,
                    "comment_content": comment_content,
                    "comment_pic_arry": comment_pic_arry,
                    "head_img": head_img
                });
            }
            that.setData({
                goods: goods,
                goods_detail: goods_detail,
                goods_price: goods.attr_min_price .toFixed(2),
                goods_num: goods.goods_num,
                goods_pic: goods_pic_arry,
                pic: goods_pic_arry[0],
                attribute_detail_id: request.attribute_detail_id,
                commentlist: commentlist,
                page: request.page,
                totalPage: request.page.totalPage,
                currentPage: request.page.currentPage,
                collection: request.collection,
                couponlist: request.couponlist,
                freight: request.freight,
                attr_list: attr_list,
                cart_count: request.cart_count,
                includeGroup: attr_list,
                custom: request.custom,
                screenHeight: screenHeight
            })
            if (attr_list != null) {
                that.distachattr_value(attr_list);
                // 只有一个属性组合的时候默认选中
                if (attr_list.length == 1) {
                    for (var i = 0; i < attr_list[0].attr_key_value_list.length; i++) {
                        this.data.attr_key_value_list[i].selected_value = attr_list[0].attr_key_value_list[i].attr_value;
                    }
                    this.setData({
                        attr_key_value_list: this.data.attr_key_value_list
                    });
                }
            }
        })
    },
    /**
     * 优惠券
     */
    coupon() {
        wx.navigateTo({
            url: '../../coupon/list/list'
        })
    },
    /**
     * 购物车
     */
    cart_list() {
        wx.redirectTo({
            url: '../../cart/list'
        })
    },


    imageLoad: function (e) {
        var imageSize = util.imageUtil(e)
        this.setData({
            imagewidth: imageSize.imageWidth,
            imageheight: imageSize.imageHeight
        })
    },

    actionSheetTap: function (e) {
        var submit_type = e.currentTarget.dataset.submit_type;
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden,
            submit_type: submit_type
        })
    },
    actionSheetbindchange: function () {
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden
        })
    },
    /* 获取数据 */
    distachattr_value: function (attr_list) {
        /**
         将后台返回的数据组合成类似
         {
           attr_key:'型号',
           attr_key_value_list:['1','2','3']
         }
         */
            // 把数据对象的数据（视图使用），写到局部内
        var attr_key_value_list = this.data.attr_key_value_list;
        // 遍历获取的数据
        for (var i = 0; i < attr_list.length; i++) {
            for (var j = 0; j < attr_list[i].attr_key_value_list.length; j++) {
                var attrIndex = this.getAttrIndex(attr_list[i].attr_key_value_list[j].attr_key, attr_key_value_list);
                // console.log('属性索引', attrIndex);
                // 如果还没有属性索引为-1，此时新增属性并设置属性值数组的第一个值；索引大于等于0，表示已存在的属性名的位置
                if (attrIndex >= 0) {
                    // 如果属性值数组中没有该值，push新值；否则不处理
                    if (!this.isValueExist(attr_list[i].attr_key_value_list[j].attr_value, attr_key_value_list[attrIndex].attr_values)) {
                        attr_key_value_list[attrIndex].attr_values.push(attr_list[i].attr_key_value_list[j].attr_value);
                    }
                } else {
                    attr_key_value_list.push({
                        attr_key: attr_list[i].attr_key_value_list[j].attr_key,
                        attr_values: [attr_list[i].attr_key_value_list[j].attr_value]
                    });
                }
            }
        }
        // console.log('result', attr_key_value_list)
        for (var i = 0; i < attr_key_value_list.length; i++) {
            for (var j = 0; j < attr_key_value_list[i].attr_values.length; j++) {
                if (attr_key_value_list[i].attr_value_status) {
                    attr_key_value_list[i].attr_value_status[j] = true;
                } else {
                    attr_key_value_list[i].attr_value_status = [];
                    attr_key_value_list[i].attr_value_status[j] = true;
                }
            }
        }
        this.setData({
            attr_key_value_list: attr_key_value_list
        });
    },
    getAttrIndex: function (attrName, attr_key_value_list) {
        // 判断数组中的attr_key是否有该属性值
        for (var i = 0; i < attr_key_value_list.length; i++) {
            if (attrName == attr_key_value_list[i].attr_key) {
                break;
            }
        }
        // console.log("..." + i < attr_key_value_list.length ? i : -1);
        return i < attr_key_value_list.length ? i : -1;
    },
    isValueExist: function (value, valueArr) {
        // 判断是否已有属性值
        for (var i = 0; i < valueArr.length; i++) {
            if (valueArr[i] == value) {
                break;
            }
        }
        return i < valueArr.length;
    },
    /* 选择属性值事件 */
    selectattr_value: function (e) {
        /*
        点选属性值，联动判断其他属性值是否可选
        */
        var attr_key_value_list = this.data.attr_key_value_list;
        var index = e.currentTarget.dataset.index;//属性索引
        var key = e.currentTarget.dataset.key;
        var value = e.currentTarget.dataset.value;
        if (e.currentTarget.dataset.status || index == this.data.firstIndex) {
            if (e.currentTarget.dataset.selected_value == e.currentTarget.dataset.value) {
                // 取消选中
                this.disSelectValue(attr_key_value_list, index, key, value);
            } else {
                // 选中
                this.selectValue(attr_key_value_list, index, key, value);
            }

        }
    },
    /* 选中 */
    selectValue: function (attr_key_value_list, index, key, value, unselectStatus) {
        // console.log('firstIndex', this.data.firstIndex);
        var includeGroup = [];
        if (index == this.data.firstIndex && !unselectStatus) { // 如果是第一个选中的属性值，则该属性所有值可选
            var attr_list = this.data.attr_list;
            // 其他选中的属性值全都置空
            // console.log('其他选中的属性值全都置空', index, this.data.firstIndex, !unselectStatus);
            for (var i = 0; i < attr_key_value_list.length; i++) {
                for (var j = 0; j < attr_key_value_list[i].attr_values.length; j++) {
                    attr_key_value_list[i].selected_value = '';
                }
            }
        } else {
            var attr_list = this.data.includeGroup;
        }

        // console.log('选中', attr_list, index, key, value);
        for (var i = 0; i < attr_list.length; i++) {
            for (var j = 0; j < attr_list[i].attr_key_value_list.length; j++) {
                if (attr_list[i].attr_key_value_list[j].attr_key == key && attr_list[i].attr_key_value_list[j].attr_value == value) {
                    includeGroup.push(attr_list[i]);
                }
            }
        }
        attr_key_value_list[index].selected_value = value;

        // 判断属性是否可选
        for (var i = 0; i < attr_key_value_list.length; i++) {
            for (var j = 0; j < attr_key_value_list[i].attr_values.length; j++) {
                attr_key_value_list[i].attr_value_status[j] = false;
            }
        }
        for (var k = 0; k < attr_key_value_list.length; k++) {
            for (var i = 0; i < includeGroup.length; i++) {
                for (var j = 0; j < includeGroup[i].attr_key_value_list.length; j++) {
                    if (attr_key_value_list[k].attr_key == includeGroup[i].attr_key_value_list[j].attr_key) {
                        for (var m = 0; m < attr_key_value_list[k].attr_values.length; m++) {
                            if (attr_key_value_list[k].attr_values[m] == includeGroup[i].attr_key_value_list[j].attr_value) {
                                attr_key_value_list[k].attr_value_status[m] = true;
                            }
                        }
                    }
                }
            }
        }
        this.setData({
            attr_key_value_list: attr_key_value_list,
            includeGroup: includeGroup
        });

        var count = 0;
        for (var i = 0; i < attr_key_value_list.length; i++) {
            for (var j = 0; j < attr_key_value_list[i].attr_values.length; j++) {
                if (attr_key_value_list[i].selected_value) {
                    count++;
                    break;
                }
            }
        }
        if (count < 2) {// 第一次选中，同属性的值都可选
            this.setData({
                firstIndex: index
            });
        } else {
            this.setData({
                firstIndex: -1
            });
        }
        if (count == attr_key_value_list.length) {//如果选择数等于数组属性数，则选择完毕
            // var value=[];
            var reday_attr_arry = [];
            // var key_value = {};
            for (var i = 0; i < attr_key_value_list.length; i++) {
                // console.log(attr_key_value_list[i]);
                if (!this.data.attr_key_value_list[i].selected_value) {
                    break;
                }
                reday_attr_arry.push(this.data.attr_key_value_list[i].selected_value);
                // console.log(value);
                // attr_key_value_list[i].attr_key_value_list =
            }
            var goods_detail = [];
            for (var i = 0; i < attr_list.length; i++) {
                if (reday_attr_arry.toString() == attr_list[i].goods_attr.toString()) {
                    goods_detail = attr_list[i];
                    this.setData({
                       goods_price: goods_detail.attribute_detail_avg_price.toFixed(2),
                        goods_num: goods_detail.attribute_detail_num,
                        attribute_detail_id: goods_detail.attribute_detail_id,
                        goods_count: 1
                    })
                }
            }
        } else {
            var goods = this.data.goods;
            this.setData({
                goods_price: goods.attr_min_price.toFixed(2),
                goods_num: goods.goods_num,
                attribute_detail_id: 0,
                goods_count: 1
            })
        }
    },
    /* 取消选中 */
    disSelectValue: function (attr_key_value_list, index, key, value) {
        var attr_list = this.data.attr_list;
        attr_key_value_list[index].selected_value = '';

        // 判断属性是否可选
        for (var i = 0; i < attr_key_value_list.length; i++) {
            for (var j = 0; j < attr_key_value_list[i].attr_values.length; j++) {
                attr_key_value_list[i].attr_value_status[j] = true;
            }
        }
        this.setData({
            includeGroup: attr_list,
            attr_key_value_list: attr_key_value_list
        });

        for (var i = 0; i < attr_key_value_list.length; i++) {
            if (attr_key_value_list[i].selected_value) {
                this.selectValue(attr_key_value_list, i, attr_key_value_list[i].attr_key, attr_key_value_list[i].selected_value, true);
            }
        }
    },
    // 增加数量
    addCount(e) {
        var goods_count = this.data.goods_count;
        goods_count = parseInt(goods_count) + 1;
        this.setData({
            goods_count: goods_count
        });
    },
    // 减少数量
    minusCount(e) {
        var goods_count = this.data.goods_count;
        if (goods_count <= 1) {
            return false;
        }
        goods_count = goods_count - 1;
        this.setData({
            goods_count: goods_count
        });
    },
    add_cart() {
        var that = this;
        var goods_id = that.data.goods.goods_id;
        var goods_count = that.data.goods_count;
        var attribute_detail_id = that.data.attribute_detail_id;
        var sys_num = that.data.goods_num;
        if (attribute_detail_id == 0) {
            that.showTip('请选择商品规格属性');
            return;
        }
        if (goods_count > sys_num) {
            that.showTip('库存不足');
            return;
        }
        var data = {
            goods_id: goods_id,
            goods_count: goods_count,
            attribute_detail_id: attribute_detail_id,
            marketId: wx.getStorageSync("market_id")
        }
        util.request(app.data.httpserver + 'cart/add', data = data).then(function (request) {
            that.setData({
                actionSheetHidden: true,
                cart_count: request.cart_count
            });
            that.showTip(request.message);
        })
    },
    /**
     * 预支付界面
     */
    to_order() {
        var that = this;
        var goods_id = that.data.goods.goods_id;
        var goods_count = that.data.goods_count;
        var attribute_detail_id = that.data.attribute_detail_id;
        var sys_num = that.data.goods_num;
        if (attribute_detail_id == 0) {
            that.showTip('请选择商品规格属性');
            return;
        }
        if (goods_count > sys_num) {
            that.showTip('库存不足');
            return;
        }
        wx.navigateTo({
            url: '../../order/payment/info?goods_id=' + goods_id + '&goods_count=' + goods_count + '&attribute_detail_id=' + attribute_detail_id + '&address_id=',
        })
    },
    collection() {
        var that = this;
        var goods_id = that.data.goods.goods_id;
        var data = {goods_id: goods_id}
        util.request(app.data.httpserver + 'collection/add', data = data).then(function (request) {
            that.setData({
                collection: 1,
            });
            wx.showToast({
                title: request.message,
                icon: 'success',
                duration: 2000
            })
        })
    },
    collection_ed() {
        var that = this;
        var goods_id = that.data.goods.goods_id;
        var data = { goods_id: goods_id }
        util.request(app.data.httpserver + 'collection/delete', data = data).then(function (request) {
            that.setData({
                collection: null,
            });
            wx.showToast({
                title: request.message,
                icon: 'success',
                duration: 2000
            })
        })
    },
    comment_list() {
        var that = this
        wx.showNavigationBarLoading();
        var goods_id = that.data.goods.goods_id;
        var currentPage = that.data.currentPage;
        // wx.request({
        //   url: that.data.httpserver + 'app/comment/list',
        //   type: 'post',
        //   data: { goods_id: goods_id, currentPage: currentPage},
        //   header: wx.getStorageSync('header'),
        //   success: function (request) {
        var data = {goods_id: goods_id, currentPage: currentPage}
        util.request(app.data.httpserver + 'app/comment/list', data = data).then(function (request) {
            var comment_list = request.list;
            var commentlist = that.data.commentlist;
            for (var i = 0; i < comment_list.length; i++) {

                var username = comment_list[i].username;
                var addtime = comment_list[i].addtime;
                var comment_title = comment_list[i].comment_title;
                var comment_content = comment_list[i].comment_content;
                var comment_pic = comment_list[i].comment_pic;
                var head_img = comment_list[i].head_img;
                // if (head_img!=''){
                //   if (head_img.indexOf('http') == -1) {
                //     head_img = that.data.httphost + head_img;
                //   }
                // }

                if (comment_pic != '') {
                    var comment_pic_arry = [];
                    for (var j = 0; j < comment_pic.split(',').length; j++) {
                        comment_pic_arry.push(comment_pic.split(',')[j].replace('../', that.data.httphost + '../'));
                    }
                }
                commentlist.push({
                    "username": username,
                    "addtime": addtime,
                    "comment_title": comment_title,
                    "comment_content": comment_content,
                    "comment_pic_arry": comment_pic_arry,
                    "head_img": head_img
                });
            }
            that.setData({
                commentlist: commentlist
            })
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
        wx.stopPullDownRefresh();
    },

    getPage1Height: function () {
        var that = this;
        let query = wx.createSelectorQuery().in(that)
        query.select('#page1').boundingClientRect((res) => {
            that.page1Height = res.height;
        }).exec()
    },
    getPage2Height: function () {
        var that = this;
        let query = wx.createSelectorQuery().in(that)
        query.select('#page2').boundingClientRect((res) => {
            that.page2Height = res.height;
            that.page2Top = res.top;
        }).exec()
    },
    getPage3Height: function () {
        var that = this;
        let query = wx.createSelectorQuery().in(that)
        query.select('#page3').boundingClientRect((res) => {
            console.log('res: ', res)
            that.page3Top = res.top;
        }).exec()
    },
    /**
     * 页面上拉触底事件的处理函数
     */
    downLoad: function () {
        console.log("downLoad--------------")
        var totalPage = this.data.totalPage;
        var currentPage = this.data.currentPage;
        if (totalPage > currentPage) {
            currentPage++;
            this.setData({
                currentPage: currentPage,
            })
            this.comment_list();
        }
    },
    /**
     * 提示
     */
    showTip(tipTxt) {
        var that = this
        that.setData({
            nullTip: false, //弹窗显示
            tipTxt: tipTxt
        })
        setTimeout(function () {
            that.setData({
                nullTip: true,
                tipTxt: tipTxt
            }) //1.5秒之后弹窗隐藏
        }, 1500)
    },
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})