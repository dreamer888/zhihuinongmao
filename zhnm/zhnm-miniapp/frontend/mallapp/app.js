var util = require('utils/util.js');
App({
  data:{
    // httphost: "https://wx.qanpai.com/",
    // httpserver: "https://wx.qanpai.com/mallapp/",
    // httphost: "http://192.168.1.108:9092/",
    // httpserver: "http://192.168.1.108:9092/",
        httphost: "https://www.wqwy2014.com/",
        httpserver: "https://www.wqwy2014.com/mallapp/",
        // httphost: "http://192.168.1.233/",
        // httpserver: "http://192.168.1.233/mallapp/",
  },
  onLaunch: function() {
    //获取用户的登录信息
    //  user.checkLogin().then(res => {
    //    console.log('app login')
    //    this.globalData.userInfo = wx.getStorageSync('userInfo');
    //    this.globalData.token = wx.getStorageSync('token');
    //  }).catch(() => {
    //    console.log('app no login')
    //    wx.redirectTo({
    //      url: 'pages/welcome/index'
    //    })
    //  });

    //  var session_id = wx.getStorageSync('session_id');
    //  var header = wx.getStorageSync('header');
    //  if (session_id == '') {
    //    wx.redirectTo({
    //      url: 'pages/welcome/index'
    //    })
    //  }else{
    //    wx.request({
    //      url: this.data.httpserver + 'check_session_out',
    //      header: header,
    //      success: function (request) {
    //        console.log('result-' + request.data.result);
    //        var result = request.data.result;
    //        if (result == 1005) {

    //          wx.redirectTo({
    //            url: '/pages/welcome/index'
    //          })
    //        }
    //      }
    //    })
    //  }

  },
    // 调用API从本地缓存中获取数据
  //   var pages = getCurrentPages()    //获取加载的页面
  //   console.log('pages-' + pages);
  //   var currentPage = pages[pages.length - 1]    //获取当前页面的对象
  //   var url = currentPage.route    //当前页面url
  //   var options = currentPage.options    //如果要获取url中所带的参数可以查看options

  //   //拼接url的参数
  //   var urlWithArgs = url + '?'
  //   for (var key in options) {
  //     var value = options[key]
  //     urlWithArgs += key + '=' + value + '&'
  //   }
  //   urlWithArgs = urlWithArgs.substring(0, urlWithArgs.length - 1)
  //   console.log('url-' + urlWithArgs);

  //   console.log(wx.getStorageSync('session_id'));
  //   var session_id = wx.getStorageSync('session_id');
  //   var header = wx.getStorageSync('header');
  //   if (session_id == '') {
  //     wx.redirectTo({
  //       url: 'pages/welcome/index'
  //     })
  //   }else{
  //     wx.request({
  //       url: this.data.httpserver + 'check_session_out',
  //       header: header,
  //       success: function (request) {
  //         console.log('result-' + request.data.result);
  //         var result = request.data.result;
  //         if (result == 1005) {
            
  //           wx.redirectTo({
  //             url: '/pages/welcome/index'
  //           })
  //         }
  //       }
  //     })
  //   } 
  // },
  onShow(){
    this.onLaunch();
  },
  getUserInfo: function() {
    
  },

  globalData: {
    userInfo: wx.getStorageSync('userInfo'),
    header: wx.getStorageSync('header'),
    session_id:wx.getStorageSync('session_id'),
  },
  
})
