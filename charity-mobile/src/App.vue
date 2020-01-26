<template>
  <div id="app">
    <div
      style="background-image: url(&#39;https://s2.ax1x.com/2020/01/24/1ZkT7F.md.jpg&#39;); padding-top:10px;padding-bottom: 30px"
    >
      <div class="hero-inner">
        <h2 style="color: #fff">物资需求将在这里整合</h2>
        <p style="color: #fff">现在武汉的一线医院物资短缺，急需：N95 口罩、护目镜、防护服等。请大家有医用防护物资来源渠道请联系以下电话</p>
        <a href="https://3g.dxy.cn/newh5/view/pneumonia" class="button" style="color: #fff">返回疫情动态</a>
      </div>
    </div>
    <van-list
      v-model="loading"
      :finished="finished"
      finished-text="没有更多了"
      @load="onLoad"
    >
    <div v-for="content in list" :key="content.name">
      <van-cell
        style="font-size: 18px; background-color: rgb(183, 136, 182)"
        :title="content.name"
      />
      <van-cell title="物资名称" value="物资数量"></van-cell>
        <div
          v-for="item in content.items"
          :key="item.name"
          style="border: 1px solid #000010; margin: 20px; font-size: 10px"
        >
          <van-cell :title="item.name" :value="item.amount" />
        </div>
        <van-cell title="医院地址" :value="content.address" />
        <van-cell title="联系人" :value="content.contat" />
        <van-cell title="联系电话" :value="content.mobile" />
        <div class="hidden">
          <van-button>提交捐赠信息</van-button>
        </div>
    </div>
    </van-list>
  </div>
</template>

<script>
import Vue from "vue";
import { Col, Row, Cell, Button, Icon, List } from "vant";

// Vue.use(PullRefresh).use(List);
Vue.use(List);
Vue.use(Col);
Vue.use(Row);
Vue.use(Cell);
Vue.use(Button);
Vue.use(Icon);

export default {
  name: "app",
  components: {},
  data() {
    return {
      list: [],
      storeList: [],
      rawData: [],
      current: 1,
      loading: false,
      finished: false
    }
  },
   created () {
    const vm = this
    var xhr = new XMLHttpRequest()
    xhr.open("GET", 'http://39.105.77.161:8081/donationList', true)
    xhr.onload = function () {
      if (this.status == 200) {
        let rawData = JSON.parse(this.responseText)
        let result = []
        for(let i=0, len = rawData.length; i < len; i += 4){
          result.push(rawData.slice(i, i + 4))
        }
        vm.rawData = rawData
        vm.storeList = [...result]
        // 先放4个
        vm.list = result[0]
      }
    }
    xhr.send();
  },
  methods: {
    onLoad() {
      // 异步更新数据
      setTimeout(() => {
        this.list.push(...this.storeList[this.current++])
        // 加载状态结束
        this.loading = false;
        // 数据全部加载完成
        if (this.list.length >= this.rawData.length) {
          this.finished = true;
        }
      }, 1000);
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
.hidden {
  display: none;
}
.button {
  /* margin-bottom: 12px;  */
  background-color: #000; 
  cursor: pointer;
  border: 1px solid #fff;
  padding: 10px;
  font-size: 14px;
}
</style>
