// const appData = getApp().globalData;
// function identityFilter(pageObj) {
//   if (pageObj.onShow) {
//     let _onShow = pageObj.onShow;
//     pageObj.onShow = function () {
//       //改动点
//       appData.promise.then(() => {
//         //跳转到登录页
//         wx.redirectTo({
//           url: "/pages/common/login/login"
//         });
//       }, () => {
//         //获取页面实例，防止this劫持
//         let currentInstance = getPageInstance();
//         _onShow.call(currentInstance);
//       });
//     }
//   }
//   return pageObj;
// }