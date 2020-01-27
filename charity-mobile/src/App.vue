<template>
  <div id="app">
    <div
      style="background-image: url(&#39;https://s2.ax1x.com/2020/01/24/1ZkT7F.md.jpg&#39;); padding-top:10px;padding-bottom: 30px"
    >
      <div class="hero-inner">
        <h2 style="color: #fff">物资需求将在这里整合</h2>
        <p style="color: #fff">现在湖北省的一线医院物资短缺，急需：N95 口罩、护目镜、防护服等。请大家有医用防护物资来源渠道请联系以下电话</p>
        <a href="https://3g.dxy.cn/newh5/view/pneumonia" class="button" style="color: #fff">返回疫情动态</a>
      </div>
    </div>
    <van-tabs v-model="active">
      <van-tab v-for="(city, index) in cityList" :title="city.cityName" :key="index"  :name="city.id">
        <div style="height: 10px"></div>
        <div v-if="list.length === 0" class="no-data">
          志愿者努力收集数据中...
        </div>
        <!-- <van-list
        v-else
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"> -->
        <div v-for="(content, i) in list" :key="content.name + i">
          <van-cell
            style="font-size: 18px; background-color: rgb(183, 136, 182)"
            :title="content.name"
          />
          <van-cell title="物资名称" value="物资数量"></van-cell>
            <div
              v-for="(item, i) in content.items"
              :key="item.name + i"
              style="border: 1px solid #000010; margin: 20px; font-size: 10px"
            >
              <van-cell :title="item.name" :value="item.amount" />
            </div>
            <van-cell title="医院地址" :value="content.address" />
            <van-cell title="联系人" :value="content.contact" />
            <van-cell title="联系电话" :value="content.mobile" is-link :url="'tel:'+content.mobile"/>
            <!-- <a href="tel:13764567708">移动WEB页面JS一键拨打号码咨询功能</a> -->
            <div class="hidden">
              <van-button>提交捐赠信息</van-button>
            </div>
        </div>
       <!-- </van-list> -->
      </van-tab>
    </van-tabs>
  </div>
</template>

<script>
import Vue from "vue";
import { Col, Row, Cell, Button, Icon, List, Tab, Tabs  } from "vant";

Vue.use(List);
Vue.use(Col);
Vue.use(Row);
Vue.use(Cell);
Vue.use(Button);
Vue.use(Icon);
Vue.use(Tab);
Vue.use(Tabs);

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
      finished: false,
      cityList: [],
      active: '420100'
    }
  },
  created () {
    this.init()
  },
  watch: {
    active: function (val) {
      this.getdonationList(val)
    }
  },
  methods: {
    init() {
      this.getCityList()
      this.getdonationList(this.active)
    },
    getCityList () {
       this.$http({
        method: 'get',
        url: '/cityList',
      }).then(({data}) => {
        this.cityList = data
      })
    },
    getdonationList(id) {
      this.$http({
        method: 'get',
        url: '/donationList',
        params: { id: id }
      }).then(({data}) => {
        this.list = data
      })
    },
    onLoad() {
      // 异步更新数据
      // setTimeout(() => {
      //   this.list.push(...this.storeList[this.current++])
      //   // 加载状态结束
      //   this.loading = false;
      //   // 数据全部加载完成
      //   if (this.list.length >= this.rawData.length) {
      //     this.finished = true;
      //   }
      // }, 1000);
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
}
.hidden {
  display: none;
}
.button {
  background-color: #000; 
  cursor: pointer;
  border: 1px solid #fff;
  padding: 10px;
  font-size: 14px;
}
.no-data {
  margin-top: 20px;
  font-size: 14px;
  color: #999;
}
</style>
