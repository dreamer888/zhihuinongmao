//var url = require('utils/url.js');

function imageUtil(e) {
    var imageSize = {};
    var originalWidth = e.detail.width;//图片原始宽
    var originalHeight = e.detail.height;//图片原始高
    var originalScale = originalHeight / originalWidth;//图片高宽比
    //获取屏幕宽高
    wx.getSystemInfo({
        success: function (res) {
            var windowWidth = res.windowWidth;
            var windowHeight = res.windowHeight;
            var windowscale = windowHeight / windowWidth;//屏幕高宽比
            if (originalScale < windowscale) {//图片高宽比小于屏幕高宽比
                //图片缩放后的宽为屏幕宽
                imageSize.imageWidth = windowWidth;
                imageSize.imageHeight = (windowWidth * originalHeight) / originalWidth;
            } else {//图片高宽比大于屏幕高宽比
                //图片缩放后的高为屏幕高
                imageSize.imageHeight = windowHeight;
                imageSize.imageWidth = (windowHeight * originalWidth) / originalHeight;
            }

        }
    })
    return imageSize;
}

/**
 * 封封微信的的request
 */
function request(url, data = {}, method = "GET") {
    var session_id = wx.getStorageSync('session_id');
    wx.showNavigationBarLoading();
    var header = wx.getStorageSync('header');
    if (session_id == '') {
        wx.redirectTo({
            url: '/pages/welcome/index?url=' + get_url()
        })
    }
    return new Promise(function (resolve, reject) {
        wx.request({
            url: url,
            data: data,
            method: method,
            header: wx.getStorageSync('header'),
            success: function (res) {
                // console.log("res-->" + JSON.stringify(res));
                // console.log("res-->" + res.data.result);
                if (typeof (res.data.result != 'undefined')) {
                    if (res.data.result == 1005) {
                        //需要登录后才可以操作
                        wx.redirectTo({
                            url: '/pages/welcome/index?url=' + get_url()
                        })
                    } else {
                        wx.hideNavigationBarLoading() //完成停止加载
                        resolve(res.data);
                    }
                }
            },
            fail: function (err) {
                reject(err)
                console.log("failed")
            }
        })
    });
}

/**
 * 检查微信会话是否过期
 */
function checkSession() {
    return new Promise(function (resolve, reject) {
        wx.checkSession({
            success: function () {
                resolve(true);
            },
            fail: function () {
                reject(false);
            }
        })
    });
}

/**
 * 调用微信登录
 */
function login() {
    return new Promise(function (resolve, reject) {
        console.log('执行util.js->login()');
        wx.login({
            success: function (res) {
                console.log('执行util.js->res=' + res.code);
                if (res.code) {
                    //登录远程服务器
                    resolve(res);
                } else {
                    reject(res);
                }
            },
            fail: function (err) {
                reject(err);
            }
        });
    });
}

function getUserInfo() {
    return new Promise(function (resolve, reject) {
        wx.getUserInfo({
            withCredentials: true,
            success: function (res) {
                console.log(res)
                resolve(res);
            },
            fail: function (err) {
                reject(err);
            }
        })
    });
}

function redirect(url) {

    //判断页面是否需要登录
    if (false) {
        wx.redirectTo({
            url: '/pages/auth/login/login'
        });
        return false;
    } else {
        wx.redirectTo({
            url: url
        });
    }
}

function showErrorToast(msg) {
    wx.showToast({
        title: msg,
        image: '/static/images/icon_error.png'
    })
}

/**
 *
 */
function get_url() {
    var pages = getCurrentPages()    //获取加载的页面
    console.log('pages-' + pages);
    var currentPage = pages[pages.length - 1]    //获取当前页面的对象
    var url = currentPage.route    //当前页面url
    var options = currentPage.options    //如果要获取url中所带的参数可以查看options
    //拼接url的参数
    var urlWithArgs = url + '?'
    for (var key in options) {
        var value = options[key]
        urlWithArgs += key + '=' + value + '&'
    }
    urlWithArgs = urlWithArgs.substring(0, urlWithArgs.length - 1)
    console.log('url-' + urlWithArgs);
    return urlWithArgs;
}
module.exports = {
    // formatTime,
    request,
    redirect,
    showErrorToast,
    checkSession,
    login,
    getUserInfo,
    imageUtil: imageUtil
}
 