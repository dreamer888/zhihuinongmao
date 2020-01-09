App({
  data: {
    nullTip:true
  },
  showTip(tipTxt) {
    this.setData({
      nullTip: false, //弹窗显示
    })
    setTimeout(function () {
      this.data.nullTip = true //1.5秒之后弹窗隐藏
    }, 1500)
  }
})