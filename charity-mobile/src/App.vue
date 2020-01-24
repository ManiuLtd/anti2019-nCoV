<template>
  <div id="app">
    <div
      style="background-image: url(&#39;https://s2.ax1x.com/2020/01/24/1ZkT7F.md.jpg&#39;); padding-top:10px;"
    >
      <div class="hero-inner">
        <h2 style="color: #fff">物资需求将在这里整合</h2>
        <p style="color: #fff">现在武汉的一线医院物资短缺，急需：N95 口罩、护目镜、防护服等。请大家有医用防护物资来源渠道请联系以下电话</p>
        <van-button
          style="margin-bottom: 12px; background-color: #000; boder: 1px solid #000;cursor: pointer"
        >
          <a href="https://3g.dxy.cn/newh5/view/pneumonia" style="color: #fff">返回疫情动态</a>
        </van-button>
      </div>
    </div>
    <!-- <van-list v-model="loading" finished = "finished" finished-text="没有更多了" @load="onLoad"> -->
    <div v-for="content in list" :key="content.name">
      <!-- 医院名称 -->
      <van-cell
        style="font-size: 18px; background-color: rgb(183, 136, 182)"
        :title="content.name"
      />
      <!-- 物资列表 -->
      <van-cell title="物资名称" value="物资数量"></van-cell>
      <div
        v-for="item in content.items"
        :key="item.name"
        style="border: 1px solid #000010; margin: 20px; font-size: 10px"
      >
        <van-cell :title="item.name" :value="item.amount" />
      </div>

      <!-- 点击加载详情 -->
      <template v-if="content.showInfo">
        <van-cell title="医院地址" :value="content.address" />
        <van-cell title="联系人" :value="content.contat" />
        <van-cell title="联系电话" :value="content.mobile" />
        <div>
          <van-button>提交捐赠信息</van-button>
        </div>
        <div style="boder: 1px solid #000" @click="content.showInfo=false">
          <div>收起</div>
          <div>
            <van-icon name="arrow-up" />
          </div>
        </div>
      </template>
      <template v-else>
        <div style="boder: 1px solid #000" @click="content.showInfo=true">
          <div>点击加载详情</div>
          <div>
            <van-icon name="arrow-down" />
          </div>
        </div>
      </template>
    </div>
    <!-- </van-list> -->
  </div>
</template>

<script>
import Vue from "vue";
import { Col, Row, Cell, Button, Icon } from "vant";

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
      list: [
        {
          no: 1,
          showInfo: false,
          name: "武汉大学人民医院",
          address: "湖北省武汉市武昌区解放路238号",
          contat: "刘老师",
          mobile: 13146228147,
          items: [
            {
              name: "N95口罩",
              amount: 10
            },
            {
              name: "外科口罩",
              amount: 100
            },
            {
              name: "一次性口罩",
              amount: 10202
            }
          ]
        },
        {
          no: 1,
          showInfo: false,
          name: "武汉协和医院",
          address: "湖北省武汉市武昌区解放路238号",
          contat: "刘老师",
          mobile: 13146228147,
          items: [
            {
              name: "N95口罩",
              amount: 10
            },
            {
              name: "外科口罩",
              amount: 100
            },
            {
              name: "一次性口罩",
              amount: 10202
            }
          ]
        },
        {
          no: 1,
          showInfo: false,
          name: "湖北省第二医院",
          address: "湖北省武汉市武昌区解放路238号",
          contat: "刘老师",
          mobile: 13146228147,
          items: [
            {
              name: "N95口罩",
              amount: 10
            },
            {
              name: "外科口罩",
              amount: 100
            },
            {
              name: "一次性口罩",
              amount: 10202
            }
          ]
        },
        {
          no: 1,
          showInfo: false,
          name: "武汉大学任命医院",
          address: "湖北省武汉市武昌区解放路238号",
          contat: "刘老师",
          mobile: 13146228147,
          items: [
            {
              name: "N95口罩",
              amount: 10
            },
            {
              name: "外科口罩",
              amount: 100
            },
            {
              name: "一次性口罩",
              amount: 10202
            }
          ]
        },
        {
          no: 1,
          showInfo: false,
          name: "武汉大学任命医院",
          address: "湖北省武汉市武昌区解放路238号",
          contat: "刘老师",
          mobile: 13146228147,
          items: [
            {
              name: "N95口罩",
              amount: 10
            },
            {
              name: "外科口罩",
              amount: 100
            },
            {
              name: "一次性口罩",
              amount: 10202
            }
          ]
        }
      ],
      loading: false,
      finished: true
    };
  },
  methods: {
    onLoad() {
      // 异步更新数据
      // setTimeout(() => {
      //   // for (let i = 0; i < 10; i++) {
      //   //   this.list.push(this.list.length + 1);
      //   // }
      //   // 加载状态结束
      //   this.loading = false;
      //   // 数据全部加载完成
      //   if (this.list.length >= 40) {
      //     this.finished = true;
      //   }
      // }, 500);
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
</style>
